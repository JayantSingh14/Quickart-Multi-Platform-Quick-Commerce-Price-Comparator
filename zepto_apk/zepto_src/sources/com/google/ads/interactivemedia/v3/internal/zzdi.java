package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzdi implements zzci {
    private static final zzdi zza = new zzdi();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzde();
    private static final Runnable zze = new zzdf();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzdb zzk = new zzdb();
    private final zzck zzj = new zzck();
    private final zzdc zzl = new zzdc(new zzdl());

    public static zzdi zzd() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzdi zzdiVar) throws JSONException {
        zzdi zzdiVar2;
        zzdiVar.zzg = 0;
        zzdiVar.zzi.clear();
        zzdiVar.zzh = false;
        for (com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar : zzbz.zza().zzb()) {
        }
        zzdiVar.zzm = System.nanoTime();
        zzdiVar.zzk.zzi();
        long jNanoTime = System.nanoTime();
        zzcj zzcjVarZza = zzdiVar.zzj.zza();
        if (zzdiVar.zzk.zze().size() > 0) {
            Iterator it = zzdiVar.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject jSONObjectZza = zzcjVarZza.zza(null);
                View viewZza = zzdiVar.zzk.zza(str);
                zzcj zzcjVarZzb = zzdiVar.zzj.zzb();
                String strZzc = zzdiVar.zzk.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzcjVarZzb.zza(viewZza);
                    zzct.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e2) {
                        zzcu.zza("Error with setting not visible reason", e2);
                    }
                    zzct.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzct.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzdiVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        if (zzdiVar.zzk.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzcjVarZza.zza(null);
            zzdiVar2 = zzdiVar;
            zzdiVar2.zzk(null, zzcjVarZza, jSONObjectZza3, 1, false);
            zzct.zzf(jSONObjectZza3);
            zzdiVar2.zzl.zzd(jSONObjectZza3, zzdiVar2.zzk.zzf(), jNanoTime);
        } else {
            zzdiVar2 = zzdiVar;
            zzdiVar2.zzl.zzb();
        }
        zzdiVar2.zzk.zzg();
        long jNanoTime2 = System.nanoTime() - zzdiVar2.zzm;
        if (zzdiVar2.zzf.size() > 0) {
            for (zzdh zzdhVar : zzdiVar2.zzf) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzdhVar.zzb();
                if (zzdhVar instanceof zzdg) {
                    ((zzdg) zzdhVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzcj zzcjVar, JSONObject jSONObject, int i2, boolean z) {
        zzcjVar.zzb(view, jSONObject, this, i2 == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzci
    public final void zza(View view, zzcj zzcjVar, JSONObject jSONObject, boolean z) throws JSONException {
        int iZzk;
        boolean z2;
        zzdi zzdiVar;
        View view2;
        zzcj zzcjVar2;
        boolean z3;
        if (zzcz.zzb(view) != null || (iZzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzcjVar.zza(view);
        zzct.zzc(jSONObject, jSONObjectZza);
        String strZzd = this.zzk.zzd(view);
        if (strZzd != null) {
            zzct.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e2) {
                zzcu.zza("Error with setting has window focus", e2);
            }
            this.zzk.zzh();
            zzdiVar = this;
        } else {
            zzda zzdaVarZzb = this.zzk.zzb(view);
            if (zzdaVarZzb != null) {
                zzcc zzccVarZza = zzdaVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzdaVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put((String) arrayListZzb.get(i2));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzccVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzccVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzccVarZza.zzc());
                } catch (JSONException e3) {
                    zzcu.zza("Error with setting friendly obstruction", e3);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                zzdiVar = this;
                view2 = view;
                zzcjVar2 = zzcjVar;
                z3 = true;
            } else {
                view2 = view;
                zzcjVar2 = zzcjVar;
                z3 = false;
                zzdiVar = this;
            }
            zzdiVar.zzk(view2, zzcjVar2, jSONObjectZza, iZzk, z3);
        }
        zzdiVar.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzdd(this));
    }
}
