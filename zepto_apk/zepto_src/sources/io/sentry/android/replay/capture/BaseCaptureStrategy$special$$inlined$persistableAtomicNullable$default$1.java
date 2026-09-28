package io.sentry.android.replay.capture;

import io.sentry.DateUtils;
import io.sentry.android.replay.ReplayCache;
import java.util.Date;
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
public final class BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1 implements ReadWriteProperty<Object, Date> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f52561a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52562b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52563c;

    @Metadata
    @SourceDebugExtension
    /* renamed from: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0<Unit> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52565c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Date f52566d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCaptureStrategy f52567e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, Date date, BaseCaptureStrategy baseCaptureStrategy) {
            super(0);
            this.f52565c = obj;
            this.f52566d = date;
            this.f52567e = baseCaptureStrategy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ReplayCache replayCache = this.f52567e.f52527h;
            if (replayCache != null) {
                Date date = this.f52566d;
                replayCache.c("segment.timestamp", date == null ? null : DateUtils.e(date));
            }
            return Unit.f53572a;
        }
    }

    public BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1(BaseCaptureStrategy baseCaptureStrategy, BaseCaptureStrategy baseCaptureStrategy2) {
        this.f52562b = baseCaptureStrategy;
        this.f52563c = baseCaptureStrategy2;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f52561a.get();
    }
}
