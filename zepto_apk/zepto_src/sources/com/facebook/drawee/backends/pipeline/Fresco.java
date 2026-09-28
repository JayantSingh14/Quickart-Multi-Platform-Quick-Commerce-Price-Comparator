package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

/* loaded from: classes.dex */
public class Fresco {

    /* renamed from: a, reason: collision with root package name */
    public static PipelineDraweeControllerBuilderSupplier f17198a = null;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f17199b = false;

    public static ImagePipeline a() {
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.p;
        Preconditions.d(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        return imagePipelineFactory.d();
    }
}
