package io.sentry.android.replay.capture;

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
public final class BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 implements ReadWriteProperty<Object, String> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f52568a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52569b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52570c;

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnonymousClass2 f52571a;

        public AnonymousClass1(AnonymousClass2 anonymousClass2) {
            this.f52571a = anonymousClass2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f52571a.invoke();
        }
    }

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0<Unit> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52572c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f52573d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCaptureStrategy f52574e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, String str, BaseCaptureStrategy baseCaptureStrategy) {
            super(0);
            this.f52572c = obj;
            this.f52573d = str;
            this.f52574e = baseCaptureStrategy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ReplayCache replayCache = this.f52574e.f52527h;
            if (replayCache != null) {
                replayCache.c("replay.screen-at-start", String.valueOf(this.f52573d));
            }
            return Unit.f53572a;
        }
    }

    public BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2(BaseCaptureStrategy baseCaptureStrategy, BaseCaptureStrategy baseCaptureStrategy2) {
        this.f52569b = baseCaptureStrategy;
        this.f52570c = baseCaptureStrategy2;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f52568a.get();
    }
}
