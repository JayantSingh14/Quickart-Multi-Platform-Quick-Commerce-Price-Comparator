package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18300a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f18301b;

    /* renamed from: c, reason: collision with root package name */
    public final Producer f18302c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18303d;

    /* renamed from: e, reason: collision with root package name */
    public final MultiImageTranscoderFactory f18304e;

    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final boolean f18305c;

        /* renamed from: d, reason: collision with root package name */
        public final MultiImageTranscoderFactory f18306d;

        /* renamed from: e, reason: collision with root package name */
        public final ProducerContext f18307e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f18308f;

        /* renamed from: g, reason: collision with root package name */
        public final JobScheduler f18309g;

        public TransformingConsumer(final Consumer consumer, ProducerContext producerContext, boolean z, MultiImageTranscoderFactory multiImageTranscoderFactory) {
            super(consumer);
            this.f18308f = false;
            this.f18307e = producerContext;
            producerContext.D().getClass();
            this.f18305c = z;
            this.f18306d = multiImageTranscoderFactory;
            this.f18309g = new JobScheduler(ResizeAndRotateProducer.this.f18300a, new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public final void a(EncodedImage encodedImage, int i2) throws Throwable {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    if (encodedImage == null) {
                        transformingConsumer.f18138b.b(i2, null);
                        return;
                    }
                    MultiImageTranscoderFactory multiImageTranscoderFactory2 = transformingConsumer.f18306d;
                    encodedImage.Z();
                    ImageTranscoder imageTranscoderCreateImageTranscoder = multiImageTranscoderFactory2.createImageTranscoder(encodedImage.f17957b, transformingConsumer.f18305c);
                    Consumer consumer2 = transformingConsumer.f18138b;
                    ProducerContext producerContext2 = transformingConsumer.f18307e;
                    producerContext2.s().c(producerContext2, "ResizeAndRotateProducer");
                    ImageRequest imageRequestD = producerContext2.D();
                    MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStreamC = ResizeAndRotateProducer.this.f18301b.c();
                    try {
                        try {
                            RotationOptions rotationOptions = imageRequestD.f18355i;
                            ResizeOptions resizeOptions = imageRequestD.f18354h;
                            encodedImage.Z();
                            ImageTranscodeResult imageTranscodeResultB = imageTranscoderCreateImageTranscoder.b(encodedImage, memoryPooledByteBufferOutputStreamC, rotationOptions, resizeOptions, encodedImage.f17965j);
                            int i3 = imageTranscodeResultB.f18384a;
                            if (i3 == 2) {
                                throw new RuntimeException("Error while transcoding the image");
                            }
                            ImmutableMap immutableMapL = transformingConsumer.l(encodedImage, imageRequestD.f18354h, imageTranscodeResultB, imageTranscoderCreateImageTranscoder.a());
                            DefaultCloseableReference defaultCloseableReferenceD = CloseableReference.D(memoryPooledByteBufferOutputStreamC.a());
                            try {
                                EncodedImage encodedImage2 = new EncodedImage(defaultCloseableReferenceD);
                                encodedImage2.f17957b = DefaultImageFormats.f17681a;
                                try {
                                    encodedImage2.D();
                                    producerContext2.s().i(producerContext2, "ResizeAndRotateProducer", immutableMapL);
                                    if (i3 != 1) {
                                        i2 |= 16;
                                    }
                                    consumer2.b(i2, encodedImage2);
                                    defaultCloseableReferenceD.close();
                                    memoryPooledByteBufferOutputStreamC.close();
                                } finally {
                                    encodedImage2.close();
                                }
                            } catch (Throwable th) {
                                CloseableReference.e(defaultCloseableReferenceD);
                                throw th;
                            }
                        } catch (Exception e2) {
                            producerContext2.s().k(producerContext2, "ResizeAndRotateProducer", e2, null);
                            if (BaseConsumer.d(i2)) {
                                consumer2.onFailure(e2);
                            }
                            memoryPooledByteBufferOutputStreamC.close();
                        }
                    } catch (Throwable th2) {
                        memoryPooledByteBufferOutputStreamC.close();
                        throw th2;
                    }
                }
            });
            producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void a() {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    if (transformingConsumer.f18307e.x()) {
                        transformingConsumer.f18309g.d();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void b() {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    transformingConsumer.f18309g.a();
                    transformingConsumer.f18308f = true;
                    consumer.a();
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void h(int r17, java.lang.Object r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 260
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.h(int, java.lang.Object):void");
        }

        public final ImmutableMap l(EncodedImage encodedImage, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) throws IOException {
            String str2;
            long j2;
            ProducerContext producerContext = this.f18307e;
            if (!producerContext.s().e(producerContext, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            encodedImage.Z();
            sb.append(encodedImage.f17960e);
            sb.append("x");
            encodedImage.Z();
            sb.append(encodedImage.f17961f);
            String string = sb.toString();
            if (resizeOptions != null) {
                str2 = resizeOptions.f17787a + "x" + resizeOptions.f17788b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            encodedImage.Z();
            map.put("Image format", String.valueOf(encodedImage.f17957b));
            map.put("Original size", string);
            map.put("Requested size", str2);
            JobScheduler jobScheduler = this.f18309g;
            synchronized (jobScheduler) {
                j2 = jobScheduler.f18194i - jobScheduler.f18193h;
            }
            map.put("queueTime", String.valueOf(j2));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return new ImmutableMap(map);
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer producer, boolean z, MultiImageTranscoderFactory multiImageTranscoderFactory) {
        executor.getClass();
        this.f18300a = executor;
        pooledByteBufferFactory.getClass();
        this.f18301b = pooledByteBufferFactory;
        this.f18302c = producer;
        multiImageTranscoderFactory.getClass();
        this.f18304e = multiImageTranscoderFactory;
        this.f18303d = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        this.f18302c.b(new TransformingConsumer(consumer, producerContext, this.f18303d, this.f18304e), producerContext);
    }
}
