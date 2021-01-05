package com.example.nous;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.nous.Model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView name, email, phone, animalscore, historyscore, sciencescore;
        ImageView profilepic;
        Button editProfile;
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        name = v.findViewById(R.id.tvName);
        email = v.findViewById(R.id.tvEmail);
        phone = v.findViewById(R.id.tvPhoneNo);
        animalscore = v.findViewById(R.id.tvAnimal);
        historyscore = v.findViewById(R.id.tvhistory);
        sciencescore = v.findViewById(R.id.tvScience);
        profilepic = v.findViewById(R.id.profilepic);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                name.setText(currentUser.getName());
                email.setText(currentUser.getEmail());
                phone.setText(currentUser.getPhone());
                animalscore.setText(currentUser.getAnimalMasteryPoint().toString());
                historyscore.setText(currentUser.getHistoryMasteryPoint().toString());
                sciencescore.setText(currentUser.getScienceMasteryPoint().toString());
                if(currentUser.getProfilePictureUrl().isEmpty())
                {
                    Glide.with(v).load(R.drawable.ic_explorer).into(profilepic);
                }
                else
                {
                    Glide.with(v).load(currentUser.getProfilePictureUrl()).into(profilepic);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        editProfile = v.findViewById(R.id.btnEditProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
