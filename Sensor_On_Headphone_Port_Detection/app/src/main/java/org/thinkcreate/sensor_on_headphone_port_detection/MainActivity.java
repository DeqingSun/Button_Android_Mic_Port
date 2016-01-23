package org.thinkcreate.sensor_on_headphone_port_detection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    static final String TAG = "MainActivity";
    private ButtonOnMicReceiver mButtonOnMicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonOnMicReceiver = new ButtonOnMicReceiver();
        registerReceiver(mButtonOnMicReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));

        AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        am.registerMediaButtonEventReceiver(new ComponentName(getPackageName(), ButtonOnMicReceiver.class.getName()));


        Log.v(TAG, "HeadsetExample: The Button Receiver has been registered");
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode== KeyEvent.KEYCODE_VOLUME_DOWN){

            return true;
        }
        else if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)
        {

            return true;
        }
        else return super.onKeyUp(keyCode, event);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
            Log.v(TAG, "down");
            Toast.makeText(this, "KEYCODE_VOLUME_DOWN", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)
        {
            Log.v(TAG, "up");
            Toast.makeText(this, "KEYCODE_VOLUME_UP", Toast.LENGTH_SHORT).show();
            return true;
        }
        else return super.onKeyDown(keyCode, event);
    }
}
