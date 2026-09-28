package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zziiw implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f34861a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziix f34862b;

    public zziiw(zziix zziixVar) {
        this.f34862b = zziixVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f34861a;
        zziix zziixVar = this.f34862b;
        return i2 < zziixVar.f34864a.size() || zziixVar.f34865b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f34861a;
        zziix zziixVar = this.f34862b;
        ArrayList arrayList = zziixVar.f34864a;
        if (i2 >= arrayList.size()) {
            arrayList.add(zziixVar.f34865b.next());
            return next();
        }
        int i3 = this.f34861a;
        this.f34861a = i3 + 1;
        return arrayList.get(i3);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
