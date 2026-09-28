package com.truecaller.android.sdk.oAuth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public abstract class OAuthResponse implements Parcelable {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String KEY_DEVICE_CODE = "DEVICE_CODE";

    @NotNull
    public static final String KEY_SIM_STATE = "SIM_STATUS";

    @NotNull
    public static final String OAUTH_RESPONSE_EXTRA = "OAUTH_SDK_RESPONSE_EXTRA";
    private final boolean isSuccessful;

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class SimState {
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class FailureResponse extends OAuthResponse {

        @NotNull
        public static final Parcelable.Creator<FailureResponse> CREATOR = new Creator();

        @NotNull
        private final TcOAuthError tcOAuthError;

        @Metadata
        public static final class Creator implements Parcelable.Creator<FailureResponse> {
            @Override // android.os.Parcelable.Creator
            public final FailureResponse createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FailureResponse((TcOAuthError) parcel.readParcelable(FailureResponse.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            public final FailureResponse[] newArray(int i2) {
                return new FailureResponse[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailureResponse(@NotNull TcOAuthError tcOAuthError) {
            super(false, null);
            Intrinsics.checkNotNullParameter(tcOAuthError, "tcOAuthError");
            this.tcOAuthError = tcOAuthError;
        }

        public static /* synthetic */ FailureResponse copy$default(FailureResponse failureResponse, TcOAuthError tcOAuthError, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                tcOAuthError = failureResponse.tcOAuthError;
            }
            return failureResponse.copy(tcOAuthError);
        }

        @NotNull
        public final TcOAuthError component1() {
            return this.tcOAuthError;
        }

        @NotNull
        public final FailureResponse copy(@NotNull TcOAuthError tcOAuthError) {
            Intrinsics.checkNotNullParameter(tcOAuthError, "tcOAuthError");
            return new FailureResponse(tcOAuthError);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FailureResponse) && Intrinsics.b(this.tcOAuthError, ((FailureResponse) obj).tcOAuthError);
        }

        @NotNull
        public final TcOAuthError getTcOAuthError() {
            return this.tcOAuthError;
        }

        public int hashCode() {
            return this.tcOAuthError.hashCode();
        }

        @NotNull
        public String toString() {
            return "FailureResponse(tcOAuthError=" + this.tcOAuthError + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeParcelable(this.tcOAuthError, i2);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class SuccessResponse extends OAuthResponse {

        @NotNull
        public static final Parcelable.Creator<SuccessResponse> CREATOR = new Creator();

        @NotNull
        private final TcOAuthData tcOAuthData;

        @Metadata
        public static final class Creator implements Parcelable.Creator<SuccessResponse> {
            @Override // android.os.Parcelable.Creator
            public final SuccessResponse createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SuccessResponse(TcOAuthData.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final SuccessResponse[] newArray(int i2) {
                return new SuccessResponse[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuccessResponse(@NotNull TcOAuthData tcOAuthData) {
            super(true, null);
            Intrinsics.checkNotNullParameter(tcOAuthData, "tcOAuthData");
            this.tcOAuthData = tcOAuthData;
        }

        public static /* synthetic */ SuccessResponse copy$default(SuccessResponse successResponse, TcOAuthData tcOAuthData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                tcOAuthData = successResponse.tcOAuthData;
            }
            return successResponse.copy(tcOAuthData);
        }

        @NotNull
        public final TcOAuthData component1() {
            return this.tcOAuthData;
        }

        @NotNull
        public final SuccessResponse copy(@NotNull TcOAuthData tcOAuthData) {
            Intrinsics.checkNotNullParameter(tcOAuthData, "tcOAuthData");
            return new SuccessResponse(tcOAuthData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessResponse) && Intrinsics.b(this.tcOAuthData, ((SuccessResponse) obj).tcOAuthData);
        }

        @NotNull
        public final TcOAuthData getTcOAuthData() {
            return this.tcOAuthData;
        }

        public int hashCode() {
            return this.tcOAuthData.hashCode();
        }

        @NotNull
        public String toString() {
            return "SuccessResponse(tcOAuthData=" + this.tcOAuthData + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            this.tcOAuthData.writeToParcel(dest, i2);
        }
    }

    public /* synthetic */ OAuthResponse(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    private OAuthResponse(boolean z) {
        this.isSuccessful = z;
    }
}
