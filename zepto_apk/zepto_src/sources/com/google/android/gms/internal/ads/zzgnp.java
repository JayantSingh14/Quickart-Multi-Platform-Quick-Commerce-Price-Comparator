package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgnp extends zzgoq {

    /* renamed from: a, reason: collision with root package name */
    public final int f32994a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32995b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32996c;

    public /* synthetic */ zzgnp(int i2, String str, int i3) {
        this.f32994a = i2;
        this.f32995b = str;
        this.f32996c = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgoq
    public final int a() {
        return this.f32994a;
    }

    @Override // com.google.android.gms.internal.ads.zzgoq
    public final String b() {
        return this.f32995b;
    }

    @Override // com.google.android.gms.internal.ads.zzgoq
    public final int c() {
        return this.f32996c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoq)) {
            return false;
        }
        zzgoq zzgoqVar = (zzgoq) obj;
        if (this.f32994a != zzgoqVar.a()) {
            return false;
        }
        String str = this.f32995b;
        if (str == null) {
            if (zzgoqVar.b() != null) {
                return false;
            }
        } else if (!str.equals(zzgoqVar.b())) {
            return false;
        }
        return this.f32996c == zzgoqVar.c();
    }

    public final int hashCode() {
        String str = this.f32995b;
        return (((str == null ? 0 : str.hashCode()) ^ ((this.f32994a ^ 1000003) * 1000003)) * 1000003) ^ this.f32996c;
    }

    public final String toString() {
        int i2 = this.f32994a;
        int length = String.valueOf(i2).length();
        String str = this.f32995b;
        int length2 = String.valueOf(str).length();
        int i3 = this.f32996c;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 9 + String.valueOf(i3).length() + 1);
        sb.append("OverlayDisplayState{statusCode=");
        sb.append(i2);
        sb.append(", sessionToken=");
        sb.append(str);
        return androidx.fragment.app.e.u(sb, ", uiMode=", i3, "}");
    }
}
