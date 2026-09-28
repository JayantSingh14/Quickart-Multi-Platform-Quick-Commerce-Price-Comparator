package com.airbnb.lottie.model;

import android.graphics.ColorFilter;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public interface KeyPathElement {
    void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback);

    void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2);
}
