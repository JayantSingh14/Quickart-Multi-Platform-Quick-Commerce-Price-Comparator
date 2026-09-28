package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzoa {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzob f39531a;

    public zzoa(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.f39531a = zzobVar;
    }

    public final void a() {
        zzob zzobVar = this.f39531a;
        zzobVar.g();
        zzib zzibVar = zzobVar.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        Clock clock = zzibVar.f39094k;
        if (zzhgVar.q(clock.currentTimeMillis())) {
            zzhg zzhgVar2 = zzibVar.f39088e;
            zzib.j(zzhgVar2);
            zzhgVar2.f39031l.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.n.a("Detected application was in foreground");
                c(clock.currentTimeMillis());
            }
        }
    }

    public final void b(long j2) {
        zzob zzobVar = this.f39531a;
        zzobVar.g();
        zzobVar.k();
        zzib zzibVar = zzobVar.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        boolean zQ = zzhgVar.q(j2);
        zzhg zzhgVar2 = zzibVar.f39088e;
        if (zQ) {
            zzib.j(zzhgVar2);
            zzhgVar2.f39031l.b(true);
            zzibVar.q().l();
        }
        zzib.j(zzhgVar2);
        zzhgVar2.p.b(j2);
        if (zzhgVar2.f39031l.a()) {
            c(j2);
        }
    }

    public final void c(long j2) {
        zzob zzobVar = this.f39531a;
        zzobVar.g();
        zzib zzibVar = zzobVar.f39180a;
        if (zzibVar.a()) {
            zzhg zzhgVar = zzibVar.f39088e;
            zzib.j(zzhgVar);
            zzhgVar.p.b(j2);
            long jElapsedRealtime = zzibVar.f39094k.elapsedRealtime();
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.b(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j3 = j2 / 1000;
            Long lValueOf = Long.valueOf(j3);
            zzli zzliVar = zzibVar.f39096m;
            zzib.k(zzliVar);
            zzliVar.s(j2, lValueOf, "auto", "_sid");
            zzib.j(zzhgVar);
            zzhgVar.q.b(j3);
            zzhgVar.f39031l.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j3);
            zzib.k(zzliVar);
            zzliVar.p(j2, bundle, "auto", "_s");
            String strA = zzhgVar.v.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strA);
            zzib.k(zzliVar);
            zzliVar.p(j2, bundle2, "auto", "_ssr");
        }
    }
}
