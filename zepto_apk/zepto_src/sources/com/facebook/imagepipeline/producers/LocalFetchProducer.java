package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18217a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f18218b;

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.f18217a = executor;
        this.f18218b = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener2S = producerContext.s();
        final ImageRequest imageRequestD = producerContext.D();
        producerContext.e(ImagesContract.LOCAL, "fetch");
        final StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(consumer, producerListener2S, producerContext, e()) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
            @Override // com.facebook.common.executors.StatefulRunnable
            public final void b(Object obj) {
                EncodedImage.b((EncodedImage) obj);
            }

            @Override // com.facebook.common.executors.StatefulRunnable
            public final Object c() throws IOException {
                ImageRequest imageRequest = imageRequestD;
                LocalFetchProducer localFetchProducer = LocalFetchProducer.this;
                EncodedImage encodedImageD = localFetchProducer.d(imageRequest);
                ProducerListener2 producerListener2 = producerListener2S;
                ProducerContext producerContext2 = producerContext;
                if (encodedImageD == null) {
                    producerListener2.b(producerContext2, localFetchProducer.e(), false);
                    producerContext2.e(ImagesContract.LOCAL, "fetch");
                    return null;
                }
                encodedImageD.D();
                producerListener2.b(producerContext2, localFetchProducer.e(), true);
                producerContext2.e(ImagesContract.LOCAL, "fetch");
                encodedImageD.Z();
                producerContext2.V(encodedImageD.f17965j, "image_color_space");
                return encodedImageD;
            }
        };
        producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                statefulProducerRunnable.a();
            }
        });
        this.f18217a.execute(statefulProducerRunnable);
    }

    public final EncodedImage c(InputStream inputStream, int i2) {
        PooledByteBufferFactory pooledByteBufferFactory = this.f18218b;
        DefaultCloseableReference defaultCloseableReferenceD = null;
        try {
            defaultCloseableReferenceD = i2 <= 0 ? CloseableReference.D(pooledByteBufferFactory.a(inputStream)) : CloseableReference.D(pooledByteBufferFactory.b(inputStream, i2));
            EncodedImage encodedImage = new EncodedImage(defaultCloseableReferenceD);
            Closeables.b(inputStream);
            defaultCloseableReferenceD.close();
            return encodedImage;
        } catch (Throwable th) {
            Closeables.b(inputStream);
            CloseableReference.e(defaultCloseableReferenceD);
            throw th;
        }
    }

    public abstract EncodedImage d(ImageRequest imageRequest);

    public abstract String e();
}
