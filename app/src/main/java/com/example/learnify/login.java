package com.example.learnify;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private Button BtnSignIn;
    private EditText ETEmailLogin;
    private EditText ETPasswordLogin;
    private Button BtnBackLogin;
    FirebaseAuth mAuth;

     // yoc can uncomment this code when an user already login // autologin system
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent= new Intent(login.this, Details.class);
//            startActivity(intent);
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BtnSignIn = (Button) findViewById(R.id.btnSignIn);
        ETEmailLogin = findViewById(R.id.etEmailAddressLogin);
        ETPasswordLogin = findViewById(R.id.etPasswordLogin);
        BtnBackLogin = findViewById(R.id.btnBackLogin);
        mAuth = FirebaseAuth.getInstance();

        BtnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        BtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email;
                String password;
                email = ETEmailLogin.getText().toString().toLowerCase().trim();
                password = ETPasswordLogin.getText().toString().trim();
                EmailValidator validator = new EmailValidator();
//                        if (validator.validate(email)) {
//                            Toast.makeText(login.this, "Check Format valid", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(login.this, "Check Format invalid", Toast.LENGTH_SHORT).show();
//                        }
                if (email.isEmpty() ) {
                    Toast.makeText(login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                } else  if (!validator.validate(email)) {
                    Toast.makeText(login.this, "Check Format", Toast.LENGTH_SHORT).show();
                    return;
                }else  if (!email.contains("bcs") && !email.contains("bit") ) {
                    Toast.makeText(login.this, "Check Format", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (password.isEmpty()) {
                    Toast.makeText(login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(login.this, "User Login.",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(login.this, Details.class);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                }
            }
        });

    }
}

class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

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
//
//                Intent intent = new Intent(SignIn.this,Details.class);
//                startActivity(intent);
//            }
//        });