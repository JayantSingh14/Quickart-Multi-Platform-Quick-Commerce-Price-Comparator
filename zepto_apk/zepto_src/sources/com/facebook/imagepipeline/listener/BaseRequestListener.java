package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class BaseRequestListener implements RequestListener {
    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void a(ImageRequest request, Object callerContext, String requestId, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callerContext, "callerContext");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void b(String requestId, String producerName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void c(ImageRequest request, String requestId, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean d(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void e(String requestId, String producerName, Map map) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void f(String requestId, String producerName, Throwable t, Map map) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void g(String requestId, String producerName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void h(String requestId, String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void i(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter("NetworkFetchProducer", "producerName");
        Intrinsics.checkNotNullParameter("intermediate_result", "eventName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void j(ImageRequest request, String requestId, Throwable throwable, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void k(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
    }
}
