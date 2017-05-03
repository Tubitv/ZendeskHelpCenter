package com.tubitv.tools.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tubitv.tools.logic.ZendeskHelpCenter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String ZENDESK_BASE_API_URL = "https://help.tubitv.com/api/v2/help_center/en-us/";

    private Button mFetch, mDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFetch = (Button) findViewById(R.id.button_fetch);
        mDisplay = (Button) findViewById(R.id.button_display);
        mFetch.setOnClickListener(this);
        mDisplay.setOnClickListener(this);

        new ZendeskHelpCenter();
    }


    private void fetchData(){
//        ZendeskHelpCenter.fetchData(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_display:

                break;

            case R.id.button_fetch:

                break;
        }
    }
}
