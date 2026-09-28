package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class ColorInfo {

    /* renamed from: h, reason: collision with root package name */
    public static final ColorInfo f5169h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f5170i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f5171j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f5172k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f5173l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f5174m;
    public static final String n;

    /* renamed from: a, reason: collision with root package name */
    public final int f5175a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5176b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5177c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f5178d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5179e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5180f;

    /* renamed from: g, reason: collision with root package name */
    public int f5181g;

    public static final class Builder {

        /* renamed from: d, reason: collision with root package name */
        public byte[] f5185d;

        /* renamed from: a, reason: collision with root package name */
        public int f5182a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f5183b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f5184c = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f5186e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f5187f = -1;

        public final ColorInfo a() {
            return new ColorInfo(this.f5182a, this.f5183b, this.f5184c, this.f5186e, this.f5187f, this.f5185d);
        }
    }

    static {
        Builder builder = new Builder();
        builder.f5182a = 1;
        builder.f5183b = 2;
        builder.f5184c = 3;
        f5169h = builder.a();
        Builder builder2 = new Builder();
        builder2.f5182a = 1;
        builder2.f5183b = 1;
        builder2.f5184c = 2;
        builder2.a();
        int i2 = Util.f5744a;
        f5170i = Integer.toString(0, 36);
        f5171j = Integer.toString(1, 36);
        f5172k = Integer.toString(2, 36);
        f5173l = Integer.toString(3, 36);
        f5174m = Integer.toString(4, 36);
        n = Integer.toString(5, 36);
    }

    public ColorInfo(int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f5175a = i2;
        this.f5176b = i3;
        this.f5177c = i4;
        this.f5178d = bArr;
        this.f5179e = i5;
        this.f5180f = i6;
    }

    public static String a(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? android.support.v4.media.b.f(i2, "Undefined color range ") : "Limited range" : "Full range" : "Unset color range";
    }

    public static String b(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? android.support.v4.media.b.f(i2, "Undefined color space ") : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String c(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? android.support.v4.media.b.f(i2, "Undefined color transfer ") : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean e(ColorInfo colorInfo) {
        if (colorInfo == null) {
            return true;
        }
        int i2 = colorInfo.f5175a;
        if (i2 != -1 && i2 != 1 && i2 != 2) {
            return false;
        }
        int i3 = colorInfo.f5176b;
        if (i3 != -1 && i3 != 2) {
            return false;
        }
        int i4 = colorInfo.f5177c;
        if ((i4 != -1 && i4 != 3) || colorInfo.f5178d != null) {
            return false;
        }
        int i5 = colorInfo.f5180f;
        if (i5 != -1 && i5 != 8) {
            return false;
        }
        int i6 = colorInfo.f5179e;
        return i6 == -1 || i6 == 8;
    }

    public static int f(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int g(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean d() {
        return (this.f5175a == -1 || this.f5176b == -1 || this.f5177c == -1) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ColorInfo.class == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.f5175a == colorInfo.f5175a && this.f5176b == colorInfo.f5176b && this.f5177c == colorInfo.f5177c && Arrays.equals(this.f5178d, colorInfo.f5178d) && this.f5179e == colorInfo.f5179e && this.f5180f == colorInfo.f5180f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f5181g == 0) {
            this.f5181g = ((((Arrays.hashCode(this.f5178d) + ((((((527 + this.f5175a) * 31) + this.f5176b) * 31) + this.f5177c) * 31)) * 31) + this.f5179e) * 31) + this.f5180f;
        }
        return this.f5181g;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(b(this.f5175a));
        sb.append(", ");
        sb.append(a(this.f5176b));
        sb.append(", ");
        sb.append(c(this.f5177c));
        sb.append(", ");
        sb.append(this.f5178d != null);
        sb.append(", ");
        String str2 = RegionUtil.REGION_STRING_NA;
        int i2 = this.f5179e;
        if (i2 != -1) {
            str = i2 + "bit Luma";
        } else {
            str = RegionUtil.REGION_STRING_NA;
        }
        sb.append(str);
        sb.append(", ");
        int i3 = this.f5180f;
        if (i3 != -1) {
            str2 = i3 + "bit Chroma";
        }
        return android.support.v4.media.b.r(sb, str2, ")");
    }
}
