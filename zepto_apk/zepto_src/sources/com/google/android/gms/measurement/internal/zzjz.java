package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f39228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39229b;

    public zzjz(zzli zzliVar, long j2) {
        this.f39228a = j2;
        Objects.requireNonNull(zzliVar);
        this.f39229b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar = this.f39229b.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzhd zzhdVar = zzhgVar.f39030k;
        long j2 = this.f39228a;
        zzhdVar.b(j2);
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.b(Long.valueOf(j2), "Session timeout duration set");
    }
}
