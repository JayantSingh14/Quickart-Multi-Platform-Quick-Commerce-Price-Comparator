package io.sentry.android.replay.capture;

import io.sentry.android.replay.capture.BaseCaptureStrategy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class BaseCaptureStrategy$persistingExecutor$2 extends Lambda implements Function0<ScheduledExecutorService> {

    /* renamed from: c, reason: collision with root package name */
    public static final BaseCaptureStrategy$persistingExecutor$2 f52576c = new BaseCaptureStrategy$persistingExecutor$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Executors.newSingleThreadScheduledExecutor(new BaseCaptureStrategy.ReplayPersistingExecutorServiceThreadFactory());
    }
}
