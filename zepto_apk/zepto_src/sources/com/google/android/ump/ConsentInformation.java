package com.google.android.ump;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public interface ConsentInformation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsentStatus {
    }

    public interface OnConsentInfoUpdateFailureListener {
    }

    public interface OnConsentInfoUpdateSuccessListener {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class PrivacyOptionsRequirementStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrivacyOptionsRequirementStatus[] f42224a = {new PrivacyOptionsRequirementStatus("UNKNOWN", 0), new PrivacyOptionsRequirementStatus("NOT_REQUIRED", 1), new PrivacyOptionsRequirementStatus("REQUIRED", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        PrivacyOptionsRequirementStatus EF5;

        @RecentlyNonNull
        public static PrivacyOptionsRequirementStatus valueOf(@RecentlyNonNull String str) {
            return (PrivacyOptionsRequirementStatus) Enum.valueOf(PrivacyOptionsRequirementStatus.class, str);
        }

        @RecentlyNonNull
        public static PrivacyOptionsRequirementStatus[] values() {
            return (PrivacyOptionsRequirementStatus[]) f42224a.clone();
        }
    }
}
