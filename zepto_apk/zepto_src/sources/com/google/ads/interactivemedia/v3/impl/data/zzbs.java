package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzac.class)
/* loaded from: classes3.dex */
public abstract class zzbs {
    public static zzbs create(int i2, int i3, String str, String str2, String str3) {
        return new zzac(i2, i3, str, str2, str3);
    }

    public abstract String alternateText();

    public abstract String creativeType();

    public String getAlternateText() {
        return alternateText();
    }

    public String getCreativeType() {
        return creativeType();
    }

    public int getHeight() {
        return height();
    }

    public String getResourceUri() {
        return imageUrl();
    }

    public int getWidth() {
        return width();
    }

    public abstract int height();

    public abstract String imageUrl();

    public final String toString() {
        int iWidth = width();
        int iHeight = height();
        String strImageUrl = imageUrl();
        String strAlternateText = alternateText();
        String strCreativeType = creativeType();
        StringBuilder sbT = b.t(iWidth, iHeight, "IconClickFallbackImageMsgData [width=", ", height=", ", imageUrl=");
        b.B(sbT, strImageUrl, ", alternateText=", strAlternateText, ", creativeType=");
        return b.r(sbT, strCreativeType, "]");
    }

    public abstract int width();
}
