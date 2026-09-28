package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzesp implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30243a;

    /* renamed from: b, reason: collision with root package name */
    public final zzduu f30244b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdzp f30245c;

    /* renamed from: d, reason: collision with root package name */
    public final zzesr f30246d;

    public zzesp(zzgyw zzgywVar, zzduu zzduuVar, zzdzp zzdzpVar, zzesr zzesrVar) {
        this.f30243a = zzgywVar;
        this.f30244b = zzduuVar;
        this.f30245c = zzdzpVar;
        this.f30246d = zzesrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzesq zzesqVar;
        zzbgb zzbgbVar = zzbgk.Lc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzesr zzesrVar = this.f30246d;
        if (zBooleanValue && (zzesqVar = zzesrVar.f30249b) != null) {
            return zzgym.a(zzesqVar);
        }
        zzbgb zzbgbVar2 = zzbgk.M1;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (zzgpz.a((String) zzbgiVar.a(zzbgbVar2)) || (!((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue() && (zzesrVar.f30248a.get() || !this.f30245c.f28847b))) {
            return zzgym.a(new zzesq(new Bundle()));
        }
        zzesrVar.f30248a.set(true);
        return ((zzgxi) this.f30243a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeso
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzfir {
                zzesp zzespVar = this.f30242a;
                zzespVar.getClass();
                List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.M1)).split(";"));
                Bundle bundle = new Bundle();
                for (String str : listAsList) {
                    try {
                        zzfji zzfjiVarA = zzespVar.f30244b.a(str, new JSONObject());
                        zzfjiVarA.a();
                        boolean z = zzespVar.f30245c.f28847b;
                        Bundle bundle2 = new Bundle();
                        boolean zBooleanValue2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Lc)).booleanValue();
                        zzbtc zzbtcVar = zzfjiVarA.f31270a;
                        if (!zBooleanValue2 || z) {
                            try {
                                zzbvn zzbvnVarU = zzbtcVar.U();
                                if (zzbvnVarU != null) {
                                    try {
                                        bundle2.putString("sdk_version", zzbvnVarU.toString());
                                    } catch (zzfir unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                throw new zzfir(th);
                            }
                        }
                        try {
                            zzbvn zzbvnVarM = zzbtcVar.m();
                            if (zzbvnVarM != null) {
                                try {
                                    bundle2.putString("adapter_version", zzbvnVarM.toString());
                                } catch (zzfir unused2) {
                                }
                            }
                            bundle.putBundle(str, bundle2);
                        } catch (Throwable th2) {
                            throw new zzfir(th2);
                        }
                    } catch (zzfir unused3) {
                    }
                }
                zzesq zzesqVar2 = new zzesq(bundle);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Lc)).booleanValue()) {
                    zzespVar.f30246d.f30249b = zzesqVar2;
                }
                return zzesqVar2;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 1;
    }
}
