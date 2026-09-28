package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzect;
import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzgxu;
import com.google.android.gms.internal.ads.zzgym;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzbh implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f21849a;

    /* renamed from: b, reason: collision with root package name */
    public final zzect f21850b;

    public zzbh(zzgyw zzgywVar, zzect zzectVar) {
        this.f21849a = zzgywVar;
        this.f21850b = zzectVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        final zzbza zzbzaVar = (zzbza) obj;
        return zzgym.h(this.f21850b.a(zzbzaVar), new zzgxu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbg
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj2) {
                zzeeg zzeegVar = (zzeeg) obj2;
                zzbj zzbjVar = new zzbj(new JsonReader(new InputStreamReader(zzeegVar.f29176a)), zzeegVar.f29177b);
                zzbza zzbzaVar2 = zzbzaVar;
                try {
                    zzbjVar.f21853b = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m(zzbzaVar2.f25720a).toString();
                } catch (JSONException unused) {
                    zzbjVar.f21853b = "{}";
                }
                Bundle bundle = zzbzaVar2.n;
                if (!bundle.isEmpty()) {
                    try {
                        zzbjVar.f21854c = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m(bundle).toString();
                    } catch (JSONException unused2) {
                    }
                }
                return zzgym.a(zzbjVar);
            }
        }, this.f21849a);
    }
}
