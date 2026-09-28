package androidx.media3.common.text;

import android.os.Bundle;
import android.text.Spanned;
import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
final class CustomSpanBundler {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5643a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f5644b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f5645c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5646d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5647e;

    static {
        int i2 = Util.f5744a;
        f5643a = Integer.toString(0, 36);
        f5644b = Integer.toString(1, 36);
        f5645c = Integer.toString(2, 36);
        f5646d = Integer.toString(3, 36);
        f5647e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, LanguageFeatureSpan languageFeatureSpan, int i2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f5643a, spanned.getSpanStart(languageFeatureSpan));
        bundle2.putInt(f5644b, spanned.getSpanEnd(languageFeatureSpan));
        bundle2.putInt(f5645c, spanned.getSpanFlags(languageFeatureSpan));
        bundle2.putInt(f5646d, i2);
        if (bundle != null) {
            bundle2.putBundle(f5647e, bundle);
        }
        return bundle2;
    }
}
