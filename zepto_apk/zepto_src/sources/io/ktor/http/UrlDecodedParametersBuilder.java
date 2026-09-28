package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UrlDecodedParametersBuilder implements ParametersBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final ParametersBuilderImpl f50279a;

    public UrlDecodedParametersBuilder(ParametersBuilderImpl encodedParametersBuilder) {
        Intrinsics.checkNotNullParameter(encodedParametersBuilder, "encodedParametersBuilder");
        this.f50279a = encodedParametersBuilder;
        boolean z = encodedParametersBuilder.f50507a;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final List a(String name) throws Throwable {
        Intrinsics.checkNotNullParameter(name, "name");
        List listA = this.f50279a.a(CodecsKt.f(name, false));
        if (listA == null) {
            return null;
        }
        List list = listA;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.e(0, 0, 11, (String) it.next()));
        }
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void b(Iterable values, String name) throws Throwable {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        String strF = CodecsKt.f(name, false);
        ArrayList arrayList = new ArrayList(CollectionsKt.r(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Intrinsics.checkNotNullParameter(str, "<this>");
            arrayList.add(CodecsKt.f(str, true));
        }
        this.f50279a.b(arrayList, strF);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set d() {
        return ((StringValuesImpl) UrlDecodedParametersBuilderKt.a(this.f50279a)).d();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set names() {
        Set setKeySet = this.f50279a.f50508b.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.r(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.e(0, 0, 15, (String) it.next()));
        }
        return CollectionsKt.h0(arrayList);
    }
}
