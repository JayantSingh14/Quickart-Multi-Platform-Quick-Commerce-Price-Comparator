package com.bumptech.glide.load.resource.transcode;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes3.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f16390a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapBytesTranscoder f16391b;

    /* renamed from: c, reason: collision with root package name */
    public final GifDrawableBytesTranscoder f16392c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, BitmapBytesTranscoder bitmapBytesTranscoder, GifDrawableBytesTranscoder gifDrawableBytesTranscoder) {
        this.f16390a = bitmapPool;
        this.f16391b = bitmapBytesTranscoder;
        this.f16392c = gifDrawableBytesTranscoder;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource a(Resource resource, Options options) {
        Drawable drawable = (Drawable) resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f16391b.a(BitmapResource.b(((BitmapDrawable) drawable).getBitmap(), this.f16390a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f16392c.a(resource, options);
        }
        return null;
    }
}
