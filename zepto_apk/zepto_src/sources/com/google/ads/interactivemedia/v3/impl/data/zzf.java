package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class zzf {
    public abstract zzg build();

    public abstract zzf setBitrate(int i2);

    public abstract zzf setDisableUi(boolean z);

    public abstract zzf setEnableFocusSkipButton(boolean z);

    public abstract zzf setEnablePreloading(boolean z);

    public abstract zzf setLoadVideoTimeout(int i2);

    public abstract zzf setMimeTypes(@Nullable List<String> list);

    public abstract zzf setPlayAdsAfterTime(double d2);

    public abstract zzf setUiElements(@Nullable Set<UiElement> set);
}
