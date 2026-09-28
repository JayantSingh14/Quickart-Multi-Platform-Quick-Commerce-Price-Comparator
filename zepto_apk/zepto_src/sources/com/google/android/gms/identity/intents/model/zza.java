package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zza implements Parcelable.Creator<CountrySpecification> {
    @Override // android.os.Parcelable.Creator
    public final CountrySpecification createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                strCreateString = SafeParcelReader.createString(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        CountrySpecification countrySpecification = new CountrySpecification();
        countrySpecification.f22535a = strCreateString;
        return countrySpecification;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CountrySpecification[] newArray(int i2) {
        return new CountrySpecification[i2];
    }
}
