package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f43032i;

    /* renamed from: j, reason: collision with root package name */
    public static final RegularImmutableSet f43033j;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f43034d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f43035e;

    /* renamed from: f, reason: collision with root package name */
    public final transient Object[] f43036f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f43037g;

    /* renamed from: h, reason: collision with root package name */
    public final transient int f43038h;

    static {
        Object[] objArr = new Object[0];
        f43032i = objArr;
        f43033j = new RegularImmutableSet(objArr, 0, objArr, 0, 0);
    }

    public RegularImmutableSet(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f43034d = objArr;
        this.f43035e = i2;
        this.f43036f = objArr2;
        this.f43037g = i3;
        this.f43038h = i4;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f43036f;
            if (objArr.length != 0) {
                int iC = Hashing.c(obj);
                while (true) {
                    int i2 = iC & this.f43037g;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iC = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        Object[] objArr2 = this.f43034d;
        int i3 = this.f43038h;
        System.arraycopy(objArr2, 0, objArr, i2, i3);
        return i2 + i3;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] f() {
        return this.f43034d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int g() {
        return this.f43038h;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f43035e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int i() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return b().listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList q() {
        return ImmutableList.m(this.f43038h, this.f43034d);
    }

    @Override // com.google.common.collect.ImmutableSet
    public final boolean r() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f43038h;
    }
}
