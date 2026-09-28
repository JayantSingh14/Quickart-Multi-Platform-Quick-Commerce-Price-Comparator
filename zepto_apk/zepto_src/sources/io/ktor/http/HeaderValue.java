package io.ktor.http;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HeaderValue {

    /* renamed from: a, reason: collision with root package name */
    public final String f50192a;

    /* renamed from: b, reason: collision with root package name */
    public final List f50193b;

    /* renamed from: c, reason: collision with root package name */
    public final double f50194c;

    public HeaderValue(String value, List params) {
        Double d2;
        Object next;
        String strD;
        Double dY;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f50192a = value;
        this.f50193b = params;
        Iterator it = params.iterator();
        while (true) {
            d2 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.b(((HeaderValueParam) next).c(), "q")) {
                    break;
                }
            }
        }
        HeaderValueParam headerValueParam = (HeaderValueParam) next;
        double dDoubleValue = 1.0d;
        if (headerValueParam != null && (strD = headerValueParam.d()) != null && (dY = StringsKt.Y(strD)) != null) {
            double dDoubleValue2 = dY.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                d2 = dY;
            }
            if (d2 != null) {
                dDoubleValue = d2.doubleValue();
            }
        }
        this.f50194c = dDoubleValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderValue)) {
            return false;
        }
        HeaderValue headerValue = (HeaderValue) obj;
        return Intrinsics.b(this.f50192a, headerValue.f50192a) && Intrinsics.b(this.f50193b, headerValue.f50193b);
    }

    public final int hashCode() {
        return this.f50193b.hashCode() + (this.f50192a.hashCode() * 31);
    }

    public final String toString() {
        return "HeaderValue(value=" + this.f50192a + ", params=" + this.f50193b + ')';
    }
}
