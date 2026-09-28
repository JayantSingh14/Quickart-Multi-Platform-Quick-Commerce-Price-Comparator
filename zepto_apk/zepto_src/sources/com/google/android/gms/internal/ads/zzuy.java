package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;

/* loaded from: classes4.dex */
final /* synthetic */ class zzuy implements zzvb {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzuy f35677a = new zzuy();

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ int zza(Object obj) {
        HashMap map = zzvc.f35693a;
        String str = ((zzuj) obj).f35645a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
