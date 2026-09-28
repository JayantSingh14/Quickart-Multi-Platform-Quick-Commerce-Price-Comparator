package io.sentry.android.replay;

import io.sentry.android.replay.WindowRecorder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class WindowRecorder$capturer$2 extends Lambda implements Function0<ScheduledExecutorService> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowRecorder$capturer$2 f52510c = new WindowRecorder$capturer$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Executors.newSingleThreadScheduledExecutor(new WindowRecorder.RecorderExecutorServiceThreadFactory());
    }
}
