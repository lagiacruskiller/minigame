package com.example.minigame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView stamina;
    private int staminavalue;
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stamina = findViewById(R.id.staminabar);
        staminavalue = 100;
        findViews();
    }
    private void findViews(){
        findViewById(R.id.btnup).setOnClickListener(this);
        findViewById(R.id.btndown).setOnClickListener(this);
        findViewById(R.id.btnleft).setOnClickListener(this);
        findViewById(R.id.btnright).setOnClickListener(this);
        gameView = findViewById(R.id.gameview);

    }

    @Override
    public void onClick(View v) {
        while(staminavalue > 0){
            switch(v.getId()){
                case R.id.btnup:
                    Log.d("MainActivity","OnClick: Up");
                    gameView.setPosY(gameView.getPosY() - 50);
                    gameView.invalidate();
                    break;
                case R.id.btndown:
                    Log.d("MainActivity","OnClick: Down");
                    gameView.setPosY(gameView.getPosY() + 50);
                    gameView.invalidate();
                    break;
                case R.id.btnleft:
                    Log.d("MainActivity","OnClick: Left");
                    gameView.setPosX(gameView.getPosX() - 50);
                    gameView.invalidate();
                    break;
                case R.id.btnright:
                    Log.d("MainActivity","OnClick: Right");
                    gameView.setPosX(gameView.getPosX() + 50);
                    gameView.invalidate();
                    break;
            }
            setStaminavalue(getStaminavalue()-1);
            Log.d("MainActivity","OnClick");
            stamina.setText("Stamina: " + staminavalue);
            break;
        }
        if(staminavalue == 0)
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Game Over")
                    .setMessage("Your stamina have depleted")
                    .setPositiveButton("Retry?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            staminavalue = 100;
                            stamina.setText("Stamina: " + staminavalue);
                        }
                    });


    }

    public int getStaminavalue(){
        return staminavalue;
    }

    private void setStaminavalue(int staminavalue){
        this.staminavalue = staminavalue;
    }
}
