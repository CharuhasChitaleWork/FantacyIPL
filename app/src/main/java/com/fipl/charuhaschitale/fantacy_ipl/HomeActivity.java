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

    private DatabaseReference mDatabase,ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        creategroupe = (Button) findViewById(R.id.buttonCreateGroupe);
        joinGroupe = (Button) findViewById(R.id.buttonJoinGroupe);
        team11 =(TextView) findViewById(R.id.Team11);
        team12 =(TextView) findViewById(R.id.Team12);
        team21 =(TextView) findViewById(R.id.Team21);
        team22 =(TextView) findViewById(R.id.Team22);

        mDatabase = FirebaseDatabase.getInstance().getReference();
      ref = mDatabase.child("realtime_fixtures");
  ref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
          String bun = dataSnapshot.getValue().toString();
          team11.setText(bun);
        Object obj=  dataSnapshot.getValue();
        team12.setText(obj.toString());
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }
  });



    }




}
