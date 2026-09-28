package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f42590g = 0;

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: A */
    public final ImmutableSortedSet headSet(Object obj) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return C(comparable, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: B */
    public final ImmutableSortedSet headSet(Object obj, boolean z) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return C(comparable, z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: E */
    public final ImmutableSortedSet subSet(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        Preconditions.f(this.f42738d.compare(comparable, comparable2) <= 0);
        return G(comparable, true, comparable2, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: F */
    public final ImmutableSortedSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        Preconditions.f(this.f42738d.compare(comparable, comparable2) <= 0);
        return G(comparable, z, comparable2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: H */
    public final ImmutableSortedSet tailSet(Object obj) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return J(comparable, true);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: I */
    public final ImmutableSortedSet tailSet(Object obj, boolean z) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return J(comparable, z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: K */
    public abstract ContiguousSet C(Comparable comparable, boolean z);

    public abstract Range L();

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: M */
    public abstract ContiguousSet G(Comparable comparable, boolean z, Comparable comparable2, boolean z2);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: N */
    public abstract ContiguousSet J(Comparable comparable, boolean z);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return C(comparable, z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        Preconditions.f(this.f42738d.compare(comparable, comparable2) <= 0);
        return G(comparable, z, comparable2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return J(comparable, z);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return L().toString();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet v() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return C(comparable, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        Comparable comparable = (Comparable) obj;
        comparable.getClass();
        return J(comparable, true);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        Preconditions.f(this.f42738d.compare(comparable, comparable2) <= 0);
        return G(comparable, true, comparable2, false);
    }
}
