package io.ktor.http;

import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class URLBuilderKt {
    public static final void a(URLBuilder uRLBuilder, StringBuilder sb) {
        List listH;
        sb.append(uRLBuilder.f50241a.f50257a);
        String str = uRLBuilder.f50241a.f50257a;
        if (Intrinsics.b(str, UtilsKt.SCHEME_FILE)) {
            CharSequence charSequence = uRLBuilder.f50242b;
            String strC = c(uRLBuilder);
            sb.append("://");
            sb.append(charSequence);
            if (!StringsKt.Q(strC, '/')) {
                sb.append('/');
            }
            sb.append((CharSequence) strC);
            return;
        }
        if (Intrinsics.b(str, "mailto")) {
            Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
            StringBuilder sb2 = new StringBuilder();
            String str2 = uRLBuilder.f50245e;
            String str3 = uRLBuilder.f50246f;
            Intrinsics.checkNotNullParameter(sb2, "<this>");
            if (str2 != null) {
                sb2.append(str2);
                if (str3 != null) {
                    sb2.append(':');
                    sb2.append(str3);
                }
                sb2.append("@");
            }
            CharSequence string = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            CharSequence charSequence2 = uRLBuilder.f50242b;
            sb.append(":");
            sb.append(string);
            sb.append(charSequence2);
            return;
        }
        sb.append("://");
        sb.append(b(uRLBuilder));
        String encodedPath = c(uRLBuilder);
        ParametersBuilderImpl encodedQueryParameters = uRLBuilder.f50249i;
        boolean z = uRLBuilder.f50244d;
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQueryParameters, "encodedQueryParameters");
        if (!StringsKt.z(encodedPath) && !StringsKt.O(encodedPath, "/", false)) {
            sb.append('/');
        }
        sb.append((CharSequence) encodedPath);
        if (!encodedQueryParameters.f50508b.isEmpty() || z) {
            sb.append("?");
        }
        Set<Map.Entry> setD = encodedQueryParameters.d();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setD) {
            String str4 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listH = CollectionsKt.H(new Pair(str4, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new Pair(str4, (String) it.next()));
                }
                listH = arrayList2;
            }
            CollectionsKt.i(arrayList, listH);
        }
        CollectionsKt.D(arrayList, sb, "&", URLUtilsKt$appendUrlFullPath$2.f50259c, 60);
        if (uRLBuilder.f50247g.length() > 0) {
            sb.append('#');
            sb.append(uRLBuilder.f50247g);
        }
    }

    public static final String b(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb2 = new StringBuilder();
        String str = uRLBuilder.f50245e;
        String str2 = uRLBuilder.f50246f;
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        if (str != null) {
            sb2.append(str);
            if (str2 != null) {
                sb2.append(':');
                sb2.append(str2);
            }
            sb2.append("@");
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        sb.append(string);
        sb.append(uRLBuilder.f50242b);
        int i2 = uRLBuilder.f50243c;
        if (i2 != 0 && i2 != uRLBuilder.f50241a.f50258b) {
            sb.append(":");
            sb.append(String.valueOf(uRLBuilder.f50243c));
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static final String c(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        List list = uRLBuilder.f50248h;
        return list.isEmpty() ? "" : list.size() == 1 ? ((CharSequence) CollectionsKt.z(list)).length() == 0 ? "/" : (String) CollectionsKt.z(list) : CollectionsKt.E(list, "/", null, null, null, 62);
    }

    public static final void d(URLBuilder uRLBuilder, String value) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        uRLBuilder.c(StringsKt.z(value) ? EmptyList.f53609a : value.equals("/") ? URLParserKt.f50251a : CollectionsKt.f0(StringsKt.M(value, new char[]{'/'})));
    }
}
