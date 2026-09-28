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
public abstract class TcOAuthError implements Parcelable {
    private final int errorCode;

    @NotNull
    private final String errorMessage;

    @Parcelize
    @Keep
    @Metadata
    public static final class ApiError extends TcOAuthError {

        @NotNull
        public static final Parcelable.Creator<ApiError> CREATOR = new Creator();
        private final int code;

        @NotNull
        private final String message;

        @Metadata
        public static final class Creator implements Parcelable.Creator<ApiError> {
            @Override // android.os.Parcelable.Creator
            public final ApiError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ApiError(parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final ApiError[] newArray(int i2) {
                return new ApiError[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiError(int i2, @NotNull String message) {
            super(i2, message, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.code = i2;
            this.message = message;
        }

        public static /* synthetic */ ApiError copy$default(ApiError apiError, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = apiError.code;
            }
            if ((i3 & 2) != 0) {
                str = apiError.message;
            }
            return apiError.copy(i2, str);
        }

        public final int component1() {
            return this.code;
        }

        @NotNull
        public final String component2() {
            return this.message;
        }

        @NotNull
        public final ApiError copy(int i2, @NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ApiError(i2, message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApiError)) {
                return false;
            }
            ApiError apiError = (ApiError) obj;
            return this.code == apiError.code && Intrinsics.b(this.message, apiError.message);
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode() + (Integer.hashCode(this.code) * 31);
        }

        @NotNull
        public String toString() {
            return "ApiError(code=" + this.code + ", message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.code);
            dest.writeString(this.message);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class DefaultError extends TcOAuthError {

        @NotNull
        public static final DefaultError INSTANCE = new DefaultError();

        @NotNull
        public static final Parcelable.Creator<DefaultError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<DefaultError> {
            @Override // android.os.Parcelable.Creator
            public final DefaultError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return DefaultError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final DefaultError[] newArray(int i2) {
                return new DefaultError[i2];
            }
        }

        private DefaultError() {
            super(0, "Something went wrong", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class DeviceNotSupported extends TcOAuthError {

        @NotNull
        public static final DeviceNotSupported INSTANCE = new DeviceNotSupported();

        @NotNull
        public static final Parcelable.Creator<DeviceNotSupported> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<DeviceNotSupported> {
            @Override // android.os.Parcelable.Creator
            public final DeviceNotSupported createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return DeviceNotSupported.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final DeviceNotSupported[] newArray(int i2) {
                return new DeviceNotSupported[i2];
            }
        }

        private DeviceNotSupported() {
            super(16, "Device is not supported", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class InvalidAccountStateError extends TcOAuthError {

        @NotNull
        public static final InvalidAccountStateError INSTANCE = new InvalidAccountStateError();

        @NotNull
        public static final Parcelable.Creator<InvalidAccountStateError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<InvalidAccountStateError> {
            @Override // android.os.Parcelable.Creator
            public final InvalidAccountStateError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return InvalidAccountStateError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final InvalidAccountStateError[] newArray(int i2) {
                return new InvalidAccountStateError[i2];
            }
        }

        private InvalidAccountStateError() {
            super(10, "Truecaller user has an invalid account state", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class InvalidPartnerError extends TcOAuthError {

        @NotNull
        public static final InvalidPartnerError INSTANCE = new InvalidPartnerError();

        @NotNull
        public static final Parcelable.Creator<InvalidPartnerError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<InvalidPartnerError> {
            @Override // android.os.Parcelable.Creator
            public final InvalidPartnerError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return InvalidPartnerError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final InvalidPartnerError[] newArray(int i2) {
                return new InvalidPartnerError[i2];
            }
        }

        private InvalidPartnerError() {
            super(12, "Invalid partner or partner information is missing", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class OldSdkError extends TcOAuthError {

        @NotNull
        public static final OldSdkError INSTANCE = new OldSdkError();

        @NotNull
        public static final Parcelable.Creator<OldSdkError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<OldSdkError> {
            @Override // android.os.Parcelable.Creator
            public final OldSdkError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return OldSdkError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final OldSdkError[] newArray(int i2) {
                return new OldSdkError[i2];
            }
        }

        private OldSdkError() {
            super(6, "Truecaller sdk is old and not compatible", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class RequestCodeCollisionError extends TcOAuthError {

        @NotNull
        public static final RequestCodeCollisionError INSTANCE = new RequestCodeCollisionError();

        @NotNull
        public static final Parcelable.Creator<RequestCodeCollisionError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<RequestCodeCollisionError> {
            @Override // android.os.Parcelable.Creator
            public final RequestCodeCollisionError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return RequestCodeCollisionError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final RequestCodeCollisionError[] newArray(int i2) {
                return new RequestCodeCollisionError[i2];
            }
        }

        private RequestCodeCollisionError() {
            super(7, "Conflicting request code possible", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class TruecallerActivityNotFoundError extends TcOAuthError {

        @NotNull
        public static final TruecallerActivityNotFoundError INSTANCE = new TruecallerActivityNotFoundError();

        @NotNull
        public static final Parcelable.Creator<TruecallerActivityNotFoundError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<TruecallerActivityNotFoundError> {
            @Override // android.os.Parcelable.Creator
            public final TruecallerActivityNotFoundError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return TruecallerActivityNotFoundError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final TruecallerActivityNotFoundError[] newArray(int i2) {
                return new TruecallerActivityNotFoundError[i2];
            }
        }

        private TruecallerActivityNotFoundError() {
            super(15, "Truecaller activity not found", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class TruecallerClosedError extends TcOAuthError {

        @NotNull
        public static final TruecallerClosedError INSTANCE = new TruecallerClosedError();

        @NotNull
        public static final Parcelable.Creator<TruecallerClosedError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<TruecallerClosedError> {
            @Override // android.os.Parcelable.Creator
            public final TruecallerClosedError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return TruecallerClosedError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final TruecallerClosedError[] newArray(int i2) {
                return new TruecallerClosedError[i2];
            }
        }

        private TruecallerClosedError() {
            super(5, "Truecaller app closed unexpectedly", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class TruecallerNotInstalledError extends TcOAuthError {

        @NotNull
        public static final TruecallerNotInstalledError INSTANCE = new TruecallerNotInstalledError();

        @NotNull
        public static final Parcelable.Creator<TruecallerNotInstalledError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<TruecallerNotInstalledError> {
            @Override // android.os.Parcelable.Creator
            public final TruecallerNotInstalledError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return TruecallerNotInstalledError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final TruecallerNotInstalledError[] newArray(int i2) {
                return new TruecallerNotInstalledError[i2];
            }
        }

        private TruecallerNotInstalledError() {
            super(11, "Truecaller app is not installed", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class UserDeniedByPressingFooterError extends TcOAuthError {

        @NotNull
        public static final UserDeniedByPressingFooterError INSTANCE = new UserDeniedByPressingFooterError();

        @NotNull
        public static final Parcelable.Creator<UserDeniedByPressingFooterError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<UserDeniedByPressingFooterError> {
            @Override // android.os.Parcelable.Creator
            public final UserDeniedByPressingFooterError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return UserDeniedByPressingFooterError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final UserDeniedByPressingFooterError[] newArray(int i2) {
                return new UserDeniedByPressingFooterError[i2];
            }
        }

        private UserDeniedByPressingFooterError() {
            super(14, "User denied by pressing the footer button", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class UserDeniedError extends TcOAuthError {

        @NotNull
        public static final UserDeniedError INSTANCE = new UserDeniedError();

        @NotNull
        public static final Parcelable.Creator<UserDeniedError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<UserDeniedError> {
            @Override // android.os.Parcelable.Creator
            public final UserDeniedError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return UserDeniedError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final UserDeniedError[] newArray(int i2) {
                return new UserDeniedError[i2];
            }
        }

        private UserDeniedError() {
            super(2, "User denied by dismissing consent screen", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Parcelize
    @Keep
    @Metadata
    public static final class UserDeniedWhileLoadingError extends TcOAuthError {

        @NotNull
        public static final UserDeniedWhileLoadingError INSTANCE = new UserDeniedWhileLoadingError();

        @NotNull
        public static final Parcelable.Creator<UserDeniedWhileLoadingError> CREATOR = new Creator();

        @Metadata
        public static final class Creator implements Parcelable.Creator<UserDeniedWhileLoadingError> {
            @Override // android.os.Parcelable.Creator
            public final UserDeniedWhileLoadingError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return UserDeniedWhileLoadingError.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final UserDeniedWhileLoadingError[] newArray(int i2) {
                return new UserDeniedWhileLoadingError[i2];
            }
        }

        private UserDeniedWhileLoadingError() {
            super(13, "User denied while loading", null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int i2) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }
    }

    public /* synthetic */ TcOAuthError(int i2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    private TcOAuthError(int i2, String str) {
        this.errorCode = i2;
        this.errorMessage = str;
    }
}
