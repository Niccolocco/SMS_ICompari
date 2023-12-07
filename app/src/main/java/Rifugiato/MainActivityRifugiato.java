package Rifugiato;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.uniba.dib.esame.MainActivity;
import it.uniba.dib.esame.R;

public class MainActivityRifugiato extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    Button button0;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rifugiato);
        auth = FirebaseAuth.getInstance();
        button0 = findViewById(R.id.logout);
        user = auth.getCurrentUser();
        textView = findViewById(R.id.userdetails);
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
            Intent intent0 = new Intent(getApplicationContext(), MainActivityloginrifugiato.class);
            startActivity(intent0);
            finish();
        } else {
            textView.setText(user.getEmail());
        }
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent1 = new Intent(getApplicationContext(), MainActivityloginrifugiato.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}