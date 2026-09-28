package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.ImageReader;

@RequiresApi
/* loaded from: classes3.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final Downsampler f16307a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f16307a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        this.f16307a.getClass();
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) {
        Downsampler downsampler = this.f16307a;
        return downsampler.a(new ImageReader.ParcelFileDescriptorImageReader((ParcelFileDescriptor) obj, downsampler.f16284d, downsampler.f16283c), i2, i3, options, Downsampler.f16279j);
    }
}
