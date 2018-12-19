package com.aghnala.snapsnap.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aghnala.snapsnap.R;

/**
 * Created by simco on 1/3/2018.
 */

public class ChatFragment extends Fragment {


//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//
//    String uid;
//
    public static ChatFragment newInstance(){
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat , container, false);

//        uid = FirebaseAuth.getInstance().getUid();
//
//        mRecyclerView = view.findViewById(R.id.recyclerView);
//        mRecyclerView.setNestedScrollingEnabled(false);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new StoryAdapter(getDataSet(), getContext());
//        mRecyclerView.setAdapter(mAdapter);
//
//        Button mRefresh = view.findViewById(R.id.refresh);
//        mRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clear();
//                listenForData();
//            }
//        });
       return view;
    }

//    private void clear() {
//        int size = this.results.size();
//        this.results.clear();
//        mAdapter.notifyItemRangeChanged(0, size);
//    }

//    private ArrayList<StoryObject> results = new ArrayList<>();
//    private ArrayList<StoryObject> getDataSet() {
//        listenForData();
//        return results;
//    }

//    private void listenForData(){
//        DatabaseReference receivedDb = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("received");
//        receivedDb.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                        getUserInfo(snapshot.getKey());
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

//    private void getUserInfo(String chatUid) {
//        DatabaseReference chatUserDb = FirebaseDatabase.getInstance().getReference().child("users").child(chatUid);
//        chatUserDb.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    String email = dataSnapshot.child("email").getValue().toString();
//                    String uid = dataSnapshot.getRef().getKey();
//
//                    StoryObject obj = new StoryObject(email, uid, "chat");
//                    if(!results.contains(obj)){
//                        results.add(obj);
//                        mAdapter.notifyDataSetChanged();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
}
