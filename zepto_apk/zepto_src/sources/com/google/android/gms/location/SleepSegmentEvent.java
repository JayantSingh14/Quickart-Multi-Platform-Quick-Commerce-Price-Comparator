package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SleepSegmentEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new zzag();

    /* renamed from: a, reason: collision with root package name */
    public final long f38361a;

    /* renamed from: b, reason: collision with root package name */
    public final long f38362b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38363c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38364d;

    /* renamed from: e, reason: collision with root package name */
    public final int f38365e;

    public SleepSegmentEvent(int i2, int i3, int i4, long j2, long j3) {
        Preconditions.checkArgument(j2 <= j3, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.f38361a = j2;
        this.f38362b = j3;
        this.f38363c = i2;
        this.f38364d = i3;
        this.f38365e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f38361a == sleepSegmentEvent.f38361a && this.f38362b == sleepSegmentEvent.f38362b && this.f38363c == sleepSegmentEvent.f38363c && this.f38364d == sleepSegmentEvent.f38364d && this.f38365e == sleepSegmentEvent.f38365e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f38361a), Long.valueOf(this.f38362b), Integer.valueOf(this.f38363c));
    }

    public final String toString() {
        return "startMillis=" + this.f38361a + ", endMillis=" + this.f38362b + ", status=" + this.f38363c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f38361a);
        SafeParcelWriter.writeLong(parcel, 2, this.f38362b);
        SafeParcelWriter.writeInt(parcel, 3, this.f38363c);
        SafeParcelWriter.writeInt(parcel, 4, this.f38364d);
        SafeParcelWriter.writeInt(parcel, 5, this.f38365e);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
