package com.chuckerteam.chucker.internal.support;

import androidx.media3.exoplayer.analytics.l;
import com.chuckerteam.chucker.api.ChuckerCollector;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.ReportingSink;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Response;

@Metadata
/* loaded from: classes3.dex */
public final class ResponseProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final ChuckerCollector f16799a;

    /* renamed from: b, reason: collision with root package name */
    public final l f16800b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f16801c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16802d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f16803e;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public final class ResponseReportingSinkCallback implements ReportingSink.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final Response f16804a;

        /* renamed from: b, reason: collision with root package name */
        public final HttpTransaction f16805b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResponseProcessor f16806c;

        public ResponseReportingSinkCallback(ResponseProcessor responseProcessor, Response response, HttpTransaction transaction) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            this.f16806c = responseProcessor;
            this.f16804a = response;
            this.f16805b = transaction;
        }
    }

    public ResponseProcessor(ChuckerCollector collector, l cacheDirectoryProvider, LinkedHashSet headersToRedact, boolean z, ArrayList bodyDecoders) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        Intrinsics.checkNotNullParameter(cacheDirectoryProvider, "cacheDirectoryProvider");
        Intrinsics.checkNotNullParameter(headersToRedact, "headersToRedact");
        Intrinsics.checkNotNullParameter(bodyDecoders, "bodyDecoders");
        this.f16799a = collector;
        this.f16800b = cacheDirectoryProvider;
        this.f16801c = headersToRedact;
        this.f16802d = z;
        this.f16803e = bodyDecoders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response a(okhttp3.Response r13, com.chuckerteam.chucker.internal.data.entity.HttpTransaction r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.ResponseProcessor.a(okhttp3.Response, com.chuckerteam.chucker.internal.data.entity.HttpTransaction):okhttp3.Response");
    }
}
