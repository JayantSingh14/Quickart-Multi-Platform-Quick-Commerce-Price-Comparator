package com.brentvatne.exoplayer;

import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactExoplayerLoadErrorHandlingPolicy extends DefaultLoadErrorHandlingPolicy {

    /* renamed from: b, reason: collision with root package name */
    public final int f15559b;

    public ReactExoplayerLoadErrorHandlingPolicy(int i2) {
        super(i2);
        this.f15559b = i2;
    }

    @Override // androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public final long a(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        Intrinsics.checkNotNullParameter(loadErrorInfo, "loadErrorInfo");
        IOException iOException = loadErrorInfo.f8162a;
        String message = iOException.getMessage();
        if ((iOException instanceof HttpDataSource.HttpDataSourceException) && message != null && (message.equals("Unable to connect") || message.equals("Software caused connection abort"))) {
            return 1000L;
        }
        int i2 = this.f15559b;
        if (loadErrorInfo.f8163b < i2) {
            return Math.min((r5 - 1) * 1000, 5000L);
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public final int b(int i2) {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
