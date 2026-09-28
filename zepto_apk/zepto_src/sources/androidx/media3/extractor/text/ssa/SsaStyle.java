package androidx.media3.extractor.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.support.v4.media.a;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class SsaStyle {

    /* renamed from: a, reason: collision with root package name */
    public final String f9332a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9333b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f9334c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f9335d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9336e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9337f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f9338g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9339h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9340i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9341j;

    public static final class Format {

        /* renamed from: a, reason: collision with root package name */
        public final int f9342a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9343b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9344c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9345d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9346e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9347f;

        /* renamed from: g, reason: collision with root package name */
        public final int f9348g;

        /* renamed from: h, reason: collision with root package name */
        public final int f9349h;

        /* renamed from: i, reason: collision with root package name */
        public final int f9350i;

        /* renamed from: j, reason: collision with root package name */
        public final int f9351j;

        /* renamed from: k, reason: collision with root package name */
        public final int f9352k;

        public Format(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f9342a = i2;
            this.f9343b = i3;
            this.f9344c = i4;
            this.f9345d = i5;
            this.f9346e = i6;
            this.f9347f = i7;
            this.f9348g = i8;
            this.f9349h = i9;
            this.f9350i = i10;
            this.f9351j = i11;
            this.f9352k = i12;
        }
    }

    public static final class Overrides {

        /* renamed from: a, reason: collision with root package name */
        public static final Pattern f9353a = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: b, reason: collision with root package name */
        public static final Pattern f9354b;

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f9355c;

        /* renamed from: d, reason: collision with root package name */
        public static final Pattern f9356d;

        static {
            int i2 = Util.f5744a;
            Locale locale = Locale.US;
            f9354b = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            f9355c = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            f9356d = Pattern.compile("\\\\an(\\d+)");
        }

        public static PointF a(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f9354b.matcher(str);
            Matcher matcher2 = f9355c.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    Log.g("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            strGroup.getClass();
            float f2 = Float.parseFloat(strGroup.trim());
            strGroup2.getClass();
            return new PointF(f2, Float.parseFloat(strGroup2.trim()));
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaBorderStyle {
    }

    public SsaStyle(String str, int i2, Integer num, Integer num2, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i3) {
        this.f9332a = str;
        this.f9333b = i2;
        this.f9334c = num;
        this.f9335d = num2;
        this.f9336e = f2;
        this.f9337f = z;
        this.f9338g = z2;
        this.f9339h = z3;
        this.f9340i = z4;
        this.f9341j = i3;
    }

    public static int a(String str) {
        boolean z;
        try {
            int i2 = Integer.parseInt(str.trim());
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return i2;
            }
        } catch (NumberFormatException unused) {
        }
        a.y("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean b(String str) throws NumberFormatException {
        try {
            int i2 = Integer.parseInt(str);
            return i2 == 1 || i2 == -1;
        } catch (NumberFormatException e2) {
            Log.i("SsaStyle", "Failed to parse boolean value: '" + str + "'", e2);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long j2 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            Assertions.a(j2 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.b(((j2 >> 24) & 255) ^ 255), Ints.b(j2 & 255), Ints.b((j2 >> 8) & 255), Ints.b((j2 >> 16) & 255)));
        } catch (IllegalArgumentException e2) {
            Log.i("SsaStyle", "Failed to parse color expression: '" + str + "'", e2);
            return null;
        }
    }
}
