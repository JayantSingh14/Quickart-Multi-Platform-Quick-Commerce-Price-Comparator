package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SafeAreaViewLocalData {

    /* renamed from: a, reason: collision with root package name */
    public final EdgeInsets f47183a;

    /* renamed from: b, reason: collision with root package name */
    public final SafeAreaViewMode f47184b;

    /* renamed from: c, reason: collision with root package name */
    public final SafeAreaViewEdges f47185c;

    public SafeAreaViewLocalData(EdgeInsets insets, SafeAreaViewMode mode, SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.f47183a = insets;
        this.f47184b = mode;
        this.f47185c = edges;
    }

    public final SafeAreaViewEdges a() {
        return this.f47185c;
    }

    public final EdgeInsets b() {
        return this.f47183a;
    }

    public final SafeAreaViewMode c() {
        return this.f47184b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewLocalData)) {
            return false;
        }
        SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) obj;
        return Intrinsics.b(this.f47183a, safeAreaViewLocalData.f47183a) && this.f47184b == safeAreaViewLocalData.f47184b && Intrinsics.b(this.f47185c, safeAreaViewLocalData.f47185c);
    }

    public final int hashCode() {
        return this.f47185c.hashCode() + ((this.f47184b.hashCode() + (this.f47183a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SafeAreaViewLocalData(insets=" + this.f47183a + ", mode=" + this.f47184b + ", edges=" + this.f47185c + ")";
    }
}
