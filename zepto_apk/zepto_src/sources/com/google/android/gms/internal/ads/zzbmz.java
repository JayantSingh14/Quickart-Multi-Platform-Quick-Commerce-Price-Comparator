package com.google.android.gms.internal.ads;

import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzbmz implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* bridge */ /* synthetic */ void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        String str = (String) map.get("action");
        if (CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE.equals(str)) {
            zzcirVar.D0();
        } else if ("resume".equals(str)) {
            zzcirVar.v0();
        }
    }
}
