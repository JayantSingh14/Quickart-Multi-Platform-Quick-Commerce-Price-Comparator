package com.chuckerteam.chucker.internal.data.har.log.page;

import android.support.v4.media.b;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class PageTimings {

    @SerializedName("onContentLoad")
    @Nullable
    private final Long onContentLoad = null;

    @SerializedName("onLoad")
    @Nullable
    private final Long onLoad = null;

    @SerializedName("comment")
    @Nullable
    private final String comment = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageTimings)) {
            return false;
        }
        PageTimings pageTimings = (PageTimings) obj;
        return Intrinsics.b(this.onContentLoad, pageTimings.onContentLoad) && Intrinsics.b(this.onLoad, pageTimings.onLoad) && Intrinsics.b(this.comment, pageTimings.comment);
    }

    public final int hashCode() {
        Long l2 = this.onContentLoad;
        int iHashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        Long l3 = this.onLoad;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str = this.comment;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        Long l2 = this.onContentLoad;
        Long l3 = this.onLoad;
        String str = this.comment;
        StringBuilder sb = new StringBuilder("PageTimings(onContentLoad=");
        sb.append(l2);
        sb.append(", onLoad=");
        sb.append(l3);
        sb.append(", comment=");
        return b.r(sb, str, ")");
    }
}
