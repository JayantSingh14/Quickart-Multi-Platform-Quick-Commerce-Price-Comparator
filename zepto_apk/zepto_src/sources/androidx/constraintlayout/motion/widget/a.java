package androidx.constraintlayout.motion.widget;

import android.app.Activity;
import android.app.job.JobParameters;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.DispatchQueue;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.ui.PlayerView;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.TransactionExecutor;
import androidx.work.ListenableWorker;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback;
import com.amazonaws.mobileconnectors.remoteconfiguration.RemoteConfigurationManager;
import com.amazonaws.mobileconnectors.remoteconfiguration.exceptions.ConfigurationNotFoundException;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ConfigurationDb;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ConfigurationImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear.LocalConfigInstanceIdGenerationHelper;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfigurationImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.net.RequestThrottledException;
import com.appsflyer.internal.AFj1sSDK;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import com.facebook.react.R;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.DefaultDevLoadingViewImplementation;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.imagepicker.ImagePickerModuleImpl;
import com.imagepicker.Utils;
import com.swmansion.reanimated.layoutReanimation.SharedTransitionManager;
import com.zeptoconsumerapp.slotmachine.SlotMachineView;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2299a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2300b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2301c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f2299a = i2;
        this.f2300b = obj;
        this.f2301c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        RemoteConfiguration remoteConfiguration;
        switch (this.f2299a) {
            case 0:
                ViewTransition viewTransition = (ViewTransition) this.f2300b;
                int i2 = viewTransition.p;
                View[] viewArr = (View[]) this.f2301c;
                if (i2 != -1) {
                    for (View view : viewArr) {
                        view.setTag(viewTransition.p, Long.valueOf(System.nanoTime()));
                    }
                }
                if (viewTransition.q != -1) {
                    for (View view2 : viewArr) {
                        view2.setTag(viewTransition.q, null);
                    }
                    return;
                }
                return;
            case 1:
                ((ResourcesCompat.FontCallback) this.f2300b).c((Typeface) this.f2301c);
                return;
            case 2:
                DispatchQueue this$0 = (DispatchQueue) this.f2300b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Runnable runnable = (Runnable) this.f2301c;
                Intrinsics.checkNotNullParameter(runnable, "$runnable");
                if (!this$0.f4793c.offer(runnable)) {
                    throw new IllegalStateException("cannot enqueue any more runnables");
                }
                this$0.a();
                return;
            case 3:
                int i3 = Util.f5744a;
                if (((SettableFuture) this.f2300b).isCancelled()) {
                    ((ListenableFuture) this.f2301c).cancel(false);
                    return;
                }
                return;
            case 4:
                AudioRendererEventListener.EventDispatcher eventDispatcher = (AudioRendererEventListener.EventDispatcher) this.f2300b;
                eventDispatcher.getClass();
                int i4 = Util.f5744a;
                eventDispatcher.f6524b.g((String) this.f2301c);
                return;
            case 5:
                ((AudioSink.Listener) this.f2300b).c((AudioSink.AudioTrackConfig) this.f2301c);
                return;
            case 6:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) this.f2300b;
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f8424g;
                Surface surface = sphericalGLSurfaceView.f8425h;
                SurfaceTexture surfaceTexture2 = (SurfaceTexture) this.f2301c;
                Surface surface2 = new Surface(surfaceTexture2);
                sphericalGLSurfaceView.f8424g = surfaceTexture2;
                sphericalGLSurfaceView.f8425h = surface2;
                Iterator it = sphericalGLSurfaceView.f8418a.iterator();
                while (it.hasNext()) {
                    ((SphericalGLSurfaceView.VideoSurfaceListener) it.next()).y(surface2);
                }
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                    return;
                }
                return;
            case 7:
                PlayerView.a((PlayerView) this.f2300b, (Bitmap) this.f2301c);
                return;
            case 8:
                MultiInstanceInvalidationClient this$02 = (MultiInstanceInvalidationClient) this.f2300b;
                String[] tables = (String[]) this.f2301c;
                int i5 = MultiInstanceInvalidationClient$callback$1.f11789a;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                Intrinsics.checkNotNullParameter(tables, "$tables");
                this$02.getClass();
                throw null;
            case 9:
                Runnable command = (Runnable) this.f2300b;
                Intrinsics.checkNotNullParameter(command, "$command");
                TransactionExecutor this$03 = (TransactionExecutor) this.f2301c;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                try {
                    command.run();
                    return;
                } finally {
                    this$03.a();
                }
            case 10:
                Processor processor = (Processor) this.f2300b;
                WorkGenerationalId workGenerationalId = (WorkGenerationalId) this.f2301c;
                synchronized (processor.f12626k) {
                    try {
                        Iterator it2 = processor.f12625j.iterator();
                        while (it2.hasNext()) {
                            ((ExecutionListener) it2.next()).c(workGenerationalId, false);
                        }
                    } finally {
                    }
                }
                return;
            case 11:
                if (((WorkerWrapper) this.f2300b).q.isCancelled()) {
                    ((androidx.work.impl.utils.futures.SettableFuture) this.f2301c).cancel(true);
                    return;
                }
                return;
            case 12:
                TimeLimiter this$04 = (TimeLimiter) this.f2300b;
                Intrinsics.checkNotNullParameter(this$04, "this$0");
                StartStopToken token = (StartStopToken) this.f2301c;
                Intrinsics.checkNotNullParameter(token, "$token");
                this$04.f12721b.c(token, 3);
                return;
            case 13:
                List listenersList = (List) this.f2300b;
                Intrinsics.checkNotNullParameter(listenersList, "$listenersList");
                ConstraintTracker this$05 = (ConstraintTracker) this.f2301c;
                Intrinsics.checkNotNullParameter(this$05, "this$0");
                Iterator it3 = listenersList.iterator();
                while (it3.hasNext()) {
                    ((ConstraintListener) it3.next()).a(this$05.f12840e);
                }
                return;
            case 14:
                WorkForegroundRunnable workForegroundRunnable = (WorkForegroundRunnable) this.f2300b;
                boolean zIsCancelled = workForegroundRunnable.f13000a.isCancelled();
                androidx.work.impl.utils.futures.SettableFuture settableFuture = (androidx.work.impl.utils.futures.SettableFuture) this.f2301c;
                if (zIsCancelled) {
                    settableFuture.cancel(true);
                    return;
                } else {
                    settableFuture.k(workForegroundRunnable.f13003d.getForegroundInfoAsync());
                    return;
                }
            case 15:
                ConstraintTrackingWorker this$06 = (ConstraintTrackingWorker) this.f2300b;
                ListenableFuture innerFuture = (ListenableFuture) this.f2301c;
                Intrinsics.checkNotNullParameter(this$06, "this$0");
                Intrinsics.checkNotNullParameter(innerFuture, "$innerFuture");
                synchronized (this$06.f13067f) {
                    try {
                        if (this$06.f13068g) {
                            androidx.work.impl.utils.futures.SettableFuture future = this$06.f13069h;
                            Intrinsics.checkNotNullExpressionValue(future, "future");
                            String str = ConstraintTrackingWorkerKt.f13071a;
                            future.i(new ListenableWorker.Result.Retry());
                        } else {
                            this$06.f13069h.k(innerFuture);
                        }
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 16:
                RemoteConfigurationManager remoteConfigurationManager = (RemoteConfigurationManager) this.f2300b;
                ConfigurationSyncCallback configurationSyncCallback = (ConfigurationSyncCallback) this.f2301c;
                ConfigurationDb configurationDb = remoteConfigurationManager.f15250b;
                if (configurationDb == null) {
                    remoteConfiguration = null;
                } else {
                    try {
                        remoteConfiguration = configurationDb.readRemoteConfiguration(remoteConfigurationManager.f15249a);
                    } catch (ConfigurationNotFoundException unused) {
                    } catch (JSONException unused2) {
                        remoteConfigurationManager.f15250b.deleteConfiguration();
                    }
                    if (remoteConfiguration == null) {
                        remoteConfiguration = null;
                    } else {
                        new JSONObject(remoteConfiguration.getConfiguration().getAsJsonString());
                    }
                }
                synchronized (remoteConfigurationManager) {
                    try {
                        Attributes attributesM56clone = remoteConfigurationManager.f15252d.m56clone();
                        if (remoteConfigurationManager.f15255g.isSyncAllowedRightNow() || (remoteConfigurationManager.f15255g.getCause() == 10 && remoteConfigurationManager.f15254f != attributesM56clone.hashCode())) {
                            String entityTag = remoteConfiguration != null ? remoteConfiguration.getEntityTag() : null;
                            String string = remoteConfigurationManager.f15253e.getString("localConfigurationInstanceId", null);
                            if (TextUtils.isEmpty(string)) {
                                string = LocalConfigInstanceIdGenerationHelper.generateLocalConfigInstanceId(UUID.randomUUID().toString());
                                SharedPreferences.Editor editorEdit = remoteConfigurationManager.f15253e.edit();
                                editorEdit.putString("localConfigurationInstanceId", string);
                                editorEdit.apply();
                            }
                            try {
                                RemoteConfiguration remoteConfigurationFetch = remoteConfigurationManager.f15251c.fetch(remoteConfigurationManager.f15249a, attributesM56clone, entityTag, string);
                                remoteConfigurationManager.f15254f = attributesM56clone.hashCode();
                                remoteConfigurationManager.f15255g.updateSyncTimeAfterSuccess();
                                if (remoteConfigurationFetch.isUpdate()) {
                                    remoteConfigurationManager.f15250b.saveConfiguration(remoteConfigurationFetch);
                                    configurationSyncCallback.onConfigurationModified(remoteConfigurationFetch.getConfiguration());
                                } else {
                                    RemoteConfigurationImpl remoteConfigurationImpl = new RemoteConfigurationImpl(new ConfigurationImpl(remoteConfiguration.getConfiguration().getAsJsonString(), new Date()), remoteConfiguration.getAppConfigurationId(), remoteConfiguration.getOrigin(), remoteConfiguration.getEntityTag(), false);
                                    remoteConfigurationManager.f15250b.saveConfiguration(remoteConfigurationImpl);
                                    configurationSyncCallback.onConfigurationUnmodified(remoteConfigurationImpl.getConfiguration());
                                }
                            } catch (RequestThrottledException unused3) {
                                remoteConfigurationManager.f15255g.updateSyncTimeAfterThrottle(0L);
                                configurationSyncCallback.onThrottle(remoteConfigurationManager.f15255g.getTimeToNextSyncInMS());
                            } catch (Exception e2) {
                                remoteConfigurationManager.f15255g.updateSyncTimeAfterFailure();
                                configurationSyncCallback.onFailure(e2);
                            }
                        } else {
                            configurationSyncCallback.onThrottle(remoteConfigurationManager.f15255g.getTimeToNextSyncInMS());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 17:
                ((AFj1sSDK) this.f2300b).getRevenue((Runnable) this.f2301c);
                return;
            case 18:
                Intrinsics.checkNotNullParameter((PriorityThreadFactory) this.f2300b, "this$0");
                Runnable runnable2 = (Runnable) this.f2301c;
                Intrinsics.checkNotNullParameter(runnable2, "$runnable");
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused4) {
                }
                runnable2.run();
                return;
            case 19:
                MessageQueueThreadImpl.lambda$callOnQueue$0((SimpleSettableFuture) this.f2300b, (Callable) this.f2301c);
                return;
            case 20:
                String str2 = (String) this.f2301c;
                DefaultDevLoadingViewImplementation defaultDevLoadingViewImplementation = (DefaultDevLoadingViewImplementation) this.f2300b;
                PopupWindow popupWindow = defaultDevLoadingViewImplementation.f18793c;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    Activity activityA = defaultDevLoadingViewImplementation.f18791a.a();
                    if (activityA == null) {
                        FLog.g("ReactNative", "Unable to display loading message because react activity isn't available");
                        return;
                    }
                    try {
                        Rect rect = new Rect();
                        activityA.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        int i6 = rect.top;
                        Object systemService = activityA.getSystemService("layout_inflater");
                        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                        View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.dev_loading_view, (ViewGroup) null);
                        Intrinsics.d(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView = (TextView) viewInflate;
                        textView.setText(str2);
                        PopupWindow popupWindow2 = new PopupWindow(textView, -1, -2);
                        popupWindow2.setTouchable(false);
                        popupWindow2.showAtLocation(activityA.getWindow().getDecorView(), 0, 0, i6);
                        defaultDevLoadingViewImplementation.f18792b = textView;
                        defaultDevLoadingViewImplementation.f18793c = popupWindow2;
                        return;
                    } catch (WindowManager.BadTokenException unused5) {
                        FLog.g("ReactNative", "Unable to display loading message because react activity isn't active, message: " + str2);
                        return;
                    }
                }
                return;
            case 21:
                DevSupportManagerBase devSupportManagerBase = (DevSupportManagerBase) this.f2300b;
                devSupportManagerBase.getClass();
                DebugServerException debugServerException = (DebugServerException) this.f2301c;
                devSupportManagerBase.L(debugServerException.getMessage(), debugServerException);
                return;
            case 22:
                ((SurfaceMountingManager) this.f2300b).lambda$addRootView$0((View) this.f2301c);
                return;
            case 23:
                DevLoadingModule.showMessage$lambda$0((DevLoadingModule) this.f2300b, (String) this.f2301c);
                return;
            case 24:
                int i7 = JobInfoSchedulerService.f20868a;
                ((JobInfoSchedulerService) this.f2300b).jobFinished((JobParameters) this.f2301c, false);
                return;
            case 25:
                ((EventHandler) ((Map.Entry) this.f2300b).getKey()).a((Event) this.f2301c);
                return;
            case 26:
                List list = (List) this.f2301c;
                ImagePickerModuleImpl imagePickerModuleImpl = (ImagePickerModuleImpl) this.f2300b;
                imagePickerModuleImpl.getClass();
                try {
                    try {
                        imagePickerModuleImpl.f45932c.invoke(Utils.k(list, imagePickerModuleImpl.f45933d, imagePickerModuleImpl.f45931b));
                    } catch (RuntimeException e3) {
                        imagePickerModuleImpl.f45932c.invoke(Utils.d("others", e3.getMessage()));
                    }
                    return;
                } finally {
                    imagePickerModuleImpl.f45932c = null;
                }
            case 27:
                ((SharedTransitionManager) this.f2300b).lambda$finishSharedAnimation$1((ViewParent) this.f2301c);
                return;
            case 28:
                Activity activity = (Activity) this.f2300b;
                View decorView = activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                new WindowInsetsControllerCompat(activity.getWindow(), decorView).e(((String) this.f2301c).equals("dark"));
                return;
            default:
                int i8 = SlotMachineView.x;
                UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) this.f2300b).getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    SlotMachineView slotMachineView = (SlotMachineView) this.f2301c;
                    uIManagerModule.updateNodeSize(slotMachineView.getId(), (int) slotMachineView.f47824i, slotMachineView.f47821f);
                    return;
                }
                return;
        }
    }
}
