package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
abstract class zzon {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f37193a;

    public zzon(Unsafe unsafe) {
        this.f37193a = unsafe;
    }

    public abstract void a(Object obj, long j2, byte b2);

    public abstract boolean b(long j2, Object obj);

    public abstract void c(Object obj, long j2, boolean z);

    public abstract float d(long j2, Object obj);

    public abstract void e(Object obj, long j2, float f2);

    public abstract double f(long j2, Object obj);

    public abstract void g(Object obj, long j2, double d2);
}
