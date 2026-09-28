package androidx.constraintlayout.helper.widget;

import PrefetchAgreementWallet.PrefetchAgreementWalletInterface;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.view.d;
import androidx.lifecycle.ComputableLiveData;
import androidx.media3.common.b;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.amazon.android.apay.commonlibrary.instrumentationlib.logger.KuberMetricEventsLogger;
import com.appsflyer.internal.AFa1tSDK;
import com.appsflyer.internal.AFc1dSDK;
import com.appsflyer.internal.AFd1mSDK;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.fabric.mounting.MountItemDispatcher;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.debug.DevMenuModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.uimanager.ViewManager;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.common.util.concurrent.ListenableFuture;
import com.reactnativepagerview.NestedScrollableHost;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.gesturehandler.react.RNViewConfigurationHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobImpl;
import okhttp3.Call;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2070b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f2069a = i2;
        this.f2070b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        boolean z;
        switch (this.f2069a) {
            case 0:
                Carousel carousel = (Carousel) this.f2070b;
                MotionLayout motionLayout = carousel.r;
                int i2 = carousel.E;
                motionLayout.setTransitionDuration(i2);
                if (carousel.D < carousel.q) {
                    carousel.r.H(carousel.w, i2);
                    return;
                } else {
                    carousel.r.H(carousel.x, i2);
                    return;
                }
            case 1:
                ComputableLiveData this$0 = (ComputableLiveData) this.f2070b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                do {
                    AtomicBoolean atomicBoolean2 = this$0.f4772d;
                    boolean zCompareAndSet = atomicBoolean2.compareAndSet(false, true);
                    atomicBoolean = this$0.f4771c;
                    if (zCompareAndSet) {
                        z = false;
                        Object objA = null;
                        while (atomicBoolean.compareAndSet(true, false)) {
                            try {
                                objA = this$0.a();
                                z = true;
                            } catch (Throwable th) {
                                atomicBoolean2.set(false);
                                throw th;
                            }
                        }
                        if (z) {
                            this$0.f4770b.i(objA);
                        }
                        atomicBoolean2.set(false);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                } while (atomicBoolean.get());
                return;
            case 2:
                DefaultAnalyticsCollector defaultAnalyticsCollector = (DefaultAnalyticsCollector) this.f2070b;
                AnalyticsListener.EventTime eventTimeC = defaultAnalyticsCollector.C();
                defaultAnalyticsCollector.L(eventTimeC, 1028, new b(eventTimeC, 21));
                defaultAnalyticsCollector.f6386f.d();
                return;
            case 3:
                int i3 = SsMediaSource.B;
                ((SsMediaSource) this.f2070b).n0();
                return;
            case 4:
                CoroutineWorker this$02 = (CoroutineWorker) this.f2070b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                if (this$02.f12500f.isCancelled()) {
                    this$02.f12499e.e(null);
                    return;
                }
                return;
            case 5:
                ConstraintTrackingWorker this$03 = (ConstraintTrackingWorker) this.f2070b;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                if (this$03.f13069h.isCancelled()) {
                    return;
                }
                String strB = this$03.getInputData().b("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                Logger loggerE = Logger.e();
                Intrinsics.checkNotNullExpressionValue(loggerE, "get()");
                if (strB == null || strB.length() == 0) {
                    loggerE.c(ConstraintTrackingWorkerKt.f13071a, "No worker to delegate to.");
                    SettableFuture future = this$03.f13069h;
                    Intrinsics.checkNotNullExpressionValue(future, "future");
                    future.i(new ListenableWorker.Result.Failure());
                    return;
                }
                ListenableWorker listenableWorkerB = this$03.getWorkerFactory().b(this$03.getApplicationContext(), strB, this$03.f13066e);
                this$03.f13070i = listenableWorkerB;
                if (listenableWorkerB == null) {
                    loggerE.a(ConstraintTrackingWorkerKt.f13071a, "No worker to delegate to.");
                    SettableFuture future2 = this$03.f13069h;
                    Intrinsics.checkNotNullExpressionValue(future2, "future");
                    future2.i(new ListenableWorker.Result.Failure());
                    return;
                }
                WorkManagerImpl workManagerImplF = WorkManagerImpl.f(this$03.getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(workManagerImplF, "getInstance(applicationContext)");
                WorkSpecDao workSpecDaoV = workManagerImplF.f12655c.v();
                String string = this$03.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
                WorkSpec workSpecJ = workSpecDaoV.j(string);
                if (workSpecJ == null) {
                    SettableFuture future3 = this$03.f13069h;
                    Intrinsics.checkNotNullExpressionValue(future3, "future");
                    String str = ConstraintTrackingWorkerKt.f13071a;
                    future3.i(new ListenableWorker.Result.Failure());
                    return;
                }
                Trackers trackers = workManagerImplF.f12662j;
                Intrinsics.checkNotNullExpressionValue(trackers, "workManagerImpl.trackers");
                WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
                ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl = workManagerImplF.f12656d.f13062b;
                Intrinsics.checkNotNullExpressionValue(executorCoroutineDispatcherImpl, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
                this$03.f13069h.q(new a(WorkConstraintsTrackerKt.b(workConstraintsTracker, workSpecJ, executorCoroutineDispatcherImpl, this$03), 6), new SynchronousExecutor());
                if (!workConstraintsTracker.a(workSpecJ)) {
                    loggerE.a(ConstraintTrackingWorkerKt.f13071a, "Constraints not met for delegate " + strB + ". Requesting retry.");
                    SettableFuture future4 = this$03.f13069h;
                    Intrinsics.checkNotNullExpressionValue(future4, "future");
                    future4.i(new ListenableWorker.Result.Retry());
                    return;
                }
                loggerE.a(ConstraintTrackingWorkerKt.f13071a, "Constraints met for delegate ".concat(strB));
                try {
                    ListenableWorker listenableWorker = this$03.f13070i;
                    Intrinsics.c(listenableWorker);
                    ListenableFuture listenableFutureStartWork = listenableWorker.startWork();
                    Intrinsics.checkNotNullExpressionValue(listenableFutureStartWork, "delegate!!.startWork()");
                    listenableFutureStartWork.q(new androidx.constraintlayout.motion.widget.a(15, this$03, listenableFutureStartWork), this$03.getBackgroundExecutor());
                    return;
                } catch (Throwable th2) {
                    String str2 = ConstraintTrackingWorkerKt.f13071a;
                    loggerE.b(str2, android.support.v4.media.b.D("Delegated worker ", strB, " threw exception in startWork."), th2);
                    synchronized (this$03.f13067f) {
                        try {
                            if (!this$03.f13068g) {
                                SettableFuture future5 = this$03.f13069h;
                                Intrinsics.checkNotNullExpressionValue(future5, "future");
                                future5.i(new ListenableWorker.Result.Failure());
                                return;
                            } else {
                                loggerE.a(str2, "Constraints were unmet, Retrying.");
                                SettableFuture future6 = this$03.f13069h;
                                Intrinsics.checkNotNullExpressionValue(future6, "future");
                                future6.i(new ListenableWorker.Result.Retry());
                                return;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            case 6:
                JobImpl job = (JobImpl) this.f2070b;
                Intrinsics.checkNotNullParameter(job, "$job");
                job.e(null);
                return;
            case 7:
                PrefetchAgreementWalletInterface prefetchAgreementWalletInterface = com.amazon.android.apay.commonlibrary.commonlib.service.a.f14871c;
                com.amazon.android.apay.commonlibrary.commonlib.service.a this$04 = (com.amazon.android.apay.commonlibrary.commonlib.service.a) this.f2070b;
                Intrinsics.checkNotNullParameter(this$04, "this$0");
                this$04.f14875b.shutdown();
                return;
            case 8:
                KuberMetricEventsLogger.a((KuberMetricEventsLogger) this.f2070b);
                return;
            case 9:
                AFa1tSDK.getRevenue((AFc1dSDK) this.f2070b);
                return;
            case 10:
                ((AFd1mSDK) this.f2070b).getMonetizationNetwork();
                return;
            case 11:
                ((Call) this.f2070b).cancel();
                return;
            case 12:
                ((MessageQueueThreadImpl) this.f2070b).lambda$resetPerfStats$1();
                return;
            case 13:
                ((MountItemDispatcher) this.f2070b).lambda$new$0();
                return;
            case 14:
                ((SurfaceMountingManager) this.f2070b).lambda$stopSurface$1();
                return;
            case 15:
                AppearanceModule.setColorScheme$lambda$0((String) this.f2070b);
                return;
            case 16:
                DevMenuModule.reload$lambda$0((DevMenuModule) this.f2070b);
                return;
            case 17:
                DevSettingsModule.reload$lambda$0((DevSettingsModule) this.f2070b);
                return;
            case 18:
                DevLoadingModule.hide$lambda$1((DevLoadingModule) this.f2070b);
                return;
            case 19:
                Iterator it = ((ArrayList) this.f2070b).iterator();
                while (it.hasNext()) {
                    ((ViewManager) it.next()).invalidate();
                }
                return;
            case 20:
                ((CarouselLayoutManager) this.f2070b).c1();
                return;
            case 21:
                EditText editText = (EditText) this.f2070b;
                editText.requestFocus();
                editText.post(new d(2, editText));
                return;
            case 22:
                ((MaterialBackOrchestrator) this.f2070b).a(true);
                return;
            case 23:
                ViewPager2 viewPager2 = (ViewPager2) this.f2070b;
                viewPager2.measure(View.MeasureSpec.makeMeasureSpec(viewPager2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewPager2.getHeight(), 1073741824));
                viewPager2.layout(viewPager2.getLeft(), viewPager2.getTop(), viewPager2.getRight(), viewPager2.getBottom());
                return;
            case 24:
                ((NestedScrollableHost) this.f2070b).setDidSetInitialIndex(true);
                return;
            case 25:
                int i4 = FlingGestureHandler.W;
                ((FlingGestureHandler) this.f2070b).l();
                return;
            case 26:
                RNViewConfigurationHelper rNViewConfigurationHelper = HoverGestureHandler.P;
                ((HoverGestureHandler) this.f2070b).H();
                return;
            case 27:
                ((LongPressGestureHandler) this.f2070b).a(false);
                return;
            case 28:
                ((TapGestureHandler) this.f2070b).l();
                return;
            default:
                RNGestureHandlerModule.install$lambda$2((RNGestureHandlerModule) this.f2070b);
                return;
        }
    }
}
