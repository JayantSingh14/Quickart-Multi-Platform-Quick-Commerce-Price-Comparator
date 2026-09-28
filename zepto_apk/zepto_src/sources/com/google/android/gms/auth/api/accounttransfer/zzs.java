package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.collection.ArrayMap;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferProgressCreator")
/* loaded from: classes4.dex */
public final class zzs extends zzbz {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayMap f22040g;

    /* renamed from: a, reason: collision with root package name */
    public final int f22041a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f22042b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f22043c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f22044d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f22045e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f22046f;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f22040g = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
        arrayMap.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
        arrayMap.put(APayConstants.SUCCESS, FastJsonResponse.Field.forStrings(APayConstants.SUCCESS, 4));
        arrayMap.put("failed", FastJsonResponse.Field.forStrings("failed", 5));
        arrayMap.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
    }

    public zzs() {
        this.f22041a = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return f22040g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.f22041a);
            case 2:
                return this.f22042b;
            case 3:
                return this.f22043c;
            case 4:
                return this.f22044d;
            case 5:
                return this.f22045e;
            case 6:
                return this.f22046f;
            default:
                throw new IllegalStateException(b.f(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.f22042b = arrayList;
            return;
        }
        if (safeParcelableFieldId == 3) {
            this.f22043c = arrayList;
            return;
        }
        if (safeParcelableFieldId == 4) {
            this.f22044d = arrayList;
        } else if (safeParcelableFieldId == 5) {
            this.f22045e = arrayList;
        } else {
            if (safeParcelableFieldId != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(safeParcelableFieldId)));
            }
            this.f22046f = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22041a);
        SafeParcelWriter.writeStringList(parcel, 2, this.f22042b, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.f22043c, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.f22044d, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.f22045e, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.f22046f, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzs(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        this.f22041a = i2;
        this.f22042b = arrayList;
        this.f22043c = arrayList2;
        this.f22044d = arrayList3;
        this.f22045e = arrayList4;
        this.f22046f = arrayList5;
    }
}
