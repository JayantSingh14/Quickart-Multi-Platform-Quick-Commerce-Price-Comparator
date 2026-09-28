package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16384a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteBufferGifDecoder f16385b;

    /* renamed from: c, reason: collision with root package name */
    public final LruArrayPool f16386c;

    public StreamGifDecoder(ArrayList arrayList, ByteBufferGifDecoder byteBufferGifDecoder, LruArrayPool lruArrayPool) {
        this.f16384a = arrayList;
        this.f16385b = byteBufferGifDecoder;
        this.f16386c = lruArrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        InputStream inputStream = (InputStream) obj;
        if (((Boolean) options.c(GifOptions.f16383b)).booleanValue()) {
            return false;
        }
        return ImageHeaderParserUtils.c(this.f16386c, inputStream, this.f16384a) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) throws IOException {
        byte[] byteArray;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i4 = inputStream.read(bArr);
                if (i4 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i4);
            }
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            }
            byteArray = null;
        }
        if (byteArray == null) {
            return null;
        }
        return this.f16385b.b(ByteBuffer.wrap(byteArray), i2, i3, options);
    }
}
