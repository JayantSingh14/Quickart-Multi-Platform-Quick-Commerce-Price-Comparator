package io.sentry.android.replay.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StabilityInferred(parameters = 0)
@Metadata
/* loaded from: classes3.dex */
public final class AndroidTextLayout implements TextLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Layout f52626a;

    public AndroidTextLayout(Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.f52626a = layout;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int a(int i2) {
        return this.f52626a.getLineTop(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final float b(int i2, int i3) {
        return this.f52626a.getPrimaryHorizontal(i3);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int c(int i2) {
        return this.f52626a.getLineStart(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int d() {
        return this.f52626a.getLineCount();
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final Integer e() {
        int i2;
        Layout layout = this.f52626a;
        if (!(layout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = layout.getText();
        Intrinsics.d(text, "null cannot be cast to non-null type android.text.Spanned");
        ForegroundColorSpan[] spans = (ForegroundColorSpan[]) ((Spanned) text).getSpans(0, layout.getText().length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        int i3 = Integer.MIN_VALUE;
        Integer numValueOf = null;
        for (ForegroundColorSpan foregroundColorSpan : spans) {
            CharSequence text2 = layout.getText();
            Intrinsics.d(text2, "null cannot be cast to non-null type android.text.Spanned");
            int spanStart = ((Spanned) text2).getSpanStart(foregroundColorSpan);
            CharSequence text3 = layout.getText();
            Intrinsics.d(text3, "null cannot be cast to non-null type android.text.Spanned");
            int spanEnd = ((Spanned) text3).getSpanEnd(foregroundColorSpan);
            if (spanStart != -1 && spanEnd != -1 && (i2 = spanEnd - spanStart) > i3) {
                numValueOf = Integer.valueOf(foregroundColorSpan.getForegroundColor());
                i3 = i2;
            }
        }
        if (numValueOf != null) {
            return Integer.valueOf(numValueOf.intValue() | (-16777216));
        }
        return null;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int f(int i2) {
        return this.f52626a.getLineVisibleEnd(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int g(int i2) {
        return this.f52626a.getEllipsisCount(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int h(int i2) {
        return this.f52626a.getLineBottom(i2);
    }
}
