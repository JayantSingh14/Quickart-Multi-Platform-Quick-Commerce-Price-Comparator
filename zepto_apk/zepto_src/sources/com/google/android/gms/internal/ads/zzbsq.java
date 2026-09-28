package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbsq implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbsr f25531a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f25532b;

    public /* synthetic */ zzbsq(zzbsr zzbsrVar, Object obj) {
        this.f25531a = zzbsrVar;
        this.f25532b = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) throws JSONException {
        zzbsr zzbsrVar = this.f25531a;
        zzbsrVar.getClass();
        zzcdt zzcdtVar = new zzcdt();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        String string = UUID.randomUUID().toString();
        zzbnm.o.b(string, new zzbsp(zzbsrVar, zzcdtVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, string);
        jSONObject.put("args", (JSONObject) this.f25532b);
        ((zzbrs) obj).f("google.afma.activeView.handleUpdate", jSONObject);
        return zzcdtVar;
    }
}
