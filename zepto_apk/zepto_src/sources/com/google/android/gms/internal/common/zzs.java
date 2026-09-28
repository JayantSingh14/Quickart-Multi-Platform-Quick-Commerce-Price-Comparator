package com.google.android.gms.internal.common;

/* loaded from: classes4.dex */
final class zzs extends zzv {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzp f36500g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzw zzwVar, String str, zzp zzpVar) {
        super(zzwVar, str);
        this.f36500g = zzpVar;
    }

    @Override // com.google.android.gms.internal.common.zzv
    public final int b(int i2) {
        String str = this.f36504c;
        int length = str.length();
        zzr.b(i2, length);
        while (i2 < length) {
            if (str.charAt(i2) == ((zzm) this.f36500g).f36498a) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzv
    public final int c(int i2) {
        return i2 + 1;
    }
}
