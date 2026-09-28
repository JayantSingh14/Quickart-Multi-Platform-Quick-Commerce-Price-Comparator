package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class BaseRequestListener2 implements RequestListener2 {
    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter("NetworkFetchProducer", "producerName");
        Intrinsics.checkNotNullParameter("intermediate_result", "eventName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void b(ProducerContext producerContext, String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void c(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void d(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final boolean e(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void f(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void g(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void h(ProducerContext producerContext, Throwable th) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void i(ProducerContext producerContext, String producerName, Map map) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void j(SettableProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void k(ProducerContext producerContext, String producerName, Throwable th, Map map) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
    }
}
