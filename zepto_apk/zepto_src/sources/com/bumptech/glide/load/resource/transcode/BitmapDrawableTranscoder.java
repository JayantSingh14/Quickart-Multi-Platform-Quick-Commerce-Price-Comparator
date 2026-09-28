package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;

/* loaded from: classes3.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f16389a;

    public BitmapDrawableTranscoder(Resources resources) {
        this.f16389a = resources;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource a(Resource resource, Options options) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(this.f16389a, resource);
    }
}
