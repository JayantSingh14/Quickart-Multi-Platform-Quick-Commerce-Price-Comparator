package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import in.juspay.hypersdk.core.PaymentConstants;

/* loaded from: classes.dex */
public final class FirebaseOptions {

    /* renamed from: a, reason: collision with root package name */
    public final String f43506a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43507b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43508c;

    /* renamed from: d, reason: collision with root package name */
    public final String f43509d;

    /* renamed from: e, reason: collision with root package name */
    public final String f43510e;

    /* renamed from: f, reason: collision with root package name */
    public final String f43511f;

    /* renamed from: g, reason: collision with root package name */
    public final String f43512g;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f43513a;

        /* renamed from: b, reason: collision with root package name */
        public String f43514b;

        /* renamed from: c, reason: collision with root package name */
        public String f43515c;

        /* renamed from: d, reason: collision with root package name */
        public String f43516d;

        /* renamed from: e, reason: collision with root package name */
        public String f43517e;

        /* renamed from: f, reason: collision with root package name */
        public String f43518f;

        /* renamed from: g, reason: collision with root package name */
        public String f43519g;

        public final FirebaseOptions a() {
            return new FirebaseOptions(this.f43514b, this.f43513a, this.f43515c, this.f43516d, this.f43517e, this.f43518f, this.f43519g);
        }

        public final void b(String str) {
            this.f43513a = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
        }

        public final void c(String str) {
            this.f43514b = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
        }

        public final void d(String str) {
            this.f43515c = str;
        }

        public final void e(String str) {
            this.f43516d = str;
        }

        public final void f(String str) {
            this.f43517e = str;
        }

        public final void g(String str) {
            this.f43519g = str;
        }

        public final void h(String str) {
            this.f43518f = str;
        }
    }

    public FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f43507b = str;
        this.f43506a = str2;
        this.f43508c = str3;
        this.f43509d = str4;
        this.f43510e = str5;
        this.f43511f = str6;
        this.f43512g = str7;
    }

    public static FirebaseOptions a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString(PaymentConstants.PROJECT_ID));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return Objects.equal(this.f43507b, firebaseOptions.f43507b) && Objects.equal(this.f43506a, firebaseOptions.f43506a) && Objects.equal(this.f43508c, firebaseOptions.f43508c) && Objects.equal(this.f43509d, firebaseOptions.f43509d) && Objects.equal(this.f43510e, firebaseOptions.f43510e) && Objects.equal(this.f43511f, firebaseOptions.f43511f) && Objects.equal(this.f43512g, firebaseOptions.f43512g);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f43507b, this.f43506a, this.f43508c, this.f43509d, this.f43510e, this.f43511f, this.f43512g);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f43507b).add("apiKey", this.f43506a).add("databaseUrl", this.f43508c).add("gcmSenderId", this.f43510e).add("storageBucket", this.f43511f).add("projectId", this.f43512g).toString();
    }
}
