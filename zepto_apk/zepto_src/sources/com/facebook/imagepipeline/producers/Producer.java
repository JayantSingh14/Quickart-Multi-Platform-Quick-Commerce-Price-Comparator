package com.facebook.imagepipeline.producers;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface Producer<T> {
    void b(Consumer consumer, ProducerContext producerContext);
}
