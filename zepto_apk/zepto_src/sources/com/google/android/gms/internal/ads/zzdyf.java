package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzdyf extends zzdyj {

    /* renamed from: a, reason: collision with root package name */
    public long f28786a;

    /* renamed from: b, reason: collision with root package name */
    public int f28787b;

    /* renamed from: c, reason: collision with root package name */
    public byte f28788c;

    public final zzdyk a() {
        if (this.f28788c == 3) {
            return new zzdyg(this.f28786a, this.f28787b);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f28788c & 1) == 0) {
            sb.append(" id");
        }
        if ((this.f28788c & 2) == 0) {
            sb.append(" eventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
