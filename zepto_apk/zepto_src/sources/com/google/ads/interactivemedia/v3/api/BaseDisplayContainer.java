package com.google.ads.interactivemedia.v3.api;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface BaseDisplayContainer {
    @KeepForSdk
    void claim();

    @Deprecated
    void destroy();

    @NonNull
    ViewGroup getAdContainer();

    @NonNull
    Collection<CompanionAdSlot> getCompanionSlots();

    void registerFriendlyObstruction(@NonNull FriendlyObstruction friendlyObstruction);

    @Deprecated
    void registerVideoControlsOverlay(@NonNull View view);

    @Deprecated
    void setAdContainer(@NonNull ViewGroup viewGroup);

    void setCompanionSlots(@Nullable Collection<CompanionAdSlot> collection);

    void unregisterAllFriendlyObstructions();

    @Deprecated
    void unregisterAllVideoControlsOverlays();
}
