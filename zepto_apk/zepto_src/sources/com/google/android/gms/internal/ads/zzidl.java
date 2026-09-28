package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzidl {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f34766a;

    public zzidl(Unsafe unsafe) {
        this.f34766a = unsafe;
    }

    public abstract void a(Object obj, long j2, byte b2);

    public abstract boolean b(long j2, Object obj);

    public abstract void c(Object obj, long j2, boolean z);

    public abstract float d(long j2, Object obj);

    public abstract void e(Object obj, long j2, float f2);

    public abstract double f(long j2, Object obj);

    public abstract void g(Object obj, long j2, double d2);

    public abstract byte h(long j2);

    public abstract void i(long j2, byte[] bArr, long j3, long j4);
}
