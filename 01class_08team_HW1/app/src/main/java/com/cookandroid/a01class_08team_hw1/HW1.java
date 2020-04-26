package com.cookandroid.a01class_08team_hw1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class HW1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hw5);

        setTitle("5주차퀴즈_01-08조");

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1
        );      //weight 값을 1로 두어서 다른 레이아웃과 1:1비율을 지정할 수 있도록 했다.


        LinearLayout bLayout = new LinearLayout(this);
        bLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(bLayout, params1);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.HORIZONTAL);


        LinearLayout bottomLayout = new LinearLayout(this);
        bottomLayout.setOrientation(LinearLayout.HORIZONTAL);
        bottomLayout.setBackgroundColor(Color.BLUE);

        LinearLayout rightLayout = new LinearLayout(this);
        rightLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout leftLayout = new LinearLayout(this);
        leftLayout.setOrientation(LinearLayout.VERTICAL);
        leftLayout.setBackgroundColor(Color.RED);

        LinearLayout r1Layout = new LinearLayout(this);
        r1Layout.setBackgroundColor(Color.YELLOW);

        LinearLayout r2Layout = new LinearLayout(this);
        r2Layout.setBackgroundColor(Color.BLACK);

        bLayout.addView(baseLayout, params1);
        bLayout.addView(bottomLayout,params1);
        baseLayout.addView(leftLayout, params1);
        baseLayout.addView(rightLayout, params1);
        rightLayout.addView(r1Layout, params1);
        rightLayout.addView(r2Layout, params1);



    }
}
