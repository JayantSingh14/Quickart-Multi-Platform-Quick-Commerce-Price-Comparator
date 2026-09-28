package com.swmansion.rnscreens.utils;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class PaddingBundle {

    /* renamed from: a, reason: collision with root package name */
    public final float f47149a;

    /* renamed from: b, reason: collision with root package name */
    public final float f47150b;

    /* renamed from: c, reason: collision with root package name */
    public final float f47151c;

    public PaddingBundle(float f2, float f3, float f4) {
        this.f47149a = f2;
        this.f47150b = f3;
        this.f47151c = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingBundle)) {
            return false;
        }
        PaddingBundle paddingBundle = (PaddingBundle) obj;
        return Float.compare(this.f47149a, paddingBundle.f47149a) == 0 && Float.compare(this.f47150b, paddingBundle.f47150b) == 0 && Float.compare(this.f47151c, paddingBundle.f47151c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f47151c) + ((Float.hashCode(this.f47150b) + (Float.hashCode(this.f47149a) * 31)) * 31);
    }

    public final String toString() {
        return "PaddingBundle(height=" + this.f47149a + ", paddingStart=" + this.f47150b + ", paddingEnd=" + this.f47151c + ")";
    }
}
