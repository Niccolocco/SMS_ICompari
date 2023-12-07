package Rifugiato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.uniba.dib.esame.MainActivity;
import it.uniba.dib.esame.R;

public class MainActivityloginrifugiato extends AppCompatActivity {

    Button indietro;
    FirebaseAuth mAuth;
    TextView registrati;
    TextInputEditText editTextemail,  editTextpassword;
    ProgressBar progressBar;

    Button buttonl;
    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent9 = new Intent(MainActivityloginrifugiato.this, MainActivityRifugiato.class);
            startActivity(intent9);
            finish();

        }
    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityloginrifugiato);
        indietro = findViewById(R.id.button3);
        registrati = findViewById(R.id.registrati);
        buttonl = findViewById(R.id.loginrifugiato);
        editTextemail = findViewById(R.id.editTextTextEmailAddress);
        editTextpassword=findViewById(R.id.editTextTextPassword);
        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Registrazioner", "Button Registrati clicked");
                Intent intent2 = new Intent(MainActivityloginrifugiato.this, Registrazioner.class);
                startActivity(intent2);


            }
        });
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivityloginrifugiato.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });


        buttonl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email= String.valueOf(editTextemail.getText());
                password= String.valueOf(editTextpassword.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivityloginrifugiato.this, "Enter mail", Toast.LENGTH_SHORT).show();
                } if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivityloginrifugiato.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivityloginrifugiato.this, "Login avvenuto con successo", Toast.LENGTH_SHORT).show();
                                    Intent intent0 = new Intent(MainActivityloginrifugiato.this, MainActivityRifugiato.class);
                                    startActivity(intent0);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivityloginrifugiato.this, "Login fallito", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }

        });
    }

}