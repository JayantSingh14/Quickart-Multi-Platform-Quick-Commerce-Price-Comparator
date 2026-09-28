package com.google.common.graph;

import android.support.v4.media.b;
import com.google.common.annotations.Beta;
import com.google.common.collect.Iterators;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.Iterator;

@Immutable
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class EndpointPair<N> implements Iterable<N> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f43189a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f43190b;

    public static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public final boolean b() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair
        public final Object d() {
            return this.f43189a;
        }

        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (true != endpointPair.b()) {
                    return false;
                }
                if (!this.f43189a.equals(endpointPair.d())) {
                    return false;
                }
                if (!this.f43190b.equals(endpointPair.f())) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.graph.EndpointPair
        public final Object f() {
            return this.f43190b;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f43189a, this.f43190b});
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public final Iterator iterator() {
            return Iterators.h(this.f43189a, this.f43190b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f43189a);
            sb.append(" -> ");
            return b.q(sb, this.f43190b, ">");
        }
    }

    public static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public final boolean b() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public final Object d() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (endpointPair.b()) {
                return false;
            }
            Object obj2 = this.f43189a;
            Object obj3 = endpointPair.f43189a;
            boolean zEquals = obj2.equals(obj3);
            Object obj4 = this.f43190b;
            Object obj5 = endpointPair.f43190b;
            return zEquals ? obj4.equals(obj5) : obj2.equals(obj5) && obj4.equals(obj3);
        }

        @Override // com.google.common.graph.EndpointPair
        public final Object f() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public final int hashCode() {
            return this.f43190b.hashCode() + this.f43189a.hashCode();
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public final Iterator iterator() {
            return Iterators.h(this.f43189a, this.f43190b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.f43189a);
            sb.append(", ");
            return b.q(sb, this.f43190b, "]");
        }
    }

    public EndpointPair(Object obj, Object obj2) {
        obj.getClass();
        this.f43189a = obj;
        obj2.getClass();
        this.f43190b = obj2;
    }

    public abstract boolean b();

    public abstract Object d();

    public abstract Object f();

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Iterators.h(this.f43189a, this.f43190b);
    }
}
