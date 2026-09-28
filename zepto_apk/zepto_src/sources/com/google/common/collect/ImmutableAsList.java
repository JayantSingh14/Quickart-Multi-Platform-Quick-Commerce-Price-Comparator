package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class ImmutableAsList<E> extends ImmutableList<E> {

    @J2ktIncompatible
    @GwtIncompatible
    public static class SerializedForm implements Serializable {
    }

    public abstract ImmutableCollection A();

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return A().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        ((RegularContiguousSet) A()).getClass();
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        ((RegularContiguousSet) A()).getClass();
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return A().size();
    }
}
