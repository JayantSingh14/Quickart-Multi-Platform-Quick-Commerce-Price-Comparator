package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzbmj implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* bridge */ /* synthetic */ void a(Object obj, Map map) {
        JSONObject jSONObjectZzd;
        zzcir zzcirVar = (zzcir) obj;
        zzbjl zzbjlVarE = zzcirVar.E();
        if (zzbjlVarE == null || (jSONObjectZzd = zzbjlVarE.zzd()) == null) {
            zzcirVar.m("nativeClickMetaReady", new JSONObject());
        } else {
            zzcirVar.m("nativeClickMetaReady", jSONObjectZzd);
        }
    }
}
