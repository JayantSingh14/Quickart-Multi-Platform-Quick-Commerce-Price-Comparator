package kotlin.random;

import android.support.v4.media.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class Random {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Default f53818a = new Default(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Random f53819b = PlatformImplementationsKt.f53716a.b();

    @Metadata
    public static final class Default extends Random implements Serializable {

        @Metadata
        /* loaded from: classes3.dex */
        public static final class Serialized implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final Serialized f53820a = new Serialized();
        }

        public Default(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // kotlin.random.Random
        public final int a(int i2) {
            return Random.f53819b.a(i2);
        }

        @Override // kotlin.random.Random
        public final byte[] b(int i2, byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.f53819b.b(i2, array);
        }

        @Override // kotlin.random.Random
        public final byte[] c(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.f53819b.c(array);
        }

        @Override // kotlin.random.Random
        public final int d() {
            return Random.f53819b.d();
        }

        @Override // kotlin.random.Random
        public final int e(int i2) {
            return Random.f53819b.e(i2);
        }

        @Override // kotlin.random.Random
        public final int f(int i2) {
            return Random.f53819b.f(i2);
        }

        @Override // kotlin.random.Random
        public final long g() {
            return Random.f53819b.g();
        }

        @Override // kotlin.random.Random
        public final long h(long j2) {
            return Random.f53819b.h(j2);
        }

        @Override // kotlin.random.Random
        public final long i(long j2) {
            return Random.f53819b.i(j2);
        }
    }

    public abstract int a(int i2);

    public byte[] b(int i2, byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < 0 || i2 < 0 || i2 > array.length) {
            throw new IllegalArgumentException(b.n(b.u(i2, "fromIndex (0) or toIndex (", ") are out of range: 0.."), array.length, ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "fromIndex (0) must be not greater than toIndex (", ").").toString());
        }
        int i3 = i2 / 4;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int iD = d();
            array[i4] = (byte) iD;
            array[i4 + 1] = (byte) (iD >>> 8);
            array[i4 + 2] = (byte) (iD >>> 16);
            array[i4 + 3] = (byte) (iD >>> 24);
            i4 += 4;
        }
        int i6 = i2 - i4;
        int iA = a(i6 * 8);
        for (int i7 = 0; i7 < i6; i7++) {
            array[i4 + i7] = (byte) (iA >>> (i7 * 8));
        }
        return array;
    }

    public byte[] c(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return b(array.length, array);
    }

    public int d() {
        return a(32);
    }

    public int e(int i2) {
        return f(i2);
    }

    public int f(int i2) {
        int iD;
        int i3;
        RandomKt.b(i2);
        if (i2 > 0 || i2 == Integer.MIN_VALUE) {
            if (((-i2) & i2) == i2) {
                return a(RandomKt.d(i2));
            }
            do {
                iD = d() >>> 1;
                i3 = iD % i2;
            } while ((i2 - 1) + (iD - i3) < 0);
            return i3;
        }
        while (true) {
            int iD2 = d();
            if (iD2 >= 0 && iD2 < i2) {
                return iD2;
            }
        }
    }

    public long g() {
        return (d() << 32) + d();
    }

    public long h(long j2) {
        return i(j2);
    }

    public long i(long j2) {
        long jG;
        long j3;
        RandomKt.c(j2);
        if (j2 > 0) {
            if (((-j2) & j2) == j2) {
                return ((int) j2) != 0 ? a(RandomKt.d(r0)) & 4294967295L : ((int) (j2 >>> 32)) == 1 ? d() & 4294967295L : (a(RandomKt.d(r11)) << 32) + (d() & 4294967295L);
            }
            do {
                jG = g() >>> 1;
                j3 = jG % j2;
            } while ((j2 - 1) + (jG - j3) < 0);
            return j3;
        }
        while (true) {
            long jG2 = g();
            if (0 <= jG2 && jG2 < j2) {
                return jG2;
            }
        }
    }
}
