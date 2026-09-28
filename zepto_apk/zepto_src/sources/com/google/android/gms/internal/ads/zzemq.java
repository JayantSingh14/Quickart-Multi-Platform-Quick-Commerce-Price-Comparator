package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzemq {

    /* renamed from: a, reason: collision with root package name */
    public final String f29796a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29797b;

    /* renamed from: c, reason: collision with root package name */
    public int f29798c;

    /* renamed from: d, reason: collision with root package name */
    public long f29799d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f29800e;

    public zzemq(String str, String str2, int i2, long j2, Integer num) {
        this.f29796a = str;
        this.f29797b = str2;
        this.f29798c = i2;
        this.f29799d = j2;
        this.f29800e = num;
    }

    public final String toString() {
        Integer num;
        int i2 = this.f29798c;
        long j2 = this.f29799d;
        String str = this.f29796a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(i2).length() + 1 + String.valueOf(j2).length());
        sb.append(str);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(i2);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(j2);
        String string = sb.toString();
        String str2 = this.f29797b;
        if (!TextUtils.isEmpty(str2)) {
            string = android.support.v4.media.b.s(new StringBuilder(string.length() + 1 + String.valueOf(str2).length()), string, CLConstants.DOT_SALT_DELIMETER, str2);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X1)).booleanValue() || (num = this.f29800e) == null || TextUtils.isEmpty(str2)) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder(string.length() + 1 + num.toString().length());
        sb2.append(string);
        sb2.append(CLConstants.DOT_SALT_DELIMETER);
        sb2.append(num);
        return sb2.toString();
    }
}
