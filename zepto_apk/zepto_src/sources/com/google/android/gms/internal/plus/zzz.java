package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzz implements Parcelable.Creator<zzr.zze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zze createFromParcel(Parcel parcel) {
        int i2;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        boolean z = false;
        int i3 = 0;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    i2 = 1;
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    i2 = 2;
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    i2 = 3;
                    break;
                case 4:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    i2 = 4;
                    break;
                case 5:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    i2 = 5;
                    break;
                case 6:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    i2 = 6;
                    break;
                case 7:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    i2 = 7;
                    break;
                case 8:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    i2 = 8;
                    break;
                case 9:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    i2 = 9;
                    break;
                case 10:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    i2 = 10;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    continue;
            }
            hashSet.add(Integer.valueOf(i2));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zze(hashSet, i4, strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, z, strCreateString6, strCreateString7, i3);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zze[] newArray(int i2) {
        return new zzr.zze[i2];
    }
}
