package kotlin.random;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class URandomKt {
    public static final long a(Random.Default r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.getClass();
        long jG = Random.f53819b.g();
        ULong.Companion companion = ULong.f53561b;
        return jG;
    }
}
