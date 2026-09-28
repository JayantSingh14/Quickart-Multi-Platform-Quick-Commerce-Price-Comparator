package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzkg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f39252a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39253b;

    public zzkg(zzli zzliVar, long j2) {
        this.f39252a = j2;
        Objects.requireNonNull(zzliVar);
        this.f39253b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        zzli zzliVar = this.f39253b;
        zzliVar.g();
        zzliVar.h();
        zzib zzibVar = zzliVar.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Resetting analytics data (FE)");
        zzob zzobVar = zzibVar.f39091h;
        zzib.k(zzobVar);
        zzobVar.g();
        zznz zznzVar = zzobVar.f39535f;
        zznzVar.f39527c.c();
        long jElapsedRealtime = zznzVar.f39528d.f39180a.f39094k.elapsedRealtime();
        zznzVar.f39525a = jElapsedRealtime;
        zznzVar.f39526b = jElapsedRealtime;
        zzibVar.q().l();
        boolean z = !zzibVar.a();
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzhgVar.f39025f.b(this.f39252a);
        zzib zzibVar2 = zzhgVar.f39180a;
        zzhg zzhgVar2 = zzibVar2.f39088e;
        zzib.j(zzhgVar2);
        if (!TextUtils.isEmpty(zzhgVar2.v.a())) {
            zzhgVar.v.b(null);
        }
        zzhgVar.p.b(0L);
        zzhgVar.q.b(0L);
        if (!zzibVar2.f39087d.t()) {
            zzhgVar.p(z);
        }
        zzhgVar.w.b(null);
        zzhgVar.x.b(0L);
        zzhgVar.y.b(null);
        zznk zznkVarO = zzibVar.o();
        zznkVarO.g();
        zznkVarO.h();
        zzr zzrVarW = zznkVarO.w(false);
        zznkVarO.s();
        zznkVarO.f39180a.n().k();
        zznkVarO.u(new zzmg(zznkVarO, zzrVarW));
        zzib.k(zzobVar);
        zzobVar.f39534e.a();
        zzliVar.s = z;
        zzibVar.o().k(new AtomicReference());
    }
}
