package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import com.facebook.react.packagerconnection.JSPackagerClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata
/* loaded from: classes3.dex */
public abstract class NotificationOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void b(Object obj, Responder responder) throws JSONException {
        Intrinsics.checkNotNullParameter(responder, "responder");
        ((JSPackagerClient.ResponderImpl) responder).a("Request is not supported");
        FLog.g("JSPackagerClient", "Request is not supported");
    }
}
