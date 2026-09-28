package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {

    @DoNotMock
    public static final class Builder<R, C, V> {
        public Builder() {
            new ArrayList();
        }
    }

    public static final class SerializedForm implements Serializable {
    }

    @Override // com.google.common.collect.AbstractTable
    public final Iterator a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable
    public final void b() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable
    public final boolean c(Object obj) {
        Collection collectionE = this.f42522b;
        if (collectionE == null) {
            collectionE = e();
            this.f42522b = collectionE;
        }
        return ((ImmutableCollection) collectionE).contains(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    public final Iterator f() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet d();

    @Override // com.google.common.collect.AbstractTable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableCollection e();

    public Object j(Object obj, Object obj2) {
        Map map = (Map) Maps.h(obj, g());
        if (map == null) {
            return null;
        }
        return Maps.h(obj2, map);
    }

    @Override // com.google.common.collect.Table
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableMap g();

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public final Set n() {
        return (ImmutableSet) super.n();
    }
}
