package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {

    /* renamed from: a, reason: collision with root package name */
    public ReconnectingWebSocket f19204a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f19205b;

    public class ResponderImpl implements Responder {

        /* renamed from: a, reason: collision with root package name */
        public final Object f19206a;

        public ResponderImpl(Object obj) {
            this.f19206a = obj;
        }

        public final void a(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, this.f19206a);
                jSONObject.put("error", str);
                JSPackagerClient.this.f19204a.j(jSONObject.toString());
            } catch (Exception e2) {
                FLog.h("JSPackagerClient", "Responding with error failed", e2);
            }
        }

        public final void b(Object obj) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, this.f19206a);
                jSONObject.put("result", obj);
                JSPackagerClient.this.f19204a.j(jSONObject.toString());
            } catch (Exception e2) {
                FLog.h("JSPackagerClient", "Responding failed", e2);
            }
        }
    }

    public final void a(Object obj, String str) throws JSONException {
        if (obj != null) {
            new ResponderImpl(obj).a(str);
        }
        FLog.g("JSPackagerClient", "Handling the message failed with reason: " + str);
    }

    public final void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("version");
            String strOptString = jSONObject.optString("method");
            Object objOpt = jSONObject.opt(CLConstants.SHARED_PREFERENCE_ITEM_ID);
            Object objOpt2 = jSONObject.opt("params");
            if (iOptInt != 2) {
                FLog.g("JSPackagerClient", "Message with incompatible or missing version of protocol received: " + iOptInt);
            } else {
                if (strOptString == null) {
                    a(objOpt, "No method provided");
                    return;
                }
                RequestHandler requestHandler = (RequestHandler) this.f19205b.get(strOptString);
                if (requestHandler == null) {
                    a(objOpt, "No request handler for method: ".concat(strOptString));
                } else if (objOpt == null) {
                    requestHandler.a();
                } else {
                    requestHandler.b(objOpt2, new ResponderImpl(objOpt));
                }
            }
        } catch (Exception e2) {
            FLog.h("JSPackagerClient", "Handling the message failed", e2);
        }
    }
}
