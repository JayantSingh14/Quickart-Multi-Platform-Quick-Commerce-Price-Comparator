package com.zeptoconsumerapp.apiprefetch.homepage;

import com.zeptoconsumerapp.apiprefetch.base.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class HomePageOptions extends Options {

    /* renamed from: a, reason: collision with root package name */
    public final String f47589a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f47590b;

    /* renamed from: c, reason: collision with root package name */
    public final Double f47591c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f47592d;

    public HomePageOptions(String requestKey, Double d2, Double d3, boolean z) {
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        this.f47589a = requestKey;
        this.f47590b = d2;
        this.f47591c = d3;
        this.f47592d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePageOptions)) {
            return false;
        }
        HomePageOptions homePageOptions = (HomePageOptions) obj;
        return Intrinsics.b(this.f47589a, homePageOptions.f47589a) && Intrinsics.b(this.f47590b, homePageOptions.f47590b) && Intrinsics.b(this.f47591c, homePageOptions.f47591c) && this.f47592d == homePageOptions.f47592d;
    }

    public final int hashCode() {
        int iHashCode = this.f47589a.hashCode() * 31;
        Double d2 = this.f47590b;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.f47591c;
        return Boolean.hashCode(this.f47592d) + ((iHashCode2 + (d3 != null ? d3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "HomePageOptions(requestKey=" + this.f47589a + ", latitude=" + this.f47590b + ", longitude=" + this.f47591c + ", hasLocationAccess=" + this.f47592d + ")";
    }
}
