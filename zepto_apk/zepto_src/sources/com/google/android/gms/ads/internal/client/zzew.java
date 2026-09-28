package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbps;
import com.google.android.gms.internal.ads.zzbpv;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzew extends zzbps {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzex f21212a;

    public /* synthetic */ zzew(zzex zzexVar) {
        Objects.requireNonNull(zzexVar);
        this.f21212a = zzexVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void r5(List list) {
        int i2;
        ArrayList arrayList;
        zzex zzexVar = this.f21212a;
        synchronized (zzexVar.f21217d) {
            zzexVar.f21219f = false;
            zzexVar.f21220g = true;
            arrayList = new ArrayList(zzexVar.f21218e);
            zzexVar.f21218e.clear();
        }
        zzbpv zzbpvVarA = zzex.a(list);
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((OnInitializationCompleteListener) arrayList.get(i2)).a(zzbpvVarA);
        }
    }
}
