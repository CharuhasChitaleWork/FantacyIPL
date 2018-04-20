package com.fipl.charuhaschitale.fantacy_ipl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

private DatabaseReference mDatabase;


public class LeaderboardActivity extends AppCompatActivity {
    TextView leader_board_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
// ...
