package com.chuckerteam.chucker.api;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.view.inputmethod.a;
import androidx.media3.exoplayer.analytics.l;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.api.RetentionManager;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.LimitingSource;
import com.chuckerteam.chucker.internal.support.Logger;
import com.chuckerteam.chucker.internal.support.OkHttpUtilsKt;
import com.chuckerteam.chucker.internal.support.PlainTextDecoder;
import com.chuckerteam.chucker.internal.support.RequestProcessor;
import com.chuckerteam.chucker.internal.support.ResponseProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import okio.Buffer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ChuckerInterceptor implements Interceptor {

    /* renamed from: h, reason: collision with root package name */
    public static final List f16612h = CollectionsKt.H(PlainTextDecoder.f16788a);

    /* renamed from: a, reason: collision with root package name */
    public final ChuckerCollector f16613a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestProcessor f16614b;

    /* renamed from: c, reason: collision with root package name */
    public final ResponseProcessor f16615c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f16616d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f16617e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f16618f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f16619g;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f16620a;

        /* renamed from: b, reason: collision with root package name */
        public ChuckerCollector f16621b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16622c;

        /* renamed from: d, reason: collision with root package name */
        public final EmptySet f16623d;

        /* renamed from: e, reason: collision with root package name */
        public final EmptyList f16624e;

        /* renamed from: f, reason: collision with root package name */
        public final LinkedHashSet f16625f;

        /* renamed from: g, reason: collision with root package name */
        public final LinkedHashSet f16626g;

        /* renamed from: h, reason: collision with root package name */
        public final LinkedHashSet f16627h;

        /* renamed from: i, reason: collision with root package name */
        public final LinkedHashSet f16628i;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f16620a = context;
            this.f16623d = EmptySet.f53611a;
            this.f16624e = EmptyList.f53609a;
            this.f16625f = new LinkedHashSet();
            this.f16626g = new LinkedHashSet();
            this.f16627h = new LinkedHashSet();
            this.f16628i = new LinkedHashSet();
        }

        public final void a() {
            this.f16622c = true;
        }

        public final ChuckerInterceptor b() {
            return new ChuckerInterceptor(this);
        }

        public final void c(ChuckerCollector collector) {
            Intrinsics.checkNotNullParameter(collector, "collector");
            this.f16621b = collector;
        }
    }

    @Metadata
    public static final class Companion {
    }

    public ChuckerInterceptor(Builder builder) {
        ShortcutManager shortcutManagerH;
        LinkedHashSet linkedHashSetG0 = CollectionsKt.g0(builder.f16623d);
        ArrayList arrayListL = CollectionsKt.L(builder.f16624e, f16612h);
        ChuckerCollector chuckerCollector = builder.f16621b;
        Context context = builder.f16620a;
        ChuckerCollector chuckerCollector2 = chuckerCollector == null ? new ChuckerCollector(context, RetentionManager.Period.f16637b) : chuckerCollector;
        this.f16613a = chuckerCollector2;
        this.f16614b = new RequestProcessor(builder.f16620a, chuckerCollector2, linkedHashSetG0, arrayListL);
        this.f16615c = new ResponseProcessor(chuckerCollector2, new l(builder, 5), linkedHashSetG0, builder.f16622c, arrayListL);
        this.f16616d = CollectionsKt.h0(builder.f16625f);
        this.f16617e = CollectionsKt.h0(builder.f16626g);
        this.f16618f = CollectionsKt.h0(builder.f16627h);
        this.f16619g = CollectionsKt.h0(builder.f16628i);
        Logger.Companion companion = Logger.Companion.f16778a;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 25 && (shortcutManagerH = a.h(context.getSystemService(a.i()))) != null) {
            List dynamicShortcuts = shortcutManagerH.getDynamicShortcuts();
            Intrinsics.checkNotNullExpressionValue(dynamicShortcuts, "getDynamicShortcuts(...)");
            List list = dynamicShortcuts;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.b(a.g(it.next()).getId(), "chuckerShortcutId")) {
                        return;
                    }
                }
            }
            ShortcutInfo shortcutInfoBuild = a.a(context).setShortLabel(context.getString(R.string.chucker_shortcut_label)).setLongLabel(context.getString(R.string.chucker_shortcut_label)).setIcon(Icon.createWithResource(context, R.mipmap.chucker_ic_launcher)).setIntent(Chucker.a(context).setAction("android.intent.action.VIEW")).build();
            Intrinsics.checkNotNullExpressionValue(shortcutInfoBuild, "build(...)");
            try {
                shortcutManagerH.addDynamicShortcuts(CollectionsKt.H(shortcutInfoBuild));
            } catch (IllegalArgumentException e2) {
                companion.b("ShortcutManager addDynamicShortcuts failed ", e2);
            } catch (IllegalStateException e3) {
                companion.b("ShortcutManager addDynamicShortcuts failed ", e3);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public final Response a(RealInterceptorChain chain) throws IOException {
        Object[] objArr;
        Object[] objArr2;
        MediaType mediaTypeContentType;
        char c2 = 1;
        Intrinsics.checkNotNullParameter(chain, "chain");
        HttpTransaction transaction = new HttpTransaction();
        Request request = chain.f56582e;
        String strB = request.f56331a.b();
        HttpUrl httpUrl = request.f56331a;
        String str = httpUrl.f56262d;
        if (this.f16616d.contains(strB)) {
            objArr = true;
            break;
        }
        Set set = this.f16617e;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (((Regex) it.next()).c(strB)) {
                    objArr = true;
                    break;
                }
            }
        }
        objArr = false;
        if (objArr == true || this.f16618f.contains(str)) {
            objArr2 = true;
            break;
        }
        Set set2 = this.f16619g;
        if (set2 == null || !set2.isEmpty()) {
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                if (((Regex) it2.next()).c(str)) {
                    objArr2 = true;
                    break;
                }
            }
        }
        objArr2 = false;
        Object[] objArr3 = (objArr == true || objArr2 == true) ? false : true;
        if (objArr3 != false) {
            RequestProcessor requestProcessor = this.f16614b;
            requestProcessor.getClass();
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Headers headers = request.f56333c;
            transaction.setRequestHeadersSize(Long.valueOf(headers.b()));
            Headers headersA = OkHttpUtilsKt.a(headers, requestProcessor.f16797c);
            transaction.setRequestHeaders(headersA);
            transaction.setGraphQlOperationName(headersA);
            transaction.populateUrl(httpUrl);
            transaction.setGraphQlDetected(transaction.getGraphQlOperationName() != null || httpUrl.f56264f.contains("graphql") || StringsKt.n(httpUrl.f56262d, "graphql", false));
            transaction.setRequestDate(Long.valueOf(System.currentTimeMillis()));
            transaction.setMethod(request.f56332b);
            RequestBody requestBody = request.f56334d;
            transaction.setRequestContentType((requestBody == null || (mediaTypeContentType = requestBody.contentType()) == null) ? null : mediaTypeContentType.f56280a);
            transaction.setRequestPayloadSize(requestBody != null ? Long.valueOf(requestBody.contentLength()) : null);
            if (requestBody != null) {
                boolean zIsOneShot = requestBody.isOneShot();
                Logger.Companion companion = Logger.Companion.f16778a;
                if (zIsOneShot) {
                    Logger.DefaultImpls.a("Skipping one shot request body");
                } else if (requestBody.isDuplex()) {
                    Logger.DefaultImpls.a("Skipping duplex request body");
                } else {
                    try {
                        Buffer buffer = new Buffer();
                        requestBody.writeTo(buffer);
                        LimitingSource limitingSource = new LimitingSource(OkHttpUtilsKt.b(buffer, headers));
                        Buffer buffer2 = new Buffer();
                        try {
                            buffer2.g0(limitingSource);
                            Unit unit = Unit.f53572a;
                            limitingSource.close();
                            String str2 = (String) SequencesKt.h(SequencesKt.n(CollectionsKt.n(requestProcessor.f16798d), new com.brentvatne.react.a(c2 == true ? 1 : 0, request, buffer2.s0(buffer2.f56914b))));
                            transaction.setRequestBody(str2);
                            transaction.setRequestBodyEncoded(str2 == null);
                            if (str2 != null && limitingSource.f16775b >= limitingSource.f16774a) {
                                transaction.setRequestBody(transaction.getRequestBody() + requestProcessor.f16795a.getString(R.string.chucker_body_content_truncated));
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.a(limitingSource, th);
                                throw th2;
                            }
                        }
                    } catch (IOException e2) {
                        companion.a("Failed to read request payload", e2);
                    }
                }
            }
            ChuckerCollector chuckerCollector = requestProcessor.f16796b;
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            BuildersKt.c(chuckerCollector.f16599d, null, new ChuckerCollector$onRequestSent$1(chuckerCollector, transaction, null), 3);
        }
        try {
            Response responseA = chain.a(request);
            return objArr3 != false ? this.f16615c.a(responseA, transaction) : responseA;
        } catch (IOException e3) {
            transaction.setError(e3.toString());
            this.f16613a.a(transaction);
            throw e3;
        }
    }
}
