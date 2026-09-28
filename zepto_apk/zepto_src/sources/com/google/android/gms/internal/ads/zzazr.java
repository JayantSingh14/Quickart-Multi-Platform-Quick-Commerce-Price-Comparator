package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
final class zzazr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24555a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzazt f24556b;

    public zzazr(zzazt zzaztVar, int i2) {
        this.f24555a = i2;
        Objects.requireNonNull(zzaztVar);
        this.f24556b = zzaztVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        zzawp zzawpVarA;
        int i2 = this.f24555a;
        zzazt zzaztVar = this.f24556b;
        if (i2 > 0) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzaztVar.f24558a;
            zzawpVarA = zzfum.a(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzawpVarA = null;
        }
        zzazt zzaztVar2 = this.f24556b;
        zzaztVar2.f24565h = zzawpVarA;
        int i3 = this.f24555a;
        if (i3 < 4) {
            if (zzawpVarA != null && zzawpVarA.c0() && !zzawpVarA.y0().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzawpVarA.C0() && zzawpVarA.D0().C() && zzawpVarA.D0().D() != -2) {
                return;
            }
            int i4 = i3 + 1;
            if (zzaztVar2.f24569l) {
                Future<?> futureSubmit = zzaztVar2.f24559b.submit(new zzazr(zzaztVar2, i4));
                if (i4 == 0) {
                    zzaztVar2.f24566i = futureSubmit;
                }
            }
        }
    }
}
