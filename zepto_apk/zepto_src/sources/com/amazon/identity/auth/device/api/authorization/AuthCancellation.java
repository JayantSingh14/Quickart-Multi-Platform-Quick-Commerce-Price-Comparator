package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;

/* loaded from: classes3.dex */
public final class AuthCancellation {
    public static final int CAUSE_FAILED_AUTHENTICATION = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Cause f15088a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15089b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Cause {
        public static final Cause FAILED_AUTHENTICATION;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Cause[] f15090a;

        static {
            Cause cause = new Cause();
            FAILED_AUTHENTICATION = cause;
            f15090a = new Cause[]{cause};
        }

        public static Cause a() {
            return FAILED_AUTHENTICATION;
        }

        public static Cause valueOf(String str) {
            return (Cause) Enum.valueOf(Cause.class, str);
        }

        public static Cause[] values() {
            return (Cause[]) f15090a.clone();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthCancellation(Bundle bundle) {
        this(Cause.a(), bundle.getString(AuthzConstants.BUNDLE_KEY.ON_CANCEL_DESCRIPTION.val));
        bundle.getInt(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthCancellation.class != obj.getClass()) {
            return false;
        }
        AuthCancellation authCancellation = (AuthCancellation) obj;
        if (this.f15088a != authCancellation.f15088a) {
            return false;
        }
        String str = this.f15089b;
        if (str == null) {
            if (authCancellation.f15089b != null) {
                return false;
            }
        } else if (!str.equals(authCancellation.f15089b)) {
            return false;
        }
        return true;
    }

    public Cause getCause() {
        return this.f15088a;
    }

    public String getDescription() {
        return this.f15089b;
    }

    public int hashCode() {
        Cause cause = this.f15088a;
        int iHashCode = ((cause == null ? 0 : cause.hashCode()) + 31) * 31;
        String str = this.f15089b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + " {cause='" + this.f15088a.toString() + "', description='" + this.f15089b + "'}";
    }

    public AuthCancellation(Cause cause, String str) {
        this.f15088a = cause;
        this.f15089b = str;
    }
}
