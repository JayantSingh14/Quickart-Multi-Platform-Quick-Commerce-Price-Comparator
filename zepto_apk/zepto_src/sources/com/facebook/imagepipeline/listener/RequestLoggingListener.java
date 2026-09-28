package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RequestLoggingListener implements RequestListener {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f17977a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f17978b = new HashMap();

    @Metadata
    public static final class Companion {
        public static final long a(Long l2, long j2) {
            if (l2 != null) {
                return j2 - l2.longValue();
            }
            return -1L;
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final synchronized void a(ImageRequest request, Object callerContextObject, String requestId, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callerContextObject, "callerContextObject");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (FLog.f17086a.a(2)) {
            Long lValueOf = Long.valueOf(SystemClock.uptimeMillis());
            Boolean boolValueOf = Boolean.valueOf(z);
            FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = FLog.f17086a;
            if (fLogDefaultLoggingDelegate.a(2)) {
                String str = String.format(null, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", lValueOf, requestId, callerContextObject, boolValueOf);
                fLogDefaultLoggingDelegate.getClass();
                FLogDefaultLoggingDelegate.b(2, "RequestLoggingListener", str);
            }
            this.f17978b.put(requestId, Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void b(String requestId, String producerName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (FLog.f17086a.a(2)) {
            Pair pairCreate = Pair.create(requestId, producerName);
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.f17977a.put(pairCreate, Long.valueOf(jUptimeMillis));
            FLog.m("time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(jUptimeMillis), requestId, producerName);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final synchronized void c(ImageRequest request, String requestId, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (FLog.f17086a.a(2)) {
            Long l2 = (Long) this.f17978b.remove(requestId);
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.m("time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(jUptimeMillis), requestId, Long.valueOf(Companion.a(l2, jUptimeMillis)));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final boolean d(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FLog.f17086a.a(2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void e(String requestId, String producerName, Map map) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (FLog.f17086a.a(2)) {
            Long l2 = (Long) this.f17977a.remove(Pair.create(requestId, producerName));
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.n("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(jUptimeMillis), requestId, producerName, Long.valueOf(Companion.a(l2, jUptimeMillis)), map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void f(String requestId, String producerName, Throwable throwable, Map map) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (FLog.f17086a.a(5)) {
            Long l2 = (Long) this.f17977a.remove(Pair.create(requestId, producerName));
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.t("RequestLoggingListener", throwable, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(jUptimeMillis), requestId, producerName, Long.valueOf(Companion.a(l2, jUptimeMillis)), map, throwable.toString());
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void g(String requestId, String producerName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (FLog.f17086a.a(2)) {
            Long l2 = (Long) this.f17977a.remove(Pair.create(requestId, producerName));
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.n("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(jUptimeMillis), requestId, producerName, Long.valueOf(Companion.a(l2, jUptimeMillis)), null);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void h(String requestId, String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (FLog.f17086a.a(2)) {
            Long l2 = (Long) this.f17977a.remove(Pair.create(requestId, producerName));
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.n("RequestLoggingListener", "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", Long.valueOf(jUptimeMillis), requestId, producerName, Long.valueOf(Companion.a(l2, jUptimeMillis)), Boolean.valueOf(z));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final synchronized void i(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter("NetworkFetchProducer", "producerName");
        Intrinsics.checkNotNullParameter("intermediate_result", "producerEventName");
        if (FLog.f17086a.a(2)) {
            FLog.n("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(SystemClock.uptimeMillis()), requestId, "NetworkFetchProducer", "intermediate_result", Long.valueOf(Companion.a((Long) this.f17977a.get(Pair.create(requestId, "NetworkFetchProducer")), SystemClock.uptimeMillis())));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final synchronized void j(ImageRequest request, String requestId, Throwable throwable, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (FLog.f17086a.a(5)) {
            Long l2 = (Long) this.f17978b.remove(requestId);
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.s("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(jUptimeMillis), requestId, Long.valueOf(Companion.a(l2, jUptimeMillis)), throwable.toString());
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final synchronized void k(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (FLog.f17086a.a(2)) {
            Long l2 = (Long) this.f17978b.remove(requestId);
            long jUptimeMillis = SystemClock.uptimeMillis();
            FLog.m("time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(jUptimeMillis), requestId, Long.valueOf(Companion.a(l2, jUptimeMillis)));
        }
    }
}
