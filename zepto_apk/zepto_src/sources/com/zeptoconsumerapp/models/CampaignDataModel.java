package com.zeptoconsumerapp.models;

import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class CampaignDataModel {

    @SerializedName("backgroundColor")
    private String backgroundColor;

    @SerializedName("duration")
    private long duration;

    @SerializedName("endDateInEpoch")
    private long endDate;

    @SerializedName("imageAssets")
    private List<SplashScreenAssetModel> imageAssets;

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    private String name;

    @SerializedName("startDateInEpoch")
    private long startDate;

    @SerializedName("visibility")
    private String visibility;

    public final List a() {
        return this.imageAssets;
    }

    public final String b() {
        return this.backgroundColor;
    }

    public final long c() {
        return this.duration;
    }

    public final long d() {
        return this.endDate;
    }

    public final String e() {
        return this.name;
    }

    public final long f() {
        return this.startDate;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CampaignDataModel{name='");
        sb.append(this.name);
        sb.append("', visibility='");
        sb.append(this.visibility);
        sb.append("', assets=");
        sb.append(this.imageAssets);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", backgroundColor=");
        return e.t(sb, this.backgroundColor, '}');
    }
}
