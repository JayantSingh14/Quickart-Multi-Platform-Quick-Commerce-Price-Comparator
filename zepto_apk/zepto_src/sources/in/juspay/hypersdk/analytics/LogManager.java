package in.juspay.hypersdk.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.services.SdkConfigService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class LogManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<String, LogManager> GLOBAL_LOG_MANAGER_MAP = new ConcurrentHashMap<>();

    @NotNull
    private static final AtomicBoolean INIT_STATE = new AtomicBoolean(false);
    private final boolean classicEnabled;
    private final boolean experimentalEnabled;

    @JvmField
    @NotNull
    public final LogConfig logConfig;

    @NotNull
    private final LogMode logMode;

    @Nullable
    private Timer logPushTimer;
    private LogPusher.LogPushTimerTask logPushTimerTask;

    @JvmField
    @NotNull
    public final LogPusher logPusher;

    @NotNull
    private final LogPusherExp logPusherExp;

    @NotNull
    private final AtomicInteger logPusherNumCounter;

    @JvmField
    @NotNull
    public final LogSessioniser logSessioniser;

    @NotNull
    private final LogSessioniserExp logSessioniserExp;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SharedPreferences getAnalyticsSharedPreferences(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(LogConstants.ANALYTICS_SHARED_PREFERENCES, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "ctx.getSharedPreferences…ODE_PRIVATE\n            )");
            return sharedPreferences;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LogMode getLogMode(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logsConfig");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("workingLogger", "json-array");
                if (Intrinsics.b(strOptString, "byte-d-json")) {
                    return LogMode.BYTE_D_JSON;
                }
                if (Intrinsics.b(strOptString, "both")) {
                    return LogMode.BOTH;
                }
            }
            return LogMode.JSON_ARRAY;
        }

        private final List<Workspace> loadSavedWorkspaces(Context context) {
            List listSplit$default;
            ArrayList arrayList = null;
            String string = getAnalyticsSharedPreferences(context).getString(LogConstants.SAVED_WORKSPACES, null);
            if (string != null && (listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{","}, false, 0, 6, null)) != null) {
                arrayList = new ArrayList(CollectionsKt.r(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Workspace(context, (String) it.next(), false, 4, null));
                }
            }
            return arrayList == null ? new ArrayList() : arrayList;
        }

        private final void registerSavedWorkspaces(Context context, SdkConfigService sdkConfigService, JSONObject jSONObject) {
            ExecutorManager.runOnLogsPool(new androidx.media3.common.util.e(context, sdkConfigService, jSONObject, 18));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerSavedWorkspaces$lambda$0(Context ctx, SdkConfigService sdkConfigService, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(ctx, "$ctx");
            Intrinsics.checkNotNullParameter(sdkConfigService, "$sdkConfigService");
            ExecutorManager.setLogsThreadId(Thread.currentThread().getId());
            for (Workspace workspace : LogManager.Companion.loadSavedWorkspaces(ctx)) {
                Companion companion = LogManager.Companion;
                JSONObject sdkConfig = sdkConfigService.getSdkConfig();
                Intrinsics.checkNotNullExpressionValue(sdkConfig, "sdkConfigService.sdkConfig");
                companion.registerWorkspace(ctx, workspace, sdkConfig, false, jSONObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerWorkspace$lambda$2(Context ctx, String workspacePath) {
            Intrinsics.checkNotNullParameter(ctx, "$ctx");
            Intrinsics.checkNotNullParameter(workspacePath, "$workspacePath");
            LogManager.Companion.saveWorkspace(ctx, workspacePath);
        }

        private final void saveWorkspace(Context context, String str) {
            List listSplit$default;
            SharedPreferences analyticsSharedPreferences = getAnalyticsSharedPreferences(context);
            String string = analyticsSharedPreferences.getString(LogConstants.SAVED_WORKSPACES, null);
            Boolean boolValueOf = (string == null || (listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{","}, false, 0, 6, null)) == null) ? null : Boolean.valueOf(listSplit$default.contains(str));
            if (Intrinsics.b(boolValueOf, Boolean.TRUE)) {
                str = null;
            } else if (Intrinsics.b(boolValueOf, Boolean.FALSE)) {
                str = string + ',' + str;
            } else if (boolValueOf != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (str != null) {
                analyticsSharedPreferences.edit().putString(LogConstants.SAVED_WORKSPACES, str).apply();
            }
        }

        @JvmStatic
        @NotNull
        public final LogManager registerWorkspace(@NotNull Context ctx, @NotNull Workspace workspace, @NotNull JSONObject sdkConfig, @Nullable JSONObject jSONObject, @NotNull SdkConfigService sdkConfigService) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(workspace, "workspace");
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            Intrinsics.checkNotNullParameter(sdkConfigService, "sdkConfigService");
            LogManager logManagerRegisterWorkspace = registerWorkspace(ctx, workspace, sdkConfig, true, jSONObject);
            if (!LogManager.INIT_STATE.getAndSet(true)) {
                registerSavedWorkspaces(ctx, sdkConfigService, jSONObject);
            }
            return logManagerRegisterWorkspace;
        }

        private Companion() {
        }

        private final LogManager registerWorkspace(Context context, Workspace workspace, JSONObject jSONObject, boolean z, JSONObject jSONObject2) {
            String path = workspace.getPath();
            LogManager logManager = (LogManager) LogManager.GLOBAL_LOG_MANAGER_MAP.get(path);
            if (logManager != null) {
                return logManager;
            }
            if (z) {
                ExecutorManager.runOnBackgroundThread(new in.juspay.hypernfc.b(3, context, path));
            }
            LogManager logManager2 = new LogManager(workspace, jSONObject, jSONObject2, null);
            LogManager logManager3 = (LogManager) LogManager.GLOBAL_LOG_MANAGER_MAP.putIfAbsent(path, logManager2);
            if (logManager3 != null) {
                return logManager3;
            }
            logManager2.initialize();
            return logManager2;
        }
    }

    @Metadata
    public enum LogMode {
        JSON_ARRAY,
        BYTE_D_JSON,
        BOTH
    }

    public /* synthetic */ LogManager(Workspace workspace, JSONObject jSONObject, JSONObject jSONObject2, DefaultConstructorMarker defaultConstructorMarker) {
        this(workspace, jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(LogManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logSessioniser.clearBacklog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$1(LogManager this$0) throws JSONException, IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logPusherExp.clearBacklog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$2(LogManager this$0) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logPusher.loadSavedChannels();
    }

    @JvmStatic
    @NotNull
    public static final LogManager registerWorkspace(@NotNull Context context, @NotNull Workspace workspace, @NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NotNull SdkConfigService sdkConfigService) {
        return Companion.registerWorkspace(context, workspace, jSONObject, jSONObject2, sdkConfigService);
    }

    private final void startLogPusherTimer() {
        ExecutorManager.runOnLogsPool(new a(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLogPusherTimer$lambda$4(LogManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.logConfig.shouldPush) {
            try {
                this$0.logPusher.setPushState(true);
                this$0.logSessioniser.startLogSessioniser();
                Timer timer = new Timer();
                this$0.logPushTimer = timer;
                LogPusher.LogPushTimerTask logPushTimerTask = this$0.logPushTimerTask;
                long j2 = this$0.logConfig.logPostInterval;
                timer.scheduleAtFixedRate(logPushTimerTask, j2, j2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPushTasks$lambda$3(LogManager this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logSessioniserExp.startLogSessioniser();
        if (z) {
            this$0.logSessioniserExp.startPushing();
        }
    }

    private final void stopLogPusherOnTerminate() {
        ExecutorManager.runOnLogsPool(new a(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopLogPusherOnTerminate$lambda$5(LogManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.logConfig.shouldPush) {
            try {
                this$0.logSessioniser.stopLogSessioniserOnTerminate();
                Timer timer = this$0.logPushTimer;
                if (timer != null) {
                    timer.cancel();
                }
                LogPusher.LogPushTimerTask logPushTimerTaskCreatePusherTask = this$0.logPusher.createPusherTask();
                this$0.logPushTimerTask = logPushTimerTaskCreatePusherTask;
                logPushTimerTaskCreatePusherTask.run();
                this$0.logPusher.setPushState(false);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean addChannel(@Nullable String str, @Nullable String str2) {
        if (this.classicEnabled) {
            return this.logPusher.addChannelFromJS(str, str2);
        }
        return false;
    }

    public final boolean addChannelExp(@Nullable String str, @Nullable String str2) {
        if (this.experimentalEnabled) {
            return this.logPusherExp.addChannelFromJS(str, str2);
        }
        return false;
    }

    public final void addLogLine(@Nullable String str, @Nullable JSONObject jSONObject) {
        if (this.classicEnabled) {
            this.logSessioniser.addLogLine(str, jSONObject);
        }
        if (this.experimentalEnabled) {
            this.logSessioniserExp.addLogLine(jSONObject);
        }
    }

    public final void addLogsToPersistedQueue(@Nullable JSONObject jSONObject) {
        if (this.classicEnabled) {
            this.logPusher.addLogsToPersistedQueue(jSONObject);
        }
        if (this.experimentalEnabled) {
            this.logPusherExp.addLogsToPersistedQueue(jSONObject);
        }
    }

    public final boolean experimentalEnabled() {
        return this.experimentalEnabled;
    }

    @Keep
    public final void flushLogPush() {
        if (this.classicEnabled) {
            this.logSessioniser.pushLogsToPusher();
            LogPusher.LogPushTimerTask logPushTimerTask = this.logPushTimerTask;
            if (logPushTimerTask != null) {
                logPushTimerTask.pushAllLogs();
            }
        }
        if (this.experimentalEnabled) {
            this.logPusherExp.pushAllLogs();
        }
    }

    @NotNull
    public final String[] getChannelNames() {
        if (!this.classicEnabled) {
            return new String[0];
        }
        String[] channelNames = this.logPusher.getChannelNames();
        Intrinsics.checkNotNullExpressionValue(channelNames, "logPusher.channelNames");
        return channelNames;
    }

    @NotNull
    public final String[] getChannelNamesExp() {
        if (!this.experimentalEnabled) {
            return new String[0];
        }
        Set<String> channelNames = this.logPusherExp.getChannelNames();
        Intrinsics.checkNotNullExpressionValue(channelNames, "logPusherExp.channelNames");
        return (String[]) channelNames.toArray(new String[0]);
    }

    public final void initialize() {
        ExecutorManager.runOnLogsPool(new a(this, 0));
        ExecutorManager.runOnLogSessioniserThread(new a(this, 1));
        ExecutorManager.runOnLogsPool(new a(this, 2));
    }

    public final void setEndPointSandbox(boolean z) {
        if (this.classicEnabled) {
            this.logPusher.setEndPointSandbox(Boolean.valueOf(z));
        }
        if (this.experimentalEnabled) {
            this.logPusherExp.setEndPointSandbox(Boolean.valueOf(z));
        }
    }

    public final void setHeaders(@Nullable JSONObject jSONObject, @Nullable String str) {
        if (this.classicEnabled) {
            this.logPusher.setHeaders(jSONObject, str);
        }
        if (this.experimentalEnabled) {
            this.logPusherExp.setHeaders(jSONObject, str);
        }
    }

    public final void setLogHeaderValues(@Nullable JSONObject jSONObject) {
        if (this.classicEnabled) {
            this.logPusher.setLogHeaderValuesForChannels(jSONObject);
        }
        if (this.experimentalEnabled) {
            this.logPusherExp.setLogHeaderValuesForChannels(jSONObject);
        }
    }

    public final void startPushExp() {
        if (this.experimentalEnabled) {
            this.logSessioniserExp.startPushing();
        }
    }

    public final void startPushTasks(boolean z) {
        if (this.logPusherNumCounter.getAndIncrement() == 0) {
            if (this.classicEnabled) {
                startLogPusherTimer();
            }
            if (this.experimentalEnabled) {
                ExecutorManager.runOnLogSessioniserThread(new androidx.media3.exoplayer.audio.h(this, z, 4));
            }
        }
    }

    public final void stopPushTasks() {
        if (this.logPusherNumCounter.decrementAndGet() <= 0) {
            this.logPusherNumCounter.set(0);
            if (this.classicEnabled) {
                stopLogPusherOnTerminate();
            }
            if (this.experimentalEnabled) {
                this.logSessioniserExp.stopLogSessioniserOnTerminate();
            }
        }
    }

    private LogManager(Workspace workspace, JSONObject jSONObject, JSONObject jSONObject2) {
        LogConfig logConfig = new LogConfig(jSONObject, jSONObject2);
        this.logConfig = logConfig;
        LogPusher logPusher = new LogPusher(workspace, logConfig);
        this.logPusher = logPusher;
        this.logSessioniser = new LogSessioniser(workspace, logConfig, logPusher);
        LogPusherExp logPusherExp = new LogPusherExp(workspace, logConfig);
        this.logPusherExp = logPusherExp;
        this.logSessioniserExp = new LogSessioniserExp(workspace, logConfig, logPusherExp);
        this.logPusherNumCounter = new AtomicInteger(0);
        this.logPushTimerTask = logPusher.createPusherTask();
        LogMode logMode = Companion.getLogMode(jSONObject);
        this.logMode = logMode;
        this.classicEnabled = logMode == LogMode.JSON_ARRAY || logMode == LogMode.BOTH;
        this.experimentalEnabled = logMode == LogMode.BYTE_D_JSON || logMode == LogMode.BOTH;
    }
}
