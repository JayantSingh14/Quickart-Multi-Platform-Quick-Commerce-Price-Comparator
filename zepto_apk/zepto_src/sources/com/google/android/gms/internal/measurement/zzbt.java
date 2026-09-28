package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzbt extends zzbz {

    /* renamed from: a, reason: collision with root package name */
    public String f36805a;

    /* renamed from: b, reason: collision with root package name */
    public byte f36806b;

    /* renamed from: c, reason: collision with root package name */
    public int f36807c;

    /* renamed from: d, reason: collision with root package name */
    public int f36808d;

    public final zzca a() {
        if (this.f36806b == 1 && this.f36805a != null && this.f36807c != 0 && this.f36808d != 0) {
            return new zzbu(this.f36805a, this.f36807c, this.f36808d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f36805a == null) {
            sb.append(" fileOwner");
        }
        if (this.f36806b == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.f36807c == 0) {
            sb.append(" fileChecks");
        }
        if (this.f36808d == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
