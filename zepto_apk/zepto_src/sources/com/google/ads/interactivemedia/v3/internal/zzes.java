package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;

/* loaded from: classes3.dex */
public final class zzes {
    public static boolean zza(BaseDisplayContainer baseDisplayContainer, com.google.ads.interactivemedia.v3.impl.data.zzcp zzcpVar) {
        int width = baseDisplayContainer.getAdContainer().getWidth();
        int height = baseDisplayContainer.getAdContainer().getHeight();
        if (zzcpVar.x().intValue() < 0 || zzcpVar.width().intValue() < 0) {
            return false;
        }
        if (zzcpVar.width().intValue() + zzcpVar.x().intValue() > width || zzcpVar.y().intValue() < 0 || zzcpVar.height().intValue() < 0) {
            return false;
        }
        return zzcpVar.height().intValue() + zzcpVar.y().intValue() <= height;
    }
}
