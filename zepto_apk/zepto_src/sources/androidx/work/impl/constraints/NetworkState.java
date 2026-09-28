package androidx.work.impl.constraints;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class NetworkState {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12797a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12798b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12799c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12800d;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f12797a = z;
        this.f12798b = z2;
        this.f12799c = z3;
        this.f12800d = z4;
    }

    public final boolean a() {
        return this.f12797a;
    }

    public final boolean b() {
        return this.f12799c;
    }

    public final boolean c() {
        return this.f12800d;
    }

    public final boolean d() {
        return this.f12798b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.f12797a == networkState.f12797a && this.f12798b == networkState.f12798b && this.f12799c == networkState.f12799c && this.f12800d == networkState.f12800d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z = this.f12797a;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = i2 * 31;
        boolean z2 = this.f12798b;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.f12799c;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z4 = this.f12800d;
        return i7 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f12797a + ", isValidated=" + this.f12798b + ", isMetered=" + this.f12799c + ", isNotRoaming=" + this.f12800d + ')';
    }
}
