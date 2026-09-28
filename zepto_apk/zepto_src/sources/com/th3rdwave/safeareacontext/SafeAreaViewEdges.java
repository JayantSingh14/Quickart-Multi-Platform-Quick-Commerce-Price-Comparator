package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SafeAreaViewEdges {

    /* renamed from: a, reason: collision with root package name */
    public final SafeAreaViewEdgeModes f47179a;

    /* renamed from: b, reason: collision with root package name */
    public final SafeAreaViewEdgeModes f47180b;

    /* renamed from: c, reason: collision with root package name */
    public final SafeAreaViewEdgeModes f47181c;

    /* renamed from: d, reason: collision with root package name */
    public final SafeAreaViewEdgeModes f47182d;

    public SafeAreaViewEdges(SafeAreaViewEdgeModes top, SafeAreaViewEdgeModes right, SafeAreaViewEdgeModes bottom, SafeAreaViewEdgeModes left) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        this.f47179a = top;
        this.f47180b = right;
        this.f47181c = bottom;
        this.f47182d = left;
    }

    public final SafeAreaViewEdgeModes a() {
        return this.f47181c;
    }

    public final SafeAreaViewEdgeModes b() {
        return this.f47182d;
    }

    public final SafeAreaViewEdgeModes c() {
        return this.f47180b;
    }

    public final SafeAreaViewEdgeModes d() {
        return this.f47179a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewEdges)) {
            return false;
        }
        SafeAreaViewEdges safeAreaViewEdges = (SafeAreaViewEdges) obj;
        return this.f47179a == safeAreaViewEdges.f47179a && this.f47180b == safeAreaViewEdges.f47180b && this.f47181c == safeAreaViewEdges.f47181c && this.f47182d == safeAreaViewEdges.f47182d;
    }

    public final int hashCode() {
        return this.f47182d.hashCode() + ((this.f47181c.hashCode() + ((this.f47180b.hashCode() + (this.f47179a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "SafeAreaViewEdges(top=" + this.f47179a + ", right=" + this.f47180b + ", bottom=" + this.f47181c + ", left=" + this.f47182d + ")";
    }
}
