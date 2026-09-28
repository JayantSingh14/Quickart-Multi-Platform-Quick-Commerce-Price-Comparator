package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "SleepSegmentRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class SleepSegmentRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new zzah();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38366a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38367b;

    public SleepSegmentRequest(int i2, ArrayList arrayList) {
        this.f38366a = arrayList;
        this.f38367b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return Objects.equal(this.f38366a, sleepSegmentRequest.f38366a) && this.f38367b == sleepSegmentRequest.f38367b;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38366a, Integer.valueOf(this.f38367b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f38366a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f38367b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
