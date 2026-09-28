package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {

    /* renamed from: a, reason: collision with root package name */
    public final Producer f18299a;

    @Metadata
    public final class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            EncodedImage encodedImage = (EncodedImage) obj;
            CloseableReference closeableReferenceC = null;
            try {
                if (EncodedImage.V(encodedImage) && encodedImage != null) {
                    closeableReferenceC = CloseableReference.c(encodedImage.f17956a);
                }
                this.f18138b.b(i2, closeableReferenceC);
            } finally {
                CloseableReference.e(closeableReferenceC);
            }
        }
    }

    public RemoveImageTransformMetaDataProducer(Producer inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.f18299a = inputProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.f18299a.b(new RemoveImageTransformMetaDataConsumer(consumer), context);
    }
}
