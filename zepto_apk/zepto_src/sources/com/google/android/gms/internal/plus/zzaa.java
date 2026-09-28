package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzaa implements Parcelable.Creator<zzr.zzf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzf createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String strCreateString = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            int i3 = 1;
            if (fieldId != 1) {
                i3 = 2;
                if (fieldId != 2) {
                    i3 = 3;
                    if (fieldId != 3) {
                        SafeParcelReader.skipUnknownField(parcel, header);
                    } else {
                        strCreateString = SafeParcelReader.createString(parcel, header);
                    }
                } else {
                    z = SafeParcelReader.readBoolean(parcel, header);
                }
            } else {
                i2 = SafeParcelReader.readInt(parcel, header);
            }
            hashSet.add(Integer.valueOf(i3));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zzf(hashSet, i2, z, strCreateString);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzf[] newArray(int i2) {
        return new zzr.zzf[i2];
    }
}
