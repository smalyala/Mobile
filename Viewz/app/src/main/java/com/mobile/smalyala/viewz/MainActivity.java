package com.mobile.smalyala.viewz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    int cycle = 0;

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

    public void change(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView);
        cycle = (cycle + 1)%8;
        if (cycle == 0)
            image.setImageResource(R.drawable.cookie);
        else if (cycle == 1)
            image.setImageResource(R.drawable.fish);
        else if (cycle == 2)
            image.setImageResource(R.drawable.human);
        else if (cycle == 3)
            image.setImageResource(R.drawable.monkey);
        else if (cycle == 4)
            image.setImageResource(R.drawable.mouse);
        else if (cycle == 4)
            image.setImageResource(R.drawable.rock);
        else if (cycle == 5)
            image.setImageResource(R.drawable.spidermonkey);
        else if (cycle == 6)
            image.setImageResource(R.drawable.tree);
        else if (cycle == 7)
            image.setImageResource(R.drawable.turtle);
    }
}
