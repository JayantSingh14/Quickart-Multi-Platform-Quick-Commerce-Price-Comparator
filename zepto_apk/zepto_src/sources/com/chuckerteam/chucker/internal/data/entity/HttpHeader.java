package com.chuckerteam.chucker.internal.data.entity;

import android.support.v4.media.b;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class HttpHeader {

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    @NotNull
    private final String name;

    @SerializedName(CLConstants.FIELD_PAY_INFO_VALUE)
    @NotNull
    private final String value;

    public HttpHeader(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
    }

    public final String a() {
        return this.name;
    }

    public final String b() {
        return this.value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHeader)) {
            return false;
        }
        HttpHeader httpHeader = (HttpHeader) obj;
        return Intrinsics.b(this.name, httpHeader.name) && Intrinsics.b(this.value, httpHeader.value);
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return b.m("HttpHeader(name=", this.name, ", value=", this.value, ")");
    }
}
