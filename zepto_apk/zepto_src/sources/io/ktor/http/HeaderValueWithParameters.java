package io.ktor.http;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class HeaderValueWithParameters {

    /* renamed from: a, reason: collision with root package name */
    public final String f50197a;

    /* renamed from: b, reason: collision with root package name */
    public final List f50198b;

    @Metadata
    public static final class Companion {
    }

    public HeaderValueWithParameters(String content, List parameters) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f50197a = content;
        this.f50198b = parameters;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.f50198b;
        int iB = CollectionsKt.B(list);
        if (iB < 0) {
            return null;
        }
        int i2 = 0;
        while (true) {
            HeaderValueParam headerValueParam = (HeaderValueParam) list.get(i2);
            if (StringsKt.t(headerValueParam.c(), name, true)) {
                return headerValueParam.d();
            }
            if (i2 == iB) {
                return null;
            }
            i2++;
        }
    }

    public final String toString() {
        List<HeaderValueParam> list = this.f50198b;
        boolean zIsEmpty = list.isEmpty();
        String str = this.f50197a;
        if (zIsEmpty) {
            return str;
        }
        int length = str.length();
        int i2 = 0;
        int length2 = 0;
        for (HeaderValueParam headerValueParam : list) {
            length2 += headerValueParam.d().length() + headerValueParam.c().length() + 3;
        }
        StringBuilder sb = new StringBuilder(length + length2);
        sb.append(str);
        int iB = CollectionsKt.B(list);
        if (iB >= 0) {
            while (true) {
                HeaderValueParam headerValueParam2 = (HeaderValueParam) list.get(i2);
                sb.append("; ");
                sb.append(headerValueParam2.c());
                sb.append("=");
                String strD = headerValueParam2.d();
                if (HeaderValueWithParametersKt.a(strD)) {
                    sb.append(HeaderValueWithParametersKt.b(strD));
                } else {
                    sb.append(strD);
                }
                if (i2 == iB) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "{\n            val size =…   }.toString()\n        }");
        return string;
    }
}
