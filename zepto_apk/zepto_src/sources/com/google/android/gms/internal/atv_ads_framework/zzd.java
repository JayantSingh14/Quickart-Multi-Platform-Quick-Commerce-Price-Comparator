package com.google.android.gms.internal.atv_ads_framework;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzd {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f36107a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f36108b;

    static {
        Uri uriBuild = new Uri.Builder().scheme("content").appendPath("signals").build();
        f36107a = uriBuild.buildUpon().authority("com.google.android.apps.tv.launcherx.ads.signals.AdsSignalsContentProvider").build();
        f36108b = uriBuild.buildUpon().authority("com.google.android.tvrecommendations.ads.signals.AdsSignalsContentProvider").build();
        zzbi.o(2, "atv_atcrc", "atv_atcrc_tva");
    }
}
