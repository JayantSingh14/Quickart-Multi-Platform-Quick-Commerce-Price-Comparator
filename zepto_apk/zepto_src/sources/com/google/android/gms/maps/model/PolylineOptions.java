package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StrokeStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class PolylineOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38524a;

    /* renamed from: b, reason: collision with root package name */
    public float f38525b;

    /* renamed from: c, reason: collision with root package name */
    public int f38526c;

    /* renamed from: d, reason: collision with root package name */
    public float f38527d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f38528e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f38529f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38530g;

    /* renamed from: h, reason: collision with root package name */
    public Cap f38531h;

    /* renamed from: i, reason: collision with root package name */
    public Cap f38532i;

    /* renamed from: j, reason: collision with root package name */
    public final int f38533j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f38534k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f38535l;

    public PolylineOptions() {
        this.f38525b = 10.0f;
        this.f38526c = -16777216;
        this.f38527d = 0.0f;
        this.f38528e = true;
        this.f38529f = false;
        this.f38530g = false;
        this.f38531h = new ButtCap();
        this.f38532i = new ButtCap();
        this.f38533j = 0;
        this.f38534k = null;
        this.f38535l = new ArrayList();
        this.f38524a = new ArrayList();
    }

    public final void A(boolean z) {
        this.f38529f = z;
    }

    public final void N(ArrayList arrayList) {
        this.f38534k = arrayList;
    }

    public final void Z(Cap cap) {
        this.f38531h = (Cap) Preconditions.checkNotNull(cap, "startCap must not be null");
    }

    public final void b(List list) {
        Preconditions.checkNotNull(list, "points must not be null.");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f38524a.add((LatLng) it.next());
        }
    }

    public final void l0(float f2) {
        this.f38525b = f2;
    }

    public final void n0(float f2) {
        this.f38527d = f2;
    }

    public final void r(int i2) {
        this.f38526c = i2;
    }

    public final void s(Cap cap) {
        this.f38532i = (Cap) Preconditions.checkNotNull(cap, "endCap must not be null");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f38524a, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.f38525b);
        SafeParcelWriter.writeInt(parcel, 4, this.f38526c);
        SafeParcelWriter.writeFloat(parcel, 5, this.f38527d);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f38528e);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f38529f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f38530g);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f38531h.b(), i2, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f38532i.b(), i2, false);
        SafeParcelWriter.writeInt(parcel, 11, this.f38533j);
        SafeParcelWriter.writeTypedList(parcel, 12, this.f38534k, false);
        ArrayList<StyleSpan> arrayList = this.f38535l;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (StyleSpan styleSpan : arrayList) {
            StrokeStyle strokeStyle = styleSpan.f38558a;
            StrokeStyle.Builder builder = new StrokeStyle.Builder();
            builder.f38556a = strokeStyle.f38551a;
            Pair pair = new Pair(Integer.valueOf(strokeStyle.f38552b), Integer.valueOf(strokeStyle.f38553c));
            int iIntValue = ((Integer) pair.first).intValue();
            int iIntValue2 = ((Integer) pair.second).intValue();
            builder.f38556a = this.f38525b;
            builder.f38557b = this.f38528e;
            arrayList2.add(new StyleSpan(new StrokeStyle(builder.f38556a, iIntValue, iIntValue2, builder.f38557b, strokeStyle.f38555e), styleSpan.f38559b));
        }
        SafeParcelWriter.writeTypedList(parcel, 13, arrayList2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public PolylineOptions(ArrayList arrayList, float f2, int i2, float f3, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int i3, ArrayList arrayList2, ArrayList arrayList3) {
        this.f38525b = 10.0f;
        this.f38526c = -16777216;
        this.f38527d = 0.0f;
        this.f38528e = true;
        this.f38529f = false;
        this.f38530g = false;
        this.f38531h = new ButtCap();
        this.f38532i = new ButtCap();
        this.f38533j = 0;
        this.f38534k = null;
        this.f38535l = new ArrayList();
        this.f38524a = arrayList;
        this.f38525b = f2;
        this.f38526c = i2;
        this.f38527d = f3;
        this.f38528e = z;
        this.f38529f = z2;
        this.f38530g = z3;
        if (cap != null) {
            this.f38531h = cap;
        }
        if (cap2 != null) {
            this.f38532i = cap2;
        }
        this.f38533j = i3;
        this.f38534k = arrayList2;
        if (arrayList3 != null) {
            this.f38535l = arrayList3;
        }
    }
}
