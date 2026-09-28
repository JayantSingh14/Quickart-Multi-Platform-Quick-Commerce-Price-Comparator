package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public interface GifDecoder {

    public interface BitmapProvider {
        void a(Bitmap bitmap);

        byte[] b(int i2);

        Bitmap c(int i2, int i3, Bitmap.Config config);

        int[] d(int i2);

        void e(byte[] bArr);

        void f(int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    Bitmap a();
}
