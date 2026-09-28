package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public class StreetViewPanoramaView extends FrameLayout {
    public StreetViewPanoramaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet);
        new zzat(this, context);
    }

    public StreetViewPanoramaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet, i2);
        new zzat(this, context);
    }
}
