package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzgnu;
import com.google.android.gms.internal.ads.zzgnv;
import com.google.android.gms.internal.ads.zzgoo;
import com.google.android.gms.internal.ads.zzgor;
import com.google.android.gms.internal.ads.zzgos;
import com.google.android.gms.internal.ads.zzgot;
import com.google.android.gms.internal.ads.zzgpg;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzz {

    /* renamed from: f, reason: collision with root package name */
    public zzgor f21399f;

    /* renamed from: c, reason: collision with root package name */
    public zzcir f21396c = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21398e = false;

    /* renamed from: a, reason: collision with root package name */
    public String f21394a = null;

    /* renamed from: d, reason: collision with root package name */
    public zzgnu f21397d = null;

    /* renamed from: b, reason: collision with root package name */
    public String f21395b = null;

    public final synchronized boolean a(Context context) {
        if (!zzgpg.a(context)) {
            return false;
        }
        try {
            this.f21397d = zzgnv.a(context);
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.util.zze.k("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("LastMileDeliveryOverlay.bindLastMileDeliveryService", e2);
        }
        if (this.f21397d == null) {
            this.f21398e = false;
            return false;
        }
        if (this.f21399f == null) {
            this.f21399f = new zzx(this);
        }
        this.f21398e = true;
        return true;
    }

    public final void b(zzcir zzcirVar, zzgoo zzgooVar) {
        if (zzcirVar == null) {
            c("adWebview missing", "onLMDShow");
            return;
        }
        this.f21396c = zzcirVar;
        if (!this.f21398e && !a(zzcirVar.getContext())) {
            c("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ec)).booleanValue()) {
            this.f21395b = zzgooVar.b();
        }
        if (this.f21399f == null) {
            this.f21399f = new zzx(this);
        }
        zzgnu zzgnuVar = this.f21397d;
        if (zzgnuVar != null) {
            zzgnuVar.a(zzgooVar, this.f21399f);
        }
    }

    public final void c(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.k(str);
        if (this.f21396c != null) {
            HashMap map = new HashMap();
            map.put(APayConstants.Error.MESSAGE, str);
            map.put("action", str2);
            d("onError", map);
        }
    }

    public final void d(final String str, final HashMap map) {
        zzcdo.f25987f.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcir zzcirVar = this.f21391a.f21396c;
                if (zzcirVar != null) {
                    zzcirVar.g(str, map);
                }
            }
        });
    }

    public final zzgot e() {
        zzgos zzgosVarC = zzgot.c();
        if (!((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ec)).booleanValue() || TextUtils.isEmpty(this.f21395b)) {
            String str = this.f21394a;
            if (str != null) {
                zzgosVarC.a(str);
            } else {
                c("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgosVarC.b(this.f21395b);
        }
        return zzgosVarC.c();
    }
}
