package com.example.halosoundboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;


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
    protected MediaPlayer mp;
    protected AssetManager assetManager;
    protected AssetFileDescriptor asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assetManager is used to access mp3 files from the assets directory
        assetManager = getAssets();
        mp = new MediaPlayer();

        // Save all the buttons
        weapon = (Button) findViewById(R.id.btnWeap);
        weapon.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)   // annotation just suppresses compile warning (see method for fix to the error)
            public void onClick(View v){
                playMedia("weapon.mp3");
            }
        });
        fight = (Button) findViewById(R.id.btnFight);
        fight.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("finishFight.mp3");
            }
        });
        cameras = (Button) findViewById(R.id.btnCam);
        cameras.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("cameras.mp3");
            }
        });
        boo = (Button) findViewById(R.id.btnBoo);
        boo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("boo.mp3");
            }
        });
        miss = (Button) findViewById(R.id.btnMiss);
        miss.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("miss.mp3");
            }
        });
        giveCov = (Button) findViewById(R.id.btnGive);
        giveCov.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("giveBack.mp3");
            }
        });
        wakeMe = (Button) findViewById(R.id.btnWake);
        wakeMe.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("wakeMe.mp3");
            }
        });
        theRock = (Button) findViewById(R.id.btnRock);
        theRock.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("theRock.mp3");
            }
        });
        theLadies = (Button) findViewById(R.id.btnLadies);
        theLadies.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("ladies.mp3");
            }
        });
        tellCov = (Button) findViewById(R.id.btnTell);
        tellCov.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                playMedia("tellCovenant.mp3");
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void playMedia(String fileName){
        // Good practice to reset the mp
        mp.reset();


        try {
            asset = assetManager.openFd(fileName);

            // This block implements the same functionality as the setDataSource(AssetFileDescriptor) method but allows it to be used on older versions of android
            if (asset.getDeclaredLength() < 0) {
                mp.setDataSource(asset.getFileDescriptor());
            } else {
                mp.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getDeclaredLength());
            }

            asset.close();
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
