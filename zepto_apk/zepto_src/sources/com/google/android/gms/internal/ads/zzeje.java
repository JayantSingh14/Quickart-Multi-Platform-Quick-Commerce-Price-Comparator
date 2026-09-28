package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzeje {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29458a;

    public zzeje(Context context) {
        this.f29458a = context;
    }

    public final ListenableFuture a(boolean z) {
        try {
            new GetTopicsRequest.Builder();
            Intrinsics.checkNotNullParameter("com.google.android.gms.ads", "adsSdkName");
            GetTopicsRequest getTopicsRequest = new GetTopicsRequest("com.google.android.gms.ads", z);
            TopicsManagerFutures topicsManagerFuturesA = TopicsManagerFutures.a(this.f29458a);
            return topicsManagerFuturesA != null ? topicsManagerFuturesA.b(getTopicsRequest) : zzgym.b(new IllegalStateException());
        } catch (Exception e2) {
            return zzgym.b(e2);
        }
    }
}
