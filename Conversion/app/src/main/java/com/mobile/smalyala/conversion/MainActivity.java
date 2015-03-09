package com.mobile.smalyala.conversion;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void exec(View view) {
        String[] options = {"monkey", "tree", "cookie", "mouse", "fish", "rock", "spider monkey", "human", "human"}; //9 total
        String answer;
        TextView text = (TextView) findViewById(R.id.editText);
        String ageFake = text.getText().toString();
        int age = Integer.parseInt(ageFake);
        if (age >= 40)
            age = 40;
        age = age/10;
        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup);
        RadioButton rb = (RadioButton)findViewById(radio.getCheckedRadioButtonId());
        String believer = (String)rb.getText();
        int first;
        if (believer.equals("Yes"))
            first = 1;
        else
            first = 0;
        radio = (RadioGroup)findViewById(R.id.radioGroup2);
        rb = (RadioButton)findViewById(radio.getCheckedRadioButtonId());
        String person = (String)rb.getText();
        int second;
        if (person.equals("Yes"))
            second = 4;
        else if (person.equals("No"))
            second = 2;
        else
            second = 0;
        if (first == 1) {
            int total = age + second;
            answer = options[total] + ".";
        }
        else {
            answer = "believer.";
        }
        TextView disp = (TextView)findViewById(R.id.disp);
        disp.setText(answer);
    }
}
