package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SleepClassifyEventCreator")
/* loaded from: classes4.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new zzaf();

    /* renamed from: a, reason: collision with root package name */
    public final int f38352a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38353b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38354c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38355d;

    /* renamed from: e, reason: collision with root package name */
    public final int f38356e;

    /* renamed from: f, reason: collision with root package name */
    public final int f38357f;

    /* renamed from: g, reason: collision with root package name */
    public final int f38358g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f38359h;

    /* renamed from: i, reason: collision with root package name */
    public final int f38360i;

    public SleepClassifyEvent(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, int i9) {
        this.f38352a = i2;
        this.f38353b = i3;
        this.f38354c = i4;
        this.f38355d = i5;
        this.f38356e = i6;
        this.f38357f = i7;
        this.f38358g = i8;
        this.f38359h = z;
        this.f38360i = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f38352a == sleepClassifyEvent.f38352a && this.f38353b == sleepClassifyEvent.f38353b;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38352a), Integer.valueOf(this.f38353b));
    }

    public final String toString() {
        return this.f38352a + " Conf:" + this.f38353b + " Motion:" + this.f38354c + " Light:" + this.f38355d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38352a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38353b);
        SafeParcelWriter.writeInt(parcel, 3, this.f38354c);
        SafeParcelWriter.writeInt(parcel, 4, this.f38355d);
        SafeParcelWriter.writeInt(parcel, 5, this.f38356e);
        SafeParcelWriter.writeInt(parcel, 6, this.f38357f);
        SafeParcelWriter.writeInt(parcel, 7, this.f38358g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f38359h);
        SafeParcelWriter.writeInt(parcel, 9, this.f38360i);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
