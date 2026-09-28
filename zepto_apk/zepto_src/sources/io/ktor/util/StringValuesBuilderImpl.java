package io.ktor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class StringValuesBuilderImpl implements StringValuesBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f50507a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f50508b;

    public StringValuesBuilderImpl(boolean z) {
        this.f50507a = z;
        this.f50508b = z ? new CaseInsensitiveMap() : new LinkedHashMap(8);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final List a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (List) this.f50508b.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final void b(Iterable values, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List listG = g(name);
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k(str);
            listG.add(str);
        }
    }

    public final void c(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        k(value);
        g(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set d() {
        Set setEntrySet = this.f50508b.entrySet();
        Intrinsics.checkNotNullParameter(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }

    public final void e(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.c(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl$appendAll$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String name = (String) obj;
                List values = (List) obj2;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                this.f50509c.b(values, name);
                return Unit.f53572a;
            }
        });
    }

    public final void f() {
        this.f50508b.clear();
    }

    public final List g(String str) {
        Map map = this.f50508b;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        j(str);
        map.put(str, arrayList);
        return arrayList;
    }

    public final String h(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List listA = a(name);
        if (listA != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(listA);
        }
        return null;
    }

    public final void i(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f50508b.remove(name);
    }

    public void j(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public void k(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Set names() {
        return this.f50508b.keySet();
    }

    public StringValuesBuilderImpl() {
        this(false);
    }
}
