package com.google.android.datatransport;

/* loaded from: classes.dex */
public interface Transport<T> {
    void a(Event event, TransportScheduleCallback transportScheduleCallback);

    void b(Event event);
}
