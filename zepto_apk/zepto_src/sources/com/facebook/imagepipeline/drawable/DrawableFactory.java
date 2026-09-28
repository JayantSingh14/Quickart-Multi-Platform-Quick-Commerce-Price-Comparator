package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface DrawableFactory {
    boolean a(CloseableImage closeableImage);

    Drawable b(CloseableImage closeableImage);
}
