package com.th3rdwave.safeareacontext;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class EdgeInsets {

    /* renamed from: a, reason: collision with root package name */
    public final float f47154a;

    /* renamed from: b, reason: collision with root package name */
    public final float f47155b;

    /* renamed from: c, reason: collision with root package name */
    public final float f47156c;

    /* renamed from: d, reason: collision with root package name */
    public final float f47157d;

    public EdgeInsets(float f2, float f3, float f4, float f5) {
        this.f47154a = f2;
        this.f47155b = f3;
        this.f47156c = f4;
        this.f47157d = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeInsets)) {
            return false;
        }
        EdgeInsets edgeInsets = (EdgeInsets) obj;
        return Float.compare(this.f47154a, edgeInsets.f47154a) == 0 && Float.compare(this.f47155b, edgeInsets.f47155b) == 0 && Float.compare(this.f47156c, edgeInsets.f47156c) == 0 && Float.compare(this.f47157d, edgeInsets.f47157d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f47157d) + ((Float.hashCode(this.f47156c) + ((Float.hashCode(this.f47155b) + (Float.hashCode(this.f47154a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "EdgeInsets(top=" + this.f47154a + ", right=" + this.f47155b + ", bottom=" + this.f47156c + ", left=" + this.f47157d + ")";
    }
}
