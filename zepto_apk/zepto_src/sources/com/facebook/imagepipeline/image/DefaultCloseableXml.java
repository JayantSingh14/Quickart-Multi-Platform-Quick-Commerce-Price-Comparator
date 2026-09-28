package com.facebook.imagepipeline.image;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DefaultCloseableXml extends DefaultCloseableImage implements CloseableXml {

    /* renamed from: d, reason: collision with root package name */
    public Drawable f17954d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17955e;

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final int B0() {
        return getHeight() * getWidth() * 4;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f17954d = null;
        this.f17955e = true;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public final int getHeight() {
        Drawable drawable = this.f17954d;
        if (drawable == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(drawable.getIntrinsicHeight());
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public final int getWidth() {
        Drawable drawable = this.f17954d;
        if (drawable == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final boolean isClosed() {
        return this.f17955e;
    }

    @Override // com.facebook.imagepipeline.image.CloseableXml
    public final Drawable k1() {
        Drawable.ConstantState constantState;
        Drawable drawable = this.f17954d;
        if (drawable == null || (constantState = drawable.getConstantState()) == null) {
            return null;
        }
        return constantState.newDrawable();
    }
}
