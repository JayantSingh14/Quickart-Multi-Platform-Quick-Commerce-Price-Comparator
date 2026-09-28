package com.facebook.react.modules.image;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.SparseArray;
import androidx.media3.exoplayer.analytics.l;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.fresco.ImageCacheControl;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.views.image.ReactCallerContextFactory;
import com.facebook.react.views.imagehelper.ImageSource;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.hyper.constants.Labels;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "ImageLoader")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";

    @NotNull
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";

    @NotNull
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";

    @NotNull
    public static final String NAME = "ImageLoader";

    @Nullable
    private ImagePipeline _imagePipeline;

    @Nullable
    private final Object callerContext;

    @Nullable
    private ReactCallerContextFactory callerContextFactory;

    @NotNull
    private final Object enqueuedRequestMonitor;

    @NotNull
    private final SparseArray<DataSource<Void>> enqueuedRequests;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = this;
    }

    private final Object getCallerContext() {
        Object objA;
        ReactCallerContextFactory reactCallerContextFactory = this.callerContextFactory;
        return (reactCallerContextFactory == null || (objA = reactCallerContextFactory.a()) == null) ? this.callerContext : objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImagePipeline getImagePipeline() {
        ImagePipeline imagePipeline = this._imagePipeline;
        if (imagePipeline != null) {
            return imagePipeline;
        }
        ImagePipeline imagePipelineA = Fresco.a();
        Intrinsics.checkNotNullExpressionValue(imagePipelineA, "getImagePipeline(...)");
        return imagePipelineA;
    }

    private final void registerRequest(int i2, DataSource<Void> dataSource) {
        synchronized (this.enqueuedRequestMonitor) {
            this.enqueuedRequests.put(i2, dataSource);
            Unit unit = Unit.f53572a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataSource<Void> removeRequest(int i2) {
        DataSource<Void> dataSource;
        synchronized (this.enqueuedRequestMonitor) {
            dataSource = this.enqueuedRequests.get(i2);
            this.enqueuedRequests.remove(i2);
        }
        return dataSource;
    }

    private final void setImagePipeline(ImagePipeline imagePipeline) {
        this._imagePipeline = imagePipeline;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void abortRequest(double d2) {
        DataSource<Void> dataSourceRemoveRequest = removeRequest((int) d2);
        if (dataSourceRemoveRequest != null) {
            dataSourceRemoveRequest.close();
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSize(@Nullable String str, @NotNull final Promise promise) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ImageRequest imageRequestA = ImageRequestBuilder.d(new ImageSource(reactApplicationContext, str, null, 28).b()).a();
        Intrinsics.checkNotNullExpressionValue(imageRequestA, "build(...)");
        getImagePipeline().b(imageRequestA, getCallerContext(), null, null, null).g(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.facebook.react.modules.image.ImageLoaderModule$getSize$dataSubscriber$1
            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void e(DataSource dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                promise.reject("E_GET_SIZE_FAILURE", dataSource.d());
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void f(DataSource dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.b()) {
                    CloseableReference closeableReference = (CloseableReference) dataSource.a();
                    Promise promise2 = promise;
                    try {
                        if (closeableReference == null) {
                            promise2.reject("E_GET_SIZE_FAILURE", "Failed to get the size of the image");
                            return;
                        }
                        Object objL = closeableReference.l();
                        Intrinsics.checkNotNullExpressionValue(objL, "get(...)");
                        CloseableImage closeableImage = (CloseableImage) objL;
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                        writableMapCreateMap.putInt(Snapshot.WIDTH, closeableImage.getWidth());
                        writableMapCreateMap.putInt(Snapshot.HEIGHT, closeableImage.getHeight());
                        promise2.resolve(writableMapCreateMap);
                    } catch (Exception e2) {
                        promise2.reject("E_GET_SIZE_FAILURE", e2);
                    } finally {
                        closeableReference.close();
                    }
                }
            }
        }, CallerThreadExecutor.a());
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSizeWithHeaders(@Nullable String str, @Nullable ReadableMap readableMap, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ImageRequestBuilder imageRequestBuilderD = ImageRequestBuilder.d(new ImageSource(reactApplicationContext, str, null, 28).b());
        Intrinsics.checkNotNullExpressionValue(imageRequestBuilderD, "newBuilderWithSource(...)");
        getImagePipeline().b(ReactNetworkImageRequest.Companion.a(imageRequestBuilderD, readableMap, ImageCacheControl.f19112a), getCallerContext(), null, null, null).g(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.facebook.react.modules.image.ImageLoaderModule$getSizeWithHeaders$dataSubscriber$1
            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void e(DataSource dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                promise.reject("E_GET_SIZE_FAILURE", dataSource.d());
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void f(DataSource dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.b()) {
                    CloseableReference closeableReference = (CloseableReference) dataSource.a();
                    Promise promise2 = promise;
                    try {
                        if (closeableReference == null) {
                            promise2.reject("E_GET_SIZE_FAILURE", "Failed to get the size of the image");
                            return;
                        }
                        Object objL = closeableReference.l();
                        Intrinsics.checkNotNullExpressionValue(objL, "get(...)");
                        CloseableImage closeableImage = (CloseableImage) objL;
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                        writableMapCreateMap.putInt(Snapshot.WIDTH, closeableImage.getWidth());
                        writableMapCreateMap.putInt(Snapshot.HEIGHT, closeableImage.getHeight());
                        promise2.resolve(writableMapCreateMap);
                    } catch (Exception e2) {
                        promise2.reject("E_GET_SIZE_FAILURE", e2);
                    } finally {
                        closeableReference.close();
                    }
                }
            }
        }, CallerThreadExecutor.a());
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        synchronized (this.enqueuedRequestMonitor) {
            try {
                int size = this.enqueuedRequests.size();
                for (int i2 = 0; i2 < size; i2++) {
                    DataSource<Void> dataSourceValueAt = this.enqueuedRequests.valueAt(i2);
                    Intrinsics.checkNotNullExpressionValue(dataSourceValueAt, "valueAt(...)");
                    dataSourceValueAt.close();
                }
                this.enqueuedRequests.clear();
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void prefetchImage(@Nullable String str, double d2, @NotNull final Promise promise) throws NumberFormatException {
        AbstractDataSource abstractDataSourceB;
        Intrinsics.checkNotNullParameter(promise, "promise");
        final int i2 = (int) d2;
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
            return;
        }
        ImageRequest imageRequestA = ImageRequestBuilder.d(Uri.parse(str)).a();
        Intrinsics.checkNotNullExpressionValue(imageRequestA, "build(...)");
        ImagePipeline imagePipeline = getImagePipeline();
        Object callerContext = getCallerContext();
        imagePipeline.getClass();
        Priority priority = Priority.f17783c;
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (((Boolean) imagePipeline.f17822b.get()).booleanValue()) {
            try {
                abstractDataSourceB = imagePipeline.g(imagePipeline.f17821a.d(imageRequestA), imageRequestA, callerContext);
            } catch (Exception e2) {
                abstractDataSourceB = DataSources.b(e2);
            }
        } else {
            abstractDataSourceB = DataSources.b(ImagePipeline.n);
            Intrinsics.checkNotNullExpressionValue(abstractDataSourceB, "immediateFailedDataSource(...)");
        }
        BaseDataSubscriber<Void> baseDataSubscriber = new BaseDataSubscriber<Void>() { // from class: com.facebook.react.modules.image.ImageLoaderModule$prefetchImage$prefetchSubscriber$1
            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void e(DataSource dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                try {
                    this.f19120a.removeRequest(i2);
                    promise.reject("E_PREFETCH_FAILURE", dataSource.d());
                } finally {
                    dataSource.close();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void f(DataSource dataSource) {
                Promise promise2 = promise;
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.b()) {
                    try {
                        this.f19120a.removeRequest(i2);
                        promise2.resolve(Boolean.TRUE);
                    } catch (Exception e3) {
                        promise2.reject("E_PREFETCH_FAILURE", e3);
                    } finally {
                        dataSource.close();
                    }
                }
            }
        };
        registerRequest(i2, abstractDataSourceB);
        abstractDataSourceB.g(baseDataSubscriber, CallerThreadExecutor.a());
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void queryCache(@NotNull final ReadableArray uris, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.facebook.react.modules.image.ImageLoaderModule.queryCache.1
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public final void doInBackgroundGuarded(Void[] voidArr) {
                Void[] params = voidArr;
                Intrinsics.checkNotNullParameter(params, "params");
                WritableMap writableMapCreateMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                ImagePipeline imagePipeline = ImageLoaderModule.this.getImagePipeline();
                ReadableArray readableArray = uris;
                int size = readableArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String string = readableArray.getString(i2);
                    if (string != null && string.length() != 0) {
                        Uri uri = Uri.parse(string);
                        imagePipeline.getClass();
                        if (uri == null ? false : imagePipeline.f17826f.f17750a.d(new l(uri, 6))) {
                            writableMapCreateMap.putString(string, Labels.Device.MEMORY);
                        } else if (imagePipeline.d(uri, ImageRequest.CacheChoice.f18360a) || imagePipeline.d(uri, ImageRequest.CacheChoice.f18361b) || imagePipeline.d(uri, ImageRequest.CacheChoice.f18362c)) {
                            writableMapCreateMap.putString(string, "disk");
                        }
                    }
                }
                promise.resolve(writableMapCreateMap);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(@NotNull ReactApplicationContext reactContext, @Nullable Object obj) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(@NotNull ReactApplicationContext reactContext, @NotNull ImagePipeline imagePipeline, @NotNull ReactCallerContextFactory callerContextFactory) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(callerContextFactory, "callerContextFactory");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContextFactory = callerContextFactory;
        setImagePipeline(imagePipeline);
        this.callerContext = null;
    }
}
