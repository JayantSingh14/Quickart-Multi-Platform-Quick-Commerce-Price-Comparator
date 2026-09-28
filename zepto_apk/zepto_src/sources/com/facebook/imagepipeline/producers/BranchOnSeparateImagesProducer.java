package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final ResizeAndRotateProducer f18113a;

    /* renamed from: b, reason: collision with root package name */
    public final ThrottlingProducer f18114b;

    public class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18115c;

        public OnFirstImageConsumer(Consumer consumer, ProducerContext producerContext) {
            super(consumer);
            this.f18115c = producerContext;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            BranchOnSeparateImagesProducer.this.f18114b.b(this.f18138b, this.f18115c);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) throws IOException {
            EncodedImage encodedImage = (EncodedImage) obj;
            ProducerContext producerContext = this.f18115c;
            ImageRequest imageRequestD = producerContext.D();
            boolean zD = BaseConsumer.d(i2);
            boolean zB = ThumbnailSizeChecker.b(encodedImage, imageRequestD.f18354h);
            Consumer consumer = this.f18138b;
            if (encodedImage != null && zB) {
                if (zD && zB) {
                    consumer.b(i2, encodedImage);
                } else {
                    consumer.b(i2 & (-2), encodedImage);
                }
            }
            if (!zD || zB || imageRequestD.d()) {
                return;
            }
            EncodedImage.b(encodedImage);
            BranchOnSeparateImagesProducer.this.f18114b.b(consumer, producerContext);
        }
    }

    public BranchOnSeparateImagesProducer(ResizeAndRotateProducer resizeAndRotateProducer, ThrottlingProducer throttlingProducer) {
        this.f18113a = resizeAndRotateProducer;
        this.f18114b = throttlingProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        this.f18113a.b(new OnFirstImageConsumer(consumer, producerContext), producerContext);
    }
}
