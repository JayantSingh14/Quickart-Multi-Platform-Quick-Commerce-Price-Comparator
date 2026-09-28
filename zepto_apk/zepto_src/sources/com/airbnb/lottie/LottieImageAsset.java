package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public class LottieImageAsset {

    /* renamed from: a, reason: collision with root package name */
    public final int f14172a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14173b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14174c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14175d;

    /* renamed from: e, reason: collision with root package name */
    public final String f14176e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f14177f;

    public LottieImageAsset(int i2, int i3, String str, String str2, String str3) {
        this.f14172a = i2;
        this.f14173b = i3;
        this.f14174c = str;
        this.f14175d = str2;
        this.f14176e = str3;
    }

    public final LottieImageAsset a(float f2) {
        int i2 = (int) (this.f14172a * f2);
        int i3 = (int) (this.f14173b * f2);
        LottieImageAsset lottieImageAsset = new LottieImageAsset(i2, i3, this.f14174c, this.f14175d, this.f14176e);
        Bitmap bitmap = this.f14177f;
        if (bitmap != null) {
            lottieImageAsset.f14177f = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        }
        return lottieImageAsset;
    }
}
