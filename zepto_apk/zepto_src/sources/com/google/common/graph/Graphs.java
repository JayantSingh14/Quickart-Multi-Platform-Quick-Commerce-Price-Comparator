package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Iterator;
import java.util.Set;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Graphs {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class NodeVisitState {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NodeVisitState[] f43197a = {new NodeVisitState("PENDING", 0), new NodeVisitState("COMPLETE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        NodeVisitState EF5;

        public static NodeVisitState valueOf(String str) {
            return (NodeVisitState) Enum.valueOf(NodeVisitState.class, str);
        }

        public static NodeVisitState[] values() {
            return (NodeVisitState[]) f43197a.clone();
        }
    }

    public static class TransposedGraph<N> extends ForwardingGraph<N> {

        /* renamed from: com.google.common.graph.Graphs$TransposedGraph$1, reason: invalid class name */
        class AnonymousClass1 extends IncidentEdgeSet<Object> {
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                throw null;
            }
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int e() {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph
        public final Set g(Object obj) {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int i() {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph
        public final Set k(Object obj) {
            throw null;
        }
    }

    public static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public final EndpointPair j(Object obj) {
            throw null;
        }
    }

    public static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int e() {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph
        public final Set g(Object obj) {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        public final Object h(Object obj, Object obj2) {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public final int i() {
            throw null;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph
        public final Set k(Object obj) {
            throw null;
        }
    }
}
