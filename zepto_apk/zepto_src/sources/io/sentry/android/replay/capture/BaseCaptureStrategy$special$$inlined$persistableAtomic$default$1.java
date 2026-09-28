package io.sentry.android.replay.capture;

import io.sentry.android.replay.ReplayCache;
import io.sentry.protocol.SentryId;
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
public final class BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1 implements ReadWriteProperty<Object, SentryId> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f52540a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52541b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52542c;

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnonymousClass2 f52543a;

        public AnonymousClass1(AnonymousClass2 anonymousClass2) {
            this.f52543a = anonymousClass2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f52543a.invoke();
        }
    }

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0<Unit> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52544c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SentryId f52545d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCaptureStrategy f52546e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, SentryId sentryId, BaseCaptureStrategy baseCaptureStrategy) {
            super(0);
            this.f52544c = obj;
            this.f52545d = sentryId;
            this.f52546e = baseCaptureStrategy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ReplayCache replayCache = this.f52546e.f52527h;
            if (replayCache != null) {
                replayCache.c("replay.id", String.valueOf(this.f52545d));
            }
            return Unit.f53572a;
        }
    }

    public BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1(SentryId sentryId, BaseCaptureStrategy baseCaptureStrategy, BaseCaptureStrategy baseCaptureStrategy2) {
        this.f52541b = baseCaptureStrategy;
        this.f52542c = baseCaptureStrategy2;
        this.f52540a = new AtomicReference(sentryId);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f52540a.get();
    }
}
