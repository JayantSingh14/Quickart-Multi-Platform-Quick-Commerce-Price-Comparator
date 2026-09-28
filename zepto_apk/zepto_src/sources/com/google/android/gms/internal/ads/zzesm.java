package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzesm implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Set f30240a;

    public zzesm(Set set) {
        this.f30240a = set;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f30240a.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzgym.a(new zzesl(arrayList));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 8;
    }
}
