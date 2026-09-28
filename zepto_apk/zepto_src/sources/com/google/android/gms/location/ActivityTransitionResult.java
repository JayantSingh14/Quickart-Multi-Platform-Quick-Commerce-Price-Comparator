package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ActivityTransitionResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final List f38284a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f38285b;

    public ActivityTransitionResult(ArrayList arrayList, Bundle bundle) {
        this.f38285b = null;
        Preconditions.checkNotNull(arrayList, "transitionEvents list can't be null.");
        if (!arrayList.isEmpty()) {
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                Preconditions.checkArgument(((ActivityTransitionEvent) arrayList.get(i2)).f38278c >= ((ActivityTransitionEvent) arrayList.get(i2 + (-1))).f38278c);
            }
        }
        this.f38284a = Collections.unmodifiableList(arrayList);
        this.f38285b = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f38284a.equals(((ActivityTransitionResult) obj).f38284a);
    }

    public final int hashCode() {
        return this.f38284a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f38284a, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.f38285b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
