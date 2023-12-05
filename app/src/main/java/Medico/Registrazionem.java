package Medico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Rifugiato.MainActivityloginrifugiato;
import Rifugiato.Registrazioner;
import it.uniba.dib.esame.R;

public class Registrazionem extends AppCompatActivity {

    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazionem);
        button = findViewById(R.id.registrazionem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registrazionem.this, MainActivityloginmedico.class);
                startActivity(intent);
            }
        });

    }
}