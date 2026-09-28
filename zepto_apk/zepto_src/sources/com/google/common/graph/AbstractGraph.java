package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.graph.AbstractBaseGraph;
import java.util.Set;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
    @Override // com.google.common.graph.Graph
    public Set a() {
        return new AbstractBaseGraph.AnonymousClass1();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Graph)) {
            return false;
        }
        Graph graph = (Graph) obj;
        return b() == graph.b() && d().equals(graph.d()) && a().equals(graph.a());
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return "isDirected: " + b() + ", allowsSelfLoops: " + c() + ", nodes: " + d() + ", edges: " + a();
    }
}
