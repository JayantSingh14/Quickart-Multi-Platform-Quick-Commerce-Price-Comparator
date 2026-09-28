package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.text.ReactFontManager;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class TSpanView extends TextView {
    public Path q;
    public String r;
    public TextPathView s;
    public final ArrayList t;
    public final ArrayList u;
    public final AssetManager v;

    /* renamed from: com.horcrux.svg.TSpanView$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45873a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f45874b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f45875c;

        static {
            int[] iArr = new int[TextProperties.AlignmentBaseline.values().length];
            f45875c = iArr;
            try {
                TextProperties.AlignmentBaseline alignmentBaseline = TextProperties.AlignmentBaseline.baseline;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline2 = TextProperties.AlignmentBaseline.baseline;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline3 = TextProperties.AlignmentBaseline.baseline;
                iArr3[14] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline4 = TextProperties.AlignmentBaseline.baseline;
                iArr4[12] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline5 = TextProperties.AlignmentBaseline.baseline;
                iArr5[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline6 = TextProperties.AlignmentBaseline.baseline;
                iArr6[3] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline7 = TextProperties.AlignmentBaseline.baseline;
                iArr7[4] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline8 = TextProperties.AlignmentBaseline.baseline;
                iArr8[5] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline9 = TextProperties.AlignmentBaseline.baseline;
                iArr9[6] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline10 = TextProperties.AlignmentBaseline.baseline;
                iArr10[15] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline11 = TextProperties.AlignmentBaseline.baseline;
                iArr11[7] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline12 = TextProperties.AlignmentBaseline.baseline;
                iArr12[13] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline13 = TextProperties.AlignmentBaseline.baseline;
                iArr13[11] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline14 = TextProperties.AlignmentBaseline.baseline;
                iArr14[8] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline15 = TextProperties.AlignmentBaseline.baseline;
                iArr15[9] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                int[] iArr16 = f45875c;
                TextProperties.AlignmentBaseline alignmentBaseline16 = TextProperties.AlignmentBaseline.baseline;
                iArr16[10] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr17 = new int[TextProperties.TextLengthAdjust.values().length];
            f45874b = iArr17;
            try {
                iArr17[0] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f45874b[1] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr18 = new int[TextProperties.TextAnchor.values().length];
            f45873a = iArr18;
            try {
                iArr18[0] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f45873a[1] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f45873a[2] = 3;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public TSpanView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = this.mContext.getResources().getAssets();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView
    public final void clearCache() {
        this.q = null;
        super.clearCache();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
        if (this.r == null) {
            clip(canvas, paint);
            j(canvas, paint, f2);
            return;
        }
        SVGLength sVGLength = this.f45915f;
        if (sVGLength != null && sVGLength.f45853a != 0.0d) {
            if (setupFillPaint(paint, this.fillOpacity * f2)) {
                v(canvas, paint);
            }
            if (setupStrokePaint(paint, f2 * this.strokeOpacity)) {
                v(canvas, paint);
                return;
            }
            return;
        }
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        if (size > 0) {
            u(paint, m().a());
            for (int i2 = 0; i2 < size; i2++) {
                String str = (String) arrayList.get(i2);
                Matrix matrix = (Matrix) this.u.get(i2);
                canvas.save();
                canvas.concat(matrix);
                canvas.drawText(str, 0.0f, 0.0f, paint);
                canvas.restore();
            }
        }
        k(canvas, paint, f2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:72:0x018f
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Path getPath(android.graphics.Canvas r72, android.graphics.Paint r73) {
        /*
            Method dump skipped, instructions count: 1696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.getPath(android.graphics.Canvas, android.graphics.Paint):android.graphics.Path");
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final int hitTest(float[] fArr) {
        Region region;
        if (this.r == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int iRound = Math.round(fArr2[0]);
            int iRound2 = Math.round(fArr2[1]);
            initBounds();
            Region region2 = this.mRegion;
            if ((region2 != null && region2.contains(iRound, iRound2)) || ((region = this.mStrokeRegion) != null && region.contains(iRound, iRound2))) {
                if (getClipPath() == null || this.mClipRegion.contains(iRound, iRound2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView, android.view.View
    public final void invalidate() {
        this.q = null;
        super.invalidate();
    }

    @Override // com.horcrux.svg.TextView
    public final double r(Paint paint) {
        if (!Double.isNaN(this.p)) {
            return this.p;
        }
        String str = this.r;
        double dR = 0.0d;
        if (str == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    dR += ((TextView) childAt).r(paint);
                }
            }
            this.p = dR;
            return dR;
        }
        if (str.length() == 0) {
            this.p = 0.0d;
            return 0.0d;
        }
        FontData fontDataA = m().a();
        u(paint, fontDataA);
        t(paint, fontDataA);
        double dMeasureText = paint.measureText(str);
        this.p = dMeasureText;
        return dMeasureText;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.graphics.Paint r6, com.horcrux.svg.FontData r7) {
        /*
            r5 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            float r1 = r5.mScale
            double r1 = (double) r1
            double r3 = r7.f45712a
            double r3 = r3 * r1
            double r1 = r7.n
            double r3 = r1 / r3
            float r3 = (float) r3
            r6.setLetterSpacing(r3)
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            java.lang.String r2 = r7.f45718g
            if (r1 != 0) goto L30
            com.horcrux.svg.TextProperties$FontVariantLigatures r1 = com.horcrux.svg.TextProperties.FontVariantLigatures.f45885a
            com.horcrux.svg.TextProperties$FontVariantLigatures r3 = r7.f45720i
            if (r3 != r1) goto L30
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.setFontFeatureSettings(r1)
            goto L41
        L30:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.setFontFeatureSettings(r1)
        L41:
            r1 = 26
            if (r0 < r1) goto L5d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "'wght' "
            r0.<init>(r1)
            int r1 = r7.f45717f
            r0.append(r1)
            java.lang.String r7 = r7.f45719h
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.google.android.material.appbar.a.v(r6, r7)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.t(android.graphics.Paint, com.horcrux.svg.FontData):void");
    }

    public final void u(Paint paint, FontData fontData) {
        int i2 = 0;
        boolean z = fontData.f45716e == TextProperties.FontWeight.Bold || fontData.f45717f >= 550;
        boolean z2 = fontData.f45714c == TextProperties.FontStyle.f45883b;
        if (z && z2) {
            i2 = 3;
        } else if (z) {
            i2 = 1;
        } else if (z2) {
            i2 = 2;
        }
        int i3 = fontData.f45717f;
        AssetManager assetManager = this.v;
        Typeface typefaceB = null;
        String str = fontData.f45713b;
        if (str != null && str.length() > 0) {
            String strD = android.support.v4.media.b.D("fonts/", str, ".otf");
            String strD2 = android.support.v4.media.b.D("fonts/", str, ".ttf");
            if (Build.VERSION.SDK_INT >= 26) {
                b.p();
                Typeface.Builder builderB = b.b(assetManager, strD);
                StringBuilder sb = new StringBuilder("'wght' ");
                sb.append(i3);
                String str2 = fontData.f45719h;
                sb.append(str2);
                builderB.setFontVariationSettings(sb.toString());
                builderB.setWeight(i3);
                builderB.setItalic(z2);
                typefaceB = builderB.build();
                if (typefaceB == null) {
                    b.p();
                    Typeface.Builder builderB2 = b.b(assetManager, strD2);
                    builderB2.setFontVariationSettings("'wght' " + i3 + str2);
                    builderB2.setWeight(i3);
                    builderB2.setItalic(z2);
                    typefaceB = builderB2.build();
                }
            } else {
                try {
                    try {
                        typefaceB = Typeface.create(Typeface.createFromAsset(assetManager, strD), i2);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    typefaceB = Typeface.create(Typeface.createFromAsset(assetManager, strD2), i2);
                }
            }
        }
        if (typefaceB == null) {
            try {
                typefaceB = ReactFontManager.a().b(str, i2, assetManager);
            } catch (Exception unused3) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            typefaceB = Typeface.create(typefaceB, i3, z2);
        }
        paint.setLinearText(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typefaceB);
        paint.setTextSize((float) (fontData.f45712a * this.mScale));
        paint.setLetterSpacing(0.0f);
    }

    public final void v(Canvas canvas, Paint paint) {
        GlyphContext glyphContextM = m();
        o();
        FontData fontDataA = glyphContextM.a();
        TextPaint textPaint = new TextPaint(paint);
        u(textPaint, fontDataA);
        t(textPaint, fontDataA);
        double dB = glyphContextM.b();
        int iOrdinal = fontDataA.f45721j.ordinal();
        Layout.Alignment alignment = iOrdinal != 1 ? iOrdinal != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        SpannableString spannableString = new SpannableString(this.r);
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, (int) PropHelper.b(this.f45915f, canvas.getWidth(), this.mScale, dB)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(true).setBreakStrategy(1).setHyphenationFrequency(1).build();
        int lineAscent = staticLayoutBuild.getLineAscent(0);
        float fJ = (float) glyphContextM.j(0.0d);
        float fK = (float) (glyphContextM.k() + lineAscent);
        n();
        canvas.save();
        canvas.translate(fJ, fK);
        staticLayoutBuild.draw(canvas);
        canvas.restore();
    }
}
