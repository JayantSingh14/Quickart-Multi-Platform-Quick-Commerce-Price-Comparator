package in.juspay.airborne.ota;

import android.content.Context;
import android.util.Log;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import in.juspay.airborne.LazyDownloadCallback;
import in.juspay.airborne.TrackerCallback;
import in.juspay.airborne.network.NetUtils;
import in.juspay.airborne.network.OTANetUtils;
import in.juspay.airborne.ota.ReleaseConfig;
import in.juspay.airborne.ota.UpdateResult;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.airborne.services.OTAServices;
import in.juspay.airborne.services.Workspace;
import in.juspay.airborne.utils.OTAUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hyperutil.constants.LogSubCategory;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ApplicationManager {

    @NotNull
    public static final String TAG = "ApplicationManager";

    @NotNull
    private String applicationContent;

    @NotNull
    private final Context ctx;
    private final boolean fromAirborne;

    @NotNull
    private String indexFolderPath;

    @NotNull
    private final WaitTask indexPathWaitTask;

    @NotNull
    private final WaitTask loadWaitTask;

    @Nullable
    private final String metricsEndPoint;
    private NetUtils netUtils;

    @Nullable
    private final Function1<String, Unit> onBootComplete;

    @NotNull
    private final OTAServices otaServices;

    @Nullable
    private ReleaseConfigCallback rcCallback;

    @Nullable
    private final Map<String, String> rcHeaders;

    @Nullable
    private ReleaseConfig releaseConfig;

    @NotNull
    private String releaseConfigTemplateUrl;

    @Nullable
    private String sessionId;
    private boolean shouldUpdate;

    @NotNull
    private final TrackerCallback tracker;

    @NotNull
    private final Workspace workspace;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ConcurrentMap<String, WeakReference<Context>> CONTEXT_MAP = new ConcurrentHashMap();

    @NotNull
    private static final ConcurrentMap<String, UpdateTask> RUNNING_UPDATE_TASKS = new ConcurrentHashMap();

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <V> Future<V> doAsync(Callable<V> callable) {
            return OTAUtils.INSTANCE.doAsync(callable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String sanitizeClientId(String str) {
            String lowerCase = ((String) StringsKt.M(str, new char[]{'_'}).get(0)).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <V> List<V> setDifference(List<? extends V> list, List<? extends V> list2) {
            return CollectionsKt.e0(SetsKt.b(CollectionsKt.h0(list), CollectionsKt.h0(list2)));
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class LogLabel {

        @NotNull
        public static final String APP_LOAD_EXCEPTION = "app_load_exception";

        @NotNull
        public static final String CLEAN_UP_ERROR = "clean_up_error";

        @NotNull
        public static final LogLabel INSTANCE = new LogLabel();

        private LogLabel() {
        }
    }

    @Metadata
    public enum StateKey {
        SAVED_PACKAGE_UPDATE,
        SAVED_RESOURCE_UPDATE
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationManager(@NotNull Context ctx, @NotNull String releaseConfigTemplateUrl, @NotNull OTAServices otaServices, @Nullable String str, @Nullable Map<String, String> map, @Nullable Function1<? super String, Unit> function1, boolean z) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(releaseConfigTemplateUrl, "releaseConfigTemplateUrl");
        Intrinsics.checkNotNullParameter(otaServices, "otaServices");
        this.ctx = ctx;
        this.releaseConfigTemplateUrl = releaseConfigTemplateUrl;
        this.otaServices = otaServices;
        this.metricsEndPoint = str;
        this.rcHeaders = map;
        this.onBootComplete = function1;
        this.fromAirborne = z;
        this.shouldUpdate = true;
        this.applicationContent = "";
        this.loadWaitTask = new WaitTask();
        this.indexPathWaitTask = new WaitTask();
        this.workspace = otaServices.getWorkspace();
        this.tracker = otaServices.getTrackerCallback();
        this.indexFolderPath = "";
    }

    private final void cleanUpDir(String str, List<String> list) throws JSONException {
        List listF;
        Log.d(TAG, "requiredFiles for " + str + ' ' + list);
        String[] strArrListFilesRecursive = this.otaServices.getFileProviderService().listFilesRecursive(str);
        if (strArrListFilesRecursive == null || (listF = ArraysKt.F(strArrListFilesRecursive)) == null) {
            listF = EmptyList.f53609a;
        }
        List<String> difference = Companion.setDifference(listF, list);
        if (difference.isEmpty()) {
            android.support.v4.media.a.t("No clean-up required for dir: ", str, TAG);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (String str2 : difference) {
            if (this.otaServices.getFileProviderService().deleteFileFromInternalStorage(str + '/' + str2)) {
                Log.d(TAG, "Deleted file " + str2 + " from " + str);
                str2 = null;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        if (!arrayList.isEmpty()) {
            JSONObject jSONObjectPut = new JSONObject().put(APayConstants.Error.MESSAGE, "Failed to delete some files during clean up.").put("failures", arrayList);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …put(\"failures\", failures)");
            trackError(LogLabel.CLEAN_UP_ERROR, jSONObjectPut);
        }
        logTimeTaken$default(this, jCurrentTimeMillis, null, 2, null);
    }

    private final String getIndexFilePath(String str) {
        File fileFromInternalStorage = this.otaServices.getFileProviderService().getFileFromInternalStorage("app/package/" + str);
        if (!fileFromInternalStorage.exists()) {
            return "";
        }
        String absolutePath = fileFromInternalStorage.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return absolutePath;
    }

    public static /* synthetic */ void loadApplication$default(ApplicationManager applicationManager, String str, LazyDownloadCallback lazyDownloadCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            lazyDownloadCallback = null;
        }
        applicationManager.loadApplication(str, lazyDownloadCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadApplication$lambda$1(ApplicationManager this$0, String unSanitizedClientId, LazyDownloadCallback lazyDownloadCallback) throws JSONException {
        Function1<String, Unit> function1;
        ReleaseConfig releaseConfig;
        String filePath;
        String split;
        String filePath2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unSanitizedClientId, "$unSanitizedClientId");
        this$0.otaServices.setClientId(unSanitizedClientId);
        String strSanitizeClientId = Companion.sanitizeClientId(unSanitizedClientId);
        JSONObject jSONObjectPut = new JSONObject().put(PaymentConstants.CLIENT_ID, strSanitizeClientId);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"client_id\", clientId)");
        this$0.trackInfo("init", jSONObjectPut);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this$0.releaseConfig == null) {
                    WeakReference<Context> weakReference = new WeakReference<>(this$0.ctx);
                    ConcurrentMap<String, WeakReference<Context>> concurrentMap = CONTEXT_MAP;
                    WeakReference<Context> weakReference2 = concurrentMap.get(strSanitizeClientId);
                    boolean z = false;
                    if (weakReference2 != null ? weakReference2.get() != null || !concurrentMap.replace(strSanitizeClientId, weakReference2, weakReference) : concurrentMap.putIfAbsent(strSanitizeClientId, weakReference) != null) {
                        z = true;
                    }
                    WeakReference<Context> weakReference3 = concurrentMap.get(strSanitizeClientId);
                    if (weakReference3 != null) {
                        weakReference = weakReference3;
                    }
                    this$0.releaseConfig = this$0.readReleaseConfig(weakReference);
                    if (this$0.shouldUpdate) {
                        this$0.releaseConfig = this$0.tryUpdate(strSanitizeClientId, z, weakReference, lazyDownloadCallback);
                    } else {
                        Log.d(TAG, "Updates disabled, running w/o updating.");
                    }
                }
                releaseConfig = this$0.releaseConfig;
                Intrinsics.c(releaseConfig);
                ReleaseConfig.Split index = releaseConfig.getPkg().getIndex();
                String str = "";
                if (index == null || (filePath = index.getFilePath()) == null) {
                    filePath = "";
                }
                this$0.indexFolderPath = this$0.getIndexFilePath(filePath);
                this$0.indexPathWaitTask.complete();
                ReleaseConfig.Split index2 = releaseConfig.getPkg().getIndex();
                if (index2 != null && (filePath2 = index2.getFilePath()) != null) {
                    str = filePath2;
                }
                split = this$0.readSplit(str);
            } catch (Exception e2) {
                Log.e(TAG, "Critical exception while loading app! " + e2);
                this$0.trackError(LogLabel.APP_LOAD_EXCEPTION, "Exception raised while loading application.", e2);
                this$0.indexPathWaitTask.complete();
                this$0.loadWaitTask.complete();
                function1 = this$0.onBootComplete;
                if (function1 != null) {
                }
            }
            if (split.length() == 0) {
                throw new IllegalStateException("index split is empty.");
            }
            this$0.trackBoot(releaseConfig, jCurrentTimeMillis);
            Log.d(TAG, "Loading package version: " + releaseConfig.getPkg().getVersion());
            String strE0 = StringsKt.e0("\n                window.document.title=\"" + releaseConfig.getPkg().getName() + "\";\n                window.RELEASE_CONFIG=" + releaseConfig.serialize() + ";\n                ");
            StringBuilder sb = new StringBuilder();
            sb.append(strE0);
            sb.append(split);
            this$0.applicationContent = sb.toString();
            this$0.loadWaitTask.complete();
            this$0.indexPathWaitTask.complete();
            this$0.loadWaitTask.complete();
            function1 = this$0.onBootComplete;
            if (function1 != null) {
                function1.invoke(this$0.indexFolderPath);
            }
            this$0.logTimeTaken(jCurrentTimeMillis, "loadApplication");
            return Unit.f53572a;
        } catch (Throwable th) {
            this$0.indexPathWaitTask.complete();
            this$0.loadWaitTask.complete();
            Function1<String, Unit> function12 = this$0.onBootComplete;
            if (function12 != null) {
                function12.invoke(this$0.indexFolderPath);
            }
            this$0.logTimeTaken(jCurrentTimeMillis, "loadApplication");
            throw th;
        }
    }

    private final <T> T loadConfigComponent(String str, String str2, T t, T t2, Function1<? super String, ? extends Result<? extends T>> function1) throws JSONException {
        if (str.length() > 0) {
            T t3 = (T) ((Result) function1.invoke(str)).f53539a;
            if (!(t3 instanceof Result.Failure)) {
                return t3;
            }
            Throwable thA = Result.a(t3);
            if (thA != null) {
                trackReadReleaseConfigError(thA);
            }
        }
        if (t != null) {
            return t;
        }
        T t4 = (T) ((Result) function1.invoke(readFromAssets(str2))).f53539a;
        return Result.a(t4) == null ? t4 : t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTimeTaken(long j2, String str) {
        String str2 = "Time " + (System.currentTimeMillis() - j2) + "ms";
        if (str == null) {
            Log.d(TAG, str2);
            return;
        }
        Log.d(TAG, str + ' ' + str2);
    }

    public static /* synthetic */ void logTimeTaken$default(ApplicationManager applicationManager, long j2, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        applicationManager.logTimeTaken(j2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit postMetrics(String str, boolean z) throws IOException {
        String str2 = this.metricsEndPoint;
        if (str2 == null) {
            return null;
        }
        NetUtils netUtils = this.netUtils;
        if (netUtils == null) {
            Intrinsics.h("netUtils");
            throw null;
        }
        String str3 = this.sessionId;
        if (str3 == null) {
            str3 = "";
        }
        netUtils.postMetrics(str2, str3, str, z);
        return Unit.f53572a;
    }

    private final String readFile(String str) {
        String fromFile = this.otaServices.getFileProviderService().readFromFile("app/" + str);
        Intrinsics.checkNotNullExpressionValue(fromFile, "otaServices.fileProvider…FromFile(\"app/$filePath\")");
        return fromFile;
    }

    private final Future<String> readFileAsync(String str) {
        return Companion.doAsync(new a(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String readFileAsync$lambda$19(ApplicationManager this$0, String filePath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        return this$0.readFile(filePath);
    }

    private final String readFromAssets(String str) {
        String fromAssets = this.otaServices.getFileProviderService().readFromAssets("app/" + str);
        return fromAssets == null ? "" : fromAssets;
    }

    private final String readFromInternalStorage(String str) {
        String fromInternalStorage = this.otaServices.getFileProviderService().readFromInternalStorage("app/" + str);
        return fromInternalStorage == null ? "" : fromInternalStorage;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:4:0x0002, B:5:0x0027, B:7:0x002d, B:12:0x0041, B:14:0x0066, B:32:0x00b1, B:35:0x00b9, B:38:0x00c1, B:40:0x00c7, B:42:0x00e0, B:44:0x00e7, B:46:0x00fd, B:48:0x0104, B:17:0x0070, B:18:0x0074, B:20:0x007a, B:22:0x0086, B:24:0x008a, B:28:0x00a1, B:31:0x00ae, B:25:0x0097), top: B:56:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0 A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:4:0x0002, B:5:0x0027, B:7:0x002d, B:12:0x0041, B:14:0x0066, B:32:0x00b1, B:35:0x00b9, B:38:0x00c1, B:40:0x00c7, B:42:0x00e0, B:44:0x00e7, B:46:0x00fd, B:48:0x0104, B:17:0x0070, B:18:0x0074, B:20:0x007a, B:22:0x0086, B:24:0x008a, B:28:0x00a1, B:31:0x00ae, B:25:0x0097), top: B:56:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:4:0x0002, B:5:0x0027, B:7:0x002d, B:12:0x0041, B:14:0x0066, B:32:0x00b1, B:35:0x00b9, B:38:0x00c1, B:40:0x00c7, B:42:0x00e0, B:44:0x00e7, B:46:0x00fd, B:48:0x0104, B:17:0x0070, B:18:0x0074, B:20:0x007a, B:22:0x0086, B:24:0x008a, B:28:0x00a1, B:31:0x00ae, B:25:0x0097), top: B:56:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final in.juspay.airborne.ota.ReleaseConfig readReleaseConfig(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.airborne.ota.ApplicationManager.readReleaseConfig(java.lang.Object):in.juspay.airborne.ota.ReleaseConfig");
    }

    private final String readResourceByFileName(String str) {
        return readFile(android.support.v4.media.b.C("resources/", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair readSplits$lambda$11$lambda$10(String it, ApplicationManager this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new Pair(it, this$0.readSplit(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runCleanUp(JSONObject jSONObject, UpdateResult updateResult) throws JSONException {
        List<String> filePaths;
        List<String> filePaths2;
        List<String> filePaths3;
        List<String> filePaths4;
        Iterable arrayList;
        ReleaseConfig.ResourceManifest resources;
        ReleaseConfig.ResourceManifest resources2;
        ReleaseConfig.PackageManifest pkg;
        ReleaseConfig.PackageManifest pkg2;
        Log.d(TAG, "runCleanUp: updateResult: " + updateResult);
        ReleaseConfig releaseConfig = updateResult instanceof UpdateResult.Ok ? ((UpdateResult.Ok) updateResult).getReleaseConfig() : null;
        ReleaseConfig releaseConfig2 = this.releaseConfig;
        if (releaseConfig2 == null || (pkg2 = releaseConfig2.getPkg()) == null || (filePaths = pkg2.getFilePaths()) == null) {
            filePaths = EmptyList.f53609a;
        }
        Log.d(TAG, "runCleanUp: Current splits: " + filePaths);
        if (releaseConfig == null || (pkg = releaseConfig.getPkg()) == null || (filePaths2 = pkg.getFilePaths()) == null) {
            filePaths2 = EmptyList.f53609a;
        }
        Log.d(TAG, "runCleanUp: New splits: " + filePaths2);
        ReleaseConfig releaseConfig3 = this.releaseConfig;
        if (releaseConfig3 == null || (resources2 = releaseConfig3.getResources()) == null || (filePaths3 = resources2.getFilePaths()) == null) {
            filePaths3 = EmptyList.f53609a;
        }
        if (releaseConfig == null || (resources = releaseConfig.getResources()) == null || (filePaths4 = resources.getFilePaths()) == null) {
            filePaths4 = EmptyList.f53609a;
        }
        cleanUpDir("app/package", this.fromAirborne ? CollectionsKt.L(CollectionsKt.L(CollectionsKt.L(filePaths, filePaths2), filePaths3), filePaths4) : CollectionsKt.L(filePaths, filePaths2));
        if (!this.fromAirborne) {
            cleanUpDir("app/resources", CollectionsKt.L(filePaths3, filePaths4));
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SAVED_PACKAGE_UPDATE");
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("dir") : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("SAVED_RESOURCE_UPDATE");
        String strOptString2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("dir") : null;
        String[] list = this.workspace.getCacheRoot().list();
        if (list == null || (arrayList = ArraysKt.F(list)) == null) {
            arrayList = new ArrayList();
        }
        Iterable<String> iterable = arrayList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(iterable, 10));
        for (String it : iterable) {
            Workspace workspace = this.workspace;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(workspace.openInCache(it));
        }
        Regex regex = new Regex("temp-.*-\\d+");
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            File file = (File) next;
            if (file.isDirectory() && !Intrinsics.b(file.getName(), strOptString) && !Intrinsics.b(file.getName(), strOptString2)) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                if (regex.c(name)) {
                    arrayList3.add(next);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            File file2 = (File) it3.next();
            Log.d(TAG, "Deleting temp directory " + file2.getName());
            String name2 = !FilesKt.b(file2) ? file2.getName() : null;
            if (name2 != null) {
                arrayList4.add(name2);
            }
        }
        if (arrayList4.isEmpty()) {
            return;
        }
        JSONObject jSONObjectPut = new JSONObject().put(APayConstants.Error.MESSAGE, "Failed to delete some temporary directories during clean-up.").put("failures", arrayList4);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"messag…put(\"failures\", failures)");
        trackError(LogLabel.CLEAN_UP_ERROR, jSONObjectPut);
    }

    private final void trackBoot(ReleaseConfig releaseConfig, long j2) throws JSONException {
        String strComponent1 = releaseConfig.component1();
        ReleaseConfig.Config configComponent2 = releaseConfig.component2();
        ReleaseConfig.PackageManifest packageManifestComponent3 = releaseConfig.component3();
        ReleaseConfig.ResourceManifest resourceManifestComponent4 = releaseConfig.component4();
        JSONArray jSONArray = new JSONArray();
        Iterator<ReleaseConfig.Split> it = resourceManifestComponent4.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getFileName());
        }
        JSONObject jSONObjectPut = new JSONObject().put("release_config_version", strComponent1).put("config_version", configComponent2.getVersion()).put("package_version", packageManifestComponent3 != null ? packageManifestComponent3.getVersion() : null).put("resource_versions", jSONArray).put("time_taken", System.currentTimeMillis() - j2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …TimeMillis() - startTime)");
        trackInfo("boot", jSONObjectPut);
    }

    private final void trackError(String str, String str2, Exception exc) throws JSONException {
        JSONObject value = new JSONObject().put(APayConstants.Error.MESSAGE, str2);
        if (exc != null) {
            value.put("stack_trace", Log.getStackTraceString(exc));
        }
        Intrinsics.checkNotNullExpressionValue(value, "value");
        trackError(str, value);
    }

    public static /* synthetic */ void trackError$default(ApplicationManager applicationManager, String str, String str2, Exception exc, int i2, Object obj) throws JSONException {
        if ((i2 & 4) != 0) {
            exc = null;
        }
        applicationManager.trackError(str, str2, exc);
    }

    private final void trackGeneric(String str, JSONObject jSONObject, String str2) {
        this.tracker.track("lifecycle", LogSubCategory.LifeCycle.HYPER_OTA, str2, TAG, str, jSONObject);
    }

    private final void trackInfo(String str, JSONObject jSONObject) {
        trackGeneric(str, jSONObject, "info");
    }

    private final void trackReadReleaseConfigError(Throwable th) throws JSONException {
        if (th instanceof Exception) {
            JSONObject value = new JSONObject().put("error", th.getMessage()).put("stack_trace", Log.getStackTraceString(th));
            Intrinsics.checkNotNullExpressionValue(value, "value");
            trackError("read_release_config_error", value);
        }
    }

    private final void trackUpdateResult(UpdateResult updateResult) throws JSONException {
        String str;
        if (updateResult instanceof UpdateResult.Ok) {
            str = "OK";
        } else if (updateResult instanceof UpdateResult.PackageUpdateTimeout) {
            str = "PACKAGE_TIMEOUT";
        } else if (Intrinsics.b(updateResult, UpdateResult.ReleaseConfigFetchTimeout.INSTANCE)) {
            str = "RELEASE_CONFIG_TIMEOUT";
        } else if (Intrinsics.b(updateResult, UpdateResult.Error.RCFetchError.INSTANCE) || Intrinsics.b(updateResult, UpdateResult.Error.Unknown.INSTANCE)) {
            str = MerchantConstants.ERROR;
        } else {
            if (!Intrinsics.b(updateResult, UpdateResult.NA.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = RegionUtil.REGION_STRING_NA;
        }
        JSONObject jSONObjectPut = new JSONObject().put("result", str);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"result\", result)");
        trackInfo("update_result", jSONObjectPut);
    }

    private final ReleaseConfig tryUpdate(final String str, final boolean z, Object obj, LazyDownloadCallback lazyDownloadCallback) throws ExecutionException, JSONException, InterruptedException {
        String releaseConfig;
        ReleaseConfig releaseConfigTryUpdate;
        ReleaseConfigCallback releaseConfigCallback;
        String releaseConfig2;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (Intrinsics.b(this.releaseConfigTemplateUrl, "")) {
            ReleaseConfigCallback releaseConfigCallback2 = this.rcCallback;
            releaseConfig = releaseConfigCallback2 != null ? releaseConfigCallback2.getReleaseConfig(false) : null;
        } else {
            releaseConfig = this.releaseConfigTemplateUrl;
        }
        OTANetUtils oTANetUtils = new OTANetUtils(this.ctx, str, this.otaServices.getCleanUpValue());
        this.netUtils = oTANetUtils;
        oTANetUtils.setTrackMetrics(this.metricsEndPoint != null);
        if (releaseConfig == null) {
            releaseConfig = this.releaseConfigTemplateUrl;
        }
        String str2 = releaseConfig;
        FileProviderService fileProviderService = this.otaServices.getFileProviderService();
        ReleaseConfig releaseConfig3 = this.releaseConfig;
        TrackerCallback trackerCallback = this.tracker;
        NetUtils netUtils = this.netUtils;
        if (netUtils == null) {
            Intrinsics.h("netUtils");
            throw null;
        }
        final UpdateTask updateTask = new UpdateTask(str2, fileProviderService, releaseConfig3, obj, trackerCallback, netUtils, this.rcHeaders, lazyDownloadCallback, this.fromAirborne);
        UpdateTask updateTaskPutIfAbsent = RUNNING_UPDATE_TASKS.putIfAbsent(str, updateTask);
        UpdateTask updateTask2 = updateTaskPutIfAbsent == null ? updateTask : updateTaskPutIfAbsent;
        if (updateTask2.equals(updateTask)) {
            Log.d(TAG, "No running update tasks for '" + str + "', starting new task.");
            ReleaseConfig.PackageManifest packageManifestCopyTempPkg = updateTask2.copyTempPkg();
            if (packageManifestCopyTempPkg != null) {
                ReleaseConfig releaseConfig4 = this.releaseConfig;
                ReleaseConfig releaseConfigCopy$default = releaseConfig4 != null ? ReleaseConfig.copy$default(releaseConfig4, null, null, packageManifestCopyTempPkg, null, 11, null) : null;
                this.releaseConfig = releaseConfigCopy$default;
                updateTask2.updateReleaseConfig(releaseConfigCopy$default);
            }
            updateTask.run(new Function2<UpdateResult, JSONObject, Unit>() { // from class: in.juspay.airborne.ota.ApplicationManager.tryUpdate.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) throws JSONException, IOException {
                    invoke((UpdateResult) obj2, (JSONObject) obj3);
                    return Unit.f53572a;
                }

                public final void invoke(@NotNull UpdateResult updateResult, @NotNull JSONObject persistentState) throws JSONException, IOException {
                    ReleaseConfig.PackageManifest pkg;
                    Intrinsics.checkNotNullParameter(updateResult, "updateResult");
                    Intrinsics.checkNotNullParameter(persistentState, "persistentState");
                    Log.d(ApplicationManager.TAG, "Running onFinish for '" + str + '\'');
                    if (!z) {
                        this.runCleanUp(persistentState, updateResult);
                    }
                    boolean z2 = false;
                    if (updateResult instanceof UpdateResult.Ok) {
                        String version = ((UpdateResult.Ok) updateResult).getReleaseConfig().getPkg().getVersion();
                        ReleaseConfig releaseConfig5 = this.releaseConfig;
                        if (!Intrinsics.b(version, (releaseConfig5 == null || (pkg = releaseConfig5.getPkg()) == null) ? null : pkg.getVersion())) {
                            z2 = true;
                        }
                    }
                    ApplicationManager.RUNNING_UPDATE_TASKS.remove(str);
                    this.logTimeTaken(jCurrentTimeMillis, android.support.v4.media.b.r(new StringBuilder("Update task finished for '"), str, "'."));
                    this.postMetrics(updateTask.getUpdateUUID(), z2);
                }
            });
        } else {
            Log.d(TAG, "Update task already running for '" + str + "'.");
        }
        UpdateResult updateResultAwait = updateTask2.await(this.tracker);
        trackUpdateResult(updateResultAwait);
        if (updateResultAwait instanceof UpdateResult.Ok) {
            releaseConfigTryUpdate = ((UpdateResult.Ok) updateResultAwait).getReleaseConfig();
        } else if (updateResultAwait instanceof UpdateResult.PackageUpdateTimeout) {
            releaseConfigTryUpdate = ((UpdateResult.PackageUpdateTimeout) updateResultAwait).getReleaseConfig();
            if (releaseConfigTryUpdate == null) {
                releaseConfigTryUpdate = this.releaseConfig;
            }
        } else if (!Intrinsics.b(updateResultAwait, UpdateResult.Error.RCFetchError.INSTANCE) || (releaseConfigCallback = this.rcCallback) == null || releaseConfigCallback == null || !releaseConfigCallback.shouldRetry()) {
            releaseConfigTryUpdate = this.releaseConfig;
        } else {
            Log.d(TAG, "Failed to fetch release config, re-trying in release mode.");
            updateTask2.awaitOnFinish$airborne_release();
            ReleaseConfigCallback releaseConfigCallback3 = this.rcCallback;
            if (releaseConfigCallback3 == null || (releaseConfig2 = releaseConfigCallback3.getReleaseConfig(true)) == null) {
                releaseConfig2 = this.releaseConfigTemplateUrl;
            }
            this.releaseConfigTemplateUrl = releaseConfig2;
            releaseConfigTryUpdate = tryUpdate(str, true, obj, lazyDownloadCallback);
        }
        logTimeTaken(jCurrentTimeMillis, "tryUpdate");
        return releaseConfigTryUpdate;
    }

    public static /* synthetic */ ReleaseConfig tryUpdate$default(ApplicationManager applicationManager, String str, boolean z, Object obj, LazyDownloadCallback lazyDownloadCallback, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            lazyDownloadCallback = null;
        }
        return applicationManager.tryUpdate(str, z, obj, lazyDownloadCallback);
    }

    @NotNull
    public final String getApplicationContent() throws ExecutionException, InterruptedException {
        this.loadWaitTask.get();
        return this.applicationContent;
    }

    @NotNull
    public final String getBundledIndexPath() {
        ReleaseConfig.PackageManifest pkg;
        ReleaseConfig.Split index;
        String filePath;
        ReleaseConfig releaseConfig = this.releaseConfig;
        return (releaseConfig == null || (pkg = releaseConfig.getPkg()) == null || (index = pkg.getIndex()) == null || (filePath = index.getFilePath()) == null) ? "" : filePath;
    }

    @NotNull
    public final String getIndexBundlePath() throws InterruptedException {
        while (!this.indexPathWaitTask.isDone()) {
            try {
                Context context = this.ctx;
                Intrinsics.d(context, "null cannot be cast to non-null type java.lang.Object");
                context.wait();
            } catch (Exception unused) {
            }
        }
        return this.indexFolderPath;
    }

    public final boolean getShouldUpdate() {
        return this.shouldUpdate;
    }

    public final void loadApplication(@NotNull String unSanitizedClientId, @Nullable LazyDownloadCallback lazyDownloadCallback) {
        Intrinsics.checkNotNullParameter(unSanitizedClientId, "unSanitizedClientId");
        Companion.doAsync(new d(this, unSanitizedClientId, lazyDownloadCallback, 1));
    }

    @NotNull
    public final String readResourceByName(@NotNull String name) {
        String resourceByFileName;
        ReleaseConfig.ResourceManifest resources;
        ReleaseConfig.Split resource;
        Intrinsics.checkNotNullParameter(name, "name");
        ReleaseConfig releaseConfig = this.releaseConfig;
        String filePath = (releaseConfig == null || (resources = releaseConfig.getResources()) == null || (resource = resources.getResource(name)) == null) ? null : resource.getFilePath();
        return (filePath == null || (resourceByFileName = readResourceByFileName(filePath)) == null) ? "" : resourceByFileName;
    }

    @NotNull
    public final String readSplit(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return readFile("package/" + fileName);
    }

    @NotNull
    public final String readSplits(@NotNull String fileNames) {
        Intrinsics.checkNotNullParameter(fileNames, "fileNames");
        JSONArray jSONArray = new JSONArray(fileNames);
        IntRange intRangeF = RangesKt.f(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.r(intRangeF, 10));
        Iterator<Integer> it = intRangeF.iterator();
        while (((IntProgressionIterator) it).f53843c) {
            arrayList.add(jSONArray.getString(((IntIterator) it).a()));
        }
        String string = readSplits(arrayList).toString();
        Intrinsics.checkNotNullExpressionValue(string, "readSplits(list).toString()");
        return string;
    }

    public final void setReleaseConfigCallback(@NotNull ReleaseConfigCallback rcCallback) {
        Intrinsics.checkNotNullParameter(rcCallback, "rcCallback");
        this.rcCallback = rcCallback;
    }

    public final void setSessionId(@Nullable String str) {
        this.sessionId = str;
    }

    public final void setShouldUpdate(boolean z) {
        this.shouldUpdate = z;
    }

    private final void trackError(String str, JSONObject jSONObject) {
        trackGeneric(str, jSONObject, "error");
    }

    private final JSONObject readSplits(List<String> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Companion.doAsync(new a((String) it.next(), this)));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) ((Future) it2.next()).get();
            jSONObject.put((String) pair.f53533a, (String) pair.f53534b);
        }
        return jSONObject;
    }

    public /* synthetic */ ApplicationManager(Context context, String str, OTAServices oTAServices, String str2, Map map, Function1 function1, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, oTAServices, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : map, (i2 & 32) != 0 ? null : function1, (i2 & 64) != 0 ? true : z);
    }

    @NotNull
    public final String readReleaseConfig() {
        String strSerialize;
        ReleaseConfig releaseConfig = this.releaseConfig;
        return (releaseConfig == null || (strSerialize = releaseConfig.serialize()) == null) ? "" : strSerialize;
    }
}
