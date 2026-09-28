package com.google.ads.interactivemedia.v3.api;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface FriendlyObstruction {
    @Nullable
    String getDetailedReason();

    @NonNull
    FriendlyObstructionPurpose getPurpose();

    @NonNull
    View getView();
}
