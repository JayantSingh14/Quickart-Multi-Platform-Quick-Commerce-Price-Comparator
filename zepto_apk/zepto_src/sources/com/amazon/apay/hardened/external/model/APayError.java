package com.amazon.apay.hardened.external.model;

import android.content.Intent;
import com.amazon.apay.hardened.external.model.APayConstants;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class APayError extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public ErrorType f14993a;

    /* renamed from: b, reason: collision with root package name */
    public String f14994b;

    public enum ErrorType {
        AUTH_ERROR,
        PAYMENT_ERROR,
        BROWSING_EXPERIENCE,
        INVALID_REQUEST,
        AUTHORISATION_ERROR,
        INVALID_API_KEY_ERROR,
        INITIALISATION_ERROR
    }

    public APayError(JSONObject jSONObject) throws JSONException {
        super(jSONObject.getString(APayConstants.Error.MESSAGE));
        this.f14993a = ErrorType.valueOf(jSONObject.getString(APayConstants.Error.ERROR_TYPE));
        this.f14994b = jSONObject.getString("code");
    }

    public static APayError fromIntent(Intent intent) {
        if (intent == null || intent.getStringExtra("error") == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("error");
        Timber.a("%s", stringExtra);
        try {
            return new APayError(new JSONObject(stringExtra));
        } catch (JSONException e2) {
            Timber.f58263c.e(e2);
            return null;
        }
    }

    public Intent getApayErrorIntent() throws JSONException {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(APayConstants.Error.ERROR_TYPE, this.f14993a);
            jSONObject.put("code", this.f14994b);
            jSONObject.put(APayConstants.Error.MESSAGE, getMessage());
            intent.putExtra("error", jSONObject.toString());
            return intent;
        } catch (JSONException e2) {
            Timber.f58263c.e(e2);
            return new Intent();
        }
    }

    public String getCode() {
        return this.f14994b;
    }

    public ErrorType getType() {
        return this.f14993a;
    }

    public APayError(ErrorType errorType, String str, String str2) {
        super(str2);
        this.f14993a = errorType;
        this.f14994b = str;
    }

    public APayError(ErrorType errorType, String str, String str2, Throwable th) {
        super(str2, th);
        this.f14993a = errorType;
        this.f14994b = str;
    }
}
