package com.example.halosoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    protected Button weapon;
    protected Button fight;
    protected Button cameras;
    protected Button boo;
    protected Button miss;
    protected Button giveCov;
    protected Button wakeMe;
    protected Button theRock;
    protected Button theLadies;
    protected Button tellCov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Save all the buttons
        weapon = (Button) findViewById(R.id.btnWeap);
        weapon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Pass to the global click method
                // Have some way to let the that method know which button was clicked
            }
        });
        fight = (Button) findViewById(R.id.btnFight);
        cameras = (Button) findViewById(R.id.btnCam);
        boo = (Button) findViewById(R.id.btnBoo);
        miss = (Button) findViewById(R.id.btnMiss);
        giveCov = (Button) findViewById(R.id.btnGive);
        wakeMe = (Button) findViewById(R.id.btnWake);
        theRock = (Button) findViewById(R.id.btnRock);
        theLadies = (Button) findViewById(R.id.btnLadies);
        tellCov = (Button) findViewById(R.id.btnTell);



    }

    protected void onAnyClick(){
        // Called whenever any button is clicked

    }

}