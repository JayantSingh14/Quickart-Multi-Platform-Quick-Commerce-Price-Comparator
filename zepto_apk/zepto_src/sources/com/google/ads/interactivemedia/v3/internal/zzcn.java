package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import in.juspay.airborne.ota.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class zzcn {
    private final String zza;
    private zzdq zzb;
    private long zzc;
    private int zzd;

    public zzcn(String str) {
        zzb();
        this.zza = str;
        this.zzb = new zzdq(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j2) {
        if (j2 < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzcg.zza().zzg(zza(), this.zza, str);
    }

    public final void zze() {
        zzcg.zza().zzc(zza(), this.zza);
    }

    public final void zzf(com.google.ads.interactivemedia.omid.library.adsession.zzb zzbVar) {
        zzcg.zza().zzd(zza(), this.zza, zzbVar.zzb());
    }

    public final void zzg(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzct.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzcg.zza().zzf(zza(), jSONObject);
    }

    public final void zzh(String str, long j2) {
        if (j2 >= this.zzc) {
            this.zzd = 2;
            zzcg.zza().zzg(zza(), this.zza, str);
        }
    }

    public void zzi(com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar, com.google.ads.interactivemedia.omid.library.adsession.zzc zzcVar) {
        zzj(zzeVar, zzcVar, null);
    }

    public final void zzj(com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar, com.google.ads.interactivemedia.omid.library.adsession.zzc zzcVar, JSONObject jSONObject) throws JSONException {
        String strZzi = zzeVar.zzi();
        JSONObject jSONObject2 = new JSONObject();
        zzct.zze(jSONObject2, PaymentConstants.ENV, Constants.APP_DIR);
        zzct.zze(jSONObject2, "adSessionType", zzcVar.zzc());
        JSONObject jSONObject3 = new JSONObject();
        zzct.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzct.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzct.zze(jSONObject3, "os", "Android");
        zzct.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzct.zze(jSONObject2, "deviceCategory", zzcs.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzct.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzct.zze(jSONObject4, "partnerName", zzcVar.zzd().zzb());
        zzct.zze(jSONObject4, "partnerVersion", zzcVar.zzd().zzc());
        zzct.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzct.zze(jSONObject5, "libraryVersion", "1.4.10-google_20240110");
        zzct.zze(jSONObject5, CLConstants.SALT_FIELD_APP_ID, zzce.zzb().zza().getApplicationContext().getPackageName());
        zzct.zze(jSONObject2, Constants.APP_DIR, jSONObject5);
        if (zzcVar.zze() != null) {
            zzct.zze(jSONObject2, "contentUrl", zzcVar.zze());
        }
        zzct.zze(jSONObject2, "customReferenceData", zzcVar.zzf());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzcVar.zzg().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzcg.zza().zzi(zza(), strZzi, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzk(boolean z) {
        if (this.zzb.get() != 0) {
            zzcg.zza().zzh(zza(), this.zza, true != z ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzl(float f2) {
        zzcg.zza().zze(zza(), this.zza, f2);
    }

    public final void zzm(WebView webView) {
        this.zzb = new zzdq(webView);
    }

    public void zzn() {
    }
}
