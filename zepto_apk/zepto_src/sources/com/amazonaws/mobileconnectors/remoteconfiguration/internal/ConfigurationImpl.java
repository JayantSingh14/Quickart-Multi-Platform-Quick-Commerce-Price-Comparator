package com.amazonaws.mobileconnectors.remoteconfiguration.internal;

import com.amazonaws.mobileconnectors.remoteconfiguration.Configuration;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigurationImpl implements Configuration {

    /* renamed from: a, reason: collision with root package name */
    public final String f15280a;

    /* renamed from: b, reason: collision with root package name */
    public final Date f15281b;

    public ConfigurationImpl(String str) {
        this(str, null);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Configuration
    public JSONObject getAsJsonObject() {
        try {
            return new JSONObject(this.f15280a);
        } catch (JSONException e2) {
            throw new IllegalStateException("The configuration is invalid.", e2);
        }
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Configuration
    public String getAsJsonString() {
        return this.f15280a;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Configuration
    public Date getTimestamp() {
        return this.f15281b;
    }

    public ConfigurationImpl(String str, Date date) {
        if (str == null) {
            throw new NullPointerException("The JSON may not be null.");
        }
        this.f15280a = str;
        this.f15281b = date;
    }
}
