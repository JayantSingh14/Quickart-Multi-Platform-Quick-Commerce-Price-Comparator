package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdsp {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zza f28449b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f28450c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxe f28451d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f28452e;

    /* renamed from: f, reason: collision with root package name */
    public final zzayq f28453f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f28454g;

    /* renamed from: i, reason: collision with root package name */
    public final zzehu f28456i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfpi f28457j;

    /* renamed from: k, reason: collision with root package name */
    public final zzeif f28458k;

    /* renamed from: l, reason: collision with root package name */
    public final zzfio f28459l;

    /* renamed from: m, reason: collision with root package name */
    public ListenableFuture f28460m;

    /* renamed from: a, reason: collision with root package name */
    public final zzdsd f28448a = new zzdsd();

    /* renamed from: h, reason: collision with root package name */
    public final zzboe f28455h = new zzboe();

    public zzdsp(zzdsn zzdsnVar) {
        this.f28450c = zzdsnVar.f28435b;
        this.f28452e = zzdsnVar.f28438e;
        this.f28453f = zzdsnVar.f28439f;
        this.f28454g = zzdsnVar.f28440g;
        this.f28449b = zzdsnVar.f28434a;
        this.f28456i = zzdsnVar.f28437d;
        this.f28457j = zzdsnVar.f28441h;
        this.f28451d = zzdsnVar.f28436c;
        this.f28458k = zzdsnVar.f28442i;
        this.f28459l = zzdsnVar.f28443j;
    }

    public final synchronized ListenableFuture a(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.f28460m;
        if (listenableFuture == null) {
            return zzgyq.f33377b;
        }
        return zzgym.h(listenableFuture, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzdsl
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws JSONException {
                String str2 = str;
                JSONObject jSONObject2 = jSONObject;
                zzcir zzcirVar = (zzcir) obj;
                zzboe zzboeVar = this.f28430a.f28455h;
                zzboeVar.getClass();
                zzcdt zzcdtVar = new zzcdt();
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                String string = UUID.randomUUID().toString();
                zzboeVar.b(string, new zzboc(zzboeVar, zzcdtVar));
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, string);
                    jSONObject3.put("args", jSONObject2);
                    zzcirVar.f(str2, jSONObject3);
                    return zzcdtVar;
                } catch (Exception e2) {
                    zzcdtVar.c(e2);
                    return zzcdtVar;
                }
            }
        }, this.f28452e);
    }

    public final synchronized void b(String str, zzbnn zzbnnVar) {
        ListenableFuture listenableFuture = this.f28460m;
        if (listenableFuture == null) {
            return;
        }
        zzdsf zzdsfVar = new zzdsf(this, str, zzbnnVar);
        Executor executor = this.f28452e;
        ((zzgxf) listenableFuture).q(new zzgyk(listenableFuture, zzdsfVar), executor);
    }

    public final synchronized void c(String str, zzbnn zzbnnVar) {
        ListenableFuture listenableFuture = this.f28460m;
        if (listenableFuture == null) {
            return;
        }
        zzdsg zzdsgVar = new zzdsg(this, str, zzbnnVar);
        Executor executor = this.f28452e;
        ((zzgxf) listenableFuture).q(new zzgyk(listenableFuture, zzdsgVar), executor);
    }

    public final synchronized void d(Map map) {
        ListenableFuture listenableFuture = this.f28460m;
        if (listenableFuture == null) {
            return;
        }
        zzdsh zzdshVar = new zzdsh(this, map);
        Executor executor = this.f28452e;
        ((zzgxf) listenableFuture).q(new zzgyk(listenableFuture, zzdshVar), executor);
    }
}
