package com.google.firebase.events;

import com.google.firebase.DataCollectionDefaultChange;

/* loaded from: classes4.dex */
public class Event<T> {

    /* renamed from: a, reason: collision with root package name */
    public final DataCollectionDefaultChange f44542a;

    public Event(DataCollectionDefaultChange dataCollectionDefaultChange) {
        this.f44542a = dataCollectionDefaultChange;
    }

    public final Object a() {
        return this.f44542a;
    }

    public final String toString() {
        return "Event{type: " + DataCollectionDefaultChange.class + ", payload: " + this.f44542a + "}";
    }
}
