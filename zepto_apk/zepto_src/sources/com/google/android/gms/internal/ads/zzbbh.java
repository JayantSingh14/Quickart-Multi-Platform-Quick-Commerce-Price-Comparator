package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class zzbbh implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final zzazt f24669a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24670b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24671c;

    /* renamed from: d, reason: collision with root package name */
    public final zzavs f24672d;

    /* renamed from: e, reason: collision with root package name */
    public Method f24673e;

    /* renamed from: f, reason: collision with root package name */
    public final int f24674f;

    /* renamed from: g, reason: collision with root package name */
    public final int f24675g;

    public zzbbh(zzazt zzaztVar, String str, String str2, zzavs zzavsVar, int i2, int i3) {
        this.f24669a = zzaztVar;
        this.f24670b = str;
        this.f24671c = str2;
        this.f24672d = zzavsVar;
        this.f24674f = i2;
        this.f24675g = i3;
    }

    public abstract void a();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i2;
        try {
            long jNanoTime = System.nanoTime();
            zzazt zzaztVar = this.f24669a;
            Method methodD = zzaztVar.d(this.f24670b, this.f24671c);
            this.f24673e = methodD;
            if (methodD == null) {
                return null;
            }
            a();
            zzayk zzaykVar = zzaztVar.f24568k;
            if (zzaykVar == null || (i2 = this.f24674f) == Integer.MIN_VALUE) {
                return null;
            }
            zzaykVar.a(this.f24675g, i2, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
