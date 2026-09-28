package com.google.android.gms.ads.internal.util.client;

import androidx.fragment.app.e;

/* loaded from: classes4.dex */
final class zzm extends zzw {

    /* renamed from: a, reason: collision with root package name */
    public final int f21435a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21436b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21437c;

    public zzm(int i2, int i3, boolean z) {
        this.f21435a = i2;
        this.f21436b = i3;
        this.f21437c = z;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int a() {
        return this.f21435a;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int b() {
        return this.f21436b;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final boolean c() {
        return this.f21437c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzw)) {
            return false;
        }
        zzw zzwVar = (zzw) obj;
        return this.f21435a == zzwVar.a() && this.f21436b == zzwVar.b() && this.f21437c == zzwVar.c();
    }

    public final int hashCode() {
        return (true != this.f21437c ? 1237 : 1231) ^ ((((this.f21435a ^ 1000003) * 1000003) ^ this.f21436b) * 1000003);
    }

    public final String toString() {
        int i2 = this.f21435a;
        int length = String.valueOf(i2).length();
        int i3 = this.f21436b;
        int length2 = String.valueOf(i3).length();
        boolean z = this.f21437c;
        StringBuilder sb = new StringBuilder(length + 59 + length2 + 26 + String.valueOf(z).length() + 1);
        e.w(i2, i3, "OfflineAdConfig{impressionPrerequisite=", ", clickPrerequisite=", sb);
        sb.append(", notificationFlowEnabled=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
