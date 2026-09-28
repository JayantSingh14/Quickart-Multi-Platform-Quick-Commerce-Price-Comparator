package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzgpo implements zzgqb {
    public static zzgpo b(char c2) {
        return new zzgpl(c2);
    }

    public abstract boolean a(char c2);

    @Override // com.google.android.gms.internal.ads.zzgqb
    public final /* synthetic */ boolean zza(Object obj) {
        return a(((Character) obj).charValue());
    }
}
