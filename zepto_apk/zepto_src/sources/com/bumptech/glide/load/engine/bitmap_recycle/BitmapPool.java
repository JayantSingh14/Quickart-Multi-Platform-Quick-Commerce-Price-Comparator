package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface BitmapPool {
    Bitmap a(int i2, int i3, Bitmap.Config config);

    void b(Bitmap bitmap);

    void c(int i2);

    void d();

    Bitmap e(int i2, int i3, Bitmap.Config config);
}
