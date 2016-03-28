package com.akshaykhanna.fragements;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment  {

    WorkoutListFragmentInterface listener;

    static interface WorkoutListFragmentInterface
    {
        void onItemClicked(long id);
    }


    public WorkoutListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener=(WorkoutListFragmentInterface)context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       if(listener!=null)
       {
           listener.onItemClicked(id);
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String name[]=new String[Workout.workouts.length];
        for(int i=0;i<Workout.workouts.length;i++)
        {
            name[i]=Workout.workouts[i].getName();
        }
        ArrayAdapter<String> aa=new ArrayAdapter<String>(
                inflater.getContext(),android.R.layout.simple_list_item_1,name
        );
        setListAdapter(aa);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
