package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andrjokelibrary.JokesActivity;


public class MainActivity extends AppCompatActivity {
    private static String mJoke;

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

    public void tellJoke(View view) {
        EndpointsAsyncTask task=new EndpointsAsyncTask();
        task.execute(this);
        try{
            Thread.sleep(5000);
            mJoke=task.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mJoke != null) {
            Intent intent=new Intent(this, JokesActivity.class);
            intent.putExtra("Joke",mJoke);
            startActivity(intent);

        }

    }


}
