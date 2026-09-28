package com.google.firebase.sessions;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class TimeProviderImpl implements TimeProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeProviderImpl f45123a = new TimeProviderImpl();

    @Override // com.google.firebase.sessions.TimeProvider
    public final long a() {
        return System.currentTimeMillis() * 1000;
    }
}
