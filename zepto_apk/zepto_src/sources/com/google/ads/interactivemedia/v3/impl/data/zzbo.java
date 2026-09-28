package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: classes3.dex */
public interface zzbo {
    zzbp build();

    zzbo detailedReason(@Nullable String str);

    zzbo purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    zzbo view(View view);
}
