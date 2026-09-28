package com.phoenix;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class BundleInfo {

    @SerializedName("size")
    @Nullable
    private final Long size;

    @SerializedName("url")
    @Nullable
    private final String url;

    public final Long a() {
        return this.size;
    }

    public final String b() {
        return this.url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BundleInfo)) {
            return false;
        }
        BundleInfo bundleInfo = (BundleInfo) obj;
        return Intrinsics.b(this.size, bundleInfo.size) && Intrinsics.b(this.url, bundleInfo.url);
    }

    public final int hashCode() {
        Long l2 = this.size;
        int iHashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        String str = this.url;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "BundleInfo(size=" + this.size + ", url=" + this.url + ")";
    }
}
