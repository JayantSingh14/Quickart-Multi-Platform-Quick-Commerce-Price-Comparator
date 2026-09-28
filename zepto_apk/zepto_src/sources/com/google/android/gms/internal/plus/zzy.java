package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzy implements Parcelable.Creator<zzr.zzd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzd createFromParcel(Parcel parcel) {
        int i2;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, header);
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
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    i2 = 7;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    continue;
            }
            hashSet.add(Integer.valueOf(i2));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zzd(hashSet, i3, strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, strCreateString6);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzd[] newArray(int i2) {
        return new zzr.zzd[i2];
    }
}
