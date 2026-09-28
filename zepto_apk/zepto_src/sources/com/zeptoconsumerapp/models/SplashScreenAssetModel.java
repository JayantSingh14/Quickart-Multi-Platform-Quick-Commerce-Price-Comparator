package com.zeptoconsumerapp.models;

import android.support.v4.media.b;
import com.google.gson.annotations.SerializedName;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

/* loaded from: classes4.dex */
public class SplashScreenAssetModel {

    @SerializedName(Snapshot.HEIGHT)
    private int height;

    @SerializedName("localPath")
    private String localPath;

    @SerializedName("splashScreenImageAssetPosition")
    private String splashScreenImageAssetPosition;

    @SerializedName("url")
    private String url;

    @SerializedName(Snapshot.WIDTH)
    private int width;

    public final int a() {
        return this.height;
    }

    public final String b() {
        return this.localPath;
    }

    public final String c() {
        return this.splashScreenImageAssetPosition;
    }

    public final int d() {
        return this.width;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SplashScreenAssetModel{url='");
        sb.append(this.url);
        sb.append("', width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", position='");
        sb.append(this.splashScreenImageAssetPosition);
        sb.append("', localPath='");
        return b.r(sb, this.localPath, "'}");
    }
}
