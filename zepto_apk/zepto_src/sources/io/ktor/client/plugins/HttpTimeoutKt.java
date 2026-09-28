package io.ktor.client.plugins;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestData;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes3.dex */
public final class HttpTimeoutKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f49660a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpTimeout");

    public static final ConnectTimeoutException a(HttpRequestData request, IOException iOException) {
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sb = new StringBuilder("Connect timeout has expired [url=");
        sb.append(request.f50010a);
        sb.append(", connect_timeout=");
        HttpTimeout.Plugin plugin = HttpTimeout.f49642d;
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.a();
        if (httpTimeoutCapabilityConfiguration == null || (obj = httpTimeoutCapabilityConfiguration.f49648b) == null) {
            obj = zzck.UNKNOWN_CONTENT_TYPE;
        }
        return new ConnectTimeoutException(b.q(sb, obj, " ms]"), iOException);
    }

    public static final SocketTimeoutException b(HttpRequestData request, Throwable th) {
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sb = new StringBuilder("Socket timeout has expired [url=");
        sb.append(request.f50010a);
        sb.append(", socket_timeout=");
        HttpTimeout.Plugin plugin = HttpTimeout.f49642d;
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.a();
        if (httpTimeoutCapabilityConfiguration == null || (obj = httpTimeoutCapabilityConfiguration.f49649c) == null) {
            obj = zzck.UNKNOWN_CONTENT_TYPE;
        }
        return new SocketTimeoutException(b.q(sb, obj, "] ms"), th);
    }

    public static final long d(long j2) {
        if (j2 == Long.MAX_VALUE) {
            return 0L;
        }
        return j2;
    }
}
