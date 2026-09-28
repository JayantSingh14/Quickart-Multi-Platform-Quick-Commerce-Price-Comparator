package io.sentry.android.replay.util;

import io.sentry.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SamplingKt {
    public static final boolean a(Random random, Double d2) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return d2 != null && d2.doubleValue() >= random.b();
    }
}
