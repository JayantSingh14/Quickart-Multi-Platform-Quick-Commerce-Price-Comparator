package io.sentry.android.replay.capture;

import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ReplayCache;
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
public final class BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3 implements ReadWriteProperty<Object, SentryReplayEvent.ReplayType> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f52554a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52555b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52556c;

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0<Unit> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52558c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SentryReplayEvent.ReplayType f52559d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCaptureStrategy f52560e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, SentryReplayEvent.ReplayType replayType, BaseCaptureStrategy baseCaptureStrategy) {
            super(0);
            this.f52558c = obj;
            this.f52559d = replayType;
            this.f52560e = baseCaptureStrategy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ReplayCache replayCache = this.f52560e.f52527h;
            if (replayCache != null) {
                replayCache.c("replay.type", String.valueOf(this.f52559d));
            }
            return Unit.f53572a;
        }
    }

    public BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3(BaseCaptureStrategy baseCaptureStrategy, BaseCaptureStrategy baseCaptureStrategy2) {
        this.f52555b = baseCaptureStrategy;
        this.f52556c = baseCaptureStrategy2;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f52554a.get();
    }
}
