package com.phoenix;

import com.phoenix.PhoenixLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixAnalyticsLogger {

    @Metadata
    public static final class Companion {
        public static void a(String eventName, JSONObject params) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            ArrayList arrayList = PhoenixEventListener.f46123a;
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            PhoenixLogger.Companion.a("PhoenixEventListener-triggerEvent" + eventName + params);
            Iterator it = PhoenixEventListener.f46123a.iterator();
            while (it.hasNext()) {
                ((IPhoenixDelegate) it.next()).a(eventName, new JSONObject(params.toString()));
            }
        }
    }
}
