package com.amazon.identity.auth.device.api.authorization;

import com.amazon.identity.auth.device.authorization.RegionUtil;

/* loaded from: classes3.dex */
public enum Region {
    AUTO(RegionUtil.REGION_STRING_AUTO),
    NA(RegionUtil.REGION_STRING_NA),
    EU(RegionUtil.REGION_STRING_EU),
    FE(RegionUtil.REGION_STRING_FE);


    /* renamed from: a, reason: collision with root package name */
    public final String f15115a;

    Region(String str) {
        this.f15115a = str;
    }

    public String getStringValue() {
        return this.f15115a;
    }
}
