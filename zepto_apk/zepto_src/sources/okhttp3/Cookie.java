package okhttp3;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.http.DatesKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class Cookie {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f56221j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f56222k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f56223l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f56224m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f56225a;

    /* renamed from: b, reason: collision with root package name */
    public final String f56226b;

    /* renamed from: c, reason: collision with root package name */
    public final long f56227c;

    /* renamed from: d, reason: collision with root package name */
    public final String f56228d;

    /* renamed from: e, reason: collision with root package name */
    public final String f56229e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f56230f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f56231g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f56232h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f56233i;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f56234a;

        /* renamed from: b, reason: collision with root package name */
        public String f56235b;

        /* renamed from: c, reason: collision with root package name */
        public String f56236c;

        public final Cookie a() {
            String str = this.f56234a;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.f56235b;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            String str3 = this.f56236c;
            if (str3 != null) {
                return new Cookie(str, str2, 253402300799999L, str3, "/", false, false, false, false);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final void b(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            String strB = HostnamesKt.b(domain);
            if (strB == null) {
                throw new IllegalArgumentException("unexpected domain: ".concat(domain));
            }
            this.f56236c = strB;
        }

        public final void c(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (!Intrinsics.b(StringsKt.b0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.f56234a = name;
        }

        public final void d(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (!Intrinsics.b(StringsKt.b0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.f56235b = value;
        }
    }

    @Metadata
    public static final class Companion {
        public static int a(int i2, int i3, String str, boolean z) {
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static long b(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.b(int, java.lang.String):long");
        }
    }

    public Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f56225a = str;
        this.f56226b = str2;
        this.f56227c = j2;
        this.f56228d = str3;
        this.f56229e = str4;
        this.f56230f = z;
        this.f56231g = z2;
        this.f56232h = z3;
        this.f56233i = z4;
    }

    public final String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56225a);
        sb.append('=');
        sb.append(this.f56226b);
        if (this.f56232h) {
            long j2 = this.f56227c;
            if (j2 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.b(new Date(j2)));
            }
        }
        if (!this.f56233i) {
            sb.append("; domain=");
            if (z) {
                sb.append(CLConstants.DOT_SALT_DELIMETER);
            }
            sb.append(this.f56228d);
        }
        sb.append("; path=");
        sb.append(this.f56229e);
        if (this.f56230f) {
            sb.append("; secure");
        }
        if (this.f56231g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.b(cookie.f56225a, this.f56225a) && Intrinsics.b(cookie.f56226b, this.f56226b) && cookie.f56227c == this.f56227c && Intrinsics.b(cookie.f56228d, this.f56228d) && Intrinsics.b(cookie.f56229e, this.f56229e) && cookie.f56230f == this.f56230f && cookie.f56231g == this.f56231g && cookie.f56232h == this.f56232h && cookie.f56233i == this.f56233i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f56233i) + ((Boolean.hashCode(this.f56232h) + ((Boolean.hashCode(this.f56231g) + ((Boolean.hashCode(this.f56230f) + e.e(e.e(a.d(e.e(e.e(527, 31, this.f56225a), 31, this.f56226b), 31, this.f56227c), 31, this.f56228d), 31, this.f56229e)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return a(false);
    }
}
