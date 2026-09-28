package com.zeptoconsumerapp.modules.configservice.entity;

import android.support.v4.media.a;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class FeatureConfig {

    @SerializedName("data")
    @Nullable
    private final JsonObject data;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("minAppVersions")
    @Nullable
    private final Map<String, Integer> minAppVersions;

    @SerializedName("rollout")
    private final int rollout;

    public final JsonObject a() {
        return this.data;
    }

    public final boolean b() {
        return this.enabled;
    }

    public final Map c() {
        return this.minAppVersions;
    }

    public final int d() {
        return this.rollout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureConfig)) {
            return false;
        }
        FeatureConfig featureConfig = (FeatureConfig) obj;
        return this.enabled == featureConfig.enabled && this.rollout == featureConfig.rollout && Intrinsics.b(this.minAppVersions, featureConfig.minAppVersions) && Intrinsics.b(this.data, featureConfig.data);
    }

    public final int hashCode() {
        int iB = a.b(this.rollout, Boolean.hashCode(this.enabled) * 31, 31);
        Map<String, Integer> map = this.minAppVersions;
        int iHashCode = (iB + (map == null ? 0 : map.hashCode())) * 31;
        JsonObject jsonObject = this.data;
        return iHashCode + (jsonObject != null ? jsonObject.f45256a.hashCode() : 0);
    }

    public final String toString() {
        return "FeatureConfig(enabled=" + this.enabled + ", rollout=" + this.rollout + ", minAppVersions=" + this.minAppVersions + ", data=" + this.data + ")";
    }
}
