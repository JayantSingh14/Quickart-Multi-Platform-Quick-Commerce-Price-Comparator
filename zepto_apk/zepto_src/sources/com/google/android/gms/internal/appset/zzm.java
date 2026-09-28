package com.google.android.gms.internal.appset;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzm implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzg zzgVar = (zzg) ((zzd) obj).getService();
        com.google.android.gms.appset.zza zzaVar = new com.google.android.gms.appset.zza(null, null);
        zzo zzoVar = new zzo((TaskCompletionSource) obj2);
        zzgVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.appset.internal.IAppSetService");
        int i2 = zzc.f36009a;
        parcelObtain.writeInt(1);
        zzaVar.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(zzoVar);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            zzgVar.f36008a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
