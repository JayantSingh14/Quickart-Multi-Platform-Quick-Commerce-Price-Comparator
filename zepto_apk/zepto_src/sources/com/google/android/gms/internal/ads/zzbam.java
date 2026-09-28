package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public final class zzbam implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final zzazt f24639a;

    /* renamed from: b, reason: collision with root package name */
    public final zzavs f24640b;

    public zzbam(zzazt zzaztVar, zzavs zzavsVar) {
        this.f24639a = zzaztVar;
        this.f24640b = zzavsVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws ExecutionException, InterruptedException {
        zzazt zzaztVar = this.f24639a;
        zzayt zzaytVar = zzaztVar.f24567j;
        if ((zzaytVar != null ? zzaytVar.f24514a : zzaztVar.f24566i) != null) {
            (zzaytVar != null ? zzaytVar.f24514a : zzaztVar.f24566i).get();
        }
        zzawp zzawpVarB = zzaztVar.b();
        if (zzawpVarB == null) {
            return null;
        }
        try {
            zzavs zzavsVar = this.f24640b;
            synchronized (zzavsVar) {
                byte[] bArrG = zzawpVarB.g();
                zziab zziabVar = zziab.f34620b;
                int i2 = zzhyy.f34536a;
                zzavsVar.i(bArrG, bArrG.length, zziab.f34621c);
            }
            return null;
        } catch (zzibg | NullPointerException unused) {
            return null;
        }
    }
}
