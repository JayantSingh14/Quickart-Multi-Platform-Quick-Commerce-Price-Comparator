package com.google.common.graph;

import androidx.media3.exoplayer.analytics.l;
import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;
import com.google.common.graph.AbstractBaseGraph;
import java.util.AbstractMap;
import java.util.Set;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {

    /* renamed from: com.google.common.graph.AbstractValueGraph$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractGraph<Object> {
        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.Graph
        public final Set a() {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final boolean b() {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final boolean c() {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final Set d() {
            throw null;
        }

        @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int e() {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final Set g(Object obj) {
            throw null;
        }

        @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int i() {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final Set k(Object obj) {
            throw null;
        }

        @Override // com.google.common.graph.BaseGraph
        public final Set l(Object obj) {
            throw null;
        }

        @Override // com.google.common.graph.AbstractBaseGraph
        public final int m(Object obj) {
            throw null;
        }
    }

    @Override // com.google.common.graph.ValueGraph
    public final Set a() {
        return new AbstractBaseGraph.AnonymousClass1();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        if (b() == valueGraph.b() && d().equals(valueGraph.d())) {
            return ((AbstractMap) Maps.b(a(), new l(this, 13))).equals(Maps.b(valueGraph.a(), new l(valueGraph, 13)));
        }
        return false;
    }

    public final int hashCode() {
        return ((AbstractMap) Maps.b(a(), new l(this, 13))).hashCode();
    }

    public final String toString() {
        return "isDirected: " + b() + ", allowsSelfLoops: " + c() + ", nodes: " + d() + ", edges: " + Maps.b(a(), new l(this, 13));
    }
}
