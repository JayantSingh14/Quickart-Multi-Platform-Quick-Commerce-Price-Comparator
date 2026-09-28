package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final ImmutableList f43010e = new RegularImmutableList(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f43011c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f43012d;

    public RegularImmutableList(Object[] objArr, int i2) {
        this.f43011c = objArr;
        this.f43012d = i2;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        Object[] objArr2 = this.f43011c;
        int i3 = this.f43012d;
        System.arraycopy(objArr2, 0, objArr, i2, i3);
        return i2 + i3;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] f() {
        return this.f43011c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int g() {
        return this.f43012d;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        Preconditions.i(i2, this.f43012d);
        Object obj = this.f43011c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int i() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f43012d;
    }
}
