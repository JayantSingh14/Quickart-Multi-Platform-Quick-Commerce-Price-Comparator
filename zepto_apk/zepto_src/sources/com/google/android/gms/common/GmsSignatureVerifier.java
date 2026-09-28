package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzah;
import com.google.android.gms.internal.common.zzai;
import com.google.android.gms.internal.common.zzal;
import java.util.HashMap;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes4.dex */
public class GmsSignatureVerifier {
    private static final zzab zza;
    private static final zzab zzb;
    private static final HashMap zzc;

    static {
        zzaa zzaaVar = new zzaa();
        zzaaVar.zza("com.google.android.gms");
        zzaaVar.zzb(204200000L);
        zzm zzmVar = zzo.zzf;
        byte[] bArrZzc = zzmVar.zzc();
        byte[] bArrZzc2 = zzo.zzd.zzc();
        byte[] bArrZzc3 = zzo.zzb.zzc();
        zzal zzalVar = zzah.f36487b;
        Object[] objArr = {bArrZzc, bArrZzc2, bArrZzc3};
        zzai.a(3, objArr);
        zzaaVar.zzc(zzah.r(3, objArr));
        zzm zzmVar2 = zzo.zze;
        byte[] bArrZzc4 = zzmVar2.zzc();
        zzm zzmVar3 = zzo.zzc;
        Object[] objArr2 = {bArrZzc4, zzmVar3.zzc(), zzo.zza.zzc()};
        zzai.a(3, objArr2);
        zzaaVar.zzd(zzah.r(3, objArr2));
        zza = zzaaVar.zze();
        zzaa zzaaVar2 = new zzaa();
        zzaaVar2.zza("com.android.vending");
        zzaaVar2.zzb(82240000L);
        Object[] objArr3 = {zzmVar.zzc()};
        zzai.a(1, objArr3);
        zzaaVar2.zzc(zzah.r(1, objArr3));
        Object[] objArr4 = {zzmVar2.zzc(), zzmVar3.zzc()};
        zzai.a(2, objArr4);
        zzaaVar2.zzd(zzah.r(2, objArr4));
        zzb = zzaaVar2.zze();
        zzc = new HashMap();
    }
}
