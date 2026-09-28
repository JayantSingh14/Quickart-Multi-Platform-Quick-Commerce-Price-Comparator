package com.zeptoconsumerapp.modules.configservice.entity;

import com.google.gson.annotations.SerializedName;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ConfigData {

    @SerializedName(PaymentConstants.Category.CONFIG)
    @NotNull
    private final Map<String, FeatureConfig> config;

    @SerializedName("version")
    private final long version;

    public final Map a() {
        return this.config;
    }

    public final long b() {
        return this.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) obj;
        return this.version == configData.version && Intrinsics.b(this.config, configData.config);
    }

    public final int hashCode() {
        return this.config.hashCode() + (Long.hashCode(this.version) * 31);
    }

    public final String toString() {
        return "ConfigData(version=" + this.version + ", config=" + this.config + ")";
    }
}
