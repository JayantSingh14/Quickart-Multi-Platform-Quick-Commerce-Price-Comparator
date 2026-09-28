package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaki implements zzafv {

    /* renamed from: b, reason: collision with root package name */
    public static final zzaki f23372b = new zzaki(true);

    /* renamed from: c, reason: collision with root package name */
    public static final zzaki f23373c = new zzaki(false);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f23374a;

    public zzaki(boolean z) {
        this.f23374a = z;
    }

    public final String toString() {
        boolean z = !this.f23374a;
        StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 33);
        sb.append("IncorrectFragmentation{expected=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
