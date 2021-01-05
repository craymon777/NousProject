package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nous.Model.StageCompleted;
import com.example.nous.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogin, btnRegister, btnResetPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        btnLogin = (Button) findViewById(R.id.buttonlogin2);
        btnRegister = (Button) findViewById(R.id.buttonconfirm);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnResetPassword = (Button) findViewById(R.id.buttonforgotpass);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, ForgotPasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }


                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    User newUser = createDefaultUser(email);
                                    FirebaseDatabase.getInstance().getReference("User")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful())
                                            {
                                                Toast.makeText(SignupActivity.this, "User has been registered successfully" , Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                                                finish();
                                            }
                                            else
                                            {
                                                Toast.makeText(SignupActivity.this, "Failed to register! Try Again!" , Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            }
                        });

            }
        });
    }

    public User createDefaultUser(String inputEmail)
    {
        String  Name, Email, Phone, ProfilepicUrl;
        Integer AMS, HMS, SMS, experientPoint;
        HashMap<String, StageCompleted> stageCompleted = new HashMap<String, StageCompleted>();
        HashMap<String, Integer> badgeCompleted = new HashMap<String, Integer>();
        Name = "Explorer";
        Email = inputEmail;
        Phone = "";
        ProfilepicUrl = "";
        AMS = 0;
        HMS = 0;
        SMS = 0;
        StageCompleted animal = new StageCompleted(0,0,0,0,0);
        StageCompleted history = new StageCompleted(0,0,0,0,0);
        StageCompleted science = new StageCompleted(0,0,0,0,0);
        stageCompleted.put("animal", animal);
        stageCompleted.put("history",history);
        stageCompleted.put("science",science);
        badgeCompleted.put("badge1",0);
        badgeCompleted.put("badge2",0);
        badgeCompleted.put("badge3",0);
        badgeCompleted.put("badge4",0);
        badgeCompleted.put("badge5",0);
        badgeCompleted.put("badge6",0);
        badgeCompleted.put("badge7",0);
        experientPoint=0;
        User user = new User(Name,Email,Phone,ProfilepicUrl,AMS,HMS,SMS,stageCompleted,badgeCompleted,experientPoint);
        return user;
    }
}