package com.facebook.react.common.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes3.dex */
public final class OkHttpCallUtil {
    public static final void a(OkHttpClient client, Integer tag) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Dispatcher dispatcher = client.f56297a;
        for (Call call : dispatcher.e()) {
            if (tag.equals(call.r().c(Object.class))) {
                call.cancel();
                return;
            }
        }
        for (Call call2 : dispatcher.f()) {
            if (tag.equals(call2.r().c(Object.class))) {
                call2.cancel();
                return;
            }
        }
    }
}
