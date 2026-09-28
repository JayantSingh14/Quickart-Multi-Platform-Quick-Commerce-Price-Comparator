package com.zeptoconsumerapp.modules.configservice.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ResolvedConfig {

    @SerializedName(PaymentConstants.Category.CONFIG)
    @Nullable
    private final JsonObject config;

    @SerializedName("enabled")
    private final boolean enabled;

    public ResolvedConfig(boolean z, JsonObject jsonObject) {
        this.enabled = z;
        this.config = jsonObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolvedConfig)) {
            return false;
        }
        ResolvedConfig resolvedConfig = (ResolvedConfig) obj;
        return this.enabled == resolvedConfig.enabled && Intrinsics.b(this.config, resolvedConfig.config);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.enabled) * 31;
        JsonObject jsonObject = this.config;
        return iHashCode + (jsonObject == null ? 0 : jsonObject.f45256a.hashCode());
    }

    public final String toString() {
        return "ResolvedConfig(enabled=" + this.enabled + ", config=" + this.config + ")";
    }
}
