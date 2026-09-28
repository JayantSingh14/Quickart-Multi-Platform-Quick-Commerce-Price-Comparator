package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.graphics.Shader;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public final class ComplexColorCompat {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f2747a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f2748b;

    /* renamed from: c, reason: collision with root package name */
    public int f2749c;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i2) {
        this.f2747a = shader;
        this.f2748b = colorStateList;
        this.f2749c = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f6, code lost:
    
        if (r3.size() <= 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f8, code lost:
    
        r0 = new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(r3, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01fe, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ff, code lost:
    
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0203, code lost:
    
        if (r19 == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0205, code lost:
    
        r0 = new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(r6, r7, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x020b, code lost:
    
        r0 = new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(r6, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0211, code lost:
    
        if (r8 == 1) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0214, code lost:
    
        if (r8 == 2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0218, code lost:
    
        if (r11 == 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x021a, code lost:
    
        if (r11 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x021c, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0221, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0224, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0227, code lost:
    
        r13 = new android.graphics.LinearGradient(r22, r25, r16, r17, r0.f2762a, r0.f2763b, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0237, code lost:
    
        r13 = new android.graphics.SweepGradient(r5, r10, r0.f2762a, r0.f2763b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0245, code lost:
    
        if (r24 <= 0.0f) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x024b, code lost:
    
        if (r11 == 1) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x024d, code lost:
    
        if (r11 == 2) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x024f, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0252, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0255, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0257, code lost:
    
        r13 = new android.graphics.RadialGradient(r5, r10, r24, r0.f2762a, r0.f2763b, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0273, code lost:
    
        return new androidx.core.content.res.ComplexColorCompat(r13, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027b, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.content.res.ComplexColorCompat a(android.content.res.Resources r26, int r27, android.content.res.Resources.Theme r28) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ComplexColorCompat.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.res.ComplexColorCompat");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.f2747a == null && (colorStateList = this.f2748b) != null && colorStateList.isStateful();
    }
}
