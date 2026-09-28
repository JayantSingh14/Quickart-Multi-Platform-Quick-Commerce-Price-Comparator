package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class AbsoluteCornerSize implements CornerSize {

    /* renamed from: a, reason: collision with root package name */
    public final float f40968a;

    public AbsoluteCornerSize(float f2) {
        this.f40968a = f2;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float a(RectF rectF) {
        return this.f40968a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbsoluteCornerSize) && this.f40968a == ((AbsoluteCornerSize) obj).f40968a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f40968a)});
    }
}
