package com.fipl.charuhaschitale.fantacy_ipl;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    Button login,register;
        EditText email,pass;
        TextView singup,talabel ;
    boolean fl = false;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.buttonLogin);
        email =(EditText) findViewById(R.id.editTextEmail);
        pass =(EditText) findViewById(R.id.editTextPass);
        talabel = (TextView) findViewById(R.id.textViewError);
        singup = (TextView) findViewById(R.id.textViewSignup);
        register = (Button) findViewById(R.id.buttonSignup);
         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();
                String password = pass.getText().toString();
               Login(emaill,password);

            }
        });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emaill = email.getText().toString();
                    String password = pass.getText().toString();
                  Resister(emaill,password);

                }
            });

    }

    private void Resister(String emaill, String password) {
        mAuth.createUserWithEmailAndPassword(emaill, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            talabel.setText("Try Again");

                        }

                        // ...
                    }
                });
    }

    private void Login(String emaill, String password) {

        mAuth.signInWithEmailAndPassword(emaill, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                             Toast.makeText(MainActivity.this,"Authentication failed.", Toast.LENGTH_SHORT).show();
                            talabel.setText("Try Again");
                        }

                        // ...
                    }
                });

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("User",currentUser.getDisplayName());
        startActivity(intent); }
        else {

        }
    }




}
