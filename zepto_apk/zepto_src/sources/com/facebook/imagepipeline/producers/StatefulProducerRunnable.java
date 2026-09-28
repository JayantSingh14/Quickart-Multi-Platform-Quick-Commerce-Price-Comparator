package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Consumer f18314b;

    /* renamed from: c, reason: collision with root package name */
    public final ProducerListener2 f18315c;

    /* renamed from: d, reason: collision with root package name */
    public final ProducerContext f18316d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18317e;

    public StatefulProducerRunnable(Consumer consumer, ProducerListener2 producerListener, ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerListener, "producerListener");
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        this.f18314b = consumer;
        this.f18315c = producerListener;
        this.f18316d = producerContext;
        this.f18317e = producerName;
        producerListener.c(producerContext, producerName);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void d() {
        ProducerListener2 producerListener2 = this.f18315c;
        ProducerContext producerContext = this.f18316d;
        String str = this.f18317e;
        producerListener2.e(producerContext, str);
        producerListener2.g(producerContext, str);
        this.f18314b.a();
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void e(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        ProducerListener2 producerListener2 = this.f18315c;
        ProducerContext producerContext = this.f18316d;
        String str = this.f18317e;
        producerListener2.e(producerContext, str);
        producerListener2.k(producerContext, str, e2, null);
        this.f18314b.onFailure(e2);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void f(Object obj) {
        ProducerListener2 producerListener2 = this.f18315c;
        ProducerContext producerContext = this.f18316d;
        String str = this.f18317e;
        producerListener2.i(producerContext, str, producerListener2.e(producerContext, str) ? g(obj) : null);
        this.f18314b.b(1, obj);
    }

    public Map g(Object obj) {
        return null;
    }
}
