package com.amazon.android.apay.commonlibrary.interfaces.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonPayError extends RuntimeException implements Parcelable {

    @NotNull
    public static final a CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f14940a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f14941b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Throwable f14942c;

    @Metadata
    public static final class a implements Parcelable.Creator<AmazonPayError> {
        @Override // android.os.Parcelable.Creator
        public final AmazonPayError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            return (string == null || string2 == null) ? new AmazonPayError("", "") : new AmazonPayError(string2, string);
        }

        @Override // android.os.Parcelable.Creator
        public final AmazonPayError[] newArray(int i2) {
            return new AmazonPayError[i2];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonPayError(@NotNull String errorType, @NotNull String errorMessage, @Nullable Throwable th) {
        super(errorMessage);
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.f14940a = errorType;
        this.f14941b = errorMessage;
        this.f14942c = th;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AmazonPayError fromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return (AmazonPayError) extras.getParcelable(MerchantConstants.ERROR);
        }
        return null;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.f14941b;
    }

    @NotNull
    public final String getErrorType() {
        return this.f14940a;
    }

    @Nullable
    public final Throwable getThrowable() {
        return this.f14942c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i2) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f14941b);
        out.writeString(this.f14940a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonPayError(@NotNull String errorType, @NotNull String errorMessage) {
        this(errorType, errorMessage, null);
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
    }
}
