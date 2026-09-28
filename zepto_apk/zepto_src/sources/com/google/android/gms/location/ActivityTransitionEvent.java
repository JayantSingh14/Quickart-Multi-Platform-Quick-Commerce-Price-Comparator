package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.apache.commons.lang3.StringUtils;

@SafeParcelable.Class(creator = "ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    public final int f38276a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38277b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38278c;

    public ActivityTransitionEvent(int i2, int i3, long j2) {
        Parcelable.Creator<ActivityTransition> creator = ActivityTransition.CREATOR;
        boolean z = false;
        if (i3 >= 0 && i3 <= 1) {
            z = true;
        }
        Preconditions.checkArgument(z, "Transition type " + i3 + " is not valid.");
        this.f38276a = i2;
        this.f38277b = i3;
        this.f38278c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f38276a == activityTransitionEvent.f38276a && this.f38277b == activityTransitionEvent.f38277b && this.f38278c == activityTransitionEvent.f38278c;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38276a), Integer.valueOf(this.f38277b), Long.valueOf(this.f38278c));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityType " + this.f38276a);
        sb.append(StringUtils.SPACE);
        sb.append("TransitionType " + this.f38277b);
        sb.append(StringUtils.SPACE);
        sb.append("ElapsedRealTimeNanos " + this.f38278c);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38276a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38277b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38278c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
