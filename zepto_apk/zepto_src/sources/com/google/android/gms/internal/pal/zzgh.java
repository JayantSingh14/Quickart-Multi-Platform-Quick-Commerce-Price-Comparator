package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzgh implements zzgp {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgi f37754a;

    public zzgh(zzgi zzgiVar) {
        this.f37754a = zzgiVar;
    }

    @Override // com.google.android.gms.internal.pal.zzgp
    public final Boolean zza(String str, boolean z) {
        zzgi zzgiVar = this.f37754a;
        try {
            return Boolean.valueOf(zzgiVar.f37759e.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(zzgiVar.f37759e.getString(str, String.valueOf(z)));
        }
    }
}
