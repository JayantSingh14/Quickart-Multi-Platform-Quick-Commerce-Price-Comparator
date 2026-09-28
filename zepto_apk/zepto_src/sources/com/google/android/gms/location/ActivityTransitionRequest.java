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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@SafeParcelable.Class(creator = "ActivityTransitionRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzh();

    /* renamed from: e, reason: collision with root package name */
    public static final Comparator f38279e = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public final List f38280a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38281b;

    /* renamed from: c, reason: collision with root package name */
    public final List f38282c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38283d;

    public ActivityTransitionRequest(ArrayList arrayList, String str, ArrayList arrayList2, String str2) {
        Preconditions.checkNotNull(arrayList, "transitions can't be null");
        Preconditions.checkArgument(arrayList.size() > 0, "transitions can't be empty.");
        Preconditions.checkNotNull(arrayList);
        TreeSet treeSet = new TreeSet(f38279e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            Preconditions.checkArgument(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.f38280a = Collections.unmodifiableList(arrayList);
        this.f38281b = str;
        this.f38282c = arrayList2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList2);
        this.f38283d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (Objects.equal(this.f38280a, activityTransitionRequest.f38280a) && Objects.equal(this.f38281b, activityTransitionRequest.f38281b) && Objects.equal(this.f38283d, activityTransitionRequest.f38283d) && Objects.equal(this.f38282c, activityTransitionRequest.f38282c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f38280a.hashCode() * 31;
        String str = this.f38281b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f38282c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f38283d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f38280a);
        String strValueOf2 = String.valueOf(this.f38282c);
        StringBuilder sbY = b.y("ActivityTransitionRequest [mTransitions=", strValueOf, ", mTag='");
        b.B(sbY, this.f38281b, "', mClients=", strValueOf2, ", mAttributionTag=");
        return b.r(sbY, this.f38283d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f38280a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f38281b, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f38282c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38283d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
