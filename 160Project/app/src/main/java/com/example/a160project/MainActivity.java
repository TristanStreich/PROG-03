package com.example.a160project;

import static com.example.a160project.RunningScreen.randDouble;
import static com.example.a160project.RunningScreen.randInt;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a160project.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_160Project);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        getActionBar().hide();s

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                navController.navigate(R.id.return_to_HomeScreen);
//            }
//        });
//        Button record = findViewById(R.id.button);
//
//        record.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startRun(view);
//            }
//        });
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


    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void startRun(View view) {
        Button record = findViewById(R.id.button);

        String stop_text = getResources().getString(R.string.stop);
        record.setText(stop_text);

        int calories = 89;
        double miles = 0.8;
        int steps = 826;

        TextView calories_text = findViewById(R.id.calories_counter);
        TextView miles_text = findViewById(R.id.miles_counter);
        TextView steps_text = findViewById(R.id.steps_counter);

        calories_text.setText(Integer.toString(calories));
        miles_text.setText(String.format("%.2f", miles));
        steps_text.setText(Integer.toString(steps));

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRun(view);
            }
        });
    }

    public void stopRun(View view) {
        Button stop = findViewById(R.id.button);

        String record_text = getResources().getString(R.string.record);
        stop.setText(record_text);

        int calories = 0;
        double miles = 0.0;
        int steps = 0;

        TextView calories_text = findViewById(R.id.calories_counter);
        TextView miles_text = findViewById(R.id.miles_counter);
        TextView steps_text = findViewById(R.id.steps_counter);

        calories_text.setText(Integer.toString(calories));
        miles_text.setText(String.format("%.2f", miles));
        steps_text.setText(Integer.toString(steps));

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRun(view);
            }
        });
    }
}