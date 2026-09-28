package com.zeptoconsumerapp.FusedLocation;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class LocationStatusTypes {

    /* renamed from: a, reason: collision with root package name */
    public static final LocationStatusTypes f47477a;

    /* renamed from: b, reason: collision with root package name */
    public static final LocationStatusTypes f47478b;

    /* renamed from: c, reason: collision with root package name */
    public static final LocationStatusTypes f47479c;

    /* renamed from: d, reason: collision with root package name */
    public static final LocationStatusTypes f47480d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ LocationStatusTypes[] f47481e;

    static {
        LocationStatusTypes locationStatusTypes = new LocationStatusTypes("UNRESOLVED", 0);
        f47477a = locationStatusTypes;
        LocationStatusTypes locationStatusTypes2 = new LocationStatusTypes("CHANGE_ADDRESS", 1);
        LocationStatusTypes locationStatusTypes3 = new LocationStatusTypes("NO_PERMISSION", 2);
        f47478b = locationStatusTypes3;
        LocationStatusTypes locationStatusTypes4 = new LocationStatusTypes("LOCATION_OFF", 3);
        f47479c = locationStatusTypes4;
        LocationStatusTypes locationStatusTypes5 = new LocationStatusTypes("GRANTED", 4);
        f47480d = locationStatusTypes5;
        f47481e = new LocationStatusTypes[]{locationStatusTypes, locationStatusTypes2, locationStatusTypes3, locationStatusTypes4, locationStatusTypes5, new LocationStatusTypes(MerchantConstants.ERROR, 5), new LocationStatusTypes("GRANTED_LOCATION_NOT_FOUND", 6)};
    }

    public static LocationStatusTypes valueOf(String str) {
        return (LocationStatusTypes) Enum.valueOf(LocationStatusTypes.class, str);
    }

    public static LocationStatusTypes[] values() {
        return (LocationStatusTypes[]) f47481e.clone();
    }
}
