package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public final int a(int i2) {
        return RandomKt.e(j().nextInt(), i2);
    }

    @Override // kotlin.random.Random
    public final byte[] c(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        j().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public final int d() {
        return j().nextInt();
    }

    @Override // kotlin.random.Random
    public final int e(int i2) {
        return j().nextInt(i2);
    }

    @Override // kotlin.random.Random
    public final long g() {
        return j().nextLong();
    }

    public abstract java.util.Random j();
}
