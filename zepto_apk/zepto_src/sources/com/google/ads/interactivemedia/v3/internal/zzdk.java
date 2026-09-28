package com.google.ads.interactivemedia.v3.internal;

import android.os.AsyncTask;

/* loaded from: classes3.dex */
public abstract class zzdk extends AsyncTask {
    private zzdl zza;
    protected final zzdc zzd;

    public zzdk(zzdc zzdcVar) {
        this.zzd = zzdcVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzdl zzdlVar = this.zza;
        if (zzdlVar != null) {
            zzdlVar.zza(this);
        }
    }

    public final void zzb(zzdl zzdlVar) {
        this.zza = zzdlVar;
    }
}
