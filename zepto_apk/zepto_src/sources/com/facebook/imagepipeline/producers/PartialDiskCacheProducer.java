package com.facebook.imagepipeline.producers;

import android.support.v4.media.b;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;

@Nullsafe
/* loaded from: classes3.dex */
public class PartialDiskCacheProducer implements Producer<EncodedImage> {

    /* renamed from: com.facebook.imagepipeline.producers.PartialDiskCacheProducer$1, reason: invalid class name */
    class AnonymousClass1 implements Continuation<EncodedImage, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerListener2 f18260a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProducerContext f18261b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Consumer f18262c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CacheKey f18263d;

        public AnonymousClass1(ProducerListener2 producerListener2, ProducerContext producerContext, Consumer consumer, CacheKey cacheKey) {
            this.f18260a = producerListener2;
            this.f18261b = producerContext;
            this.f18262c = consumer;
            this.f18263d = cacheKey;
        }

        @Override // bolts.Continuation
        public final Object a(Task task) {
            boolean zG = task.g();
            ProducerListener2 producerListener2 = this.f18260a;
            Consumer consumer = this.f18262c;
            ProducerContext producerContext = this.f18261b;
            if (zG || (task.h() && (task.e() instanceof CancellationException))) {
                producerListener2.g(producerContext, "PartialDiskCacheProducer");
                consumer.a();
                return null;
            }
            boolean zH = task.h();
            CacheKey cacheKey = this.f18263d;
            PartialDiskCacheProducer partialDiskCacheProducer = PartialDiskCacheProducer.this;
            if (zH) {
                producerListener2.k(producerContext, "PartialDiskCacheProducer", task.e(), null);
                partialDiskCacheProducer.d(consumer, producerContext, cacheKey, null);
                return null;
            }
            EncodedImage encodedImage = (EncodedImage) task.f();
            if (encodedImage == null) {
                producerListener2.i(producerContext, "PartialDiskCacheProducer", PartialDiskCacheProducer.c(producerListener2, producerContext, false, 0));
                partialDiskCacheProducer.d(consumer, producerContext, cacheKey, encodedImage);
                return null;
            }
            producerListener2.i(producerContext, "PartialDiskCacheProducer", PartialDiskCacheProducer.c(producerListener2, producerContext, true, encodedImage.A()));
            int iA = encodedImage.A() - 1;
            Lazy lazy = BytesRange.f17773c;
            if (!(iA > 0)) {
                throw new IllegalArgumentException();
            }
            encodedImage.f17964i = new BytesRange(0, iA);
            int iA2 = encodedImage.A();
            ImageRequest imageRequestD = producerContext.D();
            BytesRange bytesRange = imageRequestD.f18356j;
            if (bytesRange != null && bytesRange.f17774a >= 0 && bytesRange.f17775b <= iA) {
                producerContext.e("disk", "partial");
                producerListener2.b(producerContext, "PartialDiskCacheProducer", true);
                consumer.b(9, encodedImage);
                return null;
            }
            consumer.b(8, encodedImage);
            ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(imageRequestD);
            int i2 = iA2 - 1;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException();
            }
            imageRequestBuilderB.f18381l = new BytesRange(i2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            partialDiskCacheProducer.d(consumer, new SettableProducerContext(imageRequestBuilderB.a(), producerContext.getId(), producerContext.l(), producerContext.s(), producerContext.a(), producerContext.Z(), producerContext.O(), producerContext.x(), producerContext.A(), producerContext.c()), cacheKey, encodedImage);
            return null;
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.PartialDiskCacheProducer$2, reason: invalid class name */
    class AnonymousClass2 extends BaseProducerContextCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f18265a;

        public AnonymousClass2(AtomicBoolean atomicBoolean) {
            this.f18265a = atomicBoolean;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public final void b() {
            this.f18265a.set(true);
        }
    }

    public static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final Supplier f18266c;

        /* renamed from: d, reason: collision with root package name */
        public final CacheKey f18267d;

        /* renamed from: e, reason: collision with root package name */
        public final PooledByteBufferFactory f18268e;

        /* renamed from: f, reason: collision with root package name */
        public final ByteArrayPool f18269f;

        /* renamed from: g, reason: collision with root package name */
        public final EncodedImage f18270g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f18271h;

        public PartialDiskCacheConsumer(Consumer consumer, Supplier supplier, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage encodedImage, boolean z) {
            super(consumer);
            this.f18266c = supplier;
            this.f18267d = cacheKey;
            this.f18268e = pooledByteBufferFactory;
            this.f18269f = byteArrayPool;
            this.f18270g = encodedImage;
            this.f18271h = z;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) throws IOException {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (BaseConsumer.e(i2)) {
                return;
            }
            CacheKey cacheKey = this.f18267d;
            Supplier supplier = this.f18266c;
            Consumer consumer = this.f18138b;
            EncodedImage encodedImage2 = this.f18270g;
            if (encodedImage2 != null && encodedImage != null && encodedImage.f17964i != null) {
                try {
                    try {
                        n(m(encodedImage2, encodedImage));
                    } catch (IOException e2) {
                        FLog.h("PartialDiskCacheProducer", "Error while merging image data", e2);
                        consumer.onFailure(e2);
                    }
                    ((DiskCachesStore) supplier.get()).b().e(cacheKey);
                    return;
                } finally {
                    encodedImage.close();
                    encodedImage2.close();
                }
            }
            if (this.f18271h && BaseConsumer.k(i2, 8) && BaseConsumer.d(i2) && encodedImage != null) {
                encodedImage.Z();
                if (encodedImage.f17957b != ImageFormat.f17694c) {
                    ((DiskCachesStore) supplier.get()).b().c(cacheKey, encodedImage);
                    consumer.b(i2, encodedImage);
                    return;
                }
            }
            consumer.b(i2, encodedImage);
        }

        public final void l(InputStream inputStream, PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2) throws IOException {
            ByteArrayPool byteArrayPool = this.f18269f;
            byte[] bArr = (byte[]) byteArrayPool.get(16384);
            int i3 = i2;
            while (i3 > 0) {
                try {
                    int i4 = inputStream.read(bArr, 0, Math.min(16384, i3));
                    if (i4 < 0) {
                        break;
                    } else if (i4 > 0) {
                        pooledByteBufferOutputStream.write(bArr, 0, i4);
                        i3 -= i4;
                    }
                } finally {
                    byteArrayPool.a(bArr);
                }
            }
            if (i3 > 0) {
                throw new IOException(b.e(i2, i3, "Failed to read ", " bytes - finished ", " short"));
            }
        }

        public final PooledByteBufferOutputStream m(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            BytesRange bytesRange = encodedImage2.f17964i;
            bytesRange.getClass();
            int iA = encodedImage2.A();
            int i2 = bytesRange.f17774a;
            MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStreamE = this.f18268e.e(iA + i2);
            InputStream inputStreamS = encodedImage.s();
            inputStreamS.getClass();
            l(inputStreamS, memoryPooledByteBufferOutputStreamE, i2);
            InputStream inputStreamS2 = encodedImage2.s();
            inputStreamS2.getClass();
            l(inputStreamS2, memoryPooledByteBufferOutputStreamE, encodedImage2.A());
            return memoryPooledByteBufferOutputStreamE;
        }

        public final void n(PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Throwable {
            EncodedImage encodedImage;
            Throwable th;
            DefaultCloseableReference defaultCloseableReferenceD = CloseableReference.D(pooledByteBufferOutputStream.a());
            try {
                encodedImage = new EncodedImage(defaultCloseableReferenceD);
            } catch (Throwable th2) {
                encodedImage = null;
                th = th2;
            }
            try {
                encodedImage.D();
                this.f18138b.b(1, encodedImage);
                encodedImage.close();
                defaultCloseableReferenceD.close();
            } catch (Throwable th3) {
                th = th3;
                EncodedImage.b(encodedImage);
                CloseableReference.e(defaultCloseableReferenceD);
                throw th;
            }
        }
    }

    public static Map c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i2) {
        if (producerListener2.e(producerContext, "PartialDiskCacheProducer")) {
            return z ? ImmutableMap.b("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2)) : ImmutableMap.a("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        ImageRequest imageRequestD = producerContext.D();
        boolean zN = producerContext.D().n(16);
        boolean zN2 = producerContext.D().n(32);
        if (!zN && !zN2) {
            throw null;
        }
        producerContext.s().c(producerContext, "PartialDiskCacheProducer");
        imageRequestD.f18348b.buildUpon().appendQueryParameter("fresco_partial", "true").build();
        throw null;
    }

    public final void d(Consumer consumer, ProducerContext producerContext, CacheKey cacheKey, EncodedImage encodedImage) {
        new PartialDiskCacheConsumer(consumer, null, cacheKey, null, null, encodedImage, producerContext.D().n(32));
        throw null;
    }
}
