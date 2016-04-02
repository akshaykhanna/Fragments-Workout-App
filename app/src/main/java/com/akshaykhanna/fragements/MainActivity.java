package com.akshaykhanna.fragements;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        View fragContainer = findViewById(R.id.fragment_container);
        if(fragContainer!=null)
        {
            Toast.makeText(this,"Tablet Screen",Toast.LENGTH_SHORT).show();
            WorkoutDetailFragment fragDetail=new WorkoutDetailFragment();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            fragDetail.setWorkoutId((int)id);
            ft.replace(R.id.fragment_container,fragDetail);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else
        {
            Toast.makeText(this,"Mobile Screen",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
            startActivity(intent);
        }

    }
}
