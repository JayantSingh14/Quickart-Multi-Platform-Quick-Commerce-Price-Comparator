package com.zeptoconsumerapp.GoogleAdsManager.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class GAMConfig {

    /* renamed from: b, reason: collision with root package name */
    public static final GAMConfig f47502b;

    /* renamed from: c, reason: collision with root package name */
    public static final GAMConfig f47503c;

    /* renamed from: d, reason: collision with root package name */
    public static final GAMConfig f47504d;

    /* renamed from: e, reason: collision with root package name */
    public static final GAMConfig f47505e;

    /* renamed from: f, reason: collision with root package name */
    public static final GAMConfig f47506f;

    /* renamed from: g, reason: collision with root package name */
    public static final GAMConfig f47507g;

    /* renamed from: h, reason: collision with root package name */
    public static final GAMConfig f47508h;

    /* renamed from: i, reason: collision with root package name */
    public static final GAMConfig f47509i;

    /* renamed from: j, reason: collision with root package name */
    public static final GAMConfig f47510j;

    /* renamed from: k, reason: collision with root package name */
    public static final GAMConfig f47511k;

    /* renamed from: l, reason: collision with root package name */
    public static final GAMConfig f47512l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ GAMConfig[] f47513m;
    public static final /* synthetic */ EnumEntries n;

    /* renamed from: a, reason: collision with root package name */
    public final String f47514a;

    static {
        GAMConfig gAMConfig = new GAMConfig("AD_SIZE", 0, "adSize");
        f47502b = gAMConfig;
        GAMConfig gAMConfig2 = new GAMConfig("AD_BANNER_TYPE", 1, "adBannerType");
        f47503c = gAMConfig2;
        GAMConfig gAMConfig3 = new GAMConfig("CORRELATOR_ID", 2, "correlator");
        f47504d = gAMConfig3;
        GAMConfig gAMConfig4 = new GAMConfig("CUSTOM_TARGETING", 3, "customTargeting");
        f47505e = gAMConfig4;
        GAMConfig gAMConfig5 = new GAMConfig("AD_UNIT_ID", 4, "adUnitId");
        f47506f = gAMConfig5;
        GAMConfig gAMConfig6 = new GAMConfig("AD_IMPRESSION_FUNC", 5, "onAdImpressionFunc");
        GAMConfig gAMConfig7 = new GAMConfig("AD_CLICKED_FUNC", 6, "onAdClickedFunc");
        GAMConfig gAMConfig8 = new GAMConfig("AD_FAILED_FUNC", 7, "onAdFailedToLoadFunc");
        f47507g = gAMConfig8;
        GAMConfig gAMConfig9 = new GAMConfig("AD_LOAD_FUNC", 8, "onAdLoadedFunc");
        GAMConfig gAMConfig10 = new GAMConfig("AD_STRING", 9, "adString");
        f47508h = gAMConfig10;
        GAMConfig gAMConfig11 = new GAMConfig("SMALL_BANNER", 10, "SMALL_BANNER");
        f47509i = gAMConfig11;
        GAMConfig gAMConfig12 = new GAMConfig("MEDIUM_BANNER", 11, "MEDIUM_BANNER");
        f47510j = gAMConfig12;
        GAMConfig gAMConfig13 = new GAMConfig("LARGE_RECTANGLE", 12, "LARGE_RECTANGLE");
        f47511k = gAMConfig13;
        GAMConfig gAMConfig14 = new GAMConfig("CUSTOM", 13, "CUSTOM");
        f47512l = gAMConfig14;
        GAMConfig[] gAMConfigArr = {gAMConfig, gAMConfig2, gAMConfig3, gAMConfig4, gAMConfig5, gAMConfig6, gAMConfig7, gAMConfig8, gAMConfig9, gAMConfig10, gAMConfig11, gAMConfig12, gAMConfig13, gAMConfig14};
        f47513m = gAMConfigArr;
        n = EnumEntriesKt.a(gAMConfigArr);
    }

    public GAMConfig(String str, int i2, String str2) {
        this.f47514a = str2;
    }

    public static GAMConfig valueOf(String str) {
        return (GAMConfig) Enum.valueOf(GAMConfig.class, str);
    }

    public static GAMConfig[] values() {
        return (GAMConfig[]) f47513m.clone();
    }

    public final String a() {
        return this.f47514a;
    }
}
