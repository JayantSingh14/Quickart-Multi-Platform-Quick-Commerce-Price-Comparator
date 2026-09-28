package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {

    /* renamed from: c, reason: collision with root package name */
    public final FallbackThreadLocalRandom$implStorage$1 f53815c = new FallbackThreadLocalRandom$implStorage$1();

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random j() {
        java.util.Random random = this.f53815c.get();
        Intrinsics.checkNotNullExpressionValue(random, "get(...)");
        return random;
    }
}
