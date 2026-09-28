package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class zzs {

    /* renamed from: a, reason: collision with root package name */
    public final zzu f41991a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f41992b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41993c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f41994d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public zzr f41995e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f41996f = false;

    public zzs(zzu zzuVar, IntentFilter intentFilter, Context context) {
        this.f41991a = zzuVar;
        this.f41992b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.f41993c = applicationContext != null ? applicationContext : context;
    }

    public abstract void a(Context context, Intent intent);

    public final void b() {
        zzr zzrVar;
        if ((this.f41996f || !this.f41994d.isEmpty()) && this.f41995e == null) {
            zzr zzrVar2 = new zzr(this);
            this.f41995e = zzrVar2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f41993c.registerReceiver(zzrVar2, this.f41992b, 2);
            } else {
                this.f41993c.registerReceiver(zzrVar2, this.f41992b);
            }
        }
        if (this.f41996f || !this.f41994d.isEmpty() || (zzrVar = this.f41995e) == null) {
            return;
        }
        this.f41993c.unregisterReceiver(zzrVar);
        this.f41995e = null;
    }
}
