package io.sentry.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class Random implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicLong f53131b = new AtomicLong(8682522807148012L);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f53132a;

    public Random() {
        AtomicLong atomicLong;
        long j2;
        long j3;
        do {
            atomicLong = f53131b;
            j2 = atomicLong.get();
            j3 = 1181783497276652981L * j2;
        } while (!atomicLong.compareAndSet(j2, j3));
        this.f53132a = new AtomicLong(((System.nanoTime() ^ j3) ^ 25214903917L) & 281474976710655L);
    }

    public final int a(int i2) {
        long j2;
        long j3;
        AtomicLong atomicLong = this.f53132a;
        do {
            j2 = atomicLong.get();
            j3 = ((25214903917L * j2) + 11) & 281474976710655L;
        } while (!atomicLong.compareAndSet(j2, j3));
        return (int) (j3 >>> (48 - i2));
    }

    public final double b() {
        return ((a(26) << 27) + a(27)) * 1.1102230246251565E-16d;
    }
}
