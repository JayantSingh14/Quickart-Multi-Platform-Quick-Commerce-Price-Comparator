package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo
/* loaded from: classes4.dex */
public final class ClampedCornerSize implements CornerSize {

    /* renamed from: a, reason: collision with root package name */
    public final float f40971a;

    public ClampedCornerSize(float f2) {
        this.f40971a = f2;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float a(RectF rectF) {
        return Math.min(this.f40971a, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClampedCornerSize) && this.f40971a == ((ClampedCornerSize) obj).f40971a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f40971a)});
    }
}
