package androidx.media3.common.text;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class TextEmphasisSpan implements LanguageFeatureSpan {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5652d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5653e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f5654f;

    /* renamed from: a, reason: collision with root package name */
    public final int f5655a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5656b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5657c;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkFill {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkShape {
    }

    static {
        int i2 = Util.f5744a;
        f5652d = Integer.toString(0, 36);
        f5653e = Integer.toString(1, 36);
        f5654f = Integer.toString(2, 36);
    }

    public TextEmphasisSpan(int i2, int i3, int i4) {
        this.f5655a = i2;
        this.f5656b = i3;
        this.f5657c = i4;
    }
}
