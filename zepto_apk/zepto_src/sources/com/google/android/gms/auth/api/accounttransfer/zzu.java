package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import in.juspay.airborne.ota.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
/* loaded from: classes4.dex */
public final class zzu extends zzbz {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f22047g;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f22048a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22049b;

    /* renamed from: c, reason: collision with root package name */
    public zzw f22050c;

    /* renamed from: d, reason: collision with root package name */
    public String f22051d;

    /* renamed from: e, reason: collision with root package name */
    public String f22052e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22053f;

    static {
        HashMap map = new HashMap();
        f22047g = map;
        map.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzw.class));
        map.put("signature", FastJsonResponse.Field.forString("signature", 3));
        map.put(Constants.PACKAGE_DIR_NAME, FastJsonResponse.Field.forString(Constants.PACKAGE_DIR_NAME, 4));
    }

    public zzu() {
        this.f22048a = new HashSet(3);
        this.f22049b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.f22050c = (zzw) fastJsonResponse;
        this.f22048a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f22047g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.f22049b);
        }
        if (safeParcelableFieldId == 2) {
            return this.f22050c;
        }
        if (safeParcelableFieldId == 3) {
            return this.f22051d;
        }
        if (safeParcelableFieldId == 4) {
            return this.f22052e;
        }
        throw new IllegalStateException(b.f(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f22048a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.f22051d = str2;
        } else {
            if (safeParcelableFieldId != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
            }
            this.f22052e = str2;
        }
        this.f22048a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        HashSet hashSet = this.f22048a;
        if (hashSet.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.f22049b);
        }
        if (hashSet.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.f22050c, i2, true);
        }
        if (hashSet.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.f22051d, true);
        }
        if (hashSet.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.f22052e, true);
        }
        if (hashSet.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.f22053f, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzu(HashSet hashSet, int i2, zzw zzwVar, String str, String str2, String str3) {
        this.f22048a = hashSet;
        this.f22049b = i2;
        this.f22050c = zzwVar;
        this.f22051d = str;
        this.f22052e = str2;
        this.f22053f = str3;
    }
}
