package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzab implements Parcelable.Creator<zzr.zzg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzg createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String strCreateString = null;
        String strCreateString2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            int i4 = 1;
            if (fieldId != 1) {
                i4 = 3;
                if (fieldId != 3) {
                    i4 = 4;
                    if (fieldId != 4) {
                        i4 = 5;
                        if (fieldId != 5) {
                            i4 = 6;
                            if (fieldId != 6) {
                                SafeParcelReader.skipUnknownField(parcel, header);
                            } else {
                                i2 = SafeParcelReader.readInt(parcel, header);
                            }
                        } else {
                            strCreateString = SafeParcelReader.createString(parcel, header);
                        }
                    } else {
                        strCreateString2 = SafeParcelReader.createString(parcel, header);
                    }
                } else {
                    SafeParcelReader.readInt(parcel, header);
                }
            } else {
                i3 = SafeParcelReader.readInt(parcel, header);
            }
            hashSet.add(Integer.valueOf(i4));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zzg(hashSet, i3, strCreateString, i2, strCreateString2);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzg[] newArray(int i2) {
        return new zzr.zzg[i2];
    }
}
