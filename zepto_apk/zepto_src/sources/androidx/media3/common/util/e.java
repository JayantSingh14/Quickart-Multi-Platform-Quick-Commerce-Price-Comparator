package androidx.media3.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.session.SessionResult;
import androidx.media3.session.l0;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpecKt;
import com.amazon.android.apay.commonlibrary.commonlib.manager.AppConfigManager;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;
import com.appsflyer.internal.AFa1tSDK;
import com.appsflyer.internal.AFd1uSDK;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.DelayProducer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.reactnativepagerview.NestedScrollableHost;
import com.reactnativepagerview.PagerViewViewManager;
import com.th3rdwave.safeareacontext.SafeAreaView;
import in.juspay.hyperapay.APayBridge;
import in.juspay.hypersdk.analytics.LogChannelExp;
import in.juspay.hypersdk.analytics.LogManager;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.services.SdkConfigService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.ActivityFramesTracker;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.internal.util.ScreenshotUtils;
import io.sentry.android.replay.ScreenshotRecorder;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.TextLayout;
import io.sentry.android.replay.util.ViewsKt;
import io.sentry.android.replay.viewhierarchy.ViewHierarchyNode;
import io.sentry.react.RNSentryModuleImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.Message;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5765a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5766b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5767c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5768d;

    public /* synthetic */ e(SettableFuture settableFuture, l0 l0Var, SessionResult sessionResult) {
        this.f5765a = 1;
        this.f5766b = settableFuture;
        this.f5767c = l0Var;
        this.f5768d = sessionResult;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.media3.exoplayer.drm.DrmSessionEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4, types: [io.sentry.android.replay.d] */
    @Override // java.lang.Runnable
    public final void run() throws JSONException, IllegalAccessException, InstantiationException {
        boolean zBooleanValue = true;
        switch (this.f5765a) {
            case 0:
                ListenableFuture listenableFuture = (ListenableFuture) this.f5767c;
                SettableFuture settableFuture = (SettableFuture) this.f5766b;
                AsyncFunction asyncFunction = (AsyncFunction) this.f5768d;
                int i2 = Util.f5744a;
                try {
                    try {
                        settableFuture.p(asyncFunction.apply(Futures.b(listenableFuture)));
                        return;
                    } catch (Throwable th) {
                        settableFuture.o(th);
                        return;
                    }
                } catch (Error e2) {
                    e = e2;
                    settableFuture.o(e);
                    return;
                } catch (CancellationException unused) {
                    settableFuture.cancel(false);
                    return;
                } catch (RuntimeException e3) {
                    e = e3;
                    settableFuture.o(e);
                    return;
                } catch (ExecutionException e4) {
                    e = e4;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    settableFuture.o(e);
                    return;
                }
            case 1:
                SettableFuture settableFuture2 = (SettableFuture) this.f5766b;
                l0 l0Var = (l0) this.f5767c;
                SessionResult sessionResult = (SessionResult) this.f5768d;
                int i3 = Util.f5744a;
                try {
                    if (settableFuture2.isCancelled()) {
                        return;
                    }
                    l0Var.run();
                    settableFuture2.n(sessionResult);
                    return;
                } catch (Throwable th2) {
                    settableFuture2.o(th2);
                    return;
                }
            case 2:
                AudioRendererEventListener.EventDispatcher eventDispatcher = (AudioRendererEventListener.EventDispatcher) this.f5767c;
                eventDispatcher.getClass();
                int i4 = Util.f5744a;
                eventDispatcher.f6524b.m((Format) this.f5766b, (DecoderReuseEvaluation) this.f5768d);
                return;
            case 3:
                DrmSessionEventListener.EventDispatcher eventDispatcher2 = (DrmSessionEventListener.EventDispatcher) this.f5767c;
                this.f5766b.K(eventDispatcher2.f6924a, eventDispatcher2.f6925b, (Exception) this.f5768d);
                return;
            case 4:
                MediaSourceEventListener.EventDispatcher eventDispatcher3 = (MediaSourceEventListener.EventDispatcher) this.f5767c;
                this.f5766b.R(eventDispatcher3.f7614a, eventDispatcher3.f7615b, (MediaLoadData) this.f5768d);
                return;
            case 5:
                VideoRendererEventListener.EventDispatcher eventDispatcher4 = (VideoRendererEventListener.EventDispatcher) this.f5767c;
                eventDispatcher4.getClass();
                int i5 = Util.f5744a;
                eventDispatcher4.f8347b.u((Format) this.f5766b, (DecoderReuseEvaluation) this.f5768d);
                return;
            case 6:
                Processor processor = (Processor) this.f5767c;
                androidx.work.impl.utils.futures.SettableFuture settableFuture3 = (androidx.work.impl.utils.futures.SettableFuture) this.f5766b;
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f5768d;
                String str = Processor.f12615l;
                processor.getClass();
                try {
                    zBooleanValue = ((Boolean) settableFuture3.get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused2) {
                }
                synchronized (processor.f12626k) {
                    try {
                        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workerWrapper.f12668d);
                        String str2 = workGenerationalIdA.f12893a;
                        if (processor.c(str2) == workerWrapper) {
                            processor.b(str2);
                        }
                        Logger.e().a(Processor.f12615l, processor.getClass().getSimpleName() + StringUtils.SPACE + str2 + " executed; reschedule = " + zBooleanValue);
                        Iterator it = processor.f12625j.iterator();
                        while (it.hasNext()) {
                            ((ExecutionListener) it.next()).c(workGenerationalIdA, zBooleanValue);
                        }
                    } finally {
                    }
                }
                return;
            case 7:
                AppConfigManager.a((AppConfigManager) this.f5767c, (Context) this.f5766b, (String) this.f5768d);
                return;
            case 8:
                KuberMetricEventsLogger.a((String) this.f5767c, (String) this.f5766b, (KuberMetricEventsLogger) this.f5768d);
                return;
            case 9:
                ((AFa1tSDK) this.f5767c).d_((Context) this.f5766b, (Intent) this.f5768d);
                return;
            case 10:
                AFd1uSDK.getMediationNetwork((AFd1uSDK) this.f5767c, (Throwable) this.f5766b, (String) this.f5768d);
                return;
            case 11:
                ComponentActivity componentActivity = (ComponentActivity) this.f5767c;
                componentActivity.removeOnPictureInPictureModeChangedListener((com.brentvatne.exoplayer.c) this.f5766b);
                componentActivity.removeOnUserLeaveHintListener((com.brentvatne.exoplayer.d) this.f5768d);
                return;
            case 12:
                ReactExoplayerView reactExoplayerView = (ReactExoplayerView) this.f5767c;
                boolean z = reactExoplayerView.e1;
                Source source = (Source) this.f5766b;
                if (z && source == reactExoplayerView.E0) {
                    return;
                }
                try {
                    reactExoplayerView.U(source);
                    return;
                } catch (Exception e5) {
                    ((ReactExoplayerView) this.f5768d).f15572m = true;
                    DebugLog.b("ReactExoplayerView", "Failed to initialize Player! 1");
                    DebugLog.b("ReactExoplayerView", e5.toString());
                    e5.printStackTrace();
                    reactExoplayerView.f15560a.f15444c.invoke(e5.toString(), e5, "1001");
                    return;
                }
            case 13:
                EncodedImage encodedImage = (EncodedImage) this.f5768d;
                BufferedDiskCache this$0 = (BufferedDiskCache) this.f5767c;
                CacheKey key = (CacheKey) this.f5766b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(key, "$key");
                try {
                    this$0.f(key, encodedImage);
                    Intrinsics.c(encodedImage);
                    this$0.f17736g.e(key, encodedImage);
                    encodedImage.close();
                    return;
                } catch (Throwable th3) {
                    try {
                        Intrinsics.checkNotNullParameter(th3, "th");
                        throw th3;
                    } catch (Throwable th4) {
                        StagingArea stagingArea = this$0.f17736g;
                        Intrinsics.c(encodedImage);
                        stagingArea.e(key, encodedImage);
                        encodedImage.close();
                        throw th4;
                    }
                }
            case 14:
                DelayProducer this$02 = (DelayProducer) this.f5767c;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                com.facebook.imagepipeline.producers.Consumer consumer = (com.facebook.imagepipeline.producers.Consumer) this.f5766b;
                Intrinsics.checkNotNullParameter(consumer, "$consumer");
                ProducerContext context = (ProducerContext) this.f5768d;
                Intrinsics.checkNotNullParameter(context, "$context");
                this$02.getClass();
                throw null;
            case 15:
                PagerViewViewManager.createViewInstance$lambda$0((ViewPager2) this.f5767c, (PagerViewViewManager) this.f5766b, (NestedScrollableHost) this.f5768d);
                return;
            case 16:
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) this.f5766b;
                Condition condition = (Condition) this.f5768d;
                int i6 = SafeAreaView.f47168f;
                ReentrantLock reentrantLock = (ReentrantLock) this.f5767c;
                reentrantLock.lock();
                try {
                    if (!booleanRef.f53798a) {
                        booleanRef.f53798a = true;
                        condition.signal();
                    }
                    Unit unit = Unit.f53572a;
                    reentrantLock.unlock();
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            case 17:
                APayBridge.getAmazonpayPaymentMetadata$lambda$6((String) this.f5767c, (APayBridge) this.f5766b, (String) this.f5768d);
                return;
            case 18:
                LogManager.Companion.registerSavedWorkspaces$lambda$0((Context) this.f5767c, (SdkConfigService) this.f5766b, (JSONObject) this.f5768d);
                return;
            case 19:
                ((LogPusherExp) this.f5767c).lambda$clearBacklog$0((String) this.f5766b, (LogChannelExp) this.f5768d);
                return;
            case 20:
                ((LogPusherExp) this.f5767c).lambda$addLogLines$3((String) this.f5766b, (String) this.f5768d);
                return;
            case 21:
                ((LogSessioniser) this.f5767c).lambda$addLogLine$4((JSONObject) this.f5766b, (String) this.f5768d);
                return;
            case 22:
                Runnable runnable = (Runnable) this.f5766b;
                ActivityFramesTracker activityFramesTracker = (ActivityFramesTracker) this.f5767c;
                activityFramesTracker.getClass();
                try {
                    runnable.run();
                    return;
                } catch (Throwable unused3) {
                    String str3 = (String) this.f5768d;
                    if (str3 != null) {
                        activityFramesTracker.f51997b.getLogger().c(SentryLevel.WARNING, "Failed to execute ".concat(str3), new Object[0]);
                        return;
                    }
                    return;
                }
            case 23:
                Window window = (Window) this.f5766b;
                final View view = (View) this.f5768d;
                final ScreenshotRecorder this$03 = (ScreenshotRecorder) this.f5767c;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                try {
                    this$03.f52476l.set(false);
                    PixelCopy.request(window, this$03.f52473i, (PixelCopy.OnPixelCopyFinishedListener) new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.replay.d
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i7) {
                            final ScreenshotRecorder this$04 = this$03;
                            Intrinsics.checkNotNullParameter(this$04, "this$0");
                            if (i7 != 0) {
                                this$04.f52466b.getLogger().c(SentryLevel.INFO, "Failed to capture replay recording: %d", Integer.valueOf(i7));
                                this$04.n.set(false);
                                return;
                            }
                            boolean z2 = this$04.f52476l.get();
                            SentryOptions sentryOptions = this$04.f52466b;
                            if (z2) {
                                sentryOptions.getLogger().c(SentryLevel.INFO, "Failed to determine view hierarchy, not capturing", new Object[0]);
                                this$04.n.set(false);
                                return;
                            }
                            View view2 = view;
                            final ViewHierarchyNode viewHierarchyNodeA = ViewHierarchyNode.Companion.a(view2, null, 0, sentryOptions);
                            ViewsKt.b(view2, viewHierarchyNodeA, sentryOptions);
                            ExecutorsKt.c(this$04.f52468d, sentryOptions, "screenshot_recorder.mask", new Runnable() { // from class: io.sentry.android.replay.e
                                /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlin.Lazy] */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    final ScreenshotRecorder this$05 = this$04;
                                    Intrinsics.checkNotNullParameter(this$05, "this$0");
                                    ViewHierarchyNode viewHierarchy = viewHierarchyNodeA;
                                    Intrinsics.checkNotNullParameter(viewHierarchy, "$viewHierarchy");
                                    final Canvas canvas = new Canvas(this$05.f52473i);
                                    canvas.setMatrix((Matrix) this$05.f52475k.getValue());
                                    viewHierarchy.a(new Function1<ViewHierarchyNode, Boolean>() { // from class: io.sentry.android.replay.ScreenshotRecorder$capture$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, kotlin.Lazy] */
                                        /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object, kotlin.Lazy] */
                                        /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object, kotlin.Lazy] */
                                        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, kotlin.Lazy] */
                                        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlin.Lazy] */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Pair pair;
                                            Integer numE;
                                            List listH;
                                            ViewHierarchyNode node = (ViewHierarchyNode) obj;
                                            Intrinsics.checkNotNullParameter(node, "node");
                                            if (node.f52658d && node.f52655a > 0 && node.f52656b > 0) {
                                                Rect globalRect = node.f52659e;
                                                if (globalRect == null) {
                                                    return Boolean.FALSE;
                                                }
                                                boolean z3 = node instanceof ViewHierarchyNode.ImageViewHierarchyNode;
                                                int i8 = 1;
                                                int i9 = 0;
                                                ScreenshotRecorder screenshotRecorder = this$05;
                                                if (z3) {
                                                    List listH2 = CollectionsKt.H(globalRect);
                                                    Bitmap bitmap = screenshotRecorder.f52473i;
                                                    Rect rect = new Rect(globalRect);
                                                    RectF rectF = new RectF(rect);
                                                    ((Matrix) screenshotRecorder.f52475k.getValue()).mapRect(rectF);
                                                    rectF.round(rect);
                                                    ((Canvas) screenshotRecorder.f52474j.getValue()).drawBitmap(bitmap, rect, new Rect(0, 0, 1, 1), (Paint) null);
                                                    pair = new Pair(listH2, Integer.valueOf(((Bitmap) screenshotRecorder.f52472h.getValue()).getPixel(0, 0)));
                                                } else {
                                                    if (node instanceof ViewHierarchyNode.TextViewHierarchyNode) {
                                                        ViewHierarchyNode.TextViewHierarchyNode textViewHierarchyNode = (ViewHierarchyNode.TextViewHierarchyNode) node;
                                                        TextLayout textLayout = textViewHierarchyNode.f52661g;
                                                        int iIntValue = ((textLayout == null || (numE = textLayout.e()) == null) && (numE = textViewHierarchyNode.f52662h) == null) ? -16777216 : numE.intValue();
                                                        Intrinsics.checkNotNullParameter(globalRect, "globalRect");
                                                        if (textLayout == null) {
                                                            listH = CollectionsKt.H(globalRect);
                                                        } else {
                                                            ArrayList arrayList = new ArrayList();
                                                            int iD = textLayout.d();
                                                            int i10 = 0;
                                                            while (i10 < iD) {
                                                                int iB = (int) textLayout.b(i10, textLayout.c(i10));
                                                                int iG = textLayout.g(i10);
                                                                int iF = textLayout.f(i10);
                                                                int iB2 = (int) textLayout.b(i10, (iF - iG) + (iG > 0 ? i8 : i9));
                                                                if (iB2 == 0 && iF > 0) {
                                                                    iB2 = ((int) textLayout.b(i10, iF - 1)) + i8;
                                                                }
                                                                int iA = textLayout.a(i10);
                                                                int iH = textLayout.h(i10);
                                                                Rect rect2 = new Rect();
                                                                int i11 = globalRect.left + textViewHierarchyNode.f52663i + iB;
                                                                rect2.left = i11;
                                                                rect2.right = (iB2 - iB) + i11;
                                                                int i12 = globalRect.top + textViewHierarchyNode.f52664j + iA;
                                                                rect2.top = i12;
                                                                rect2.bottom = (iH - iA) + i12;
                                                                arrayList.add(rect2);
                                                                i10++;
                                                                i8 = 1;
                                                                i9 = 0;
                                                            }
                                                            listH = arrayList;
                                                        }
                                                        pair = new Pair(listH, Integer.valueOf(iIntValue));
                                                    } else {
                                                        pair = new Pair(CollectionsKt.H(globalRect), -16777216);
                                                    }
                                                }
                                                List list = (List) pair.f53533a;
                                                ((Paint) screenshotRecorder.f52471g.getValue()).setColor(((Number) pair.f53534b).intValue());
                                                Iterator it2 = list.iterator();
                                                while (it2.hasNext()) {
                                                    canvas.drawRoundRect(new RectF((Rect) it2.next()), 10.0f, 10.0f, (Paint) screenshotRecorder.f52471g.getValue());
                                                }
                                            }
                                            return Boolean.TRUE;
                                        }
                                    });
                                    this$05.f52469e.x(this$05.f52473i);
                                    this$05.n.set(true);
                                    this$05.f52476l.set(false);
                                }
                            });
                        }
                    }, this$03.f52467c.f52630a);
                    return;
                } catch (Throwable th5) {
                    this$03.f52466b.getLogger().b(SentryLevel.WARNING, "Failed to capture replay recording", th5);
                    this$03.n.set(false);
                    return;
                }
            case 24:
                Runnable task = (Runnable) this.f5767c;
                Intrinsics.checkNotNullParameter(task, "$task");
                SentryOptions options = (SentryOptions) this.f5766b;
                Intrinsics.checkNotNullParameter(options, "$options");
                String taskName = (String) this.f5768d;
                Intrinsics.checkNotNullParameter(taskName, "$taskName");
                try {
                    task.run();
                    return;
                } catch (Throwable th6) {
                    options.getLogger().b(SentryLevel.ERROR, "Failed to execute task " + taskName, th6);
                    return;
                }
            case 25:
                ((byte[][]) this.f5767c)[0] = ScreenshotUtils.a((Activity) this.f5766b, AndroidMainThreadChecker.f52307a, RNSentryModuleImpl.f52986l, RNSentryModuleImpl.f52987m);
                ((CountDownLatch) this.f5768d).countDown();
                return;
            default:
                ((SimpleResolver) this.f5767c).lambda$sendAsync$0((CompletableFuture) this.f5766b, (Message) this.f5768d);
                return;
        }
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i2) {
        this.f5765a = i2;
        this.f5767c = obj;
        this.f5766b = obj2;
        this.f5768d = obj3;
    }
}
