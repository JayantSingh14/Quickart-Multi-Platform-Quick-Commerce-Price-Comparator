package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzbmi implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* bridge */ /* synthetic */ void a(Object obj, Map map) {
        JSONObject jSONObjectZzc;
        zzcir zzcirVar = (zzcir) obj;
        zzbjl zzbjlVarE = zzcirVar.E();
        if (zzbjlVarE == null || (jSONObjectZzc = zzbjlVarE.zzc()) == null) {
            zzcirVar.m("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcirVar.m("nativeAdViewSignalsReady", jSONObjectZzc);
        }
    }
}
