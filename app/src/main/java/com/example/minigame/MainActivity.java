package com.example.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView stamina;
    int staminavalue = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        findViewById(R.id.btnup).setOnClickListener(this);
        findViewById(R.id.btndown).setOnClickListener(this);
        findViewById(R.id.btnleft).setOnClickListener(this);
        findViewById(R.id.btnright).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch(v.getId()){
           case R.id.btnup:
               Log.d("MainActivity","OnClick: Up");
               break;
           case R.id.btndown:
               Log.d("MainActivity","OnClick: Down");
               break;
           case R.id.btnleft:
               Log.d("MainActivity","OnClick: Left");
               break;
           case R.id.btnright:
               Log.d("MainActivity","OnClick: Right");
               break;
       }
        staminavalue = staminavalue - 1;
        Log.d("MainActivity","OnClick");
        stamina.setText("Stamina: " + staminavalue);
    }
}
