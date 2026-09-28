package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        View view;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        int i3 = 0;
        float f8 = 1.0f;
        float f9 = 0.5f;
        LatLng latLng = null;
        String strCreateString = null;
        String strCreateString2 = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String strCreateString3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, header, LatLng.CREATOR);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 6:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    f3 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    f4 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 12:
                    f9 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 13:
                    f5 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 14:
                    f8 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 15:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 16:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 17:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 18:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 19:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 20:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 21:
                    f7 = SafeParcelReader.readFloat(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.f38490e = 0.5f;
        markerOptions.f38491f = 1.0f;
        markerOptions.f38493h = true;
        markerOptions.f38494i = false;
        markerOptions.f38495j = 0.0f;
        markerOptions.f38496k = 0.5f;
        markerOptions.f38497l = 0.0f;
        markerOptions.f38498m = 1.0f;
        markerOptions.o = 0;
        markerOptions.f38486a = latLng;
        markerOptions.f38487b = strCreateString;
        markerOptions.f38488c = strCreateString2;
        if (iBinder == null) {
            view = null;
            markerOptions.f38489d = null;
        } else {
            view = null;
            markerOptions.f38489d = new BitmapDescriptor(IObjectWrapper.Stub.g(iBinder));
        }
        markerOptions.f38490e = f2;
        markerOptions.f38491f = f3;
        markerOptions.f38492g = z;
        markerOptions.f38493h = z2;
        markerOptions.f38494i = z3;
        markerOptions.f38495j = f4;
        markerOptions.f38496k = f9;
        markerOptions.f38497l = f5;
        markerOptions.f38498m = f8;
        markerOptions.n = f6;
        markerOptions.q = i3;
        markerOptions.o = i2;
        IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(iBinder2);
        markerOptions.p = iObjectWrapperG == null ? view : (View) ObjectWrapper.z0(iObjectWrapperG);
        markerOptions.r = strCreateString3;
        markerOptions.s = f7;
        return markerOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new MarkerOptions[i2];
    }
}
