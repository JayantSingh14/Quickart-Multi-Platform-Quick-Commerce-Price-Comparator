package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class RelativeCornerSize implements CornerSize {

    /* renamed from: a, reason: collision with root package name */
    public final float f41004a;

    public RelativeCornerSize(float f2) {
        this.f41004a = f2;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f41004a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RelativeCornerSize) && this.f41004a == ((RelativeCornerSize) obj).f41004a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f41004a)});
    }
}
