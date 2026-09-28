package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzds implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f37631a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdu f37632b;

    public zzds(zzdu zzduVar, int i2) {
        this.f37632b = zzduVar;
        this.f37631a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        zzaf zzafVarA;
        zzdu zzduVar = this.f37632b;
        if (this.f37631a > 0) {
            try {
                Thread.sleep(r1 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        zzaf zzafVar = null;
        try {
            PackageInfo packageInfo = zzduVar.f37634a.getPackageManager().getPackageInfo(zzduVar.f37634a.getPackageName(), 0);
            Context context = zzduVar.f37634a;
            try {
                zzafVarA = (zzaf) new zzhe(context, context.getPackageName(), Integer.toString(packageInfo.versionCode)).f37790d.poll(5000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused2) {
                zzafVarA = null;
            }
            if (zzafVarA == null) {
                zzafVarA = zzhe.a();
            }
            zzafVar = zzafVarA;
        } catch (Throwable unused3) {
        }
        this.f37632b.f37643j = zzafVar;
        if (this.f37631a < 4) {
            if (zzafVar != null && zzafVar.Z() && !zzafVar.j0().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzafVar.a0() && zzafVar.i0().r() && zzafVar.i0().p() != -2) {
                return;
            }
            zzdu zzduVar2 = this.f37632b;
            int i2 = this.f37631a + 1;
            if (zzduVar2.n) {
                Future<?> futureSubmit = zzduVar2.f37635b.submit(new zzds(zzduVar2, i2));
                if (i2 == 0) {
                    zzduVar2.f37644k = futureSubmit;
                }
            }
        }
    }
}
