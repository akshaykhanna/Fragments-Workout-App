package com.akshaykhanna.fragements;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListFragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // WorkoutDetailFragment fragDetail=(WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);

        //fragDetail.setWorkoutId(0);
    }

    @Override
    public void onItemClicked(long id) {

    }
}
