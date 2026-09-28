package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzbsg implements zzcdx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrl f25509a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f25510b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25511c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbsj f25512d;

    public zzbsg(zzbsj zzbsjVar, zzbrl zzbrlVar, Object obj, zzcdt zzcdtVar) {
        this.f25509a = zzbrlVar;
        this.f25510b = obj;
        this.f25511c = zzcdtVar;
        Objects.requireNonNull(zzbsjVar);
        this.f25512d = zzbsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final void zza(Object obj) throws JSONException {
        zzbrs zzbrsVar = (zzbrs) obj;
        com.google.android.gms.ads.internal.util.zze.k("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.f25510b;
        zzcdt zzcdtVar = this.f25511c;
        zzbrl zzbrlVar = this.f25509a;
        zzbsj zzbsjVar = this.f25512d;
        zzbsjVar.getClass();
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            String string = UUID.randomUUID().toString();
            zzbnm.o.b(string, new zzbsi(zzbrlVar, zzbsjVar, zzcdtVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, string);
            jSONObject.put("args", zzbsjVar.f25519b.zzb(obj2));
            zzbrsVar.f(zzbsjVar.f25521d, jSONObject);
        } catch (Exception e2) {
            try {
                zzcdtVar.c(e2);
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to invokeJavascript", e2);
            } finally {
                zzbrlVar.d();
            }
        }
    }
}
