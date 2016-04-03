package com.akshaykhanna.fragements;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private  int seconds=0;
    private  boolean running=false;
    private  boolean wasRunning=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_stopwatch,container,false);

        //using this type of button click events because buttons are in fragment layout
        Button bStart=(Button)view.findViewById(R.id.bt_start);
        Button bStop=(Button)view.findViewById(R.id.bt_stop);
        Button bReset=(Button)view.findViewById(R.id.bt_reset);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        bReset.setOnClickListener(this);

        runStopWatch(view);
        return view;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_start:onButtomStart(v);
                break;
            case R.id.bt_stop:onButtomStop(v);
                break;
            case R.id.bt_reset:onButtomReset(v);
                break;
        }
    }

    //stops stopwatch when app loose foucs
    @Override
    public void onPause() {
        super.onPause();
        wasRunning=running;
        running=false;
    }
    //starts stopwatch if was preeviously running before pause when app gains focus
    @Override
    public void onResume() {
        super.onResume();
        running=wasRunning;
    }
    //saves stopwatch state(on/off + time) when activity gets destroy due to orientation  or screen size change
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    public void runStopWatch(View view)
    {
        final TextView tv = (TextView) view.findViewById(R.id.tv_timer);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, sec);
                tv.setText(time);
                if (running) {
                    seconds += 1;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onButtomStart(View v)
    {
        //Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show();
        running=true;
        Context context=getActivity();
        Toast.makeText(context,"Start",Toast.LENGTH_SHORT).show();
    }
    public void onButtomStop(View v)
    {
        //Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        running=false;
    }
    public void onButtomReset(View v)
    {
        // Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show();
        running=false;
        seconds=0;
    }


    public StopwatchFragment() {
        // Required empty public constructor
    }

}
