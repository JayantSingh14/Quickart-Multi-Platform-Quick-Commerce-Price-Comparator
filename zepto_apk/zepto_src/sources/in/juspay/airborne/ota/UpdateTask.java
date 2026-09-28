package in.juspay.airborne.ota;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import in.juspay.airborne.LazyDownloadCallback;
import in.juspay.airborne.R;
import in.juspay.airborne.TrackerCallback;
import in.juspay.airborne.network.NetUtils;
import in.juspay.airborne.ota.ApplicationManager;
import in.juspay.airborne.ota.ReleaseConfig;
import in.juspay.airborne.ota.UpdateResult;
import in.juspay.airborne.ota.UpdateTask;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.airborne.services.TempWriter;
import in.juspay.airborne.services.Workspace;
import in.juspay.airborne.utils.OTAUtils;
import in.juspay.hyperutil.constants.LogSubCategory;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.KEYRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class UpdateTask {

    @NotNull
    public static final Companion Companion = new Companion(0 == true ? 1 : 0);

    @NotNull
    public static final String LABEL = "ota_update";
    public static final int RETRY_LIMIT = 1;

    @NotNull
    private static final String SDK_VERSION;

    @NotNull
    public static final String TAG = "UpdateTask";

    @NotNull
    private volatile UpdateResult currentResult;

    @NotNull
    private volatile Stage currentStage;
    private long currentStageStartTime;

    @NotNull
    private Map<String, String> defaultHeaders;

    @NotNull
    private final Object fileLock;

    @NotNull
    private final FileProviderService fileProviderService;
    private final boolean fromAirborne;
    private long initTime;

    @Nullable
    private final LazyDownloadCallback lazyDownloadCallback;

    @Nullable
    private ReleaseConfig localReleaseConfig;

    @NotNull
    private final NetUtils netUtils;

    @Nullable
    private Function2<? super UpdateResult, ? super JSONObject, Unit> onFinish;

    @NotNull
    private final WaitTask onFinishWaitTask;
    private volatile long packageTimeout;

    @Nullable
    private Future<Update.Package> packageUpdate;
    private long releaseConfigTimeout;

    @NotNull
    private final String releaseConfigUrl;

    @NotNull
    private ResourceUpdateStatus resourceDownloadStatus;

    @Nullable
    private Future<Unit> resourceSaveFuture;

    @Nullable
    private ResourceUpdateTask resourceUpdate;

    @NotNull
    private final TrackerCallback tracker;

    @NotNull
    private final List<TrackerCallback> trackers;

    @NotNull
    private AtomicBoolean updateTimedOut;

    @NotNull
    private final String updateUUID;

    @NotNull
    private final Queue<Pair<WaitTask, Stage>> waitQueue;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <V> Future<V> doAsync(Callable<V> callable) {
            return OTAUtils.INSTANCE.doAsync(callable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <V> List<V> setDifference(List<? extends V> list, List<? extends V> list2) {
            return CollectionsKt.e0(SetsKt.b(CollectionsKt.h0(list), CollectionsKt.h0(list2)));
        }

        public final void closeQuietly(@NotNull Closeable closeable) throws IOException {
            Intrinsics.checkNotNullParameter(closeable, "<this>");
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }

        @NotNull
        public final String getSDK_VERSION() {
            return UpdateTask.SDK_VERSION;
        }

        @NotNull
        public final String utf8(@NotNull InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), KEYRecord.Flags.FLAG2);
            try {
                String strB = TextStreamsKt.b(bufferedReader);
                bufferedReader.close();
                return strB;
            } finally {
            }
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class LogKey {

        @NotNull
        public static final LogKey INSTANCE = new LogKey();

        @NotNull
        public static final String PACKAGE_UPDATE_RESULT = "package_update_result";

        private LogKey() {
        }
    }

    @Metadata
    public enum ResourceUpdateStatus {
        RESOURCES_DOWNLOADING,
        RESOURCES_INSTALLING,
        RESOURCES_TIMEDOUT
    }

    @Metadata
    @SourceDebugExtension
    public final class ResourceUpdateTask {

        @NotNull
        private final Set<ReleaseConfig.Split> commonResources;
        public List<ReleaseConfig.Split> copied;

        @Nullable
        private final ReleaseConfig.ResourceManifest currentResourceManifest;
        public List<? extends Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> futures;

        @NotNull
        private final ReleaseConfig.ResourceManifest newResourceManifest;

        @NotNull
        private final List<ReleaseConfig.Split> newResources;

        @Nullable
        private final Pair<TempWriter, ReleaseConfig.ResourceManifest> savedResourcesInfo;
        public List<ReleaseConfig.Split> skipped;

        @NotNull
        private final TempWriter tempWriter;
        final /* synthetic */ UpdateTask this$0;

        public ResourceUpdateTask(@Nullable UpdateTask updateTask, @NotNull ReleaseConfig.ResourceManifest resourceManifest, ReleaseConfig.ResourceManifest newResourceManifest) {
            Set<ReleaseConfig.Split> elements;
            List<ReleaseConfig.Split> listE0;
            Intrinsics.checkNotNullParameter(newResourceManifest, "newResourceManifest");
            this.this$0 = updateTask;
            this.currentResourceManifest = resourceManifest;
            this.newResourceManifest = newResourceManifest;
            TempWriter tempWriterNewTempWriter = updateTask.fileProviderService.newTempWriter(Constants.RESOURCES_DIR_NAME);
            Intrinsics.checkNotNullExpressionValue(tempWriterNewTempWriter, "fileProviderService.newT…riter(RESOURCES_DIR_NAME)");
            this.tempWriter = tempWriterNewTempWriter;
            if (resourceManifest != null) {
                Set elements2 = CollectionsKt.h0(newResourceManifest);
                Intrinsics.checkNotNullParameter(resourceManifest, "<this>");
                Intrinsics.checkNotNullParameter(elements2, "other");
                elements = CollectionsKt.g0(resourceManifest);
                Intrinsics.checkNotNullParameter(elements, "<this>");
                Intrinsics.checkNotNullParameter(elements2, "elements");
                elements.retainAll(CollectionsKt.t(elements2));
            } else {
                elements = EmptySet.f53611a;
            }
            this.commonResources = elements;
            Intrinsics.checkNotNullParameter(newResourceManifest, "<this>");
            Intrinsics.checkNotNullParameter(elements, "elements");
            Collection collectionT = CollectionsKt.t(elements);
            if (collectionT.isEmpty()) {
                listE0 = CollectionsKt.e0(newResourceManifest);
            } else {
                ArrayList arrayList = new ArrayList();
                for (ReleaseConfig.Split split : newResourceManifest) {
                    if (!collectionT.contains(split)) {
                        arrayList.add(split);
                    }
                }
                listE0 = arrayList;
            }
            this.newResources = listE0;
            this.savedResourcesInfo = findSavedResources();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit completeResourceDownload$lambda$13(ResourceUpdateTask this$0) throws JSONException {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.saveDownloadedResources();
            return Unit.f53572a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void completeResourceDownload$lambda$14(UpdateTask this$0) throws JSONException {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.removeFromPersistentState(ApplicationManager.StateKey.SAVED_RESOURCE_UPDATE);
        }

        private final Future<ReleaseConfig.Split> copyResource(ReleaseConfig.Split split, TempWriter tempWriter) {
            return UpdateTask.Companion.doAsync(new e(this.this$0, tempWriter, split));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReleaseConfig.Split copyResource$lambda$19(UpdateTask this$0, TempWriter tempWriter, ReleaseConfig.Split resource) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tempWriter, "$tempWriter");
            Intrinsics.checkNotNullParameter(resource, "$resource");
            if (tempWriter.copyToMain(resource.getFilePath(), this$0.fromAirborne ? "app/package" : "app/resources")) {
                return resource;
            }
            Log.e(UpdateTask.TAG, "Failed to copy resource: " + resource.getFilePath());
            return null;
        }

        private final Pair<TempWriter, ReleaseConfig.ResourceManifest> findSavedResources() throws JSONException {
            JSONObject persistentState = this.this$0.readPersistentState(ApplicationManager.StateKey.SAVED_RESOURCE_UPDATE);
            if (persistentState == null) {
                return null;
            }
            UpdateTask updateTask = this.this$0;
            Log.d(UpdateTask.TAG, "Found saved resources " + persistentState + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            try {
                TempWriter tempWriterReOpenTempWriter = updateTask.fileProviderService.reOpenTempWriter(persistentState.getString("dir"));
                ReleaseConfig.Companion companion = ReleaseConfig.Companion;
                JSONArray jSONArray = persistentState.getJSONArray("resource_manifest");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "it.getJSONArray(\"resource_manifest\")");
                ReleaseConfig.ResourceManifest resourceManifestResourcesFromJSON = companion.resourcesFromJSON(jSONArray);
                if (resourceManifestResourcesFromJSON.isEmpty()) {
                    return null;
                }
                return new Pair<>(tempWriterReOpenTempWriter, resourceManifestResourcesFromJSON);
            } catch (Exception e2) {
                updateTask.removeFromPersistentState(ApplicationManager.StateKey.SAVED_RESOURCE_UPDATE);
                UpdateTask.trackException$default(updateTask, "saved_resources_corrupted", e2, null, 4, null);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Result start$lambda$2$lambda$1(ResourceUpdateTask this$0, ReleaseConfig.Split resource, UpdateTask this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(resource, "$resource");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Pair<TempWriter, ReleaseConfig.ResourceManifest> pair = this$0.savedResourcesInfo;
            if (pair == null || !((ReleaseConfig.ResourceManifest) pair.f53534b).contains((Object) resource)) {
                Log.d(UpdateTask.TAG, "Downloading resource: " + resource.getFilePath());
                return this$1.downloadFile(this$0.tempWriter, resource.getUrl(), resource.getFilePath()) instanceof Result.Ok ? new Result.Ok(new Pair(resource, this$0.tempWriter)) : new Result.Error();
            }
            Log.d(UpdateTask.TAG, "Skipping download of saved resource: " + resource.getFilePath());
            return new Result.Ok(new Pair(resource, this$0.savedResourcesInfo.f53533a));
        }

        private final boolean writeResourceManifest(ReleaseConfig.ResourceManifest resourceManifest) {
            JSONArray json = resourceManifest.toJSON();
            UpdateTask updateTask = this.this$0;
            String string = json.toString();
            Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
            return updateTask.writeManifest(Constants.RESOURCES_FILE_NAME, string);
        }

        public final void awaitResourceUpdates() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long nanos = TimeUnit.MICROSECONDS.toNanos(1L);
            Log.d(UpdateTask.TAG, "awaitDownloads: Starting wait.");
            while (this.this$0.resourceDownloadStatus == ResourceUpdateStatus.RESOURCES_DOWNLOADING && !this.this$0.updateTimedOut.get() && !isDone()) {
                LockSupport.parkNanos(nanos);
            }
            if (!this.this$0.updateTimedOut.get()) {
                Log.d(UpdateTask.TAG, "awaitResources: Timeout.");
            }
            this.this$0.logTimeTaken(jCurrentTimeMillis, "awaitDownloads: Wait ended.");
        }

        public final void completeResourceDownload() throws JSONException {
            if (getSkipped().isEmpty()) {
                if (this.savedResourcesInfo != null) {
                    OTAUtils oTAUtils = OTAUtils.INSTANCE;
                    final UpdateTask updateTask = this.this$0;
                    oTAUtils.runOnBackgroundThread(new Runnable() { // from class: in.juspay.airborne.ota.g
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            UpdateTask.ResourceUpdateTask.completeResourceDownload$lambda$14(updateTask);
                        }
                    });
                }
                Log.d(UpdateTask.TAG, "No resources skipped!");
                return;
            }
            Log.d(UpdateTask.TAG, "Skipped resources " + getSkipped());
            UpdateTask updateTask2 = this.this$0;
            JSONObject jSONObject = new JSONObject();
            List<ReleaseConfig.Split> skipped = getSkipped();
            ArrayList arrayList = new ArrayList(CollectionsKt.r(skipped, 10));
            Iterator<T> it = skipped.iterator();
            while (it.hasNext()) {
                arrayList.add(((ReleaseConfig.Split) it.next()).toJSON());
            }
            JSONObject jSONObjectPut = jSONObject.put(Constants.RESOURCES_DIR_NAME, arrayList);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"resour…pped.map { it.toJSON() })");
            updateTask2.trackInfo("skipped_resources", jSONObjectPut);
            this.this$0.resourceSaveFuture = UpdateTask.Companion.doAsync(new f(this, 0));
        }

        @NotNull
        public final Set<ReleaseConfig.Split> getCommonResources() {
            return this.commonResources;
        }

        @NotNull
        public final List<ReleaseConfig.Split> getCopied() {
            List<ReleaseConfig.Split> list = this.copied;
            if (list != null) {
                return list;
            }
            Intrinsics.h("copied");
            throw null;
        }

        @Nullable
        public final ReleaseConfig.ResourceManifest getCurrentResourceManifest() {
            return this.currentResourceManifest;
        }

        @NotNull
        public final List<Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> getFutures() {
            List list = this.futures;
            if (list != null) {
                return list;
            }
            Intrinsics.h("futures");
            throw null;
        }

        @NotNull
        public final ReleaseConfig.ResourceManifest getNewResourceManifest() {
            return this.newResourceManifest;
        }

        @NotNull
        public final List<ReleaseConfig.Split> getNewResources() {
            return this.newResources;
        }

        @Nullable
        public final Pair<TempWriter, ReleaseConfig.ResourceManifest> getSavedResourcesInfo() {
            return this.savedResourcesInfo;
        }

        @NotNull
        public final List<ReleaseConfig.Split> getSkipped() {
            List<ReleaseConfig.Split> list = this.skipped;
            if (list != null) {
                return list;
            }
            Intrinsics.h("skipped");
            throw null;
        }

        @NotNull
        public final TempWriter getTempWriter() {
            return this.tempWriter;
        }

        @Nullable
        public final ReleaseConfig.ResourceManifest installDownloadedResources() throws JSONException {
            boolean z;
            UpdateTask updateTask = this.this$0;
            synchronized (this) {
                try {
                    ResourceUpdateStatus resourceUpdateStatus = updateTask.resourceDownloadStatus;
                    ResourceUpdateStatus resourceUpdateStatus2 = ResourceUpdateStatus.RESOURCES_INSTALLING;
                    if (resourceUpdateStatus != resourceUpdateStatus2) {
                        updateTask.resourceDownloadStatus = resourceUpdateStatus2;
                        z = true;
                    } else {
                        z = false;
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                return null;
            }
            List<Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> futures = getFutures();
            ArrayList arrayList = new ArrayList();
            for (Object obj : futures) {
                if (((Future) obj).isDone()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((Result) ((Future) it.next()).get());
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof Result.Ok) {
                    arrayList3.add(next);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.r(arrayList3, 10));
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                Result.Ok ok = (Result.Ok) it3.next();
                arrayList4.add(copyResource((ReleaseConfig.Split) ((Pair) ok.getV()).f53533a, (TempWriter) ((Pair) ok.getV()).f53534b));
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                ReleaseConfig.Split split = (ReleaseConfig.Split) ((Future) it4.next()).get();
                if (split != null) {
                    arrayList5.add(split);
                }
            }
            setCopied(arrayList5);
            UpdateTask updateTask2 = this.this$0;
            JSONObject jSONObject = new JSONObject();
            List<ReleaseConfig.Split> copied = getCopied();
            ArrayList arrayList6 = new ArrayList(CollectionsKt.r(copied, 10));
            Iterator<T> it5 = copied.iterator();
            while (it5.hasNext()) {
                arrayList6.add(((ReleaseConfig.Split) it5.next()).toJSON());
            }
            JSONObject jSONObjectPut = jSONObject.put(Constants.RESOURCES_DIR_NAME, arrayList6);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"resour…pied.map { it.toJSON() })");
            updateTask2.trackInfo("updated_resources", jSONObjectPut);
            List<ReleaseConfig.Split> list = this.newResources;
            ArrayList arrayList7 = new ArrayList();
            for (Object obj2 : list) {
                if (!getCopied().contains((ReleaseConfig.Split) obj2)) {
                    arrayList7.add(obj2);
                }
            }
            setSkipped(arrayList7);
            if (getCopied().isEmpty()) {
                Log.d(UpdateTask.TAG, "No new resources to install.");
                return null;
            }
            Iterable iterable = this.currentResourceManifest;
            if (iterable == null) {
                iterable = EmptyList.f53609a;
            }
            ArrayList arrayList8 = new ArrayList();
            for (Object obj3 : iterable) {
                if (getSkipped().contains((ReleaseConfig.Split) obj3)) {
                    arrayList8.add(obj3);
                }
            }
            ReleaseConfig.ResourceManifest resourceManifest = this.newResourceManifest;
            ArrayList arrayList9 = new ArrayList();
            for (ReleaseConfig.Split split2 : resourceManifest) {
                if (getCopied().contains(split2)) {
                    arrayList9.add(split2);
                }
            }
            Log.d(UpdateTask.TAG, "Retaining outdated resources: " + arrayList8);
            Log.d(UpdateTask.TAG, "Retaining common resources: " + this.commonResources);
            Log.d(UpdateTask.TAG, "Latest resources installed: " + arrayList9);
            ReleaseConfig.ResourceManifest resourceManifest2 = new ReleaseConfig.ResourceManifest(CollectionsKt.L(CollectionsKt.L(arrayList8, arrayList9), CollectionsKt.e0(this.commonResources)));
            writeResourceManifest(resourceManifest2);
            return resourceManifest2;
        }

        public final boolean isDone() {
            List<Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> futures = getFutures();
            if ((futures instanceof Collection) && futures.isEmpty()) {
                return true;
            }
            Iterator<T> it = futures.iterator();
            while (it.hasNext()) {
                if (!((Future) it.next()).isDone()) {
                    return false;
                }
            }
            return true;
        }

        public final void saveDownloadedResources() throws JSONException {
            List<Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> futures = getFutures();
            ArrayList arrayList = new ArrayList(CollectionsKt.r(futures, 10));
            Iterator<T> it = futures.iterator();
            while (it.hasNext()) {
                arrayList.add((Result) ((Future) it.next()).get());
            }
            if (arrayList.isEmpty()) {
                Log.d(UpdateTask.TAG, "No resources to save.");
                return;
            }
            Log.d(UpdateTask.TAG, "Download results: " + arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof Result.Ok) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (Intrinsics.b(((TempWriter) ((Pair) ((Result.Ok) obj2).getV()).f53534b).getDirName(), this.tempWriter.getDirName())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.r(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add((ReleaseConfig.Split) ((Pair) ((Result.Ok) it2.next()).getV()).f53533a);
            }
            ReleaseConfig.ResourceManifest resourceManifest = this.newResourceManifest;
            ArrayList arrayList5 = new ArrayList();
            for (ReleaseConfig.Split split : resourceManifest) {
                ReleaseConfig.Split split2 = split;
                if (arrayList4.contains(split2) && getSkipped().contains(split2)) {
                    arrayList5.add(split);
                }
            }
            JSONObject jSONObject = new JSONObject(MapsKt.h(new Pair("dir", this.tempWriter.getDirName()), new Pair("resource_manifest", new ReleaseConfig.ResourceManifest(arrayList5).toJSON())));
            Log.d(UpdateTask.TAG, "Saved resources " + arrayList5);
            this.this$0.setInPersistentState(ApplicationManager.StateKey.SAVED_RESOURCE_UPDATE, jSONObject);
        }

        public final void setCopied(@NotNull List<ReleaseConfig.Split> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.copied = list;
        }

        public final void setFutures(@NotNull List<? extends Future<Result<Pair<ReleaseConfig.Split, TempWriter>>>> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.futures = list;
        }

        public final void setSkipped(@NotNull List<ReleaseConfig.Split> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.skipped = list;
        }

        public final void start() {
            Log.d(UpdateTask.TAG, "Starting resource update task with resources " + this.newResources);
            List<ReleaseConfig.Split> list = this.newResources;
            UpdateTask updateTask = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(UpdateTask.Companion.doAsync(new d(this, (ReleaseConfig.Split) it.next(), updateTask, 0)));
            }
            setFutures(arrayList);
        }
    }

    @Metadata
    public interface Result<V> {

        @Metadata
        public static class Error<V> implements Result<V> {

            @Metadata
            public static final class CustomError<V> extends Error<V> {

                @NotNull
                private final String msg;

                public CustomError(@NotNull String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    this.msg = msg;
                }

                public static /* synthetic */ CustomError copy$default(CustomError customError, String str, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = customError.msg;
                    }
                    return customError.copy(str);
                }

                @NotNull
                public final String component1() {
                    return this.msg;
                }

                @NotNull
                public final CustomError<V> copy(@NotNull String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    return new CustomError<>(msg);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof CustomError) && Intrinsics.b(this.msg, ((CustomError) obj).msg);
                }

                @NotNull
                public final String getMsg() {
                    return this.msg;
                }

                public int hashCode() {
                    return this.msg.hashCode();
                }

                @NotNull
                public String toString() {
                    return androidx.fragment.app.e.t(new StringBuilder("CustomError(msg="), this.msg, ')');
                }
            }

            @Metadata
            public static final class HttpError<V> extends Error<V> {

                @NotNull
                private final Response response;

                public HttpError(@NotNull Response response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.response = response;
                }

                public static /* synthetic */ HttpError copy$default(HttpError httpError, Response response, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        response = httpError.response;
                    }
                    return httpError.copy(response);
                }

                @NotNull
                public final Response component1() {
                    return this.response;
                }

                @NotNull
                public final HttpError<V> copy(@NotNull Response response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    return new HttpError<>(response);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof HttpError) && Intrinsics.b(this.response, ((HttpError) obj).response);
                }

                @NotNull
                public final Response getResponse() {
                    return this.response;
                }

                public int hashCode() {
                    return this.response.hashCode();
                }

                @NotNull
                public String toString() {
                    return "HttpError(response=" + this.response + ')';
                }
            }

            @Metadata
            public static final class HttpNoBody<V> extends Error<V> {

                @NotNull
                private final Response response;

                public HttpNoBody(@NotNull Response response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.response = response;
                }

                public static /* synthetic */ HttpNoBody copy$default(HttpNoBody httpNoBody, Response response, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        response = httpNoBody.response;
                    }
                    return httpNoBody.copy(response);
                }

                @NotNull
                public final Response component1() {
                    return this.response;
                }

                @NotNull
                public final HttpNoBody<V> copy(@NotNull Response response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    return new HttpNoBody<>(response);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof HttpNoBody) && Intrinsics.b(this.response, ((HttpNoBody) obj).response);
                }

                @NotNull
                public final Response getResponse() {
                    return this.response;
                }

                public int hashCode() {
                    return this.response.hashCode();
                }

                @NotNull
                public String toString() {
                    return "HttpNoBody(response=" + this.response + ')';
                }
            }

            @Metadata
            public static final class ParseError<V> extends Error<V> {

                /* renamed from: e, reason: collision with root package name */
                @NotNull
                private final Exception f48450e;

                public ParseError(@NotNull Exception e2) {
                    Intrinsics.checkNotNullParameter(e2, "e");
                    this.f48450e = e2;
                }

                public static /* synthetic */ ParseError copy$default(ParseError parseError, Exception exc, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        exc = parseError.f48450e;
                    }
                    return parseError.copy(exc);
                }

                @NotNull
                public final Exception component1() {
                    return this.f48450e;
                }

                @NotNull
                public final ParseError<V> copy(@NotNull Exception e2) {
                    Intrinsics.checkNotNullParameter(e2, "e");
                    return new ParseError<>(e2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ParseError) && Intrinsics.b(this.f48450e, ((ParseError) obj).f48450e);
                }

                @NotNull
                public final Exception getE() {
                    return this.f48450e;
                }

                public int hashCode() {
                    return this.f48450e.hashCode();
                }

                @NotNull
                public String toString() {
                    return "ParseError(e=" + this.f48450e + ')';
                }
            }
        }

        @Metadata
        public static final class Ok<V> implements Result<V> {
            private final V v;

            public Ok(V v) {
                this.v = v;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Ok copy$default(Ok ok, Object obj, int i2, Object obj2) {
                if ((i2 & 1) != 0) {
                    obj = ok.v;
                }
                return ok.copy(obj);
            }

            public final V component1() {
                return this.v;
            }

            @NotNull
            public final Ok<V> copy(V v) {
                return new Ok<>(v);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ok) && Intrinsics.b(this.v, ((Ok) obj).v);
            }

            public final V getV() {
                return this.v;
            }

            public int hashCode() {
                V v = this.v;
                if (v == null) {
                    return 0;
                }
                return v.hashCode();
            }

            @NotNull
            public String toString() {
                return "Ok(v=" + this.v + ')';
            }
        }
    }

    @Metadata
    public enum Stage {
        INITIALIZING,
        FETCHING_RC,
        DOWNLOADING_UPDATES,
        INSTALLING,
        LAZY_DOWNLOADING,
        FINISHED
    }

    @Metadata
    public interface Update {

        @Metadata
        public static final class Error implements Update {

            @NotNull
            public static final Error INSTANCE = new Error();

            private Error() {
            }
        }

        @Metadata
        public interface Package extends Update {

            @Metadata
            public static final class Failed implements Package {

                @NotNull
                public static final Failed INSTANCE = new Failed();

                private Failed() {
                }
            }

            @Metadata
            public static final class Finished implements Package {

                @NotNull
                private final TempWriter tempWriter;

                public Finished(@NotNull TempWriter tempWriter) {
                    Intrinsics.checkNotNullParameter(tempWriter, "tempWriter");
                    this.tempWriter = tempWriter;
                }

                @NotNull
                public final TempWriter getTempWriter() {
                    return this.tempWriter;
                }
            }

            @Metadata
            public static final class NA implements Package {

                @NotNull
                public static final NA INSTANCE = new NA();

                private NA() {
                }
            }
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Stage.values().length];
            try {
                iArr[Stage.INITIALIZING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Stage.FETCHING_RC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Stage.DOWNLOADING_UPDATES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Stage.INSTALLING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Stage.LAZY_DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Stage.FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Context ctx = Workspace.Companion.getCtx();
        String string = ctx != null ? ctx.getString(R.string.airborne_version) : null;
        if (string == null) {
            string = "undefined";
        }
        SDK_VERSION = string;
    }

    public UpdateTask(@NotNull String releaseConfigUrl, @NotNull FileProviderService fileProviderService, @Nullable ReleaseConfig releaseConfig, @NotNull Object fileLock, @NotNull TrackerCallback tracker, @NotNull NetUtils netUtils, @Nullable Map<String, String> map, @Nullable LazyDownloadCallback lazyDownloadCallback, boolean z) {
        ReleaseConfig.Config config;
        ReleaseConfig.PackageManifest pkg;
        ReleaseConfig.Config config2;
        ReleaseConfig.Config config3;
        Intrinsics.checkNotNullParameter(releaseConfigUrl, "releaseConfigUrl");
        Intrinsics.checkNotNullParameter(fileProviderService, "fileProviderService");
        Intrinsics.checkNotNullParameter(fileLock, "fileLock");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(netUtils, "netUtils");
        this.releaseConfigUrl = releaseConfigUrl;
        this.fileProviderService = fileProviderService;
        this.localReleaseConfig = releaseConfig;
        this.fileLock = fileLock;
        this.tracker = tracker;
        this.netUtils = netUtils;
        this.lazyDownloadCallback = lazyDownloadCallback;
        this.fromAirborne = z;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.updateUUID = string;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.trackers = copyOnWriteArrayList;
        this.waitQueue = new ArrayBlockingQueue(256);
        this.currentStage = Stage.INITIALIZING;
        this.currentStageStartTime = System.currentTimeMillis();
        ReleaseConfig releaseConfig2 = this.localReleaseConfig;
        this.releaseConfigTimeout = ((releaseConfig2 == null || (config3 = releaseConfig2.getConfig()) == null) ? Constants.INSTANCE.getDEFAULT_CONFIG() : config3).getReleaseConfigTimeout();
        this.initTime = System.currentTimeMillis();
        this.updateTimedOut = new AtomicBoolean(false);
        this.resourceDownloadStatus = ResourceUpdateStatus.RESOURCES_DOWNLOADING;
        ReleaseConfig releaseConfig3 = this.localReleaseConfig;
        this.packageTimeout = ((releaseConfig3 == null || (config2 = releaseConfig3.getConfig()) == null) ? Constants.INSTANCE.getDEFAULT_CONFIG() : config2).getBootTimeout();
        this.currentResult = UpdateResult.NA.INSTANCE;
        this.onFinishWaitTask = new WaitTask();
        Pair pair = new Pair("x-os-version", Build.VERSION.RELEASE);
        Pair pair2 = new Pair("x-airborne-version", SDK_VERSION);
        ReleaseConfig releaseConfig4 = this.localReleaseConfig;
        String version = null;
        Pair pair3 = new Pair("x-release-config-version", String.valueOf(releaseConfig4 != null ? releaseConfig4.getVersion() : null));
        ReleaseConfig releaseConfig5 = this.localReleaseConfig;
        Pair pair4 = new Pair("x-package-version", (releaseConfig5 == null || (pkg = releaseConfig5.getPkg()) == null) ? null : pkg.getVersion());
        ReleaseConfig releaseConfig6 = this.localReleaseConfig;
        if (releaseConfig6 != null && (config = releaseConfig6.getConfig()) != null) {
            version = config.getVersion();
        }
        this.defaultHeaders = MapsKt.i(pair, pair2, pair3, pair4, new Pair("x-config-version", version));
        copyOnWriteArrayList.add(tracker);
        map = map == null ? MapsKt.c() : map;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Set setEntrySet = new TreeMap(map).entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "sortedHeaders.entries");
        this.defaultHeaders.put("x-dimension", CollectionsKt.E(setEntrySet, ";", null, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: in.juspay.airborne.ota.UpdateTask$headersString$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getKey() + '=' + it.getValue();
            }
        }, 30));
    }

    private final void awaitCompletion(Stage stage, long j2) throws ExecutionException, InterruptedException, TimeoutException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.d(TAG, "awaitCompletion: awaiting " + stage.name() + " for " + j2 + "ms");
        WaitTask waitTask = new WaitTask();
        Pair<WaitTask, Stage> pair = new Pair<>(waitTask, stage);
        boolean zOffer = this.waitQueue.offer(pair);
        if (!zOffer) {
            Log.e(TAG, "Failed to enqueue!");
        }
        if (this.currentStage.ordinal() > stage.ordinal() || this.currentStage == Stage.FINISHED) {
            if (zOffer) {
                this.waitQueue.remove(pair);
            }
            waitTask.complete();
        }
        try {
            waitTask.get(j2, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            if (stage != Stage.DOWNLOADING_UPDATES) {
                throw e2;
            }
            this.resourceDownloadStatus = ResourceUpdateStatus.RESOURCES_TIMEDOUT;
            ResourceUpdateTask resourceUpdateTask = this.resourceUpdate;
            setCurrentResult$default(this, null, null, null, resourceUpdateTask != null ? resourceUpdateTask.installDownloadedResources() : null, 7, null);
            Future<Update.Package> future = this.packageUpdate;
            if (future == null || !future.isDone()) {
                throw e2;
            }
        }
        logTimeTaken(jCurrentTimeMillis, "awaitCompletion: " + stage.name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean copyFile(TempWriter tempWriter, String str, String str2) {
        return tempWriter.copyToMain(str, str2);
    }

    private final boolean copyFilesAsync(TempWriter tempWriter, String str) {
        String[] list = tempWriter.list();
        if (list != null) {
            if (list.length == 0) {
                return true;
            }
            ArrayList arrayList = new ArrayList(list.length);
            for (String str2 : list) {
                arrayList.add(Companion.doAsync(new d(tempWriter, str2, str, 2)));
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((Boolean) ((Future) it.next()).get());
            }
            if (arrayList2.isEmpty()) {
                return true;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.b((Boolean) it2.next(), Boolean.TRUE)) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean copyFilesAsync$lambda$28$lambda$25$lambda$24(TempWriter tempWriter, String it, String dest) {
        Intrinsics.checkNotNullParameter(tempWriter, "$tempWriter");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(dest, "$dest");
        return Boolean.valueOf(tempWriter.copyToMain(it, dest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<Unit> downloadFile(TempWriter tempWriter, URL url, String str) throws JSONException, IOException {
        Result<Unit> error;
        Log.d(TAG, "downloadFile " + url);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        Result resultFetch$default = fetch$default(this, string, true, false, 0, 12, null);
        if (resultFetch$default instanceof Result.Ok) {
            try {
                ResponseBody responseBody = (ResponseBody) ((Pair) ((Result.Ok) resultFetch$default).getV()).f53534b;
                if (Thread.interrupted()) {
                    Log.d(TAG, "Cancelled before writing: " + str);
                    return new Result.Error();
                }
                byte[] bArrB = responseBody.b();
                if (this.fromAirborne) {
                    Intrinsics.checkNotNullExpressionValue(bArrB, "{\n                      …                        }");
                } else {
                    byte[] bArrVerifyFileForHyperSDK = this.fileProviderService.getHyperFileUtil().verifyFileForHyperSDK(bArrB, str);
                    if (bArrVerifyFileForHyperSDK != null) {
                        bArrB = bArrVerifyFileForHyperSDK;
                    }
                    Intrinsics.checkNotNullExpressionValue(bArrB, "{\n                      …                        }");
                }
                if (tempWriter.write(str, bArrB)) {
                    Log.d(TAG, "File " + str + " written to disk");
                    error = new Result.Ok<>(Unit.f53572a);
                } else {
                    Log.e(TAG, "Write to disk failed while downloading: " + str);
                    error = new Result.Error<>();
                }
            } catch (Exception e2) {
                Log.e(TAG, "Error downloading file " + str, e2);
                Companion.closeQuietly((Closeable) ((Pair) ((Result.Ok) resultFetch$default).getV()).f53533a);
                trackFileWriteError(str, e2);
                error = new Result.Error<>();
            }
        } else {
            error = new Result.Error<>();
        }
        logTimeTaken(jCurrentTimeMillis, str);
        return error;
    }

    private final Update.Package downloadLazyPackageUpdate(ReleaseConfig.PackageManifest packageManifest, final TempWriter tw, final Function3<? super TempWriter, ? super String, ? super Boolean, Unit> function3) throws JSONException {
        ReleaseConfig releaseConfig = this.localReleaseConfig;
        ReleaseConfig.PackageManifest pkg = releaseConfig != null ? releaseConfig.getPkg() : null;
        if (!packageManifest.getLazy().isEmpty()) {
            List<ReleaseConfig.Split> lazy = packageManifest.getLazy();
            if (!(lazy instanceof Collection) || !lazy.isEmpty()) {
                Iterator<T> it = lazy.iterator();
                while (it.hasNext()) {
                    if (!Intrinsics.b(((ReleaseConfig.Split) it.next()).isDownloaded(), Boolean.TRUE)) {
                        JSONObject jSONObjectPut = new JSONObject().put("package_version", packageManifest.getVersion());
                        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"packag…ersion\", fetched.version)");
                        trackInfo("lazy_package_update_download_started", jSONObjectPut);
                        Log.d(TAG, "Trying to download lazy splits of the new app version " + packageManifest.getVersion() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            List<ReleaseConfig.Split> importantSplits = pkg != null ? pkg.getImportantSplits() : null;
                            if (importantSplits == null) {
                                importantSplits = EmptyList.f53609a;
                            }
                            List<ReleaseConfig.Split> list = importantSplits;
                            List<ReleaseConfig.Split> lazy2 = pkg != null ? pkg.getLazy() : null;
                            if (lazy2 == null) {
                                lazy2 = EmptyList.f53609a;
                            }
                            ArrayList arrayListL = CollectionsKt.L(list, lazy2);
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = arrayListL.iterator();
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                if (Intrinsics.b(((ReleaseConfig.Split) next).isDownloaded(), Boolean.TRUE)) {
                                    arrayList.add(next);
                                }
                            }
                            List difference = Companion.setDifference(packageManifest.getLazy(), arrayList);
                            Log.d(TAG, "Downloading lazy splits: " + difference);
                            if (tw == null) {
                                tw = this.fileProviderService.newTempWriter(Constants.PACKAGE_DIR_NAME);
                            }
                            List<ReleaseConfig.Split> lazy3 = packageManifest.getLazy();
                            Set elements = CollectionsKt.h0(arrayList);
                            Intrinsics.checkNotNullParameter(lazy3, "<this>");
                            Intrinsics.checkNotNullParameter(elements, "other");
                            LinkedHashSet<ReleaseConfig.Split> linkedHashSetG0 = CollectionsKt.g0(lazy3);
                            Intrinsics.checkNotNullParameter(linkedHashSetG0, "<this>");
                            Intrinsics.checkNotNullParameter(elements, "elements");
                            linkedHashSetG0.retainAll(CollectionsKt.t(elements));
                            for (ReleaseConfig.Split split : linkedHashSetG0) {
                                Boolean bool = Boolean.TRUE;
                                split.setDownloaded(bool);
                                Intrinsics.checkNotNullExpressionValue(tw, "tw");
                                function3.invoke(tw, split.getFilePath(), bool);
                            }
                            if (difference.isEmpty()) {
                                JSONObject jSONObjectPut2 = new JSONObject().put("lazy_package_splits_download", "lazy no new splits available");
                                Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"lazy_p…no new splits available\")");
                                trackInfo("lazy_package_update_info", jSONObjectPut2);
                            } else {
                                Log.d(TAG, "Starting lazy split downloads.");
                                List<ReleaseConfig.Split> list2 = difference;
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list2, 10));
                                for (final ReleaseConfig.Split split2 : list2) {
                                    arrayList2.add(Companion.doAsync(new Callable() { // from class: in.juspay.airborne.ota.c
                                        @Override // java.util.concurrent.Callable
                                        public final Object call() {
                                            return UpdateTask.downloadLazyPackageUpdate$lambda$21$lambda$20(split2, this, tw, function3);
                                        }
                                    }));
                                }
                                Log.d(TAG, "Awaiting split downloads.");
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    arrayList3.add((Result) ((Future) it3.next()).get());
                                }
                                if (!arrayList3.isEmpty()) {
                                    Iterator it4 = arrayList3.iterator();
                                    while (it4.hasNext()) {
                                        if (((Result) it4.next()) instanceof Result.Error) {
                                            Log.d(TAG, "Failed to download some lazy splits.");
                                            JSONObject jSONObjectPut3 = new JSONObject().put("result", "FAILURE").put("reason", "Failed to download some lazy splits");
                                            Intrinsics.checkNotNullExpressionValue(jSONObjectPut3, "JSONObject()\n           …wnload some lazy splits\")");
                                            trackInfo("lazy_package_download_result", jSONObjectPut3);
                                            return Update.Package.Failed.INSTANCE;
                                        }
                                    }
                                }
                                JSONObject jSONObjectPut4 = new JSONObject().put("result", MerchantConstants.SUCCESS).put("reason", "lazy");
                                Intrinsics.checkNotNullExpressionValue(jSONObjectPut4, "JSONObject()\n           …   .put(\"reason\", \"lazy\")");
                                trackInfo("lazy_package_download_result", jSONObjectPut4);
                                logTimeTaken(jCurrentTimeMillis, "Downloaded new lazy package splits");
                            }
                            Intrinsics.checkNotNullExpressionValue(tw, "tw");
                            return new Update.Package.Finished(tw);
                        } catch (Exception e2) {
                            Log.d(TAG, "An exception occurred during lazy package update.");
                            trackException$default(this, "lazy_package_update_error", e2, null, 4, null);
                            return Update.Package.Failed.INSTANCE;
                        }
                    }
                }
            }
        }
        JSONObject jSONObjectPut5 = new JSONObject().put("package_splits_download", "No updates in app");
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut5, "JSONObject().put(\"packag…ad\", \"No updates in app\")");
        trackInfo("lazy_package_update_info", jSONObjectPut5);
        Log.d(TAG, "No updates in app for lazy.");
        return Update.Package.NA.INSTANCE;
    }

    public static /* synthetic */ Update.Package downloadLazyPackageUpdate$default(UpdateTask updateTask, ReleaseConfig.PackageManifest packageManifest, TempWriter tempWriter, Function3 function3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            tempWriter = null;
        }
        return updateTask.downloadLazyPackageUpdate(packageManifest, tempWriter, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result downloadLazyPackageUpdate$lambda$21$lambda$20(ReleaseConfig.Split it, UpdateTask this$0, TempWriter tw, Function3 downloadCallback) throws JSONException, IOException {
        Result<Unit> resultDownloadFile;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(downloadCallback, "$downloadCallback");
        if (Intrinsics.b(it.isDownloaded(), Boolean.TRUE)) {
            resultDownloadFile = new Result.Ok<>(Unit.f53572a);
        } else {
            Intrinsics.checkNotNullExpressionValue(tw, "tw");
            resultDownloadFile = this$0.downloadFile(tw, it.getUrl(), it.getFilePath());
        }
        Intrinsics.checkNotNullExpressionValue(tw, "tw");
        downloadCallback.invoke(tw, it.getFilePath(), Boolean.valueOf(resultDownloadFile instanceof Result.Ok));
        return resultDownloadFile;
    }

    private final void downloadLazySplits(TempWriter tempWriter, final ReleaseConfig.PackageManifest packageManifest, final boolean z) throws JSONException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Update.Package packageDownloadLazyPackageUpdate = downloadLazyPackageUpdate(packageManifest, tempWriter, new Function3<TempWriter, String, Boolean, Unit>() { // from class: in.juspay.airborne.ota.UpdateTask$downloadLazySplits$updateResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((TempWriter) obj, (String) obj2, ((Boolean) obj3).booleanValue());
                return Unit.f53572a;
            }

            public final void invoke(@NotNull TempWriter tw1, @NotNull String filePath, boolean z2) {
                Object next;
                Intrinsics.checkNotNullParameter(tw1, "tw1");
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                if (z) {
                    Iterator<T> it = packageManifest.getLazy().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (Intrinsics.b(((ReleaseConfig.Split) next).getFilePath(), filePath)) {
                                break;
                            }
                        }
                    }
                    ReleaseConfig.Split split = (ReleaseConfig.Split) next;
                    boolean z3 = false;
                    if (split != null ? Intrinsics.b(split.isDownloaded(), Boolean.TRUE) : false) {
                        this.incrementLazyDownloadCount(atomicInteger, packageManifest, filePath, true);
                    } else {
                        if (z2 && this.copyFile(tw1, filePath, "app/package")) {
                            z3 = true;
                        }
                        if (z3 && split != null) {
                            split.setDownloaded(Boolean.TRUE);
                        }
                        this.incrementLazyDownloadCount(atomicInteger, packageManifest, filePath, z3);
                    }
                    if (atomicInteger.get() % 5 == 0) {
                        this.writePackageManifest(packageManifest);
                    }
                }
            }
        });
        if (z && (packageDownloadLazyPackageUpdate instanceof Update.Package.Finished)) {
            writePackageManifest(packageManifest);
            trackPackageUpdateResult(new Result.Ok(packageManifest.getVersion()), jCurrentTimeMillis);
        }
        if (z) {
            return;
        }
        if ((packageDownloadLazyPackageUpdate instanceof Update.Package.Finished) || (packageDownloadLazyPackageUpdate instanceof Update.Package.NA)) {
            saveDownloadedPackages(packageDownloadLazyPackageUpdate, packageManifest);
        }
    }

    private final Update.Package downloadPackageUpdate(ReleaseConfig.PackageManifest packageManifest) throws JSONException {
        List<ReleaseConfig.Split> importantSplits;
        ReleaseConfig releaseConfig = this.localReleaseConfig;
        ReleaseConfig.PackageManifest pkg = releaseConfig != null ? releaseConfig.getPkg() : null;
        if (Intrinsics.b(pkg != null ? pkg.getVersion() : null, packageManifest.getVersion())) {
            JSONObject jSONObjectPut = new JSONObject().put("package_splits_download", "No updates in app");
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"packag…ad\", \"No updates in app\")");
            trackInfo("important_package_update_info", jSONObjectPut);
            Log.d(TAG, "No updates in app.");
            return Update.Package.NA.INSTANCE;
        }
        JSONObject jSONObjectPut2 = new JSONObject().put("package_version", packageManifest.getVersion());
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"packag…ersion\", fetched.version)");
        trackInfo("package_update_download_started", jSONObjectPut2);
        Log.d(TAG, "New app version " + packageManifest.getVersion() + " available, trying to download update.");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Companion companion = Companion;
            List<ReleaseConfig.Split> importantSplits2 = packageManifest.getImportantSplits();
            if (pkg == null || (importantSplits = pkg.getImportantSplits()) == null) {
                importantSplits = EmptyList.f53609a;
            }
            List difference = companion.setDifference(importantSplits2, importantSplits);
            Log.d(TAG, "Downloading important splits: " + difference);
            TempWriter tw = this.fileProviderService.newTempWriter(Constants.PACKAGE_DIR_NAME);
            if (difference.isEmpty()) {
                JSONObject jSONObjectPut3 = new JSONObject().put("important_package_splits_download", "important no new splits available");
                Intrinsics.checkNotNullExpressionValue(jSONObjectPut3, "JSONObject().put(\n      …le\"\n                    )");
                trackInfo("important_package_update_info", jSONObjectPut3);
            } else {
                Log.d(TAG, "Starting important split downloads.");
                List list = difference;
                ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Companion.doAsync(new e((ReleaseConfig.Split) it.next(), this, tw)));
                }
                Log.d(TAG, "Awaiting split downloads.");
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((Result) ((Future) it2.next()).get());
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        if (((Result) it3.next()) instanceof Result.Error) {
                            Log.d(TAG, "Failed to download some important splits.");
                            JSONObject jSONObjectPut4 = new JSONObject().put("result", "FAILURE").put("reason", "Failed to download some important splits");
                            Intrinsics.checkNotNullExpressionValue(jSONObjectPut4, "JSONObject()\n           …d some important splits\")");
                            trackInfo("important_package_download_result", jSONObjectPut4);
                            return Update.Package.Failed.INSTANCE;
                        }
                    }
                }
                JSONObject jSONObjectPut5 = new JSONObject().put("result", MerchantConstants.SUCCESS).put("reason", "important");
                Intrinsics.checkNotNullExpressionValue(jSONObjectPut5, "JSONObject()\n           …ut(\"reason\", \"important\")");
                trackInfo("important_package_download_result", jSONObjectPut5);
                logTimeTaken(jCurrentTimeMillis, "Downloaded new important package splits");
            }
            Intrinsics.checkNotNullExpressionValue(tw, "tw");
            return new Update.Package.Finished(tw);
        } catch (Exception e2) {
            Log.d(TAG, "An exception occurred during important package update.");
            trackException$default(this, "important_package_update_error", e2, null, 4, null);
            return Update.Package.Failed.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result downloadPackageUpdate$lambda$14$lambda$13(ReleaseConfig.Split it, UpdateTask this$0, TempWriter tw) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.b(it.isDownloaded(), Boolean.TRUE)) {
            return new Result.Ok(Unit.f53572a);
        }
        Intrinsics.checkNotNullExpressionValue(tw, "tw");
        return this$0.downloadFile(tw, it.getUrl(), it.getFilePath());
    }

    private final Result<Pair<Response, ResponseBody>> fetch(String str, boolean z, boolean z2, int i2) throws JSONException {
        String str2;
        Map<String, String> map;
        try {
            if (z2) {
                map = this.defaultHeaders;
                map.put("cache-control", "no-cache");
            } else {
                map = this.defaultHeaders;
            }
            str2 = str;
            try {
                Response resp = this.netUtils.doGet(str2, map, null, null, null);
                int i3 = resp.f56353d;
                ResponseBody responseBody = resp.f56356g;
                if (i3 != 200) {
                    Log.e(TAG, "Error in fetch " + str2 + " code = " + i3);
                    Intrinsics.checkNotNullExpressionValue(resp, "resp");
                    trackFetchHttpError(resp);
                    resp.close();
                    return new Result.Error.HttpError(resp);
                }
                if (responseBody != null) {
                    return new Result.Ok(new Pair(resp, responseBody));
                }
                Log.e(TAG, "Error in fetch " + str2 + " body = null");
                Intrinsics.checkNotNullExpressionValue(resp, "resp");
                trackFetchHttpError(resp);
                resp.close();
                return new Result.Error.HttpNoBody(resp);
            } catch (IOException e2) {
                e = e2;
                Log.e(TAG, "Error in fetch " + str2, e);
                if (e instanceof InterruptedIOException) {
                    return new Result.Error();
                }
                trackFetchIOError(str2, e);
                return (i2 >= 1 || !z) ? new Result.Error() : fetch(str2, true, z2, i2 + 1);
            }
        } catch (IOException e3) {
            e = e3;
            str2 = str;
        }
    }

    public static /* synthetic */ Result fetch$default(UpdateTask updateTask, String str, boolean z, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return updateTask.fetch(str, z, z2, i2);
    }

    private final ReleaseConfig fetchReleaseConfig() throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Result<Pair<Response, ResponseBody>> resultFetch$default = fetch$default(this, this.releaseConfigUrl, false, true, 0, 10, null);
        if (!(resultFetch$default instanceof Result.Ok)) {
            if (!(resultFetch$default instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            trackReleaseConfigFetchResult(resultFetch$default, jCurrentTimeMillis);
            return null;
        }
        byte[] bArrB = ((ResponseBody) ((Pair) ((Result.Ok) resultFetch$default).getV()).f53534b).b();
        Intrinsics.checkNotNullExpressionValue(bArrB, "body.bytes()");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        try {
            Object objM61deSerializeIoAF18A = ReleaseConfig.Companion.m61deSerializeIoAF18A(new String(bArrB, UTF_8));
            ResultKt.b(objM61deSerializeIoAF18A);
            ReleaseConfig releaseConfig = (ReleaseConfig) objM61deSerializeIoAF18A;
            trackReleaseConfigFetchResult(resultFetch$default, jCurrentTimeMillis);
            return releaseConfig;
        } catch (Exception e2) {
            Log.e(TAG, "Failed to parse release config " + Log.getStackTraceString(e2));
            trackReleaseConfigFetchResult(new Result.Error.ParseError(e2), jCurrentTimeMillis);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLazyDownloadCount(AtomicInteger atomicInteger, ReleaseConfig.PackageManifest packageManifest, String str, boolean z) {
        LazyDownloadCallback lazyDownloadCallback;
        if (z) {
            LazyDownloadCallback lazyDownloadCallback2 = this.lazyDownloadCallback;
            if (lazyDownloadCallback2 != null) {
                lazyDownloadCallback2.fileInstalled(str, true);
            }
            if (atomicInteger.incrementAndGet() != packageManifest.getLazy().size() || (lazyDownloadCallback = this.lazyDownloadCallback) == null) {
                return;
            }
            lazyDownloadCallback.lazySplitsInstalled(true);
            return;
        }
        LazyDownloadCallback lazyDownloadCallback3 = this.lazyDownloadCallback;
        if (lazyDownloadCallback3 != null) {
            lazyDownloadCallback3.fileInstalled(str, false);
        }
        LazyDownloadCallback lazyDownloadCallback4 = this.lazyDownloadCallback;
        if (lazyDownloadCallback4 != null) {
            lazyDownloadCallback4.lazySplitsInstalled(false);
        }
        atomicInteger.set(packageManifest.getLazy().size() + 1);
    }

    private final boolean installPackageUpdate(Update.Package r5, ReleaseConfig.PackageManifest packageManifest, long j2) throws JSONException {
        if (Intrinsics.b(r5, Update.Package.Failed.INSTANCE)) {
            trackPackageUpdateResult(new Result.Error(), j2);
            return false;
        }
        if (Intrinsics.b(r5, Update.Package.NA.INSTANCE)) {
            JSONObject jSONObjectPut = new JSONObject().put("result", "No package update available").put("time_taken", System.currentTimeMillis() - j2);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"result…TimeMillis() - startTime)");
            trackInfo(LogKey.PACKAGE_UPDATE_RESULT, jSONObjectPut);
            Log.d(TAG, "Application is up to-date!");
            return false;
        }
        if (!(r5 instanceof Update.Package.Finished)) {
            throw new NoWhenBranchMatchedException();
        }
        Iterator<T> it = packageManifest.getLazy().iterator();
        while (it.hasNext()) {
            ((ReleaseConfig.Split) it.next()).setDownloaded(Boolean.FALSE);
        }
        return movePackageUpdate(((Update.Package.Finished) r5).getTempWriter(), packageManifest, j2);
    }

    private final JSONObject loadPersistentState() throws JSONException {
        try {
            String fromFile = this.fileProviderService.readFromFile("app/state.json");
            Intrinsics.checkNotNullExpressionValue(fromFile, "fileProviderService.read…le(\"$APP_DIR/state.json\")");
            return fromFile.length() == 0 ? new JSONObject() : new JSONObject(fromFile);
        } catch (JSONException e2) {
            trackException$default(this, "persistent_state_load_failed", e2, null, 4, null);
            savePersistentState(new JSONObject());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTimeTaken(long j2, String str) {
    }

    public static /* synthetic */ void logTimeTaken$default(UpdateTask updateTask, long j2, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        updateTask.logTimeTaken(j2, str);
    }

    private final boolean movePackageUpdate(TempWriter tempWriter, ReleaseConfig.PackageManifest packageManifest, long j2) throws JSONException {
        boolean zWritePackageManifest;
        boolean zCopyFilesAsync = copyFilesAsync(tempWriter, "app/package");
        if (zCopyFilesAsync) {
            Log.d(TAG, "Copied important splits.");
        }
        boolean z = false;
        if (zCopyFilesAsync) {
            Iterator<T> it = packageManifest.getImportant().iterator();
            while (it.hasNext()) {
                ((ReleaseConfig.Split) it.next()).setDownloaded(Boolean.TRUE);
            }
            zWritePackageManifest = writePackageManifest(packageManifest);
        } else {
            zWritePackageManifest = false;
        }
        if (zWritePackageManifest) {
            Log.d(TAG, "Wrote package manifest.");
        }
        if (zCopyFilesAsync && zWritePackageManifest) {
            z = true;
        }
        if (!z) {
            Log.e(TAG, "An error occurred while installing the important package splits.");
            trackPackageUpdateResult(new Result.Error.CustomError(!zCopyFilesAsync ? "important splits package copy failed" : "release config write failed"), j2);
            return z;
        }
        Log.d(TAG, "Installed new important package version: " + packageManifest.getVersion());
        trackPackageUpdateResult(new Result.Ok(packageManifest.getVersion()), j2);
        return z;
    }

    private final void onComplete(Stage stage) throws ExecutionException, JSONException, InterruptedException {
        if (stage.ordinal() >= this.currentStage.ordinal()) {
            Stage stage2 = this.currentStage;
            Stage stage3 = Stage.FINISHED;
            if (stage2 != stage3) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.currentStageStartTime;
                this.currentStageStartTime = System.currentTimeMillis();
                Log.d(TAG, "Ended stage: " + stage.name() + ' ' + jCurrentTimeMillis + "ms");
                switch (WhenMappings.$EnumSwitchMapping$0[stage.ordinal()]) {
                    case 1:
                        stage3 = Stage.FETCHING_RC;
                        break;
                    case 2:
                        stage3 = Stage.DOWNLOADING_UPDATES;
                        break;
                    case 3:
                        stage3 = Stage.INSTALLING;
                        break;
                    case 4:
                        stage3 = Stage.LAZY_DOWNLOADING;
                        break;
                    case 5:
                    case 6:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                this.currentStage = stage3;
                Log.d(TAG, "Reached stage: " + this.currentStage.name());
                int size = this.waitQueue.size();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        if (this.currentStage == Stage.FINISHED) {
                            while (!this.waitQueue.isEmpty()) {
                                Pair<WaitTask, Stage> pairPoll = this.waitQueue.poll();
                                if (pairPoll != null) {
                                    ((WaitTask) pairPoll.f53533a).complete();
                                }
                            }
                            trackEnd();
                            JSONObject jSONObjectLoadPersistentState = loadPersistentState();
                            Function2<? super UpdateResult, ? super JSONObject, Unit> function2 = this.onFinish;
                            if (function2 != null) {
                                function2.invoke(this.currentResult, jSONObjectLoadPersistentState);
                            }
                            this.onFinishWaitTask.complete();
                            Future<Unit> future = this.resourceSaveFuture;
                            if (future == null) {
                                return;
                            }
                            future.get();
                            return;
                        }
                        return;
                    }
                    Pair<WaitTask, Stage> pairPoll2 = this.waitQueue.poll();
                    if (pairPoll2 != null) {
                        WaitTask waitTask = (WaitTask) pairPoll2.f53533a;
                        if (((Stage) pairPoll2.f53534b).ordinal() <= stage.ordinal()) {
                            waitTask.complete();
                        } else {
                            this.waitQueue.offer(pairPoll2);
                        }
                    }
                    size = i2;
                }
            }
        }
        Log.d(TAG, "Received completion of stage " + stage.name() + " even though current stage is" + this.currentStage.name() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject readPersistentState(ApplicationManager.StateKey stateKey) {
        Log.d(TAG, "readPersistentState: " + stateKey.name());
        JSONObject jSONObjectOptJSONObject = loadPersistentState().optJSONObject(stateKey.name());
        Log.d(TAG, "readPersistentState exit");
        return jSONObjectOptJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeFromPersistentState(ApplicationManager.StateKey stateKey) throws JSONException {
        JSONObject jSONObjectLoadPersistentState = loadPersistentState();
        jSONObjectLoadPersistentState.remove(stateKey.name());
        savePersistentState(jSONObjectLoadPersistentState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit run$lambda$1(UpdateTask this$0) throws ExecutionException, JSONException, InterruptedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.runInternal();
        return Unit.f53572a;
    }

    private final void runInternal() throws ExecutionException, JSONException, InterruptedException {
        ReleaseConfig.Config config;
        ReleaseConfig releaseConfig;
        ReleaseConfig.PackageManifest pkg;
        boolean zBooleanValue;
        ReleaseConfig.Config config2;
        ReleaseConfig.PackageManifest pkg2;
        ReleaseConfig.PackageManifest pkg3;
        UpdateTask updateTask = this;
        ReleaseConfig releaseConfigFetchReleaseConfig = updateTask.fetchReleaseConfig();
        if (releaseConfigFetchReleaseConfig == null) {
            updateTask.currentResult = UpdateResult.Error.RCFetchError.INSTANCE;
            updateTask.onComplete(Stage.INSTALLING);
        } else {
            updateTask.updateTimeouts(releaseConfigFetchReleaseConfig);
            updateTask.onComplete(Stage.FETCHING_RC);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Companion companion = Companion;
            updateTask.packageUpdate = companion.doAsync(new androidx.media3.datasource.b(6, updateTask, releaseConfigFetchReleaseConfig));
            ReleaseConfig releaseConfig2 = updateTask.localReleaseConfig;
            ResourceUpdateTask resourceUpdateTask = new ResourceUpdateTask(updateTask, releaseConfig2 != null ? releaseConfig2.getResources() : null, releaseConfigFetchReleaseConfig.getResources());
            updateTask.resourceUpdate = resourceUpdateTask;
            resourceUpdateTask.start();
            String version = releaseConfigFetchReleaseConfig.getVersion();
            ReleaseConfig releaseConfig3 = updateTask.localReleaseConfig;
            if (!Intrinsics.b(version, releaseConfig3 != null ? releaseConfig3.getVersion() : null) && updateTask.writeRCVersion(releaseConfigFetchReleaseConfig.getVersion())) {
                JSONObject jSONObjectPut = new JSONObject().put("new_rc_version", releaseConfigFetchReleaseConfig.getVersion());
                Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"new_rc…ersion\", fetched.version)");
                updateTask.trackInfo("rc_version_updated", jSONObjectPut);
                Log.d(TAG, "RC Version updated.");
            }
            String version2 = releaseConfigFetchReleaseConfig.getConfig().getVersion();
            ReleaseConfig releaseConfig4 = updateTask.localReleaseConfig;
            if (Intrinsics.b(version2, (releaseConfig4 == null || (config2 = releaseConfig4.getConfig()) == null) ? null : config2.getVersion()) || !updateTask.writeConfig(releaseConfigFetchReleaseConfig.getConfig())) {
                config = null;
            } else {
                ReleaseConfig.Config config3 = releaseConfigFetchReleaseConfig.getConfig();
                setCurrentResult$default(updateTask, releaseConfigFetchReleaseConfig.getVersion(), config3, null, null, 12, null);
                JSONObject jSONObjectPut2 = new JSONObject().put("new_config_version", releaseConfigFetchReleaseConfig.getConfig().getVersion());
                Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"new_co…, fetched.config.version)");
                updateTask.trackInfo("config_updated", jSONObjectPut2);
                Log.d(TAG, "Config updated.");
                config = config3;
            }
            Future<Update.Package> future = updateTask.packageUpdate;
            Update.Package r1 = future != null ? future.get() : null;
            ResourceUpdateTask resourceUpdateTask2 = updateTask.resourceUpdate;
            if (resourceUpdateTask2 != null) {
                resourceUpdateTask2.awaitResourceUpdates();
            }
            updateTask.onComplete(Stage.DOWNLOADING_UPDATES);
            if (updateTask.updateTimedOut.get()) {
                releaseConfig = releaseConfigFetchReleaseConfig;
                if (r1 != null && releaseConfig.getPkg().getLazy().isEmpty()) {
                    updateTask.saveDownloadedPackages(r1, releaseConfig.getPkg());
                }
                pkg = null;
                zBooleanValue = false;
            } else {
                Log.d(TAG, "Installing package as updateTimedout is false");
                releaseConfig = releaseConfigFetchReleaseConfig;
                updateTask = this;
                Object obj = companion.doAsync(new b(r1, this, releaseConfig, jCurrentTimeMillis)).get();
                Intrinsics.checkNotNullExpressionValue(obj, "packageInstallFuture.get()");
                zBooleanValue = ((Boolean) obj).booleanValue();
                pkg = zBooleanValue ? releaseConfig.getPkg() : null;
            }
            ResourceUpdateTask resourceUpdateTask3 = updateTask.resourceUpdate;
            ReleaseConfig.ResourceManifest resourceManifestInstallDownloadedResources = resourceUpdateTask3 != null ? resourceUpdateTask3.installDownloadedResources() : null;
            ResourceUpdateTask resourceUpdateTask4 = updateTask.resourceUpdate;
            if (resourceUpdateTask4 != null) {
                resourceUpdateTask4.completeResourceDownload();
            }
            updateTask.onComplete(Stage.INSTALLING);
            updateTask.setCurrentResult(releaseConfig.getVersion(), config, pkg, resourceManifestInstallDownloadedResources);
            z = updateTask.updateTimedOut.get() || !zBooleanValue;
            if (r1 instanceof Update.Package.Finished) {
                Log.d(TAG, "Starting lazy splits download of new pkg version " + releaseConfig.getPkg().getVersion());
                updateTask.downloadLazySplits(((Update.Package.Finished) r1).getTempWriter(), releaseConfig.getPkg(), z ^ true);
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder("Starting lazy splits download of current pkg version ");
            ReleaseConfig releaseConfig5 = updateTask.localReleaseConfig;
            sb.append((releaseConfig5 == null || (pkg3 = releaseConfig5.getPkg()) == null) ? null : pkg3.getVersion());
            Log.d(TAG, sb.toString());
            ReleaseConfig releaseConfig6 = updateTask.localReleaseConfig;
            if (releaseConfig6 != null && (pkg2 = releaseConfig6.getPkg()) != null) {
                updateTask.downloadLazySplits(null, pkg2, true);
            }
        }
        updateTask.onComplete(Stage.LAZY_DOWNLOADING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Update.Package runInternal$lambda$2(UpdateTask this$0, ReleaseConfig releaseConfig) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.downloadPackageUpdate(releaseConfig.getPkg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean runInternal$lambda$4(Update.Package r1, UpdateTask this$0, ReleaseConfig releaseConfig, long j2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (r1 != null) {
            return Boolean.valueOf(this$0.installPackageUpdate(r1, releaseConfig.getPkg(), j2));
        }
        return null;
    }

    private final void saveDownloadedPackages(Update.Package r5, ReleaseConfig.PackageManifest packageManifest) throws JSONException {
        if (r5 instanceof Update.Package.Finished) {
            Iterator<T> it = packageManifest.getLazy().iterator();
            while (it.hasNext()) {
                ((ReleaseConfig.Split) it.next()).setDownloaded(Boolean.TRUE);
            }
            JSONObject jSONObject = new JSONObject(MapsKt.h(new Pair("dir", ((Update.Package.Finished) r5).getTempWriter().getDirName()), new Pair("package_manifest", packageManifest.toJSON())));
            Log.d(TAG, "Saved resources " + packageManifest);
            setInPersistentState(ApplicationManager.StateKey.SAVED_PACKAGE_UPDATE, jSONObject);
        }
    }

    private final void savePersistentState(JSONObject jSONObject) throws JSONException {
        try {
            FileProviderService fileProviderService = this.fileProviderService;
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "state.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fileProviderService.updateFile("app/state.json", bytes);
        } catch (Exception e2) {
            JSONObject jSONObjectPut = new JSONObject().put("state", jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"state\", state)");
            trackException("persistent_state_save_failed", e2, jSONObjectPut);
        }
    }

    private final void setCurrentResult(String str, ReleaseConfig.Config config, ReleaseConfig.PackageManifest packageManifest, ReleaseConfig.ResourceManifest resourceManifest) {
        ReleaseConfig releaseConfig;
        ReleaseConfig releaseConfig2;
        ReleaseConfig releaseConfig3;
        if (config == null && packageManifest == null && resourceManifest == null) {
            return;
        }
        try {
            UpdateResult updateResult = this.currentResult;
            UpdateResult.Ok ok = updateResult instanceof UpdateResult.Ok ? (UpdateResult.Ok) updateResult : null;
            ReleaseConfig releaseConfig4 = ok != null ? ok.getReleaseConfig() : null;
            if (str == null) {
                str = releaseConfig4 != null ? releaseConfig4.getVersion() : null;
                if (str == null && ((releaseConfig3 = this.localReleaseConfig) == null || (str = releaseConfig3.getVersion()) == null)) {
                    str = "1";
                }
            }
            if (config == null) {
                config = releaseConfig4 != null ? releaseConfig4.getConfig() : null;
                if (config == null && ((releaseConfig2 = this.localReleaseConfig) == null || (config = releaseConfig2.getConfig()) == null)) {
                    config = Constants.INSTANCE.getDEFAULT_CONFIG();
                }
            }
            if (packageManifest == null) {
                packageManifest = releaseConfig4 != null ? releaseConfig4.getPkg() : null;
                if (packageManifest == null) {
                    ReleaseConfig releaseConfig5 = this.localReleaseConfig;
                    packageManifest = releaseConfig5 != null ? releaseConfig5.getPkg() : null;
                    Intrinsics.c(packageManifest);
                }
            }
            if (resourceManifest == null) {
                resourceManifest = releaseConfig4 != null ? releaseConfig4.getResources() : null;
                if (resourceManifest == null && ((releaseConfig = this.localReleaseConfig) == null || (resourceManifest = releaseConfig.getResources()) == null)) {
                    resourceManifest = Constants.INSTANCE.getDEFAULT_RESOURCES();
                }
            }
            this.currentResult = new UpdateResult.Ok(new ReleaseConfig(str, config, packageManifest, resourceManifest));
        } catch (NullPointerException unused) {
            this.currentResult = UpdateResult.Error.Unknown.INSTANCE;
        }
    }

    public static /* synthetic */ void setCurrentResult$default(UpdateTask updateTask, String str, ReleaseConfig.Config config, ReleaseConfig.PackageManifest packageManifest, ReleaseConfig.ResourceManifest resourceManifest, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            config = null;
        }
        if ((i2 & 4) != 0) {
            packageManifest = null;
        }
        if ((i2 & 8) != 0) {
            resourceManifest = null;
        }
        updateTask.setCurrentResult(str, config, packageManifest, resourceManifest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInPersistentState(ApplicationManager.StateKey stateKey, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectLoadPersistentState = loadPersistentState();
        try {
            jSONObjectLoadPersistentState.put(stateKey.name(), jSONObject);
            savePersistentState(jSONObjectLoadPersistentState);
        } catch (JSONException e2) {
            Log.e("Update Task", "Persistent state write failed " + jSONObjectLoadPersistentState);
            JSONObject jSONObjectPut = new JSONObject().put("key", stateKey).put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …     .put(\"value\", value)");
            trackException("persistent_state_set_failed", e2, jSONObjectPut);
        }
    }

    private final void trackEnd() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("time_taken", System.currentTimeMillis() - this.initTime);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"time_t…tTimeMillis() - initTime)");
        trackInfo("end", jSONObjectPut);
    }

    private final void trackError(String str, JSONObject jSONObject) throws JSONException {
        trackGeneric("error", str, jSONObject);
    }

    private final void trackException(String str, Exception exc, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectPut = jSONObject.put("error", exc.getMessage()).put("stack_trace", Log.getStackTraceString(exc));
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "value\n                .p…g.getStackTraceString(e))");
        trackError(str, jSONObjectPut);
    }

    public static /* synthetic */ void trackException$default(UpdateTask updateTask, String str, Exception exc, JSONObject jSONObject, int i2, Object obj) throws JSONException {
        if ((i2 & 4) != 0) {
            jSONObject = new JSONObject();
        }
        updateTask.trackException(str, exc, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void trackFetchHttpError(okhttp3.Response r5) throws org.json.JSONException, java.io.IOException {
        /*
            r4 = this;
            okhttp3.ResponseBody r0 = r5.f56356g
            if (r0 == 0) goto L10
            java.io.InputStream r0 = r0.a()
            in.juspay.airborne.ota.UpdateTask$Companion r1 = in.juspay.airborne.ota.UpdateTask.Companion
            java.lang.String r0 = r1.utf8(r0)
            if (r0 != 0) goto L12
        L10:
            java.lang.String r0 = "null"
        L12:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            okhttp3.Request r2 = r5.f56350a
            okhttp3.HttpUrl r2 = r2.f56331a
            java.lang.String r2 = r2.f56267i
            java.lang.String r3 = "url"
            org.json.JSONObject r1 = r1.put(r3, r2)
            java.lang.String r2 = "status"
            int r5 = r5.f56353d
            org.json.JSONObject r5 = r1.put(r2, r5)
            java.lang.String r1 = "body"
            org.json.JSONObject r5 = r5.put(r1, r0)
            java.lang.String r0 = "JSONObject()\n           …       .put(\"body\", body)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "fetch_failed"
            r4.trackError(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.airborne.ota.UpdateTask.trackFetchHttpError(okhttp3.Response):void");
    }

    private final void trackFetchIOError(String str, IOException iOException) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("url", str);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"url\", url)");
        trackException("fetch_failed", iOException, jSONObjectPut);
    }

    private final void trackFileWriteError(String str, Exception exc) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("file_name", str);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"file_name\", fileName)");
        trackException("file_write_failed", exc, jSONObjectPut);
    }

    private final void trackGeneric(String str, String str2, JSONObject jSONObject) throws JSONException {
        for (TrackerCallback trackerCallback : this.trackers) {
            JSONObject jSONObjectPut = jSONObject.put("app_update_id", this.updateUUID);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "value.put(\"app_update_id\", updateUUID)");
            trackerCallback.track("lifecycle", LogSubCategory.LifeCycle.HYPER_OTA, str, LABEL, str2, jSONObjectPut);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackInfo(String str, JSONObject jSONObject) throws JSONException {
        trackGeneric("info", str, jSONObject);
    }

    private final void trackInit() throws JSONException {
        ReleaseConfig.PackageManifest pkg;
        ReleaseConfig.Config config;
        JSONObject jSONObject = new JSONObject();
        ReleaseConfig releaseConfig = this.localReleaseConfig;
        String version = null;
        JSONObject jSONObjectPut = jSONObject.put("config_version", (releaseConfig == null || (config = releaseConfig.getConfig()) == null) ? null : config.getVersion());
        ReleaseConfig releaseConfig2 = this.localReleaseConfig;
        if (releaseConfig2 != null && (pkg = releaseConfig2.getPkg()) != null) {
            version = pkg.getVersion();
        }
        jSONObjectPut.put("package_version", version);
        trackInfo("init with local config versions", jSONObject);
    }

    private final void trackPackageUpdateResult(Result<String> result, long j2) throws JSONException {
        Pair pair = result instanceof Result.Ok ? new Pair(((Result.Ok) result).getV(), null) : result instanceof Result.Error.CustomError ? new Pair(null, ((Result.Error.CustomError) result).getMsg()) : new Pair(null, "Reason unknown");
        JSONObject jSONObject = new JSONObject();
        Object obj = pair.f53533a;
        if (obj != null) {
            jSONObject.put("result", MerchantConstants.SUCCESS).put("package_version", obj);
        } else {
            jSONObject.put("result", "FAILED");
        }
        Object obj2 = pair.f53534b;
        if (((String) obj2) != null) {
            jSONObject.put("reason", obj2);
        }
        JSONObject jSONObjectPut = jSONObject.put("time_taken", System.currentTimeMillis() - j2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "value.put(\"time_taken\", …TimeMillis() - startTime)");
        trackInfo(LogKey.PACKAGE_UPDATE_RESULT, jSONObjectPut);
    }

    private final void trackReleaseConfigFetchResult(Result<Pair<Response, ResponseBody>> result, long j2) throws JSONException {
        String strValueOf = result instanceof Result.Ok ? Integer.valueOf(((Response) ((Pair) ((Result.Ok) result).getV()).f53533a).f56353d) : result instanceof Result.Error.HttpError ? Integer.valueOf(((Result.Error.HttpError) result).getResponse().f56353d) : result instanceof Result.Error.HttpNoBody ? Integer.valueOf(((Result.Error.HttpNoBody) result).getResponse().f56353d) : "-1";
        String message = result instanceof Result.Error.HttpError ? ((Result.Error.HttpError) result).getResponse().f56352c : result instanceof Result.Error.HttpNoBody ? "HTTP_NO_BODY" : result instanceof Result.Error.ParseError ? ((Result.Error.ParseError) result).getE().getMessage() : null;
        JSONObject value = new JSONObject().put("release_config_url", this.releaseConfigUrl).put(CLConstants.OTP_STATUS, strValueOf).put("time_taken", System.currentTimeMillis() - j2);
        if (message != null) {
            value.put("error", message);
        }
        if (result instanceof Result.Error.ParseError) {
            value.put("stack_trace", Log.getStackTraceString(((Result.Error.ParseError) result).getE()));
        }
        Intrinsics.checkNotNullExpressionValue(value, "value");
        trackInfo("release_config_fetch", value);
    }

    private final void updateTimeouts(ReleaseConfig releaseConfig) {
        this.releaseConfigTimeout = releaseConfig.getConfig().getReleaseConfigTimeout();
        this.packageTimeout = releaseConfig.getConfig().getBootTimeout();
    }

    private final boolean waitForStage(Stage stage, long j2) throws ExecutionException, InterruptedException {
        try {
            awaitCompletion(stage, j2);
        } catch (TimeoutException unused) {
            if (this.currentStage.ordinal() < stage.ordinal() + 1) {
                this.updateTimedOut.set(true);
                Log.d(TAG, "Timeout waiting for " + stage.name());
                return false;
            }
        }
        return true;
    }

    private final boolean writeConfig(ReleaseConfig.Config config) {
        String string = config.toJSON().toString();
        Intrinsics.checkNotNullExpressionValue(string, "config.toJSON().toString()");
        return writeManifest(Constants.CONFIG_FILE_NAME, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean writeManifest(String str, String str2) {
        boolean zUpdateFile;
        Log.d(TAG, "writing manifest " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.fileLock) {
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            zUpdateFile = this.fileProviderService.updateFile("app/" + str, bytes);
        }
        logTimeTaken(jCurrentTimeMillis, android.support.v4.media.b.C("writeManifest ", str));
        return zUpdateFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean writePackageManifest(ReleaseConfig.PackageManifest packageManifest) {
        String string = packageManifest.toJSON().toString();
        Intrinsics.checkNotNullExpressionValue(string, "packageManifest.toJSON().toString()");
        return writeManifest(Constants.PACKAGE_MANIFEST_FILE_NAME, string);
    }

    private final boolean writeRCVersion(String str) {
        return writeManifest(Constants.RC_VERSION_FILE_NAME, str);
    }

    @NotNull
    public final UpdateResult await(@NotNull TrackerCallback tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        if (!this.trackers.contains(tracker)) {
            this.trackers.add(tracker);
        }
        if (!waitForStage(Stage.FETCHING_RC, this.releaseConfigTimeout)) {
            return UpdateResult.ReleaseConfigFetchTimeout.INSTANCE;
        }
        if (waitForStage(Stage.DOWNLOADING_UPDATES, this.packageTimeout)) {
            return !waitForStage(Stage.INSTALLING, 10000L) ? UpdateResult.Error.Unknown.INSTANCE : this.currentResult;
        }
        UpdateResult updateResult = this.currentResult;
        return new UpdateResult.PackageUpdateTimeout(updateResult instanceof UpdateResult.Ok ? ((UpdateResult.Ok) updateResult).getReleaseConfig() : null);
    }

    public final void awaitOnFinish$airborne_release() throws ExecutionException, InterruptedException {
        this.onFinishWaitTask.get();
    }

    @Nullable
    public final ReleaseConfig.PackageManifest copyTempPkg() throws JSONException {
        ApplicationManager.StateKey stateKey = ApplicationManager.StateKey.SAVED_PACKAGE_UPDATE;
        JSONObject persistentState = readPersistentState(stateKey);
        if (persistentState != null) {
            Log.d(TAG, "Found saved pkg " + persistentState + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            try {
                TempWriter tw = this.fileProviderService.reOpenTempWriter(persistentState.getString("dir"));
                ReleaseConfig.Companion companion = ReleaseConfig.Companion;
                JSONObject jSONObject = persistentState.getJSONObject("package_manifest");
                Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(\"package_manifest\")");
                ReleaseConfig.PackageManifest packageManifestPackageFromJSON = companion.packageFromJSON(jSONObject);
                Intrinsics.checkNotNullExpressionValue(tw, "tw");
                if (!movePackageUpdate(tw, packageManifestPackageFromJSON, System.currentTimeMillis())) {
                    return null;
                }
                removeFromPersistentState(stateKey);
                return packageManifestPackageFromJSON;
            } catch (Exception e2) {
                removeFromPersistentState(ApplicationManager.StateKey.SAVED_RESOURCE_UPDATE);
                trackException$default(this, "saved_resources_corrupted", e2, null, 4, null);
            }
        }
        return null;
    }

    @NotNull
    public final String getUpdateUUID() {
        return this.updateUUID;
    }

    public final void run(@NotNull Function2<? super UpdateResult, ? super JSONObject, Unit> onFinish) throws ExecutionException, JSONException, InterruptedException {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        trackInit();
        Stage stage = this.currentStage;
        Stage stage2 = Stage.INITIALIZING;
        if (stage == stage2) {
            this.onFinish = onFinish;
            this.initTime = System.currentTimeMillis();
            onComplete(stage2);
            Companion.doAsync(new f(this, 1));
        }
    }

    public final void updateReleaseConfig(@Nullable ReleaseConfig releaseConfig) {
        if (releaseConfig != null) {
            this.localReleaseConfig = releaseConfig;
            this.releaseConfigTimeout = releaseConfig.getConfig().getReleaseConfigTimeout();
            this.packageTimeout = releaseConfig.getConfig().getBootTimeout();
            this.defaultHeaders.put("x-release-config-version", releaseConfig.getVersion());
            this.defaultHeaders.put("x-package-version", releaseConfig.getPkg().getVersion());
            this.defaultHeaders.put("x-config-version", releaseConfig.getConfig().getVersion());
        }
    }

    public /* synthetic */ UpdateTask(String str, FileProviderService fileProviderService, ReleaseConfig releaseConfig, Object obj, TrackerCallback trackerCallback, NetUtils netUtils, Map map, LazyDownloadCallback lazyDownloadCallback, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fileProviderService, releaseConfig, obj, trackerCallback, netUtils, (i2 & 64) != 0 ? null : map, lazyDownloadCallback, (i2 & 256) != 0 ? true : z);
    }
}
