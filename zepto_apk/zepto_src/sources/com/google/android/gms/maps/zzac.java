package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public final class zzac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        byte b2 = -1;
        byte b3 = -1;
        CameraPosition cameraPosition = null;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        Float floatObject = null;
        Float floatObject2 = null;
        LatLngBounds latLngBounds = null;
        byte b13 = -1;
        Integer integerObject = null;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    b2 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 3:
                    b3 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.createParcelable(parcel, header, CameraPosition.CREATOR);
                    break;
                case 6:
                    b4 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 7:
                    b5 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 8:
                    b6 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 9:
                    b7 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 10:
                    b8 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 11:
                    b9 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 12:
                    b10 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 13:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 14:
                    b11 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 15:
                    b12 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 16:
                    floatObject = SafeParcelReader.readFloatObject(parcel, header);
                    break;
                case 17:
                    floatObject2 = SafeParcelReader.readFloatObject(parcel, header);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, header, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b13 = SafeParcelReader.readByte(parcel, header);
                    break;
                case 20:
                    integerObject = SafeParcelReader.readIntegerObject(parcel, header);
                    break;
                case 21:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        googleMapOptions.f38399c = -1;
        googleMapOptions.n = null;
        googleMapOptions.o = null;
        googleMapOptions.p = null;
        googleMapOptions.r = null;
        googleMapOptions.s = null;
        googleMapOptions.f38397a = com.google.android.gms.maps.internal.zza.b(b2);
        googleMapOptions.f38398b = com.google.android.gms.maps.internal.zza.b(b3);
        googleMapOptions.f38399c = i2;
        googleMapOptions.f38400d = cameraPosition;
        googleMapOptions.f38401e = com.google.android.gms.maps.internal.zza.b(b4);
        googleMapOptions.f38402f = com.google.android.gms.maps.internal.zza.b(b5);
        googleMapOptions.f38403g = com.google.android.gms.maps.internal.zza.b(b6);
        googleMapOptions.f38404h = com.google.android.gms.maps.internal.zza.b(b7);
        googleMapOptions.f38405i = com.google.android.gms.maps.internal.zza.b(b8);
        googleMapOptions.f38406j = com.google.android.gms.maps.internal.zza.b(b9);
        googleMapOptions.f38407k = com.google.android.gms.maps.internal.zza.b(b10);
        googleMapOptions.f38408l = com.google.android.gms.maps.internal.zza.b(b11);
        googleMapOptions.f38409m = com.google.android.gms.maps.internal.zza.b(b12);
        googleMapOptions.n = floatObject;
        googleMapOptions.o = floatObject2;
        googleMapOptions.p = latLngBounds;
        googleMapOptions.q = com.google.android.gms.maps.internal.zza.b(b13);
        googleMapOptions.r = integerObject;
        googleMapOptions.s = strCreateString;
        return googleMapOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleMapOptions[i2];
    }
}
