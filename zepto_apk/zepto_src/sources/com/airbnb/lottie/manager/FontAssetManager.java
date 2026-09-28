package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class FontAssetManager {

    /* renamed from: d, reason: collision with root package name */
    public final AssetManager f14431d;

    /* renamed from: e, reason: collision with root package name */
    public FontAssetDelegate f14432e;

    /* renamed from: a, reason: collision with root package name */
    public final MutablePair f14428a = new MutablePair();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f14429b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f14430c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public String f14433f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.f14432e = fontAssetDelegate;
        if (callback instanceof View) {
            this.f14431d = ((View) callback).getContext().getAssets();
        } else {
            Logger.b("LottieDrawable must be inside of a view for images to work.");
            this.f14431d = null;
        }
    }
}
