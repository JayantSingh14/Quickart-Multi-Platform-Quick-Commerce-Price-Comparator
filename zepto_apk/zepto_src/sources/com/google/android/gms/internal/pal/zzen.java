package com.google.android.gms.internal.pal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public final class zzen implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final zzdu f37697a;

    /* renamed from: b, reason: collision with root package name */
    public final zzr f37698b;

    public zzen(zzdu zzduVar, zzr zzrVar) {
        this.f37697a = zzduVar;
        this.f37698b = zzrVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws ExecutionException, InterruptedException {
        Future future = this.f37697a.f37644k;
        if (future != null) {
            future.get();
        }
        zzaf zzafVar = this.f37697a.f37643j;
        if (zzafVar == null) {
            return null;
        }
        try {
            synchronized (this.f37698b) {
                zzr zzrVar = this.f37698b;
                byte[] bArrF = zzafVar.F();
                zzrVar.f(bArrF, bArrF.length, zzacm.a());
            }
            return null;
        } catch (zzadi | NullPointerException unused) {
            return null;
        }
    }
}
