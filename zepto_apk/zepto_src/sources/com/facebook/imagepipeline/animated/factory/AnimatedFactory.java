package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;

@NotThreadSafe
@Metadata
/* loaded from: classes3.dex */
public interface AnimatedFactory {
    DrawableFactory a();

    ImageDecoder b();

    ImageDecoder c();
}
