package com.zeptoconsumerapp.modules.configservice.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ConfigResponse {

    @SerializedName("data")
    @NotNull
    private final ConfigData data;

    public final ConfigData a() {
        return this.data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConfigResponse) && Intrinsics.b(this.data, ((ConfigResponse) obj).data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        return "ConfigResponse(data=" + this.data + ")";
    }
}
