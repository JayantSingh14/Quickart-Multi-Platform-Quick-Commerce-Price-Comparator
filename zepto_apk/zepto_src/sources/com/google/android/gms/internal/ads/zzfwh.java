package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfwh extends zzfwn {

    /* renamed from: a, reason: collision with root package name */
    public String f31971a;

    /* renamed from: b, reason: collision with root package name */
    public byte f31972b;

    /* renamed from: c, reason: collision with root package name */
    public int f31973c;

    /* renamed from: d, reason: collision with root package name */
    public int f31974d;

    public final zzfwo a() {
        if (this.f31972b == 1 && this.f31971a != null && this.f31973c != 0 && this.f31974d != 0) {
            return new zzfwi(this.f31971a, this.f31973c, this.f31974d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f31971a == null) {
            sb.append(" fileOwner");
        }
        if (this.f31972b == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.f31973c == 0) {
            sb.append(" fileChecks");
        }
        if (this.f31974d == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
