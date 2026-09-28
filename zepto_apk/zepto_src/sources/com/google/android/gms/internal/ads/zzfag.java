package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzfag implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f30731a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30732b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30733c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30734d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f30735e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f30736f;

    /* renamed from: g, reason: collision with root package name */
    public final String f30737g;

    /* renamed from: h, reason: collision with root package name */
    public final String f30738h;

    /* renamed from: i, reason: collision with root package name */
    public final String f30739i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f30740j;

    /* renamed from: k, reason: collision with root package name */
    public final String f30741k;

    /* renamed from: l, reason: collision with root package name */
    public final String f30742l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f30743m;
    public final long n;
    public final boolean o;
    public final String p;
    public final int q;
    public final String r;

    public zzfag(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList arrayList, String str3, String str4, boolean z6, long j2, boolean z7, String str5, int i2, String str6, String str7, String str8) {
        String str9 = Build.FINGERPRINT;
        String str10 = Build.MODEL;
        this.f30731a = z;
        this.f30732b = z2;
        this.f30733c = str;
        this.f30734d = z3;
        this.f30735e = z4;
        this.f30736f = z5;
        this.f30737g = str2;
        this.f30738h = str6;
        this.f30740j = arrayList;
        this.f30741k = str3;
        this.f30742l = str4;
        this.f30743m = z6;
        this.n = j2;
        this.o = z7;
        this.p = str5;
        this.q = i2;
        this.r = str8;
        this.f30739i = str7;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        String str;
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putBoolean("cog", this.f30731a);
        bundle.putBoolean("coh", this.f30732b);
        bundle.putString("gl", this.f30733c);
        bundle.putBoolean("simulator", this.f30734d);
        bundle.putBoolean("is_latchsky", this.f30735e);
        bundle.putInt("build_api_level", this.q);
        zzbgb zzbgbVar = zzbgk.hc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            bundle.putBoolean("is_sidewinder", this.f30736f);
        }
        bundle.putString("hl", this.f30737g);
        zzbgb zzbgbVar2 = zzbgk.Ce;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() || ((Boolean) zzbgiVar.a(zzbgk.De)).booleanValue()) {
            bundle.putString("dlc", this.f30738h);
        }
        ArrayList<String> arrayList = this.f30740j;
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("hl_list", arrayList);
        }
        String str2 = this.f30739i;
        if (str2 != null) {
            bundle.putString("dgl", str2);
        }
        bundle.putString("mv", this.f30741k);
        bundle.putString("submodel", Build.MODEL);
        Bundle bundleA = zzfiz.a(bundle, LogSubCategory.Context.DEVICE);
        bundle.putBundle(LogSubCategory.Context.DEVICE, bundleA);
        bundleA.putString("build", Build.FINGERPRINT);
        bundleA.putLong("remaining_data_partition_space", this.n);
        Bundle bundleA2 = zzfiz.a(bundleA, "browser");
        bundleA.putBundle("browser", bundleA2);
        bundleA2.putBoolean("is_browser_custom_tabs_capable", this.f30743m);
        String str3 = this.f30742l;
        if (!TextUtils.isEmpty(str3)) {
            Bundle bundleA3 = zzfiz.a(bundleA, "play_store");
            bundleA.putBundle("play_store", bundleA3);
            bundleA3.putString("package_version", str3);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.xc)).booleanValue()) {
            bundle.putBoolean("is_bstar", this.o);
        }
        String str4 = this.p;
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString("v_unity", str4);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.rc)).booleanValue()) {
            zzfiz.d(bundle, "gotmt_l", true, ((Boolean) zzbgiVar.a(zzbgk.oc)).booleanValue());
            zzfiz.d(bundle, "gotmt_i", true, ((Boolean) zzbgiVar.a(zzbgk.nc)).booleanValue());
        }
        if (!((Boolean) zzbgiVar.a(zzbgk.sf)).booleanValue() || (str = this.r) == null) {
            return;
        }
        bundle.putString("sdk_i_s", str);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        bundle.putBoolean("simulator", this.f30734d);
        bundle.putInt("build_api_level", this.q);
        ArrayList<String> arrayList = this.f30740j;
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("hl_list", arrayList);
        }
        bundle.putString("submodel", Build.MODEL);
    }
}
