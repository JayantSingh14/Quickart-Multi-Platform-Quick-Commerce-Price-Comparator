package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.graph.EndpointPairIterator;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* renamed from: com.google.common.graph.AbstractBaseGraph$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<EndpointPair<Object>> {
        public AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (obj instanceof EndpointPair) {
                EndpointPair endpointPair = (EndpointPair) obj;
                AbstractBaseGraph abstractBaseGraph = AbstractBaseGraph.this;
                abstractBaseGraph.getClass();
                if (endpointPair.b() == abstractBaseGraph.b()) {
                    Set setD = abstractBaseGraph.d();
                    Object obj2 = endpointPair.f43189a;
                    if (setD.contains(obj2) && abstractBaseGraph.k(obj2).contains(endpointPair.f43190b)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            AbstractBaseGraph abstractBaseGraph = AbstractBaseGraph.this;
            if (abstractBaseGraph.b()) {
                return new EndpointPairIterator.Directed(abstractBaseGraph);
            }
            EndpointPairIterator.Undirected undirected = new EndpointPairIterator.Undirected(abstractBaseGraph);
            undirected.f43195g = new HashSet(Maps.c(abstractBaseGraph.d().size() + 1));
            return undirected;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return Ints.f(AbstractBaseGraph.this.n());
        }
    }

    /* renamed from: com.google.common.graph.AbstractBaseGraph$2, reason: invalid class name */
    class AnonymousClass2 extends IncidentEdgeSet<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f43184a = 0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public int e() {
        return b() ? g(null).size() : m(null);
    }

    @Override // com.google.common.graph.BaseGraph
    public int i() {
        return b() ? k(null).size() : m(null);
    }

    public int m(Object obj) {
        if (b()) {
            return Ints.f(g(obj).size() + k(obj).size());
        }
        return Ints.f(r0.size() + ((c() && l(obj).contains(obj)) ? 1 : 0));
    }

    public long n() {
        long jM = 0;
        while (d().iterator().hasNext()) {
            jM += m(r0.next());
        }
        Preconditions.n((1 & jM) == 0);
        return jM >>> 1;
    }
}
