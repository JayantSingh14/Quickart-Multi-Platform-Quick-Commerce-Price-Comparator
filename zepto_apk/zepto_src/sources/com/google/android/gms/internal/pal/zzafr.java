package com.google.android.gms.internal.pal;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f37497a;

    public zzafr(Unsafe unsafe) {
        this.f37497a = unsafe;
    }

    public abstract double a(Object obj, long j2);

    public abstract float b(Object obj, long j2);

    public abstract void c(Object obj, long j2, boolean z);

    public abstract void d(Object obj, long j2, byte b2);

    public abstract void e(Object obj, long j2, double d2);

    public abstract void f(Object obj, long j2, float f2);

    public abstract boolean g(Object obj, long j2);

    public final int h(Class cls) {
        return this.f37497a.arrayBaseOffset(cls);
    }

    public final int i(Class cls) {
        return this.f37497a.arrayIndexScale(cls);
    }

    public final int j(long j2, Object obj) {
        return this.f37497a.getInt(obj, j2);
    }

    public final long k(long j2, Object obj) {
        return this.f37497a.getLong(obj, j2);
    }

    public final void l(Field field) {
        this.f37497a.objectFieldOffset(field);
    }

    public final Object m(long j2, Object obj) {
        return this.f37497a.getObject(obj, j2);
    }

    public final void n(Object obj, int i2, long j2) {
        this.f37497a.putInt(obj, j2, i2);
    }

    public final void o(Object obj, long j2, long j3) {
        this.f37497a.putLong(obj, j2, j3);
    }

    public final void p(Object obj, long j2, Object obj2) {
        this.f37497a.putObject(obj, j2, obj2);
    }
}
