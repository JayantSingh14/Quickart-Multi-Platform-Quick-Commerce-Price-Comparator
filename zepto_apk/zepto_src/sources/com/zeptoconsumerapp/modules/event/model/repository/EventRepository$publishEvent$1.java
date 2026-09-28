package com.zeptoconsumerapp.modules.event.model.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class EventRepository$publishEvent$1 implements Callback<Void> {
    @Override // retrofit2.Callback
    public final void a(Call call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.d("EventRepository").e(t.getStackTrace().toString(), new Object[0]);
    }

    @Override // retrofit2.Callback
    public final void b(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        okhttp3.Response response2 = response.f58224a;
        if (response2.c()) {
            Timber.d("EventRepository").d(response2.toString(), new Object[0]);
        } else {
            Timber.d("EventRepository").e(response2.toString(), new Object[0]);
        }
    }
}
