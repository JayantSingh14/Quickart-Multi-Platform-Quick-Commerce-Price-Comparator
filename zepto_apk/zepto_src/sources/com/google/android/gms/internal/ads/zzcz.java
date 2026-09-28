package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzcz {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgux f27441a = new zzgry();

    static {
        zzgvs zzgvsVar = zzgtd.f33183b;
        new zzcz(zzguy.f33232e);
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzcz(zzgtd zzgtdVar) {
        zzgvs zzgvsVar = zzgtd.f33183b;
        Object[] array = (zzgtdVar == null ? zzgud.a(zzgtdVar.listIterator(0)) : zzgtdVar).toArray();
        int length = array.length;
        zzguw.a(length, array);
        Arrays.sort(array, f27441a);
        zzgtd.t(length, array);
    }
}
