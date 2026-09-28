package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18233a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f18234b;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.f18233a = executor;
        this.f18234b = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener2S = producerContext.s();
        final ImageRequest imageRequestD = producerContext.D();
        producerContext.e(ImagesContract.LOCAL, "video");
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, producerListener2S, producerContext) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
            @Override // com.facebook.common.executors.StatefulRunnable
            public final void b(Object obj) {
                CloseableReference.e((CloseableReference) obj);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            @Override // com.facebook.common.executors.StatefulRunnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object c() throws java.lang.Throwable {
                /*
                    r8 = this;
                    com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer r0 = com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.this
                    com.facebook.imagepipeline.request.ImageRequest r1 = r7
                    r2 = 0
                    r0.getClass()     // Catch: java.lang.IllegalArgumentException -> L11
                    android.net.Uri r3 = r1.f18348b     // Catch: java.lang.IllegalArgumentException -> L11
                    android.content.ContentResolver r4 = r0.f18234b     // Catch: java.lang.IllegalArgumentException -> L11
                    java.lang.String r3 = com.facebook.common.util.UriUtil.a(r4, r3)     // Catch: java.lang.IllegalArgumentException -> L11
                    goto L12
                L11:
                    r3 = r2
                L12:
                    if (r3 == 0) goto L31
                    com.facebook.imagepipeline.common.ResizeOptions r4 = r1.f18354h
                    r5 = 2048(0x800, float:2.87E-42)
                    if (r4 == 0) goto L1d
                    int r6 = r4.f17787a
                    goto L1e
                L1d:
                    r6 = r5
                L1e:
                    r7 = 96
                    if (r6 > r7) goto L2b
                    if (r4 == 0) goto L26
                    int r5 = r4.f17788b
                L26:
                    if (r5 <= r7) goto L29
                    goto L2b
                L29:
                    r4 = 3
                    goto L2c
                L2b:
                    r4 = 1
                L2c:
                    android.graphics.Bitmap r3 = android.media.ThumbnailUtils.createVideoThumbnail(r3, r4)
                    goto L32
                L31:
                    r3 = r2
                L32:
                    if (r3 != 0) goto L6c
                    android.content.ContentResolver r0 = r0.f18234b
                    android.net.Uri r1 = r1.f18348b
                    java.lang.String r3 = "r"
                    android.os.ParcelFileDescriptor r0 = r0.openFileDescriptor(r1, r3)     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L5d
                    r0.getClass()     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L5d
                    android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L5d
                    r1.<init>()     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L5d
                    java.io.FileDescriptor r0 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L58 java.io.FileNotFoundException -> L65
                    r1.setDataSource(r0)     // Catch: java.lang.Throwable -> L58 java.io.FileNotFoundException -> L65
                    r3 = -1
                    android.graphics.Bitmap r0 = r1.getFrameAtTime(r3)     // Catch: java.lang.Throwable -> L58 java.io.FileNotFoundException -> L65
                    r1.release()     // Catch: java.io.IOException -> L56
                L56:
                    r3 = r0
                    goto L6c
                L58:
                    r0 = move-exception
                    r2 = r1
                    goto L5f
                L5b:
                    r0 = move-exception
                    goto L5f
                L5d:
                    r1 = r2
                    goto L65
                L5f:
                    if (r2 == 0) goto L64
                    r2.release()     // Catch: java.io.IOException -> L64
                L64:
                    throw r0
                L65:
                    if (r1 == 0) goto L6a
                    r1.release()     // Catch: java.io.IOException -> L6a
                L6a:
                    r0 = r2
                    goto L56
                L6c:
                    if (r3 != 0) goto L6f
                    goto L90
                L6f:
                    com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r0 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.b()
                    com.facebook.imagepipeline.image.ImmutableQualityInfo r1 = com.facebook.imagepipeline.image.ImmutableQualityInfo.f17971d
                    com.facebook.imagepipeline.image.CloseableStaticBitmap r0 = com.facebook.imagepipeline.image.CloseableStaticBitmap.q0(r3, r0, r1)
                    java.lang.String r1 = "image_format"
                    java.lang.String r2 = "thumbnail"
                    com.facebook.imagepipeline.producers.ProducerContext r3 = r6
                    r3.V(r2, r1)
                    java.util.Map r1 = r3.getExtras()
                    r2 = r0
                    com.facebook.imagepipeline.image.BaseCloseableImage r2 = (com.facebook.imagepipeline.image.BaseCloseableImage) r2
                    r2.N(r1)
                    com.facebook.common.references.DefaultCloseableReference r2 = com.facebook.common.references.CloseableReference.D(r0)
                L90:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.AnonymousClass1.c():java.lang.Object");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void e(Exception exc) {
                super.e(exc);
                ProducerListener2 producerListener2 = producerListener2S;
                ProducerContext producerContext2 = producerContext;
                producerListener2.b(producerContext2, "VideoThumbnailProducer", false);
                producerContext2.e(ImagesContract.LOCAL, "video");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void f(Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                super.f(closeableReference);
                boolean z = closeableReference != null;
                ProducerListener2 producerListener2 = producerListener2S;
                ProducerContext producerContext2 = producerContext;
                producerListener2.b(producerContext2, "VideoThumbnailProducer", z);
                producerContext2.e(ImagesContract.LOCAL, "video");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public final Map g(Object obj) {
                return ImmutableMap.a("createdThumbnail", String.valueOf(((CloseableReference) obj) != null));
            }
        };
        producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                statefulProducerRunnable.a();
            }
        });
        this.f18233a.execute(statefulProducerRunnable);
    }
}
