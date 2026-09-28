package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzdn extends zzdj {
    public zzdn(zzdc zzdcVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(zzdcVar, hashSet, jSONObject, j2);
    }

    private final void zzc(String str) {
        zzbz zzbzVarZza = zzbz.zza();
        if (zzbzVarZza != null) {
            for (com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar : zzbzVarZza.zzc()) {
                if (((zzdj) this).zza.contains(zzeVar.zzi())) {
                    zzeVar.zzh().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzdk, android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzdk
    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
