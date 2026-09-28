package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator<UserAddress> {
    @Override // android.os.Parcelable.Creator
    public final UserAddress createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        boolean z = false;
        String strCreateString14 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString14 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 11:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
                case 14:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    strCreateString13 = SafeParcelReader.createString(parcel, header);
                    break;
                case 16:
                    strCreateString12 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        UserAddress userAddress = new UserAddress();
        userAddress.f22536a = strCreateString;
        userAddress.f22537b = strCreateString14;
        userAddress.f22538c = strCreateString2;
        userAddress.f22539d = strCreateString3;
        userAddress.f22540e = strCreateString4;
        userAddress.f22541f = strCreateString5;
        userAddress.f22542g = strCreateString6;
        userAddress.f22543h = strCreateString7;
        userAddress.f22544i = strCreateString8;
        userAddress.f22545j = strCreateString9;
        userAddress.f22546k = strCreateString10;
        userAddress.f22547l = strCreateString11;
        userAddress.f22548m = z;
        userAddress.n = strCreateString13;
        userAddress.o = strCreateString12;
        return userAddress;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ UserAddress[] newArray(int i2) {
        return new UserAddress[i2];
    }
}
