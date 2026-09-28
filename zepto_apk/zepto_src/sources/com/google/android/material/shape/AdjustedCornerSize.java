package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo
/* loaded from: classes4.dex */
public final class AdjustedCornerSize implements CornerSize {

    /* renamed from: a, reason: collision with root package name */
    public final CornerSize f40969a;

    /* renamed from: b, reason: collision with root package name */
    public final float f40970b;

    public AdjustedCornerSize(float f2, CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).f40969a;
            f2 += ((AdjustedCornerSize) cornerSize).f40970b;
        }
        this.f40969a = cornerSize;
        this.f40970b = f2;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f40969a.a(rectF) + this.f40970b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        return this.f40969a.equals(adjustedCornerSize.f40969a) && this.f40970b == adjustedCornerSize.f40970b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f40969a, Float.valueOf(this.f40970b)});
    }
}
