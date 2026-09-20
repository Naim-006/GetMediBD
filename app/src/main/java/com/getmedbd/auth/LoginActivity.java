package com.getmedbd.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.getmedbd.R;
import com.getmedbd.customer.home.MainActivity;

/**
 * Login Activity for user authentication
 */
public class LoginActivity extends AppCompatActivity {
    
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        initViews();
        setupListeners();
    }
    
    private void initViews() {
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
    }
    
    private void setupListeners() {
        loginButton.setOnClickListener(v -> attemptLogin());
    }
    
    private void attemptLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        
        if (validateInputs(email, password)) {
            // TODO: Implement actual authentication logic
            // For demo purposes, navigate to MainActivity
            navigateToMain();
        }
    }
    
    private boolean validateInputs(String email, String password) {
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return false;
        }
        
        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        
        return true;
    }
    
    private void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
