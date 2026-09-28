package com.google.android.tv.ads;

import com.google.android.gms.internal.atv_ads_framework.zzbe;
import com.google.android.tv.ads.IconClickFallbackImages;

/* loaded from: classes4.dex */
final class zzb extends IconClickFallbackImages.Builder {

    /* renamed from: a, reason: collision with root package name */
    public zzbe f42221a;

    @Override // com.google.android.tv.ads.IconClickFallbackImages.Builder
    public final IconClickFallbackImages a() {
        zzbe zzbeVar = this.f42221a;
        if (zzbeVar != null) {
            return new zzf(zzbeVar);
        }
        throw new IllegalStateException("Missing required properties: iconClickFallbackImageList");
    }
}
