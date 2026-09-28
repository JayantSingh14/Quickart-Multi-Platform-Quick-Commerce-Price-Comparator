package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhil extends zzhan {

    /* renamed from: a, reason: collision with root package name */
    public final String f33860a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhpw f33861b;

    public /* synthetic */ zzhil(String str, zzhpw zzhpwVar) {
        this.f33860a = str;
        this.f33861b = zzhpwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33861b != zzhpw.RAW;
    }

    public final String toString() {
        int iOrdinal = this.f33861b.ordinal();
        return android.support.v4.media.a.n(new StringBuilder("(typeUrl="), this.f33860a, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }
}
