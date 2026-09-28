package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.AutoValue_ComplianceData;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ComplianceData {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract ComplianceData a();

        public abstract Builder b(ExternalPrivacyContext externalPrivacyContext);

        public abstract Builder c();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ProductIdOrigin {

        /* renamed from: a, reason: collision with root package name */
        public static final ProductIdOrigin f20668a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ProductIdOrigin[] f20669b;

        /* JADX INFO: Fake field, exist only in values array */
        ProductIdOrigin EF0;

        static {
            ProductIdOrigin productIdOrigin = new ProductIdOrigin("NOT_SET", 0);
            ProductIdOrigin productIdOrigin2 = new ProductIdOrigin("EVENT_OVERRIDE", 1);
            f20668a = productIdOrigin2;
            f20669b = new ProductIdOrigin[]{productIdOrigin, productIdOrigin2};
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(0, productIdOrigin);
            sparseArray.put(5, productIdOrigin2);
        }

        public static ProductIdOrigin valueOf(String str) {
            return (ProductIdOrigin) Enum.valueOf(ProductIdOrigin.class, str);
        }

        public static ProductIdOrigin[] values() {
            return (ProductIdOrigin[]) f20669b.clone();
        }
    }

    public static Builder a() {
        return new AutoValue_ComplianceData.Builder();
    }

    public abstract ExternalPrivacyContext b();

    public abstract ProductIdOrigin c();
}
