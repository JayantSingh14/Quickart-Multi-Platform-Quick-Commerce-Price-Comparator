package io.sentry.android.replay.util;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata
/* loaded from: classes3.dex */
public final class ComposeTextLayout implements TextLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextLayoutResult f52627a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f52628b;

    public ComposeTextLayout(TextLayoutResult layout, boolean z) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.f52627a = layout;
        this.f52628b = z;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int a(int i2) {
        return MathKt.b(this.f52627a.getLineTop(i2));
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final float b(int i2, int i3) {
        float horizontalPosition = this.f52627a.getHorizontalPosition(i3, true);
        return (this.f52628b || d() != 1) ? horizontalPosition : horizontalPosition - this.f52627a.getLineLeft(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int c(int i2) {
        return this.f52627a.getLineStart(i2);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int d() {
        return this.f52627a.getLineCount();
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final Integer e() {
        return null;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int f(int i2) {
        return this.f52627a.getLineEnd(i2, true);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int g(int i2) {
        return this.f52627a.isLineEllipsized(i2) ? 1 : 0;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public final int h(int i2) {
        return MathKt.b(this.f52627a.getLineBottom(i2));
    }
}
