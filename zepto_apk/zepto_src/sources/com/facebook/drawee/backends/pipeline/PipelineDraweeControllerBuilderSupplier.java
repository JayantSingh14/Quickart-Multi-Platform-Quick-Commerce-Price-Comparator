package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.xml.XmlDrawableFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17203a;

    /* renamed from: b, reason: collision with root package name */
    public final ImagePipeline f17204b;

    /* renamed from: c, reason: collision with root package name */
    public final PipelineDraweeControllerFactory f17205c;

    public PipelineDraweeControllerBuilderSupplier(Context context, DraweeConfig draweeConfig) {
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.p;
        Preconditions.d(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        this.f17203a = context;
        ImagePipeline imagePipelineD = imagePipelineFactory.d();
        this.f17204b = imagePipelineD;
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        this.f17205c = pipelineDraweeControllerFactory;
        Resources resources = context.getResources();
        DeferredReleaser deferredReleaserB = DeferredReleaser.b();
        AnimatedFactory animatedFactoryA = imagePipelineFactory.a();
        DrawableFactory drawableFactoryA = animatedFactoryA == null ? null : animatedFactoryA.a();
        XmlDrawableFactory xmlDrawableFactory = imagePipelineFactory.f17876b.w.f17867i ? new XmlDrawableFactory() : null;
        if (UiThreadImmediateExecutorService.f17074b == null) {
            UiThreadImmediateExecutorService.f17074b = new UiThreadImmediateExecutorService(new Handler(Looper.getMainLooper()));
        }
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.f17074b;
        InstrumentedMemoryCache instrumentedMemoryCache = imagePipelineD.f17826f;
        Supplier supplier = draweeConfig.f17197a;
        pipelineDraweeControllerFactory.f17206a = resources;
        pipelineDraweeControllerFactory.f17207b = deferredReleaserB;
        pipelineDraweeControllerFactory.f17208c = drawableFactoryA;
        pipelineDraweeControllerFactory.f17209d = xmlDrawableFactory;
        pipelineDraweeControllerFactory.f17210e = uiThreadImmediateExecutorService;
        pipelineDraweeControllerFactory.f17211f = instrumentedMemoryCache;
        pipelineDraweeControllerFactory.f17212g = supplier;
    }

    @Override // com.facebook.common.internal.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final PipelineDraweeControllerBuilder get() {
        return new PipelineDraweeControllerBuilder(this.f17203a, this.f17205c, this.f17204b);
    }
}
