package Rifugiato;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import it.uniba.dib.esame.R;
import it.uniba.dib.esame.databinding.ActivityMainBinding;

public class Registrazioner extends AppCompatActivity {

    ActivityMainBinding binding;
    String nome, cognome, nazionalita, codiceFiscale, sesso, eta;

    FirebaseDatabase db;

    DatabaseReference reference;



    Button button;
    Button indietrologin;
    TextInputEditText editTextemail, editTextnome, editTextcognome, editTextdatadinascita, editTextpassword;
    ProgressBar  progressBar;
    Button buttonreg;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent0 = new Intent(getApplicationContext(), MainActivityRifugiato.class);
            startActivity(intent0);
            finish();
        }
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // codice FireBase
        setContentView(binding.getRoot()); // codice FireBase
        setContentView(R.layout.registrazioner);
        editTextemail = findViewById(R.id.Email);
        editTextcognome= findViewById(R.id.Cognome);
        editTextdatadinascita= findViewById(R.id.Datadinascita);
        editTextnome=findViewById(R.id.Nome);
        editTextpassword=findViewById(R.id.Password);
        button = findViewById(R.id.indietrologin);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);
        buttonreg = findViewById(R.id.buttonreg);
        indietrologin = findViewById(R.id.indietrologin);
        indietrologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Registrazioner.this, MainActivityloginrifugiato.class);
                startActivity(intent1);
                finish();
            }
        });


        binding.buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                /*
                String email = String.valueOf(editTextemail.getText());
                String cognome = String.valueOf(editTextcognome.getText());
                String datadinascita = String.valueOf(editTextdatadinascita.getText());
                String nome = String.valueOf(editTextnome.getText());
                String password = String.valueOf(editTextpassword.getText());
                */

                String password = String.valueOf(editTextpassword.getText());
                String email = String.valueOf(editTextemail.getText());

                nome = binding.nome.getText(toString());
                cognome = binding.cognome.getText(toString());
                nazionalita = binding.nazionalita.getText(toString());
                codiceFiscale = binding.codiceFiscale.getText(toString());
                sesso = binding.sesso.getText(toString());
                eta = binding.eta.getText(toString());



                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Registrazioner.this, "Enter mail", Toast.LENGTH_SHORT).show();
                } if(TextUtils.isEmpty(password)){
                    Toast.makeText(Registrazioner.this, "Enter password", Toast.LENGTH_SHORT).show();
                }

                if((!nome.isEmpty()) && (!cognome.isEmpty()) && (!nazionalita.isEmpty()) && (!codiceFiscale.isEmpty()) && (!sesso.isEmpty()) && (!eta.isEmpty())) {
                    Rifugiato rifugiato = new Rifugiato(nome, cognome, nazionalita, codiceFiscale, sesso, eta);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Rifugiato");
                    reference.child(nome).setValue(rifugiato).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.nome.setText("");
                            binding.cognome.setText("");
                            binding.nazionalita.setText("");
                            binding.codiceFiscale.setText("");
                            binding.sesso.setText("");
                            binding.eta.setText("");

                            Toast.makeText(Registrazioner.this, "Registrazione aggiornata", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Registrazioner.this, R.string.account_created, Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Registrazioner.this, R.string.authentication_failed, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}