package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes4.dex */
final class zzna implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzne f39463a;

    public zzna(zzne zzneVar) {
        this.f39463a = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39463a.f39470c;
        zznkVar.r(new ComponentName(zznkVar.f39180a.f39084a, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
