package com.facebook.react.views.text;

import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;

/* loaded from: classes3.dex */
public class TextAttributeProps {

    /* renamed from: a, reason: collision with root package name */
    public float f20115a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f20116b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20117c;

    /* renamed from: d, reason: collision with root package name */
    public float f20118d;

    /* renamed from: e, reason: collision with root package name */
    public int f20119e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20120f;

    /* renamed from: g, reason: collision with root package name */
    public int f20121g;

    /* renamed from: h, reason: collision with root package name */
    public float f20122h;

    /* renamed from: i, reason: collision with root package name */
    public int f20123i;

    /* renamed from: j, reason: collision with root package name */
    public float f20124j;

    /* renamed from: k, reason: collision with root package name */
    public float f20125k;

    /* renamed from: l, reason: collision with root package name */
    public float f20126l;

    /* renamed from: m, reason: collision with root package name */
    public TextTransform f20127m;
    public float n;
    public float o;
    public float p;
    public int q;
    public boolean r;
    public boolean s;
    public ReactAccessibilityDelegate.AccessibilityRole t;
    public ReactAccessibilityDelegate.Role u;
    public int v;
    public int w;
    public String x;
    public String y;
    public float z;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.react.views.text.TextAttributeProps a(com.facebook.react.common.mapbuffer.MapBuffer r10) {
        /*
            Method dump skipped, instructions count: 1230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextAttributeProps.a(com.facebook.react.common.mapbuffer.MapBuffer):com.facebook.react.views.text.TextAttributeProps");
    }

    public static int g(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals("normal")) {
            return 1;
        }
        return !str.equals("none") ? 2 : 0;
    }

    public static int h(int i2, ReactStylesDiffMap reactStylesDiffMap) {
        return !reactStylesDiffMap.f19469a.hasKey("textAlign") ? i2 : (!"justify".equals(reactStylesDiffMap.f19469a.getString("textAlign")) || Build.VERSION.SDK_INT < 26) ? 0 : 1;
    }

    public static int i(String str) {
        if (str != null && !"undefined".equals(str)) {
            if ("rtl".equals(str)) {
                return 1;
            }
            if ("ltr".equals(str)) {
                return 0;
            }
            FLog.q("ReactNative", "Invalid layoutDirection: ".concat(str));
        }
        return -1;
    }

    public static int l(ReactStylesDiffMap reactStylesDiffMap, boolean z, int i2) {
        if (!reactStylesDiffMap.f19469a.hasKey("textAlign")) {
            return i2;
        }
        String string = reactStylesDiffMap.f19469a.getString("textAlign");
        if ("justify".equals(string)) {
            return 3;
        }
        if (string != null && !"auto".equals(string)) {
            if ("left".equals(string)) {
                return z ? 5 : 3;
            }
            if ("right".equals(string)) {
                return z ? 3 : 5;
            }
            if ("center".equals(string)) {
                return 1;
            }
            FLog.q("ReactNative", "Invalid textAlign: ".concat(string));
        }
        return 0;
    }

    public static int m(String str) {
        if (str == null) {
            return 1;
        }
        if (str.equals("balanced")) {
            return 2;
        }
        return !str.equals("simple") ? 1 : 0;
    }

    public final int b() {
        return this.f20123i;
    }

    public final float c() {
        if (!Float.isNaN(this.f20115a)) {
            float f2 = this.z;
            if (!Float.isNaN(f2) && f2 > this.f20115a) {
                return f2;
            }
        }
        return this.f20115a;
    }

    public final String d() {
        return this.x;
    }

    public final int e() {
        return this.v;
    }

    public final int f() {
        return this.w;
    }

    public final float j() {
        float fC = this.f20117c ? PixelUtil.c(this.f20126l, Float.NaN) : PixelUtil.b(this.f20126l);
        int i2 = this.f20123i;
        if (i2 > 0) {
            return fC / i2;
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.f20123i);
    }

    public final float k() {
        return this.f20122h;
    }

    public final void n(float f2) {
        this.f20124j = f2;
        if (f2 != -1.0f) {
            f2 = (float) (this.f20117c ? Math.ceil(PixelUtil.c(f2, this.f20118d)) : Math.ceil(PixelUtil.b(f2)));
        }
        this.f20123i = (int) f2;
    }

    public final void o(float f2) {
        this.f20125k = f2;
        if (f2 == -1.0f) {
            this.f20115a = Float.NaN;
        } else {
            this.f20115a = this.f20117c ? PixelUtil.c(f2, Float.NaN) : PixelUtil.b(f2);
        }
    }
}
