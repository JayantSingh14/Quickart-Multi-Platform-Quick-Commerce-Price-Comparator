package org.apache.commons.lang3;

import com.google.android.gms.common.api.Api;
import java.util.Random;

/* loaded from: classes5.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int i2) {
        Validate.isTrue(i2 >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i2];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d2, double d3) {
        Validate.isTrue(d3 >= d2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d2 >= 0.0d, "Both range values must be non-negative.", new Object[0]);
        if (d2 == d3) {
            return d2;
        }
        return (RANDOM.nextDouble() * (d3 - d2)) + d2;
    }

    public static float nextFloat(float f2, float f3) {
        Validate.isTrue(f3 >= f2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f2 >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (f2 == f3) {
            return f2;
        }
        return (RANDOM.nextFloat() * (f3 - f2)) + f2;
    }

    public static int nextInt(int i2, int i3) {
        Validate.isTrue(i3 >= i2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i2 >= 0, "Both range values must be non-negative.", new Object[0]);
        return i2 == i3 ? i2 : RANDOM.nextInt(i3 - i2) + i2;
    }

    public static long nextLong(long j2, long j3) {
        Validate.isTrue(j3 >= j2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j2 >= 0, "Both range values must be non-negative.", new Object[0]);
        return j2 == j3 ? j2 : (long) nextDouble(j2, j3);
    }

    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }

    public static int nextInt() {
        return nextInt(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static long nextLong() {
        return nextLong(0L, Long.MAX_VALUE);
    }
}
