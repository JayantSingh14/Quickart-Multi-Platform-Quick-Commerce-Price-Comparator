package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.EndpointPair;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {

    /* renamed from: c, reason: collision with root package name */
    public final BaseGraph f43191c;

    /* renamed from: d, reason: collision with root package name */
    public final Iterator f43192d;

    /* renamed from: e, reason: collision with root package name */
    public Object f43193e = null;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f43194f = ImmutableSet.s().iterator();

    public static final class Directed<N> extends EndpointPairIterator<N> {
        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            while (!this.f43194f.hasNext()) {
                if (!c()) {
                    b();
                    return null;
                }
            }
            Object obj = this.f43193e;
            Objects.requireNonNull(obj);
            return new EndpointPair.Ordered(obj, this.f43194f.next());
        }
    }

    public static final class Undirected<N> extends EndpointPairIterator<N> {

        /* renamed from: g, reason: collision with root package name */
        public HashSet f43195g;

        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            do {
                Objects.requireNonNull(this.f43195g);
                while (this.f43194f.hasNext()) {
                    Object next = this.f43194f.next();
                    if (!this.f43195g.contains(next)) {
                        Object obj = this.f43193e;
                        Objects.requireNonNull(obj);
                        return new EndpointPair.Unordered(next, obj);
                    }
                }
                this.f43195g.add(this.f43193e);
            } while (c());
            this.f43195g = null;
            b();
            return null;
        }
    }

    public EndpointPairIterator(BaseGraph baseGraph) {
        this.f43191c = baseGraph;
        this.f43192d = baseGraph.d().iterator();
    }

    public final boolean c() {
        Preconditions.n(!this.f43194f.hasNext());
        Iterator it = this.f43192d;
        if (!it.hasNext()) {
            return false;
        }
        Object next = it.next();
        this.f43193e = next;
        this.f43194f = this.f43191c.k(next).iterator();
        return true;
    }
}
