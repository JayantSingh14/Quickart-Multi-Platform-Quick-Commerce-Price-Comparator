package ch.qos.logback.core.pattern;

import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public class FormatInfo {

    /* renamed from: a, reason: collision with root package name */
    public int f13652a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f13653b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13654c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13655d = true;

    public final int a() {
        return this.f13653b;
    }

    public final int b() {
        return this.f13652a;
    }

    public final boolean c() {
        return this.f13654c;
    }

    public final boolean d() {
        return this.f13655d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatInfo)) {
            return false;
        }
        FormatInfo formatInfo = (FormatInfo) obj;
        return this.f13652a == formatInfo.f13652a && this.f13653b == formatInfo.f13653b && this.f13654c == formatInfo.f13654c && this.f13655d == formatInfo.f13655d;
    }

    public final int hashCode() {
        return (((((this.f13652a * 31) + this.f13653b) * 31) + (this.f13654c ? 1 : 0)) * 31) + (this.f13655d ? 1 : 0);
    }

    public final String toString() {
        return "FormatInfo(" + this.f13652a + ", " + this.f13653b + ", " + this.f13654c + ", " + this.f13655d + ")";
    }
}
