package io.ktor.http;

import android.support.v4.media.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class HeaderValueParam {

    /* renamed from: a, reason: collision with root package name */
    public final String f50195a;

    /* renamed from: b, reason: collision with root package name */
    public final String f50196b;

    public HeaderValueParam(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f50195a = name;
        this.f50196b = value;
    }

    public final String a() {
        return this.f50195a;
    }

    public final String b() {
        return this.f50196b;
    }

    public final String c() {
        return this.f50195a;
    }

    public final String d() {
        return this.f50196b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HeaderValueParam)) {
            return false;
        }
        HeaderValueParam headerValueParam = (HeaderValueParam) obj;
        return StringsKt.t(headerValueParam.f50195a, this.f50195a, true) && StringsKt.t(headerValueParam.f50196b, this.f50196b, true);
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.f50195a.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f50196b.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderValueParam(name=");
        sb.append(this.f50195a);
        sb.append(", value=");
        return b.r(sb, this.f50196b, ", escapeValue=false)");
    }
}
