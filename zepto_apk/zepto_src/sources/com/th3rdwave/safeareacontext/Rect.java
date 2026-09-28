package com.th3rdwave.safeareacontext;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class Rect {

    /* renamed from: a, reason: collision with root package name */
    public final float f47160a;

    /* renamed from: b, reason: collision with root package name */
    public final float f47161b;

    /* renamed from: c, reason: collision with root package name */
    public final float f47162c;

    /* renamed from: d, reason: collision with root package name */
    public final float f47163d;

    public Rect(float f2, float f3, float f4, float f5) {
        this.f47160a = f2;
        this.f47161b = f3;
        this.f47162c = f4;
        this.f47163d = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return Float.compare(this.f47160a, rect.f47160a) == 0 && Float.compare(this.f47161b, rect.f47161b) == 0 && Float.compare(this.f47162c, rect.f47162c) == 0 && Float.compare(this.f47163d, rect.f47163d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f47163d) + ((Float.hashCode(this.f47162c) + ((Float.hashCode(this.f47161b) + (Float.hashCode(this.f47160a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Rect(x=" + this.f47160a + ", y=" + this.f47161b + ", width=" + this.f47162c + ", height=" + this.f47163d + ")";
    }
}
