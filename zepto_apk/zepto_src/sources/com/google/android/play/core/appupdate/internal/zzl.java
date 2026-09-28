package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class zzl {

    /* renamed from: a, reason: collision with root package name */
    public final zzm f41682a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f41683b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41684c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f41685d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public zzk f41686e = null;

    public zzl(zzm zzmVar, IntentFilter intentFilter, Context context) {
        this.f41682a = zzmVar;
        this.f41683b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.f41684c = applicationContext != null ? applicationContext : context;
    }

    public abstract void a(Context context, Intent intent);

    public final void b() {
        zzk zzkVar;
        HashSet hashSet = this.f41685d;
        boolean zIsEmpty = hashSet.isEmpty();
        Context context = this.f41684c;
        if (!zIsEmpty && this.f41686e == null) {
            zzk zzkVar2 = new zzk(this);
            this.f41686e = zzkVar2;
            int i2 = Build.VERSION.SDK_INT;
            IntentFilter intentFilter = this.f41683b;
            if (i2 >= 33) {
                context.registerReceiver(zzkVar2, intentFilter, 2);
            } else {
                context.registerReceiver(zzkVar2, intentFilter);
            }
        }
        if (!hashSet.isEmpty() || (zzkVar = this.f41686e) == null) {
            return;
        }
        context.unregisterReceiver(zzkVar);
        this.f41686e = null;
    }
}
