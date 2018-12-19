package com.aghnala.snapsnap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ShowCaptureActivity extends AppCompatActivity {

    String Uid;
    Bitmap rotateBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_capture);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        byte[] b = extras.getByteArray("capture");

        if (b!= null){
            ImageView image = findViewById(R.id.imageCaptured);

            Bitmap decodeBitmap = BitmapFactory.decodeByteArray(b, 0,b.length);

            rotateBitmap = rotate(decodeBitmap);

            image.setImageBitmap(rotateBitmap);
        }

        Uid = FirebaseAuth.getInstance().getUid();
        Button mStory = findViewById(R.id.stories);
        mStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToStories();
            }
        });
//        try {
//            bitmap = BitmapFactory.decodeStream(getApplication().openFileInput("imageToSend"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            finish();
//            return;
//        }
//
//        ImageView mImage = findViewById(R.id.imageCaptured);
//        mImage.setImageBitmap(bitmap);
//
//        Uid = FirebaseAuth.getInstance().getUid();
//
//        Button mSend = findViewById(R.id.send);
//        mSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), ChooseReceiverActivity.class);
//                startActivity(intent);
//                return;
//            }
//        });


    }

    private void saveToStories() {
        final DatabaseReference userStoryDb = FirebaseDatabase.getInstance().getReference().child("users").child(Uid).child("story");
        final String key = userStoryDb.push().getKey();

        StorageReference filePath = FirebaseStorage.getInstance().getReference().child("captures").child(key);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        rotateBitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        byte[] dataToUpload = baos.toByteArray();
        UploadTask uploadTask = filePath.putBytes(dataToUpload);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri imageUrl = taskSnapshot.getDownloadUrl();

                Long currenTimestamp = System.currentTimeMillis();
                Long endTimestamp = currenTimestamp + (24*60*60*1000);

                Map<String, Object> mapToUpload = new HashMap<>();
                mapToUpload.put("imageUrl", imageUrl.toString());
                mapToUpload.put("timestampBeg", currenTimestamp);
                mapToUpload.put("timestampEnd", endTimestamp);

                userStoryDb.child(key).setValue(mapToUpload);
                finish();
                return;

            }
        });

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                finish();
                return;
            }
        });
    }

    private Bitmap rotate(Bitmap decodeitmap) {
        int w = decodeitmap.getWidth();
        int h = decodeitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        return Bitmap.createBitmap(decodeitmap,0,0, w, h, matrix,true);
    }
}
