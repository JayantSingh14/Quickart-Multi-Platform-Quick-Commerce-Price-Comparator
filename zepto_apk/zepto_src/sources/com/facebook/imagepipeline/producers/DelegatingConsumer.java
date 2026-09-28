package com.facebook.imagepipeline.producers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {

    /* renamed from: b, reason: collision with root package name */
    public final Consumer f18138b;

    public DelegatingConsumer(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.f18138b = consumer;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void f() {
        this.f18138b.a();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void g(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        this.f18138b.onFailure(t);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void i(float f2) {
        this.f18138b.c(f2);
    }
}
