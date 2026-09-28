package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f16326a;

        public NonOwnedBitmapResource(Bitmap bitmap) {
            this.f16326a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final Class a() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final Object get() {
            return this.f16326a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final int getSize() {
            return Util.c(this.f16326a);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final void recycle() {
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean a(Object obj, Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) {
        return new NonOwnedBitmapResource((Bitmap) obj);
    }
}
