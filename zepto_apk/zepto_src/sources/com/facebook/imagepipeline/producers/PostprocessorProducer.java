package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.BaseCloseableImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final Producer f18279a;

    /* renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f18280b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f18281c;

    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerListener2 f18282c;

        /* renamed from: d, reason: collision with root package name */
        public final ProducerContext f18283d;

        /* renamed from: e, reason: collision with root package name */
        public final Postprocessor f18284e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f18285f;

        /* renamed from: g, reason: collision with root package name */
        public CloseableReference f18286g;

        /* renamed from: h, reason: collision with root package name */
        public int f18287h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f18288i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f18289j;

        /* renamed from: com.facebook.imagepipeline.producers.PostprocessorProducer$PostprocessorConsumer$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                CloseableReference closeableReference;
                int i2;
                boolean zP;
                synchronized (PostprocessorConsumer.this) {
                    PostprocessorConsumer postprocessorConsumer = PostprocessorConsumer.this;
                    closeableReference = postprocessorConsumer.f18286g;
                    i2 = postprocessorConsumer.f18287h;
                    postprocessorConsumer.f18286g = null;
                    postprocessorConsumer.f18288i = false;
                }
                if (CloseableReference.A(closeableReference)) {
                    try {
                        PostprocessorConsumer.l(PostprocessorConsumer.this, closeableReference, i2);
                        closeableReference.close();
                    } catch (Throwable th) {
                        CloseableReference.e(closeableReference);
                        throw th;
                    }
                }
                PostprocessorConsumer postprocessorConsumer2 = PostprocessorConsumer.this;
                synchronized (postprocessorConsumer2) {
                    postprocessorConsumer2.f18289j = false;
                    zP = postprocessorConsumer2.p();
                }
                if (zP) {
                    PostprocessorProducer.this.f18281c.execute(postprocessorConsumer2.new AnonymousClass2());
                }
            }
        }

        public PostprocessorConsumer(Consumer consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.f18286g = null;
            this.f18287h = 0;
            this.f18288i = false;
            this.f18289j = false;
            this.f18282c = producerListener2;
            this.f18284e = postprocessor;
            this.f18283d = producerContext;
            producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void b() {
                    PostprocessorConsumer postprocessorConsumer = PostprocessorConsumer.this;
                    if (postprocessorConsumer.m()) {
                        postprocessorConsumer.f18138b.a();
                    }
                }
            });
        }

        public static void l(PostprocessorConsumer postprocessorConsumer, CloseableReference closeableReference, int i2) throws Throwable {
            Postprocessor postprocessor = postprocessorConsumer.f18284e;
            if (!CloseableReference.A(closeableReference)) {
                throw new IllegalArgumentException();
            }
            if (!(((CloseableImage) closeableReference.l()) instanceof CloseableStaticBitmap)) {
                postprocessorConsumer.n(closeableReference, i2);
                return;
            }
            ProducerListener2 producerListener2 = postprocessorConsumer.f18282c;
            ProducerContext producerContext = postprocessorConsumer.f18283d;
            producerListener2.c(producerContext, "PostprocessorProducer");
            DefaultCloseableReference defaultCloseableReference = null;
            Map mapA = null;
            try {
                try {
                    DefaultCloseableReference defaultCloseableReferenceO = postprocessorConsumer.o((CloseableImage) closeableReference.l());
                    try {
                        if (producerListener2.e(producerContext, "PostprocessorProducer")) {
                            mapA = ImmutableMap.a("Postprocessor", postprocessor.getName());
                        }
                        producerListener2.i(producerContext, "PostprocessorProducer", mapA);
                        postprocessorConsumer.n(defaultCloseableReferenceO, i2);
                        CloseableReference.e(defaultCloseableReferenceO);
                    } catch (Throwable th) {
                        th = th;
                        defaultCloseableReference = defaultCloseableReferenceO;
                        CloseableReference.e(defaultCloseableReference);
                        throw th;
                    }
                } catch (Exception e2) {
                    producerListener2.k(producerContext, "PostprocessorProducer", e2, !producerListener2.e(producerContext, "PostprocessorProducer") ? null : ImmutableMap.a("Postprocessor", postprocessor.getName()));
                    if (postprocessorConsumer.m()) {
                        postprocessorConsumer.f18138b.onFailure(e2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void f() {
            if (m()) {
                this.f18138b.a();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            if (m()) {
                this.f18138b.onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.A(closeableReference)) {
                if (BaseConsumer.d(i2)) {
                    n(null, i2);
                    return;
                }
                return;
            }
            synchronized (this) {
                try {
                    if (this.f18285f) {
                        return;
                    }
                    CloseableReference closeableReference2 = this.f18286g;
                    this.f18286g = CloseableReference.c(closeableReference);
                    this.f18287h = i2;
                    this.f18288i = true;
                    boolean zP = p();
                    CloseableReference.e(closeableReference2);
                    if (zP) {
                        PostprocessorProducer.this.f18281c.execute(new AnonymousClass2());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean m() {
            synchronized (this) {
                try {
                    if (this.f18285f) {
                        return false;
                    }
                    CloseableReference closeableReference = this.f18286g;
                    this.f18286g = null;
                    this.f18285f = true;
                    CloseableReference.e(closeableReference);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void n(com.facebook.common.references.CloseableReference r3, int r4) {
            /*
                r2 = this;
                boolean r0 = com.facebook.imagepipeline.producers.BaseConsumer.d(r4)
                if (r0 != 0) goto L10
                monitor-enter(r2)
                boolean r1 = r2.f18285f     // Catch: java.lang.Throwable -> Ld
                monitor-exit(r2)
                if (r1 == 0) goto L18
                goto L10
            Ld:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Ld
                throw r3
            L10:
                if (r0 == 0) goto L1d
                boolean r0 = r2.m()
                if (r0 == 0) goto L1d
            L18:
                com.facebook.imagepipeline.producers.Consumer r0 = r2.f18138b
                r0.b(r4, r3)
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.n(com.facebook.common.references.CloseableReference, int):void");
        }

        public final DefaultCloseableReference o(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference closeableReferenceC = this.f18284e.c(closeableStaticBitmap.v1(), PostprocessorProducer.this.f18280b);
            try {
                Closeable closeableQ = CloseableStaticBitmap.Q(closeableReferenceC, closeableImage.q1(), closeableStaticBitmap.X0(), closeableStaticBitmap.H0());
                ((BaseCloseableImage) closeableQ).N(closeableStaticBitmap.getExtras());
                return CloseableReference.D(closeableQ);
            } finally {
                CloseableReference.e(closeableReferenceC);
            }
        }

        public final synchronized boolean p() {
            if (this.f18285f || !this.f18288i || this.f18289j || !CloseableReference.A(this.f18286g)) {
                return false;
            }
            this.f18289j = true;
            return true;
        }
    }

    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {

        /* renamed from: c, reason: collision with root package name */
        public boolean f18293c;

        /* renamed from: d, reason: collision with root package name */
        public CloseableReference f18294d;

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void f() {
            if (l()) {
                this.f18138b.a();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            if (l()) {
                this.f18138b.onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.e(i2)) {
                return;
            }
            synchronized (this) {
                try {
                    if (!this.f18293c) {
                        CloseableReference closeableReference2 = this.f18294d;
                        this.f18294d = CloseableReference.c(closeableReference);
                        CloseableReference.e(closeableReference2);
                    }
                } finally {
                }
            }
            synchronized (this) {
                try {
                    if (this.f18293c) {
                        return;
                    }
                    CloseableReference closeableReferenceC = CloseableReference.c(this.f18294d);
                    try {
                        this.f18138b.b(0, closeableReferenceC);
                    } finally {
                        CloseableReference.e(closeableReferenceC);
                    }
                } finally {
                }
            }
        }

        public final boolean l() {
            synchronized (this) {
                try {
                    if (this.f18293c) {
                        return false;
                    }
                    CloseableReference closeableReference = this.f18294d;
                    this.f18294d = null;
                    this.f18293c = true;
                    CloseableReference.e(closeableReference);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.e(i2)) {
                return;
            }
            this.f18138b.b(i2, closeableReference);
        }
    }

    public PostprocessorProducer(Producer producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        producer.getClass();
        this.f18279a = producer;
        this.f18280b = platformBitmapFactory;
        executor.getClass();
        this.f18281c = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        SingleUsePostprocessorConsumer singleUsePostprocessorConsumer;
        ProducerListener2 producerListener2S = producerContext.s();
        Postprocessor postprocessor = producerContext.D().p;
        postprocessor.getClass();
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, producerListener2S, postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            final RepeatedPostprocessorConsumer repeatedPostprocessorConsumer = new RepeatedPostprocessorConsumer(postprocessorConsumer);
            repeatedPostprocessorConsumer.f18293c = false;
            repeatedPostprocessorConsumer.f18294d = null;
            ((RepeatedPostprocessor) postprocessor).b(repeatedPostprocessorConsumer);
            producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void b() {
                    RepeatedPostprocessorConsumer repeatedPostprocessorConsumer2 = RepeatedPostprocessorConsumer.this;
                    if (repeatedPostprocessorConsumer2.l()) {
                        repeatedPostprocessorConsumer2.f18138b.a();
                    }
                }
            });
            singleUsePostprocessorConsumer = repeatedPostprocessorConsumer;
        } else {
            singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        this.f18279a.b(singleUsePostprocessorConsumer, producerContext);
    }
}
