package com.phoenix;

import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class CacheManifest {

    @SerializedName("appVersion")
    @NotNull
    private final String appVersion;

    @SerializedName("bundleUrl")
    @Nullable
    private final String bundleUrl;

    @SerializedName("bundleVersion")
    private final int bundleVersion;

    @SerializedName("hash")
    @Nullable
    private final String hash;

    @SerializedName("jsVersion")
    private final int jsVersion;

    @SerializedName(CLConstants.OTP_STATUS)
    @Nullable
    private final BundleStates status;

    public final String a() {
        return this.appVersion;
    }

    public final String b() {
        return this.bundleUrl;
    }

    public final int c() {
        return this.bundleVersion;
    }

    public final String d() {
        return this.hash;
    }

    public final int e() {
        return this.jsVersion;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheManifest)) {
            return false;
        }
        CacheManifest cacheManifest = (CacheManifest) obj;
        return this.status == cacheManifest.status && this.bundleVersion == cacheManifest.bundleVersion && this.jsVersion == cacheManifest.jsVersion && Intrinsics.b(this.appVersion, cacheManifest.appVersion) && Intrinsics.b(this.hash, cacheManifest.hash) && Intrinsics.b(this.bundleUrl, cacheManifest.bundleUrl);
    }

    public final BundleStates f() {
        return this.status;
    }

    public final int hashCode() {
        BundleStates bundleStates = this.status;
        int iE = e.e(android.support.v4.media.a.b(this.jsVersion, android.support.v4.media.a.b(this.bundleVersion, (bundleStates == null ? 0 : bundleStates.hashCode()) * 31, 31), 31), 31, this.appVersion);
        String str = this.hash;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bundleUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        BundleStates bundleStates = this.status;
        int i2 = this.bundleVersion;
        int i3 = this.jsVersion;
        String str = this.appVersion;
        String str2 = this.hash;
        String str3 = this.bundleUrl;
        StringBuilder sb = new StringBuilder("CacheManifest(status=");
        sb.append(bundleStates);
        sb.append(", bundleVersion=");
        sb.append(i2);
        sb.append(", jsVersion=");
        sb.append(i3);
        sb.append(", appVersion=");
        sb.append(str);
        sb.append(", hash=");
        return android.support.v4.media.a.n(sb, str2, ", bundleUrl=", str3, ")");
    }
}
