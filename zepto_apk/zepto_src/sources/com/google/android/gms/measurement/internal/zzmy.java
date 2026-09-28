package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes4.dex */
final class zzmy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f39457a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzne f39458b;

    public zzmy(zzne zzneVar, ComponentName componentName) {
        this.f39457a = componentName;
        this.f39458b = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39458b.f39470c.r(this.f39457a);
    }
}
