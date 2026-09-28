package com.google.android.gms.internal.pal;

import java.security.AccessController;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzafs {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f37498a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f37499b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzafr f37500c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f37501d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f37502e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f37503f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f37504g;

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168 A[PHI: r0
      0x0168: PHI (r0v40 java.lang.reflect.Field) = (r0v34 java.lang.reflect.Field), (r0v36 java.lang.reflect.Field) binds: [B:44:0x0158, B:50:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzafs.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f37502e) {
            f37500c.i(cls);
        }
    }

    public static void b(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        zzafr zzafrVar = f37500c;
        int iJ = zzafrVar.j(j3, obj);
        int i2 = ((~((int) j2)) & 3) << 3;
        zzafrVar.n(obj, ((255 & b2) << i2) | (iJ & (~(255 << i2))), j3);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        zzafr zzafrVar = f37500c;
        int i2 = (((int) j2) & 3) << 3;
        zzafrVar.n(obj, ((255 & b2) << i2) | (zzafrVar.j(j3, obj) & (~(255 << i2))), j3);
    }

    public static Object d(Class cls) {
        try {
            return f37498a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzafo());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(Object obj, long j2, int i2) {
        f37500c.n(obj, i2, j2);
    }

    public static void g(Object obj, long j2, long j3) {
        f37500c.o(obj, j2, j3);
    }

    public static void h(Object obj, long j2, Object obj2) {
        f37500c.p(obj, j2, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean i(Object obj, long j2) {
        return ((byte) ((f37500c.j((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean j(Object obj, long j2) {
        return ((byte) ((f37500c.j((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }

    public static boolean k(Class cls) {
        int i2 = zzabk.f37351a;
        try {
            Class cls2 = f37499b;
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

    public static int l(Class cls) {
        if (f37502e) {
            return f37500c.h(cls);
        }
        return -1;
    }
}
