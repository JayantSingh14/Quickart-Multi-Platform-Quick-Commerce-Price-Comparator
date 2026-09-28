package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class zzdxn {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f28748a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f28749b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f28750c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzu f28751d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f28752e;

    /* renamed from: f, reason: collision with root package name */
    public final CsiUrlBuilder f28753f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f28754g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f28755h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f28756i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference f28757j;

    public zzdxn(zzgyw zzgywVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, CsiUrlBuilder csiUrlBuilder, Context context) {
        this.f28748a = new HashMap();
        this.f28756i = new AtomicBoolean();
        this.f28757j = new AtomicReference(new Bundle());
        this.f28750c = zzgywVar;
        this.f28751d = zzuVar;
        zzbgb zzbgbVar = zzbgk.s2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f28752e = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        this.f28753f = csiUrlBuilder;
        zzbgb zzbgbVar2 = zzbgk.x2;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        this.f28754g = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        this.f28755h = ((Boolean) zzbgiVar.a(zzbgk.E7)).booleanValue();
        this.f28749b = context;
    }

    public final void a(Map map, boolean z) {
        if (map.isEmpty()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
            return;
        }
        b(map);
        final String strA = this.f28753f.a(map);
        com.google.android.gms.ads.internal.util.zze.k(strA);
        boolean z2 = Boolean.parseBoolean((String) map.get("scar"));
        if (this.f28752e) {
            if (!z || this.f28754g) {
                if (!z2 || this.f28755h) {
                    this.f28750c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxk
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f28742a.f28751d.b(strA, null);
                        }
                    });
                }
            }
        }
    }

    public final void b(Map map) {
        Bundle bundleB;
        if (map == null || map.isEmpty()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty or null paramMap.");
            return;
        }
        boolean andSet = this.f28756i.getAndSet(true);
        AtomicReference atomicReference = this.f28757j;
        if (!andSet) {
            final String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gb);
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.ads.zzdxl
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                    zzdxn zzdxnVar = this.f28744a;
                    zzdxnVar.f28757j.set(com.google.android.gms.ads.internal.util.zzac.b(zzdxnVar.f28749b, str));
                }
            };
            if (TextUtils.isEmpty(str)) {
                bundleB = Bundle.EMPTY;
            } else {
                Context context = this.f28749b;
                PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                bundleB = com.google.android.gms.ads.internal.util.zzac.b(context, str);
            }
            atomicReference.set(bundleB);
        }
        Bundle bundle = (Bundle) atomicReference.get();
        for (String str2 : bundle.keySet()) {
            map.put(str2, String.valueOf(bundle.get(str2)));
        }
    }
}
