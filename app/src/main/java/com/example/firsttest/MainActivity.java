package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    LinearLayout base;
    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("01-08-");


        base=(LinearLayout)findViewById(R.id.base);
        imageView=(ImageView)findViewById(R.id.img);
        btn=(Button)findViewById(R.id.btn);
        registerForContextMenu(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.inflate(R.menu.menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1:
                                imageView.setImageResource(R.drawable.dog);
                                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 800));
                                return true;
                            case R.id.item2:
                                imageView.setImageResource(R.drawable.cat);
                                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 800));
                                return true;
                            case R.id.item3:
                                imageView.setImageResource(R.drawable.seal);
                                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,800));
                                return true;
                            case R.id.item4:
                                imageView.setImageResource(R.drawable.parrot);
                                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 800));
                                return true;
                        }
                        return false;
                    }

                });
            }
        });
    }
}
