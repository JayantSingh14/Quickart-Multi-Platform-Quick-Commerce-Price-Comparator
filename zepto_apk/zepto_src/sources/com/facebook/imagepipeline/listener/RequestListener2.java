package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;
import com.facebook.imagepipeline.producers.SettableProducerContext;

/* loaded from: classes.dex */
public interface RequestListener2 extends ProducerListener2 {
    void d(ProducerContext producerContext);

    void f(ProducerContext producerContext);

    void h(ProducerContext producerContext, Throwable th);

    void j(SettableProducerContext settableProducerContext);
}
