package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgqg extends zzgqn {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgpo f33072f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgqg(CharSequence charSequence, zzgpo zzgpoVar) {
        super(charSequence);
        this.f33072f = zzgpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqn
    public final int b(int i2) {
        CharSequence charSequence = this.f33078c;
        int length = charSequence.length();
        zzgqa.j(i2, length);
        while (i2 < length) {
            if (this.f33072f.a(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgqn
    public final int c(int i2) {
        return i2 + 1;
    }
}
