package com.truecaller.android.sdk.legacy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.truecaller.android.sdk.common.models.TrueProfile;

/* loaded from: classes4.dex */
public class TrueResponse implements Parcelable {
    public static final Parcelable.Creator<TrueResponse> CREATOR = new AnonymousClass1();

    @VisibleForTesting
    public static final String IS_SUCCESSFUL = "TRUERESPONSE_IS_SUCCESSFUL";
    public static final String TRUECALLER_RESPONSE_EXTRA = "TRUECALLER_RESPONSE_EXTRA";
    public static final String TRUESDK_VERSION = "TRUERESPONSE_TRUESDK_VERSION";
    public final boolean isSuccessful;

    @Nullable
    public final TrueError trueError;

    @Nullable
    public final TrueProfile trueProfile;
    private final String truesdkVersion;

    /* renamed from: com.truecaller.android.sdk.legacy.TrueResponse$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<TrueResponse> {
        @Override // android.os.Parcelable.Creator
        public final TrueResponse createFromParcel(Parcel parcel) {
            return new TrueResponse(0, parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TrueResponse[] newArray(int i2) {
            return new TrueResponse[i2];
        }
    }

    public /* synthetic */ TrueResponse(int i2, Parcel parcel) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void writeToBundle(@NonNull Bundle bundle) {
        TrueProfile trueProfile;
        bundle.putBoolean(IS_SUCCESSFUL, this.isSuccessful);
        bundle.putString(TRUESDK_VERSION, this.truesdkVersion);
        if (this.isSuccessful && (trueProfile = this.trueProfile) != null) {
            trueProfile.writeToBundle(bundle);
            return;
        }
        TrueError trueError = this.trueError;
        if (trueError != null) {
            trueError.writeToBundle(bundle);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.trueProfile, i2);
        parcel.writeParcelable(this.trueError, i2);
        parcel.writeString(String.valueOf(this.isSuccessful));
    }

    public TrueResponse(@NonNull TrueProfile trueProfile) {
        this.trueProfile = trueProfile;
        this.trueError = null;
        this.isSuccessful = true;
        this.truesdkVersion = "2.9.0";
    }

    public TrueResponse(@NonNull TrueError trueError) {
        this.trueProfile = null;
        this.trueError = trueError;
        this.isSuccessful = false;
        this.truesdkVersion = "2.9.0";
    }

    public TrueResponse(@NonNull Bundle bundle) {
        boolean z = bundle.getBoolean(IS_SUCCESSFUL);
        this.isSuccessful = z;
        this.truesdkVersion = bundle.getString(TRUESDK_VERSION);
        if (z) {
            this.trueProfile = new TrueProfile(bundle);
            this.trueError = null;
        } else {
            this.trueProfile = null;
            this.trueError = new TrueError(bundle);
        }
    }

    private TrueResponse(Parcel parcel) {
        this.trueProfile = (TrueProfile) parcel.readParcelable(TrueProfile.class.getClassLoader());
        this.trueError = (TrueError) parcel.readParcelable(TrueError.class.getClassLoader());
        this.isSuccessful = Boolean.valueOf(parcel.readString()).booleanValue();
        this.truesdkVersion = "0.4.2";
    }
}
