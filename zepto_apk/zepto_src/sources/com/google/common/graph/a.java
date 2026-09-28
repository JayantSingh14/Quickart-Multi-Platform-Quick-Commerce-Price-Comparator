package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.EndpointPair;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43200a;

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f43200a) {
            case 0:
                int i2 = AbstractBaseGraph.AnonymousClass2.f43184a;
                return new EndpointPair.Ordered(obj, null);
            case 1:
                int i3 = AbstractBaseGraph.AnonymousClass2.f43184a;
                new EndpointPair.Ordered(null, obj);
                throw null;
            default:
                int i4 = AbstractBaseGraph.AnonymousClass2.f43184a;
                return new EndpointPair.Unordered(obj, null);
        }
    }
}
