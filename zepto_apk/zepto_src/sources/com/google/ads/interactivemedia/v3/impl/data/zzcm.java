package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: classes3.dex */
public abstract class zzcm {
    public abstract zzcm attached(boolean z);

    public abstract zzcm bounds(zzbh zzbhVar);

    public abstract zzcn build();

    public abstract zzcm detailedReason(@Nullable String str);

    public abstract zzcm hidden(boolean z);

    public abstract zzcm purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract zzcm type(String str);

    public zzcm view(View view) {
        return attached(view.isAttachedToWindow()).bounds(zzbh.builder().locationOnScreenOfView(view).build()).hidden(!view.isShown()).type(view.getClass().getCanonicalName());
    }
}
