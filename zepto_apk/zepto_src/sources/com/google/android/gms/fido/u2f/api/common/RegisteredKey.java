package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SafeParcelable.Class(creator = "RegisteredKeyCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class RegisteredKey extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RegisteredKey> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final KeyHandle f22511a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22512b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22513c;

    public RegisteredKey(KeyHandle keyHandle, String str, String str2) {
        this.f22511a = (KeyHandle) Preconditions.checkNotNull(keyHandle);
        this.f22513c = str;
        this.f22512b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisteredKey)) {
            return false;
        }
        RegisteredKey registeredKey = (RegisteredKey) obj;
        String str = this.f22513c;
        if (str == null) {
            if (registeredKey.f22513c != null) {
                return false;
            }
        } else if (!str.equals(registeredKey.f22513c)) {
            return false;
        }
        if (!this.f22511a.equals(registeredKey.f22511a)) {
            return false;
        }
        String str2 = registeredKey.f22512b;
        String str3 = this.f22512b;
        if (str3 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str3.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f22513c;
        int iHashCode = this.f22511a.hashCode() + (((str == null ? 0 : str.hashCode()) + 31) * 31);
        String str2 = this.f22512b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() throws JSONException {
        KeyHandle keyHandle = this.f22511a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(keyHandle.f22491b, 11));
            ProtocolVersion protocolVersion = keyHandle.f22492c;
            if (protocolVersion != ProtocolVersion.UNKNOWN) {
                jSONObject.put("version", protocolVersion.f22496a);
            }
            ArrayList arrayList = keyHandle.f22493d;
            if (arrayList != null) {
                jSONObject.put("transports", arrayList.toString());
            }
            String str = this.f22513c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f22512b;
            if (str2 != null) {
                jSONObject.put(CLConstants.SALT_FIELD_APP_ID, str2);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22511a, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22513c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22512b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
