package org.shadow.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes5.dex */
public final class Range<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient String f57722a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ComparableComparator implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ComparableComparator[] f57723a = {new ComparableComparator("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        ComparableComparator EF5;

        public static ComparableComparator valueOf(String str) {
            return (ComparableComparator) Enum.valueOf(ComparableComparator.class, str);
        }

        public static ComparableComparator[] values() {
            return (ComparableComparator[]) f57723a.clone();
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        String str = this.f57722a;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("[null..null]");
        String string = sb.toString();
        this.f57722a = string;
        return string;
    }
}
