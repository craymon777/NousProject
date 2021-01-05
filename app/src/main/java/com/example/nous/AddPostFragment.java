package com.example.nous;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nous.Model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

public class AddPostFragment extends DialogFragment {

    EditText et_PostTitle, et_PostContent;
    Button btnSubmitPost;
    private String imageUrl;
    private String addPostUser;

    public AddPostFragment() {
        // Required empty public constructor
    }


    public static AddPostFragment newInstance(String param1, String param2) {
        AddPostFragment fragment = new AddPostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_PostTitle = view.findViewById(R.id.etPostTitle);
        et_PostContent = view.findViewById(R.id.etPostContent);
        btnSubmitPost = view.findViewById(R.id.btnSubmitPost);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                imageUrl = currentUser.getProfilePictureUrl();
                addPostUser = currentUser.getName();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //update post database here
        btnSubmitPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_PostTitle.getText().toString().isEmpty() && !et_PostContent.getText().toString().isEmpty())
                {

                    String addPostTitle = et_PostTitle.getText().toString();
                    String addPostContent = et_PostContent.getText().toString();

                    PostModel newPost = new PostModel(addPostTitle,addPostContent,addPostUser,imageUrl);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Post").push();

                    // get post unique ID and upadte post key
                    String key = myRef.getKey();
                    newPost.setPostKey(key);

                    // add post data to firebase database

                    myRef.setValue(newPost).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startActivity(new Intent(getActivity(), ForumActivity.class));
                        }
                    });
                }
            }
        });

    }
}