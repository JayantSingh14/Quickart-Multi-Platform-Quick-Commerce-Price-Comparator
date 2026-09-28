package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f18139a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f18140b;

    /* renamed from: c, reason: collision with root package name */
    public final DiskCacheWriteProducer f18141c;

    public DiskCacheReadProducer(Supplier supplier, CacheKeyFactory cacheKeyFactory, DiskCacheWriteProducer diskCacheWriteProducer) {
        this.f18139a = supplier;
        this.f18140b = cacheKeyFactory;
        this.f18141c = diskCacheWriteProducer;
    }

    public static Map c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i2) {
        if (producerListener2.e(producerContext, "DiskCacheProducer")) {
            return z ? ImmutableMap.b("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2)) : ImmutableMap.a("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.facebook.imagepipeline.producers.Producer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(final com.facebook.imagepipeline.producers.Consumer r13, final com.facebook.imagepipeline.producers.ProducerContext r14) {
        /*
            r12 = this;
            com.facebook.imagepipeline.request.ImageRequest r0 = r14.D()
            com.facebook.imagepipeline.request.ImageRequest r1 = r14.D()
            r2 = 16
            boolean r1 = r1.n(r2)
            com.facebook.imagepipeline.producers.DiskCacheWriteProducer r2 = r12.f18141c
            r3 = 1
            java.lang.String r4 = "nil-result_read"
            java.lang.String r5 = "disk"
            r6 = 2
            r7 = 0
            if (r1 != 0) goto L2c
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = r14.Z()
            int r0 = r0.f18369a
            if (r0 < r6) goto L28
            r14.e(r5, r4)
            r13.b(r3, r7)
            return
        L28:
            r2.b(r13, r14)
            return
        L2c:
            com.facebook.imagepipeline.producers.ProducerListener2 r1 = r14.s()
            java.lang.String r8 = "DiskCacheProducer"
            r1.c(r14, r8)
            com.facebook.imagepipeline.cache.CacheKeyFactory r1 = r12.f18140b
            java.lang.Object r9 = r14.a()
            com.facebook.cache.common.SimpleCacheKey r1 = r1.d(r0, r9)
            com.facebook.common.internal.Supplier r9 = r12.f18139a
            java.lang.Object r9 = r9.get()
            com.facebook.imagepipeline.core.DiskCachesStore r9 = (com.facebook.imagepipeline.core.DiskCachesStore) r9
            com.facebook.imagepipeline.cache.BufferedDiskCache r10 = r9.a()
            com.facebook.imagepipeline.cache.BufferedDiskCache r11 = r9.b()
            com.facebook.common.internal.ImmutableMap r9 = r9.c()
            com.facebook.imagepipeline.cache.BufferedDiskCache r9 = com.facebook.imagepipeline.producers.DiskCacheDecision.a(r0, r10, r11, r9)
            if (r9 != 0) goto L94
            com.facebook.imagepipeline.producers.ProducerListener2 r1 = r14.s()
            com.facebook.imagepipeline.producers.DiskCacheDecision$DiskCacheDecisionNoDiskCacheChosenException r9 = new com.facebook.imagepipeline.producers.DiskCacheDecision$DiskCacheDecisionNoDiskCacheChosenException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Got no disk cache for CacheChoice: "
            r10.<init>(r11)
            com.facebook.imagepipeline.request.ImageRequest$CacheChoice r0 = r0.f18347a
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = r0.toString()
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r9.<init>(r0)
            r1.k(r14, r8, r9, r7)
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = r14.Z()
            int r0 = r0.f18369a
            if (r0 < r6) goto L90
            r14.e(r5, r4)
            r13.b(r3, r7)
            return
        L90:
            r2.b(r13, r14)
            return
        L94:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r2 = 0
            r0.<init>(r2)
            r9.getClass()
            java.lang.String r2 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "isCancelled"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            com.facebook.imagepipeline.systrace.FrescoSystrace.a()
            com.facebook.imagepipeline.cache.StagingArea r2 = r9.f17736g
            com.facebook.imagepipeline.image.EncodedImage r2 = r2.b(r1)
            if (r2 == 0) goto Lcd
            java.lang.String r3 = r1.a()
            java.lang.Class<com.facebook.imagepipeline.cache.BufferedDiskCache> r4 = com.facebook.imagepipeline.cache.BufferedDiskCache.class
            java.lang.String r5 = "Found image for %s in staging area"
            com.facebook.common.logging.FLog.l(r4, r5, r3)
            com.facebook.imagepipeline.cache.ImageCacheStatsTracker r3 = r9.f17735f
            r3.getClass()
            bolts.Task r2 = bolts.Task.d(r2)
            java.lang.String r3 = "forResult(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r2 != 0) goto Lee
        Lcd:
            androidx.work.impl.a r2 = new androidx.work.impl.a     // Catch: java.lang.Exception -> Ldb
            r3 = 1
            r2.<init>(r0, r9, r1, r3)     // Catch: java.lang.Exception -> Ldb
            java.util.concurrent.Executor r3 = r9.f17733d     // Catch: java.lang.Exception -> Ldb
            bolts.Task r1 = bolts.Task.a(r2, r3)     // Catch: java.lang.Exception -> Ldb
        Ld9:
            r2 = r1
            goto Lee
        Ldb:
            r2 = move-exception
            java.lang.String r1 = r1.a()
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r3 = "Failed to schedule disk-cache read for %s"
            com.facebook.common.logging.FLog.u(r3, r1, r2)
            bolts.Task r1 = bolts.Task.c(r2)
            goto Ld9
        Lee:
            com.facebook.imagepipeline.producers.ProducerListener2 r1 = r14.s()
            com.facebook.imagepipeline.producers.DiskCacheReadProducer$1 r3 = new com.facebook.imagepipeline.producers.DiskCacheReadProducer$1
            r3.<init>()
            r2.b(r3)
            com.facebook.imagepipeline.producers.DiskCacheReadProducer$2 r13 = new com.facebook.imagepipeline.producers.DiskCacheReadProducer$2
            r13.<init>()
            r14.b(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DiskCacheReadProducer.b(com.facebook.imagepipeline.producers.Consumer, com.facebook.imagepipeline.producers.ProducerContext):void");
    }
}
