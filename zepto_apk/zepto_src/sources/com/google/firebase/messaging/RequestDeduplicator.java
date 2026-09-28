package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class RequestDeduplicator {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f44750a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f44751b = new ArrayMap();

    public interface GetTokenRequest {
    }

    public RequestDeduplicator(ExecutorService executorService) {
        this.f44750a = executorService;
    }
}
