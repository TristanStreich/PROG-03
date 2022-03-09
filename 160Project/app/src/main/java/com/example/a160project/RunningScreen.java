package com.example.a160project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RunningScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RunningScreen extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //private Thread incrementMetricsThread;

    public RunningScreen() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RunningScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static RunningScreen newInstance(String param1, String param2) {
        RunningScreen fragment = new RunningScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_running_screen, container, false);
        Button record = (Button) v.findViewById(R.id.button);

        record.setOnClickListener(this);
        return v;
    }

    public static int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static double randDouble(double min, double max) {
        return min + Math.random() * (max - min);
    }

    public void startRun() {
        Button record = getView().findViewById(R.id.button);

        String stop_text = getResources().getString(R.string.stop);
        record.setText(stop_text);

        int calories = 89;
        double miles = 0.8;
        int steps = 826;

        TextView calories_text = getView().findViewById(R.id.calories_counter);
        TextView miles_text = getView().findViewById(R.id.miles_counter);
        TextView steps_text = getView().findViewById(R.id.steps_counter);

        calories_text.setText(Integer.toString(calories));
        miles_text.setText(String.format("%.2f", miles));
        steps_text.setText(Integer.toString(steps));

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRun();
            }
        });
    }

    public void stopRun() {
        Button stop = getView().findViewById(R.id.button);

        String record_text = getResources().getString(R.string.record);
        stop.setText(record_text);

        int calories = 0;
        double miles = 0.0;
        int steps = 0;

        TextView calories_text = getView().findViewById(R.id.calories_counter);
        TextView miles_text = getView().findViewById(R.id.miles_counter);
        TextView steps_text = getView().findViewById(R.id.steps_counter);

        calories_text.setText(Integer.toString(calories));
        miles_text.setText(String.format("%.2f", miles));
        steps_text.setText(Integer.toString(steps));

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRun();
            }
        });
    }

    @Override
    public void onClick(View v) {
        startRun();
    }


    //Calling this function will send the user to the home screen
    private void toHomeScreen(){
        NavHostFragment.findNavController(this).navigate(R.id.action_RunningScreen_to_HomeScreen);
    }
}