package com.chuckerteam.chucker.internal.data.har.log.entry.cache;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class SecondaryRequest {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("eTag")
    @NotNull
    private final String eTag;

    @SerializedName("expires")
    @Nullable
    private final String expires;

    @SerializedName("hitCount")
    private final int hitCount;

    @SerializedName("lastAccess")
    @NotNull
    private final String lastAccess;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecondaryRequest)) {
            return false;
        }
        SecondaryRequest secondaryRequest = (SecondaryRequest) obj;
        return Intrinsics.b(this.expires, secondaryRequest.expires) && Intrinsics.b(this.lastAccess, secondaryRequest.lastAccess) && Intrinsics.b(this.eTag, secondaryRequest.eTag) && this.hitCount == secondaryRequest.hitCount && Intrinsics.b(this.comment, secondaryRequest.comment);
    }

    public final int hashCode() {
        String str = this.expires;
        int iB = a.b(this.hitCount, e.e(e.e((str == null ? 0 : str.hashCode()) * 31, 31, this.lastAccess), 31, this.eTag), 31);
        String str2 = this.comment;
        return iB + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.expires;
        String str2 = this.lastAccess;
        String str3 = this.eTag;
        int i2 = this.hitCount;
        String str4 = this.comment;
        StringBuilder sbV = e.v("SecondaryRequest(expires=", str, ", lastAccess=", str2, ", eTag=");
        sbV.append(str3);
        sbV.append(", hitCount=");
        sbV.append(i2);
        sbV.append(", comment=");
        return b.r(sbV, str4, ")");
    }
}
