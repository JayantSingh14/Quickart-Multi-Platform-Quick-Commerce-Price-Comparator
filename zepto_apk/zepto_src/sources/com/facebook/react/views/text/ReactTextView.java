package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.internal.SystraceSection;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.facebook.yoga.YogaMeasureMode;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.common.api.Api;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    public static final ViewGroup.LayoutParams u = new ViewGroup.LayoutParams(0, 0);

    /* renamed from: h, reason: collision with root package name */
    public boolean f20109h;

    /* renamed from: i, reason: collision with root package name */
    public int f20110i;

    /* renamed from: j, reason: collision with root package name */
    public TextUtils.TruncateAt f20111j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20112k;

    /* renamed from: l, reason: collision with root package name */
    public float f20113l;

    /* renamed from: m, reason: collision with root package name */
    public float f20114m;
    public float n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public Overflow s;
    public Spannable t;

    private ReactContext getReactContext() {
        Context context = getContext();
        return context instanceof TintContextWrapper ? (ReactContext) ((TintContextWrapper) context).getBaseContext() : (ReactContext) context;
    }

    public static WritableMap t(int i2, int i3, int i4, int i5, int i6, int i7) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i2 == 8) {
            writableMapCreateMap.putString("visibility", "gone");
            writableMapCreateMap.putInt("index", i3);
            return writableMapCreateMap;
        }
        if (i2 != 0) {
            writableMapCreateMap.putString("visibility", zzck.UNKNOWN_CONTENT_TYPE);
            writableMapCreateMap.putInt("index", i3);
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("visibility", "visible");
        writableMapCreateMap.putInt("index", i3);
        writableMapCreateMap.putDouble("left", PixelUtil.a(i4));
        writableMapCreateMap.putDouble("top", PixelUtil.a(i5));
        writableMapCreateMap.putDouble("right", PixelUtil.a(i6));
        writableMapCreateMap.putDouble("bottom", PixelUtil.a(i7));
        return writableMapCreateMap;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.e(this) != null) {
            AccessibilityDelegateCompat accessibilityDelegateCompatD = ViewCompat.d(this);
            if (accessibilityDelegateCompatD instanceof ExploreByTouchHelper) {
                return ((ExploreByTouchHelper) accessibilityDelegateCompatD).d(motionEvent) || super.dispatchHoverEvent(motionEvent);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getGravityHorizontal() {
        return getGravity() & 8388615;
    }

    public Spannable getSpanned() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTextIsSelectable(this.q);
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.c();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.d();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        new SystraceSection("ReactTextView.onDraw");
        try {
            if (this.f20112k && getSpanned() != null && this.r) {
                this.r = false;
                TextLayoutManager.a(getSpanned(), getWidth(), getHeight(), YogaMeasureMode.f20392b, this.f20114m, this.f20110i, getIncludeFontPadding(), getBreakStrategy(), getHyphenationFrequency(), Layout.Alignment.ALIGN_NORMAL, Build.VERSION.SDK_INT < 26 ? -1 : getJustificationMode(), getPaint());
                setText(getSpanned());
            }
            if (this.s != Overflow.f19918b) {
                BackgroundStyleApplicator.a(this, canvas);
            }
            super.onDraw(canvas);
            Trace.endSection();
        } finally {
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.e();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0153 A[SYNTHETIC] */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        new SystraceSection("ReactTextView.onMeasure");
        try {
            super.onMeasure(i2, i3);
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.f();
            }
        }
    }

    public final void r() {
        if (!Float.isNaN(this.f20113l)) {
            setTextSize(0, this.f20113l);
        }
        if (Float.isNaN(this.n)) {
            return;
        }
        super.setLetterSpacing(this.n);
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public final int reactTagForTouch(float f2, float f3) {
        int i2;
        CharSequence text = getText();
        int id = getId();
        int i3 = (int) f2;
        int i4 = (int) f3;
        Layout layout = getLayout();
        if (layout != null) {
            int lineForVertical = layout.getLineForVertical(i4);
            int lineLeft = (int) layout.getLineLeft(lineForVertical);
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if ((text instanceof Spanned) && i3 >= lineLeft && i3 <= lineRight) {
                Spanned spanned = (Spanned) text;
                try {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i3);
                    ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                    if (reactTagSpanArr != null) {
                        int length = text.length();
                        for (int i5 = 0; i5 < reactTagSpanArr.length; i5++) {
                            int spanStart = spanned.getSpanStart(reactTagSpanArr[i5]);
                            int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i5]);
                            if (spanEnd >= offsetForHorizontal && (i2 = spanEnd - spanStart) <= length) {
                                id = reactTagSpanArr[i5].f20166a;
                                length = i2;
                            }
                        }
                        return id;
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    FLog.g("ReactNative", "Crash in HorizontalMeasurementProvider: " + e2.getMessage());
                }
            }
        }
        return id;
    }

    public final void s() {
        this.f20110i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f20112k = false;
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = false;
        this.f20111j = TextUtils.TruncateAt.END;
        this.f20113l = Float.NaN;
        this.f20114m = Float.NaN;
        this.n = 0.0f;
        this.s = Overflow.f19918b;
        this.t = null;
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.f20112k = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        BackgroundStyleApplicator.i(this, Integer.valueOf(i2));
    }

    public void setBorderRadius(float f2) {
        BorderRadiusProp borderRadiusProp = BorderRadiusProp.f19836a;
        BackgroundStyleApplicator.l(this, BorderRadiusProp.values()[0], Float.isNaN(f2) ? null : new LengthPercentage(PixelUtil.a(f2), LengthPercentageType.f19394a));
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.m(this, str == null ? null : BorderStyle.a(str));
    }

    @Override // android.widget.TextView
    public void setBreakStrategy(int i2) {
        super.setBreakStrategy(i2);
        this.r = true;
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.f20111j = truncateAt;
    }

    public void setFontSize(float f2) {
        this.f20113l = (float) (this.f20112k ? Math.ceil(PixelUtil.c(f2, Float.NaN)) : Math.ceil(PixelUtil.b(f2)));
        r();
    }

    public void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = 8388611;
        }
        setGravity(i2 | (getGravity() & (-8388616)));
    }

    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = 48;
        }
        setGravity(i2 | (getGravity() & (-113)));
    }

    @Override // android.widget.TextView
    public void setHyphenationFrequency(int i2) {
        super.setHyphenationFrequency(i2);
        this.r = true;
    }

    @Override // android.widget.TextView
    public void setIncludeFontPadding(boolean z) {
        super.setIncludeFontPadding(z);
        this.r = true;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f2) {
        if (Float.isNaN(f2)) {
            return;
        }
        this.n = PixelUtil.b(f2) / this.f20113l;
        r();
    }

    public void setLinkifyMask(int i2) {
        this.o = i2;
    }

    public void setMinimumFontSize(float f2) {
        this.f20114m = f2;
        this.r = true;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.p = z;
    }

    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        this.f20110i = i2;
        setMaxLines(i2);
        this.r = true;
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.s = Overflow.f19918b;
        } else {
            Overflow overflowA = Overflow.a(str);
            if (overflowA == null) {
                overflowA = Overflow.f19918b;
            }
            this.s = overflowA;
        }
        invalidate();
    }

    public void setSpanned(Spannable spannable) {
        this.t = spannable;
        this.r = true;
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        new SystraceSection("ReactTextView.setText(ReactTextUpdate)");
        try {
            this.f20109h = reactTextUpdate.f20101c;
            if (getLayoutParams() == null) {
                setLayoutParams(u);
            }
            Spannable spannable = reactTextUpdate.f20099a;
            int i2 = this.o;
            if (i2 > 0) {
                Linkify.addLinks(spannable, i2);
                setMovementMethod(LinkMovementMethod.getInstance());
            }
            setText(spannable);
            float f2 = reactTextUpdate.f20102d;
            float f3 = reactTextUpdate.f20103e;
            float f4 = reactTextUpdate.f20104f;
            float f5 = reactTextUpdate.f20105g;
            if (f2 != -1.0f && f3 != -1.0f && f4 != -1.0f && f5 != -1.0f) {
                setPadding((int) Math.floor(f2), (int) Math.floor(f3), (int) Math.floor(f4), (int) Math.floor(f5));
            }
            int i3 = reactTextUpdate.f20106h;
            if (i3 != getGravityHorizontal()) {
                setGravityHorizontal(i3);
            }
            int breakStrategy = getBreakStrategy();
            int i4 = reactTextUpdate.f20107i;
            if (breakStrategy != i4) {
                setBreakStrategy(i4);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                int justificationMode = getJustificationMode();
                int i5 = reactTextUpdate.f20108j;
                if (justificationMode != i5) {
                    setJustificationMode(i5);
                }
            }
            requestLayout();
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // android.widget.TextView
    public void setTextIsSelectable(boolean z) {
        this.q = z;
        super.setTextIsSelectable(z);
    }

    public final void u() {
        s();
        Intrinsics.checkNotNullParameter(this, "view");
        if (getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = getBackground();
            Intrinsics.d(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            setBackground(((CompositeBackgroundDrawable) background).f19668b);
        }
        setBreakStrategy(0);
        setMovementMethod(getDefaultMovementMethod());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            setJustificationMode(0);
        }
        setLayoutParams(u);
        TextUtils.TruncateAt truncateAt = null;
        super.setText((CharSequence) null);
        r();
        setGravity(8388659);
        setNumberOfLines(this.f20110i);
        setAdjustFontSizeToFit(this.f20112k);
        setLinkifyMask(this.o);
        setTextIsSelectable(this.q);
        setIncludeFontPadding(true);
        setEnabled(true);
        setLinkifyMask(0);
        setEllipsizeLocation(this.f20111j);
        setEnabled(true);
        if (i2 >= 26) {
            setFocusable(16);
        }
        setHyphenationFrequency(0);
        if (this.f20110i != Integer.MAX_VALUE && !this.f20112k) {
            truncateAt = this.f20111j;
        }
        setEllipsize(truncateAt);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (this.f20109h && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
