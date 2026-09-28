package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzidm {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f34767a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f34768b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzidl f34769c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f34770d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f34771e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f34772f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f34773g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f34774h;

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168 A[PHI: r0
      0x0168: PHI (r0v43 java.lang.reflect.Field) = (r0v34 java.lang.reflect.Field), (r0v36 java.lang.reflect.Field) binds: [B:44:0x0158, B:50:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzidm.<clinit>():void");
    }

    public static int a(Class cls) {
        if (f34771e) {
            return f34769c.f34766a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (f34771e) {
            f34769c.f34766a.arrayIndexScale(cls);
        }
    }

    public static void c(Object obj, long j2, byte b2) {
        Unsafe unsafe = f34769c.f34766a;
        long j3 = (-4) & j2;
        int i2 = unsafe.getInt(obj, j3);
        int i3 = ((~((int) j2)) & 3) << 3;
        unsafe.putInt(obj, j3, ((255 & b2) << i3) | (i2 & (~(255 << i3))));
    }

    public static void d(Object obj, long j2, byte b2) {
        Unsafe unsafe = f34769c.f34766a;
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        unsafe.putInt(obj, j3, ((255 & b2) << i2) | (unsafe.getInt(obj, j3) & (~(255 << i2))));
    }

    public static Object e(Class cls) {
        try {
            return f34767a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int f(long j2, Object obj) {
        return f34769c.f34766a.getInt(obj, j2);
    }

    public static void g(Object obj, int i2, long j2) {
        f34769c.f34766a.putInt(obj, j2, i2);
    }

    public static long h(long j2, Object obj) {
        return f34769c.f34766a.getLong(obj, j2);
    }

    public static void i(Object obj, long j2, long j3) {
        f34769c.f34766a.putLong(obj, j2, j3);
    }

    public static Object j(long j2, Object obj) {
        return f34769c.f34766a.getObject(obj, j2);
    }

    public static void k(Object obj, long j2, Object obj2) {
        f34769c.f34766a.putObject(obj, j2, obj2);
    }

    public static void l(byte[] bArr, long j2, byte b2) {
        f34769c.a(bArr, f34772f + j2, b2);
    }

    public static long m(ByteBuffer byteBuffer) {
        return f34769c.f34766a.getLong(byteBuffer, f34773g);
    }

    public static Unsafe n() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzidi());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean o(Class cls) {
        int i2 = zzhyy.f34536a;
        try {
            Class cls2 = f34768b;
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

    public static /* synthetic */ boolean p(long j2, Object obj) {
        return ((byte) ((f34769c.f34766a.getInt(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean q(long j2, Object obj) {
        return ((byte) ((f34769c.f34766a.getInt(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }
}
