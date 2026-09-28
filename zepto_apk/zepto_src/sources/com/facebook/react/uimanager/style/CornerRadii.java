package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.PixelUtil;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class CornerRadii {

    /* renamed from: a, reason: collision with root package name */
    public final float f19879a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19880b;

    public CornerRadii() {
        this(0.0f, 0.0f);
    }

    public final CornerRadii a() {
        return new CornerRadii(PixelUtil.b(this.f19879a), PixelUtil.b(this.f19880b));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CornerRadii)) {
            return false;
        }
        CornerRadii cornerRadii = (CornerRadii) obj;
        return Float.compare(this.f19879a, cornerRadii.f19879a) == 0 && Float.compare(this.f19880b, cornerRadii.f19880b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f19880b) + (Float.hashCode(this.f19879a) * 31);
    }

    public final String toString() {
        return "CornerRadii(horizontal=" + this.f19879a + ", vertical=" + this.f19880b + ")";
    }

    public CornerRadii(float f2, float f3) {
        this.f19879a = f2;
        this.f19880b = f3;
    }
}
