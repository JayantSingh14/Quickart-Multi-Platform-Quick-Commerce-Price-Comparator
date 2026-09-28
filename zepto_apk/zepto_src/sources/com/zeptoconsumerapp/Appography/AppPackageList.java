package com.zeptoconsumerapp.Appography;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class AppPackageList {

    @SerializedName("packages")
    @NotNull
    private final List<String> packages;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppPackageList) && Intrinsics.b(this.packages, ((AppPackageList) obj).packages);
    }

    public final int hashCode() {
        return this.packages.hashCode();
    }

    public final String toString() {
        return "AppPackageList(packages=" + this.packages + ")";
    }
}
