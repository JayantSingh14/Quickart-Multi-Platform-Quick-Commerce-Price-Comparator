package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UrlDecodedParametersBuilderKt {
    public static final Parameters a(ParametersBuilder parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilderImpl parametersBuilderImplA = ParametersKt.a();
        for (String str : parameters.names()) {
            List listA = parameters.a(str);
            if (listA == null) {
                listA = EmptyList.f53609a;
            }
            String strE = CodecsKt.e(0, 0, 15, str);
            List list = listA;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(CodecsKt.e(0, 0, 11, (String) it.next()));
            }
            parametersBuilderImplA.b(arrayList, strE);
        }
        return new ParametersImpl(parametersBuilderImplA.f50508b);
    }
}
