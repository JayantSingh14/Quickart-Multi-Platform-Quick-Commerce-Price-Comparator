package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import java.util.EnumMap;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzfqd {

    /* renamed from: a, reason: collision with root package name */
    public final zzdxe f31622a;

    public zzfqd(zzdxe zzdxeVar) {
        this.f31622a = zzdxeVar;
    }

    public final void a(int i2, long j2, zzfqk zzfqkVar, String str) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("action", "start_preload");
        zzdxdVarA.b("sp_ts", Long.toString(j2));
        zzdxdVarA.b("ad_format", zzfqkVar.a());
        zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
        zzdxdVarA.b("pid", zzfqkVar.f31645c);
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("pv", str);
        zzdxdVarA.c();
    }

    public final void b(EnumMap enumMap, long j2) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("action", "start_preload");
        zzdxdVarA.b("sp_ts", Long.toString(j2));
        zzdxdVarA.b("pv", "1");
        for (AdFormat adFormat : enumMap.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdxdVarA.b(strValueOf.concat("_count"), Integer.toString(((Integer) enumMap.get(adFormat)).intValue()));
        }
        zzdxdVarA.c();
    }

    public final void c(int i2, int i3, long j2, Long l2, String str, zzfqk zzfqkVar, String str2) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("plaac_ts", Long.toString(j2));
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("cache_size", Integer.toString(i3));
        zzdxdVarA.b("action", "is_ad_available");
        if (zzfqkVar != null) {
            zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
            zzdxdVarA.b("pid", zzfqkVar.f31645c);
            zzdxdVarA.b("ad_format", zzfqkVar.a());
        }
        if (l2 != null) {
            zzdxdVarA.b("plaay_ts", Long.toString(l2.longValue()));
        }
        if (str != null) {
            zzdxdVarA.b("gqi", str);
        }
        zzdxdVarA.b("pv", str2);
        zzdxdVarA.c();
    }

    public final void d(long j2, int i2, int i3, String str, zzfqk zzfqkVar, String str2) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("ppla_ts", Long.toString(j2));
        zzdxdVarA.b("ad_format", zzfqkVar.a());
        zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
        zzdxdVarA.b("pid", zzfqkVar.f31645c);
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("cache_size", Integer.toString(i3));
        zzdxdVarA.b("action", "poll_ad");
        if (str != null) {
            zzdxdVarA.b("gqi", str);
        }
        zzdxdVarA.b("pv", str2);
        zzdxdVarA.c();
    }

    public final void e(long j2, zzfqk zzfqkVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i2, int i3, String str) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("action", "pftla");
        zzdxdVarA.b("pftlat_ts", Long.toString(j2));
        zzdxdVarA.b("pftlaec", Integer.toString(zzeVar.f21161a));
        zzdxdVarA.b("ad_format", zzfqkVar.a());
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("cache_size", Integer.toString(i3));
        zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
        zzdxdVarA.b("pid", zzfqkVar.f31645c);
        zzdxdVarA.b("pv", str);
        zzdxdVarA.c();
    }

    public final void f(String str, long j2, String str2, String str3, AdFormat adFormat, int i2, int i3, int i4) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("action", str);
        zzdxdVarA.b("pat", Long.toString(j2));
        zzdxdVarA.b("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("cache_size", Integer.toString(i3));
        zzdxdVarA.b("pas", Integer.toString(i4));
        zzdxdVarA.b("pv", "2");
        zzdxdVarA.b("ad_unit_id", str3);
        zzdxdVarA.b("pid", str2);
        zzdxdVarA.c();
    }

    public final void g(String str, String str2, long j2, int i2, int i3, String str3, zzfqk zzfqkVar, String str4) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b(str2, Long.toString(j2));
        if (zzfqkVar != null) {
            zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
            zzdxdVarA.b("ad_format", zzfqkVar.a());
            zzdxdVarA.b("pid", zzfqkVar.f31645c);
        }
        zzdxdVarA.b("action", str);
        if (str3 != null) {
            zzdxdVarA.b("gqi", str3);
        }
        if (i2 >= 0) {
            zzdxdVarA.b("max_ads", Integer.toString(i2));
        }
        if (i3 >= 0) {
            zzdxdVarA.b("cache_size", Integer.toString(i3));
        }
        zzdxdVarA.b("pv", str4);
        zzdxdVarA.c();
    }

    public final void h(String str, long j2, String str2, String str3, AdFormat adFormat, int i2, int i3, int i4, int i5, int i6) {
        zzdxd zzdxdVarA = this.f31622a.a();
        zzdxdVarA.b("action", str);
        zzdxdVarA.b("pat", Long.toString(j2));
        zzdxdVarA.b("pid", str2);
        zzdxdVarA.b("ad_unit_id", str3);
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("cache_size", Integer.toString(i3));
        zzdxdVarA.b("tpcnt", Integer.toString(i5));
        zzdxdVarA.b("mpl", Integer.toString(i6));
        if (adFormat != null) {
            zzdxdVarA.b("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        if (i4 > 0) {
            zzdxdVarA.b("nptr", Integer.toString(i4));
        }
        zzdxdVarA.c();
    }
}
