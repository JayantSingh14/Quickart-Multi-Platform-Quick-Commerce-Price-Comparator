package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.HashSet;

@Nullsafe
/* loaded from: classes3.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {

    /* renamed from: j, reason: collision with root package name */
    public final ImagePipeline f17200j;

    /* renamed from: k, reason: collision with root package name */
    public final PipelineDraweeControllerFactory f17201k;

    /* renamed from: com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17202a;

        static {
            int[] iArr = new int[AbstractDraweeControllerBuilder.CacheLevel.values().length];
            f17202a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17202a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17202a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline imagePipeline) {
        d();
        this.f17200j = imagePipeline;
        this.f17201k = pipelineDraweeControllerFactory;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public final AbstractDataSource b(PipelineDraweeController pipelineDraweeController, String str, Object obj, Object obj2, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        ImageRequest.RequestLevel requestLevel;
        ImageRequest imageRequest = (ImageRequest) obj;
        ImagePipeline imagePipeline = this.f17200j;
        int iOrdinal = cacheLevel.ordinal();
        if (iOrdinal == 0) {
            requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
        } else if (iOrdinal == 1) {
            requestLevel = ImageRequest.RequestLevel.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
            }
            requestLevel = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        }
        ImageRequest.RequestLevel requestLevel2 = requestLevel;
        ForwardingRequestListener forwardingRequestListener = null;
        if (pipelineDraweeController != null) {
            synchronized (pipelineDraweeController) {
                HashSet hashSet = pipelineDraweeController.y;
                if (hashSet != null) {
                    forwardingRequestListener = new ForwardingRequestListener(hashSet);
                }
            }
        }
        return imagePipeline.b(imageRequest, obj2, requestLevel2, forwardingRequestListener, str);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public final PipelineDraweeController e() {
        PipelineDraweeController pipelineDraweeController;
        FrescoSystrace.a();
        try {
            DraweeController draweeController = this.f17270f;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.f17264i.getAndIncrement());
            if (draweeController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) draweeController;
            } else {
                PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.f17201k;
                pipelineDraweeController = new PipelineDraweeController(pipelineDraweeControllerFactory.f17206a, pipelineDraweeControllerFactory.f17207b, pipelineDraweeControllerFactory.f17208c, pipelineDraweeControllerFactory.f17209d, pipelineDraweeControllerFactory.f17210e, pipelineDraweeControllerFactory.f17211f);
                Supplier supplier = pipelineDraweeControllerFactory.f17212g;
                if (supplier != null) {
                    pipelineDraweeController.x = ((Boolean) supplier.get()).booleanValue();
                }
            }
            ImageRequest imageRequest = this.f17266b;
            AbstractDraweeControllerBuilder.CacheLevel cacheLevel = AbstractDraweeControllerBuilder.CacheLevel.f17277a;
            Supplier supplierC = imageRequest != null ? c(pipelineDraweeController, strValueOf, imageRequest, cacheLevel) : null;
            if (supplierC != null && this.f17267c != null) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(supplierC);
                arrayList.add(c(pipelineDraweeController, strValueOf, this.f17267c, cacheLevel));
                supplierC = new IncreasingQualityDataSourceSupplier(arrayList);
            }
            if (supplierC == null) {
                supplierC = DataSources.a(AbstractDraweeControllerBuilder.f17263h);
            }
            ImageRequest imageRequest2 = this.f17266b;
            CacheKeyFactory cacheKeyFactory = this.f17200j.f17828h;
            BitmapMemoryCacheKey bitmapMemoryCacheKeyB = (cacheKeyFactory == null || imageRequest2 == null) ? null : imageRequest2.p != null ? cacheKeyFactory.b(imageRequest2, this.f17265a) : cacheKeyFactory.a(imageRequest2, this.f17265a);
            Object obj = this.f17265a;
            pipelineDraweeController.getClass();
            FrescoSystrace.a();
            pipelineDraweeController.p(obj, strValueOf);
            pipelineDraweeController.o = false;
            pipelineDraweeController.w = supplierC;
            pipelineDraweeController.D(null);
            pipelineDraweeController.v = bitmapMemoryCacheKeyB;
            pipelineDraweeController.D(null);
            FrescoSystrace.a();
            synchronized (pipelineDraweeController) {
                pipelineDraweeController.z = this.f17266b;
                pipelineDraweeController.A = this.f17267c;
            }
            FrescoSystrace.a();
            return pipelineDraweeController;
        } catch (Throwable th) {
            FrescoSystrace.a();
            throw th;
        }
    }

    public final PipelineDraweeControllerBuilder f(Uri uri) {
        if (uri == null) {
            this.f17266b = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderD = ImageRequestBuilder.d(uri);
        imageRequestBuilderD.f18374e = RotationOptions.f17790d;
        this.f17266b = imageRequestBuilderD.a();
        return this;
    }
}
