package com.google.android.gms.internal.auth;

import java.security.AccessController;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzhj {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f36424a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f36425b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhi f36426c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f36427d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f36428e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f36429f;

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0164 A[PHI: r0
      0x0164: PHI (r0v39 java.lang.reflect.Field) = (r0v32 java.lang.reflect.Field), (r0v34 java.lang.reflect.Field) binds: [B:44:0x0154, B:50:0x0162] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhj.<clinit>():void");
    }

    public static int a(Object obj, long j2) {
        return f36426c.f36423a.getInt(obj, j2);
    }

    public static long b(Object obj, long j2) {
        return f36426c.f36423a.getLong(obj, j2);
    }

    public static Object c(Class cls) {
        try {
            return f36424a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object d(Object obj, long j2) {
        return f36426c.f36423a.getObject(obj, j2);
    }

    public static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhf());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void f(Object obj, long j2, boolean z) {
        zzhi zzhiVar = f36426c;
        long j3 = (-4) & j2;
        int i2 = zzhiVar.f36423a.getInt(obj, j3);
        int i3 = ((~((int) j2)) & 3) << 3;
        zzhiVar.f36423a.putInt(obj, j3, ((z ? 1 : 0) << i3) | ((~(255 << i3)) & i2));
    }

    public static /* synthetic */ void g(Object obj, long j2, boolean z) {
        zzhi zzhiVar = f36426c;
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        zzhiVar.f36423a.putInt(obj, j3, ((z ? 1 : 0) << i2) | ((~(255 << i2)) & zzhiVar.f36423a.getInt(obj, j3)));
    }

    public static void h(Object obj, int i2, long j2) {
        f36426c.f36423a.putInt(obj, j2, i2);
    }

    public static void i(Object obj, long j2, long j3) {
        f36426c.f36423a.putLong(obj, j2, j3);
    }

    public static void j(Object obj, long j2, Object obj2) {
        f36426c.f36423a.putObject(obj, j2, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean k(long j2, Object obj) {
        return ((byte) ((f36426c.f36423a.getInt(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean l(long j2, Object obj) {
        return ((byte) ((f36426c.f36423a.getInt(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }

    public static boolean m(Class cls) {
        int i2 = zzds.f36325a;
        try {
            Class cls2 = f36425b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void n(Class cls) {
        if (f36428e) {
            f36426c.f36423a.arrayBaseOffset(cls);
        }
    }

    public static void o(Class cls) {
        if (f36428e) {
            f36426c.f36423a.arrayIndexScale(cls);
        }
    }
}
