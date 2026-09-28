package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzfo {

    /* renamed from: a, reason: collision with root package name */
    public final zzfn f31514a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdx f31515b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdx f31516c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31517d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f31518e;

    public zzfo(Context context, Looper looper, zzfc zzfcVar) {
        this.f31514a = new zzfn(context.getApplicationContext());
        this.f31515b = zzfcVar.a(looper, null);
        this.f31516c = zzfcVar.a(Looper.getMainLooper(), null);
    }

    public final void a(boolean z) {
        if (this.f31518e == z) {
            return;
        }
        this.f31518e = z;
        if (this.f31517d) {
            b(true, z);
        }
    }

    public final void b(final boolean z, final boolean z2) {
        boolean z3 = z && z2;
        zzdx zzdxVar = this.f31515b;
        if (z3) {
            zzdxVar.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f31348a.f31514a.a(z, z2);
                }
            });
            return;
        }
        final zzfn zzfnVar = this.f31514a;
        Objects.requireNonNull(zzfnVar);
        final Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfk
            @Override // java.lang.Runnable
            public final void run() {
                zzfn zzfnVar2 = zzfnVar;
                synchronized (zzfnVar2) {
                    PowerManager.WakeLock wakeLock = zzfnVar2.f31433b;
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                }
            }
        };
        this.f31516c.d(runnable);
        zzdxVar.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfo zzfoVar = this.f31380a;
                zzfoVar.f31516c.f(runnable);
                zzfoVar.f31514a.a(z, z2);
            }
        });
    }
}
