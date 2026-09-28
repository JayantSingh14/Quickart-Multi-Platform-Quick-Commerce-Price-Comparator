package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

@UnstableApi
/* loaded from: classes3.dex */
public final class WebvttCssStyle {

    /* renamed from: f, reason: collision with root package name */
    public int f9442f;

    /* renamed from: h, reason: collision with root package name */
    public int f9444h;
    public float o;

    /* renamed from: a, reason: collision with root package name */
    public String f9437a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f9438b = "";

    /* renamed from: c, reason: collision with root package name */
    public Set f9439c = Collections.EMPTY_SET;

    /* renamed from: d, reason: collision with root package name */
    public String f9440d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9441e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9443g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9445i = false;

    /* renamed from: j, reason: collision with root package name */
    public final int f9446j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f9447k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f9448l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f9449m = -1;
    public int n = -1;
    public int p = -1;
    public boolean q = false;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public static int a(int i2, int i3, String str, String str2) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }
}
