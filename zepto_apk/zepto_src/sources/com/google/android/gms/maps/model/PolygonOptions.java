package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "PolygonOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class PolygonOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzq();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38512a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f38513b;

    /* renamed from: c, reason: collision with root package name */
    public float f38514c;

    /* renamed from: d, reason: collision with root package name */
    public int f38515d;

    /* renamed from: e, reason: collision with root package name */
    public int f38516e;

    /* renamed from: f, reason: collision with root package name */
    public float f38517f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f38518g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f38519h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f38520i;

    /* renamed from: j, reason: collision with root package name */
    public final int f38521j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f38522k;

    public PolygonOptions() {
        this.f38514c = 10.0f;
        this.f38515d = -16777216;
        this.f38516e = 0;
        this.f38517f = 0.0f;
        this.f38518g = true;
        this.f38519h = false;
        this.f38520i = false;
        this.f38521j = 0;
        this.f38522k = null;
        this.f38512a = new ArrayList();
        this.f38513b = new ArrayList();
    }

    public final void A(boolean z) {
        this.f38519h = z;
    }

    public final void N(int i2) {
        this.f38515d = i2;
    }

    public final void Z(ArrayList arrayList) {
        this.f38522k = arrayList;
    }

    public final void b(List list) {
        Preconditions.checkNotNull(list, "points must not be null.");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f38512a.add((LatLng) it.next());
        }
    }

    public final void l0(float f2) {
        this.f38514c = f2;
    }

    public final void n0(float f2) {
        this.f38517f = f2;
    }

    public final void r(Iterable iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add((LatLng) it.next());
        }
        this.f38513b.add(arrayList);
    }

    public final void s(int i2) {
        this.f38516e = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f38512a, false);
        SafeParcelWriter.writeList(parcel, 3, this.f38513b, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38514c);
        SafeParcelWriter.writeInt(parcel, 5, this.f38515d);
        SafeParcelWriter.writeInt(parcel, 6, this.f38516e);
        SafeParcelWriter.writeFloat(parcel, 7, this.f38517f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f38518g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f38519h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f38520i);
        SafeParcelWriter.writeInt(parcel, 11, this.f38521j);
        SafeParcelWriter.writeTypedList(parcel, 12, this.f38522k, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public PolygonOptions(ArrayList arrayList, ArrayList arrayList2, float f2, int i2, int i3, float f3, boolean z, boolean z2, boolean z3, int i4, ArrayList arrayList3) {
        this.f38512a = arrayList;
        this.f38513b = arrayList2;
        this.f38514c = f2;
        this.f38515d = i2;
        this.f38516e = i3;
        this.f38517f = f3;
        this.f38518g = z;
        this.f38519h = z2;
        this.f38520i = z3;
        this.f38521j = i4;
        this.f38522k = arrayList3;
    }
}
