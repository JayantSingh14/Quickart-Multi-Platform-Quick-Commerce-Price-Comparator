package com.facebook.imagepipeline.producers;

import java.util.Map;

/* loaded from: classes.dex */
public interface ProducerListener2 {
    void a(ProducerContext producerContext);

    void b(ProducerContext producerContext, String str, boolean z);

    void c(ProducerContext producerContext, String str);

    boolean e(ProducerContext producerContext, String str);

    void g(ProducerContext producerContext, String str);

    void i(ProducerContext producerContext, String str, Map map);

    void k(ProducerContext producerContext, String str, Throwable th, Map map);
}
