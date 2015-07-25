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
    private TextView javaCountTimerLabel;
    private TextView cCountTimerLabel;

    private Runnable updateTimer, calculateFibonacci;
    private Handler handler = new Handler();

    private long startTime;
    private long elapsedTime = 0l;

    private int fibonacciTarget = 40;

    private int iii;

    static {
        System.loadLibrary("hello-jni");
    }

//    public native String stringFromNative();

    public native int calcFibonacciFromNDK(int fibonacciTarget);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        javaCountBtn = (Button)findViewById(R.id.javaCountButton);
        javaCountTimerLabel = (TextView) findViewById(R.id.javaCountTimerLabel);

        cCountBtn = (Button)findViewById(R.id.cCountButton);
        cCountTimerLabel = (TextView) findViewById(R.id.cCountTimerLabel);

//        TextView tvCCountResult = (TextView) findViewById(R.id.cCountResult);
//        tvCCountResult.setText(stringFromNative());
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

    public void startJavaCalc(View view) {
        setButtonState(false, false);
        startTime = SystemClock.elapsedRealtime();


        TextView tv = (TextView) findViewById(R.id.javaCountResult);
        tv.setText(String.valueOf(calcFibonacci(fibonacciTarget)));
//        handler.removeCallbacks(updateTimer);

        long t = SystemClock.elapsedRealtime() - startTime;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS", Locale.JAPAN);
        javaCountTimerLabel.setText(sdf.format(t));

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

    public int calcFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }


    public void startCCalc (View view) {
        setButtonState(false, false);
        startTime = SystemClock.elapsedRealtime();

        TextView tvCCountResult = (TextView) findViewById(R.id.cCountResult);
        tvCCountResult.setText(String.valueOf(calcFibonacciFromNDK(fibonacciTarget)));
//        tvCCountResult.setText(String.valueOf(calcFibonacciFromNDK()));
//        iii = calcFibonacciFromNDK();
//        tvCCountResult.setText(stringFromNative());

//        tvCCountResult.setText(String.valueOf(1));

//      tvCCountResult.setText(String.valueOf(stringFromNative()));

        long t = SystemClock.elapsedRealtime() - startTime;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS", Locale.JAPAN);
        cCountTimerLabel.setText(sdf.format(t));

        setButtonState(true, true);
    }


}
