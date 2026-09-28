package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public static final ImmutableMap f43013g = new RegularImmutableMap(null, new Object[0], 0);

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f43014d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f43015e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f43016f;

    /* loaded from: classes4.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public final transient ImmutableMap f43017d;

        /* renamed from: e, reason: collision with root package name */
        public final transient Object[] f43018e;

        /* renamed from: f, reason: collision with root package name */
        public final transient int f43019f;

        /* renamed from: g, reason: collision with root package name */
        public final transient int f43020g;

        public EntrySet(ImmutableMap immutableMap, Object[] objArr, int i2, int i3) {
            this.f43017d = immutableMap;
            this.f43018e = objArr;
            this.f43019f = i2;
            this.f43020g = i3;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f43017d.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int d(int i2, Object[] objArr) {
            return b().d(i2, objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            return b().listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableSet
        public final ImmutableList q() {
            return new ImmutableList<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public final Object get(int i2) {
                    EntrySet entrySet = EntrySet.this;
                    Preconditions.i(i2, entrySet.f43020g);
                    int i3 = i2 * 2;
                    int i4 = entrySet.f43019f;
                    Object[] objArr = entrySet.f43018e;
                    Object obj = objArr[i3 + i4];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArr[i3 + (i4 ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public final boolean j() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public final int size() {
                    return EntrySet.this.f43020g;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f43020g;
        }
    }

    /* loaded from: classes4.dex */
    public static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: d, reason: collision with root package name */
        public final transient ImmutableMap f43022d;

        /* renamed from: e, reason: collision with root package name */
        public final transient ImmutableList f43023e;

        public KeySet(ImmutableMap immutableMap, ImmutableList immutableList) {
            this.f43022d = immutableMap;
            this.f43023e = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public final ImmutableList b() {
            return this.f43023e;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return this.f43022d.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int d(int i2, Object[] objArr) {
            return this.f43023e.d(i2, objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            return this.f43023e.listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f43022d.size();
        }
    }

    /* loaded from: classes4.dex */
    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: c, reason: collision with root package name */
        public final transient Object[] f43024c;

        /* renamed from: d, reason: collision with root package name */
        public final transient int f43025d;

        /* renamed from: e, reason: collision with root package name */
        public final transient int f43026e;

        public KeysOrValuesAsList(Object[] objArr, int i2, int i3) {
            this.f43024c = objArr;
            this.f43025d = i2;
            this.f43026e = i3;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, this.f43026e);
            Object obj = this.f43024c[(i2 * 2) + this.f43025d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43026e;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i2) {
        this.f43014d = obj;
        this.f43015e = objArr;
        this.f43016f = i2;
    }

    public static RegularImmutableMap o(int i2, Object[] objArr, ImmutableMap.Builder builder) {
        if (i2 == 0) {
            return (RegularImmutableMap) f43013g;
        }
        if (i2 == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        Preconditions.k(i2, objArr.length >> 1);
        Object objP = p(objArr, i2, ImmutableSet.m(i2), 0);
        if (objP instanceof Object[]) {
            Object[] objArr2 = (Object[]) objP;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder == null) {
                throw duplicateKey.a();
            }
            builder.f42677c = duplicateKey;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objP = obj;
            i2 = iIntValue;
        }
        return new RegularImmutableMap(objP, objArr, i2);
    }

    public static Object p(Object[] objArr, int i2, int i3, int i4) {
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        if (i2 == 1) {
            Objects.requireNonNull(objArr[i4]);
            Objects.requireNonNull(objArr[i4 ^ 1]);
            return null;
        }
        int i5 = i3 - 1;
        int i6 = 0;
        if (i3 <= 128) {
            byte[] bArr = new byte[i3];
            Arrays.fill(bArr, (byte) -1);
            int i7 = 0;
            while (i6 < i2) {
                int i8 = (i6 * 2) + i4;
                int i9 = (i7 * 2) + i4;
                Object obj = objArr[i8];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i8 ^ 1];
                Objects.requireNonNull(obj2);
                int iB = Hashing.b(obj.hashCode());
                while (true) {
                    int i10 = iB & i5;
                    int i11 = bArr[i10] & 255;
                    if (i11 == 255) {
                        bArr[i10] = (byte) i9;
                        if (i7 < i6) {
                            objArr[i9] = obj;
                            objArr[i9 ^ 1] = obj2;
                        }
                        i7++;
                    } else {
                        if (obj.equals(objArr[i11])) {
                            int i12 = i11 ^ 1;
                            Object obj3 = objArr[i12];
                            Objects.requireNonNull(obj3);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj, obj2, obj3);
                            objArr[i12] = obj2;
                            break;
                        }
                        iB = i10 + 1;
                    }
                }
                i6++;
            }
            return i7 == i2 ? bArr : new Object[]{bArr, Integer.valueOf(i7), duplicateKey};
        }
        if (i3 <= 32768) {
            short[] sArr = new short[i3];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            while (i6 < i2) {
                int i14 = (i6 * 2) + i4;
                int i15 = (i13 * 2) + i4;
                Object obj4 = objArr[i14];
                Objects.requireNonNull(obj4);
                Object obj5 = objArr[i14 ^ 1];
                Objects.requireNonNull(obj5);
                int iB2 = Hashing.b(obj4.hashCode());
                while (true) {
                    int i16 = iB2 & i5;
                    int i17 = sArr[i16] & 65535;
                    if (i17 == 65535) {
                        sArr[i16] = (short) i15;
                        if (i13 < i6) {
                            objArr[i15] = obj4;
                            objArr[i15 ^ 1] = obj5;
                        }
                        i13++;
                    } else {
                        if (obj4.equals(objArr[i17])) {
                            int i18 = i17 ^ 1;
                            Object obj6 = objArr[i18];
                            Objects.requireNonNull(obj6);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj4, obj5, obj6);
                            objArr[i18] = obj5;
                            break;
                        }
                        iB2 = i16 + 1;
                    }
                }
                i6++;
            }
            return i13 == i2 ? sArr : new Object[]{sArr, Integer.valueOf(i13), duplicateKey};
        }
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        int i19 = 0;
        while (i6 < i2) {
            int i20 = (i6 * 2) + i4;
            int i21 = (i19 * 2) + i4;
            Object obj7 = objArr[i20];
            Objects.requireNonNull(obj7);
            Object obj8 = objArr[i20 ^ 1];
            Objects.requireNonNull(obj8);
            int iB3 = Hashing.b(obj7.hashCode());
            while (true) {
                int i22 = iB3 & i5;
                int i23 = iArr[i22];
                if (i23 == -1) {
                    iArr[i22] = i21;
                    if (i19 < i6) {
                        objArr[i21] = obj7;
                        objArr[i21 ^ 1] = obj8;
                    }
                    i19++;
                } else {
                    if (obj7.equals(objArr[i23])) {
                        int i24 = i23 ^ 1;
                        Object obj9 = objArr[i24];
                        Objects.requireNonNull(obj9);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj7, obj8, obj9);
                        objArr[i24] = obj8;
                        break;
                    }
                    iB3 = i22 + 1;
                }
            }
            i6++;
        }
        return i19 == i2 ? iArr : new Object[]{iArr, Integer.valueOf(i19), duplicateKey};
    }

    public static Object q(Object obj, Object[] objArr, int i2, int i3, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i2 == 1) {
            Object obj3 = objArr[i3];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i3 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = Hashing.b(obj2.hashCode());
            while (true) {
                int i4 = iB & length;
                int i5 = bArr[i4] & 255;
                if (i5 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i5])) {
                    return objArr[i5 ^ 1];
                }
                iB = i4 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = Hashing.b(obj2.hashCode());
            while (true) {
                int i6 = iB2 & length2;
                int i7 = sArr[i6] & 65535;
                if (i7 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i7])) {
                    return objArr[i7 ^ 1];
                }
                iB2 = i6 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = Hashing.b(obj2.hashCode());
            while (true) {
                int i8 = iB3 & length3;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i9])) {
                    return objArr[i9 ^ 1];
                }
                iB3 = i8 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet b() {
        return new EntrySet(this, this.f43015e, 0, this.f43016f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet c() {
        return new KeySet(this, new KeysOrValuesAsList(this.f43015e, 0, this.f43016f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableCollection d() {
        return new KeysOrValuesAsList(this.f43015e, 1, this.f43016f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object objQ = q(this.f43014d, this.f43015e, this.f43016f, 0, obj);
        if (objQ == null) {
            return null;
        }
        return objQ;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f43016f;
    }
}
