package com.zeptoconsumerapp.DynamicFeatures;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata
/* loaded from: classes4.dex */
public final class EventLogger$logEvent$1 implements Callback {
    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException e2) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            if (!response.c()) {
                new Exception("HTTP " + response.f56353d + ": " + response.f56352c);
            }
            response.close();
        } finally {
        }
    }
}
