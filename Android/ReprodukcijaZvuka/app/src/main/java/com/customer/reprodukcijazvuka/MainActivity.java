package com.customer.reprodukcijazvuka;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private SoundPool soundPool;
    private  int soundID;
    boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.tvInfo);
        textView.setOnTouchListener(this);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded =true;
            }
        });
        soundID = soundPool.load(this, R.raw.zvuk1,1);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(loaded){
            soundPool.play(soundID, 1.0f,1.0f,1,0,1.0f);
        }
        return true;
    }

}