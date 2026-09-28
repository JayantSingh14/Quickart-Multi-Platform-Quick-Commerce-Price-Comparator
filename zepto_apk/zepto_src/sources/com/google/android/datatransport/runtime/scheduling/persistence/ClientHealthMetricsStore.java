package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* loaded from: classes.dex */
public interface ClientHealthMetricsStore {
    void a();

    ClientMetrics c();

    void e(long j2, LogEventDropped.Reason reason, String str);
}
