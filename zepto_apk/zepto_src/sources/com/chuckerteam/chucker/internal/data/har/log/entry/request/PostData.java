package com.chuckerteam.chucker.internal.data.har.log.entry.request;

import android.support.v4.media.a;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.har.log.entry.request.postdata.Params;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class PostData {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("mimeType")
    @NotNull
    private final String mimeType;

    @SerializedName("params")
    @Nullable
    private final Params params;

    @SerializedName("text")
    @Nullable
    private final String text;

    public PostData(HttpTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        String mimeType = transaction.getRequestContentType();
        mimeType = mimeType == null ? "application/octet-stream" : mimeType;
        String requestBody = transaction.getRequestBody();
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.mimeType = mimeType;
        this.params = null;
        this.text = requestBody;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostData)) {
            return false;
        }
        PostData postData = (PostData) obj;
        return Intrinsics.b(this.mimeType, postData.mimeType) && Intrinsics.b(this.params, postData.params) && Intrinsics.b(this.text, postData.text) && Intrinsics.b(this.comment, postData.comment);
    }

    public final int hashCode() {
        int iHashCode = this.mimeType.hashCode() * 31;
        Params params = this.params;
        int iHashCode2 = (iHashCode + (params == null ? 0 : params.hashCode())) * 31;
        String str = this.text;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.comment;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.mimeType;
        Params params = this.params;
        String str2 = this.text;
        String str3 = this.comment;
        StringBuilder sb = new StringBuilder("PostData(mimeType=");
        sb.append(str);
        sb.append(", params=");
        sb.append(params);
        sb.append(", text=");
        return a.n(sb, str2, ", comment=", str3, ")");
    }
}
