package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* loaded from: classes.dex */
final class zznz {

    /* renamed from: a, reason: collision with root package name */
    public long f39525a;

    /* renamed from: b, reason: collision with root package name */
    public long f39526b;

    /* renamed from: c, reason: collision with root package name */
    public final zzny f39527c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzob f39528d;

    public zznz(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.f39528d = zzobVar;
        zzib zzibVar = zzobVar.f39180a;
        this.f39527c = new zzny(this, zzibVar);
        long jElapsedRealtime = zzibVar.f39094k.elapsedRealtime();
        this.f39525a = jElapsedRealtime;
        this.f39526b = jElapsedRealtime;
    }

    public final boolean a(long j2, boolean z, boolean z2) {
        zzob zzobVar = this.f39528d;
        zzobVar.g();
        zzobVar.h();
        zzib zzibVar = zzobVar.f39180a;
        if (zzibVar.a()) {
            zzhg zzhgVar = zzibVar.f39088e;
            zzib.j(zzhgVar);
            zzhgVar.p.b(zzibVar.f39094k.currentTimeMillis());
        }
        long j3 = j2 - this.f39525a;
        zzgt zzgtVar = zzibVar.f39089f;
        if (!z && j3 < 1000) {
            zzib.l(zzgtVar);
            zzgtVar.n.b(Long.valueOf(j3), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z2) {
            j3 = j2 - this.f39526b;
            this.f39526b = j2;
        }
        zzib.l(zzgtVar);
        zzgtVar.n.b(Long.valueOf(j3), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j3);
        boolean z3 = !zzibVar.f39087d.u();
        zzma zzmaVar = zzibVar.f39095l;
        zzib.k(zzmaVar);
        zzpo.W(zzmaVar.m(z3), bundle, true);
        if (!z2) {
            zzli zzliVar = zzibVar.f39096m;
            zzib.k(zzliVar);
            zzliVar.o("auto", "_e", bundle);
        }
        this.f39525a = j2;
        zzny zznyVar = this.f39527c;
        zznyVar.c();
        zznyVar.b(((Long) zzfx.q0.a(null)).longValue());
        return true;
    }
}
