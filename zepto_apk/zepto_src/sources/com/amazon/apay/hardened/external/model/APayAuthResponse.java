package com.amazon.apay.hardened.external.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class APayAuthResponse {

    /* renamed from: a, reason: collision with root package name */
    public Status f14988a;

    /* renamed from: b, reason: collision with root package name */
    public String f14989b;

    /* renamed from: c, reason: collision with root package name */
    public String f14990c;

    /* renamed from: d, reason: collision with root package name */
    public String f14991d;

    public enum Status implements Parcelable {
        GRANTED,
        FAILURE,
        DENIED;

        public static final Parcelable.Creator<Status> CREATOR = new a();

        public static class a implements Parcelable.Creator<Status> {
            @Override // android.os.Parcelable.Creator
            public Status createFromParcel(Parcel parcel) {
                return Status.values()[parcel.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public Status[] newArray(int i2) {
                return new Status[i2];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(ordinal());
        }
    }

    public APayAuthResponse(Status status, String str, String str2, String str3) {
        this.f14988a = status;
        this.f14989b = str;
        this.f14990c = str2;
        this.f14991d = str3;
    }

    public static APayAuthResponse fromIntent(Intent intent) {
        Timber.c("fromIntent called", new Object[0]);
        if (intent != null) {
            try {
                if (intent.getExtras() != null && intent.getExtras().containsKey("AUTH_STATUS")) {
                    Timber.c("Intent contains AUTH_STATUS extra", new Object[0]);
                    return new APayAuthResponse((Status) intent.getExtras().getSerializable("AUTH_STATUS"), intent.getExtras().getString("authCode"), intent.getExtras().getString("lwaClientId"), intent.getExtras().getString(AuthorizationResponseParser.REDIRECT_URI_STATE));
                }
            } catch (Exception e2) {
                Timber.b(e2, "Error while reading authorization result", new Object[0]);
            }
        }
        Timber.c("Intent does not contain AUTH_STATUS extra", new Object[0]);
        return null;
    }

    public String getAuthCode() {
        return this.f14989b;
    }

    public String getClientId() {
        return this.f14990c;
    }

    public String getRedirectUri() {
        return this.f14991d;
    }

    public Status getStatus() {
        return this.f14988a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorizationResponse{status=");
        sb.append(this.f14988a.name());
        sb.append(", authCode='");
        sb.append(this.f14989b);
        sb.append("', clientId='");
        sb.append(this.f14990c);
        sb.append("', redirectUri='");
        return b.r(sb, this.f14991d, "'}");
    }
}
