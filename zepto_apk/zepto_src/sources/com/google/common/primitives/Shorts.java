package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class Shorts extends ShortsMethodsForWeb {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LexicographicalComparator implements Comparator<short[]> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f43324a = {new LexicographicalComparator("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LexicographicalComparator EF5;

        public static LexicographicalComparator valueOf(String str) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f43324a.clone();
        }

        @Override // java.util.Comparator
        public final int compare(short[] sArr, short[] sArr2) {
            short[] sArr3 = sArr;
            short[] sArr4 = sArr2;
            int iMin = Math.min(sArr3.length, sArr4.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                int i3 = sArr3[i2] - sArr4[i2];
                if (i3 != 0) {
                    return i3;
                }
            }
            return sArr3.length - sArr4.length;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final int f43325a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43326b;

        public ShortArrayAsList(int i2, int i3) {
            this.f43325a = i2;
            this.f43326b = i3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Short)) {
                return false;
            }
            ((Short) obj).shortValue();
            if (this.f43325a >= this.f43326b) {
                return false;
            }
            throw null;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            int size = size();
            if (((ShortArrayAsList) obj).size() != size) {
                return false;
            }
            if (size <= 0) {
                return true;
            }
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, size());
            throw null;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            if (this.f43325a >= this.f43326b) {
                return 1;
            }
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            ((Short) obj).shortValue();
            if (this.f43325a >= this.f43326b) {
                return -1;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            ((Short) obj).shortValue();
            if (this.f43326b - 1 < this.f43325a) {
                return -1;
            }
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            Preconditions.i(i2, size());
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43326b - this.f43325a;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            Preconditions.l(i2, i3, size());
            if (i2 == i3) {
                return Collections.EMPTY_LIST;
            }
            int i4 = this.f43325a;
            return new ShortArrayAsList(i2 + i4, i4 + i3);
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            new StringBuilder(size() * 6).append('[');
            throw null;
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        @Override // com.google.common.base.Converter
        public final Object b(Object obj) {
            return Short.decode((String) obj);
        }

        public final String toString() {
            return "Shorts.stringConverter()";
        }
    }
}
