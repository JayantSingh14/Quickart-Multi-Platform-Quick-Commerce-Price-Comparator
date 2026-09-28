package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 3:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, header, LatLng.CREATOR);
                    break;
                case 4:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 5:
                    f3 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, header, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f4 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    f5 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 11:
                    f7 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 12:
                    f8 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 13:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        groundOverlayOptions.f38468h = true;
        groundOverlayOptions.f38469i = 0.0f;
        groundOverlayOptions.f38470j = 0.5f;
        groundOverlayOptions.f38471k = 0.5f;
        groundOverlayOptions.f38472l = false;
        groundOverlayOptions.f38461a = new BitmapDescriptor(IObjectWrapper.Stub.g(iBinder));
        groundOverlayOptions.f38462b = latLng;
        groundOverlayOptions.f38463c = f2;
        groundOverlayOptions.f38464d = f3;
        groundOverlayOptions.f38465e = latLngBounds;
        groundOverlayOptions.f38466f = f4;
        groundOverlayOptions.f38467g = f5;
        groundOverlayOptions.f38468h = z;
        groundOverlayOptions.f38469i = f6;
        groundOverlayOptions.f38470j = f7;
        groundOverlayOptions.f38471k = f8;
        groundOverlayOptions.f38472l = z2;
        return groundOverlayOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GroundOverlayOptions[i2];
    }
}
