package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzhi {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f36423a;

    public zzhi(Unsafe unsafe) {
        this.f36423a = unsafe;
    }

    public abstract double a(Object obj, long j2);

    public abstract float b(Object obj, long j2);

    public abstract void c(Object obj, long j2, boolean z);

    public abstract void d(Object obj, long j2, double d2);

    public abstract void e(Object obj, long j2, float f2);

    public abstract boolean f(long j2, Object obj);
}
