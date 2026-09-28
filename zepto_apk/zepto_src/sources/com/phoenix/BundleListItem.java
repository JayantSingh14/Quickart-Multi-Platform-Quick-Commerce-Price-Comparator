package com.phoenix;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class BundleListItem {

    @SerializedName(CLConstants.SALT_FIELD_APP_ID)
    @Nullable
    private final String appId;

    @SerializedName("appVersion")
    @Nullable
    private final String appVersion;

    @SerializedName("bundle")
    @Nullable
    private final BundleInfo bundle;

    @SerializedName("bundleVersion")
    @Nullable
    private final Integer bundleVersion;

    @SerializedName("createdAt")
    @Nullable
    private final String createdAt;

    @SerializedName("defaultRelease")
    @Nullable
    private final Boolean defaultRelease;

    @SerializedName("description")
    @Nullable
    private final String description;

    @SerializedName("hash")
    @Nullable
    private final String hash;

    @SerializedName("jsVersion")
    @Nullable
    private final Integer jsVersion;

    @SerializedName("nativeRelease")
    @Nullable
    private final Boolean nativeRelease;

    @SerializedName("releaseState")
    @Nullable
    private final Integer releaseState;

    @SerializedName("releaseVersion")
    @Nullable
    private final String releaseVersion;

    @SerializedName("rollout")
    @Nullable
    private final Integer rollout;

    @SerializedName("updatedAt")
    @Nullable
    private final String updatedAt;

    public final String a() {
        return this.appId;
    }

    public final String b() {
        return this.appVersion;
    }

    public final BundleInfo c() {
        return this.bundle;
    }

    public final Integer d() {
        return this.bundleVersion;
    }

    public final String e() {
        return this.createdAt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BundleListItem)) {
            return false;
        }
        BundleListItem bundleListItem = (BundleListItem) obj;
        return Intrinsics.b(this.appId, bundleListItem.appId) && Intrinsics.b(this.appVersion, bundleListItem.appVersion) && Intrinsics.b(this.bundle, bundleListItem.bundle) && Intrinsics.b(this.bundleVersion, bundleListItem.bundleVersion) && Intrinsics.b(this.createdAt, bundleListItem.createdAt) && Intrinsics.b(this.defaultRelease, bundleListItem.defaultRelease) && Intrinsics.b(this.description, bundleListItem.description) && Intrinsics.b(this.hash, bundleListItem.hash) && Intrinsics.b(this.jsVersion, bundleListItem.jsVersion) && Intrinsics.b(this.nativeRelease, bundleListItem.nativeRelease) && Intrinsics.b(this.releaseState, bundleListItem.releaseState) && Intrinsics.b(this.releaseVersion, bundleListItem.releaseVersion) && Intrinsics.b(this.rollout, bundleListItem.rollout) && Intrinsics.b(this.updatedAt, bundleListItem.updatedAt);
    }

    public final Boolean f() {
        return this.defaultRelease;
    }

    public final String g() {
        return this.description;
    }

    public final String h() {
        return this.hash;
    }

    public final int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appVersion;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        BundleInfo bundleInfo = this.bundle;
        int iHashCode3 = (iHashCode2 + (bundleInfo == null ? 0 : bundleInfo.hashCode())) * 31;
        Integer num = this.bundleVersion;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.createdAt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.defaultRelease;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.hash;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.jsVersion;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.nativeRelease;
        int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num3 = this.releaseState;
        int iHashCode11 = (iHashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.releaseVersion;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num4 = this.rollout;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str7 = this.updatedAt;
        return iHashCode13 + (str7 != null ? str7.hashCode() : 0);
    }

    public final Integer i() {
        return this.jsVersion;
    }

    public final Boolean j() {
        return this.nativeRelease;
    }

    public final Integer k() {
        return this.releaseState;
    }

    public final String l() {
        return this.releaseVersion;
    }

    public final Integer m() {
        return this.rollout;
    }

    public final String n() {
        return this.updatedAt;
    }

    public final String toString() {
        String str = this.appId;
        String str2 = this.appVersion;
        BundleInfo bundleInfo = this.bundle;
        Integer num = this.bundleVersion;
        String str3 = this.createdAt;
        Boolean bool = this.defaultRelease;
        String str4 = this.description;
        String str5 = this.hash;
        Integer num2 = this.jsVersion;
        Boolean bool2 = this.nativeRelease;
        Integer num3 = this.releaseState;
        String str6 = this.releaseVersion;
        Integer num4 = this.rollout;
        String str7 = this.updatedAt;
        StringBuilder sbV = e.v("BundleListItem(appId=", str, ", appVersion=", str2, ", bundle=");
        sbV.append(bundleInfo);
        sbV.append(", bundleVersion=");
        sbV.append(num);
        sbV.append(", createdAt=");
        sbV.append(str3);
        sbV.append(", defaultRelease=");
        sbV.append(bool);
        sbV.append(", description=");
        b.B(sbV, str4, ", hash=", str5, ", jsVersion=");
        sbV.append(num2);
        sbV.append(", nativeRelease=");
        sbV.append(bool2);
        sbV.append(", releaseState=");
        sbV.append(num3);
        sbV.append(", releaseVersion=");
        sbV.append(str6);
        sbV.append(", rollout=");
        sbV.append(num4);
        sbV.append(", updatedAt=");
        sbV.append(str7);
        sbV.append(")");
        return sbV.toString();
    }
}
