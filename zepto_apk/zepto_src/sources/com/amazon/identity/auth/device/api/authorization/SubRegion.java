package com.amazon.identity.auth.device.api.authorization;

import com.amazon.identity.auth.device.authorization.RegionUtil;

/* loaded from: classes3.dex */
public enum SubRegion {
    IN;


    /* renamed from: a, reason: collision with root package name */
    public final String f15119a = RegionUtil.SubRegionUtil.SUB_REGION_STRING_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Region f15120b;

    SubRegion(Region region) {
        this.f15120b = region;
    }

    public Region getAssociatedRegion() {
        return this.f15120b;
    }

    public String getStringValue() {
        return this.f15119a;
    }

    public boolean isInRegion(Region region) {
        return this.f15120b == region;
    }
}
