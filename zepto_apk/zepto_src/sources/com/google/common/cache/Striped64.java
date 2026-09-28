package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
abstract class Striped64 extends Number {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f42441d = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    public static final Random f42442e = new Random();

    /* renamed from: f, reason: collision with root package name */
    public static final int f42443f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g, reason: collision with root package name */
    public static final Unsafe f42444g;

    /* renamed from: h, reason: collision with root package name */
    public static final long f42445h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f42446i;

    /* renamed from: a, reason: collision with root package name */
    public volatile transient Cell[] f42447a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient long f42448b;

    /* renamed from: c, reason: collision with root package name */
    public volatile transient int f42449c;

    /* renamed from: com.google.common.cache.Striped64$1, reason: invalid class name */
    class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() {
            return a();
        }
    }

    public static final class Cell {

        /* renamed from: b, reason: collision with root package name */
        public static final Unsafe f42450b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f42451c;

        /* renamed from: a, reason: collision with root package name */
        public volatile long f42452a;

        static {
            try {
                Unsafe unsafeE = Striped64.e();
                f42450b = unsafeE;
                f42451c = unsafeE.objectFieldOffset(Cell.class.getDeclaredField("a"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        public Cell(long j2) {
            this.f42452a = j2;
        }

        public final boolean a(long j2, long j3) {
            return f42450b.compareAndSwapLong(this, f42451c, j2, j3);
        }
    }

    static {
        try {
            Unsafe unsafeE = e();
            f42444g = unsafeE;
            f42445h = unsafeE.objectFieldOffset(Striped64.class.getDeclaredField("b"));
            f42446i = unsafeE.objectFieldOffset(Striped64.class.getDeclaredField("c"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public static Unsafe e() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
        }
    }

    public final boolean c(long j2, long j3) {
        return f42444g.compareAndSwapLong(this, f42445h, j2, j3);
    }

    public final boolean d() {
        return f42444g.compareAndSwapInt(this, f42446i, 0, 1);
    }
}
