package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzv implements Parcelable.Creator<zzr.zzb.zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb.zza createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            int i5 = 1;
            if (fieldId != 1) {
                i5 = 2;
                if (fieldId != 2) {
                    i5 = 3;
                    if (fieldId != 3) {
                        SafeParcelReader.skipUnknownField(parcel, header);
                    } else {
                        i4 = SafeParcelReader.readInt(parcel, header);
                    }
                } else {
                    i3 = SafeParcelReader.readInt(parcel, header);
                }
            } else {
                i2 = SafeParcelReader.readInt(parcel, header);
            }
            hashSet.add(Integer.valueOf(i5));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zzb.zza(hashSet, i2, i3, i4);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb.zza[] newArray(int i2) {
        return new zzr.zzb.zza[i2];
    }
}
