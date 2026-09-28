package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Collection;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements Function, Maps.EntryTransformer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f43172a;

    public /* synthetic */ f(Object obj) {
        this.f43172a = obj;
    }

    @Override // com.google.common.collect.Maps.EntryTransformer
    public Object a(Object obj, Object obj2) {
        return ((Multimaps.TransformedEntriesMultimap) this.f43172a).h(obj, (Collection) obj2);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return Multimaps.AsMap.this.f42948d.l(obj);
    }
}
