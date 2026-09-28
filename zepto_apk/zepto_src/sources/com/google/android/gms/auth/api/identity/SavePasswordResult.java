package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SavePasswordResultCreator")
@Deprecated
/* loaded from: classes4.dex */
public class SavePasswordResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SavePasswordResult> CREATOR = new zbq();

    /* renamed from: a, reason: collision with root package name */
    public final PendingIntent f22118a;

    public SavePasswordResult(PendingIntent pendingIntent) {
        this.f22118a = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SavePasswordResult) {
            return Objects.equal(this.f22118a, ((SavePasswordResult) obj).f22118a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22118a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22118a, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
