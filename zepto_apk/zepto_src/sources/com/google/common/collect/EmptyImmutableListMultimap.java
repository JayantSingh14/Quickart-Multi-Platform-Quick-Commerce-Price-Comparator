package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {

    /* renamed from: g, reason: collision with root package name */
    public static final EmptyImmutableListMultimap f42604g = new EmptyImmutableListMultimap(RegularImmutableMap.f43013g, 0);

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Map asMap() {
        return this.f42686e;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: h */
    public final ImmutableMap asMap() {
        return this.f42686e;
    }
}
