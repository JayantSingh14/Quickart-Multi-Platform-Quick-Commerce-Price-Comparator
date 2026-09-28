package com.brentvatne.common.api;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class AdsProps {

    /* renamed from: a, reason: collision with root package name */
    public Uri f15340a;

    /* renamed from: b, reason: collision with root package name */
    public String f15341b;

    @Metadata
    public static final class Companion {
    }

    public final String a() {
        return this.f15341b;
    }

    public final Uri b() {
        return this.f15340a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdsProps)) {
            AdsProps adsProps = (AdsProps) obj;
            if (Intrinsics.b(this.f15340a, adsProps.f15340a) && Intrinsics.b(this.f15341b, adsProps.f15341b)) {
                return true;
            }
        }
        return false;
    }
}
