package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzcgj implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzcgi f26166a;

    public zzcgj(zzcgi zzcgiVar) {
        this.f26166a = zzcgiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* synthetic */ void a(Object obj, Map map) {
        String str = (String) map.get("action");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Action missing from video GMSG.");
        } else if (str.equals("src")) {
            String str2 = (String) map.get("src");
            if (str2 == null) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("src missing from video GMSG.");
            } else {
                zzdqh zzdqhVar = (zzdqh) this.f26166a;
                zzdqhVar.f28250a.b(androidx.fragment.app.e.i("mediaUrl", str2));
            }
        }
    }
}
