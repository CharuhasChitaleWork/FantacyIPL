package com.fipl.charuhaschitale.fantacy_ipl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
Button creategroupe,joinGroupe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        creategroupe = (Button) findViewById(R.id.buttonCreateGroupe);
        joinGroupe = (Button) findViewById(R.id.buttonJoinGroupe);

    }
}
