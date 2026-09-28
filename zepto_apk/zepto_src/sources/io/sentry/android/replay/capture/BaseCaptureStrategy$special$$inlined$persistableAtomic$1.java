package io.sentry.android.replay.capture;

import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BaseCaptureStrategy$special$$inlined$persistableAtomic$1 implements ReadWriteProperty<Object, ScreenshotRecorderConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f52533a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52534b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52535c;

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$1$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnonymousClass2 f52536a;

        public AnonymousClass1(AnonymousClass2 anonymousClass2) {
            this.f52536a = anonymousClass2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f52536a.invoke();
        }
    }

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$1$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0<Unit> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52537c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ScreenshotRecorderConfig f52538d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCaptureStrategy f52539e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, ScreenshotRecorderConfig screenshotRecorderConfig, BaseCaptureStrategy baseCaptureStrategy) {
            super(0);
            this.f52537c = obj;
            this.f52538d = screenshotRecorderConfig;
            this.f52539e = baseCaptureStrategy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ScreenshotRecorderConfig screenshotRecorderConfig = this.f52538d;
            if (screenshotRecorderConfig != null) {
                BaseCaptureStrategy baseCaptureStrategy = this.f52539e;
                ReplayCache replayCache = baseCaptureStrategy.f52527h;
                if (replayCache != null) {
                    replayCache.c("config.height", String.valueOf(screenshotRecorderConfig.f52486b));
                }
                ReplayCache replayCache2 = baseCaptureStrategy.f52527h;
                if (replayCache2 != null) {
                    replayCache2.c("config.width", String.valueOf(screenshotRecorderConfig.f52485a));
                }
                ReplayCache replayCache3 = baseCaptureStrategy.f52527h;
                if (replayCache3 != null) {
                    replayCache3.c("config.frame-rate", String.valueOf(screenshotRecorderConfig.f52489e));
                }
                ReplayCache replayCache4 = baseCaptureStrategy.f52527h;
                if (replayCache4 != null) {
                    replayCache4.c("config.bit-rate", String.valueOf(screenshotRecorderConfig.f52490f));
                }
            }
            return Unit.f53572a;
        }
    }

    public BaseCaptureStrategy$special$$inlined$persistableAtomic$1(BaseCaptureStrategy baseCaptureStrategy, BaseCaptureStrategy baseCaptureStrategy2) {
        this.f52534b = baseCaptureStrategy;
        this.f52535c = baseCaptureStrategy2;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f52533a.get();
    }
}
