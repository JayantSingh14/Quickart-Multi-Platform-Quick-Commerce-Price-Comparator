package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfnn {
    public static void a(ListenableFuture listenableFuture, zzfne zzfneVar) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            zzgye zzgyeVarS = zzgye.s(listenableFuture);
            zzfnj zzfnjVar = new zzfnj(zzfneVar);
            zzgyeVarS.q(new zzgyk(zzgyeVarS, zzfnjVar), zzcdo.f25988g);
        }
    }

    public static int b(zzfik zzfikVar) {
        int iE = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.e(zzfikVar) - 1;
        return (iE == 0 || iE == 1) ? 7 : 23;
    }

    public static void c(ListenableFuture listenableFuture, zzfno zzfnoVar, zzfne zzfneVar, boolean z) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            zzgye zzgyeVarS = zzgye.s(listenableFuture);
            zzfnk zzfnkVar = new zzfnk(zzfnoVar, zzfneVar, z);
            zzgyeVarS.q(new zzgyk(zzgyeVarS, zzfnkVar), zzcdo.f25988g);
        }
    }
}
