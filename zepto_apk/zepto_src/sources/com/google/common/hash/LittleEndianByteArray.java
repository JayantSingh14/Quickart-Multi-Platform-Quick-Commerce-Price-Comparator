package com.google.common.hash;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class LittleEndianByteArray {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class JavaLittleEndianBytes implements LittleEndianBytes {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43210a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ JavaLittleEndianBytes[] f43211b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes$1] */
        static {
            ?? r0 = new JavaLittleEndianBytes() { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            };
            f43210a = r0;
            f43211b = new JavaLittleEndianBytes[]{r0};
        }

        public static JavaLittleEndianBytes valueOf(String str) {
            return (JavaLittleEndianBytes) Enum.valueOf(JavaLittleEndianBytes.class, str);
        }

        public static JavaLittleEndianBytes[] values() {
            return (JavaLittleEndianBytes[]) f43211b.clone();
        }
    }

    public interface LittleEndianBytes {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class UnsafeByteArray implements LittleEndianBytes {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43212a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f43213b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ UnsafeByteArray[] f43214c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1] */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2] */
        static {
            ?? r1 = new UnsafeByteArray() { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            };
            f43212a = r1;
            ?? r2 = new UnsafeByteArray() { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            };
            f43213b = r2;
            f43214c = new UnsafeByteArray[]{r1, r2};
            Unsafe unsafeA = a();
            unsafeA.arrayBaseOffset(byte[].class);
            if (unsafeA.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
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
                return (Unsafe) AccessController.doPrivileged(new a());
            }
        }

        public static /* synthetic */ Unsafe b() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        public static UnsafeByteArray valueOf(String str) {
            return (UnsafeByteArray) Enum.valueOf(UnsafeByteArray.class, str);
        }

        public static UnsafeByteArray[] values() {
            return (UnsafeByteArray[]) f43214c.clone();
        }
    }

    static {
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    UnsafeByteArray.AnonymousClass1 anonymousClass1 = UnsafeByteArray.f43212a;
                } else {
                    UnsafeByteArray.AnonymousClass2 anonymousClass2 = UnsafeByteArray.f43213b;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
