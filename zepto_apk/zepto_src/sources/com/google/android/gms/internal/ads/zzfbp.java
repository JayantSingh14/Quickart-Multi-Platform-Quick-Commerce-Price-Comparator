package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzfbp implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f30816a;

    public zzfbp(Context context) {
        this.f30816a = zzbyw.b(context, VersionInfoParcel.b());
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.cd)).booleanValue() ? zzgym.a(zzfbn.f30814a) : zzgym.a(new zzezv() { // from class: com.google.android.gms.internal.ads.zzfbo
            @Override // com.google.android.gms.internal.ads.zzezv
            public final /* synthetic */ void zza(Object obj) throws JSONException {
                JSONObject jSONObject = (JSONObject) obj;
                zzfbp zzfbpVar = this.f30815a;
                zzfbpVar.getClass();
                try {
                    jSONObject.put("gms_sdk_env", zzfbpVar.f30816a);
                } catch (JSONException unused) {
                    com.google.android.gms.ads.internal.util.zze.k("Failed putting version constants.");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 46;
    }
}
