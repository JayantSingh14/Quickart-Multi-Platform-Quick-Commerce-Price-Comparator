package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
/* loaded from: classes4.dex */
public final class zzw extends zzbz {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f22054h;

    /* renamed from: a, reason: collision with root package name */
    public final Set f22055a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22056b;

    /* renamed from: c, reason: collision with root package name */
    public String f22057c;

    /* renamed from: d, reason: collision with root package name */
    public int f22058d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f22059e;

    /* renamed from: f, reason: collision with root package name */
    public final PendingIntent f22060f;

    /* renamed from: g, reason: collision with root package name */
    public final DeviceMetaData f22061g;

    static {
        HashMap map = new HashMap();
        f22054h = map;
        map.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        map.put(CLConstants.OTP_STATUS, FastJsonResponse.Field.forInteger(CLConstants.OTP_STATUS, 3));
        map.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    public zzw() {
        this.f22055a = new ArraySet(3);
        this.f22056b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f22054h;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.f22056b);
        }
        if (safeParcelableFieldId == 2) {
            return this.f22057c;
        }
        if (safeParcelableFieldId == 3) {
            return Integer.valueOf(this.f22058d);
        }
        if (safeParcelableFieldId == 4) {
            return this.f22059e;
        }
        throw new IllegalStateException(b.f(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f22055a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 4) {
            throw new IllegalArgumentException(b.g(safeParcelableFieldId, "Field with id=", " is not known to be a byte array."));
        }
        this.f22059e = bArr;
        this.f22055a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 3) {
            throw new IllegalArgumentException(b.g(safeParcelableFieldId, "Field with id=", " is not known to be an int."));
        }
        this.f22058d = i2;
        this.f22055a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
        }
        this.f22057c = str2;
        this.f22055a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.f22055a;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.f22056b);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.f22057c, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.f22058d);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.f22059e, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.f22060f, i2, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.f22061g, i2, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzw(HashSet hashSet, int i2, String str, int i3, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f22055a = hashSet;
        this.f22056b = i2;
        this.f22057c = str;
        this.f22058d = i3;
        this.f22059e = bArr;
        this.f22060f = pendingIntent;
        this.f22061g = deviceMetaData;
    }
}
