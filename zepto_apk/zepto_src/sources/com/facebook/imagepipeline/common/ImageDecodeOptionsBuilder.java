package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap.Config f17779a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f17780b;

    public ImageDecodeOptionsBuilder() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.f17779a = config;
        this.f17780b = config;
    }
}
