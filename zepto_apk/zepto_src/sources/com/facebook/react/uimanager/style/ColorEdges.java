package com.facebook.react.uimanager.style;

import android.support.v4.media.a;
import android.support.v4.media.b;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ColorEdges {

    /* renamed from: a, reason: collision with root package name */
    public final int f19869a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19870b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19871c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19872d;

    public ColorEdges() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorEdges)) {
            return false;
        }
        ColorEdges colorEdges = (ColorEdges) obj;
        return this.f19869a == colorEdges.f19869a && this.f19870b == colorEdges.f19870b && this.f19871c == colorEdges.f19871c && this.f19872d == colorEdges.f19872d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f19872d) + a.b(this.f19871c, a.b(this.f19870b, Integer.hashCode(this.f19869a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorEdges(left=");
        sb.append(this.f19869a);
        sb.append(", top=");
        sb.append(this.f19870b);
        sb.append(", right=");
        sb.append(this.f19871c);
        sb.append(", bottom=");
        return b.o(sb, this.f19872d, ")");
    }

    public /* synthetic */ ColorEdges(int i2) {
        this(-16777216, -16777216, -16777216, -16777216);
    }

    public ColorEdges(int i2, int i3, int i4, int i5) {
        this.f19869a = i2;
        this.f19870b = i3;
        this.f19871c = i4;
        this.f19872d = i5;
    }
}
