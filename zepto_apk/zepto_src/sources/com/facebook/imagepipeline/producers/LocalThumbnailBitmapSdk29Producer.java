package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.BaseCloseableImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

@RequiresApi
@Nullsafe
/* loaded from: classes3.dex */
public class LocalThumbnailBitmapSdk29Producer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18225a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f18226b;

    public LocalThumbnailBitmapSdk29Producer(Executor executor, ContentResolver contentResolver) {
        this.f18225a = executor;
        this.f18226b = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener2S = producerContext.s();
        final ImageRequest imageRequestD = producerContext.D();
        producerContext.e(ImagesContract.LOCAL, "thumbnail_bitmap");
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, producerListener2S, producerContext) { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.1
            @Override // com.facebook.common.executors.StatefulRunnable
            public final void b(Object obj) {
                CloseableReference.e((CloseableReference) obj);
            }

            @Override // com.facebook.common.executors.StatefulRunnable
            public final Object c() throws IOException {
                String strA;
                LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = LocalThumbnailBitmapSdk29Producer.this;
                ImageRequest imageRequest = imageRequestD;
                ResizeOptions resizeOptions = imageRequest.f18354h;
                int i2 = resizeOptions != null ? resizeOptions.f17787a : 2048;
                Uri uri = imageRequest.f18348b;
                Size size = new Size(i2, resizeOptions != null ? resizeOptions.f17788b : 2048);
                try {
                    localThumbnailBitmapSdk29Producer.getClass();
                    strA = UriUtil.a(localThumbnailBitmapSdk29Producer.f18226b, uri);
                } catch (IllegalArgumentException unused) {
                    strA = null;
                }
                CancellationSignal cancellationSignal2 = cancellationSignal;
                Bitmap bitmapCreateVideoThumbnail = strA != null ? MediaUtils.b(MediaUtils.a(strA)) ? ThumbnailUtils.createVideoThumbnail(new File(strA), size, cancellationSignal2) : ThumbnailUtils.createImageThumbnail(new File(strA), size, cancellationSignal2) : null;
                if (bitmapCreateVideoThumbnail == null) {
                    bitmapCreateVideoThumbnail = localThumbnailBitmapSdk29Producer.f18226b.loadThumbnail(uri, size, cancellationSignal2);
                }
                if (bitmapCreateVideoThumbnail == null) {
                    return null;
                }
                Closeable closeableQ0 = CloseableStaticBitmap.q0(bitmapCreateVideoThumbnail, SimpleBitmapReleaser.b(), ImmutableQualityInfo.f17971d);
                ProducerContext producerContext2 = producerContext;
                producerContext2.V("thumbnail", "image_format");
                ((BaseCloseableImage) closeableQ0).N(producerContext2.getExtras());
                return CloseableReference.D(closeableQ0);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void d() {
                super.d();
                cancellationSignal.cancel();
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void e(Exception exc) {
                super.e(exc);
                ProducerListener2 producerListener2 = producerListener2S;
                ProducerContext producerContext2 = producerContext;
                producerListener2.b(producerContext2, "LocalThumbnailBitmapSdk29Producer", false);
                producerContext2.e(ImagesContract.LOCAL, "thumbnail_bitmap");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void f(Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                super.f(closeableReference);
                boolean z = closeableReference != null;
                ProducerListener2 producerListener2 = producerListener2S;
                ProducerContext producerContext2 = producerContext;
                producerListener2.b(producerContext2, "LocalThumbnailBitmapSdk29Producer", z);
                producerContext2.e(ImagesContract.LOCAL, "thumbnail_bitmap");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public final Map g(Object obj) {
                return ImmutableMap.a("createdThumbnail", String.valueOf(((CloseableReference) obj) != null));
            }
        };
        producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                statefulProducerRunnable.a();
            }
        });
        this.f18225a.execute(statefulProducerRunnable);
    }
}
