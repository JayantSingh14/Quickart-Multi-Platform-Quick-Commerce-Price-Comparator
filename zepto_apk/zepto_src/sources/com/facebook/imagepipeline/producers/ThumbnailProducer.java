package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ThumbnailProducer<T> extends Producer<T> {
    boolean a(ResizeOptions resizeOptions);
}
