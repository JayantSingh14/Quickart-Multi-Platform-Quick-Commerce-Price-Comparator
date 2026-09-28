package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* loaded from: classes.dex */
abstract class zzeq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f36917a;

    /* renamed from: b, reason: collision with root package name */
    public final long f36918b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f36919c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfb f36920d;

    public zzeq(zzfb zzfbVar, boolean z) {
        Objects.requireNonNull(zzfbVar);
        this.f36920d = zzfbVar;
        Clock clock = zzfbVar.f36944a;
        this.f36917a = clock.currentTimeMillis();
        this.f36918b = clock.elapsedRealtime();
        this.f36919c = z;
    }

    public abstract void a();

    public void b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfb zzfbVar = this.f36920d;
        if (zzfbVar.f36949f) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e2) {
            zzfbVar.k(e2, false, this.f36919c);
            b();
        }
    }
}
