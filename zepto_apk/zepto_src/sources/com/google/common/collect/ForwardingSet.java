package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    @Override // com.google.common.collect.ForwardingCollection
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public abstract Set t();

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return obj == this || t().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return t().hashCode();
    }
}
