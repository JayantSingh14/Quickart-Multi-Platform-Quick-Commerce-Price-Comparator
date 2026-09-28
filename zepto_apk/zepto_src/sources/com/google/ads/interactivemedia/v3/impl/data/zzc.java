package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.annotation.Nullable;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.CompanionAd;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.api.UniversalAdId;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagi;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import com.google.ads.interactivemedia.v3.internal.zzagl;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzc implements Ad {

    @Nullable
    private String adId;

    @Nullable
    private String adSystem;

    @Nullable
    private com.google.ads.interactivemedia.v3.api.zza adUi;

    @Nullable
    private String advertiserName;

    @Nullable
    private String clickThroughUrl;

    @Nullable
    private String contentType;

    @Nullable
    private String creativeAdId;

    @Nullable
    private String creativeId;

    @Nullable
    private String dealId;

    @Nullable
    private String description;
    private boolean disableUi;
    private double duration;
    private int height;

    @Nullable
    private String surveyUrl;

    @Nullable
    private String title;

    @Nullable
    private String traffickingParameters;

    @Nullable
    @zzagl
    @zzagi
    private Set<UiElement> uiElements;

    @Nullable
    private String universalAdIdRegistry;

    @Nullable
    private String universalAdIdValue;
    private int vastMediaBitrate;
    private int vastMediaHeight;
    private int vastMediaWidth;
    private int width;
    private boolean linear = false;
    private boolean skippable = false;
    private double skipTimeOffset = -1.0d;

    @zzagl
    @zzagi
    private zzd adPodInfo = new zzd();

    @Nullable
    @zzagl
    @zzagi
    private zzbi[] companions = null;

    @Nullable
    @zzagl
    @zzagi
    private String[] adWrapperIds = null;

    @Nullable
    @zzagl
    @zzagi
    private String[] adWrapperSystems = null;

    @Nullable
    @zzagl
    @zzagi
    private String[] adWrapperCreativeIds = null;

    @Nullable
    @zzagl
    @zzagi
    private zzcx[] universalAdIds = null;

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, "vastMediaBitrate", "vastMediaHeight", "vastMediaWidth");
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getAdId() {
        return this.adId;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public AdPodInfo getAdPodInfo() {
        return this.adPodInfo;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getAdSystem() {
        return this.adSystem;
    }

    public com.google.ads.interactivemedia.v3.api.zza getAdUi() {
        return this.adUi;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String[] getAdWrapperCreativeIds() {
        return this.adWrapperCreativeIds;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String[] getAdWrapperIds() {
        return this.adWrapperIds;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String[] getAdWrapperSystems() {
        return this.adWrapperSystems;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getAdvertiserName() {
        return this.advertiserName;
    }

    public String getClickThruUrl() {
        return this.clickThroughUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public List<CompanionAd> getCompanionAds() {
        zzbi[] zzbiVarArr = this.companions;
        return zzbiVarArr != null ? Arrays.asList(zzbiVarArr) : Arrays.asList(new CompanionAd[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getCreativeAdId() {
        return this.creativeAdId;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getCreativeId() {
        return this.creativeId;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getDealId() {
        return this.dealId;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getDescription() {
        return this.description;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public double getDuration() {
        return this.duration;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public int getHeight() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public double getSkipTimeOffset() {
        return this.skipTimeOffset;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getSurveyUrl() {
        return this.surveyUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getTitle() {
        return this.title;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getTraffickingParameters() {
        return this.traffickingParameters;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public Set<UiElement> getUiElements() {
        return this.uiElements;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getUniversalAdIdRegistry() {
        return this.universalAdIdRegistry;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public String getUniversalAdIdValue() {
        return this.universalAdIdValue;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public UniversalAdId[] getUniversalAdIds() {
        return this.universalAdIds;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public int getVastMediaBitrate() {
        return this.vastMediaBitrate;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public int getVastMediaHeight() {
        return this.vastMediaHeight;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public int getVastMediaWidth() {
        return this.vastMediaWidth;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public boolean isLinear() {
        return this.linear;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public boolean isSkippable() {
        return this.skippable;
    }

    @Override // com.google.ads.interactivemedia.v3.api.Ad
    public boolean isUiDisabled() {
        return this.disableUi;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdPodInfo(zzd zzdVar) {
        this.adPodInfo = zzdVar;
    }

    public void setAdSystem(String str) {
        this.adSystem = str;
    }

    public void setAdUi(com.google.ads.interactivemedia.v3.api.zza zzaVar) {
        this.adUi = zzaVar;
    }

    public void setAdWrapperCreativeIds(String[] strArr) {
        this.adWrapperCreativeIds = strArr;
    }

    public void setAdWrapperIds(String[] strArr) {
        this.adWrapperIds = strArr;
    }

    public void setAdWrapperSystems(String[] strArr) {
        this.adWrapperSystems = strArr;
    }

    public void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public void setClickThruUrl(String str) {
        this.clickThroughUrl = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCreativeAdId(String str) {
        this.creativeAdId = str;
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDealId(String str) {
        this.dealId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuration(double d2) {
        this.duration = d2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setLinear(boolean z) {
        this.linear = z;
    }

    public void setSkipTimeOffset(double d2) {
        this.skipTimeOffset = d2;
    }

    public void setSkippable(boolean z) {
        this.skippable = z;
    }

    public void setSurveyUrl(String str) {
        this.surveyUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTraffickingParameters(String str) {
        this.traffickingParameters = str;
    }

    public void setUiDisabled(boolean z) {
        this.disableUi = z;
    }

    public void setUiElements(Set<UiElement> set) {
        this.uiElements = set;
    }

    public void setUniversalAdIdRegistry(String str) {
        this.universalAdIdRegistry = str;
    }

    public void setUniversalAdIdValue(String str) {
        this.universalAdIdValue = str;
    }

    public void setUniversalAdIds(zzcx[] zzcxVarArr) {
        this.universalAdIds = zzcxVarArr;
    }

    public void setVastMediaBitrate(int i2) {
        this.vastMediaBitrate = i2;
    }

    public void setVastMediaHeight(int i2) {
        this.vastMediaHeight = i2;
    }

    public void setVastMediaWidth(int i2) {
        this.vastMediaWidth = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public String toString() {
        String str = this.adId;
        String str2 = this.creativeId;
        String str3 = this.creativeAdId;
        String str4 = this.universalAdIdValue;
        String str5 = this.universalAdIdRegistry;
        String str6 = this.title;
        String str7 = this.description;
        String str8 = this.contentType;
        String string = Arrays.toString(this.adWrapperIds);
        String string2 = Arrays.toString(this.adWrapperSystems);
        String string3 = Arrays.toString(this.adWrapperCreativeIds);
        String str9 = this.adSystem;
        String str10 = this.advertiserName;
        String str11 = this.surveyUrl;
        String str12 = this.dealId;
        boolean z = this.linear;
        boolean z2 = this.skippable;
        int i2 = this.width;
        int i3 = this.height;
        int i4 = this.vastMediaHeight;
        int i5 = this.vastMediaWidth;
        int i6 = this.vastMediaBitrate;
        String str13 = this.traffickingParameters;
        String str14 = this.clickThroughUrl;
        double d2 = this.duration;
        String strValueOf = String.valueOf(this.adPodInfo);
        String strValueOf2 = String.valueOf(this.uiElements);
        boolean z3 = this.disableUi;
        double d3 = this.skipTimeOffset;
        StringBuilder sbV = e.v("Ad [adId=", str, ", creativeId=", str2, ", creativeAdId=");
        b.B(sbV, str3, ", universalAdIdValue=", str4, ", universalAdIdRegistry=");
        b.B(sbV, str5, ", title=", str6, ", description=");
        b.B(sbV, str7, ", contentType=", str8, ", adWrapperIds=");
        b.B(sbV, string, ", adWrapperSystems=", string2, ", adWrapperCreativeIds=");
        b.B(sbV, string3, ", adSystem=", str9, ", advertiserName=");
        b.B(sbV, str10, ", surveyUrl=", str11, ", dealId=");
        sbV.append(str12);
        sbV.append(", linear=");
        sbV.append(z);
        sbV.append(", skippable=");
        sbV.append(z2);
        sbV.append(", width=");
        sbV.append(i2);
        sbV.append(", height=");
        a.q(i3, i4, ", vastMediaHeight=", ", vastMediaWidth=", sbV);
        a.q(i5, i6, ", vastMediaBitrate=", ", traffickingParameters=", sbV);
        b.B(sbV, str13, ", clickThroughUrl=", str14, ", duration=");
        sbV.append(d2);
        sbV.append(", adPodInfo=");
        sbV.append(strValueOf);
        sbV.append(", uiElements=");
        sbV.append(strValueOf2);
        sbV.append(", disableUi=");
        sbV.append(z3);
        sbV.append(", skipTimeOffset=");
        sbV.append(d3);
        sbV.append("]");
        return sbV.toString();
    }
}
