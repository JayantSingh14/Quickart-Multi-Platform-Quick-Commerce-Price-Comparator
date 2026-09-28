package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzcf extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcg f21561a;

    public zzcf(zzcg zzcgVar) {
        this.f21561a = zzcgVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzcg zzcgVar = this.f21561a;
        synchronized (zzcgVar) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : zzcgVar.f21563b.entrySet()) {
                    if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                        arrayList.add((BroadcastReceiver) entry.getKey());
                    }
                }
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((BroadcastReceiver) arrayList.get(i2)).onReceive(context, intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
