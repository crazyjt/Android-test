package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

/**
 * Created by 钧童 on 2017/6/30.
 */

public class Eleventh extends Activity {
    ViewFlipper viewFlipper;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleventh);

        button = (Button)findViewById(R.id.btnViewFlipper);
        viewFlipper = (ViewFlipper)findViewById(R.id.ViewFlipper);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
    }
}
