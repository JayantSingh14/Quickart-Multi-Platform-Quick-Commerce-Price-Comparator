package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        boolean z = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        double d2 = 0.0d;
        ArrayList arrayListCreateTypedList = null;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, header, LatLng.CREATOR);
                    break;
                case 3:
                    d2 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 4:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    f3 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f38447a = latLng;
        circleOptions.f38448b = d2;
        circleOptions.f38449c = f2;
        circleOptions.f38450d = i2;
        circleOptions.f38451e = i3;
        circleOptions.f38452f = f3;
        circleOptions.f38453g = z2;
        circleOptions.f38454h = z;
        circleOptions.f38455i = arrayListCreateTypedList;
        return circleOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new CircleOptions[i2];
    }
}
