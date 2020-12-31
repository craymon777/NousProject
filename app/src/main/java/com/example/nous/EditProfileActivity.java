package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nous.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {

    EditText name, phone;
    ImageView btn_back,profilePicture;
    Button btn_update;
    String email, animalScore, historyScore, scienceScore, profileURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhoneNo);
        btn_update = findViewById(R.id.buttonUpdate);
        btn_back = findViewById(R.id.back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(EditProfileActivity.this, ProfileActivity.class);
                startActivity(profile);
            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                name.setText(currentUser.getName());
                phone.setText(currentUser.getPhone());
                email = currentUser.getEmail();
                animalScore = currentUser.getAnimalScore();
                historyScore = currentUser.getHistoryScore();
                scienceScore = currentUser.getScienceScore();
                profileURL = currentUser.getProfilepic();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = name.getText().toString();
                String sPhone = phone.getText().toString();

                if(TextUtils.isEmpty(sName) || TextUtils.isEmpty(sPhone))
                {
                    Toast.makeText(EditProfileActivity.this, "All fields must be filled", Toast.LENGTH_LONG).show();
                }

                FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();

                if (User == null) {
                    Intent firebaseUserIntent = new Intent(EditProfileActivity.this, LoginActivity.class);
                    startActivity(firebaseUserIntent);
                    finish();
                } else {

                    reference.child("Name").setValue(sName);
                    reference.child("Phone").setValue(sPhone);

                    Intent profile = new Intent(EditProfileActivity.this, ProfileActivity.class);
                    startActivity(profile);
                }
            }
        });
    }
}