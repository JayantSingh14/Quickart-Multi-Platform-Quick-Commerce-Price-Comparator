package com.chuckerteam.chucker.internal.data.har.log.entry.request;

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
public final class QueryString {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    @NotNull
    private final String name;

    @SerializedName(CLConstants.FIELD_PAY_INFO_VALUE)
    @NotNull
    private final String value;

    @Metadata
    public static final class Companion {
    }

    public QueryString(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryString)) {
            return false;
        }
        QueryString queryString = (QueryString) obj;
        return Intrinsics.b(this.name, queryString.name) && Intrinsics.b(this.value, queryString.value) && Intrinsics.b(this.comment, queryString.comment);
    }

    public final int hashCode() {
        int iE = e.e(this.name.hashCode() * 31, 31, this.value);
        String str = this.comment;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.name;
        String str2 = this.value;
        return b.r(e.v("QueryString(name=", str, ", value=", str2, ", comment="), this.comment, ")");
    }
}
