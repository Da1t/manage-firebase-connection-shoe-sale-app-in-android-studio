package com.example.dean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupName = findViewById(R.id.namesignup);
        signupEmail = findViewById(R.id.email);
        signupUsername = findViewById(R.id.usernamesignup);
        signupPassword = findViewById(R.id.passwordsignup);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.buttonsignup);



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);
                checkCrededentials();
                //Toast.makeText(SignUpActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
               // startActivity(intent);
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkCrededentials() {

        String email = signupEmail.getText().toString();
      String password = signupPassword.getText().toString();

        if(email.isEmpty() || !email.contains("@"))
       {
           showError(signupEmail,"Email is not valid!");
       } else if (password.isEmpty() || password.length()<7) {
            showError(signupPassword,"Your password is not valid ");
       }
       else {
           Toast.makeText(this, "You have signup successfully! ", Toast.LENGTH_SHORT).show();
       }
   }

   private void showError(EditText input, String s) {
       // signupPassword.setError(s);
input.setError(s);

input.requestFocus();
    }
}
