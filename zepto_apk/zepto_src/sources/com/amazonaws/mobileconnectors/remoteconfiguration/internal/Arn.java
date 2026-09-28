package com.amazonaws.mobileconnectors.remoteconfiguration.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;

/* loaded from: classes3.dex */
public class Arn {

    /* renamed from: a, reason: collision with root package name */
    public final String f15264a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15265b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15266c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15267d;

    /* renamed from: e, reason: collision with root package name */
    public final String f15268e;

    public Arn(String str, String str2, String str3, String str4, String str5) {
        this.f15264a = str;
        this.f15265b = str2;
        this.f15266c = str3;
        this.f15267d = str4;
        this.f15268e = str5;
    }

    public static Arn fromArn(String str) {
        String[] strArrSplit = str.split(":", 6);
        if (strArrSplit.length != 6) {
            throw new IllegalArgumentException("Invalid ARN");
        }
        String[] strArrSplit2 = strArrSplit[5].split("[:/]", 2);
        return new Arn(strArrSplit[2], strArrSplit[3], strArrSplit[4], strArrSplit2[0], strArrSplit2[1]);
    }

    public String getAccount() {
        return this.f15266c;
    }

    public String getId() {
        return this.f15268e;
    }

    public String getRegion() {
        return this.f15265b;
    }

    public String getType() {
        return this.f15267d;
    }

    public String getVendor() {
        return this.f15264a;
    }

    public String toArn() {
        String str = this.f15264a;
        String str2 = this.f15265b;
        String str3 = this.f15266c;
        String str4 = this.f15267d;
        String str5 = this.f15268e;
        StringBuilder sbV = e.v("arn:aws:", str, ":", str2, ":");
        b.B(sbV, str3, ":", str4, ":");
        sbV.append(str5);
        return sbV.toString();
    }
}
