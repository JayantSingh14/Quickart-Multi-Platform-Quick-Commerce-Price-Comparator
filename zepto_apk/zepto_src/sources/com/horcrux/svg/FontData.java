package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.horcrux.svg.TextProperties;

/* loaded from: classes4.dex */
class FontData {
    public static final FontData p = new FontData();

    /* renamed from: a, reason: collision with root package name */
    public final double f45712a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45713b;

    /* renamed from: c, reason: collision with root package name */
    public final TextProperties.FontStyle f45714c;

    /* renamed from: d, reason: collision with root package name */
    public final ReadableMap f45715d;

    /* renamed from: e, reason: collision with root package name */
    public TextProperties.FontWeight f45716e;

    /* renamed from: f, reason: collision with root package name */
    public int f45717f;

    /* renamed from: g, reason: collision with root package name */
    public final String f45718g;

    /* renamed from: h, reason: collision with root package name */
    public final String f45719h;

    /* renamed from: i, reason: collision with root package name */
    public final TextProperties.FontVariantLigatures f45720i;

    /* renamed from: j, reason: collision with root package name */
    public final TextProperties.TextAnchor f45721j;

    /* renamed from: k, reason: collision with root package name */
    public final TextProperties.TextDecoration f45722k;

    /* renamed from: l, reason: collision with root package name */
    public final double f45723l;

    /* renamed from: m, reason: collision with root package name */
    public final double f45724m;
    public final double n;
    public final boolean o;

    public static class AbsoluteFontWeight {

        /* renamed from: a, reason: collision with root package name */
        public static final TextProperties.FontWeight[] f45725a;

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f45726b;

        static {
            TextProperties.FontWeight fontWeight = TextProperties.FontWeight.w100;
            TextProperties.FontWeight fontWeight2 = TextProperties.FontWeight.w200;
            TextProperties.FontWeight fontWeight3 = TextProperties.FontWeight.w300;
            TextProperties.FontWeight fontWeight4 = TextProperties.FontWeight.Normal;
            TextProperties.FontWeight fontWeight5 = TextProperties.FontWeight.w500;
            TextProperties.FontWeight fontWeight6 = TextProperties.FontWeight.w600;
            TextProperties.FontWeight fontWeight7 = TextProperties.FontWeight.Bold;
            TextProperties.FontWeight fontWeight8 = TextProperties.FontWeight.w800;
            TextProperties.FontWeight fontWeight9 = TextProperties.FontWeight.w900;
            f45725a = new TextProperties.FontWeight[]{fontWeight, fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9, fontWeight9};
            f45726b = new int[]{400, 700, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        }
    }

    public FontData() {
        this.f45715d = null;
        this.f45713b = "";
        this.f45714c = TextProperties.FontStyle.f45882a;
        this.f45716e = TextProperties.FontWeight.Normal;
        this.f45717f = 400;
        this.f45718g = "";
        this.f45719h = "";
        this.f45720i = TextProperties.FontVariantLigatures.f45885a;
        this.f45721j = TextProperties.TextAnchor.f45900a;
        this.f45722k = TextProperties.TextDecoration.None;
        this.o = false;
        this.f45723l = 0.0d;
        this.f45712a = 12.0d;
        this.f45724m = 0.0d;
        this.n = 0.0d;
    }

    public static double b(ReadableMap readableMap, String str, double d2, double d3, double d4) {
        return readableMap.getType(str) == ReadableType.Number ? readableMap.getDouble(str) : PropHelper.a(d4, d2, d3, readableMap.getString(str));
    }

    public final void a(FontData fontData, double d2) {
        long jRound = Math.round(d2);
        if (jRound < 1 || jRound > 1000) {
            this.f45717f = fontData.f45717f;
            this.f45716e = fontData.f45716e;
            return;
        }
        int i2 = (int) jRound;
        this.f45717f = i2;
        TextProperties.FontWeight[] fontWeightArr = AbsoluteFontWeight.f45725a;
        this.f45716e = AbsoluteFontWeight.f45725a[Math.round(i2 / 100.0f)];
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[PHI: r12
      0x0065: PHI (r12v58 int) = (r12v57 int), (r12v63 int) binds: [B:27:0x006f, B:21:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FontData(com.facebook.react.bridge.ReadableMap r12, com.horcrux.svg.FontData r13, double r14) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.FontData.<init>(com.facebook.react.bridge.ReadableMap, com.horcrux.svg.FontData, double):void");
    }
}
