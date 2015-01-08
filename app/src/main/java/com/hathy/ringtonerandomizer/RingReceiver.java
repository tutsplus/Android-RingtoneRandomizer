package com.hathy.ringtonerandomizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class RingReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String callState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (callState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                RingtoneHelper.changeRingtone(context);
            }
        }
    }
}
