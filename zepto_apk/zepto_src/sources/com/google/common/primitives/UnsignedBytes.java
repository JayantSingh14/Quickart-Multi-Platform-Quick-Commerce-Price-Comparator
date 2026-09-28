package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class UnsignedBytes {

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final Comparator f43328a;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class PureJavaComparator implements Comparator<byte[]> {

            /* renamed from: a, reason: collision with root package name */
            public static final PureJavaComparator f43329a;

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ PureJavaComparator[] f43330b;

            static {
                PureJavaComparator pureJavaComparator = new PureJavaComparator("INSTANCE", 0);
                f43329a = pureJavaComparator;
                f43330b = new PureJavaComparator[]{pureJavaComparator};
            }

            public static PureJavaComparator valueOf(String str) {
                return (PureJavaComparator) Enum.valueOf(PureJavaComparator.class, str);
            }

            public static PureJavaComparator[] values() {
                return (PureJavaComparator[]) f43330b.clone();
            }

            @Override // java.util.Comparator
            public final int compare(byte[] bArr, byte[] bArr2) {
                byte[] bArr3 = bArr;
                byte[] bArr4 = bArr2;
                int iMin = Math.min(bArr3.length, bArr4.length);
                for (int i2 = 0; i2 < iMin; i2++) {
                    int i3 = (bArr3[i2] & 255) - (bArr4[i2] & 255);
                    if (i3 != 0) {
                        return i3;
                    }
                }
                return bArr3.length - bArr4.length;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @VisibleForTesting
        public static final class UnsafeComparator implements Comparator<byte[]> {

            /* renamed from: b, reason: collision with root package name */
            public static final Unsafe f43332b;

            /* renamed from: c, reason: collision with root package name */
            public static final int f43333c;

            /* JADX INFO: Fake field, exist only in values array */
            UnsafeComparator EF5;

            /* renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ UnsafeComparator[] f43334d = {new UnsafeComparator("INSTANCE", 0)};

            /* renamed from: a, reason: collision with root package name */
            public static final boolean f43331a = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

            /* renamed from: com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1, reason: invalid class name */
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

            static {
                Unsafe unsafeB = b();
                f43332b = unsafeB;
                int iArrayBaseOffset = unsafeB.arrayBaseOffset(byte[].class);
                f43333c = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafeB.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            public static int a(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                int i2 = iMin & (-8);
                int i3 = 0;
                while (i3 < i2) {
                    Unsafe unsafe = f43332b;
                    long j2 = f43333c + i3;
                    long j3 = unsafe.getLong(bArr, j2);
                    long j4 = unsafe.getLong(bArr2, j2);
                    if (j3 != j4) {
                        if (f43331a) {
                            return UnsignedLongs.a(j3, j4);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3 ^ j4) & (-8);
                        return ((int) ((j3 >>> iNumberOfTrailingZeros) & 255)) - ((int) ((j4 >>> iNumberOfTrailingZeros) & 255));
                    }
                    i3 += 8;
                }
                while (i3 < iMin) {
                    int i4 = (bArr[i3] & 255) - (bArr2[i3] & 255);
                    if (i4 != 0) {
                        return i4;
                    }
                    i3++;
                }
                return bArr.length - bArr2.length;
            }

            public static Unsafe b() {
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

            public static UnsafeComparator valueOf(String str) {
                return (UnsafeComparator) Enum.valueOf(UnsafeComparator.class, str);
            }

            public static UnsafeComparator[] values() {
                return (UnsafeComparator[]) f43334d.clone();
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
                return a(bArr, bArr2);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        static {
            Comparator comparator;
            try {
                Object[] enumConstants = Class.forName(LexicographicalComparatorHolder.class.getName().concat("$UnsafeComparator")).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                comparator = (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                comparator = PureJavaComparator.f43329a;
            }
            f43328a = comparator;
        }
    }

    public static int a(byte b2) {
        return b2 & 255;
    }
}
