package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {

    public static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            Bitmap bitmapV1;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.x()) {
                CloseableImage closeableImage = (CloseableImage) closeableReference.l();
                if (!closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (bitmapV1 = ((CloseableStaticBitmap) closeableImage).v1()) != null) {
                    int height = bitmapV1.getHeight() * bitmapV1.getRowBytes();
                    if (height >= 0 && height <= 0) {
                        bitmapV1.prepareToDraw();
                    }
                }
            }
            this.f18138b.b(i2, closeableReference);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        if (producerContext.O()) {
            throw null;
        }
        new BitmapPrepareConsumer(consumer);
        throw null;
    }
}
