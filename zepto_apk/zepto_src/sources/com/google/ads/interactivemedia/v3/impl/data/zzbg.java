package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;

/* loaded from: classes3.dex */
public abstract class zzbg {
    public abstract zzbh build();

    public abstract zzbg height(int i2);

    public abstract zzbg left(int i2);

    public zzbg locationOnScreenOfView(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return left(iArr[0]).top(iArr[1]).height(view.getHeight()).width(view.getWidth());
    }

    public abstract zzbg top(int i2);

    public abstract zzbg width(int i2);
}
