package Rifugiato;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.uniba.dib.esame.MainActivity;
import it.uniba.dib.esame.R;

public class MainActivityloginrifugiato extends AppCompatActivity {

    Button button1;
    Button button2;

    Button button3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityloginrifugiato);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.registrati);
        button3 = findViewById(R.id.loginrifugiato);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivityloginrifugiato.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivityloginrifugiato.this, Registrazioner.class);
                startActivity(intent2);
            }

        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivityloginrifugiato.this, MainActivityRifugiato.class);
                startActivity(intent3);
            }

        });
    }
}