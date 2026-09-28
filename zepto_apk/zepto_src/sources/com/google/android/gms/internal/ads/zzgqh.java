package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* loaded from: classes4.dex */
final class zzgqh extends zzgqn {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgpp f33073f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgqh(CharSequence charSequence, zzgpp zzgppVar) {
        super(charSequence);
        this.f33073f = zzgppVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqn
    public final int b(int i2) {
        Matcher matcher = ((zzgps) this.f33073f).f33055a;
        if (matcher.find(i2)) {
            return matcher.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgqn
    public final int c(int i2) {
        return ((zzgps) this.f33073f).f33055a.end();
    }
}
