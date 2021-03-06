package com.example.a160project;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeScreen newInstance(String param1, String param2) {
        HomeScreen fragment = new HomeScreen();
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
        View v = inflater.inflate(R.layout.fragment_home_screen, container, false);

        View toBodyDetails = v.findViewById(R.id.bodyDetailsRectangle);
        toBodyDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toBodyDetailsScreen();
            }
        });

        View toExerciseSelector = v.findViewById(R.id.exerciseSelectorRectangle);
        toExerciseSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toExerciseSelector();
            }
        });
        return v;
    }

    //Calling this function will send the user to the body details screen
    private void toBodyDetailsScreen(){
        NavHostFragment.findNavController(this).navigate(R.id.action_HomeScreen_to_BodyDetails);
    }

    //Calling this function will send the user to the exercise Selector
    private void toExerciseSelector(){
        NavHostFragment.findNavController(this).navigate(R.id.action_HomeScreen_to_ExerciseSelector);
    }
}