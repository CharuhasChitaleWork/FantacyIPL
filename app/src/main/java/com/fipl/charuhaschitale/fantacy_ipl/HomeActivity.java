package com.fipl.charuhaschitale.fantacy_ipl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG ="";
    Button creategroupe,joinGroupe;

TextView team11,team12,team21,team22;

    private DatabaseReference mDatabase,ref,ref2,ref3,ref4,ref5,ref6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        team11 =(TextView) findViewById(R.id.Team11);
        team12 =(TextView) findViewById(R.id.Team12);
        team21 =(TextView) findViewById(R.id.Team21);
        team22 =(TextView) findViewById(R.id.Team22);

        mDatabase = FirebaseDatabase.getInstance().getReference();
      ref = mDatabase.child("realtime_fixtures").child("Match - 1");
        ref3 = ref.child("Team - 1");
        ref4 = ref.child("Team - 2");


      ref2 = mDatabase.child("realtime_fixtures").child("Match - 2");
            ref5 = ref2.child("Team - 1");
            ref6 = ref2.child("Team - 2");

  ref3.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
          String bun = dataSnapshot.getValue().toString();
          team11.setText(bun);


      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }
  });

        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bun = dataSnapshot.getValue().toString();
                team12.setText(bun);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bun = dataSnapshot.getValue().toString();
                team21.setText(bun);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bun = dataSnapshot.getValue().toString();
                team22.setText(bun);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}
