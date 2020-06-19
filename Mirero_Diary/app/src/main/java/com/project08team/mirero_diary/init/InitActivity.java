package com.project08team.mirero_diary.init;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.project08team.mirero_diary.BuildConfig;
import com.project08team.mirero_diary.R;
import com.project08team.mirero_diary.main.MainActivity;
import com.project08team.mirero_diary.security.PasswordActivity;
import com.project08team.mirero_diary.shared.mirero_diaryApplication;
import com.project08team.mirero_diary.shared.SPFManager;


public class InitActivity extends Activity implements InitTask.InitCallBack {

    private TextView TV_init_message;

    private int initTime = 2500; // 3S
    private Handler initHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        initHandler = new Handler();
        //init UI
        TV_init_message = (TextView) findViewById(R.id.TV_init_message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //This apk is first install or was updated
        if (SPFManager.getVersionCode(InitActivity.this) < BuildConfig.VERSION_CODE) {
            TV_init_message.setVisibility(View.VISIBLE);
        }
        initHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new InitTask(InitActivity.this, InitActivity.this).execute();
            }
        }, initTime);
    }

    @Override
    protected void onPause() {
        super.onPause();
        initHandler.removeCallbacksAndMessages(null);
    }


    @Override
    public void onInitCompiled(boolean showReleaseNote) {

        if (((mirero_diaryApplication) getApplication()).isHasPassword()) {
            Intent goSecurityPageIntent = new Intent(this, PasswordActivity.class);
            goSecurityPageIntent.putExtra("password_mode", PasswordActivity.VERIFY_PASSWORD);
            goSecurityPageIntent.putExtra("showReleaseNote", showReleaseNote);
            finish();
            InitActivity.this.startActivity(goSecurityPageIntent);
        } else {
            Intent goMainPageIntent = new Intent(InitActivity.this, MainActivity.class);
            goMainPageIntent.putExtra("showReleaseNote", showReleaseNote);
            finish();
            InitActivity.this.startActivity(goMainPageIntent);
        }
    }
}
