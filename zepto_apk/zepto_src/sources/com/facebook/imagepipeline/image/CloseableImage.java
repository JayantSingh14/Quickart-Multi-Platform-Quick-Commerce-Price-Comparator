package com.facebook.imagepipeline.image;

import com.facebook.common.references.HasBitmap;
import com.facebook.fresco.middleware.HasExtraData;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;

@Nullsafe
/* loaded from: classes3.dex */
public interface CloseableImage extends Closeable, ImageInfo, HasBitmap, HasExtraData, AutoCloseable {
    int B0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getHeight();

    int getWidth();

    boolean isClosed();

    QualityInfo q1();

    ImageInfo t1();
}
