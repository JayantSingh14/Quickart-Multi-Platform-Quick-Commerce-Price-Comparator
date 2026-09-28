package com.chuckerteam.chucker.internal.data.har.log.entry.request.postdata;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class Params {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("contentType")
    @Nullable
    private final String contentType;

    @SerializedName("fileName")
    @Nullable
    private final String fileName;

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    @NotNull
    private final String name;

    @SerializedName(CLConstants.FIELD_PAY_INFO_VALUE)
    @Nullable
    private final String value;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Params)) {
            return false;
        }
        Params params = (Params) obj;
        return Intrinsics.b(this.name, params.name) && Intrinsics.b(this.value, params.value) && Intrinsics.b(this.fileName, params.fileName) && Intrinsics.b(this.contentType, params.contentType) && Intrinsics.b(this.comment, params.comment);
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.value;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.contentType;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comment;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String str = this.name;
        String str2 = this.value;
        String str3 = this.fileName;
        String str4 = this.contentType;
        String str5 = this.comment;
        StringBuilder sbV = e.v("Params(name=", str, ", value=", str2, ", fileName=");
        b.B(sbV, str3, ", contentType=", str4, ", comment=");
        return b.r(sbV, str5, ")");
    }
}
