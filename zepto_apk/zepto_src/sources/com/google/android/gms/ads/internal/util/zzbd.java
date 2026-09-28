package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final String f21517a;

    /* renamed from: b, reason: collision with root package name */
    public final double f21518b;

    /* renamed from: c, reason: collision with root package name */
    public final double f21519c;

    /* renamed from: d, reason: collision with root package name */
    public final double f21520d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21521e;

    public zzbd(String str, double d2, double d3, double d4, int i2) {
        this.f21517a = str;
        this.f21519c = d2;
        this.f21518b = d3;
        this.f21520d = d4;
        this.f21521e = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return Objects.equal(this.f21517a, zzbdVar.f21517a) && this.f21518b == zzbdVar.f21518b && this.f21519c == zzbdVar.f21519c && this.f21521e == zzbdVar.f21521e && Double.compare(this.f21520d, zzbdVar.f21520d) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21517a, Double.valueOf(this.f21518b), Double.valueOf(this.f21519c), Double.valueOf(this.f21520d), Integer.valueOf(this.f21521e));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(CLConstants.FIELD_PAY_INFO_NAME, this.f21517a).add("minBound", Double.valueOf(this.f21519c)).add("maxBound", Double.valueOf(this.f21518b)).add("percent", Double.valueOf(this.f21520d)).add("count", Integer.valueOf(this.f21521e)).toString();
    }
}
