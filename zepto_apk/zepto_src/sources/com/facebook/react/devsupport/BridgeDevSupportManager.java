package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.debug.holder.NoopPrinter;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor.AnonymousClass1;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class BridgeDevSupportManager extends DevSupportManagerBase {

    /* renamed from: com.facebook.react.devsupport.BridgeDevSupportManager$1, reason: invalid class name */
    class AnonymousClass1 implements DevSupportManagerBase.CallbackWithBundleLoader {
    }

    /* renamed from: com.facebook.react.devsupport.BridgeDevSupportManager$2, reason: invalid class name */
    class AnonymousClass2 implements WebsocketJavaScriptExecutor.JSExecutorConnectCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleSettableFuture f18758a;

        public AnonymousClass2(SimpleSettableFuture simpleSettableFuture) {
            this.f18758a = simpleSettableFuture;
        }

        @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
        public final void onSuccess() {
            Boolean bool = Boolean.TRUE;
            SimpleSettableFuture simpleSettableFuture = this.f18758a;
            CountDownLatch countDownLatch = simpleSettableFuture.f18717a;
            if (countDownLatch.getCount() == 0) {
                throw new RuntimeException("Result has already been set!");
            }
            simpleSettableFuture.f18718b = bool;
            countDownLatch.countDown();
            BridgeDevSupportManager bridgeDevSupportManager = BridgeDevSupportManager.this;
            bridgeDevSupportManager.f18827j.c();
            bridgeDevSupportManager.o = false;
        }
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase
    public final String G() {
        return "Bridge";
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void w() {
        UiThreadUtil.assertOnUiThread();
        ReactMarkerConstants reactMarkerConstants = ReactMarkerConstants.RELOAD;
        DevInternalSettings devInternalSettings = this.q;
        ReactMarker.logMarker(reactMarkerConstants, devInternalSettings.f18796c.a());
        j();
        boolean zA = devInternalSettings.a();
        NoopPrinter noopPrinter = NoopPrinter.f17189a;
        DevServerHelper devServerHelper = this.f18821d;
        if (!zA) {
            noopPrinter.a(ReactDebugOverlayTags.f17190a, "RNCore: load from Server");
            String str = this.f18824g;
            Assertions.c(str);
            I(devServerHelper.b(str), new c(this));
            return;
        }
        noopPrinter.a(ReactDebugOverlayTags.f17190a, "RNCore: load from Proxy");
        Context context = this.f18818a;
        if (context != null) {
            this.f18827j.a(context.getString(R.string.catalyst_debug_connecting));
            this.o = true;
        }
        devServerHelper.d();
        JavaJSExecutor.Factory proxyExecutorFactory = new JavaJSExecutor.Factory() { // from class: com.facebook.react.devsupport.BridgeDevSupportManager.3
            @Override // com.facebook.react.bridge.JavaJSExecutor.Factory
            public final JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                BridgeDevSupportManager bridgeDevSupportManager = BridgeDevSupportManager.this;
                DevServerHelper devServerHelper2 = bridgeDevSupportManager.f18821d;
                devServerHelper2.getClass();
                Locale locale = Locale.US;
                String strD = android.support.v4.media.b.D("ws://", devServerHelper2.f18798b.a(), "/debugger-proxy?role=client");
                websocketJavaScriptExecutor.a(strD, websocketJavaScriptExecutor.new AnonymousClass1(bridgeDevSupportManager.new AnonymousClass2(simpleSettableFuture), new AtomicInteger(3), strD));
                try {
                    simpleSettableFuture.get(90L, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (InterruptedException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                } catch (ExecutionException e3) {
                    throw ((Exception) e3.getCause());
                } catch (TimeoutException e4) {
                    e = e4;
                    throw new RuntimeException(e);
                }
            }
        };
        this.f18823f.getClass();
        Intrinsics.checkNotNullParameter(proxyExecutorFactory, "proxyExecutorFactory");
    }
}
