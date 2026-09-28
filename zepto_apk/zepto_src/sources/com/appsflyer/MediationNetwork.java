package com.appsflyer;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public enum MediationNetwork {
    IRONSOURCE("ironsource"),
    APPLOVIN_MAX("applovinmax"),
    GOOGLE_ADMOB("googleadmob"),
    FYBER("fyber"),
    APPODEAL("appodeal"),
    ADMOST("Admost"),
    TOPON("Topon"),
    TRADPLUS("Tradplus"),
    YANDEX("Yandex"),
    CHARTBOOST("chartboost"),
    UNITY("Unity"),
    TOPON_PTE("toponpte"),
    CUSTOM_MEDIATION("customMediation"),
    DIRECT_MONETIZATION_NETWORK("directMonetizationNetwork");


    @NotNull
    private final String value;

    MediationNetwork(String str) {
        this.value = str;
    }

    @JvmName
    @NotNull
    public final String getValue() {
        return this.value;
    }
}
