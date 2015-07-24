package com.tsho.fibonaccisequence;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button javacount_btn, ccount_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        javacount_btn = (Button)findViewById(R.id.javacount);
        javacount_btn.setOnClickListener(this);

        ccount_btn = (Button)findViewById(R.id.ccount);
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.javacount:
                TextView tv = (TextView) findViewById(R.id.javacount_result);
                TextView tv2 = (TextView) findViewById(R.id.javacount_time);
                tv.setText(String.valueOf(calcFibonacci(40)));
                tv2.setText("test");
                break;
        }

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




}
