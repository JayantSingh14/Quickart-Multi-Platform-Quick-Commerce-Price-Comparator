package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import okio.Okio;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14394a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14395b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14396c;

    public /* synthetic */ b(String str, int i2, Object obj) {
        this.f14394a = i2;
        this.f14396c = obj;
        this.f14395b = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str = this.f14395b;
        Object obj = this.f14396c;
        switch (this.f14394a) {
            case 0:
                LottieAnimationView lottieAnimationView = (LottieAnimationView) obj;
                if (!lottieAnimationView.f14118m) {
                    return LottieCompositionFactory.d(lottieAnimationView.getContext(), str, null);
                }
                Context context = lottieAnimationView.getContext();
                HashMap map = LottieCompositionFactory.f14148a;
                return LottieCompositionFactory.d(context, str, "asset_" + str);
            case 1:
                return LottieCompositionFactory.f((InputStream) obj, str);
            case 2:
                HashMap map2 = LottieCompositionFactory.f14148a;
                return LottieCompositionFactory.g(JsonReader.l(Okio.d(Okio.m(new ByteArrayInputStream(str.getBytes())))), (String) obj, true);
            default:
                return LottieCompositionFactory.n(null, (ZipInputStream) obj, str);
        }
    }

    public /* synthetic */ b(String str, String str2) {
        this.f14394a = 2;
        this.f14395b = str;
        this.f14396c = str2;
    }
}
