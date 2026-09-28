package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbhm extends CustomTabsCallback {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f25067a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final List f25068b = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ab)).split(","));

    /* renamed from: c, reason: collision with root package name */
    public final zzbhp f25069c;

    /* renamed from: d, reason: collision with root package name */
    public final CustomTabsCallback f25070d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdxj f25071e;

    public zzbhm(zzbhp zzbhpVar, CustomTabsCallback customTabsCallback, zzdxj zzdxjVar) {
        this.f25070d = customTabsCallback;
        this.f25069c = zzbhpVar;
        this.f25071e = zzdxjVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void a(Bundle bundle, String str) {
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.a(bundle, str);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final Bundle b(Bundle bundle, String str) {
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            return customTabsCallback.b(bundle, str);
        }
        return null;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void d(int i2, int i3, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.d(i2, i3, bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void e(Bundle bundle) {
        this.f25067a.set(false);
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.e(bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void g(int i2, Bundle bundle) {
        this.f25067a.set(false);
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.g(i2, bundle);
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
        final zzbhp zzbhpVar = this.f25069c;
        zzbhpVar.f25084j = jCurrentTimeMillis;
        List list = this.f25068b;
        if (list == null || !list.contains(String.valueOf(i2))) {
            return;
        }
        zzbhpVar.f25083i = zztVar.f21687k.elapsedRealtime() + ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Xa)).intValue();
        if (zzbhpVar.f25079e == null) {
            zzbhpVar.f25079e = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbho
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzbhpVar.d();
                }
            };
        }
        zzbhpVar.d();
        com.google.android.gms.ads.nonagon.signalgeneration.zzaa.d(this.f25071e, "pact_action", new Pair("pe", "pact_reqpmc"));
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void h(Bundle bundle, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("gpa", -1) == 0) {
                this.f25067a.set(true);
                com.google.android.gms.ads.nonagon.signalgeneration.zzaa.d(this.f25071e, "pact_action", new Pair("pe", "pact_con"));
                this.f25069c.a(jSONObject.getString("paw_id"));
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Message is not in JSON format: ", e2);
        }
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.h(bundle, str);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void i(int i2, Uri uri, boolean z, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.f25070d;
        if (customTabsCallback != null) {
            customTabsCallback.i(i2, uri, z, bundle);
        }
    }
}
