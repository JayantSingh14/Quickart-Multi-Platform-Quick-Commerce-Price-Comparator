package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.fresco.ui.common.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ImagePerfRequestListener extends BaseRequestListener {

    /* renamed from: a, reason: collision with root package name */
    public final AwakeTimeSinceBootClock f17217a;

    /* renamed from: b, reason: collision with root package name */
    public final ImagePerfState f17218b;

    public ImagePerfRequestListener(AwakeTimeSinceBootClock awakeTimeSinceBootClock, ImagePerfState imagePerfState) {
        this.f17217a = awakeTimeSinceBootClock;
        this.f17218b = imagePerfState;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.f17217a.now();
        ImagePerfState imagePerfState = this.f17218b;
        imagePerfState.getClass();
        imagePerfState.f17479b = imageRequest;
        imagePerfState.f17480c = obj;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void c(ImageRequest imageRequest, String str, boolean z) {
        this.f17217a.now();
        ImagePerfState imagePerfState = this.f17218b;
        imagePerfState.getClass();
        imagePerfState.f17479b = imageRequest;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void j(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.f17217a.now();
        ImagePerfState imagePerfState = this.f17218b;
        imagePerfState.getClass();
        imagePerfState.f17479b = imageRequest;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void k(String str) {
        this.f17217a.now();
        this.f17218b.getClass();
    }
}
