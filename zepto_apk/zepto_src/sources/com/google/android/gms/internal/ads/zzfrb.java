package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes4.dex */
public final class zzfrb extends zzgsv {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f31696a = new LinkedList();

    @Override // com.google.android.gms.internal.ads.zzgss, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        zzfqm zzfqmVar = (zzfqm) obj;
        int i2 = zzfqmVar.f31651f;
        LinkedList linkedList = this.f31696a;
        if (i2 != 3) {
            linkedList.add(zzfqmVar);
            return true;
        }
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            zzfqm zzfqmVar2 = (zzfqm) listIterator.next();
            if (zzfqmVar2.f31651f == 3) {
                double d2 = zzfqmVar.f31650e;
                double d3 = zzfqmVar2.f31650e;
                if (d3 < d2 || (d3 == d2 && zzfqmVar2.a() > zzfqmVar.a())) {
                    listIterator.set(zzfqmVar);
                    zzfqmVar = zzfqmVar2;
                }
            }
        }
        linkedList.add(zzfqmVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgss, com.google.android.gms.internal.ads.zzgsu
    public final /* synthetic */ Object b() {
        return this.f31696a;
    }

    @Override // com.google.android.gms.internal.ads.zzgsv, com.google.android.gms.internal.ads.zzgss
    public final /* synthetic */ Collection d() {
        return this.f31696a;
    }

    @Override // com.google.android.gms.internal.ads.zzgsv
    public final LinkedList g() {
        return this.f31696a;
    }
}
