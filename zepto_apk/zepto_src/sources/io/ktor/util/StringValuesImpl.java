package io.ktor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class StringValuesImpl implements StringValues {

    /* renamed from: d, reason: collision with root package name */
    public final boolean f50510d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f50511e;

    public StringValuesImpl() {
        this(0);
    }

    @Override // io.ktor.util.StringValues
    public final List a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (List) this.f50511e.get(name);
    }

    @Override // io.ktor.util.StringValues
    public final String b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = (List) this.f50511e.get(name);
        if (list != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        for (Map.Entry entry : this.f50511e.entrySet()) {
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    @Override // io.ktor.util.StringValues
    public final Set d() {
        Set setEntrySet = this.f50511e.entrySet();
        Intrinsics.checkNotNullParameter(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }

    @Override // io.ktor.util.StringValues
    public final boolean e() {
        return this.f50510d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (this.f50510d != stringValues.e()) {
            return false;
        }
        return Intrinsics.b(d(), stringValues.d());
    }

    public final int hashCode() {
        Set setD = d();
        return setD.hashCode() + (Boolean.hashCode(this.f50510d) * 961);
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return this.f50511e.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StringValues(case=");
        sb.append(!this.f50510d);
        sb.append(") ");
        sb.append(d());
        return sb.toString();
    }

    public StringValuesImpl(Map values, boolean z) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.f50510d = z;
        Map caseInsensitiveMap = z ? new CaseInsensitiveMap() : new LinkedHashMap();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add((String) list.get(i2));
            }
            caseInsensitiveMap.put(str, arrayList);
        }
        this.f50511e = caseInsensitiveMap;
    }

    public /* synthetic */ StringValuesImpl(int i2) {
        this(MapsKt.c(), false);
    }
}
