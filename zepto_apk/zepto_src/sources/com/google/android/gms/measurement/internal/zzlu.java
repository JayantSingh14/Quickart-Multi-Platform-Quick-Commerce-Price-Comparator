package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzlu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f39358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzlt f39359b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzlt f39360c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f39361d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzma f39362e;

    public zzlu(zzma zzmaVar, Bundle bundle, zzlt zzltVar, zzlt zzltVar2, long j2) {
        this.f39358a = bundle;
        this.f39359b = zzltVar;
        this.f39360c = zzltVar2;
        this.f39361d = j2;
        Objects.requireNonNull(zzmaVar);
        this.f39362e = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.f39362e;
        zzmaVar.getClass();
        Bundle bundle = this.f39358a;
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zzpo zzpoVar = zzmaVar.f39180a.f39092i;
        zzib.j(zzpoVar);
        zzmaVar.q(this.f39359b, this.f39360c, this.f39361d, true, zzpoVar.o("screen_view", bundle, null, false));
    }
}
