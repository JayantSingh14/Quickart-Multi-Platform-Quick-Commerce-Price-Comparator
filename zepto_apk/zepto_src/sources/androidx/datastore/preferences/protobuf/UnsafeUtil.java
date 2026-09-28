package androidx.datastore.preferences.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class UnsafeUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f4181a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f4182b;

    /* renamed from: c, reason: collision with root package name */
    public static final MemoryAccessor f4183c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f4184d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f4185e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f4186f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f4187g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f4188h;

    /* renamed from: androidx.datastore.preferences.protobuf.UnsafeUtil$1, reason: invalid class name */
    class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() {
            return a();
        }
    }

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void d(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean e(long j2, Object obj) {
            return UnsafeUtil.f4188h ? UnsafeUtil.i(j2, obj) != 0 : UnsafeUtil.j(j2, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte f(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte g(long j2, Object obj) {
            return UnsafeUtil.f4188h ? UnsafeUtil.i(j2, obj) : UnsafeUtil.j(j2, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final double h(long j2, Object obj) {
            return Double.longBitsToDouble(l(j2, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final float i(long j2, Object obj) {
            return Float.intBitsToFloat(j(j2, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final long k(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void o(Object obj, long j2, boolean z) {
            if (UnsafeUtil.f4188h) {
                UnsafeUtil.n(obj, j2, z ? (byte) 1 : (byte) 0);
            } else {
                UnsafeUtil.o(obj, j2, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void p(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void q(Object obj, long j2, byte b2) {
            if (UnsafeUtil.f4188h) {
                UnsafeUtil.n(obj, j2, b2);
            } else {
                UnsafeUtil.o(obj, j2, b2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void r(Object obj, long j2, double d2) {
            u(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void s(Object obj, long j2, float f2) {
            t(obj, Float.floatToIntBits(f2), j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean x() {
            return false;
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void d(byte[] bArr, long j2, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean e(long j2, Object obj) {
            return UnsafeUtil.f4188h ? UnsafeUtil.i(j2, obj) != 0 : UnsafeUtil.j(j2, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte f(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte g(long j2, Object obj) {
            return UnsafeUtil.f4188h ? UnsafeUtil.i(j2, obj) : UnsafeUtil.j(j2, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final double h(long j2, Object obj) {
            return Double.longBitsToDouble(l(j2, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final float i(long j2, Object obj) {
            return Float.intBitsToFloat(j(j2, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final long k(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void o(Object obj, long j2, boolean z) {
            if (UnsafeUtil.f4188h) {
                UnsafeUtil.n(obj, j2, z ? (byte) 1 : (byte) 0);
            } else {
                UnsafeUtil.o(obj, j2, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void p(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void q(Object obj, long j2, byte b2) {
            if (UnsafeUtil.f4188h) {
                UnsafeUtil.n(obj, j2, b2);
            } else {
                UnsafeUtil.o(obj, j2, b2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void r(Object obj, long j2, double d2) {
            u(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void s(Object obj, long j2, float f2) {
            t(obj, Float.floatToIntBits(f2), j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean x() {
            return false;
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void c(long j2, byte[] bArr, long j3, long j4) {
            this.f4189a.copyMemory((Object) null, j2, bArr, UnsafeUtil.f4186f + j3, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void d(byte[] bArr, long j2, long j3, long j4) {
            this.f4189a.copyMemory(bArr, UnsafeUtil.f4186f + j2, (Object) null, j3, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean e(long j2, Object obj) {
            return this.f4189a.getBoolean(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte f(long j2) {
            return this.f4189a.getByte(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final byte g(long j2, Object obj) {
            return this.f4189a.getByte(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final double h(long j2, Object obj) {
            return this.f4189a.getDouble(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final float i(long j2, Object obj) {
            return this.f4189a.getFloat(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final long k(long j2) {
            return this.f4189a.getLong(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void o(Object obj, long j2, boolean z) {
            this.f4189a.putBoolean(obj, j2, z);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void p(long j2, byte b2) {
            this.f4189a.putByte(j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void q(Object obj, long j2, byte b2) {
            this.f4189a.putByte(obj, j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void r(Object obj, long j2, double d2) {
            this.f4189a.putDouble(obj, j2, d2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final void s(Object obj, long j2, float f2) {
            this.f4189a.putFloat(obj, j2, f2);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean w() {
            if (!super.w()) {
                return false;
            }
            try {
                Class<?> cls = this.f4189a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.a(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean x() {
            if (!super.x()) {
                return false;
            }
            try {
                Class<?> cls = this.f4189a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.a(th);
                return false;
            }
        }
    }

    public static abstract class MemoryAccessor {

        /* renamed from: a, reason: collision with root package name */
        public final Unsafe f4189a;

        public MemoryAccessor(Unsafe unsafe) {
            this.f4189a = unsafe;
        }

        public final int a(Class cls) {
            return this.f4189a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f4189a.arrayIndexScale(cls);
        }

        public abstract void c(long j2, byte[] bArr, long j3, long j4);

        public abstract void d(byte[] bArr, long j2, long j3, long j4);

        public abstract boolean e(long j2, Object obj);

        public abstract byte f(long j2);

        public abstract byte g(long j2, Object obj);

        public abstract double h(long j2, Object obj);

        public abstract float i(long j2, Object obj);

        public final int j(long j2, Object obj) {
            return this.f4189a.getInt(obj, j2);
        }

        public abstract long k(long j2);

        public final long l(long j2, Object obj) {
            return this.f4189a.getLong(obj, j2);
        }

        public final Object m(long j2, Object obj) {
            return this.f4189a.getObject(obj, j2);
        }

        public final long n(java.lang.reflect.Field field) {
            return this.f4189a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j2, boolean z);

        public abstract void p(long j2, byte b2);

        public abstract void q(Object obj, long j2, byte b2);

        public abstract void r(Object obj, long j2, double d2);

        public abstract void s(Object obj, long j2, float f2);

        public final void t(Object obj, int i2, long j2) {
            this.f4189a.putInt(obj, j2, i2);
        }

        public final void u(Object obj, long j2, long j3) {
            this.f4189a.putLong(obj, j2, j3);
        }

        public final void v(Object obj, long j2, Object obj2) {
            this.f4189a.putObject(obj, j2, obj2);
        }

        public boolean w() {
            Unsafe unsafe = this.f4189a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.a(th);
                return false;
            }
        }

        public boolean x() {
            Unsafe unsafe = this.f4189a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return UnsafeUtil.f() != null;
            } catch (Throwable th) {
                UnsafeUtil.a(th);
                return false;
            }
        }
    }

    static {
        Unsafe unsafeK = k();
        f4181a = unsafeK;
        f4182b = Android.f3733a;
        boolean zG = g(Long.TYPE);
        boolean zG2 = g(Integer.TYPE);
        MemoryAccessor jvmMemoryAccessor = null;
        if (unsafeK != null) {
            if (!Android.a()) {
                jvmMemoryAccessor = new JvmMemoryAccessor(unsafeK);
            } else if (zG) {
                jvmMemoryAccessor = new Android64MemoryAccessor(unsafeK);
            } else if (zG2) {
                jvmMemoryAccessor = new Android32MemoryAccessor(unsafeK);
            }
        }
        f4183c = jvmMemoryAccessor;
        f4184d = jvmMemoryAccessor == null ? false : jvmMemoryAccessor.x();
        f4185e = jvmMemoryAccessor == null ? false : jvmMemoryAccessor.w();
        f4186f = d(byte[].class);
        d(boolean[].class);
        e(boolean[].class);
        d(int[].class);
        e(int[].class);
        d(long[].class);
        e(long[].class);
        d(float[].class);
        e(float[].class);
        d(double[].class);
        e(double[].class);
        d(Object[].class);
        e(Object[].class);
        java.lang.reflect.Field fieldF = f();
        f4187g = (fieldF == null || jvmMemoryAccessor == null) ? -1L : jvmMemoryAccessor.n(fieldF);
        f4188h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static long b(ByteBuffer byteBuffer) {
        return f4183c.l(f4187g, byteBuffer);
    }

    public static Object c(Class cls) {
        try {
            return f4181a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int d(Class cls) {
        if (f4185e) {
            return f4183c.a(cls);
        }
        return -1;
    }

    public static void e(Class cls) {
        if (f4185e) {
            f4183c.b(cls);
        }
    }

    public static java.lang.reflect.Field f() {
        java.lang.reflect.Field declaredField;
        java.lang.reflect.Field declaredField2;
        if (Android.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean g(Class cls) {
        if (!Android.a()) {
            return false;
        }
        try {
            Class cls2 = f4182b;
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

    public static byte h(long j2, byte[] bArr) {
        return f4183c.g(f4186f + j2, bArr);
    }

    public static byte i(long j2, Object obj) {
        return (byte) ((f4183c.j((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte j(long j2, Object obj) {
        return (byte) ((f4183c.j((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void l(long j2, byte b2) {
        f4183c.p(j2, b2);
    }

    public static void m(byte[] bArr, long j2, byte b2) {
        f4183c.q(bArr, f4186f + j2, b2);
    }

    public static void n(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iJ = f4183c.j(j3, obj);
        int i2 = ((~((int) j2)) & 3) << 3;
        p(obj, ((255 & b2) << i2) | (iJ & (~(255 << i2))), j3);
    }

    public static void o(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        p(obj, ((255 & b2) << i2) | (f4183c.j(j3, obj) & (~(255 << i2))), j3);
    }

    public static void p(Object obj, int i2, long j2) {
        f4183c.t(obj, i2, j2);
    }

    public static void q(Object obj, long j2, long j3) {
        f4183c.u(obj, j2, j3);
    }

    public static void r(Object obj, long j2, Object obj2) {
        f4183c.v(obj, j2, obj2);
    }
}
