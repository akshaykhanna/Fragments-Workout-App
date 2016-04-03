package com.akshaykhanna.fragements;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {


    private int workoutId;

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        View v=getView();
        if (v!=null)
        {
            TextView tvHead=(TextView)v.findViewById(R.id.tv_frag_detail_head);
            TextView tvDetail=(TextView)v.findViewById(R.id.tv_frag_detail_desc);
            Workout obj=Workout.workouts[workoutId];
            tvHead.setText(obj.getName());
            tvDetail.setText(obj.getDescriptions());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // workoutId=1;
        if(savedInstanceState!=null)
        {
            workoutId=savedInstanceState.getInt("workoutId");
        }
        else
        {
            FragmentTransaction ft=getChildFragmentManager().beginTransaction();
            StopwatchFragment sf=new StopwatchFragment();
            ft.replace(R.id.stopwatch_container,sf);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("workoutId",workoutId);
    }
}
