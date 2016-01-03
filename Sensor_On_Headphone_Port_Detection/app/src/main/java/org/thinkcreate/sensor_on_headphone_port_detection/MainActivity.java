package org.thinkcreate.sensor_on_headphone_port_detection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

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
}
