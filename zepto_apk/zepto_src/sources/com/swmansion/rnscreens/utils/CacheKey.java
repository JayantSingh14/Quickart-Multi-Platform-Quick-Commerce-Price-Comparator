package com.swmansion.rnscreens.utils;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
final class CacheKey {

    /* renamed from: a, reason: collision with root package name */
    public final int f47146a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f47147b;

    public CacheKey(int i2, boolean z) {
        this.f47146a = i2;
        this.f47147b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        return this.f47146a == cacheKey.f47146a && this.f47147b == cacheKey.f47147b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f47147b) + (Integer.hashCode(this.f47146a) * 31);
    }

    public final String toString() {
        return "CacheKey(fontSize=" + this.f47146a + ", isTitleEmpty=" + this.f47147b + ")";
    }
}
