package com.facebook.imagepipeline.xml;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableXml;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class XmlDrawableFactory implements DrawableFactory {
    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public final boolean a(CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return image instanceof CloseableXml;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public final Drawable b(CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        CloseableXml closeableXml = image instanceof CloseableXml ? (CloseableXml) image : null;
        if (closeableXml != null) {
            return closeableXml.k1();
        }
        return null;
    }
}
