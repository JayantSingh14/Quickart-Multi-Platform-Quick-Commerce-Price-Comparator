package com.zeptoconsumerapp.modules.configservice;

import android.support.v4.media.b;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixManifest {

    @SerializedName("bundleVersion")
    private final int bundleVersion = 0;

    public final int a() {
        return this.bundleVersion;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoenixManifest) && this.bundleVersion == ((PhoenixManifest) obj).bundleVersion;
    }

    public final int hashCode() {
        return Integer.hashCode(this.bundleVersion);
    }

    public final String toString() {
        return b.g(this.bundleVersion, "PhoenixManifest(bundleVersion=", ")");
    }
}
