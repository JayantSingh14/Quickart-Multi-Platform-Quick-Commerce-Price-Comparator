package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class FetchState {

    /* renamed from: a, reason: collision with root package name */
    public final Consumer f18166a;

    /* renamed from: b, reason: collision with root package name */
    public final ProducerContext f18167b;

    /* renamed from: c, reason: collision with root package name */
    public long f18168c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f18169d;

    /* renamed from: e, reason: collision with root package name */
    public BytesRange f18170e;

    public FetchState(Consumer consumer, ProducerContext producerContext) {
        this.f18166a = consumer;
        this.f18167b = producerContext;
    }

    public final ProducerContext a() {
        return this.f18167b;
    }

    public final Uri b() {
        return this.f18167b.D().f18348b;
    }
}
