package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import java.util.Map;

/* loaded from: classes3.dex */
public class ImageAssetManager {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f14434e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f14435a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14436b;

    /* renamed from: c, reason: collision with root package name */
    public ImageAssetDelegate f14437c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f14438d;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f14436b = str;
        } else {
            this.f14436b = str.concat("/");
        }
        this.f14438d = map;
        this.f14437c = imageAssetDelegate;
        if (callback instanceof View) {
            this.f14435a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f14435a = null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        synchronized (f14434e) {
            ((LottieImageAsset) this.f14438d.get(str)).f14177f = bitmap;
        }
    }
}
