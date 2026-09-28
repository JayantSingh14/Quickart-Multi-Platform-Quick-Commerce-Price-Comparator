package org.shadow.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import org.shadow.apache.commons.lang3.ObjectUtils;
import org.shadow.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes5.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    public abstract Object a();

    public abstract Object b();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Pair pair = (Pair) obj;
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        compareToBuilder.a(a(), pair.a());
        compareToBuilder.a(b(), pair.b());
        return compareToBuilder.f57730a;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ObjectUtils.a(a(), entry.getKey()) && ObjectUtils.a(b(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return b();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (a() == null ? 0 : a().hashCode()) ^ (b() != null ? b().hashCode() : 0);
    }

    public String toString() {
        return "(" + a() + ',' + b() + ')';
    }
}
