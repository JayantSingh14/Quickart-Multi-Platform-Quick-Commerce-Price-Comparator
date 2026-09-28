package com.chuckerteam.chucker.internal.data.har.log.entry;

import android.support.v4.media.b;
import com.chuckerteam.chucker.internal.data.har.log.entry.cache.SecondaryRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class Cache {

    @SerializedName("afterRequest")
    @Nullable
    private final SecondaryRequest afterRequest;

    @SerializedName("beforeRequest")
    @Nullable
    private final SecondaryRequest beforeRequest;

    @SerializedName("comment")
    @Nullable
    private final String comment;

    public Cache() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cache)) {
            return false;
        }
        Cache cache = (Cache) obj;
        return Intrinsics.b(this.afterRequest, cache.afterRequest) && Intrinsics.b(this.beforeRequest, cache.beforeRequest) && Intrinsics.b(this.comment, cache.comment);
    }

    public final int hashCode() {
        SecondaryRequest secondaryRequest = this.afterRequest;
        int iHashCode = (secondaryRequest == null ? 0 : secondaryRequest.hashCode()) * 31;
        SecondaryRequest secondaryRequest2 = this.beforeRequest;
        int iHashCode2 = (iHashCode + (secondaryRequest2 == null ? 0 : secondaryRequest2.hashCode())) * 31;
        String str = this.comment;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        SecondaryRequest secondaryRequest = this.afterRequest;
        SecondaryRequest secondaryRequest2 = this.beforeRequest;
        String str = this.comment;
        StringBuilder sb = new StringBuilder("Cache(afterRequest=");
        sb.append(secondaryRequest);
        sb.append(", beforeRequest=");
        sb.append(secondaryRequest2);
        sb.append(", comment=");
        return b.r(sb, str, ")");
    }

    public Cache(int i2) {
        this.afterRequest = null;
        this.beforeRequest = null;
        this.comment = null;
    }
}
