package com.google.maps.android;

import kotlin.Metadata;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class Status {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f45502a = {new Status("OK", 0), new Status("ZERO_RESULTS", 1), new Status("NOT_FOUND", 2), new Status("REQUEST_DENIED", 3), new Status("OVER_QUERY_LIMIT", 4), new Status(CLConstants.ERROR_INVALID_REQUEST, 5), new Status("UNKNOWN_ERROR", 6)};

    /* JADX INFO: Fake field, exist only in values array */
    Status EF5;

    public static Status valueOf(String str) {
        return (Status) Enum.valueOf(Status.class, str);
    }

    public static Status[] values() {
        return (Status[]) f45502a.clone();
    }
}
