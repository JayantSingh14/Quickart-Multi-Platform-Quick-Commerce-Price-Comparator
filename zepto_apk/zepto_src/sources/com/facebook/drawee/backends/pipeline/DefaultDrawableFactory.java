package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.CloseableXml;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.xml.XmlDrawableFactory;
import com.facebook.infer.annotation.Nullsafe;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class DefaultDrawableFactory implements DrawableFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f17194a;

    /* renamed from: b, reason: collision with root package name */
    public final DrawableFactory f17195b;

    /* renamed from: c, reason: collision with root package name */
    public final XmlDrawableFactory f17196c;

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory, XmlDrawableFactory xmlDrawableFactory) {
        this.f17194a = resources;
        this.f17195b = drawableFactory;
        this.f17196c = xmlDrawableFactory;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public final boolean a(CloseableImage closeableImage) {
        return true;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public final Drawable b(CloseableImage image) {
        try {
            FrescoSystrace.a();
            if (image instanceof CloseableStaticBitmap) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) image;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f17194a, closeableStaticBitmap.v1());
                if ((closeableStaticBitmap.X0() == 0 || closeableStaticBitmap.X0() == -1) && (closeableStaticBitmap.H0() == 1 || closeableStaticBitmap.H0() == 0)) {
                    return bitmapDrawable;
                }
                return new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.X0(), closeableStaticBitmap.H0());
            }
            DrawableFactory drawableFactory = this.f17195b;
            if (drawableFactory != null && drawableFactory.a(image)) {
                return drawableFactory.b(image);
            }
            XmlDrawableFactory xmlDrawableFactory = this.f17196c;
            if (xmlDrawableFactory != null) {
                Intrinsics.checkNotNullParameter(image, "image");
                if (image instanceof CloseableXml) {
                    return xmlDrawableFactory.b(image);
                }
            }
            FrescoSystrace.a();
            return null;
        } finally {
            FrescoSystrace.a();
        }
    }
}
