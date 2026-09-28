package com.rnmaps.maps;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class ImageReader {

    /* renamed from: a, reason: collision with root package name */
    public final MapOverlay f46475a;

    /* renamed from: b, reason: collision with root package name */
    public final ThemedReactContext f46476b;

    /* renamed from: c, reason: collision with root package name */
    public final Resources f46477c;

    /* renamed from: d, reason: collision with root package name */
    public final DraweeHolder f46478d;

    /* renamed from: e, reason: collision with root package name */
    public DataSource f46479e;

    /* renamed from: f, reason: collision with root package name */
    public final ControllerListener f46480f = new BaseControllerListener<ImageInfo>() { // from class: com.rnmaps.maps.ImageReader.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void l(String str, Object obj, Animatable animatable) throws Throwable {
            CloseableReference closeableReference;
            Throwable th;
            Bitmap bitmapV1;
            ImageReader imageReader = ImageReader.this;
            try {
                closeableReference = (CloseableReference) imageReader.f46479e.a();
                MapOverlay mapOverlay = imageReader.f46475a;
                if (closeableReference != null) {
                    try {
                        CloseableImage closeableImage = (CloseableImage) closeableReference.l();
                        if ((closeableImage instanceof CloseableStaticBitmap) && (bitmapV1 = ((CloseableStaticBitmap) closeableImage).v1()) != null) {
                            Bitmap bitmapCopy = bitmapV1.copy(Bitmap.Config.ARGB_8888, true);
                            mapOverlay.setIconBitmap(bitmapCopy);
                            mapOverlay.setIconBitmapDescriptor(BitmapDescriptorFactory.c(bitmapCopy));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        imageReader.f46479e.close();
                        if (closeableReference != null) {
                            closeableReference.close();
                        }
                        throw th;
                    }
                }
                imageReader.f46479e.close();
                if (closeableReference != null) {
                    closeableReference.close();
                }
                mapOverlay.k();
            } catch (Throwable th3) {
                closeableReference = null;
                th = th3;
            }
        }
    };

    public ImageReader(ThemedReactContext themedReactContext, Resources resources, MapOverlay mapOverlay) {
        this.f46476b = themedReactContext;
        this.f46477c = resources;
        this.f46475a = mapOverlay;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f17423l = (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17388e;
        genericDraweeHierarchyBuilder.f17413b = 0;
        DraweeHolder draweeHolder = new DraweeHolder(genericDraweeHierarchyBuilder.a());
        this.f46478d = draweeHolder;
        draweeHolder.h();
    }

    public final void a(String str) throws NumberFormatException {
        MapOverlay mapOverlay = this.f46475a;
        if (str == null) {
            mapOverlay.setIconBitmapDescriptor(null);
            mapOverlay.k();
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("asset://") && !str.startsWith("data:")) {
            ThemedReactContext themedReactContext = this.f46476b;
            String packageName = themedReactContext.getPackageName();
            Resources resources = this.f46477c;
            mapOverlay.setIconBitmapDescriptor(BitmapDescriptorFactory.d(resources.getIdentifier(str, "drawable", packageName)));
            mapOverlay.setIconBitmap(BitmapFactory.decodeResource(resources, resources.getIdentifier(str, "drawable", themedReactContext.getPackageName())));
            mapOverlay.k();
            return;
        }
        ImageRequest imageRequestA = ImageRequestBuilder.d(Uri.parse(str)).a();
        this.f46479e = Fresco.a().b(imageRequestA, this, null, null, null);
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = Fresco.f17198a.get();
        pipelineDraweeControllerBuilder.f17266b = imageRequestA;
        pipelineDraweeControllerBuilder.f17268d = this.f46480f;
        DraweeHolder draweeHolder = this.f46478d;
        pipelineDraweeControllerBuilder.f17270f = draweeHolder.f17451e;
        draweeHolder.m(pipelineDraweeControllerBuilder.a());
    }
}
