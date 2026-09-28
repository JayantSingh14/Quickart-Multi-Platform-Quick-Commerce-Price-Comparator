package com.phoenix;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class BundleListResponse {

    @SerializedName("data")
    @Nullable
    private final BundleListResponseData data;

    public final BundleListResponseData a() {
        return this.data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BundleListResponse) && Intrinsics.b(this.data, ((BundleListResponse) obj).data);
    }

    public final int hashCode() {
        BundleListResponseData bundleListResponseData = this.data;
        if (bundleListResponseData == null) {
            return 0;
        }
        return bundleListResponseData.hashCode();
    }

    public final String toString() {
        return "BundleListResponse(data=" + this.data + ")";
    }
}
