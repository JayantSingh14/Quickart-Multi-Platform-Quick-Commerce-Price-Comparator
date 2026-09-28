package com.google.ads.interactivemedia.v3.api;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface CompanionAdSlot {
    public static final int FLUID_SIZE = -2;

    public interface ClickListener {
        void onCompanionAdClick();
    }

    void addClickListener(@NonNull ClickListener clickListener);

    @NonNull
    ViewGroup getContainer();

    int getHeight();

    int getWidth();

    boolean isFilled();

    void removeClickListener(@NonNull ClickListener clickListener);

    void setContainer(@NonNull ViewGroup viewGroup);

    void setSize(int i2, int i3);
}
