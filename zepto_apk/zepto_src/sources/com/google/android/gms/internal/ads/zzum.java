package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzum extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final String f35658a;

    /* renamed from: b, reason: collision with root package name */
    public final zzuj f35659b;

    /* renamed from: c, reason: collision with root package name */
    public final String f35660c;

    public zzum(zzv zzvVar, zzuu zzuuVar, int i2) {
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 25 + string.length());
        sb.append("Decoder init failed: [");
        sb.append(i2);
        sb.append("], ");
        sb.append(string);
        String string2 = sb.toString();
        int iAbs = Math.abs(i2);
        this(string2, zzuuVar, zzvVar.f35691m, null, androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iAbs).length() + 60), iAbs, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_"));
    }

    public zzum(String str, Throwable th, String str2, zzuj zzujVar, String str3) {
        super(str, th);
        this.f35658a = str2;
        this.f35659b = zzujVar;
        this.f35660c = str3;
    }
}
