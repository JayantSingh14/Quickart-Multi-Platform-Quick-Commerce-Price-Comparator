package com.bumptech.glide.load.resource.bitmap;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

/* loaded from: classes3.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final ResourceDrawableDecoder f16314a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapPool f16315b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f16314a = resourceDrawableDecoder;
        this.f16315b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        return "android.resource".equals(((Uri) obj).getScheme());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) throws PackageManager.NameNotFoundException, NumberFormatException {
        Resource resourceC = this.f16314a.c((Uri) obj);
        if (resourceC == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.f16315b, (Drawable) ((DrawableResource) resourceC).get(), i2, i3);
    }
}
