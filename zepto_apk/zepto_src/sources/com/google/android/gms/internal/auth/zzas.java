package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 1:
                zzc.b(parcel);
                throw new UnsupportedOperationException();
            case 2:
                zzc.b(parcel);
                throw new UnsupportedOperationException();
            case 3:
                zzc.b(parcel);
                throw new UnsupportedOperationException();
            case 4:
                zze();
                throw null;
            case 5:
                Status status = (Status) zzc.a(parcel, Status.CREATOR);
                zzc.b(parcel);
                Y6(status);
                return true;
            case 6:
                byte[] bArrCreateByteArray = parcel.createByteArray();
                zzc.b(parcel);
                I3(bArrCreateByteArray);
                return true;
            case 7:
                DeviceMetaData deviceMetaData = (DeviceMetaData) zzc.a(parcel, DeviceMetaData.CREATOR);
                zzc.b(parcel);
                M1(deviceMetaData);
                return true;
            default:
                return false;
        }
    }
}
