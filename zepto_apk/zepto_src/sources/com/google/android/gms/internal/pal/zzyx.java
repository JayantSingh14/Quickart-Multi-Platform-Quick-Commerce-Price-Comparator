package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzyx extends zzyy implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38165a = new ArrayList();

    @Override // com.google.android.gms.internal.pal.zzyy
    public final int b() {
        ArrayList arrayList = this.f38165a;
        if (arrayList.size() == 1) {
            return ((zzyy) arrayList.get(0)).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.pal.zzyy
    public final String d() {
        ArrayList arrayList = this.f38165a;
        if (arrayList.size() == 1) {
            return ((zzyy) arrayList.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzyx) && ((zzyx) obj).f38165a.equals(this.f38165a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f38165a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f38165a.iterator();
    }
}
