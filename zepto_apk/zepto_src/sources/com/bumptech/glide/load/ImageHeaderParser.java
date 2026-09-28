package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f15802a;

        ImageType(boolean z) {
            this.f15802a = z;
        }

        public boolean hasAlpha() {
            return this.f15802a;
        }
    }

    int a(InputStream inputStream, LruArrayPool lruArrayPool);

    ImageType b(ByteBuffer byteBuffer);

    ImageType c(InputStream inputStream);
}
