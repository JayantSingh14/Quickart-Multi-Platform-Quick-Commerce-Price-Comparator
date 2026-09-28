package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Producer f18088a;

    public static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) throws IOException {
            EncodedImage encodedImage = (EncodedImage) obj;
            Consumer consumer = this.f18138b;
            if (encodedImage == null) {
                consumer.b(i2, null);
                return;
            }
            if (!EncodedImage.O(encodedImage)) {
                encodedImage.D();
            }
            consumer.b(i2, encodedImage);
        }
    }

    public AddImageTransformMetaDataProducer(Producer producer) {
        this.f18088a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        this.f18088a.b(new AddImageTransformMetaDataConsumer(consumer), producerContext);
    }
}
