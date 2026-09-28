package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zznu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f39516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzob f39517b;

    public zznu(zzob zzobVar, long j2) {
        this.f39516a = j2;
        Objects.requireNonNull(zzobVar);
        this.f39517b = zzobVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzob zzobVar = this.f39517b;
        zzobVar.g();
        zzobVar.k();
        zzib zzibVar = zzobVar.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        long j2 = this.f39516a;
        zzgtVar.n.b(Long.valueOf(j2), "Activity paused, time");
        zznx zznxVar = zzobVar.f39536g;
        zzob zzobVar2 = zznxVar.f39523b;
        zznw zznwVar = new zznw(zznxVar, zzobVar2.f39180a.f39094k.currentTimeMillis(), j2);
        zznxVar.f39522a = zznwVar;
        zzobVar2.f39532c.postDelayed(zznwVar, 2000L);
        if (zzibVar.f39087d.u()) {
            zzobVar.f39535f.f39527c.c();
        }
    }
}
