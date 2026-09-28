package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        boolean z = false;
        Bundle bundleCreateBundle = null;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, DetectedActivity.CREATOR);
            } else if (fieldId == 2) {
                j2 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 3) {
                j3 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 4) {
                i2 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult();
        Preconditions.checkArgument(arrayListCreateTypedList != null && arrayListCreateTypedList.size() > 0, "Must have at least 1 detected activity");
        if (j2 > 0 && j3 > 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "Must set times");
        activityRecognitionResult.f38269a = arrayListCreateTypedList;
        activityRecognitionResult.f38270b = j2;
        activityRecognitionResult.f38271c = j3;
        activityRecognitionResult.f38272d = i2;
        activityRecognitionResult.f38273e = bundleCreateBundle;
        return activityRecognitionResult;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityRecognitionResult[i2];
    }
}
