package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzc {

    /* renamed from: b, reason: collision with root package name */
    public static final zzc f25783b = new zzc(new zza[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final zza f25784c;

    /* renamed from: a, reason: collision with root package name */
    public final zza[] f25785a;

    static {
        zza zzaVar = new zza(-1, new int[0], new zzak[0], new long[0], new String[0], new zzb[0]);
        int[] iArr = zzaVar.f22572d;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = zzaVar.f22573e;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        zzak[] zzakVarArr = (zzak[]) Arrays.copyOf(zzaVar.f22571c, 0);
        String[] strArr = (String[]) Arrays.copyOf(zzaVar.f22574f, 0);
        zzb[] zzbVarArr = zzaVar.f22575g;
        f25784c = new zza(0, iArrCopyOf, zzakVarArr, jArrCopyOf, strArr, (zzb[]) Arrays.copyOf(zzbVarArr, Math.max(0, zzbVarArr.length)));
        String str = zzfj.f31254a;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public zzc(zza[] zzaVarArr) {
        this.f25785a = zzaVarArr;
    }

    public final zza a(int i2) {
        return i2 < 0 ? f25784c : this.f25785a[i2];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzc.class == obj.getClass() && Arrays.equals(this.f25785a, ((zzc) obj).f25785a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f25785a) + (((int) (-9223372036854775807L)) * 961);
    }

    public final String toString() {
        return android.support.v4.media.b.C("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[", "])");
    }
}
