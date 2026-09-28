package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes4.dex */
public abstract class zzgsv extends zzgss implements Queue {
    @Override // com.google.android.gms.internal.ads.zzgss
    public /* bridge */ /* synthetic */ Collection d() {
        throw null;
    }

    @Override // java.util.Queue
    public final Object element() {
        return g().element();
    }

    public abstract LinkedList g();

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        return g().offer(obj);
    }

    @Override // java.util.Queue
    public final Object peek() {
        return g().peek();
    }

    @Override // java.util.Queue
    public final Object poll() {
        return g().poll();
    }

    @Override // java.util.Queue
    public final Object remove() {
        return g().remove();
    }
}
