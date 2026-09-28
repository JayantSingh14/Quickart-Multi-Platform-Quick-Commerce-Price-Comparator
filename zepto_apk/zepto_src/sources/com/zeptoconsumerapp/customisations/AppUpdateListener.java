package com.zeptoconsumerapp.customisations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zeptoconsumerapp.Utils;
import java.io.File;

/* loaded from: classes4.dex */
public class AppUpdateListener extends BroadcastReceiver {
    public static boolean a(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (a(new File(file, str))) {
                    }
                }
                return file.delete();
            }
        } else if (file != null && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Utils.i(new Throwable("On Receive"));
        if (intent == null || !"android.intent.action.MY_PACKAGE_REPLACED".equals(intent.getAction())) {
            return;
        }
        try {
            a(context.getCacheDir());
            Utils.i(new Throwable("Deleted cache successfully"));
        } catch (Exception e2) {
            Utils.i(e2);
        }
    }
}
