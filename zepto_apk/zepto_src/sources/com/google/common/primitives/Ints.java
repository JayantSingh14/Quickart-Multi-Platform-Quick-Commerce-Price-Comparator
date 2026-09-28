package com.google.common.primitives;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.xbill.DNS.TTL;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class Ints extends IntsMethodsForWeb {

    @GwtCompatible
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f43314a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43315b;

        /* renamed from: c, reason: collision with root package name */
        public final int f43316c;

        public IntArrayAsList(int i2, int i3, int[] iArr) {
            this.f43314a = iArr;
            this.f43315b = i2;
            this.f43316c = i3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return Ints.e(this.f43314a, ((Integer) obj).intValue(), this.f43315b, this.f43316c) != -1;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f43314a[this.f43315b + i2] != intArrayAsList.f43314a[intArrayAsList.f43315b + i2]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, size());
            return Integer.valueOf(this.f43314a[this.f43315b + i2]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            int i2 = 1;
            for (int i3 = this.f43315b; i3 < this.f43316c; i3++) {
                i2 = (i2 * 31) + this.f43314a[i3];
            }
            return i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            int iIntValue = ((Integer) obj).intValue();
            int[] iArr = this.f43314a;
            int i2 = this.f43315b;
            int iE = Ints.e(iArr, iIntValue, i2, this.f43316c);
            if (iE >= 0) {
                return iE - i2;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            int i2;
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                int i3 = this.f43316c;
                while (true) {
                    i3--;
                    i2 = this.f43315b;
                    if (i3 < i2) {
                        i3 = -1;
                        break;
                    }
                    if (this.f43314a[i3] == iIntValue) {
                        break;
                    }
                }
                if (i3 >= 0) {
                    return i3 - i2;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            Integer num = (Integer) obj;
            Preconditions.i(i2, size());
            int i3 = this.f43315b + i2;
            int[] iArr = this.f43314a;
            int i4 = iArr[i3];
            num.getClass();
            iArr[i3] = num.intValue();
            return Integer.valueOf(i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43316c - this.f43315b;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            Preconditions.l(i2, i3, size());
            if (i2 == i3) {
                return Collections.EMPTY_LIST;
            }
            int i4 = this.f43315b;
            return new IntArrayAsList(i2 + i4, i4 + i3, this.f43314a);
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            int[] iArr = this.f43314a;
            int i2 = this.f43315b;
            sb.append(iArr[i2]);
            while (true) {
                i2++;
                if (i2 >= this.f43316c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(iArr[i2]);
            }
        }
    }

    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        @Override // com.google.common.base.Converter
        public final Object b(Object obj) {
            return Integer.decode((String) obj);
        }

        public final String toString() {
            return "Ints.stringConverter()";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LexicographicalComparator implements Comparator<int[]> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f43317a = {new LexicographicalComparator("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LexicographicalComparator EF5;

        public static LexicographicalComparator valueOf(String str) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f43317a.clone();
        }

        @Override // java.util.Comparator
        public final int compare(int[] iArr, int[] iArr2) {
            int[] iArr3 = iArr;
            int[] iArr4 = iArr2;
            int iMin = Math.min(iArr3.length, iArr4.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                int i3 = iArr3[i2];
                int i4 = iArr4[i2];
                int i5 = i3 < i4 ? -1 : i3 > i4 ? 1 : 0;
                if (i5 != 0) {
                    return i5;
                }
            }
            return iArr3.length - iArr4.length;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    public static List a(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new IntArrayAsList(0, iArr.length, iArr);
    }

    public static int b(long j2) {
        int i2 = (int) j2;
        Preconditions.c(j2, "Out of range: %s", ((long) i2) == j2);
        return i2;
    }

    public static int c(int i2, int i3) {
        Preconditions.b(i3, 1073741823, "min (%s) must be less than or equal to max (%s)", i3 <= 1073741823);
        return Math.min(Math.max(i2, i3), 1073741823);
    }

    public static int d(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int e(int[] iArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (iArr[i3] == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int f(long j2) {
        if (j2 > TTL.MAX_VALUE) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    public static int[] g(Collection collection) {
        if (collection instanceof IntArrayAsList) {
            IntArrayAsList intArrayAsList = (IntArrayAsList) collection;
            return Arrays.copyOfRange(intArrayAsList.f43314a, intArrayAsList.f43315b, intArrayAsList.f43316c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = array[i2];
            obj.getClass();
            iArr[i2] = ((Number) obj).intValue();
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer h(java.lang.String r21) {
        /*
            r0 = r21
            r1 = 1
            r0.getClass()
            boolean r2 = r0.isEmpty()
            r3 = 0
            if (r2 == 0) goto L10
        Ld:
            r0 = r3
            goto L85
        L10:
            r2 = 0
            char r4 = r0.charAt(r2)
            r5 = 45
            if (r4 != r5) goto L1a
            r2 = r1
        L1a:
            int r4 = r0.length()
            if (r2 != r4) goto L21
            goto Ld
        L21:
            int r4 = r2 + 1
            char r5 = r0.charAt(r2)
            r6 = -1
            r7 = 128(0x80, float:1.794E-43)
            if (r5 >= r7) goto L31
            byte[] r8 = com.google.common.primitives.Longs.AsciiDigits.f43318a
            r5 = r8[r5]
            goto L34
        L31:
            byte[] r5 = com.google.common.primitives.Longs.AsciiDigits.f43318a
            r5 = r6
        L34:
            if (r5 < 0) goto Ld
            r8 = 10
            if (r5 < r8) goto L3b
            goto Ld
        L3b:
            int r5 = -r5
            long r9 = (long) r5
            long r11 = (long) r8
            r13 = -9223372036854775808
            long r15 = r13 / r11
        L42:
            int r5 = r0.length()
            if (r4 >= r5) goto L72
            int r5 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 >= r7) goto L55
            byte[] r17 = com.google.common.primitives.Longs.AsciiDigits.f43318a
            r4 = r17[r4]
            goto L58
        L55:
            byte[] r4 = com.google.common.primitives.Longs.AsciiDigits.f43318a
            r4 = r6
        L58:
            if (r4 < 0) goto Ld
            if (r4 >= r8) goto Ld
            int r17 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r17 >= 0) goto L61
            goto Ld
        L61:
            long r9 = r9 * r11
            r18 = r2
            long r1 = (long) r4
            long r19 = r1 + r13
            int r4 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r4 >= 0) goto L6c
            goto Ld
        L6c:
            long r9 = r9 - r1
            r4 = r5
            r2 = r18
            r1 = 1
            goto L42
        L72:
            r18 = r2
            if (r18 == 0) goto L7b
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            goto L85
        L7b:
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 != 0) goto L80
            goto Ld
        L80:
            long r0 = -r9
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L85:
            if (r0 == 0) goto L9e
            long r1 = r0.longValue()
            int r4 = r0.intValue()
            long r4 = (long) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L95
            goto L9e
        L95:
            int r0 = r0.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L9e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Ints.h(java.lang.String):java.lang.Integer");
    }
}
