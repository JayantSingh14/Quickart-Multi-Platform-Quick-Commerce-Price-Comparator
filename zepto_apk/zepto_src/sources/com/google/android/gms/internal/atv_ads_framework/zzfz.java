package com.google.android.gms.internal.atv_ads_framework;

import java.security.AccessController;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzfz {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f36210a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f36211b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzfy f36212c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f36213d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f36214e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f36215f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f36216g;

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168 A[PHI: r0
      0x0168: PHI (r0v41 java.lang.reflect.Field) = (r0v34 java.lang.reflect.Field), (r0v36 java.lang.reflect.Field) binds: [B:44:0x0158, B:50:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzfz.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f36214e) {
            f36212c.f36209a.arrayIndexScale(cls);
        }
    }

    public static void b(Object obj, long j2, byte b2) {
        zzfy zzfyVar = f36212c;
        long j3 = (-4) & j2;
        int i2 = zzfyVar.f36209a.getInt(obj, j3);
        int i3 = ((~((int) j2)) & 3) << 3;
        zzfyVar.f36209a.putInt(obj, j3, ((255 & b2) << i3) | (i2 & (~(255 << i3))));
    }

    public static void c(Object obj, long j2, byte b2) {
        zzfy zzfyVar = f36212c;
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        zzfyVar.f36209a.putInt(obj, j3, ((255 & b2) << i2) | (zzfyVar.f36209a.getInt(obj, j3) & (~(255 << i2))));
    }

    public static int d(Object obj, long j2) {
        return f36212c.f36209a.getInt(obj, j2);
    }

    public static long e(Object obj, long j2) {
        return f36212c.f36209a.getLong(obj, j2);
    }

    public static Object f(Class cls) {
        try {
            return f36210a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object g(Object obj, long j2) {
        return f36212c.f36209a.getObject(obj, j2);
    }

    public static Unsafe h() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfv());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(Object obj, long j2, int i2) {
        f36212c.f36209a.putInt(obj, j2, i2);
    }

    public static void j(Object obj, long j2, long j3) {
        f36212c.f36209a.putLong(obj, j2, j3);
    }

    public static void k(Object obj, long j2, Object obj2) {
        f36212c.f36209a.putObject(obj, j2, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean l(Object obj, long j2) {
        return ((byte) ((f36212c.f36209a.getInt(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean m(Object obj, long j2) {
        return ((byte) ((f36212c.f36209a.getInt(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }

    public static boolean n(Class cls) {
        int i2 = zzcc.f36089a;
        try {
            Class cls2 = f36211b;
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

    public static int o(Class cls) {
        if (f36214e) {
            return f36212c.f36209a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
