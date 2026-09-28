package com.phoenix;

import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class UpdateData {

    @SerializedName("bundleUrl")
    @Nullable
    private final String bundleUrl;

    @SerializedName("bundleVersion")
    @Nullable
    private final Integer bundleVersion;

    @SerializedName("hash")
    @Nullable
    private final String hash;

    @SerializedName("isMandatory")
    @Nullable
    private final Boolean isMandatory;

    @SerializedName("isUpdateAvailable")
    private final boolean isUpdateAvailable;

    @SerializedName("jsVersion")
    @Nullable
    private final Integer jsVersion;

    @SerializedName("patchUrl")
    @Nullable
    private final String patchUrl;

    @SerializedName("rollback")
    @Nullable
    private final Boolean rollback;

    public UpdateData(String str, String str2, Integer num, Integer num2) {
        Boolean bool = Boolean.FALSE;
        this.bundleUrl = str;
        this.hash = str2;
        this.isMandatory = bool;
        this.isUpdateAvailable = true;
        this.patchUrl = null;
        this.bundleVersion = num;
        this.jsVersion = num2;
        this.rollback = bool;
    }

    public final String a() {
        return this.bundleUrl;
    }

    public final Integer b() {
        return this.bundleVersion;
    }

    public final String c() {
        return this.hash;
    }

    public final Integer d() {
        return this.jsVersion;
    }

    public final String e() {
        return this.patchUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateData)) {
            return false;
        }
        UpdateData updateData = (UpdateData) obj;
        return Intrinsics.b(this.bundleUrl, updateData.bundleUrl) && Intrinsics.b(this.hash, updateData.hash) && Intrinsics.b(this.isMandatory, updateData.isMandatory) && this.isUpdateAvailable == updateData.isUpdateAvailable && Intrinsics.b(this.patchUrl, updateData.patchUrl) && Intrinsics.b(this.bundleVersion, updateData.bundleVersion) && Intrinsics.b(this.jsVersion, updateData.jsVersion) && Intrinsics.b(this.rollback, updateData.rollback);
    }

    public final Boolean f() {
        return this.rollback;
    }

    public final boolean g() {
        return this.isUpdateAvailable;
    }

    public final int hashCode() {
        String str = this.bundleUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hash;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isMandatory;
        int iHashCode3 = (Boolean.hashCode(this.isUpdateAvailable) + ((iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31)) * 31;
        String str3 = this.patchUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.bundleVersion;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.jsVersion;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.rollback;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.bundleUrl;
        String str2 = this.hash;
        Boolean bool = this.isMandatory;
        boolean z = this.isUpdateAvailable;
        String str3 = this.patchUrl;
        Integer num = this.bundleVersion;
        Integer num2 = this.jsVersion;
        Boolean bool2 = this.rollback;
        StringBuilder sbV = e.v("UpdateData(bundleUrl=", str, ", hash=", str2, ", isMandatory=");
        sbV.append(bool);
        sbV.append(", isUpdateAvailable=");
        sbV.append(z);
        sbV.append(", patchUrl=");
        sbV.append(str3);
        sbV.append(", bundleVersion=");
        sbV.append(num);
        sbV.append(", jsVersion=");
        sbV.append(num2);
        sbV.append(", rollback=");
        sbV.append(bool2);
        sbV.append(")");
        return sbV.toString();
    }
}
