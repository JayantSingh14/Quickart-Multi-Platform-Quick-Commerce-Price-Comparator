package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.DoNotOptimize;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18211a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f18212b;

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f18213c;

    @DoNotOptimize
    public class Api24Utils {
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.f18211a = executor;
        this.f18212b = pooledByteBufferFactory;
        this.f18213c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public final boolean a(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.a(512, 512, resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener2S = producerContext.s();
        final ImageRequest imageRequestD = producerContext.D();
        producerContext.e(ImagesContract.LOCAL, "exif");
        final StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(consumer, producerListener2S, producerContext) { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.1
            @Override // com.facebook.common.executors.StatefulRunnable
            public final void b(Object obj) {
                EncodedImage.b((EncodedImage) obj);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[Catch: IOException -> 0x000f, StackOverflowError -> 0x0046, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x000f, StackOverflowError -> 0x0046, blocks: (B:5:0x0011, B:7:0x001c, B:9:0x0022, B:10:0x0028, B:12:0x002e, B:16:0x0038), top: B:59:0x0011 }] */
            /* JADX WARN: Removed duplicated region for block: B:4:0x000f  */
            @Override // com.facebook.common.executors.StatefulRunnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object c() throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 269
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.AnonymousClass1.c():java.lang.Object");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public final Map g(Object obj) {
                return ImmutableMap.a("createdThumbnail", Boolean.toString(((EncodedImage) obj) != null));
            }
        };
        producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                statefulProducerRunnable.a();
            }
        });
        this.f18211a.execute(statefulProducerRunnable);
    }
}
