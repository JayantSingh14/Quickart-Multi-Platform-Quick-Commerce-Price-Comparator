package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final Downsampler f16257a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f16257a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        this.f16257a.getClass();
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) {
        InputStream inputStreamD = ByteBufferUtil.d((ByteBuffer) obj);
        Downsampler.DecodeCallbacks decodeCallbacks = Downsampler.f16279j;
        Downsampler downsampler = this.f16257a;
        return downsampler.a(new ImageReader.InputStreamImageReader(downsampler.f16283c, inputStreamD, downsampler.f16284d), i2, i3, options, decodeCallbacks);
    }
}
