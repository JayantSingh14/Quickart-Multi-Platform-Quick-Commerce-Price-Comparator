package org.shadow.apache.commons.lang3.tuple;

/* loaded from: classes5.dex */
public class MutablePair<L, R> extends Pair<L, R> {

    /* renamed from: a, reason: collision with root package name */
    public Object f57869a;

    @Override // org.shadow.apache.commons.lang3.tuple.Pair
    public final Object a() {
        return null;
    }

    @Override // org.shadow.apache.commons.lang3.tuple.Pair
    public final Object b() {
        return this.f57869a;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f57869a;
        this.f57869a = obj;
        return obj2;
    }
}
