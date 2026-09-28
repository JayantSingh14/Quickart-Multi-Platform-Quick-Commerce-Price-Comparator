package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbnj implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbnj f25333a = new zzbnj();

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        zzckk zzckkVar = (zzckk) obj;
        zzbnn zzbnnVar = zzbnm.f25337a;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i2 = Integer.parseInt(str);
            int i3 = Integer.parseInt(str2);
            int i4 = Integer.parseInt(str3);
            zzayq zzayqVarD = zzckkVar.d();
            if (zzayqVarD != null) {
                zzayqVarD.f24512b.b(i2, i3, i4);
            }
        } catch (NumberFormatException unused) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse touch parameters from gmsg.");
        }
    }
}
