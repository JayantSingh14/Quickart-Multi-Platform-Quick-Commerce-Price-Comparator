package com.zeptoconsumerapp.performancemode.performanceClasses;

import in.juspay.hyperupi.UPIConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class NetworkConnectionType {

    /* renamed from: b, reason: collision with root package name */
    public static final NetworkConnectionType f47774b;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkConnectionType f47775c;

    /* renamed from: d, reason: collision with root package name */
    public static final NetworkConnectionType f47776d;

    /* renamed from: e, reason: collision with root package name */
    public static final NetworkConnectionType f47777e;

    /* renamed from: f, reason: collision with root package name */
    public static final NetworkConnectionType f47778f;

    /* renamed from: g, reason: collision with root package name */
    public static final NetworkConnectionType f47779g;

    /* renamed from: h, reason: collision with root package name */
    public static final NetworkConnectionType f47780h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ NetworkConnectionType[] f47781i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47782j;

    /* renamed from: a, reason: collision with root package name */
    public final String f47783a;

    static {
        NetworkConnectionType networkConnectionType = new NetworkConnectionType(UPIConstants.WIFI, 0, UPIConstants.WIFI);
        f47774b = networkConnectionType;
        NetworkConnectionType networkConnectionType2 = new NetworkConnectionType("CELLULAR_2G", 1, "CELLULAR_2G");
        f47775c = networkConnectionType2;
        NetworkConnectionType networkConnectionType3 = new NetworkConnectionType("CELLULAR_3G", 2, "CELLULAR_3G");
        f47776d = networkConnectionType3;
        NetworkConnectionType networkConnectionType4 = new NetworkConnectionType("CELLULAR_4G", 3, "CELLULAR_4G");
        f47777e = networkConnectionType4;
        NetworkConnectionType networkConnectionType5 = new NetworkConnectionType("CELLULAR_5G", 4, "CELLULAR_5G");
        f47778f = networkConnectionType5;
        NetworkConnectionType networkConnectionType6 = new NetworkConnectionType("CELLULAR_UNKNOWN", 5, "CELLULAR_UNKNOWN");
        f47779g = networkConnectionType6;
        NetworkConnectionType networkConnectionType7 = new NetworkConnectionType("NONE", 6, "NONE");
        f47780h = networkConnectionType7;
        NetworkConnectionType[] networkConnectionTypeArr = {networkConnectionType, networkConnectionType2, networkConnectionType3, networkConnectionType4, networkConnectionType5, networkConnectionType6, networkConnectionType7};
        f47781i = networkConnectionTypeArr;
        f47782j = EnumEntriesKt.a(networkConnectionTypeArr);
    }

    public NetworkConnectionType(String str, int i2, String str2) {
        this.f47783a = str2;
    }

    public static NetworkConnectionType valueOf(String str) {
        return (NetworkConnectionType) Enum.valueOf(NetworkConnectionType.class, str);
    }

    public static NetworkConnectionType[] values() {
        return (NetworkConnectionType[]) f47781i.clone();
    }

    public final String a() {
        return this.f47783a;
    }
}
