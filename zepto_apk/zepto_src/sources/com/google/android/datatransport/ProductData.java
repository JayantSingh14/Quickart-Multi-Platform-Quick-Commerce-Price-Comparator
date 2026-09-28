package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ProductData {
    public static ProductData b(Integer num) {
        return new AutoValue_ProductData(num);
    }

    public abstract Integer a();
}
