package com.linda.example;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView password;
    private ImageView result;
    private ImageView wrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_password);
        result = findViewById(R.id.image_result);
        wrong = findViewById(R.id.image_v);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }
    public void Button(View view) {
//        result.setAlpha(0.8f);
//
//
//        wrong.setAlpha(0.8f);
        result.setVisibility(View.VISIBLE);
        wrong.setVisibility(View.VISIBLE);


        if (name.length() > 6) {
//            result.setImageResource(R.drawable.erro);
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Your name have to be less than 6 letters")
                    .setPositiveButton("OK", null)
                    .show();
            result.setImageResource(R.drawable.erro);

        } else if (password.length() < 5) {
//            wrong.setImageResource(R.drawable.erro);
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Your password have to be more than 5 letters")
                    .setPositiveButton("OK", null)
                    .show();
            wrong.setImageResource(R.drawable.erro);


//        } else if(name.length() > 6 && password.length() < 5){
//            new AlertDialog.Builder(MainActivity.this)
//                    .setMessage("Your name have to be less than 6 letters and password have to be more than 5 letters")
//                    .setPositiveButton("OK", null)
//                    .show();
//            result.setImageResource(R.drawable.erro);
//            wrong.setImageResource(R.drawable.erro);

        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage(" Hello~ "+ name.getText().toString())
                    .setPositiveButton("Start",null)
                    .show();
            result.setVisibility(View.INVISIBLE);
            wrong.setVisibility(View.INVISIBLE);

        }
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
}
