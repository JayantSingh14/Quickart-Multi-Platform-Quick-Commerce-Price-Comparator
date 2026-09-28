package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class zzcg {

    /* renamed from: d, reason: collision with root package name */
    public boolean f21565d;

    /* renamed from: e, reason: collision with root package name */
    public Context f21566e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21564c = false;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f21563b = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final BroadcastReceiver f21562a = new zzcf(this);

    public final synchronized void a(Context context) {
        try {
            if (this.f21564c) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.f21566e = applicationContext;
            if (applicationContext == null) {
                this.f21566e = context;
            }
            zzbgk.a(this.f21566e);
            zzbgb zzbgbVar = zzbgk.x4;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            this.f21565d = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.fc)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                this.f21566e.registerReceiver(this.f21562a, intentFilter);
            } else {
                this.f21566e.registerReceiver(this.f21562a, intentFilter, 4);
            }
            this.f21564c = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f21565d) {
            this.f21563b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
