package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzcgq implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f26175a = new ArrayList();

    public final boolean b(zzcfk zzcfkVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f26175a.iterator();
        while (it.hasNext()) {
            zzcgp zzcgpVar = (zzcgp) it.next();
            if (zzcgpVar.f26171b == zzcfkVar) {
                arrayList.add(zzcgpVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzcgp) it2.next()).f26172c.p();
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f26175a.iterator();
    }
}
