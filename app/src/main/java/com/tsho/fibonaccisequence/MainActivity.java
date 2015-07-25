package com.tsho.fibonaccisequence;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {
    private Button javaCountBtn, cCountBtn;
    private TextView javaTimerLabel;

    private Runnable updateTimer, calculateFibonacci;
    private Handler handler = new Handler();

    private long startTime;
    private long elapsedTime = 0l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        javaCountBtn = (Button)findViewById(R.id.javaCountButton);
//        javacount_btn.setOnClickListener(this);

        javaTimerLabel = (TextView) findViewById(R.id.javaCountTimerLabel);

        cCountBtn = (Button)findViewById(R.id.cCountButton);
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

    public void setButtonState(boolean java, boolean ndk) {
        javaCountBtn.setEnabled(java);
        cCountBtn.setEnabled(ndk);
    }

    public void javaCalc(View view) {
        startTime = SystemClock.elapsedRealtime();


        TextView tv = (TextView) findViewById(R.id.javaCountResult);
        tv.setText(String.valueOf(calcFibonacci(40)));
//        handler.removeCallbacks(updateTimer);

        long t = SystemClock.elapsedRealtime() - startTime;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS", Locale.JAPAN);
        javaTimerLabel.setText(sdf.format(t));

        setButtonState(true, true);

/*        updateTimer = new Runnable() {
            @Override
            public void run () {
                long t = SystemClock.elapsedRealtime();
                SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS", Locale.JAPAN);
                javaTimerLabel.setText(sdf.format(t));
                handler.removeCallbacks(updateTimer);
                handler.postDelayed(updateTimer, 10);
            }
        };
*/

//        handler.postDelayed(updateTimer, 10);
//        setButtonState(false, false);


    }

/*
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.javacount:
                TextView tv = (TextView) findViewById(R.id.javacount_result);
                TextView tv2 = (TextView) findViewById(R.id.javaTimerLabel);
                tv.setText(String.valueOf(calcFibonacci(40)));
                tv2.setText("test");

                break;
        }

    }
*/

    public int calcFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }




}
