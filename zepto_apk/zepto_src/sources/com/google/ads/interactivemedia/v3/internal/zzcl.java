package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzcl implements zzcj {
    private final zzcj zza;

    public zzcl(zzcj zzcjVar) {
        this.zza = zzcjVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzcj
    public final JSONObject zza(View view) throws JSONException {
        JSONObject jSONObjectZza = zzct.zza(0, 0, 0, 0);
        int iZzb = zzcw.zzb();
        int i2 = iZzb - 1;
        if (iZzb == 0) {
            throw null;
        }
        try {
            jSONObjectZza.put("noOutputDevice", i2 == 0);
            return jSONObjectZza;
        } catch (JSONException e2) {
            zzcu.zza("Error with setting output device status", e2);
            return jSONObjectZza;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzcj
    public final void zzb(View view, JSONObject jSONObject, zzci zzciVar, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        zzbz zzbzVarZza = zzbz.zza();
        if (zzbzVarZza != null) {
            Collection collectionZzb = zzbzVarZza.zzb();
            int size = collectionZzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = collectionZzb.iterator();
            while (it.hasNext()) {
                View viewZzg = ((com.google.ads.interactivemedia.omid.library.adsession.zze) it.next()).zzg();
                if (viewZzg != null && viewZzg.isAttachedToWindow() && viewZzg.isShown()) {
                    View view2 = viewZzg;
                    while (true) {
                        if (view2 == null) {
                            View rootView = viewZzg.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float fZza = zzcz.zza(rootView);
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i2 = size2 - 1;
                                    if (zzcz.zza((View) arrayList.get(i2)) <= fZza) {
                                        break;
                                    } else {
                                        size2 = i2;
                                    }
                                }
                                arrayList.add(size2, rootView);
                            }
                        } else if (view2.getAlpha() != 0.0f) {
                            Object parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzciVar.zza((View) arrayList.get(i3), this.zza, jSONObject, z2);
        }
    }
}
