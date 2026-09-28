package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "SaveAccountLinkingTokenRequestCreator")
/* loaded from: classes4.dex */
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new zbn();

    /* renamed from: a, reason: collision with root package name */
    public final PendingIntent f22108a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22109b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22110c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f22111d;

    /* renamed from: e, reason: collision with root package name */
    public final String f22112e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22113f;

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, ArrayList arrayList, String str3, int i2) {
        this.f22108a = pendingIntent;
        this.f22109b = str;
        this.f22110c = str2;
        this.f22111d = arrayList;
        this.f22112e = str3;
        this.f22113f = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        ArrayList arrayList = this.f22111d;
        return arrayList.size() == saveAccountLinkingTokenRequest.f22111d.size() && arrayList.containsAll(saveAccountLinkingTokenRequest.f22111d) && Objects.equal(this.f22108a, saveAccountLinkingTokenRequest.f22108a) && Objects.equal(this.f22109b, saveAccountLinkingTokenRequest.f22109b) && Objects.equal(this.f22110c, saveAccountLinkingTokenRequest.f22110c) && Objects.equal(this.f22112e, saveAccountLinkingTokenRequest.f22112e) && this.f22113f == saveAccountLinkingTokenRequest.f22113f;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22108a, this.f22109b, this.f22110c, this.f22111d, this.f22112e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22108a, i2, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22109b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22110c, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.f22111d, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22112e, false);
        SafeParcelWriter.writeInt(parcel, 6, this.f22113f);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
