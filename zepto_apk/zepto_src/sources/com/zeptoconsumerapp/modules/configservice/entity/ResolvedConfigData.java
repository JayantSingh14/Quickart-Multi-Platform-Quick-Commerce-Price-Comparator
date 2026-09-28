package com.zeptoconsumerapp.modules.configservice.entity;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ResolvedConfigData {

    @SerializedName("features")
    @NotNull
    private final Map<String, ResolvedConfig> features;

    @SerializedName("version")
    private final long version;

    public ResolvedConfigData(long j2, LinkedHashMap features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.version = j2;
        this.features = features;
    }

    public final Map a() {
        return this.features;
    }

    public final long b() {
        return this.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolvedConfigData)) {
            return false;
        }
        ResolvedConfigData resolvedConfigData = (ResolvedConfigData) obj;
        return this.version == resolvedConfigData.version && Intrinsics.b(this.features, resolvedConfigData.features);
    }

    public final int hashCode() {
        return this.features.hashCode() + (Long.hashCode(this.version) * 31);
    }

    public final String toString() {
        return "ResolvedConfigData(version=" + this.version + ", features=" + this.features + ")";
    }
}
