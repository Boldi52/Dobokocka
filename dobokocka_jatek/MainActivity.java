package com.example.dobokocka_jatek;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int jatekosokSzama = 3;
    int[] pontok = new int[3];
    boolean[] kiesett = new boolean[3];
    Random dobas = new Random();
    TextView jatekos_nevek;
    Button jatekButton, dobasButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        jatekButton = findViewById(R.id.jatek_gomb);





        Random random = new Random();
        EditText j1 = findViewById(R.id.jatekos1);
        EditText j2 = findViewById(R.id.jatekos2);
        TextView j1_dobasai = findViewById(R.id.jatekos1_dobasai);
        TextView j2_dobasai = findViewById(R.id.jatekos2_dobasai);


        TextView leiras = findViewById(R.id.jatek_leiras);

        Button jatszok = findViewById(R.id.jatszok_gomb);
        Button dobj1 = findViewById(R.id.dobj1);
        Button dobj2 = findViewById(R.id.dobj2);


        leiras.setVisibility(View.GONE);
        j1.setVisibility(View.GONE);
        j2.setVisibility(View.GONE);
        jatekButton.setVisibility(View.GONE);
        dobj1.setVisibility(View.GONE);
        dobj2.setVisibility(View.GONE);
        j1_dobasai.setVisibility(View.GONE);
        j2_dobasai.setVisibility(View.GONE);


        jatszok.setOnClickListener(v->{
            leiras.setVisibility(View.VISIBLE);
            j1.setVisibility(View.VISIBLE);
            j2.setVisibility(View.VISIBLE);
            jatekButton.setVisibility(View.VISIBLE);
            dobj1.setVisibility(View.GONE);
            dobj2.setVisibility(View.GONE);
            jatszok.setVisibility(View.GONE);
        });


        jatekButton.setOnClickListener(v->{
            leiras.setVisibility(View.GONE);
            dobj1.setVisibility(View.VISIBLE);
            dobj2.setVisibility(View.VISIBLE);
            jatekButton.setVisibility(View.GONE);
            j1_dobasai.setVisibility(View.VISIBLE);
            j2_dobasai.setVisibility(View.VISIBLE);
        });


        dobj1.setOnClickListener(v->{
            int pontszamlalo1 = 0;
            int dobas = 0;
            while(dobas != 3 && dobas < 6){
                dobas ++;
                int randomSzam1 = random.nextInt(6) + 1;
                j1_dobasai.setText("Dobás: " + randomSzam1);
                if(randomSzam1 == 3){
                    dobj1.setVisibility(View.GONE);
                    j1_dobasai.setText("Vesztettél!");
                }

                pontszamlalo1 += randomSzam1;
            }
            if(dobas == 5){
                j1_dobasai.setText("A játék véget ért. A pontjaid összege: " + pontszamlalo1);
                dobj1.setVisibility(View.GONE);
            }


        });

        dobj2.setOnClickListener(v->{

            int pontszamlalo2 = 0;
            int dobas2 = 0;
            while(dobas2 != 3 && dobas2 < 6){
                dobas2 ++;
                int randomSzam2 = random.nextInt(6) + 1;
                j2_dobasai.setText("Dobás: " + randomSzam2);
                if(randomSzam2 == 3){
                    dobj1.setVisibility(View.GONE);
                    j2_dobasai.setText("Vesztettél!");
                }

                pontszamlalo2 += randomSzam2;
            }
            if(dobas2 == 5){
                j2_dobasai.setText("A játék véget ért. A pontjaid összege: " + pontszamlalo2);
                dobj2.setVisibility(View.GONE);
            }

        });












    }




}