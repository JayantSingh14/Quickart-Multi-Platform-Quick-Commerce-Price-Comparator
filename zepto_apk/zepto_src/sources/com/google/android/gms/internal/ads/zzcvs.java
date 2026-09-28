package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzcvs implements zzems {

    /* renamed from: a, reason: collision with root package name */
    public final List f27242a;

    public zzcvs(List list) {
        this.f27242a = list;
    }

    @Override // com.google.android.gms.internal.ads.zzems
    public final void zzm() {
        Iterator it = this.f27242a.iterator();
        while (it.hasNext()) {
            zzgym.k((ListenableFuture) it.next(), new zzcvp(), zzgyb.f33369a);
        }
    }

    public zzcvs(zzcvk zzcvkVar) {
        this.f27242a = Collections.singletonList(zzgym.a(zzcvkVar));
    }
}
