package com.google.android.datatransport.runtime;

import android.util.Log;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.logging.Logging;

/* loaded from: classes3.dex */
public final class ForcedSender {
    public static void a(Transport transport) {
        Priority priority = Priority.f20516c;
        if (transport instanceof TransportImpl) {
            TransportRuntime.a().f20763d.a(((TransportImpl) transport).f20754a.e(priority), 1);
        } else {
            String strD = Logging.d("ForcedSender");
            if (Log.isLoggable(strD, 5)) {
                Log.w(strD, String.format("Expected instance of `TransportImpl`, got `%s`.", transport));
            }
        }
    }
}
