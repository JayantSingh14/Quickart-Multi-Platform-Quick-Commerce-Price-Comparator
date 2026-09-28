package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ProcessDetails {

    /* renamed from: a, reason: collision with root package name */
    public final String f45023a;

    /* renamed from: b, reason: collision with root package name */
    public final int f45024b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45025c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f45026d;

    public ProcessDetails(int i2, int i3, String processName, boolean z) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        this.f45023a = processName;
        this.f45024b = i2;
        this.f45025c = i3;
        this.f45026d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return Intrinsics.b(this.f45023a, processDetails.f45023a) && this.f45024b == processDetails.f45024b && this.f45025c == processDetails.f45025c && this.f45026d == processDetails.f45026d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iB = android.support.v4.media.a.b(this.f45025c, android.support.v4.media.a.b(this.f45024b, this.f45023a.hashCode() * 31, 31), 31);
        boolean z = this.f45026d;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return iB + i2;
    }

    public final String toString() {
        return "ProcessDetails(processName=" + this.f45023a + ", pid=" + this.f45024b + ", importance=" + this.f45025c + ", isDefaultProcess=" + this.f45026d + ')';
    }
}
