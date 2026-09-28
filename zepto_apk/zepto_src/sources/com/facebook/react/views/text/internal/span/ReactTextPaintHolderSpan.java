package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactTextPaintHolderSpan implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f20167a;

    public ReactTextPaintHolderSpan(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.f20167a = textPaint;
    }

    public final TextPaint a() {
        return this.f20167a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReactTextPaintHolderSpan) && Intrinsics.b(this.f20167a, ((ReactTextPaintHolderSpan) obj).f20167a);
    }

    public final int hashCode() {
        return this.f20167a.hashCode();
    }

    public final String toString() {
        return "ReactTextPaintHolderSpan(textPaint=" + this.f20167a + ")";
    }
}
