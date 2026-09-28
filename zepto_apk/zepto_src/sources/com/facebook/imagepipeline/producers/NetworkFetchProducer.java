package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public class NetworkFetchProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final PooledByteBufferFactory f18255a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f18256b;

    /* renamed from: c, reason: collision with root package name */
    public final NetworkFetcher f18257c;

    /* renamed from: com.facebook.imagepipeline.producers.NetworkFetchProducer$1, reason: invalid class name */
    class AnonymousClass1 implements NetworkFetcher.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FetchState f18258a;

        public AnonymousClass1(FetchState fetchState) {
            this.f18258a = fetchState;
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public final void a() {
            NetworkFetchProducer.this.getClass();
            FetchState fetchState = this.f18258a;
            fetchState.f18167b.s().g(fetchState.f18167b, "NetworkFetchProducer");
            fetchState.f18166a.a();
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public final void b(InputStream inputStream, int i2) throws Throwable {
            FrescoSystrace.a();
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            PooledByteBufferFactory pooledByteBufferFactory = networkFetchProducer.f18255a;
            MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStreamE = i2 > 0 ? pooledByteBufferFactory.e(i2) : pooledByteBufferFactory.c();
            ByteArrayPool byteArrayPool = networkFetchProducer.f18256b;
            byte[] bArr = (byte[]) byteArrayPool.get(16384);
            while (true) {
                try {
                    int i3 = inputStream.read(bArr);
                    FetchState fetchState = this.f18258a;
                    if (i3 < 0) {
                        networkFetchProducer.f18257c.d(fetchState);
                        networkFetchProducer.c(memoryPooledByteBufferOutputStreamE, fetchState);
                        byteArrayPool.a(bArr);
                        memoryPooledByteBufferOutputStreamE.close();
                        FrescoSystrace.a();
                        return;
                    }
                    if (i3 > 0) {
                        memoryPooledByteBufferOutputStreamE.write(bArr, 0, i3);
                        networkFetchProducer.d(memoryPooledByteBufferOutputStreamE, fetchState);
                        fetchState.f18166a.c(i2 > 0 ? memoryPooledByteBufferOutputStreamE.f18033c / i2 : 1.0f - ((float) Math.exp((-r4) / 50000.0d)));
                    }
                } catch (Throwable th) {
                    byteArrayPool.a(bArr);
                    memoryPooledByteBufferOutputStreamE.close();
                    throw th;
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public final void onFailure(Exception exc) {
            NetworkFetchProducer.this.getClass();
            FetchState fetchState = this.f18258a;
            ProducerListener2 producerListener2S = fetchState.f18167b.s();
            ProducerContext producerContext = fetchState.f18167b;
            producerListener2S.k(producerContext, "NetworkFetchProducer", exc, null);
            producerContext.s().b(producerContext, "NetworkFetchProducer", false);
            producerContext.r("network");
            fetchState.f18166a.onFailure(exc);
        }
    }

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.f18255a = pooledByteBufferFactory;
        this.f18256b = byteArrayPool;
        this.f18257c = networkFetcher;
    }

    public static void e(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2, BytesRange bytesRange, Consumer consumer) throws Throwable {
        EncodedImage encodedImage;
        DefaultCloseableReference defaultCloseableReferenceD = CloseableReference.D(pooledByteBufferOutputStream.a());
        EncodedImage encodedImage2 = null;
        try {
            encodedImage = new EncodedImage(defaultCloseableReferenceD);
        } catch (Throwable th) {
            th = th;
        }
        try {
            encodedImage.f17964i = bytesRange;
            encodedImage.D();
            consumer.b(i2, encodedImage);
            encodedImage.close();
            defaultCloseableReferenceD.close();
        } catch (Throwable th2) {
            th = th2;
            encodedImage2 = encodedImage;
            EncodedImage.b(encodedImage2);
            CloseableReference.e(defaultCloseableReferenceD);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        producerContext.s().c(producerContext, "NetworkFetchProducer");
        NetworkFetcher networkFetcher = this.f18257c;
        FetchState fetchStateC = networkFetcher.c(consumer, producerContext);
        networkFetcher.a(fetchStateC, new AnonymousClass1(fetchStateC));
    }

    public final void c(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) throws Throwable {
        int size = pooledByteBufferOutputStream.size();
        ProducerListener2 producerListener2S = fetchState.f18167b.s();
        ProducerContext producerContext = fetchState.f18167b;
        Map mapB = !producerListener2S.e(producerContext, "NetworkFetchProducer") ? null : this.f18257c.b(fetchState, size);
        ProducerListener2 producerListener2S2 = producerContext.s();
        producerListener2S2.i(producerContext, "NetworkFetchProducer", mapB);
        producerListener2S2.b(producerContext, "NetworkFetchProducer", true);
        producerContext.r("network");
        e(pooledByteBufferOutputStream, 1 | fetchState.f18169d, fetchState.f18170e, fetchState.f18166a);
    }

    public final void d(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) throws Throwable {
        if (fetchState.f18167b.c().a() != null) {
            ProducerContext producerContext = fetchState.f18167b;
            if (producerContext.x()) {
                this.f18257c.getClass();
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (jUptimeMillis - fetchState.f18168c >= 100) {
                    fetchState.f18168c = jUptimeMillis;
                    producerContext.s().a(producerContext);
                    e(pooledByteBufferOutputStream, fetchState.f18169d, fetchState.f18170e, fetchState.f18166a);
                }
            }
        }
    }
}
