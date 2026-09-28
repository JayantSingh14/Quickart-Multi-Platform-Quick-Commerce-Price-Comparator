package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
final class TtmlStyle {

    /* renamed from: a, reason: collision with root package name */
    public String f9407a;

    /* renamed from: b, reason: collision with root package name */
    public int f9408b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9409c;

    /* renamed from: d, reason: collision with root package name */
    public int f9410d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9411e;

    /* renamed from: k, reason: collision with root package name */
    public float f9417k;

    /* renamed from: l, reason: collision with root package name */
    public String f9418l;
    public Layout.Alignment o;
    public Layout.Alignment p;
    public TextEmphasis r;

    /* renamed from: f, reason: collision with root package name */
    public int f9412f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f9413g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f9414h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9415i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f9416j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f9419m = -1;
    public int n = -1;
    public int q = -1;
    public float s = Float.MAX_VALUE;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public final void a(TtmlStyle ttmlStyle) {
        int i2;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f9409c && ttmlStyle.f9409c) {
                this.f9408b = ttmlStyle.f9408b;
                this.f9409c = true;
            }
            if (this.f9414h == -1) {
                this.f9414h = ttmlStyle.f9414h;
            }
            if (this.f9415i == -1) {
                this.f9415i = ttmlStyle.f9415i;
            }
            if (this.f9407a == null && (str = ttmlStyle.f9407a) != null) {
                this.f9407a = str;
            }
            if (this.f9412f == -1) {
                this.f9412f = ttmlStyle.f9412f;
            }
            if (this.f9413g == -1) {
                this.f9413g = ttmlStyle.f9413g;
            }
            if (this.n == -1) {
                this.n = ttmlStyle.n;
            }
            if (this.o == null && (alignment2 = ttmlStyle.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = ttmlStyle.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = ttmlStyle.q;
            }
            if (this.f9416j == -1) {
                this.f9416j = ttmlStyle.f9416j;
                this.f9417k = ttmlStyle.f9417k;
            }
            if (this.r == null) {
                this.r = ttmlStyle.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = ttmlStyle.s;
            }
            if (!this.f9411e && ttmlStyle.f9411e) {
                this.f9410d = ttmlStyle.f9410d;
                this.f9411e = true;
            }
            if (this.f9419m != -1 || (i2 = ttmlStyle.f9419m) == -1) {
                return;
            }
            this.f9419m = i2;
        }
    }
}
