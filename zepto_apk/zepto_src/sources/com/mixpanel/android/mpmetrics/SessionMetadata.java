package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.util.MPLog;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class SessionMetadata {

    /* renamed from: a, reason: collision with root package name */
    public long f46076a;

    /* renamed from: b, reason: collision with root package name */
    public long f46077b;

    /* renamed from: c, reason: collision with root package name */
    public long f46078c;

    /* renamed from: d, reason: collision with root package name */
    public String f46079d;

    /* renamed from: e, reason: collision with root package name */
    public final SecureRandom f46080e;

    public SessionMetadata() {
        b();
        this.f46080e = new SecureRandom();
    }

    public final JSONObject a(boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$mp_event_id", Long.toHexString(this.f46080e.nextLong()));
            jSONObject.put("$mp_session_id", this.f46079d);
            jSONObject.put("$mp_session_seq_id", z ? this.f46076a : this.f46077b);
            jSONObject.put("$mp_session_start_sec", this.f46078c);
            if (z) {
                this.f46076a++;
                return jSONObject;
            }
            this.f46077b++;
            return jSONObject;
        } catch (JSONException e2) {
            MPLog.c("MixpanelAPI.ConfigurationChecker", "Cannot create session metadata JSON object", e2);
            return jSONObject;
        }
    }

    public final void b() {
        this.f46076a = 0L;
        this.f46077b = 0L;
        this.f46079d = Long.toHexString(new SecureRandom().nextLong());
        this.f46078c = System.currentTimeMillis() / 1000;
    }
}
