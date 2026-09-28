package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzyb implements zzuv {
    private final zzvw zza;
    private final zztq zzb;
    private final zzvy zzc;
    private final zzxi zzd;
    private final List zze;

    public zzyb(zzvw zzvwVar, zztq zztqVar, zzvy zzvyVar, zzxi zzxiVar, List list) {
        this.zza = zzvwVar;
        this.zzb = zztqVar;
        this.zzc = zzvyVar;
        this.zzd = zzxiVar;
        this.zze = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void zzb(Object obj, AccessibleObject accessibleObject) {
        if (true == Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!zzwq.zza(accessibleObject, obj)) {
            throw new zzud(zzaab.zze(accessibleObject, true).concat(" is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019b  */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.ads.interactivemedia.v3.internal.zzxz zzc(com.google.ads.interactivemedia.v3.internal.zztx r26, com.google.ads.interactivemedia.v3.internal.zzaao r27, java.lang.Class r28, boolean r29, boolean r30) throws java.lang.SecurityException, com.google.ads.interactivemedia.v3.internal.zzud {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzyb.zzc(com.google.ads.interactivemedia.v3.internal.zztx, com.google.ads.interactivemedia.v3.internal.zzaao, java.lang.Class, boolean, boolean):com.google.ads.interactivemedia.v3.internal.zzxz");
    }

    private static IllegalArgumentException zzd(Class cls, String str, Field field, Field field2) {
        String name = cls.getName();
        throw new IllegalArgumentException(android.support.v4.media.a.n(e.v("Class ", name, " declares multiple JSON fields named '", str, "'; conflict is caused by fields "), zzaab.zzd(field), " and ", zzaab.zzd(field2), "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#duplicate-fields"));
    }

    private final boolean zze(Field field, boolean z) {
        return !this.zzc.zzd(field, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class clsZzc = zzaaoVar.zzc();
        if (!Object.class.isAssignableFrom(clsZzc)) {
            return null;
        }
        if (zzaab.zzj(clsZzc)) {
            return new zzxu(this);
        }
        int iZze = zzwq.zze(this.zze, clsZzc);
        if (iZze == 4) {
            throw new zzud(b.D("ReflectionAccessFilter does not permit using reflection for ", String.valueOf(clsZzc), ". Register a TypeAdapter for this type or adjust the access filter."));
        }
        boolean z = iZze == 3;
        return zzaab.zzk(clsZzc) ? new zzya(clsZzc, zzc(zztxVar, zzaaoVar, clsZzc, z, true), z) : new zzxy(this.zza.zza(zzaaoVar), zzc(zztxVar, zzaaoVar, clsZzc, z, false));
    }
}
