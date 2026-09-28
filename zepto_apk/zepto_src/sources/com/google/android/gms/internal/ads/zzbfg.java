package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public final class zzbfg {
    public static final Future a(Context context, zzbev zzbevVar) {
        zzbff zzbffVar = new zzbff(context);
        zzbez zzbezVar = new zzbez(zzbffVar);
        zzbfd zzbfdVar = new zzbfd(zzbffVar, zzbevVar, zzbezVar);
        zzbfe zzbfeVar = new zzbfe(zzbffVar, zzbezVar);
        synchronized (zzbffVar.f24883c) {
            zzbeu zzbeuVar = new zzbeu(context, com.google.android.gms.ads.internal.zzt.C.t.a(), zzbfdVar, zzbfeVar);
            zzbffVar.f24881a = zzbeuVar;
            zzbeuVar.checkAvailabilityAndConnect();
        }
        return zzbezVar;
    }
}
