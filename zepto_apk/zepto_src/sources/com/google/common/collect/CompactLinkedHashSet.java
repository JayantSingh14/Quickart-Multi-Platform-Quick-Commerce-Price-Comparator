package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* renamed from: f, reason: collision with root package name */
    public transient int[] f42578f;

    /* renamed from: g, reason: collision with root package name */
    public transient int[] f42579g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f42580h;

    /* renamed from: i, reason: collision with root package name */
    public transient int f42581i;

    @Override // com.google.common.collect.CompactHashSet
    public final int b(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (o()) {
            return;
        }
        this.f42580h = -2;
        this.f42581i = -2;
        int[] iArr = this.f42578f;
        if (iArr != null && this.f42579g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f42579g, 0, size(), 0);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public final int d() {
        int iD = super.d();
        this.f42578f = new int[iD];
        this.f42579g = new int[iD];
        return iD;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final LinkedHashSet f() {
        LinkedHashSet linkedHashSetF = super.f();
        this.f42578f = null;
        this.f42579g = null;
        return linkedHashSetF;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final int i() {
        return this.f42580h;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final int j(int i2) {
        Objects.requireNonNull(this.f42579g);
        return r0[i2] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final void k(int i2) {
        super.k(i2);
        this.f42580h = -2;
        this.f42581i = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final void m(Object obj, int i2, int i3, int i4) {
        super.m(obj, i2, i3, i4);
        t(this.f42581i, i2);
        t(i2, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public final void n(int i2, int i3) {
        int size = size() - 1;
        super.n(i2, i3);
        Objects.requireNonNull(this.f42578f);
        t(r4[i2] - 1, j(i2));
        if (i2 < size) {
            Objects.requireNonNull(this.f42578f);
            t(r4[size] - 1, i2);
            t(i2, j(size));
        }
        int[] iArr = this.f42578f;
        Objects.requireNonNull(iArr);
        iArr[size] = 0;
        int[] iArr2 = this.f42579g;
        Objects.requireNonNull(iArr2);
        iArr2[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    public final void r(int i2) {
        super.r(i2);
        int[] iArr = this.f42578f;
        Objects.requireNonNull(iArr);
        this.f42578f = Arrays.copyOf(iArr, i2);
        int[] iArr2 = this.f42579g;
        Objects.requireNonNull(iArr2);
        this.f42579g = Arrays.copyOf(iArr2, i2);
    }

    public final void t(int i2, int i3) {
        if (i2 == -2) {
            this.f42580h = i3;
        } else {
            int[] iArr = this.f42579g;
            Objects.requireNonNull(iArr);
            iArr[i2] = i3 + 1;
        }
        if (i3 == -2) {
            this.f42581i = i2;
            return;
        }
        int[] iArr2 = this.f42578f;
        Objects.requireNonNull(iArr2);
        iArr2[i3] = i2 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = new Object[size()];
        ObjectArrays.b(this, objArr);
        return objArr;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return ObjectArrays.c(this, objArr);
    }
}
