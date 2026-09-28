package androidx.media3.common.text;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class RubySpan implements LanguageFeatureSpan {

    /* renamed from: c, reason: collision with root package name */
    public static final String f5648c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5649d;

    /* renamed from: a, reason: collision with root package name */
    public final String f5650a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5651b;

    static {
        int i2 = Util.f5744a;
        f5648c = Integer.toString(0, 36);
        f5649d = Integer.toString(1, 36);
    }

    public RubySpan(String str, int i2) {
        this.f5650a = str;
        this.f5651b = i2;
    }
}
