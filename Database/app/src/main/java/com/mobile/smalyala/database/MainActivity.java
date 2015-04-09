package com.mobile.smalyala.database;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://smalyaladatabase.firebaseio.com/");
        myFirebaseRef.child("previous").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> entries = (ArrayList<String>)(dataSnapshot.getValue());
                TextView text = (TextView)findViewById(R.id.textView3);
                String val = "";
                for (String x : entries) {
                    val += x + "\r\n";
                }
                text.setText(val);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) { }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void add(View view) {
        EditText text = (EditText)findViewById(R.id.editText);
        final String value = text.getText().toString();
        final Firebase myFirebaseRef = new Firebase("https://smalyaladatabase.firebaseio.com/");
        myFirebaseRef.child("previous").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> entries = (ArrayList<String>)(dataSnapshot.getValue());
                entries.add(value);
                myFirebaseRef.child("previous").setValue(entries);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) { }
        });
    }
}
