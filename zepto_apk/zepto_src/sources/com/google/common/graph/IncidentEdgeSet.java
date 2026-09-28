package com.google.common.graph;

import java.util.AbstractSet;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        throw null;
    }
}
