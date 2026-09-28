package com.zeptoconsumerapp.slotmachine;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.a;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.motion.b;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SlotMachineView extends View {
    public static final /* synthetic */ int x = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f47816a;

    /* renamed from: b, reason: collision with root package name */
    public int f47817b;

    /* renamed from: c, reason: collision with root package name */
    public TextPaint f47818c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f47819d;

    /* renamed from: e, reason: collision with root package name */
    public float f47820e;

    /* renamed from: f, reason: collision with root package name */
    public int f47821f;

    /* renamed from: g, reason: collision with root package name */
    public ValueAnimator f47822g;

    /* renamed from: h, reason: collision with root package name */
    public final int f47823h;

    /* renamed from: i, reason: collision with root package name */
    public float f47824i;

    /* renamed from: j, reason: collision with root package name */
    public DecimalFormat f47825j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f47826k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f47827l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f47828m;
    public final Object n;
    public boolean o;
    public boolean p;
    public boolean q;
    public float r;
    public boolean s;
    public float t;
    public int u;
    public final char v;
    public boolean w;

    public SlotMachineView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f47816a = true;
        this.f47819d = new Paint();
        this.f47823h = (int) (8 * getResources().getDisplayMetrics().density);
        Float fValueOf = Float.valueOf(0.0f);
        this.f47826k = CollectionsKt.k(fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf);
        this.f47827l = CollectionsKt.k(' ', (char) 8377, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',');
        this.f47828m = new ArrayList();
        this.n = MapsKt.h(new Pair(' ', 0), new Pair((char) 8377, 1), new Pair('0', 2), new Pair('1', 3), new Pair('2', 4), new Pair('3', 5), new Pair('4', 6), new Pair('5', 7), new Pair('6', 8), new Pair('7', 9), new Pair('8', 10), new Pair('9', 11), new Pair(',', 12));
        this.r = -1.0f;
        this.s = true;
        this.v = (char) 8377;
        g();
        c();
        a();
    }

    public final void a() {
        TextPaint textPaint = this.f47818c;
        if (textPaint == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        float f2 = textPaint.getFontMetrics().descent;
        TextPaint textPaint2 = this.f47818c;
        if (textPaint2 != null) {
            this.f47821f = (int) (f2 - textPaint2.getFontMetrics().ascent);
        } else {
            Intrinsics.h("textPaint");
            throw null;
        }
    }

    public final String b(int i2) {
        if (!this.q) {
            return String.valueOf(i2);
        }
        DecimalFormat decimalFormat = this.f47825j;
        if (decimalFormat == null) {
            Intrinsics.h("formatter");
            throw null;
        }
        String str = decimalFormat.format(Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = this.v + str;
        return this.r > 0.0f ? StringsKt.K(str2, ",", "") : str2;
    }

    public final void c() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setGroupingSeparator(',');
        this.f47825j = new DecimalFormat("##,##,###", decimalFormatSymbols);
    }

    public final void d() {
        Context context = getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null) {
            return;
        }
        reactContext.runOnNativeModulesQueueThread(new a(29, reactContext, this));
    }

    public final void e() {
        String strB = b(this.f47817b);
        Intrinsics.checkNotNullParameter(strB, "<this>");
        char[] charArray = new StringBuilder((CharSequence) strB).reverse().toString().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        int length = charArray.length;
        float fFloatValue = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = charArray[i2];
            float f2 = this.r;
            ArrayList arrayList = this.f47826k;
            if (f2 > 0.0f) {
                arrayList.set(i2, Float.valueOf(f2));
            } else {
                TextPaint textPaint = this.f47818c;
                if (textPaint == null) {
                    Intrinsics.h("textPaint");
                    throw null;
                }
                arrayList.set(i2, Float.valueOf(textPaint.measureText(String.valueOf(c2))));
            }
            Object obj = arrayList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            fFloatValue += ((Number) obj).floatValue();
        }
        this.f47824i = ((r0.length() - 1) * this.t) + fFloatValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = r6.f47828m
            r0.clear()
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            java.lang.StringBuilder r7 = r2.reverse()
            java.lang.String r7 = r7.toString()
            char[] r7 = r7.toCharArray()
            java.lang.String r2 = "toCharArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.StringBuilder r8 = r1.reverse()
            java.lang.String r8 = r8.toString()
            char[] r8 = r8.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            int r1 = r7.length
            int r2 = r8.length
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
        L3e:
            if (r2 >= r1) goto L9c
            int r3 = r7.length
            r4 = 32
            if (r3 > r2) goto L7f
            float r3 = r6.r
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L74
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L74
            java.lang.Object r3 = kotlin.collections.CollectionsKt.F(r0)
            com.zeptoconsumerapp.slotmachine.Datum r3 = (com.zeptoconsumerapp.slotmachine.Datum) r3
            char r3 = r3.b()
            char r5 = r6.v
            if (r3 != r5) goto L74
            java.lang.Object r3 = kotlin.collections.CollectionsKt.F(r0)
            com.zeptoconsumerapp.slotmachine.Datum r3 = (com.zeptoconsumerapp.slotmachine.Datum) r3
            r3.c()
            com.zeptoconsumerapp.slotmachine.Datum r3 = new com.zeptoconsumerapp.slotmachine.Datum
            char r4 = r8[r2]
            r3.<init>(r5, r4)
            r0.add(r3)
            goto L99
        L74:
            com.zeptoconsumerapp.slotmachine.Datum r3 = new com.zeptoconsumerapp.slotmachine.Datum
            char r5 = r8[r2]
            r3.<init>(r4, r5)
            r0.add(r3)
            goto L99
        L7f:
            int r3 = r8.length
            if (r3 > r2) goto L8d
            com.zeptoconsumerapp.slotmachine.Datum r3 = new com.zeptoconsumerapp.slotmachine.Datum
            char r5 = r7[r2]
            r3.<init>(r5, r4)
            r0.add(r3)
            goto L99
        L8d:
            com.zeptoconsumerapp.slotmachine.Datum r3 = new com.zeptoconsumerapp.slotmachine.Datum
            char r4 = r7[r2]
            char r5 = r8[r2]
            r3.<init>(r4, r5)
            r0.add(r3)
        L99:
            int r2 = r2 + 1
            goto L3e
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.slotmachine.SlotMachineView.f(java.lang.String, java.lang.String):void");
    }

    public final void g() {
        TextPaint textPaint = new TextPaint();
        this.f47818c = textPaint;
        textPaint.setColor(-16777216);
        TextPaint textPaint2 = this.f47818c;
        if (textPaint2 == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint2.setTextSize(60.0f);
        TextPaint textPaint3 = this.f47818c;
        if (textPaint3 == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint3.setAntiAlias(true);
        TextPaint textPaint4 = this.f47818c;
        if (textPaint4 != null) {
            textPaint4.setTextAlign(Paint.Align.LEFT);
        } else {
            Intrinsics.h("textPaint");
            throw null;
        }
    }

    public final void h() {
        if (!this.o) {
            this.p = true;
            return;
        }
        if (this.s && !this.q && !this.w) {
            this.s = false;
            this.f47820e = 1.0f;
            return;
        }
        this.p = false;
        ValueAnimator valueAnimator = this.f47822g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.q ? 800L : 300L);
        valueAnimatorOfFloat.addUpdateListener(new b(this, 4));
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.zeptoconsumerapp.slotmachine.SlotMachineView$startAnimation$lambda$4$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                this.f47829a.f47822g = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        });
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.start();
        this.f47822g = valueAnimatorOfFloat;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.Map] */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f2;
        float fAbs;
        float fAbs2;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int iSave = canvas.save();
        Object parent = getParent();
        View view = parent instanceof View ? (View) parent : null;
        int height = view != null ? view.getHeight() : getHeight();
        int height2 = (getHeight() - height) / 2;
        canvas.clipRect(0, height2, getWidth() + 12, height + height2);
        super.onDraw(canvas);
        float f3 = this.f47824i;
        ArrayList arrayList = this.f47828m;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            ?? r3 = this.n;
            Object obj = r3.get(Character.valueOf(((Datum) arrayList.get(i3)).a()));
            Intrinsics.c(obj);
            int iIntValue = ((Number) obj).intValue();
            Object obj2 = r3.get(Character.valueOf(((Datum) arrayList.get(i3)).b()));
            Intrinsics.c(obj2);
            float fIntValue = (this.f47820e * (iIntValue - r3)) + ((Number) obj2).intValue();
            ArrayList arrayList2 = this.f47827l;
            double d2 = fIntValue;
            int i4 = height;
            Object obj3 = arrayList2.get((int) Math.floor(d2));
            Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
            char cCharValue = ((Character) obj3).charValue();
            Object obj4 = arrayList2.get((int) Math.ceil(d2));
            Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
            char cCharValue2 = ((Character) obj4).charValue();
            float height3 = getHeight();
            TextPaint textPaint = this.f47818c;
            if (textPaint == null) {
                Intrinsics.h("textPaint");
                throw null;
            }
            float f4 = height3 - textPaint.getFontMetrics().descent;
            float f5 = this.f47823h + f4;
            float f6 = f3;
            float fFloor = f4 - ((fIntValue - ((float) Math.floor(d2))) * f5);
            float fA = android.support.v4.media.a.a((float) Math.ceil(d2), fIntValue, f5, f4);
            float f7 = this.r;
            ArrayList arrayList3 = this.f47826k;
            if (f7 > 0.0f) {
                float fFloatValue = ((Number) arrayList3.get(i3)).floatValue();
                TextPaint textPaint2 = this.f47818c;
                if (textPaint2 == null) {
                    Intrinsics.h("textPaint");
                    throw null;
                }
                f2 = 0.0f;
                fAbs = Math.abs((fFloatValue - textPaint2.measureText(String.valueOf(cCharValue))) / 2.0f);
                float fFloatValue2 = ((Number) arrayList3.get(i3)).floatValue();
                TextPaint textPaint3 = this.f47818c;
                if (textPaint3 == null) {
                    Intrinsics.h("textPaint");
                    throw null;
                }
                fAbs2 = Math.abs((fFloatValue2 - textPaint3.measureText(String.valueOf(cCharValue2))) / 2.0f);
            } else {
                f2 = 0.0f;
                float fFloatValue3 = ((Number) arrayList3.get(i3)).floatValue();
                TextPaint textPaint4 = this.f47818c;
                if (textPaint4 == null) {
                    Intrinsics.h("textPaint");
                    throw null;
                }
                fAbs = Math.abs((fFloatValue3 - textPaint4.measureText(String.valueOf(((Datum) arrayList.get(i3)).a()))) / 2.0f);
                fAbs2 = fAbs;
            }
            String strValueOf = String.valueOf(cCharValue);
            float fFloatValue4 = f6 - (((Number) arrayList3.get(i3)).floatValue() - fAbs);
            TextPaint textPaint5 = this.f47818c;
            if (textPaint5 == null) {
                Intrinsics.h("textPaint");
                throw null;
            }
            canvas.drawText(strValueOf, fFloatValue4, fFloor, textPaint5);
            String strValueOf2 = String.valueOf(cCharValue2);
            float fFloatValue5 = f6 - (((Number) arrayList3.get(i3)).floatValue() - fAbs2);
            TextPaint textPaint6 = this.f47818c;
            if (textPaint6 == null) {
                Intrinsics.h("textPaint");
                throw null;
            }
            canvas.drawText(strValueOf2, fFloatValue5, fA, textPaint6);
            Object obj5 = arrayList3.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
            float fFloatValue6 = f6 - ((Number) obj5).floatValue();
            if (this.t <= f2 || i3 == arrayList.size() - 1) {
                i2 = i4;
            } else {
                i2 = i4;
                canvas.drawRect(fFloatValue6 - this.t, height2, fFloatValue6, i2, this.f47819d);
            }
            f3 = fFloatValue6 - this.t;
            i3++;
            height = i2;
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d();
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.resolveSize((int) Math.ceil(this.f47824i), 0), View.resolveSize(this.f47821f, 0));
    }

    public final void setAnimateFromStart(boolean z) {
        this.w = z;
    }

    public final void setColor(@NotNull String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        TextPaint textPaint = this.f47818c;
        if (textPaint == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint.setColor(Color.parseColor(hex));
        invalidate();
    }

    public final void setCurrentValue(int i2) {
        int i3 = this.f47817b;
        if (i3 == i2) {
            return;
        }
        String strB = b(i3);
        if (this.f47816a) {
            strB = b(this.u);
            this.f47816a = false;
        }
        f(strB, b(i2));
        this.f47817b = i2;
        e();
        requestLayout();
        d();
        h();
    }

    public final void setFixedCharWidth(float f2) {
        this.r = TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        e();
        requestLayout();
        d();
    }

    public final void setFontFamily(@NotNull String value) {
        Typeface typefaceCreateFromAsset;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            typefaceCreateFromAsset = Typeface.createFromAsset(getResources().getAssets(), "fonts/" + value + ".ttf");
        } catch (Exception unused) {
            typefaceCreateFromAsset = Typeface.DEFAULT;
        }
        TextPaint textPaint = this.f47818c;
        if (textPaint == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint.setTypeface(typefaceCreateFromAsset);
        a();
        requestLayout();
        invalidate();
    }

    public final void setFontSize(float f2) {
        float fApplyDimension = TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
        TextPaint textPaint = this.f47818c;
        if (textPaint == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint.setTextSize(fApplyDimension);
        a();
        e();
        requestLayout();
        invalidate();
    }

    public final void setInitialValue(int i2) {
        this.u = i2;
    }

    public final void setLetterSpacing(float f2) {
        TextPaint textPaint = this.f47818c;
        if (textPaint == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        float textSize = f2 / textPaint.getTextSize();
        TextPaint textPaint2 = this.f47818c;
        if (textPaint2 == null) {
            Intrinsics.h("textPaint");
            throw null;
        }
        textPaint2.setLetterSpacing(textSize);
        a();
        e();
        requestLayout();
        invalidate();
    }

    public final void setSeparatorColor(@NotNull String separatorColor) {
        Intrinsics.checkNotNullParameter(separatorColor, "separatorColor");
        this.f47819d.setColor(Color.parseColor(separatorColor));
        invalidate();
    }

    public final void setSeparatorWidth(float f2) {
        this.t = TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        e();
        requestLayout();
        d();
    }

    public SlotMachineView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47816a = true;
        this.f47819d = new Paint();
        this.f47823h = (int) (8 * getResources().getDisplayMetrics().density);
        Float fValueOf = Float.valueOf(0.0f);
        this.f47826k = CollectionsKt.k(fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf);
        this.f47827l = CollectionsKt.k(' ', (char) 8377, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',');
        this.f47828m = new ArrayList();
        this.n = MapsKt.h(new Pair(' ', 0), new Pair((char) 8377, 1), new Pair('0', 2), new Pair('1', 3), new Pair('2', 4), new Pair('3', 5), new Pair('4', 6), new Pair('5', 7), new Pair('6', 8), new Pair('7', 9), new Pair('8', 10), new Pair('9', 11), new Pair(',', 12));
        this.r = -1.0f;
        this.s = true;
        this.v = (char) 8377;
        g();
        c();
        a();
    }

    public SlotMachineView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f47816a = true;
        this.f47819d = new Paint();
        this.f47823h = (int) (8 * getResources().getDisplayMetrics().density);
        Float fValueOf = Float.valueOf(0.0f);
        this.f47826k = CollectionsKt.k(fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf);
        this.f47827l = CollectionsKt.k(' ', (char) 8377, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',');
        this.f47828m = new ArrayList();
        this.n = MapsKt.h(new Pair(' ', 0), new Pair((char) 8377, 1), new Pair('0', 2), new Pair('1', 3), new Pair('2', 4), new Pair('3', 5), new Pair('4', 6), new Pair('5', 7), new Pair('6', 8), new Pair('7', 9), new Pair('8', 10), new Pair('9', 11), new Pair(',', 12));
        this.r = -1.0f;
        this.s = true;
        this.v = (char) 8377;
        g();
        c();
        a();
    }
}
