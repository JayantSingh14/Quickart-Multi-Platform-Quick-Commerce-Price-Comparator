package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class TextLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f20135a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f20136b = new ConcurrentHashMap();

    /* renamed from: com.facebook.react.views.text.TextLayoutManager$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<TextPaint> {
        @Override // java.lang.ThreadLocal
        public final TextPaint initialValue() {
            return new TextPaint(1);
        }
    }

    public static void a(Spannable spannable, float f2, float f3, YogaMeasureMode yogaMeasureMode, double d2, int i2, boolean z, int i3, int i4, Layout.Alignment alignment, int i5, TextPaint textPaint) {
        Spannable spannable2 = spannable;
        TextPaint textPaint2 = textPaint;
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(spannable2, textPaint2);
        Layout layoutC = c(spannable2, metricsIsBoring, f2, z, i3, i4, alignment, i5, textPaint2);
        int iB = (int) (Double.isNaN(d2) ? PixelUtil.b(4.0f) : d2);
        int i6 = 0;
        int iMax = iB;
        for (ReactAbsoluteSizeSpan reactAbsoluteSizeSpan : (ReactAbsoluteSizeSpan[]) spannable2.getSpans(0, spannable2.length(), ReactAbsoluteSizeSpan.class)) {
            iMax = Math.max(iMax, reactAbsoluteSizeSpan.getSize());
        }
        int i7 = iMax;
        while (i7 > iB) {
            if ((i2 == -1 || i2 == 0 || layoutC.getLineCount() <= i2) && ((yogaMeasureMode == YogaMeasureMode.f20391a || layoutC.getHeight() <= f3) && (spannable2.length() != 1 || layoutC.getLineWidth(i6) <= f2))) {
                return;
            }
            int iMax2 = i7 - Math.max(1, (int) PixelUtil.b(1.0f));
            float f4 = iMax2 / iMax;
            float f5 = iB;
            textPaint2.setTextSize(Math.max(textPaint2.getTextSize() * f4, f5));
            ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable2.getSpans(i6, spannable2.length(), ReactAbsoluteSizeSpan.class);
            int length = reactAbsoluteSizeSpanArr.length;
            int i8 = i6;
            while (i8 < length) {
                ReactAbsoluteSizeSpan reactAbsoluteSizeSpan2 = reactAbsoluteSizeSpanArr[i8];
                spannable2.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(reactAbsoluteSizeSpan2.getSize() * f4, f5)), spannable2.getSpanStart(reactAbsoluteSizeSpan2), spannable2.getSpanEnd(reactAbsoluteSizeSpan2), spannable2.getSpanFlags(reactAbsoluteSizeSpan2));
                spannable2.removeSpan(reactAbsoluteSizeSpan2);
                i8++;
                metricsIsBoring = metricsIsBoring;
                f4 = f4;
                reactAbsoluteSizeSpanArr = reactAbsoluteSizeSpanArr;
            }
            BoringLayout.Metrics metrics = metricsIsBoring;
            metricsIsBoring = metrics != null ? BoringLayout.isBoring(spannable2, textPaint2) : metrics;
            Layout layoutC2 = c(spannable2, metricsIsBoring, f2, z, i3, i4, alignment, i5, textPaint2);
            spannable2 = spannable;
            textPaint2 = textPaint;
            i7 = iMax2;
            layoutC = layoutC2;
            i6 = 0;
        }
    }

    public static Layout b(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, float f2, float f3, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        TextPaint textPaintA;
        Spannable spannable;
        boolean z;
        int i2;
        int i3;
        Layout.Alignment alignment;
        int i4;
        TextPaint textPaint;
        BoringLayout.Metrics metrics;
        float f4;
        Spannable spannableD = d(context, mapBuffer, reactTextViewManagerCallback);
        if (mapBuffer.c1(3)) {
            textPaintA = ((ReactTextPaintHolderSpan[]) spannableD.getSpans(0, 0, ReactTextPaintHolderSpan.class))[0].a();
        } else {
            TextAttributeProps textAttributePropsA = TextAttributeProps.a(mapBuffer.j0(4));
            TextPaint textPaint2 = (TextPaint) f20135a.get();
            textPaint2.getClass();
            textPaint2.reset();
            textPaint2.setAntiAlias(true);
            if (textAttributePropsA.b() != -1) {
                textPaint2.setTextSize(textAttributePropsA.b());
            }
            if (textAttributePropsA.e() == -1 && textAttributePropsA.f() == -1 && textAttributePropsA.d() == null) {
                textPaint2.setTypeface(null);
            } else {
                Typeface typefaceA = ReactTypefaceUtils.a(null, textAttributePropsA.e(), textAttributePropsA.f(), textAttributePropsA.d(), context.getAssets());
                textPaint2.setTypeface(typefaceA);
                if (textAttributePropsA.e() != -1 && textAttributePropsA.e() != typefaceA.getStyle()) {
                    int iE = (~typefaceA.getStyle()) & textAttributePropsA.e();
                    textPaint2.setFakeBoldText((iE & 1) != 0);
                    textPaint2.setTextSkewX((iE & 2) != 0 ? -0.25f : 0.0f);
                }
            }
            textPaintA = textPaint2;
        }
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(spannableD, textPaintA);
        int iM = TextAttributeProps.m(mapBuffer2.getString(2));
        boolean z2 = mapBuffer2.c1(4) ? mapBuffer2.getBoolean(4) : true;
        int iG = TextAttributeProps.g(mapBuffer2.getString(5));
        boolean z3 = mapBuffer2.c1(3) ? mapBuffer2.getBoolean(3) : false;
        int i5 = mapBuffer2.c1(0) ? mapBuffer2.getInt(0) : -1;
        String strF = f(mapBuffer);
        Layout.Alignment alignmentE = e(mapBuffer, spannableD, strF);
        int i6 = Build.VERSION.SDK_INT < 26 ? -1 : (strF == null || !strF.equals("justified")) ? 0 : 1;
        if (z3) {
            spannable = spannableD;
            boolean z4 = z2;
            a(spannable, f2, f3, YogaMeasureMode.f20391a, mapBuffer2.c1(6) ? mapBuffer2.getDouble(6) : Double.NaN, i5, z4, iM, iG, alignmentE, i6, textPaintA);
            z = z4;
            i2 = iM;
            i3 = iG;
            f4 = f2;
            alignment = alignmentE;
            i4 = i6;
            textPaint = textPaintA;
            metrics = metricsIsBoring;
        } else {
            spannable = spannableD;
            z = z2;
            i2 = iM;
            i3 = iG;
            alignment = alignmentE;
            i4 = i6;
            textPaint = textPaintA;
            metrics = metricsIsBoring;
            f4 = f2;
        }
        return c(spannable, metrics, f4, z, i2, i3, alignment, i4, textPaint);
    }

    public static Layout c(Spannable spannable, BoringLayout.Metrics metrics, float f2, boolean z, int i2, int i3, Layout.Alignment alignment, int i4, TextPaint textPaint) {
        int i5;
        int length = spannable.length();
        boolean z2 = f2 < 0.0f;
        float desiredWidth = metrics == null ? Layout.getDesiredWidth(spannable, textPaint) : Float.NaN;
        boolean zIsRtl = TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, length);
        if (metrics == null && (z2 || (!YogaConstants.a(desiredWidth) && desiredWidth <= f2))) {
            StaticLayout.Builder textDirection = StaticLayout.Builder.obtain(spannable, 0, length, textPaint, (int) Math.ceil(f2)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(zIsRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            if (Build.VERSION.SDK_INT >= 28) {
                textDirection.setUseLineSpacingFromFallbacks(true);
            }
            return textDirection.build();
        }
        if (metrics == null || (!z2 && metrics.width > f2)) {
            StaticLayout.Builder textDirection2 = StaticLayout.Builder.obtain(spannable, 0, length, textPaint, (int) Math.ceil(f2)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(zIsRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 26) {
                textDirection2.setJustificationMode(i4);
            }
            if (i6 >= 28) {
                textDirection2.setUseLineSpacingFromFallbacks(true);
            }
            return textDirection2.build();
        }
        int iCeil = (int) Math.ceil(f2);
        if (metrics.width < 0) {
            ReactSoftExceptionLogger.logSoftException("TextLayoutManager", new ReactNoCrashSoftException("Text width is invalid: " + metrics.width));
            i5 = 0;
        } else {
            i5 = iCeil;
        }
        return BoringLayout.make(spannable, textPaint, i5, alignment, 1.0f, 0.0f, metrics, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
    
        r3.add(new com.facebook.react.views.text.internal.span.SetSpanOperation(r10, r12, new com.facebook.react.views.text.internal.span.ReactClickableSpan(r13)));
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.Spannable d(android.content.Context r20, com.facebook.react.common.mapbuffer.MapBuffer r21, com.facebook.react.views.text.ReactTextViewManagerCallback r22) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.d(android.content.Context, com.facebook.react.common.mapbuffer.MapBuffer, com.facebook.react.views.text.ReactTextViewManagerCallback):android.text.Spannable");
    }

    public static Layout.Alignment e(MapBuffer mapBuffer, Spannable spannable, String str) {
        boolean z = g(mapBuffer) != TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, spannable.length());
        Layout.Alignment alignment = z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        return str == null ? alignment : str.equals("center") ? Layout.Alignment.ALIGN_CENTER : str.equals("right") ? z ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : alignment;
    }

    public static String f(MapBuffer mapBuffer) {
        if (!mapBuffer.c1(2)) {
            return null;
        }
        MapBuffer mapBufferJ0 = mapBuffer.j0(2);
        if (mapBufferJ0.getCount() == 0) {
            return null;
        }
        MapBuffer mapBufferJ02 = mapBufferJ0.j0(0).j0(5);
        if (mapBufferJ02.c1(12)) {
            return mapBufferJ02.getString(12);
        }
        return null;
    }

    public static boolean g(MapBuffer mapBuffer) {
        if (mapBuffer.c1(2)) {
            MapBuffer mapBufferJ0 = mapBuffer.j0(2);
            if (mapBufferJ0.getCount() != 0) {
                MapBuffer mapBufferJ02 = mapBufferJ0.j0(0).j0(5);
                if (mapBufferJ02.c1(23) && TextAttributeProps.i(mapBufferJ02.getString(23)) == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
