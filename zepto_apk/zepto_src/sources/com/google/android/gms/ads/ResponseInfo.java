package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class ResponseInfo {

    /* renamed from: a, reason: collision with root package name */
    public final zzea f21027a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f21028b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final AdapterResponseInfo f21029c;

    public ResponseInfo(zzea zzeaVar) {
        this.f21027a = zzeaVar;
        if (zzeaVar != null) {
            try {
                List<zzv> listZzg = zzeaVar.zzg();
                if (listZzg != null) {
                    for (zzv zzvVar : listZzg) {
                        AdapterResponseInfo adapterResponseInfo = zzvVar != null ? new AdapterResponseInfo(zzvVar) : null;
                        if (adapterResponseInfo != null) {
                            this.f21028b.add(adapterResponseInfo);
                        }
                    }
                }
            } catch (RemoteException e2) {
                zzo.d("Could not forward getAdapterResponseInfo to ResponseInfo.", e2);
            }
        }
        zzea zzeaVar2 = this.f21027a;
        if (zzeaVar2 == null) {
            return;
        }
        try {
            zzv zzvVarZzh = zzeaVar2.zzh();
            if (zzvVarZzh != null) {
                this.f21029c = new AdapterResponseInfo(zzvVarZzh);
            }
        } catch (RemoteException e3) {
            zzo.d("Could not forward getLoadedAdapterResponse to ResponseInfo.", e3);
        }
    }

    public final AdapterResponseInfo a() {
        return this.f21029c;
    }

    public final Bundle b() {
        try {
            zzea zzeaVar = this.f21027a;
            if (zzeaVar != null) {
                return zzeaVar.zzi();
            }
        } catch (RemoteException e2) {
            zzo.d("Could not forward getResponseExtras to ResponseInfo.", e2);
        }
        return new Bundle();
    }

    public final String c() {
        try {
            zzea zzeaVar = this.f21027a;
            if (zzeaVar != null) {
                return zzeaVar.zzf();
            }
            return null;
        } catch (RemoteException e2) {
            zzo.d("Could not forward getResponseId to ResponseInfo.", e2);
            return null;
        }
    }

    public final JSONObject d() throws JSONException {
        zzea zzeaVar;
        JSONObject jSONObject = new JSONObject();
        String strC = c();
        if (strC == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", strC);
        }
        try {
            zzeaVar = this.f21027a;
        } catch (RemoteException e2) {
            zzo.d("Could not forward getMediationAdapterClassName to ResponseInfo.", e2);
        }
        String strZze = zzeaVar != null ? zzeaVar.zze() : null;
        if (strZze == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", strZze);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f21028b.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AdapterResponseInfo) it.next()).c());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.f21029c;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.c());
        }
        Bundle bundleB = b();
        if (bundleB != null) {
            jSONObject.put("Response Extras", zzbb.f21141g.f21142a.m(bundleB));
        }
        return jSONObject;
    }

    public final String toString() {
        try {
            return d().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
