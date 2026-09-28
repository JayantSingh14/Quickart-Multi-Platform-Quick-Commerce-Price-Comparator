package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class zzfg implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final zzdu f37723a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37724b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37725c;

    /* renamed from: d, reason: collision with root package name */
    public final zzr f37726d;

    /* renamed from: e, reason: collision with root package name */
    public Method f37727e;

    /* renamed from: f, reason: collision with root package name */
    public final int f37728f;

    /* renamed from: g, reason: collision with root package name */
    public final int f37729g;

    public zzfg(zzdu zzduVar, String str, String str2, zzr zzrVar, int i2, int i3) {
        this.f37723a = zzduVar;
        this.f37724b = str;
        this.f37725c = str2;
        this.f37726d = zzrVar;
        this.f37728f = i2;
        this.f37729g = i3;
    }

    public abstract void a();

    public void b() {
        int i2;
        zzdu zzduVar = this.f37723a;
        try {
            long jNanoTime = System.nanoTime();
            Method methodC = zzduVar.c(this.f37724b, this.f37725c);
            this.f37727e = methodC;
            if (methodC == null) {
                return;
            }
            a();
            zzcp zzcpVar = zzduVar.f37645l;
            if (zzcpVar == null || (i2 = this.f37728f) == Integer.MIN_VALUE) {
                return;
            }
            zzcpVar.a(this.f37729g, i2, (System.nanoTime() - jNanoTime) / 1000, null, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        b();
        return null;
    }
}
