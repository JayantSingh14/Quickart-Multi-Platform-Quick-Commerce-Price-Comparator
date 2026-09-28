package com.chuckerteam.chucker.internal.data.har.log.entry;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpHeader;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class Header {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    @NotNull
    private final String name;

    @SerializedName(CLConstants.FIELD_PAY_INFO_VALUE)
    @NotNull
    private final String value;

    public Header(HttpHeader header) {
        Intrinsics.checkNotNullParameter(header, "header");
        String name = header.a();
        String value = header.b();
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
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.b(this.name, header.name) && Intrinsics.b(this.value, header.value) && Intrinsics.b(this.comment, header.comment);
    }

    public final int hashCode() {
        int iE = e.e(this.name.hashCode() * 31, 31, this.value);
        String str = this.comment;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.name;
        String str2 = this.value;
        return b.r(e.v("Header(name=", str, ", value=", str2, ", comment="), this.comment, ")");
    }
}
