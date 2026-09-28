package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        String strCreateString = null;
        zzr[] zzrVarArr = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    zzrVarArr = (zzr[]) SafeParcelReader.createTypedArray(parcel, header, zzr.CREATOR);
                    break;
                case 9:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z4 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z5 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzr(strCreateString, i2, i3, z, i4, i5, zzrVarArr, z2, z3, z4, z5, z6, z7, z8, z9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzr[i2];
    }
}
