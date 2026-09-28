package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

@Metadata
/* loaded from: classes3.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.Random
    public final int f(int i2) {
        return ThreadLocalRandom.current().nextInt(0, i2);
    }

    @Override // kotlin.random.Random
    public final long h(long j2) {
        return ThreadLocalRandom.current().nextLong(j2);
    }

    @Override // kotlin.random.Random
    public final long i(long j2) {
        return ThreadLocalRandom.current().nextLong(0L, j2);
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public final Random j() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
