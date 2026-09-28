package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransition extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final int f38274a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38275b;

    public static class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    public ActivityTransition(int i2, int i3) {
        this.f38274a = i2;
        this.f38275b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f38274a == activityTransition.f38274a && this.f38275b == activityTransition.f38275b;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38274a), Integer.valueOf(this.f38275b));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityTransition [mActivityType=");
        sb.append(this.f38274a);
        sb.append(", mTransitionType=");
        return b.o(sb, this.f38275b, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38274a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38275b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
