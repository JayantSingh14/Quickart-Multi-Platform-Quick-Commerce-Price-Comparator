package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    @Override // com.google.common.collect.ImmutableAsList
    public final ImmutableCollection A() {
        return null;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] f() {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int g() {
        throw null;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int i() {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ListIterator listIterator(int i2) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableList
    /* renamed from: q */
    public final UnmodifiableListIterator listIterator(int i2) {
        throw null;
    }
}
