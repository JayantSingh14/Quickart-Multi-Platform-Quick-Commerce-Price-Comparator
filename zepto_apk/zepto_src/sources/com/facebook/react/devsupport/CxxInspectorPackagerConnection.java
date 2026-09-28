package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
class CxxInspectorPackagerConnection implements IInspectorPackagerConnection {

    @DoNotStrip
    private final HybridData mHybridData;

    /* loaded from: classes3.dex */
    public static class DelegateImpl {

        /* renamed from: a, reason: collision with root package name */
        public final OkHttpClient f18775a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f18776b;

        public DelegateImpl() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.b(10L, timeUnit);
            builder.d(10L, timeUnit);
            builder.c(0L, TimeUnit.MINUTES);
            this.f18775a = new OkHttpClient(builder);
            this.f18776b = new Handler(Looper.getMainLooper());
        }

        @DoNotStrip
        public IWebSocket connectWebSocket(String str, final WebSocketDelegate webSocketDelegate) {
            Request.Builder builder = new Request.Builder();
            builder.i(str);
            final RealWebSocket realWebSocketB = this.f18775a.b(builder.b(), new WebSocketListener() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection.DelegateImpl.1
                @Override // okhttp3.WebSocketListener
                public final void a(RealWebSocket realWebSocket, int i2, String str2) {
                    DelegateImpl.this.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection.DelegateImpl.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            webSocketDelegate.didClose();
                            webSocketDelegate.close();
                        }
                    }, 0L);
                }

                @Override // okhttp3.WebSocketListener
                public final void d(RealWebSocket realWebSocket, final Exception exc, Response response) {
                    DelegateImpl.this.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection.DelegateImpl.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String message = exc.getMessage();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            WebSocketDelegate webSocketDelegate2 = webSocketDelegate;
                            if (message == null) {
                                message = "<Unknown error>";
                            }
                            webSocketDelegate2.didFailWithError(null, message);
                            webSocketDelegate.close();
                        }
                    }, 0L);
                }

                @Override // okhttp3.WebSocketListener
                public final void e(final String str2, RealWebSocket realWebSocket) {
                    DelegateImpl.this.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection.DelegateImpl.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            webSocketDelegate.didReceiveMessage(str2);
                        }
                    }, 0L);
                }
            });
            return new IWebSocket() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection.DelegateImpl.2
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    realWebSocketB.c(1000, "End of session");
                }
            };
        }

        @DoNotStrip
        public void scheduleCallback(Runnable runnable, long j2) {
            this.f18776b.postDelayed(runnable, j2);
        }
    }

    /* loaded from: classes3.dex */
    public interface IWebSocket extends Closeable, AutoCloseable {
    }

    @DoNotStrip
    public static class WebSocketDelegate implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final HybridData f18785a;

        @DoNotStrip
        private WebSocketDelegate(HybridData hybridData) {
            this.f18785a = hybridData;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f18785a.resetNative();
        }

        public native void didClose();

        public native void didFailWithError(@Nullable Integer num, String str);

        public native void didReceiveMessage(String str);
    }

    static {
        DevSupportSoLoader.a();
    }

    public CxxInspectorPackagerConnection(String str, String str2, String str3) {
        this.mHybridData = initHybrid(str, str2, str3, new DelegateImpl());
    }

    private static native HybridData initHybrid(String str, String str2, String str3, DelegateImpl delegateImpl);

    @Override // com.facebook.react.devsupport.IInspectorPackagerConnection
    public native void closeQuietly();

    @Override // com.facebook.react.devsupport.IInspectorPackagerConnection
    public native void connect();

    @Override // com.facebook.react.devsupport.IInspectorPackagerConnection
    public native void sendEventToAllConnections(String str);
}
