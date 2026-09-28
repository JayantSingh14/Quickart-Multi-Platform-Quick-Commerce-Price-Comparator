package com.facebook.react.modules.fresco;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.OkHttpCompat;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import com.zeptoconsumerapp.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = FrescoModule.NAME, needsEagerInit = BuildConfig.IS_HERMES_ENABLED)
@Metadata
/* loaded from: classes.dex */
public class FrescoModule extends ReactContextBaseJavaModule implements ModuleDataCleaner.Cleanable, LifecycleEventListener, TurboModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "FrescoModule";
    private static boolean hasBeenInitialized;
    private final boolean clearOnDestroy;

    @Nullable
    private ImagePipelineConfig config;

    @Nullable
    private ImagePipeline pipeline;

    @Metadata
    public static final class Companion {
        public static ImagePipelineConfig.Builder a(ReactContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            HashSet hashSet = new HashSet();
            hashSet.add(new SystraceRequestListener());
            OkHttpClient okHttpClientA = OkHttpClientProvider.a();
            OkHttpCompat.a(okHttpClientA).c(new JavaNetCookieJar(new ForwardingCookieHandler()));
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            ImagePipelineConfig.Builder builderA = OkHttpImagePipelineConfigFactory.a(applicationContext, okHttpClientA);
            builderA.f17852f = new ReactOkHttpNetworkFetcher(okHttpClientA);
            DownsampleMode downsampleMode = DownsampleMode.f17817b;
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            builderA.f17850d = downsampleMode;
            builderA.f17853g = hashSet;
            final boolean zLoadVectorDrawablesOnImages = ReactNativeFeatureFlags.f18968a.loadVectorDrawablesOnImages();
            final ImagePipelineExperiments.Builder builder = builderA.f17856j;
            builder.getClass();
            new Function0() { // from class: com.facebook.imagepipeline.core.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ImagePipelineExperiments.Builder this$0 = builder;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.f17874g = zLoadVectorDrawablesOnImages;
                    return Unit.f53572a;
                }
            }.invoke();
            return builderA;
        }
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, false, null, 6, null);
    }

    @JvmStatic
    @NotNull
    public static final ImagePipelineConfig.Builder getDefaultConfigBuilder(@NotNull ReactContext reactContext) {
        Companion.getClass();
        return Companion.a(reactContext);
    }

    private final ImagePipeline getImagePipeline() {
        if (this.pipeline == null) {
            this.pipeline = Fresco.a();
        }
        return this.pipeline;
    }

    @JvmStatic
    public static final boolean hasBeenInitialized() {
        Companion.getClass();
        return hasBeenInitialized;
    }

    public void clearSensitiveData() {
        ImagePipeline imagePipeline = getImagePipeline();
        if (imagePipeline != null) {
            imagePipeline.a();
            Object obj = imagePipeline.f17823c.get();
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
            diskCachesStore.b().a();
            diskCachesStore.a().a();
            Iterator it = diskCachesStore.c().entrySet().iterator();
            while (it.hasNext()) {
                ((BufferedDiskCache) ((Map.Entry) it.next()).getValue()).a();
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        boolean z;
        super.initialize();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.addLifecycleEventListener(this);
        Companion.getClass();
        if (!hasBeenInitialized) {
            ImagePipelineConfig imagePipelineConfig = this.config;
            if (imagePipelineConfig == null) {
                imagePipelineConfig = new ImagePipelineConfig(Companion.a(reactApplicationContext));
            }
            DraweeConfig.Builder builder = new DraweeConfig.Builder();
            Intrinsics.checkNotNullExpressionValue(builder, "newBuilder(...)");
            Context applicationContext = reactApplicationContext.getApplicationContext();
            DraweeConfig draweeConfig = new DraweeConfig(builder);
            FrescoSystrace.a();
            if (Fresco.f17199b) {
                FLog.o(Fresco.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
            } else {
                Fresco.f17199b = true;
            }
            synchronized (NativeLoader.class) {
                z = NativeLoader.f20308a != null;
            }
            if (!z) {
                FrescoSystrace.a();
                try {
                    try {
                        try {
                            Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, applicationContext);
                        } catch (ClassNotFoundException unused) {
                            NativeLoader.a(new SystemDelegate());
                        } catch (NoSuchMethodException unused2) {
                            NativeLoader.a(new SystemDelegate());
                        }
                    } catch (IllegalAccessException unused3) {
                        NativeLoader.a(new SystemDelegate());
                    } catch (InvocationTargetException unused4) {
                        NativeLoader.a(new SystemDelegate());
                    }
                } finally {
                    FrescoSystrace.a();
                }
            }
            Context applicationContext2 = applicationContext.getApplicationContext();
            synchronized (ImagePipelineFactory.class) {
                try {
                    if (ImagePipelineFactory.p != null) {
                        FLog.o(ImagePipelineFactory.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
                    }
                    ImagePipelineFactory.p = new ImagePipelineFactory(imagePipelineConfig);
                } finally {
                }
            }
            FrescoSystrace.a();
            PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(applicationContext2, draweeConfig);
            Fresco.f17198a = pipelineDraweeControllerBuilderSupplier;
            SimpleDraweeView.f17460i = pipelineDraweeControllerBuilderSupplier;
            FrescoSystrace.a();
            FrescoSystrace.a();
            hasBeenInitialized = true;
        } else if (this.config != null) {
            FLog.q("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.config = null;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        ImagePipeline imagePipeline;
        Companion.getClass();
        if (hasBeenInitialized && this.clearOnDestroy && (imagePipeline = getImagePipeline()) != null) {
            imagePipeline.a();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline) {
        this(reactApplicationContext, imagePipeline, false, false, 12, null);
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline, boolean z) {
        this(reactApplicationContext, imagePipeline, z, false, 8, null);
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, boolean z) {
        this(reactApplicationContext, z, null, 4, null);
    }

    public /* synthetic */ FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, ImagePipelineConfig imagePipelineConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? null : imagePipelineConfig);
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, boolean z, @Nullable ImagePipelineConfig imagePipelineConfig) {
        super(reactApplicationContext);
        this.clearOnDestroy = z;
        this.config = imagePipelineConfig;
    }

    public /* synthetic */ FrescoModule(ReactApplicationContext reactApplicationContext, ImagePipeline imagePipeline, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, imagePipeline, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? false : z2);
    }

    @JvmOverloads
    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline, boolean z, boolean z2) {
        this(reactApplicationContext, z, null, 4, null);
        this.pipeline = imagePipeline;
        if (z2) {
            hasBeenInitialized = true;
        }
    }
}
