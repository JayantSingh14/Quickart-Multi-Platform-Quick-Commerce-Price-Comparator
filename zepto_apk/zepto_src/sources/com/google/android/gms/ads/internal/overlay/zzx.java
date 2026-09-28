package com.google.android.gms.ads.internal.overlay;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzgoq;
import com.google.android.gms.internal.ads.zzgor;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzx implements zzgor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzz f21390a;

    public zzx(zzz zzzVar) {
        Objects.requireNonNull(zzzVar);
        this.f21390a = zzzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgor
    public final void a(zzgoq zzgoqVar) {
        zzz zzzVar = this.f21390a;
        zzzVar.getClass();
        if (!TextUtils.isEmpty(zzgoqVar.b())) {
            if (!((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ec)).booleanValue()) {
                zzzVar.f21394a = zzgoqVar.b();
            }
        }
        switch (zzgoqVar.a()) {
            case 8152:
                zzzVar.d("onLMDOverlayOpened", new HashMap());
                break;
            case 8153:
                zzzVar.d("onLMDOverlayClicked", new HashMap());
                break;
            case 8155:
                zzzVar.d("onLMDOverlayClose", new HashMap());
                break;
            case 8157:
                zzzVar.f21394a = null;
                zzzVar.f21395b = null;
                zzzVar.f21398e = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzgoqVar.a()));
                zzzVar.d("onLMDOverlayFailedToOpen", map);
                break;
        }
    }
}
