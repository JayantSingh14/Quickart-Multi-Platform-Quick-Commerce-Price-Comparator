package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgno extends zzgop {

    /* renamed from: a, reason: collision with root package name */
    public int f32990a;

    /* renamed from: b, reason: collision with root package name */
    public String f32991b;

    /* renamed from: c, reason: collision with root package name */
    public int f32992c;

    /* renamed from: d, reason: collision with root package name */
    public byte f32993d;

    public final zzgoq a() {
        if (this.f32993d == 3) {
            return new zzgnp(this.f32990a, this.f32991b, this.f32992c);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f32993d & 1) == 0) {
            sb.append(" statusCode");
        }
        if ((this.f32993d & 2) == 0) {
            sb.append(" uiMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
