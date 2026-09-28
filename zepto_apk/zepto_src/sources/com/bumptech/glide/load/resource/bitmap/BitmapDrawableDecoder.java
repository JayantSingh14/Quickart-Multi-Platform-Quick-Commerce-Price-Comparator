package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes3.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final ResourceDecoder f16247a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f16248b;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder resourceDecoder) {
        this.f16248b = resources;
        this.f16247a = resourceDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        return this.f16247a.a(obj, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) {
        Resource resourceB = this.f16247a.b(obj, i2, i3, options);
        if (resourceB == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(this.f16248b, resourceB);
    }
}
