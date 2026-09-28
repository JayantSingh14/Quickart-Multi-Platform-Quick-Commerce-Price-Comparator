package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzdmd implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f27930a;

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzdmg zzdmgVar = (zzdmg) this.f27930a.get();
        if (zzdmgVar == null) {
            return;
        }
        zzdmgVar.f27944h.h();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
            zzdip zzdipVar = zzdmgVar.f27945i;
            zzdipVar.S();
            if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                return;
            }
            zzdipVar.a0();
        }
    }
}
