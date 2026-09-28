package com.facebook.react.views.text;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    public static final TextPaint e0 = new TextPaint(1);
    public SpannableStringBuilder a0;
    public boolean b0;
    public final YogaMeasureFunction c0;
    public final YogaBaselineFunction d0;

    public ReactTextShadowNode() {
        this(null);
    }

    public static Layout p0(ReactTextShadowNode reactTextShadowNode, SpannableStringBuilder spannableStringBuilder, float f2, YogaMeasureMode yogaMeasureMode) {
        TextPaint textPaint = e0;
        textPaint.setTextSize(reactTextShadowNode.A.a());
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(spannableStringBuilder, textPaint);
        float desiredWidth = metricsIsBoring == null ? Layout.getDesiredWidth(spannableStringBuilder, textPaint) : Float.NaN;
        boolean z = yogaMeasureMode == YogaMeasureMode.f20391a || f2 < 0.0f;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int i2 = reactTextShadowNode.I;
        if (reactTextShadowNode.u.e() == YogaDirection.RTL) {
            if (i2 == 5) {
                i2 = 3;
            } else if (i2 == 3) {
                i2 = 5;
            }
        }
        if (i2 == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i2 != 3 && i2 == 5) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (metricsIsBoring == null && (z || (!YogaConstants.a(desiredWidth) && desiredWidth <= f2))) {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), textPaint, (int) Math.ceil(desiredWidth)).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(reactTextShadowNode.R).setBreakStrategy(reactTextShadowNode.J).setHyphenationFrequency(0);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                hyphenationFrequency.setJustificationMode(reactTextShadowNode.K);
            }
            if (i3 >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        }
        if (metricsIsBoring != null && (z || metricsIsBoring.width <= f2)) {
            return BoringLayout.make(spannableStringBuilder, textPaint, Math.max(metricsIsBoring.width, 0), alignment, 1.0f, 0.0f, metricsIsBoring, reactTextShadowNode.R);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 29) {
            f2 = (float) Math.ceil(f2);
        }
        StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), textPaint, (int) f2).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(reactTextShadowNode.R).setBreakStrategy(reactTextShadowNode.J).setHyphenationFrequency(0);
        if (i4 >= 26) {
            hyphenationFrequency2.setJustificationMode(reactTextShadowNode.K);
        }
        if (i4 >= 28) {
            hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
        }
        return hyphenationFrequency2.build();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final ArrayList F() {
        HashMap map = this.Z;
        if (map == null || map.isEmpty()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = this.a0;
        Assertions.d(spannableStringBuilder, "Spannable element has not been prepared in onBeforeLayout");
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = (ReactShadowNode) this.Z.get(Integer.valueOf(textInlineViewPlaceholderSpan.f20176a));
            reactShadowNode.I();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void S(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.a0 = o0(this, null, true, nativeViewHierarchyOptimizer);
        c0();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public final void c0() {
        super.c0();
        D();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(com.facebook.react.uimanager.UIViewOperationQueue r13) {
        /*
            r12 = this;
            android.text.SpannableStringBuilder r1 = r12.a0
            if (r1 == 0) goto L3e
            com.facebook.react.views.text.ReactTextUpdate r0 = new com.facebook.react.views.text.ReactTextUpdate
            boolean r3 = r12.Y
            r2 = 4
            float r4 = r12.Y(r2)
            r2 = 1
            float r5 = r12.Y(r2)
            r2 = 5
            float r6 = r12.Y(r2)
            r7 = 3
            r8 = r7
            float r7 = r12.Y(r8)
            int r9 = r12.I
            com.facebook.yoga.YogaNode r10 = r12.u
            com.facebook.yoga.YogaDirection r10 = r10.e()
            com.facebook.yoga.YogaDirection r11 = com.facebook.yoga.YogaDirection.RTL
            if (r10 != r11) goto L30
            if (r9 != r2) goto L2c
            goto L31
        L2c:
            if (r9 != r8) goto L30
            r8 = r2
            goto L31
        L30:
            r8 = r9
        L31:
            int r9 = r12.J
            int r10 = r12.K
            r2 = -1
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r12.f19456a
            r13.c(r1, r0)
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextShadowNode.d0(com.facebook.react.uimanager.UIViewOperationQueue):void");
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.b0 = z;
    }

    public ReactTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        YogaMeasureFunction yogaMeasureFunction = new YogaMeasureFunction() { // from class: com.facebook.react.views.text.ReactTextShadowNode.1
            /* JADX WARN: Removed duplicated region for block: B:56:0x0152  */
            @Override // com.facebook.yoga.YogaMeasureFunction
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final long h(com.facebook.yoga.YogaNodeJNIBase r18, float r19, com.facebook.yoga.YogaMeasureMode r20, float r21, com.facebook.yoga.YogaMeasureMode r22) {
                /*
                    Method dump skipped, instructions count: 345
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextShadowNode.AnonymousClass1.h(com.facebook.yoga.YogaNodeJNIBase, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode):long");
            }
        };
        this.c0 = yogaMeasureFunction;
        YogaBaselineFunction yogaBaselineFunction = new YogaBaselineFunction() { // from class: com.facebook.react.views.text.ReactTextShadowNode.2
            @Override // com.facebook.yoga.YogaBaselineFunction
            public final float a(float f2) {
                ReactTextShadowNode reactTextShadowNode = ReactTextShadowNode.this;
                SpannableStringBuilder spannableStringBuilder = reactTextShadowNode.a0;
                Assertions.d(spannableStringBuilder, "Spannable element has not been prepared in onBeforeLayout");
                Layout layoutP0 = ReactTextShadowNode.p0(reactTextShadowNode, spannableStringBuilder, f2, YogaMeasureMode.f20392b);
                return layoutP0.getLineBaseline(layoutP0.getLineCount() - 1);
            }
        };
        this.d0 = yogaBaselineFunction;
        this.u.X(yogaMeasureFunction);
        this.u.x(yogaBaselineFunction);
    }
}
