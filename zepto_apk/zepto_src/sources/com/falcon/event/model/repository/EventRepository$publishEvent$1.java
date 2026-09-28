package com.falcon.event.model.repository;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata
/* loaded from: classes3.dex */
public final class EventRepository$publishEvent$1 implements Callback<Void> {
    @Override // retrofit2.Callback
    public final void a(Call call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Log.e("EventRepository", t.getStackTrace().toString());
    }

    @Override // retrofit2.Callback
    public final void b(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        okhttp3.Response response2 = response.f58224a;
        if (response2.c()) {
            Log.d("EventRepository", response2.toString());
        } else {
            Log.e("EventRepository", response2.toString());
        }
    }
}
