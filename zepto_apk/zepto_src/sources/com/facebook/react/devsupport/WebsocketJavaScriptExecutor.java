package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import android.util.JsonWriter;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.BridgeDevSupportManager;
import com.facebook.react.devsupport.JSDebuggerWebSocketClient;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class WebsocketJavaScriptExecutor implements JavaJSExecutor {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f18901a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public JSDebuggerWebSocketClient f18902b;

    /* renamed from: com.facebook.react.devsupport.WebsocketJavaScriptExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements JSExecutorConnectCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSExecutorConnectCallback f18903a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f18904b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18905c;

        public AnonymousClass1(JSExecutorConnectCallback jSExecutorConnectCallback, AtomicInteger atomicInteger, String str) {
            this.f18903a = jSExecutorConnectCallback;
            this.f18904b = atomicInteger;
            this.f18905c = str;
        }

        public final void a(Exception exc) {
            if (this.f18904b.decrementAndGet() > 0) {
                WebsocketJavaScriptExecutor.this.a(this.f18905c, this);
                return;
            }
            BridgeDevSupportManager.AnonymousClass2 anonymousClass2 = (BridgeDevSupportManager.AnonymousClass2) this.f18903a;
            BridgeDevSupportManager bridgeDevSupportManager = BridgeDevSupportManager.this;
            bridgeDevSupportManager.f18827j.c();
            bridgeDevSupportManager.o = false;
            FLog.h("ReactNative", "Failed to connect to debugger!", exc);
            IOException exception = new IOException(bridgeDevSupportManager.f18818a.getString(R.string.catalyst_debug_error), exc);
            SimpleSettableFuture simpleSettableFuture = anonymousClass2.f18758a;
            Intrinsics.checkNotNullParameter(exception, "exception");
            CountDownLatch countDownLatch = simpleSettableFuture.f18717a;
            if (countDownLatch.getCount() == 0) {
                throw new RuntimeException("Result has already been set!");
            }
            simpleSettableFuture.f18719c = exception;
            countDownLatch.countDown();
        }

        @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
        public final void onSuccess() {
            this.f18903a.onSuccess();
        }
    }

    /* renamed from: com.facebook.react.devsupport.WebsocketJavaScriptExecutor$2, reason: invalid class name */
    class AnonymousClass2 implements JSDebuggerWebSocketClient.JSDebuggerCallback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18907a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSDebuggerWebSocketClient f18908b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Handler f18909c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSExecutorConnectCallback f18910d;

        public AnonymousClass2(JSDebuggerWebSocketClient jSDebuggerWebSocketClient, Handler handler, JSExecutorConnectCallback jSExecutorConnectCallback) {
            this.f18908b = jSDebuggerWebSocketClient;
            this.f18909c = handler;
            this.f18910d = jSExecutorConnectCallback;
        }

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public final void onFailure(Exception exc) {
            this.f18909c.removeCallbacksAndMessages(null);
            if (this.f18907a) {
                return;
            }
            ((AnonymousClass1) this.f18910d).a(exc);
            this.f18907a = true;
        }

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public final void onSuccess(String str) throws IOException {
            JSDebuggerWebSocketClient.JSDebuggerCallback jSDebuggerCallback = new JSDebuggerWebSocketClient.JSDebuggerCallback() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.2.1
                @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
                public final void onFailure(Exception exc) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.f18909c.removeCallbacksAndMessages(null);
                    if (anonymousClass2.f18907a) {
                        return;
                    }
                    ((AnonymousClass1) anonymousClass2.f18910d).a(exc);
                    anonymousClass2.f18907a = true;
                }

                @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
                public final void onSuccess(String str2) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.f18909c.removeCallbacksAndMessages(null);
                    WebsocketJavaScriptExecutor.this.f18902b = anonymousClass2.f18908b;
                    if (anonymousClass2.f18907a) {
                        return;
                    }
                    ((AnonymousClass1) anonymousClass2.f18910d).onSuccess();
                    anonymousClass2.f18907a = true;
                }
            };
            JSDebuggerWebSocketClient jSDebuggerWebSocketClient = this.f18908b;
            int andIncrement = jSDebuggerWebSocketClient.f18853d.getAndIncrement();
            jSDebuggerWebSocketClient.f18854e.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
            try {
                StringWriter stringWriter = new StringWriter();
                new JsonWriter(stringWriter).beginObject().name(CLConstants.SHARED_PREFERENCE_ITEM_ID).value(andIncrement).name("method").value("prepareJSRuntime").endObject().close();
                jSDebuggerWebSocketClient.j(andIncrement, stringWriter.toString());
            } catch (IOException e2) {
                jSDebuggerWebSocketClient.k(andIncrement, e2);
            }
        }
    }

    public static class JSExecutorCallbackFuture implements JSDebuggerWebSocketClient.JSDebuggerCallback {

        /* renamed from: a, reason: collision with root package name */
        public final Semaphore f18915a = new Semaphore(0);

        /* renamed from: b, reason: collision with root package name */
        public Exception f18916b;

        /* renamed from: c, reason: collision with root package name */
        public String f18917c;

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public final void onFailure(Exception exc) {
            this.f18916b = exc;
            this.f18915a.release();
        }

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public final void onSuccess(String str) {
            this.f18917c = str;
            this.f18915a.release();
        }
    }

    public interface JSExecutorConnectCallback {
        void onSuccess();
    }

    public static class WebsocketExecutorTimeoutException extends Exception {
    }

    public final void a(String str, final JSExecutorConnectCallback jSExecutorConnectCallback) {
        final JSDebuggerWebSocketClient jSDebuggerWebSocketClient = new JSDebuggerWebSocketClient();
        Handler handler = new Handler(Looper.getMainLooper());
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(jSDebuggerWebSocketClient, handler, jSExecutorConnectCallback);
        if (jSDebuggerWebSocketClient.f18851b != null) {
            throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
        }
        jSDebuggerWebSocketClient.f18852c = anonymousClass2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.b(10L, timeUnit);
        builder.d(10L, timeUnit);
        builder.c(0L, TimeUnit.MINUTES);
        jSDebuggerWebSocketClient.f18851b = new OkHttpClient(builder);
        Request.Builder builder2 = new Request.Builder();
        builder2.i(str);
        jSDebuggerWebSocketClient.f18851b.b(builder2.b(), jSDebuggerWebSocketClient);
        handler.postDelayed(new Runnable() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.3
            @Override // java.lang.Runnable
            public final void run() {
                jSDebuggerWebSocketClient.i();
                ((AnonymousClass1) jSExecutorConnectCallback).a(new WebsocketExecutorTimeoutException("Timeout while connecting to remote debugger"));
            }
        }, 5000L);
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public final void close() {
        JSDebuggerWebSocketClient jSDebuggerWebSocketClient = this.f18902b;
        if (jSDebuggerWebSocketClient != null) {
            jSDebuggerWebSocketClient.i();
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public final String executeJSCall(String str, String str2) throws JavaJSExecutor.ProxyExecutorException, IOException {
        JSExecutorCallbackFuture jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        JSDebuggerWebSocketClient jSDebuggerWebSocketClient = this.f18902b;
        Assertions.c(jSDebuggerWebSocketClient);
        int andIncrement = jSDebuggerWebSocketClient.f18853d.getAndIncrement();
        jSDebuggerWebSocketClient.f18854e.put(Integer.valueOf(andIncrement), jSExecutorCallbackFuture);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.beginObject().name(CLConstants.SHARED_PREFERENCE_ITEM_ID).value(andIncrement).name("method").value(str);
            stringWriter.append((CharSequence) ",\"arguments\":").append((CharSequence) str2);
            jsonWriter.endObject().close();
            jSDebuggerWebSocketClient.j(andIncrement, stringWriter.toString());
        } catch (IOException e2) {
            jSDebuggerWebSocketClient.k(andIncrement, e2);
        }
        try {
            jSExecutorCallbackFuture.f18915a.acquire();
            Exception exc = jSExecutorCallbackFuture.f18916b;
            if (exc == null) {
                return jSExecutorCallbackFuture.f18917c;
            }
            throw exc;
        } catch (Throwable th) {
            throw new JavaJSExecutor.ProxyExecutorException(th);
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public final void loadBundle(String str) throws JavaJSExecutor.ProxyExecutorException, IOException {
        JSExecutorCallbackFuture jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        JSDebuggerWebSocketClient jSDebuggerWebSocketClient = this.f18902b;
        Assertions.c(jSDebuggerWebSocketClient);
        HashMap map = this.f18901a;
        int andIncrement = jSDebuggerWebSocketClient.f18853d.getAndIncrement();
        jSDebuggerWebSocketClient.f18854e.put(Integer.valueOf(andIncrement), jSExecutorCallbackFuture);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriterBeginObject = new JsonWriter(stringWriter).beginObject().name(CLConstants.SHARED_PREFERENCE_ITEM_ID).value(andIncrement).name("method").value("executeApplicationScript").name("url").value(str).name("inject").beginObject();
            for (String str2 : map.keySet()) {
                jsonWriterBeginObject.name(str2).value((String) map.get(str2));
            }
            jsonWriterBeginObject.endObject().endObject().close();
            jSDebuggerWebSocketClient.j(andIncrement, stringWriter.toString());
        } catch (IOException e2) {
            jSDebuggerWebSocketClient.k(andIncrement, e2);
        }
        try {
            jSExecutorCallbackFuture.f18915a.acquire();
            Exception exc = jSExecutorCallbackFuture.f18916b;
            if (exc != null) {
                throw exc;
            }
        } catch (Throwable th) {
            throw new JavaJSExecutor.ProxyExecutorException(th);
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public final void setGlobalVariable(String str, String str2) {
        this.f18901a.put(str, str2);
    }
}
