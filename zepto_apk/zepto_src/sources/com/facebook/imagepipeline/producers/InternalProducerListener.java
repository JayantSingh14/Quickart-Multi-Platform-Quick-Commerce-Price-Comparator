package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class InternalProducerListener implements ProducerListener2 {

    /* renamed from: a, reason: collision with root package name */
    public final RequestListener f18182a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestListener2 f18183b;

    public InternalProducerListener(RequestListener requestListener, RequestListener2 requestListener2) {
        this.f18182a = requestListener;
        this.f18183b = requestListener2;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.i(context.getId());
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.a(context);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void b(ProducerContext context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.h(context.getId(), str, z);
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.b(context, str, z);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void c(ProducerContext context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.b(context.getId(), str);
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.c(context, str);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final boolean e(ProducerContext context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        Boolean boolValueOf = requestListener != null ? Boolean.valueOf(requestListener.d(context.getId())) : null;
        if (!Intrinsics.b(boolValueOf, Boolean.TRUE)) {
            RequestListener2 requestListener2 = this.f18183b;
            boolValueOf = requestListener2 != null ? Boolean.valueOf(requestListener2.e(context, str)) : null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void g(ProducerContext context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.g(context.getId(), str);
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.g(context, str);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void i(ProducerContext context, String str, Map map) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.e(context.getId(), str, map);
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.i(context, str, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void k(ProducerContext context, String str, Throwable th, Map map) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestListener requestListener = this.f18182a;
        if (requestListener != null) {
            requestListener.f(context.getId(), str, th, map);
        }
        RequestListener2 requestListener2 = this.f18183b;
        if (requestListener2 != null) {
            requestListener2.k(context, str, th, map);
        }
    }
}
