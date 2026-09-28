package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class InternalRequestListener extends InternalProducerListener implements RequestListener2 {

    /* renamed from: c, reason: collision with root package name */
    public final ForwardingRequestListener f18184c;

    /* renamed from: d, reason: collision with root package name */
    public final ForwardingRequestListener2 f18185d;

    public InternalRequestListener(ForwardingRequestListener forwardingRequestListener, ForwardingRequestListener2 forwardingRequestListener2) {
        super(forwardingRequestListener, forwardingRequestListener2);
        this.f18184c = forwardingRequestListener;
        this.f18185d = forwardingRequestListener2;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void d(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        ForwardingRequestListener forwardingRequestListener = this.f18184c;
        if (forwardingRequestListener != null) {
            forwardingRequestListener.c(producerContext.D(), producerContext.getId(), producerContext.O());
        }
        ForwardingRequestListener2 forwardingRequestListener2 = this.f18185d;
        if (forwardingRequestListener2 != null) {
            forwardingRequestListener2.d(producerContext);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void f(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        ForwardingRequestListener forwardingRequestListener = this.f18184c;
        if (forwardingRequestListener != null) {
            forwardingRequestListener.k(producerContext.getId());
        }
        ForwardingRequestListener2 forwardingRequestListener2 = this.f18185d;
        if (forwardingRequestListener2 != null) {
            forwardingRequestListener2.f(producerContext);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void h(ProducerContext producerContext, Throwable th) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        ForwardingRequestListener forwardingRequestListener = this.f18184c;
        if (forwardingRequestListener != null) {
            forwardingRequestListener.j(producerContext.D(), producerContext.getId(), th, producerContext.O());
        }
        ForwardingRequestListener2 forwardingRequestListener2 = this.f18185d;
        if (forwardingRequestListener2 != null) {
            forwardingRequestListener2.h(producerContext, th);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void j(SettableProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        ForwardingRequestListener forwardingRequestListener = this.f18184c;
        if (forwardingRequestListener != null) {
            forwardingRequestListener.a(producerContext.f18090a, producerContext.f18094e, producerContext.f18091b, producerContext.O());
        }
        ForwardingRequestListener2 forwardingRequestListener2 = this.f18185d;
        if (forwardingRequestListener2 != null) {
            forwardingRequestListener2.j(producerContext);
        }
    }
}
