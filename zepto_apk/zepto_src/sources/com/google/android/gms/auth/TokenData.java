package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@ShowFirstParty
@SafeParcelable.Class(creator = "TokenDataCreator")
/* loaded from: classes4.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<TokenData> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final int f22014a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22015b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f22016c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22017d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22018e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f22019f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22020g;

    public TokenData(int i2, String str, Long l2, boolean z, boolean z2, ArrayList arrayList, String str2) {
        this.f22014a = i2;
        this.f22015b = Preconditions.checkNotEmpty(str);
        this.f22016c = l2;
        this.f22017d = z;
        this.f22018e = z2;
        this.f22019f = arrayList;
        this.f22020g = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f22015b, tokenData.f22015b) && Objects.equal(this.f22016c, tokenData.f22016c) && this.f22017d == tokenData.f22017d && this.f22018e == tokenData.f22018e && Objects.equal(this.f22019f, tokenData.f22019f) && Objects.equal(this.f22020g, tokenData.f22020g);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22015b, this.f22016c, Boolean.valueOf(this.f22017d), Boolean.valueOf(this.f22018e), this.f22019f, this.f22020g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22014a);
        SafeParcelWriter.writeString(parcel, 2, this.f22015b, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.f22016c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22017d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22018e);
        SafeParcelWriter.writeStringList(parcel, 6, this.f22019f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22020g, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
