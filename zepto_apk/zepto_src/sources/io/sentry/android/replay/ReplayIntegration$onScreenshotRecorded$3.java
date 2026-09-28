package io.sentry.android.replay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ReplayIntegration$onScreenshotRecorded$3 extends Lambda implements Function2<ReplayCache, Long, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ReplayCache onScreenshotRecorded = (ReplayCache) obj;
        ((Number) obj2).longValue();
        Intrinsics.checkNotNullParameter(onScreenshotRecorded, "$this$onScreenshotRecorded");
        onScreenshotRecorded.getClass();
        Intrinsics.checkNotNullParameter(null, "screenshot");
        new ReplayFrame(null, 0L, null);
        throw null;
    }
}
