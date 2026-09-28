package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhb extends zzgz {
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ zzha a(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.f36415e) {
            return zzhaVar;
        }
        zzha zzhaVarA = zzha.a();
        zzevVar.zzc = zzhaVarA;
        return zzhaVarA;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ zzha b(Object obj) {
        return ((zzev) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final Object c(Object obj, Object obj2) {
        zzha zzhaVar = zzha.f36415e;
        if (!zzhaVar.equals(obj2)) {
            if (zzhaVar.equals(obj)) {
                zzha zzhaVar2 = (zzha) obj2;
                zzha zzhaVar3 = (zzha) obj;
                int i2 = zzhaVar3.f36416a + zzhaVar2.f36416a;
                int[] iArrCopyOf = Arrays.copyOf(zzhaVar3.f36417b, i2);
                System.arraycopy(zzhaVar2.f36417b, 0, iArrCopyOf, zzhaVar3.f36416a, zzhaVar2.f36416a);
                Object[] objArrCopyOf = Arrays.copyOf(zzhaVar3.f36418c, i2);
                System.arraycopy(zzhaVar2.f36418c, 0, objArrCopyOf, zzhaVar3.f36416a, zzhaVar2.f36416a);
                return new zzha(i2, iArrCopyOf, objArrCopyOf, true);
            }
            zzha zzhaVar4 = (zzha) obj2;
            zzha zzhaVar5 = (zzha) obj;
            zzhaVar5.getClass();
            if (!zzhaVar4.equals(zzhaVar)) {
                if (!zzhaVar5.f36419d) {
                    throw new UnsupportedOperationException();
                }
                int i3 = zzhaVar5.f36416a + zzhaVar4.f36416a;
                zzhaVar5.c(i3);
                System.arraycopy(zzhaVar4.f36417b, 0, zzhaVar5.f36417b, zzhaVar5.f36416a, zzhaVar4.f36416a);
                System.arraycopy(zzhaVar4.f36418c, 0, zzhaVar5.f36418c, zzhaVar5.f36416a, zzhaVar4.f36416a);
                zzhaVar5.f36416a = i3;
                return obj;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ void d(Object obj, int i2, long j2) {
        ((zzha) obj).b(i2 << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final void e(Object obj) {
        zzha zzhaVar = ((zzev) obj).zzc;
        if (zzhaVar.f36419d) {
            zzhaVar.f36419d = false;
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ void f(Object obj, Object obj2) {
        ((zzev) obj).zzc = (zzha) obj2;
    }
}
