package com.example.a160project;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a160project.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class ExerciseSelectorScreen extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ExerciseSelectorScreen() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ExerciseSelectorScreen newInstance(int columnCount) {
        ExerciseSelectorScreen fragment = new ExerciseSelectorScreen();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_selector_screen_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyExercisesRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }

    //Calling this function will send the user to the home screen
    private void toHomeScreen(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ExerciseSelector_to_HomeScreen);
    }
    //Calling this function will send the user to the running screen
    private void toRunningScreen(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ExerciseSelector_to_RunningScreen);
    }
}