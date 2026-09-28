package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* loaded from: classes4.dex */
final class zzgnn extends zzgoo {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f32984a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32985b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32986c;

    /* renamed from: d, reason: collision with root package name */
    public final float f32987d;

    /* renamed from: e, reason: collision with root package name */
    public final int f32988e;

    /* renamed from: f, reason: collision with root package name */
    public final String f32989f;

    public /* synthetic */ zzgnn(IBinder iBinder, String str, int i2, float f2, int i3, String str2) {
        this.f32984a = iBinder;
        this.f32985b = str;
        this.f32986c = i2;
        this.f32987d = f2;
        this.f32988e = i3;
        this.f32989f = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final IBinder a() {
        return this.f32984a;
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final String b() {
        return this.f32985b;
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final int c() {
        return this.f32986c;
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final float d() {
        return this.f32987d;
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final int e() {
        return this.f32988e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoo)) {
            return false;
        }
        zzgoo zzgooVar = (zzgoo) obj;
        if (!this.f32984a.equals(zzgooVar.a())) {
            return false;
        }
        String str = this.f32985b;
        if (str == null) {
            if (zzgooVar.b() != null) {
                return false;
            }
        } else if (!str.equals(zzgooVar.b())) {
            return false;
        }
        if (this.f32986c != zzgooVar.c() || Float.floatToIntBits(this.f32987d) != Float.floatToIntBits(zzgooVar.d()) || this.f32988e != zzgooVar.e()) {
            return false;
        }
        String str2 = this.f32989f;
        return str2 == null ? zzgooVar.f() == null : str2.equals(zzgooVar.f());
    }

    @Override // com.google.android.gms.internal.ads.zzgoo
    public final String f() {
        return this.f32989f;
    }

    public final int hashCode() {
        int iHashCode = this.f32984a.hashCode() ^ 1000003;
        String str = this.f32985b;
        int iHashCode2 = (((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f32986c) * 1000003) ^ Float.floatToIntBits(this.f32987d);
        String str2 = this.f32989f;
        return ((((iHashCode2 * 1525764945) ^ this.f32988e) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        String string = this.f32984a.toString();
        int length = string.length();
        String str = this.f32985b;
        int length2 = String.valueOf(str).length();
        int i2 = this.f32986c;
        int length3 = String.valueOf(i2).length();
        float f2 = this.f32987d;
        int length4 = String.valueOf(f2).length();
        int i3 = this.f32988e;
        int length5 = String.valueOf(i3).length();
        String str2 = this.f32989f;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 16 + length3 + 23 + length4 + 65 + length5 + 33 + String.valueOf(str2).length() + 30);
        android.support.v4.media.b.B(sb, "OverlayDisplayShowRequest{windowToken=", string, ", appId=", str);
        sb.append(", layoutGravity=");
        sb.append(i2);
        sb.append(", layoutVerticalMargin=");
        sb.append(f2);
        sb.append(", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=");
        sb.append(i3);
        sb.append(", deeplinkUrl=null, adFieldEnifd=");
        sb.append(str2);
        sb.append(", thirdPartyAuthCallerId=null}");
        return sb.toString();
    }
}
