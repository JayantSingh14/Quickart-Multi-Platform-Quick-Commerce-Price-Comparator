package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
@Deprecated
/* loaded from: classes4.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    public static final Clock n = DefaultClock.getInstance();

    /* renamed from: a, reason: collision with root package name */
    public final int f22151a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22152b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22153c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22154d;

    /* renamed from: e, reason: collision with root package name */
    public final String f22155e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f22156f;

    /* renamed from: g, reason: collision with root package name */
    public String f22157g;

    /* renamed from: h, reason: collision with root package name */
    public final long f22158h;

    /* renamed from: i, reason: collision with root package name */
    public final String f22159i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f22160j;

    /* renamed from: k, reason: collision with root package name */
    public final String f22161k;

    /* renamed from: l, reason: collision with root package name */
    public final String f22162l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f22163m = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, ArrayList arrayList, String str7, String str8) {
        this.f22151a = i2;
        this.f22152b = str;
        this.f22153c = str2;
        this.f22154d = str3;
        this.f22155e = str4;
        this.f22156f = uri;
        this.f22157g = str5;
        this.f22158h = j2;
        this.f22159i = str6;
        this.f22160j = arrayList;
        this.f22161k = str7;
        this.f22162l = str8;
    }

    public static GoogleSignInAccount r(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j2 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, jSONObject.optString(CLConstants.SHARED_PREFERENCE_ITEM_ID), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has(Scopes.EMAIL) ? jSONObject.optString(Scopes.EMAIL) : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, uri, null, j2, Preconditions.checkNotEmpty(jSONObject.getString("obfuscatedIdentifier")), new ArrayList((Collection) Preconditions.checkNotNull(hashSet)), jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null);
        googleSignInAccount.f22157g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final HashSet b() {
        HashSet hashSet = new HashSet(this.f22160j);
        hashSet.addAll(this.f22163m);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f22159i.equals(this.f22159i) && googleSignInAccount.b().equals(b());
    }

    public final int hashCode() {
        return ((this.f22159i.hashCode() + 527) * 31) + b().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22151a);
        SafeParcelWriter.writeString(parcel, 2, this.f22152b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22153c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22154d, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22155e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22156f, i2, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22157g, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f22158h);
        SafeParcelWriter.writeString(parcel, 9, this.f22159i, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.f22160j, false);
        SafeParcelWriter.writeString(parcel, 11, this.f22161k, false);
        SafeParcelWriter.writeString(parcel, 12, this.f22162l, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
