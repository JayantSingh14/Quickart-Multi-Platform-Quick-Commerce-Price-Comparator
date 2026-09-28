package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class RequestOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void a() {
        FLog.g("JSPackagerClient", "Notification is not supported");
    }
}
