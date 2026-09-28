package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
final class zzp extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (com.google.android.gms.ads.internal.util.client.zzl.f21429b) {
            com.google.android.gms.ads.internal.util.client.zzl.f21430c = false;
            com.google.android.gms.ads.internal.util.client.zzl.f21431d = false;
            com.google.android.gms.ads.internal.util.client.zzo.f("Ad debug logging enablement is out of date.");
        }
        zzd.a(context);
    }
}
