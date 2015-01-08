package com.hathy.ringtonerandomizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RingtoneHelper {

    public static List<Ringtone> fetchAvailableRingtones(Context context){

        List<Ringtone> ringtones = new ArrayList<>();
        RingtoneManager mgr = new RingtoneManager(context);
        mgr.setType(RingtoneManager.TYPE_RINGTONE);

        int n = mgr.getCursor().getCount();
        for(int i=0;i<n;i++){
            ringtones.add(mgr.getRingtone(i));
        }

        return  ringtones;
    }

    public static void changeRingtone(Context context){

        SharedPreferences preferences = context.getSharedPreferences("randomizer", Context.MODE_PRIVATE);
        if(!preferences.getBoolean("active", false))
            return;

        RingtoneManager mgr = new RingtoneManager(context);
        Random random = new Random(System.currentTimeMillis());

        int n = random.nextInt(mgr.getCursor().getCount());

        RingtoneManager.setActualDefaultRingtoneUri(context,
                RingtoneManager.TYPE_RINGTONE, mgr.getRingtoneUri(n));
    }

}
