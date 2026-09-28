package com.facebook.imagepipeline.producers;

import android.support.v4.media.b;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final ThumbnailProducer[] f18336a;

    public class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18337c;

        /* renamed from: d, reason: collision with root package name */
        public final int f18338d;

        /* renamed from: e, reason: collision with root package name */
        public final ResizeOptions f18339e;

        public ThumbnailConsumer(Consumer consumer, ProducerContext producerContext, int i2) {
            super(consumer);
            this.f18337c = producerContext;
            this.f18338d = i2;
            this.f18339e = producerContext.D().f18354h;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            int i2 = this.f18338d + 1;
            ThumbnailBranchProducer thumbnailBranchProducer = ThumbnailBranchProducer.this;
            Consumer consumer = this.f18138b;
            if (thumbnailBranchProducer.c(i2, consumer, this.f18337c)) {
                return;
            }
            consumer.onFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            EncodedImage encodedImage = (EncodedImage) obj;
            Consumer consumer = this.f18138b;
            if (encodedImage != null && (BaseConsumer.e(i2) || ThumbnailSizeChecker.b(encodedImage, this.f18339e))) {
                consumer.b(i2, encodedImage);
                return;
            }
            if (BaseConsumer.d(i2)) {
                EncodedImage.b(encodedImage);
                if (ThumbnailBranchProducer.this.c(this.f18338d + 1, consumer, this.f18337c)) {
                    return;
                }
                consumer.b(1, null);
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer... thumbnailProducerArr) {
        ThumbnailProducer[] thumbnailProducerArr2 = thumbnailProducerArr;
        this.f18336a = thumbnailProducerArr2;
        int length = thumbnailProducerArr2.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(b.f(length, "negative size: "));
            }
            throw new IndexOutOfBoundsException(Preconditions.f("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        if (producerContext.D().f18354h == null) {
            consumer.b(1, null);
        } else {
            if (c(0, consumer, producerContext)) {
                return;
            }
            consumer.b(1, null);
        }
    }

    public final boolean c(int i2, Consumer consumer, ProducerContext producerContext) {
        ThumbnailProducer[] thumbnailProducerArr;
        ResizeOptions resizeOptions = producerContext.D().f18354h;
        while (true) {
            thumbnailProducerArr = this.f18336a;
            if (i2 >= thumbnailProducerArr.length) {
                i2 = -1;
                break;
            }
            if (thumbnailProducerArr[i2].a(resizeOptions)) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            return false;
        }
        thumbnailProducerArr[i2].b(new ThumbnailConsumer(consumer, producerContext, i2), producerContext);
        return true;
    }
}
