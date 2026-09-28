package com.google.android.gms.internal.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

@SafeParcelable.Class(creator = "LocationRequestInternalCreator")
@SafeParcelable.Reserved({2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1000})
@Deprecated
/* loaded from: classes4.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();

    /* renamed from: a, reason: collision with root package name */
    public final LocationRequest f36676a;

    public zzdd(LocationRequest locationRequest, ArrayList arrayList, boolean z, boolean z2, String str, boolean z3, boolean z4, String str2, long j2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                }
            }
            builder.n = workSource;
        }
        boolean z5 = true;
        if (z) {
            Preconditions.checkArgument(true, "granularity %d must be a Granularity.GRANULARITY_* constant", 1);
            builder.f38333j = 1;
        }
        if (z2) {
            Preconditions.checkArgument(true, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", 2);
            builder.f38334k = 2;
        }
        if (str != null) {
            if (Build.VERSION.SDK_INT < 30) {
                builder.f38335l = str;
            }
        } else if (str2 != null && Build.VERSION.SDK_INT < 30) {
            builder.f38335l = str2;
        }
        if (z3) {
            builder.f38336m = true;
        }
        if (z4) {
            builder.f38331h = true;
        }
        if (j2 != Long.MAX_VALUE) {
            if (j2 != -1 && j2 < 0) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            builder.f38332i = j2;
        }
        this.f36676a = builder.a();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return Objects.equal(this.f36676a, ((zzdd) obj).f36676a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f36676a.hashCode();
    }

    public final String toString() {
        return this.f36676a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f36676a, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
