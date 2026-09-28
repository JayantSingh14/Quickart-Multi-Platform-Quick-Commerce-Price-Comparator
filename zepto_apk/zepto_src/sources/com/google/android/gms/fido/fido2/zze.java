package com.google.android.gms.fido.fido2;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zze implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzg zzgVar = new zzg((TaskCompletionSource) obj2);
        com.google.android.gms.internal.fido.zzs zzsVar = (com.google.android.gms.internal.fido.zzs) ((com.google.android.gms.internal.fido.zzp) obj).getService();
        Parcel parcelG = zzsVar.g();
        ClassLoader classLoader = com.google.android.gms.internal.fido.zzc.f36612a;
        parcelG.writeStrongBinder(zzgVar);
        parcelG.writeInt(0);
        zzsVar.z0(2, parcelG);
    }
}
