package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzdo extends zzdj {
    public zzdo(zzdc zzdcVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(zzdcVar, hashSet, jSONObject, j2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzct.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzdk, android.os.AsyncTask
    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzbz zzbzVarZza;
        if (!TextUtils.isEmpty(str) && (zzbzVarZza = zzbz.zza()) != null) {
            for (com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar : zzbzVarZza.zzc()) {
                if (((zzdj) this).zza.contains(zzeVar.zzi())) {
                    zzeVar.zzh().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
