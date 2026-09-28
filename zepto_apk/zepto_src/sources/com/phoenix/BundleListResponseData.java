package com.phoenix;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class BundleListResponseData {

    @SerializedName("count")
    @Nullable
    private final Integer count;

    @SerializedName("releases")
    @Nullable
    private final List<BundleListItem> releases;

    public final List a() {
        return this.releases;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BundleListResponseData)) {
            return false;
        }
        BundleListResponseData bundleListResponseData = (BundleListResponseData) obj;
        return Intrinsics.b(this.releases, bundleListResponseData.releases) && Intrinsics.b(this.count, bundleListResponseData.count);
    }

    public final int hashCode() {
        List<BundleListItem> list = this.releases;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.count;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "BundleListResponseData(releases=" + this.releases + ", count=" + this.count + ")";
    }
}
