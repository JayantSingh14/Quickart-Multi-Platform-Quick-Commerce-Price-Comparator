package com.phoenix;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class PhoenixAppUpdateModel {

    @SerializedName("data")
    @NotNull
    private final UpdateData data;

    public PhoenixAppUpdateModel(UpdateData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final UpdateData a() {
        return this.data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoenixAppUpdateModel) && Intrinsics.b(this.data, ((PhoenixAppUpdateModel) obj).data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        return "PhoenixAppUpdateModel(data=" + this.data + ")";
    }
}
