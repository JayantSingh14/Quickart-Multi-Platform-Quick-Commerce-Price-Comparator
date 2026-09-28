package org.shadow.apache.commons.lang3.tuple;

import java.io.Serializable;
import org.shadow.apache.commons.lang3.ObjectUtils;
import org.shadow.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes5.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        ((Triple) obj).getClass();
        compareToBuilder.a(null, null);
        compareToBuilder.a(null, null);
        compareToBuilder.a(null, null);
        return compareToBuilder.f57730a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        ((Triple) obj).getClass();
        return ObjectUtils.a(null, null) && ObjectUtils.a(null, null) && ObjectUtils.a(null, null);
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "(null,null,null)";
    }
}
