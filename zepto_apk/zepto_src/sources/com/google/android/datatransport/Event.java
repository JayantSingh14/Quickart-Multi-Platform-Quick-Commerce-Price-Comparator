package com.google.android.datatransport;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

@AutoValue
/* loaded from: classes3.dex */
public abstract class Event<T> {
    public static Event f(MessagingClientEventExtension messagingClientEventExtension, ProductData productData) {
        return new AutoValue_Event(messagingClientEventExtension, Priority.f20514a, productData);
    }

    public static Event g(Object obj) {
        return new AutoValue_Event(obj, Priority.f20514a, null);
    }

    public static Event h(CrashlyticsReport crashlyticsReport) {
        return new AutoValue_Event(crashlyticsReport, Priority.f20516c, null);
    }

    public abstract Integer a();

    public abstract EventContext b();

    public abstract Object c();

    public abstract Priority d();

    public abstract ProductData e();
}
