package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzevc implements zzijg {
    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        List arrayList = new ArrayList();
        zzbgb zzbgbVar = zzbgk.Rc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((String) zzbdVar.f21153c.a(zzbgbVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) zzbdVar.f21153c.a(zzbgbVar)).split(","));
        }
        zzijo.a(arrayList);
        return arrayList;
    }
}
