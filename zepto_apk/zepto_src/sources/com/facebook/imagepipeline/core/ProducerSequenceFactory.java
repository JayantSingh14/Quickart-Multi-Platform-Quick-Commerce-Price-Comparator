package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import com.facebook.common.internal.Supplier;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.CustomProducerSequenceFactory;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ProducerSequenceFactory {
    public final Lazy A;
    public final Lazy B;

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f17903a;

    /* renamed from: b, reason: collision with root package name */
    public final ProducerFactory f17904b;

    /* renamed from: c, reason: collision with root package name */
    public final NetworkFetcher f17905c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17906d;

    /* renamed from: e, reason: collision with root package name */
    public final ThreadHandoffProducerQueueImpl f17907e;

    /* renamed from: f, reason: collision with root package name */
    public final DownsampleMode f17908f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f17909g;

    /* renamed from: h, reason: collision with root package name */
    public final MultiImageTranscoderFactory f17910h;

    /* renamed from: i, reason: collision with root package name */
    public final Set f17911i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f17912j;

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f17913k;

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f17914l;

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f17915m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    @Metadata
    public static final class Companion {
        public static final String a(Uri uri) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() <= 30) {
                return string;
            }
            String strSubstring = string.substring(0, 30);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring + "...";
        }
    }

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, ThreadHandoffProducerQueueImpl threadHandoffProducerQueue, DownsampleMode downsampleMode, boolean z2, MultiImageTranscoderFactory imageTranscoderFactory, Set set) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(producerFactory, "producerFactory");
        Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        Intrinsics.checkNotNullParameter(imageTranscoderFactory, "imageTranscoderFactory");
        this.f17903a = contentResolver;
        this.f17904b = producerFactory;
        this.f17905c = networkFetcher;
        this.f17906d = z;
        this.f17907e = threadHandoffProducerQueue;
        this.f17908f = downsampleMode;
        this.f17909g = z2;
        this.f17910h = imageTranscoderFactory;
        this.f17911i = set;
        this.f17912j = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        final int i2 = 0;
        this.f17913k = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i2) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i3 = 17;
        this.f17914l = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i3) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i4 = 1;
        this.f17915m = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i4) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i5 = 2;
        this.n = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i5) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i6 = 3;
        this.o = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i6) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i7 = 4;
        this.p = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i7) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i8 = 5;
        this.q = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i8) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i9 = 6;
        this.r = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i9) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i10 = 7;
        this.s = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i10) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i11 = 8;
        this.t = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i11) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i12 = 9;
        this.u = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i12) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i13 = 10;
        this.v = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i13) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i14 = 11;
        this.w = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i14) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i15 = 12;
        this.x = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i15) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i16 = 13;
        this.y = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i16) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i17 = 14;
        this.z = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i17) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i18 = 15;
        this.A = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i18) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
        final int i19 = 16;
        this.B = LazyKt.b(new Function0(this) { // from class: com.facebook.imagepipeline.core.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProducerSequenceFactory f17924b;

            {
                this.f17924b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                ResizeAndRotateProducer resizeAndRotateProducerA;
                boolean z3 = false;
                switch (i19) {
                    case 0:
                        ProducerSequenceFactory this$0 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$0.b());
                    case 1:
                        ProducerSequenceFactory this$02 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        FrescoSystrace.a();
                        Object value = this$02.t.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        return new RemoveImageTransformMetaDataProducer((Producer) value);
                    case 2:
                        ProducerSequenceFactory this$03 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$03, "this$0");
                        FrescoSystrace.a();
                        return this$03.h((Producer) this$03.q.getValue());
                    case 3:
                        ProducerSequenceFactory this$04 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$04, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory2 = this$04.f17904b;
                        Producer producer = (Producer) this$04.q.getValue();
                        producerFactory2.getClass();
                        return new ThreadHandoffProducer(producer, this$04.f17907e);
                    case 4:
                        ProducerSequenceFactory this$05 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$05, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory3 = this$05.f17904b;
                        Producer producerB = this$05.b();
                        producerFactory3.getClass();
                        return new SwallowResultProducer(producerB);
                    case 5:
                        ProducerSequenceFactory this$06 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$06, "this$0");
                        FrescoSystrace.a();
                        NetworkFetcher networkFetcher2 = this$06.f17905c;
                        synchronized (this$06) {
                            try {
                                Intrinsics.checkNotNullParameter(networkFetcher2, "networkFetcher");
                                FrescoSystrace.a();
                                ProducerFactory producerFactory4 = this$06.f17904b;
                                NetworkFetchProducer networkFetchProducer = new NetworkFetchProducer(producerFactory4.f17899j, producerFactory4.f17893d, networkFetcher2);
                                Intrinsics.checkNotNullExpressionValue(networkFetchProducer, "newNetworkFetchProducer(...)");
                                AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(this$06.j(networkFetchProducer));
                                Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
                                ProducerFactory producerFactory5 = this$06.f17904b;
                                if (this$06.f17906d && this$06.f17908f != DownsampleMode.f17818c) {
                                    z3 = true;
                                }
                                resizeAndRotateProducerA = producerFactory5.a(addImageTransformMetaDataProducer, z3, this$06.f17910h);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return resizeAndRotateProducerA;
                    case 6:
                        ProducerSequenceFactory this$07 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$07, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory6 = this$07.f17904b;
                        Producer producerA = this$07.a();
                        producerFactory6.getClass();
                        return new SwallowResultProducer(producerA);
                    case 7:
                        ProducerSequenceFactory this$08 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$08, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory7 = this$08.f17904b;
                        LocalFileFetchProducer localFileFetchProducer = new LocalFileFetchProducer(producerFactory7.f17898i.e(), producerFactory7.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer, "newLocalFileFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ = this$08.j(localFileFetchProducer);
                        this$08.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ, this$08.f17907e);
                    case 8:
                        ProducerSequenceFactory this$09 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$09, "this$0");
                        FrescoSystrace.a();
                        ProducerFactory producerFactory8 = this$09.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory8.f17898i.e(), producerFactory8.f17899j, producerFactory8.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
                        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerJ2 = this$09.j(localContentUriFetchProducer);
                        this$09.f17904b.getClass();
                        return new ThreadHandoffProducer(encodedCacheKeyMultiplexProducerJ2, this$09.f17907e);
                    case 9:
                        ProducerSequenceFactory this$010 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$010, "this$0");
                        ProducerFactory producerFactory9 = this$010.f17904b;
                        LocalFileFetchProducer localFileFetchProducer2 = new LocalFileFetchProducer(producerFactory9.f17898i.e(), producerFactory9.f17899j);
                        Intrinsics.checkNotNullExpressionValue(localFileFetchProducer2, "newLocalFileFetchProducer(...)");
                        ProducerFactory producerFactory10 = this$010.f17904b;
                        return this$010.i(localFileFetchProducer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory10.f17898i.f(), producerFactory10.f17899j, producerFactory10.f17890a)});
                    case 10:
                        ProducerSequenceFactory this$011 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$011, "this$0");
                        ProducerFactory producerFactory11 = this$011.f17904b;
                        LocalVideoThumbnailProducer localVideoThumbnailProducer = new LocalVideoThumbnailProducer(producerFactory11.f17898i.e(), producerFactory11.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
                        return this$011.g(localVideoThumbnailProducer);
                    case 11:
                        ProducerSequenceFactory this$012 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$012, "this$0");
                        ProducerFactory producerFactory12 = this$012.f17904b;
                        LocalContentUriFetchProducer localContentUriFetchProducer2 = new LocalContentUriFetchProducer(producerFactory12.f17898i.e(), producerFactory12.f17899j, producerFactory12.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
                        ProducerFactory producerFactory13 = this$012.f17904b;
                        producerFactory13.getClass();
                        ExecutorSupplier executorSupplier = producerFactory13.f17898i;
                        ExecutorService executorServiceE = executorSupplier.e();
                        ContentResolver contentResolver2 = producerFactory13.f17890a;
                        PooledByteBufferFactory pooledByteBufferFactory = producerFactory13.f17899j;
                        return this$012.i(localContentUriFetchProducer2, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(executorServiceE, pooledByteBufferFactory, contentResolver2), new LocalExifThumbnailProducer(executorSupplier.f(), pooledByteBufferFactory, producerFactory13.f17890a)});
                    case 12:
                        ProducerSequenceFactory this$013 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$013, "this$0");
                        if (Build.VERSION.SDK_INT < 29) {
                            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
                        }
                        ProducerFactory producerFactory14 = this$013.f17904b;
                        LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = new LocalThumbnailBitmapSdk29Producer(producerFactory14.f17898i.d(), producerFactory14.f17890a);
                        Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
                        return this$013.g(localThumbnailBitmapSdk29Producer);
                    case 13:
                        ProducerSequenceFactory this$014 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$014, "this$0");
                        ProducerFactory producerFactory15 = this$014.f17904b;
                        QualifiedResourceFetchProducer qualifiedResourceFetchProducer = new QualifiedResourceFetchProducer(producerFactory15.f17898i.e(), producerFactory15.f17899j, producerFactory15.f17890a);
                        Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
                        ProducerFactory producerFactory16 = this$014.f17904b;
                        return this$014.i(qualifiedResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory16.f17898i.f(), producerFactory16.f17899j, producerFactory16.f17890a)});
                    case 14:
                        ProducerSequenceFactory this$015 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$015, "this$0");
                        ProducerFactory producerFactory17 = this$015.f17904b;
                        LocalResourceFetchProducer localResourceFetchProducer = new LocalResourceFetchProducer(producerFactory17.f17898i.e(), producerFactory17.f17899j, producerFactory17.f17891b);
                        Intrinsics.checkNotNullExpressionValue(localResourceFetchProducer, "newLocalResourceFetchProducer(...)");
                        ProducerFactory producerFactory18 = this$015.f17904b;
                        return this$015.i(localResourceFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory18.f17898i.f(), producerFactory18.f17899j, producerFactory18.f17890a)});
                    case 15:
                        ProducerSequenceFactory this$016 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$016, "this$0");
                        ProducerFactory producerFactory19 = this$016.f17904b;
                        LocalAssetFetchProducer localAssetFetchProducer = new LocalAssetFetchProducer(producerFactory19.f17898i.e(), producerFactory19.f17899j, producerFactory19.f17892c);
                        Intrinsics.checkNotNullExpressionValue(localAssetFetchProducer, "newLocalAssetFetchProducer(...)");
                        ProducerFactory producerFactory20 = this$016.f17904b;
                        return this$016.i(localAssetFetchProducer, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory20.f17898i.f(), producerFactory20.f17899j, producerFactory20.f17890a)});
                    case 16:
                        ProducerSequenceFactory this$017 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$017, "this$0");
                        DataFetchProducer dataFetchProducer = new DataFetchProducer(this$017.f17904b.f17899j);
                        Intrinsics.checkNotNullExpressionValue(dataFetchProducer, "newDataFetchProducer(...)");
                        return this$017.h(this$017.f17904b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this$017.f17910h));
                    default:
                        ProducerSequenceFactory this$018 = this.f17924b;
                        Intrinsics.checkNotNullParameter(this$018, "this$0");
                        FrescoSystrace.a();
                        return new RemoveImageTransformMetaDataProducer(this$018.a());
                }
            }
        });
    }

    public final Producer a() {
        Object value = this.s.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    public final Producer b() {
        Object value = this.o.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Producer) value;
    }

    public final Producer c(ImageRequest imageRequest) {
        FrescoSystrace.a();
        Uri uriL = imageRequest.l();
        Intrinsics.checkNotNullExpressionValue(uriL, "getSourceUri(...)");
        if (uriL == null) {
            throw new IllegalStateException("Uri is null.");
        }
        int iM = imageRequest.m();
        if (iM == 0) {
            return (Producer) this.n.getValue();
        }
        Lazy lazy = this.v;
        switch (iM) {
            case 2:
                return imageRequest.d() ? e() : (Producer) lazy.getValue();
            case 3:
                return imageRequest.d() ? e() : (Producer) this.u.getValue();
            case 4:
                return imageRequest.d() ? e() : MediaUtils.b(this.f17903a.getType(uriL)) ? (Producer) lazy.getValue() : (Producer) this.w.getValue();
            case 5:
                return (Producer) this.A.getValue();
            case 6:
                return (Producer) this.z.getValue();
            case 7:
                return (Producer) this.B.getValue();
            case 8:
                return (Producer) this.y.getValue();
            default:
                Set set = this.f17911i;
                if (set != null) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((CustomProducerSequenceFactory) it.next()).getClass();
                    }
                }
                throw new IllegalArgumentException(android.support.v4.media.b.C("Unsupported uri scheme! Uri is: ", Companion.a(uriL)));
        }
    }

    public final Producer d(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.e().b() > ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.b()) {
            throw new IllegalArgumentException();
        }
        int iM = imageRequest.m();
        if (iM == 0) {
            Object value = this.p.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Producer) value;
        }
        if (iM == 2 || iM == 3) {
            Object value2 = this.r.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
            return (Producer) value2;
        }
        Uri uriL = imageRequest.l();
        Intrinsics.checkNotNullExpressionValue(uriL, "getSourceUri(...)");
        throw new IllegalArgumentException(android.support.v4.media.b.C("Unsupported uri scheme for encoded image fetch! Uri is: ", Companion.a(uriL)));
    }

    public final Producer e() {
        return (Producer) this.x.getValue();
    }

    public final synchronized Producer f(Producer producer) {
        Producer producer2;
        producer2 = (Producer) this.f17912j.get(producer);
        if (producer2 == null) {
            ProducerFactory producerFactory = this.f17904b;
            PostprocessorProducer postprocessorProducer = new PostprocessorProducer(producer, producerFactory.o, producerFactory.f17898i.d());
            Intrinsics.checkNotNullExpressionValue(postprocessorProducer, "newPostprocessorProducer(...)");
            ProducerFactory producerFactory2 = this.f17904b;
            PostprocessedBitmapMemoryCacheProducer postprocessedBitmapMemoryCacheProducer = new PostprocessedBitmapMemoryCacheProducer(producerFactory2.f17902m, producerFactory2.n, postprocessorProducer);
            this.f17912j.put(producer, postprocessedBitmapMemoryCacheProducer);
            producer2 = postprocessedBitmapMemoryCacheProducer;
        }
        return producer2;
    }

    public final Producer g(Producer producer) {
        ProducerFactory producerFactory = this.f17904b;
        InstrumentedMemoryCache instrumentedMemoryCache = producerFactory.f17902m;
        CacheKeyFactory cacheKeyFactory = producerFactory.n;
        BitmapMemoryCacheProducer bitmapMemoryCacheProducer = new BitmapMemoryCacheProducer(instrumentedMemoryCache, cacheKeyFactory, producer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheProducer, "newBitmapMemoryCacheProducer(...)");
        BitmapMemoryCacheKeyMultiplexProducer bitmapMemoryCacheKeyMultiplexProducer = new BitmapMemoryCacheKeyMultiplexProducer(cacheKeyFactory, bitmapMemoryCacheProducer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheKeyMultiplexProducer, "newBitmapMemoryCacheKeyMultiplexProducer(...)");
        ThreadHandoffProducer threadHandoffProducer = new ThreadHandoffProducer(bitmapMemoryCacheKeyMultiplexProducer, this.f17907e);
        Intrinsics.checkNotNullExpressionValue(threadHandoffProducer, "newBackgroundThreadHandoffProducer(...)");
        BitmapMemoryCacheGetProducer bitmapMemoryCacheGetProducer = new BitmapMemoryCacheGetProducer(producerFactory.f17902m, cacheKeyFactory, threadHandoffProducer);
        Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheGetProducer, "newBitmapMemoryCacheGetProducer(...)");
        return bitmapMemoryCacheGetProducer;
    }

    public final Producer h(Producer inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        FrescoSystrace.a();
        ProducerFactory producerFactory = this.f17904b;
        DecodeProducer decodeProducer = new DecodeProducer(producerFactory.f17893d, producerFactory.f17898i.c(), producerFactory.f17894e, producerFactory.f17895f, producerFactory.f17896g, producerFactory.f17897h, inputProducer, producerFactory.q, producerFactory.p);
        Intrinsics.checkNotNullExpressionValue(decodeProducer, "newDecodeProducer(...)");
        return g(decodeProducer);
    }

    public final Producer i(LocalFetchProducer localFetchProducer, ThumbnailProducer[] thumbnailProducerArr) {
        AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(j(localFetchProducer));
        Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
        ProducerFactory producerFactory = this.f17904b;
        MultiImageTranscoderFactory multiImageTranscoderFactory = this.f17910h;
        ThrottlingProducer throttlingProducer = new ThrottlingProducer(producerFactory.f17898i.a(), producerFactory.a(addImageTransformMetaDataProducer, true, multiImageTranscoderFactory));
        Intrinsics.checkNotNullExpressionValue(throttlingProducer, "newThrottlingProducer(...)");
        ThumbnailBranchProducer thumbnailBranchProducer = new ThumbnailBranchProducer(thumbnailProducerArr);
        Intrinsics.checkNotNullExpressionValue(thumbnailBranchProducer, "newThumbnailBranchProducer(...)");
        ResizeAndRotateProducer resizeAndRotateProducerA = producerFactory.a(thumbnailBranchProducer, true, multiImageTranscoderFactory);
        Intrinsics.checkNotNullExpressionValue(resizeAndRotateProducerA, "newResizeAndRotateProducer(...)");
        BranchOnSeparateImagesProducer branchOnSeparateImagesProducer = new BranchOnSeparateImagesProducer(resizeAndRotateProducerA, throttlingProducer);
        Intrinsics.checkNotNullExpressionValue(branchOnSeparateImagesProducer, "newBranchOnSeparateImagesProducer(...)");
        return h(branchOnSeparateImagesProducer);
    }

    public final EncodedCacheKeyMultiplexProducer j(Producer producer) {
        boolean z = this.f17909g;
        ProducerFactory producerFactory = this.f17904b;
        if (z) {
            FrescoSystrace.a();
            Supplier supplier = producerFactory.f17900k;
            CacheKeyFactory cacheKeyFactory = producerFactory.n;
            producer = new DiskCacheReadProducer(supplier, cacheKeyFactory, new DiskCacheWriteProducer(supplier, cacheKeyFactory, producer));
            Intrinsics.checkNotNullExpressionValue(producer, "newDiskCacheReadProducer(...)");
        }
        InstrumentedMemoryCache instrumentedMemoryCache = producerFactory.f17901l;
        CacheKeyFactory cacheKeyFactory2 = producerFactory.n;
        EncodedMemoryCacheProducer encodedMemoryCacheProducer = new EncodedMemoryCacheProducer(instrumentedMemoryCache, cacheKeyFactory2, producer);
        Intrinsics.checkNotNullExpressionValue(encodedMemoryCacheProducer, "newEncodedMemoryCacheProducer(...)");
        EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducer = new EncodedCacheKeyMultiplexProducer(cacheKeyFactory2, encodedMemoryCacheProducer);
        Intrinsics.checkNotNullExpressionValue(encodedCacheKeyMultiplexProducer, "newEncodedCacheKeyMultiplexProducer(...)");
        return encodedCacheKeyMultiplexProducer;
    }
}
