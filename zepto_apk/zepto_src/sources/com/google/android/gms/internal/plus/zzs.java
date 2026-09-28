package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzs implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int i2;
        int i3;
        int i4;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        boolean z2 = false;
        String strCreateString = null;
        zzr.zza zzaVar = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzr.zzb zzbVar = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        zzr.zzc zzcVar = null;
        String strCreateString7 = null;
        zzr.zzd zzdVar = null;
        String strCreateString8 = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateTypedList2 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        ArrayList arrayListCreateTypedList3 = null;
        int i10 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    i2 = 1;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    i2 = 2;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 3:
                    i3 = i10;
                    zzaVar = (zzr.zza) SafeParcelReader.createParcelable(parcel, header, zzr.zza.CREATOR);
                    i4 = 3;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    i2 = 4;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 5:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    i2 = 5;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 6:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    i2 = 6;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 7:
                    i3 = i10;
                    zzbVar = (zzr.zzb) SafeParcelReader.createParcelable(parcel, header, zzr.zzb.CREATOR);
                    i4 = 7;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 8:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    i2 = 8;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 9:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    i2 = 9;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 12:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    i2 = 12;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 14:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    i2 = 14;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 15:
                    i3 = i10;
                    zzcVar = (zzr.zzc) SafeParcelReader.createParcelable(parcel, header, zzr.zzc.CREATOR);
                    i4 = 15;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 16:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    i2 = 16;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 18:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    i2 = 18;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 19:
                    i3 = i10;
                    zzdVar = (zzr.zzd) SafeParcelReader.createParcelable(parcel, header, zzr.zzd.CREATOR);
                    i4 = 19;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 20:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    i2 = 20;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 21:
                    i7 = SafeParcelReader.readInt(parcel, header);
                    i2 = 21;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 22:
                    i3 = i10;
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzr.zze.CREATOR);
                    i4 = 22;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 23:
                    i3 = i10;
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, zzr.zzf.CREATOR);
                    i4 = 23;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 24:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    i2 = 24;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 25:
                    i9 = SafeParcelReader.readInt(parcel, header);
                    i2 = 25;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 26:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    i2 = 26;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 27:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    i2 = 27;
                    hashSet.add(Integer.valueOf(i2));
                    break;
                case 28:
                    i3 = i10;
                    arrayListCreateTypedList3 = SafeParcelReader.createTypedList(parcel, header, zzr.zzg.CREATOR);
                    i4 = 28;
                    hashSet.add(Integer.valueOf(i4));
                    i10 = i3;
                    break;
                case 29:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    i2 = 29;
                    hashSet.add(Integer.valueOf(i2));
                    break;
            }
        }
        int i11 = i10;
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr(hashSet, i11, strCreateString, zzaVar, strCreateString2, strCreateString3, i5, zzbVar, strCreateString4, strCreateString5, i6, strCreateString6, zzcVar, z, strCreateString7, zzdVar, strCreateString8, i7, arrayListCreateTypedList, arrayListCreateTypedList2, i8, i9, strCreateString9, strCreateString10, arrayListCreateTypedList3, z2);
        }
        throw new SafeParcelReader.ParseException(e.m(37, iValidateObjectHeader, "Overread allowed size end="), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i2) {
        return new zzr[i2];
    }
}
