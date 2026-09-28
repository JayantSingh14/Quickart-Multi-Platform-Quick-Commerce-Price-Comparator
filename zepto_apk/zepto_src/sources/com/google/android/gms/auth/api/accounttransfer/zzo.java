package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferMsgCreator")
/* loaded from: classes4.dex */
public final class zzo extends zzbz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f22034f;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f22035a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22036b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f22037c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22038d;

    /* renamed from: e, reason: collision with root package name */
    public zzs f22039e;

    static {
        HashMap map = new HashMap();
        f22034f = map;
        map.put("authenticatorData", FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzu.class));
        map.put(ReactProgressBarViewManager.PROP_PROGRESS, FastJsonResponse.Field.forConcreteType(ReactProgressBarViewManager.PROP_PROGRESS, 4, zzs.class));
    }

    public zzo() {
        this.f22035a = new HashSet(1);
        this.f22036b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(safeParcelableFieldId), arrayList.getClass().getCanonicalName()));
        }
        this.f22037c = arrayList;
        this.f22035a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.f22039e = (zzs) fastJsonResponse;
        this.f22035a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f22034f;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.f22036b);
        }
        if (safeParcelableFieldId == 2) {
            return this.f22037c;
        }
        if (safeParcelableFieldId == 4) {
            return this.f22039e;
        }
        throw new IllegalStateException(b.f(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f22035a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        HashSet hashSet = this.f22035a;
        if (hashSet.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.f22036b);
        }
        if (hashSet.contains(2)) {
            SafeParcelWriter.writeTypedList(parcel, 2, this.f22037c, true);
        }
        if (hashSet.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.f22038d);
        }
        if (hashSet.contains(4)) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.f22039e, i2, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzo(HashSet hashSet, int i2, ArrayList arrayList, int i3, zzs zzsVar) {
        this.f22035a = hashSet;
        this.f22036b = i2;
        this.f22037c = arrayList;
        this.f22038d = i3;
        this.f22039e = zzsVar;
    }
}
