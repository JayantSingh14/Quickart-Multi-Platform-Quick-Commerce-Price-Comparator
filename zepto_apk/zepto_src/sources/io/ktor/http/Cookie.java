package io.ktor.http;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Cookie {

    /* renamed from: a, reason: collision with root package name */
    public final String f50132a;

    /* renamed from: b, reason: collision with root package name */
    public final String f50133b;

    /* renamed from: c, reason: collision with root package name */
    public final CookieEncoding f50134c;

    /* renamed from: d, reason: collision with root package name */
    public final int f50135d;

    /* renamed from: e, reason: collision with root package name */
    public final GMTDate f50136e;

    /* renamed from: f, reason: collision with root package name */
    public final String f50137f;

    /* renamed from: g, reason: collision with root package name */
    public final String f50138g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f50139h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f50140i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f50141j;

    public Cookie(String name, String value, CookieEncoding encoding, int i2, GMTDate gMTDate, String str, String str2, boolean z, boolean z2, Map extensions) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.f50132a = name;
        this.f50133b = value;
        this.f50134c = encoding;
        this.f50135d = i2;
        this.f50136e = gMTDate;
        this.f50137f = str;
        this.f50138g = str2;
        this.f50139h = z;
        this.f50140i = z2;
        this.f50141j = extensions;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.util.Map] */
    public static Cookie a(Cookie cookie, String str, String str2, int i2) {
        if ((i2 & 32) != 0) {
            str = cookie.f50137f;
        }
        String str3 = str;
        if ((i2 & 64) != 0) {
            str2 = cookie.f50138g;
        }
        ?? extensions = cookie.f50141j;
        String name = cookie.f50132a;
        Intrinsics.checkNotNullParameter(name, "name");
        String value = cookie.f50133b;
        Intrinsics.checkNotNullParameter(value, "value");
        CookieEncoding encoding = cookie.f50134c;
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        return new Cookie(name, value, encoding, cookie.f50135d, cookie.f50136e, str3, str2, cookie.f50139h, cookie.f50140i, extensions);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.b(this.f50132a, cookie.f50132a) && Intrinsics.b(this.f50133b, cookie.f50133b) && this.f50134c == cookie.f50134c && this.f50135d == cookie.f50135d && Intrinsics.b(this.f50136e, cookie.f50136e) && Intrinsics.b(this.f50137f, cookie.f50137f) && Intrinsics.b(this.f50138g, cookie.f50138g) && this.f50139h == cookie.f50139h && this.f50140i == cookie.f50140i && this.f50141j.equals(cookie.f50141j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iB = a.b(this.f50135d, (this.f50134c.hashCode() + e.e(this.f50132a.hashCode() * 31, 31, this.f50133b)) * 31, 31);
        GMTDate gMTDate = this.f50136e;
        int iHashCode = (iB + (gMTDate == null ? 0 : gMTDate.hashCode())) * 31;
        String str = this.f50137f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f50138g;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.f50139h;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode3 + i2) * 31;
        boolean z2 = this.f50140i;
        return this.f50141j.hashCode() + ((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31);
    }

    public final String toString() {
        return "Cookie(name=" + this.f50132a + ", value=" + this.f50133b + ", encoding=" + this.f50134c + ", maxAge=" + this.f50135d + ", expires=" + this.f50136e + ", domain=" + this.f50137f + ", path=" + this.f50138g + ", secure=" + this.f50139h + ", httpOnly=" + this.f50140i + ", extensions=" + this.f50141j + ')';
    }
}
