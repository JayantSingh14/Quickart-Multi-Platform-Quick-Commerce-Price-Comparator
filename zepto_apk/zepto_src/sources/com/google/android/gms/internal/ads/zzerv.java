package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzerv implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfik f30189a;

    /* renamed from: b, reason: collision with root package name */
    public final long f30190b;

    /* renamed from: c, reason: collision with root package name */
    public final long f30191c;

    public zzerv(zzfik zzfikVar, long j2, long j3) {
        this.f30189a = zzfikVar;
        this.f30190b = j2;
        this.f30191c = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        zzfik zzfikVar = this.f30189a;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
        bundle.putInt("http_timeout_millis", zzmVar.w);
        bundle.putString("slotname", zzfikVar.f31219g);
        int i2 = zzfikVar.p.f31184a;
        if (i2 == 0) {
            throw null;
        }
        int i3 = i2 - 1;
        if (i3 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i3 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        long j2 = this.f30190b;
        bundle.putLong("start_signals_timestamp", j2);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Fe)).booleanValue()) {
            bundle.putLong("tsi", j2 - this.f30191c);
        }
        Bundle bundle2 = zzmVar.f21256c;
        zzfiz.d(bundle, "is_sdk_preload", true, bundle2.getBoolean("is_sdk_preload", false));
        zzfiz.b(bundle, "prefetch_type", "zenith_v2", bundle2.getBoolean("zenith_v2", false));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        long j3 = zzmVar.f21255b;
        zzfiz.b(bundle, "cust_age", simpleDateFormat.format(new Date(j3)), j3 != -1);
        if (bundle2 != null) {
            bundle.putBundle("extras", bundle2);
        }
        int i4 = zzmVar.f21257d;
        zzfiz.c(bundle, "cust_gender", i4, i4 != -1);
        zzfiz.f("kw", zzmVar.f21258e, bundle);
        int i5 = zzmVar.f21260g;
        zzfiz.c(bundle, "tag_for_child_directed_treatment", i5, i5 != -1);
        if (zzmVar.f21259f) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", zzmVar.y);
        int i6 = zzmVar.f21254a;
        zzfiz.c(bundle, "d_imp_hdr", 1, i6 >= 2 && zzmVar.f21261h);
        String str = zzmVar.f21262i;
        zzfiz.b(bundle, "ppid", str, i6 >= 2 && !TextUtils.isEmpty(str));
        Location location = zzmVar.f21264k;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", accuracy);
            bundle3.putLong("lat", (long) latitude);
            bundle3.putLong("long", (long) longitude);
            bundle3.putLong("time", time);
            bundle.putBundle("uule", bundle3);
        }
        zzfiz.e("url", zzmVar.f21265l, bundle);
        zzfiz.f("neighboring_content_urls", zzmVar.v, bundle);
        Bundle bundle4 = zzmVar.n;
        if (bundle4 != null) {
            bundle.putBundle("custom_targeting", bundle4);
        }
        zzfiz.f("category_exclusions", zzmVar.o, bundle);
        zzfiz.e("request_agent", zzmVar.p, bundle);
        zzfiz.e("request_pkg", zzmVar.q, bundle);
        zzfiz.d(bundle, "is_designed_for_families", zzmVar.r, i6 >= 7);
        if (i6 >= 8) {
            int i7 = zzmVar.t;
            zzfiz.c(bundle, "tag_for_under_age_of_consent", i7, i7 != -1);
            zzfiz.e("max_ad_content_rating", zzmVar.u, bundle);
        }
        Bundle bundle5 = zzfikVar.f31217e;
        bundle.putInt("plcs", bundle5.getInt("plcs"));
        bundle.putInt("plbs", bundle5.getInt("plbs"));
        zzfiz.e("plid", bundle5.getString("plid"), bundle);
        zzfiz.c(bundle, "s2s_rr", 1, zzfikVar.v && !(zzmVar.s == null && zzmVar.x == null));
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        zzfik zzfikVar = this.f30189a;
        bundle.putString("slotname", zzfikVar.f31219g);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
        if (zzmVar.f21259f) {
            bundle.putBoolean("test_request", true);
        }
        int i2 = zzmVar.f21260g;
        zzfiz.c(bundle, "tag_for_child_directed_treatment", i2, i2 != -1);
        if (zzmVar.f21254a >= 8) {
            int i3 = zzmVar.t;
            zzfiz.c(bundle, "tag_for_under_age_of_consent", i3, i3 != -1);
        }
        zzfiz.e("url", zzmVar.f21265l, bundle);
        zzfiz.f("neighboring_content_urls", zzmVar.v, bundle);
        Bundle bundle2 = zzmVar.f21256c;
        Bundle bundle3 = (Bundle) bundle2.clone();
        HashSet hashSet = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.m8)).split(",", -1)));
        for (String str : bundle2.keySet()) {
            if (!hashSet.contains(str)) {
                bundle3.remove(str);
            }
        }
        if (bundle3 != null) {
            bundle.putBundle("extras", bundle3);
        }
    }
}
