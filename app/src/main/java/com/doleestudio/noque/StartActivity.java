package com.doleestudio.noque;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class StartActivity extends ActionBarActivity {
    private boolean isBackButtonPressedBefore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.start_container, new StartFragment()).addToBackStack(null).commit();

    }
}
