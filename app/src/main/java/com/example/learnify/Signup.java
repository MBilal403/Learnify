package com.example.learnify;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    private EditText ETFirstName;
    private Button BtnSignUp;
    private EditText ETLastName;
    private EditText ETEmailName;
    private EditText ETPassword;
    private Button BtnBackSignUp;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ETFirstName = findViewById(R.id.etFirstName);

        BtnSignUp = findViewById(R.id.btnSignUp);
        ETLastName= findViewById(R.id.etLastName);
        ETEmailName= findViewById(R.id.etEmailAddress);
        ETPassword= findViewById(R.id.etPassword);
        BtnBackSignUp = findViewById(R.id.btnBackSignUp);
        mAuth = FirebaseAuth.getInstance();
        BtnBackSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname;
                String lastname;

                String email;
                String password;
                firstname = ETFirstName.getText().toString().trim();
                lastname = ETLastName.getText().toString().trim();
                email = ETEmailName.getText().toString().trim();
                password = ETPassword.getText().toString().trim();
//                if (firstname.isEmpty()) {
//                    Toast.makeText(Signup.this, "Enter First Name", Toast.LENGTH_SHORT).show();
//                    return;
//                }else if (lastname.isEmpty()) {
//                    Toast.makeText(Signup.this, "Enter lastName", Toast.LENGTH_SHORT).show();
//                    return;
//                }else

                if (email.isEmpty()) {
                    Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.isEmpty()) {
                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(Signup.this, "Authentication Created.",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(Signup.this, login.class);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user
                                        Toast.makeText(Signup.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });




                    Toast.makeText(Signup.this, "Create", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });



































//        buttonn4 = findViewById(R.id.button4);
//        buttonn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Signup.this, LoginSignup.class);
//                startActivity(intent);
//            }
//        });
//        buttonn6 = findViewById(R.id.button6);
//        buttonn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Signup.this,Details.class);
//                startActivity(intent);
//            }
//        });
//        email1 = findViewById(R.id.editTextTextEmailAddress);
//        password1 = findViewById(R.id.editTextTextPassword);
//
//        buttonn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email;
//                String password;
//                email = String.valueOf(email1.getText().toString());
//                password = String.valueOf(password1.getText().toString());
//
//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        String email = null;
//        String password = null;
//        firebaseAuth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(Signup.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent( Signup.this, Details.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                        else {
//                            Toast.makeText(Signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });


    }


}
