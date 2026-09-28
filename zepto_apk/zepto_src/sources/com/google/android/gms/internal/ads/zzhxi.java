package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzhxi extends zzhxj implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f34468a = new ArrayList();

    @Override // com.google.android.gms.internal.ads.zzhxj
    public final String b() {
        ArrayList arrayList = this.f34468a;
        int size = arrayList.size();
        if (size == 1) {
            return ((zzhxj) arrayList.get(0)).b();
        }
        throw new IllegalStateException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(size).length() + 37), size, "Array must have size 1, but has size "));
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzhxi) && ((zzhxi) obj).f34468a.equals(this.f34468a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f34468a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f34468a.iterator();
    }
}
