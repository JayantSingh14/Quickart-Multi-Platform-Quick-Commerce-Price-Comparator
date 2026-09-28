package com.google.android.gms.internal.ads;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class zzbva extends zzbcc implements zzbvb {
    public zzbva() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            zzepn zzepnVar = (zzepn) this;
            synchronized (zzepnVar) {
                if (!zzepnVar.f30045e) {
                    if (string == null) {
                        synchronized (zzepnVar) {
                            zzepnVar.Xb(2, "Adapter returned null signals");
                        }
                    } else {
                        try {
                            JSONObject jSONObject = zzepnVar.f30043c;
                            jSONObject.put("signals", string);
                            zzbgb zzbgbVar = zzbgk.W1;
                            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                                jSONObject.put("latency", com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzepnVar.f30044d);
                            }
                            if (((Boolean) zzbdVar.f21153c.a(zzbgk.V1)).booleanValue()) {
                                jSONObject.put("signal_error_code", 0);
                            }
                        } catch (JSONException unused) {
                        }
                        zzepnVar.f30042b.b(zzepnVar.f30043c);
                        zzepnVar.f30045e = true;
                    }
                }
            }
        } else if (i2 == 2) {
            String string2 = parcel.readString();
            zzbcd.f(parcel);
            zzepn zzepnVar2 = (zzepn) this;
            synchronized (zzepnVar2) {
                zzepnVar2.Xb(2, string2);
            }
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            zzepn zzepnVar3 = (zzepn) this;
            synchronized (zzepnVar3) {
                zzepnVar3.Xb(2, zzeVar.f21162b);
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
