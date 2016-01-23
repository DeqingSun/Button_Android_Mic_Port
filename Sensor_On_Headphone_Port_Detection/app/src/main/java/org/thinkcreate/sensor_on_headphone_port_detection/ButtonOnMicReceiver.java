package org.thinkcreate.sensor_on_headphone_port_detection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class ButtonOnMicReceiver extends BroadcastReceiver {
    static final String TAG = "ButtonOnMicReceiver";
    static int counter = 0;

    public ButtonOnMicReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        Log.d(TAG, "onReceive");

        if (action.equals(Intent.ACTION_HEADSET_PLUG)) {
            //Toast.makeText(context, "earphones activity",Toast.LENGTH_SHORT).show();
            if (intent.getExtras().getInt("state")==1) {//if plugged
                Toast.makeText(context, "Headphone plugged", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Headphone plugged");
            } else {
                Toast.makeText(context, "Headphone un-plugged",Toast.LENGTH_LONG).show();
                Log.d(TAG, "Headphone un-plugged");
            }
            counter++;
        }else if (action.equals(Intent.ACTION_MEDIA_BUTTON)) {
            KeyEvent keyEvent  = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            //Log.d(TAG, keyEvent.toString());
            if (keyEvent != null) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP){
                    switch(keyEvent.getKeyCode()) {
                        case KeyEvent.KEYCODE_HEADSETHOOK:
                            Log.d(TAG, "KEYCODE_HEADSETHOOK");
                            counter++;
                            break;
                    }
                }
            }
        }else{
            Log.d(TAG, "unknown action: "+action);
        }
        Log.d(TAG, "count "+counter);

    }
}
