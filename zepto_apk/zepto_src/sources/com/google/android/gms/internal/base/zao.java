package com.google.android.gms.internal.base;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.internal.zabx;

/* loaded from: classes4.dex */
public final class zao extends ContextCompat {
    public static void g(Context context, zabx zabxVar, IntentFilter intentFilter) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            context.registerReceiver(zabxVar, intentFilter, i2 >= 33 ? 2 : 0);
        } else {
            context.registerReceiver(zabxVar, intentFilter);
        }
    }
}
