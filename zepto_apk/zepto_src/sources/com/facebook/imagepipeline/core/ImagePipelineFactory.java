package com.facebook.imagepipeline.core;

import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.LruCountingMemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.DefaultDecoder;
import com.facebook.imagepipeline.platform.OreoDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.reflect.Constructor;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.jvm.internal.Intrinsics;

@NotThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public class ImagePipelineFactory {
    public static ImagePipelineFactory p;
    public static ImagePipeline q;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadHandoffProducerQueueImpl f17875a;

    /* renamed from: b, reason: collision with root package name */
    public final ImagePipelineConfig f17876b;

    /* renamed from: c, reason: collision with root package name */
    public final CloseableReferenceFactory f17877c;

    /* renamed from: d, reason: collision with root package name */
    public final Supplier f17878d;

    /* renamed from: e, reason: collision with root package name */
    public CountingMemoryCache f17879e;

    /* renamed from: f, reason: collision with root package name */
    public InstrumentedMemoryCache f17880f;

    /* renamed from: g, reason: collision with root package name */
    public LruCountingMemoryCache f17881g;

    /* renamed from: h, reason: collision with root package name */
    public InstrumentedMemoryCache f17882h;

    /* renamed from: i, reason: collision with root package name */
    public ImageDecoder f17883i;

    /* renamed from: j, reason: collision with root package name */
    public MultiImageTranscoderFactory f17884j;

    /* renamed from: k, reason: collision with root package name */
    public ProducerFactory f17885k;

    /* renamed from: l, reason: collision with root package name */
    public ProducerSequenceFactory f17886l;

    /* renamed from: m, reason: collision with root package name */
    public ArtBitmapFactory f17887m;
    public DefaultDecoder n;
    public AnimatedFactory o;

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        FrescoSystrace.a();
        this.f17876b = imagePipelineConfig;
        ImagePipelineExperiments imagePipelineExperiments = imagePipelineConfig.w;
        imagePipelineExperiments.getClass();
        this.f17875a = new ThreadHandoffProducerQueueImpl(imagePipelineConfig.f17842i.f17798d);
        this.f17877c = new CloseableReferenceFactory(imagePipelineConfig.y);
        FrescoSystrace.a();
        this.f17878d = imagePipelineConfig.f17840g;
        if (imagePipelineExperiments.f17867i) {
            ImageFormatChecker.b().c();
        }
    }

    public final AnimatedFactory a() {
        if (this.o == null) {
            PlatformBitmapFactory platformBitmapFactoryE = e();
            ImagePipelineConfig imagePipelineConfig = this.f17876b;
            DefaultExecutorSupplier defaultExecutorSupplier = imagePipelineConfig.f17842i;
            CountingMemoryCache countingMemoryCacheB = b();
            ImagePipelineExperiments imagePipelineExperiments = imagePipelineConfig.w;
            imagePipelineExperiments.getClass();
            imagePipelineExperiments.getClass();
            int i2 = imagePipelineExperiments.f17865g;
            imagePipelineExperiments.getClass();
            if (!AnimatedFactoryProvider.f17701a) {
                try {
                    Class<?> cls = Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl");
                    Class cls2 = Boolean.TYPE;
                    Class cls3 = Integer.TYPE;
                    Constructor<?> constructor = cls.getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, cls2, cls2, cls3, cls3, SerialExecutorService.class);
                    Boolean bool = Boolean.FALSE;
                    Object objNewInstance = constructor.newInstance(platformBitmapFactoryE, defaultExecutorSupplier, countingMemoryCacheB, bool, bool, Integer.valueOf(i2), 1000, null);
                    Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.animated.factory.AnimatedFactory");
                    AnimatedFactoryProvider.f17702b = (AnimatedFactory) objNewInstance;
                } catch (Throwable unused) {
                }
                if (AnimatedFactoryProvider.f17702b != null) {
                    AnimatedFactoryProvider.f17701a = true;
                }
            }
            this.o = AnimatedFactoryProvider.f17702b;
        }
        return this.o;
    }

    public final CountingMemoryCache b() {
        if (this.f17879e == null) {
            ImagePipelineConfig imagePipelineConfig = this.f17876b;
            CountingLruBitmapMemoryCacheFactory countingLruBitmapMemoryCacheFactory = imagePipelineConfig.z;
            ImagePipelineExperiments imagePipelineExperiments = imagePipelineConfig.w;
            imagePipelineExperiments.getClass();
            imagePipelineExperiments.getClass();
            this.f17879e = countingLruBitmapMemoryCacheFactory.a(imagePipelineConfig.f17834a, imagePipelineConfig.n, imagePipelineConfig.f17835b, null);
        }
        return this.f17879e;
    }

    public final InstrumentedMemoryCache c() {
        if (this.f17882h == null) {
            ImagePipelineConfig imagePipelineConfig = this.f17876b;
            imagePipelineConfig.getClass();
            if (this.f17881g == null) {
                this.f17881g = EncodedCountingMemoryCacheFactory.a(imagePipelineConfig.f17841h, imagePipelineConfig.n, imagePipelineConfig.f17836c);
            }
            this.f17882h = EncodedMemoryCacheFactory.a(this.f17881g, imagePipelineConfig.f17843j);
        }
        return this.f17882h;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 com.facebook.imagepipeline.core.ImagePipeline, still in use, count: 3, list:
          (r2v0 com.facebook.imagepipeline.core.ImagePipeline) from 0x0169: MOVE (r31v0 com.facebook.imagepipeline.core.ImagePipeline) = (r2v0 com.facebook.imagepipeline.core.ImagePipeline) (LINE:362)
          (r2v0 com.facebook.imagepipeline.core.ImagePipeline) from 0x012d: MOVE (r31v2 com.facebook.imagepipeline.core.ImagePipeline) = (r2v0 com.facebook.imagepipeline.core.ImagePipeline) (LINE:302)
          (r2v0 com.facebook.imagepipeline.core.ImagePipeline) from 0x00ac: MOVE (r31v4 com.facebook.imagepipeline.core.ImagePipeline) = (r2v0 com.facebook.imagepipeline.core.ImagePipeline) (LINE:173)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final com.facebook.imagepipeline.core.ImagePipeline d() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineFactory.d():com.facebook.imagepipeline.core.ImagePipeline");
    }

    public final PlatformBitmapFactory e() {
        if (this.f17887m == null) {
            PoolFactory poolFactory = this.f17876b.p;
            PlatformDecoder platformDecoder = f();
            Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
            Intrinsics.checkNotNullParameter(platformDecoder, "platformDecoder");
            CloseableReferenceFactory closeableReferenceFactory = this.f17877c;
            Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
            BitmapPool bitmapPoolA = poolFactory.a();
            Intrinsics.checkNotNullExpressionValue(bitmapPoolA, "getBitmapPool(...)");
            this.f17887m = new ArtBitmapFactory(bitmapPoolA, closeableReferenceFactory);
        }
        return this.f17887m;
    }

    public final PlatformDecoder f() {
        DefaultDecoder artDecoder;
        if (this.n == null) {
            ImagePipelineConfig imagePipelineConfig = this.f17876b;
            PoolFactory poolFactory = imagePipelineConfig.p;
            ImagePipelineExperiments imagePipelineExperiments = imagePipelineConfig.w;
            imagePipelineExperiments.getClass();
            imagePipelineExperiments.getClass();
            PlatformDecoderOptions platformDecoderOptions = imagePipelineExperiments.f17866h;
            Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
            Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
            if (Build.VERSION.SDK_INT >= 26) {
                BitmapPool bitmapPool = poolFactory.a();
                Intrinsics.checkNotNullExpressionValue(bitmapPool, "getBitmapPool(...)");
                Pools.Pool decodeBuffers = PlatformDecoderFactory.a(poolFactory);
                Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
                Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
                Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
                artDecoder = new OreoDecoder(bitmapPool, decodeBuffers, platformDecoderOptions);
            } else {
                BitmapPool bitmapPoolA = poolFactory.a();
                Intrinsics.checkNotNullExpressionValue(bitmapPoolA, "getBitmapPool(...)");
                artDecoder = new ArtDecoder(bitmapPoolA, PlatformDecoderFactory.a(poolFactory), platformDecoderOptions);
            }
            this.n = artDecoder;
        }
        return this.n;
    }
}
