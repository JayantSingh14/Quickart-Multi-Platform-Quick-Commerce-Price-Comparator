package com.google.android.gms.fido.fido2;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzl implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzq zzqVar = new zzq((TaskCompletionSource) obj2);
        com.google.android.gms.internal.fido.zzn zznVar = (com.google.android.gms.internal.fido.zzn) ((com.google.android.gms.internal.fido.zzk) obj).getService();
        Parcel parcelG = zznVar.g();
        ClassLoader classLoader = com.google.android.gms.internal.fido.zzc.f36612a;
        parcelG.writeStrongBinder(zzqVar);
        parcelG.writeInt(0);
        zznVar.z0(1, parcelG);
    }
}
