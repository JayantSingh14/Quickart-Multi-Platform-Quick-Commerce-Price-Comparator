package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zzx implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        int i2 = 102;
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = 0;
        long j5 = Long.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        long j7 = -1;
        String strCreateString = null;
        com.google.android.gms.internal.location.zzd zzdVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    j3 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 4:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 5:
                    j5 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    j4 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    j6 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 11:
                    j7 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, header, WorkSource.CREATOR);
                    break;
                case 17:
                    zzdVar = (com.google.android.gms.internal.location.zzd) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.location.zzd.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new LocationRequest(i2, j2, j3, j4, j5, j6, i3, f2, z, j7, i4, i5, strCreateString, z2, workSource, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}
