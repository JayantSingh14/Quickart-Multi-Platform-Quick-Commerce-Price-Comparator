package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class Striped64 extends Number {

    /* renamed from: a, reason: collision with root package name */
    public volatile transient long f43219a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient int f43220b;

    /* renamed from: com.google.common.hash.Striped64$1, reason: invalid class name */
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

        /* renamed from: a, reason: collision with root package name */
        public volatile long f43221a;

        static {
            try {
                Striped64.a().objectFieldOffset(Cell.class.getDeclaredField("a"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }
    }

    static {
        new ThreadLocal();
        new Random();
        Runtime.getRuntime().availableProcessors();
        try {
            Unsafe unsafeA = a();
            unsafeA.objectFieldOffset(Striped64.class.getDeclaredField("a"));
            unsafeA.objectFieldOffset(Striped64.class.getDeclaredField("b"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public static Unsafe a() {
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
}
