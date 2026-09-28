package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzaz extends zzaw {

    /* renamed from: a, reason: collision with root package name */
    public final String f37530a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37531b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f37532c;

    public zzaz(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("Null advertisingId");
        }
        this.f37530a = str;
        this.f37531b = str2;
        this.f37532c = z;
    }

    @Override // com.google.android.gms.internal.pal.zzaw
    public final String a() {
        return this.f37530a;
    }

    @Override // com.google.android.gms.internal.pal.zzaw
    public final String b() {
        return this.f37531b;
    }

    @Override // com.google.android.gms.internal.pal.zzaw
    public final boolean c() {
        return this.f37532c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzawVar = (zzaw) obj;
        return this.f37530a.equals(zzawVar.a()) && this.f37531b.equals(zzawVar.b()) && this.f37532c == zzawVar.c();
    }

    public final int hashCode() {
        return ((((this.f37530a.hashCode() ^ 1000003) * 1000003) ^ this.f37531b.hashCode()) * 1000003) ^ (true != this.f37532c ? 1237 : 1231);
    }

    public final String toString() {
        return "AdvertisingIdInfo{advertisingId=" + this.f37530a + ", advertisingIdType=" + this.f37531b + ", isLimitAdTracking=" + this.f37532c + "}";
    }
}
