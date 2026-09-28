package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: j, reason: collision with root package name */
    public static volatile Glide f15646j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile boolean f15647k;

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f15648a;

    /* renamed from: b, reason: collision with root package name */
    public final LruResourceCache f15649b;

    /* renamed from: c, reason: collision with root package name */
    public final GlideContext f15650c;

    /* renamed from: d, reason: collision with root package name */
    public final Registry f15651d;

    /* renamed from: e, reason: collision with root package name */
    public final LruArrayPool f15652e;

    /* renamed from: f, reason: collision with root package name */
    public final RequestManagerRetriever f15653f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultConnectivityMonitorFactory f15654g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f15655h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final RequestOptionsFactory f15656i;

    public interface RequestOptionsFactory {
    }

    public Glide(Context context, Engine engine, LruResourceCache lruResourceCache, BitmapPool bitmapPool, LruArrayPool lruArrayPool, RequestManagerRetriever requestManagerRetriever, DefaultConnectivityMonitorFactory defaultConnectivityMonitorFactory, int i2, RequestOptionsFactory requestOptionsFactory, ArrayMap arrayMap, List list) {
        this.f15648a = bitmapPool;
        this.f15652e = lruArrayPool;
        this.f15649b = lruResourceCache;
        this.f15653f = requestManagerRetriever;
        this.f15654g = defaultConnectivityMonitorFactory;
        this.f15656i = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f15651d = registry;
        DefaultImageHeaderParser defaultImageHeaderParser = new DefaultImageHeaderParser();
        ImageHeaderParserRegistry imageHeaderParserRegistry = registry.f15694g;
        synchronized (imageHeaderParserRegistry) {
            imageHeaderParserRegistry.f16427a.add(defaultImageHeaderParser);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            ExifInterfaceImageHeaderParser exifInterfaceImageHeaderParser = new ExifInterfaceImageHeaderParser();
            ImageHeaderParserRegistry imageHeaderParserRegistry2 = registry.f15694g;
            synchronized (imageHeaderParserRegistry2) {
                imageHeaderParserRegistry2.f16427a.add(exifInterfaceImageHeaderParser);
            }
        }
        ArrayList arrayListB = registry.b();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, arrayListB, bitmapPool, lruArrayPool);
        VideoDecoder videoDecoderF = VideoDecoder.f(bitmapPool);
        Downsampler downsampler = new Downsampler(registry.b(), resources.getDisplayMetrics(), bitmapPool, lruArrayPool);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, lruArrayPool);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(lruArrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        ByteBufferEncoder byteBufferEncoder = new ByteBufferEncoder();
        EncoderRegistry encoderRegistry = registry.f15689b;
        encoderRegistry.a(ByteBuffer.class, byteBufferEncoder);
        encoderRegistry.a(InputStream.class, new StreamEncoder(lruArrayPool));
        ResourceDecoderRegistry resourceDecoderRegistry = registry.f15690c;
        resourceDecoderRegistry.a(byteBufferBitmapDecoder, ByteBuffer.class, Bitmap.class, "Bitmap");
        registry.a(streamBitmapDecoder, InputStream.class, Bitmap.class, "Bitmap");
        registry.a(new ParcelFileDescriptorBitmapDecoder(downsampler), ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        resourceDecoderRegistry.a(videoDecoderF, ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        resourceDecoderRegistry.a(VideoDecoder.c(bitmapPool), AssetFileDescriptor.class, Bitmap.class, "Bitmap");
        UnitModelLoader.Factory factory = UnitModelLoader.Factory.f16201a;
        ModelLoaderRegistry modelLoaderRegistry = registry.f15688a;
        modelLoaderRegistry.a(Bitmap.class, Bitmap.class, factory);
        resourceDecoderRegistry.a(new UnitBitmapDecoder(), Bitmap.class, Bitmap.class, "Bitmap");
        ResourceEncoderRegistry resourceEncoderRegistry = registry.f15691d;
        resourceEncoderRegistry.a(Bitmap.class, bitmapEncoder);
        resourceDecoderRegistry.a(new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder), ByteBuffer.class, BitmapDrawable.class, "BitmapDrawable");
        resourceDecoderRegistry.a(new BitmapDrawableDecoder(resources, streamBitmapDecoder), InputStream.class, BitmapDrawable.class, "BitmapDrawable");
        resourceDecoderRegistry.a(new BitmapDrawableDecoder(resources, videoDecoderF), ParcelFileDescriptor.class, BitmapDrawable.class, "BitmapDrawable");
        resourceEncoderRegistry.a(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool, bitmapEncoder));
        resourceDecoderRegistry.a(new StreamGifDecoder(arrayListB, byteBufferGifDecoder, lruArrayPool), InputStream.class, GifDrawable.class, "Gif");
        resourceDecoderRegistry.a(byteBufferGifDecoder, ByteBuffer.class, GifDrawable.class, "Gif");
        resourceEncoderRegistry.a(GifDrawable.class, new GifDrawableEncoder());
        modelLoaderRegistry.a(GifDecoder.class, GifDecoder.class, factory);
        resourceDecoderRegistry.a(new GifFrameResourceDecoder(bitmapPool), GifDecoder.class, Bitmap.class, "Bitmap");
        registry.a(resourceDrawableDecoder, Uri.class, Drawable.class, "legacy_append");
        registry.a(new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool), Uri.class, Bitmap.class, "legacy_append");
        registry.c(new ByteBufferRewinder.Factory());
        modelLoaderRegistry.a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory());
        modelLoaderRegistry.a(File.class, InputStream.class, new FileLoader.StreamFactory());
        registry.a(new FileDecoder(), File.class, File.class, "legacy_append");
        modelLoaderRegistry.a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory());
        modelLoaderRegistry.a(File.class, File.class, factory);
        registry.c(new InputStreamRewinder.Factory(lruArrayPool));
        registry.c(new ParcelFileDescriptorRewinder.Factory());
        Class cls = Integer.TYPE;
        modelLoaderRegistry.a(cls, InputStream.class, streamFactory);
        modelLoaderRegistry.a(cls, ParcelFileDescriptor.class, fileDescriptorFactory);
        modelLoaderRegistry.a(Integer.class, InputStream.class, streamFactory);
        modelLoaderRegistry.a(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory);
        modelLoaderRegistry.a(Integer.class, Uri.class, uriFactory);
        modelLoaderRegistry.a(cls, AssetFileDescriptor.class, assetFileDescriptorFactory);
        modelLoaderRegistry.a(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory);
        modelLoaderRegistry.a(cls, Uri.class, uriFactory);
        modelLoaderRegistry.a(String.class, InputStream.class, new DataUrlLoader.StreamFactory());
        modelLoaderRegistry.a(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory());
        modelLoaderRegistry.a(String.class, InputStream.class, new StringLoader.StreamFactory());
        modelLoaderRegistry.a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory());
        modelLoaderRegistry.a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory());
        modelLoaderRegistry.a(Uri.class, InputStream.class, new HttpUriLoader.Factory());
        modelLoaderRegistry.a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets()));
        modelLoaderRegistry.a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets()));
        modelLoaderRegistry.a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context));
        registry.f15688a.a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i3 >= 29) {
            registry.f15688a.a(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry.f15688a.a(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        modelLoaderRegistry.a(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver));
        modelLoaderRegistry.a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver));
        modelLoaderRegistry.a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver));
        modelLoaderRegistry.a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory());
        modelLoaderRegistry.a(URL.class, InputStream.class, new UrlLoader.StreamFactory());
        modelLoaderRegistry.a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context));
        modelLoaderRegistry.a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory());
        modelLoaderRegistry.a(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory());
        modelLoaderRegistry.a(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory());
        modelLoaderRegistry.a(Uri.class, Uri.class, factory);
        modelLoaderRegistry.a(Drawable.class, Drawable.class, factory);
        registry.a(new UnitDrawableDecoder(), Drawable.class, Drawable.class, "legacy_append");
        BitmapDrawableTranscoder bitmapDrawableTranscoder = new BitmapDrawableTranscoder(resources);
        TranscoderRegistry transcoderRegistry = registry.f15693f;
        transcoderRegistry.c(Bitmap.class, BitmapDrawable.class, bitmapDrawableTranscoder);
        transcoderRegistry.c(Bitmap.class, byte[].class, bitmapBytesTranscoder);
        transcoderRegistry.c(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder));
        registry.f15693f.c(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        VideoDecoder videoDecoderD = VideoDecoder.d(bitmapPool);
        registry.a(videoDecoderD, ByteBuffer.class, Bitmap.class, "legacy_append");
        registry.a(new BitmapDrawableDecoder(resources, videoDecoderD), ByteBuffer.class, BitmapDrawable.class, "legacy_append");
        new ImageViewTargetFactory();
        this.f15650c = new GlideContext(context, lruArrayPool, registry, requestOptionsFactory, arrayMap, list, engine, i2);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) throws PackageManager.NameNotFoundException {
        if (f15647k) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f15647k = true;
        GlideBuilder glideBuilder = new GlideBuilder();
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(ManifestParser.a(str));
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                }
            } else if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.c().isEmpty()) {
                Set setC = generatedAppGlideModule.c();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GlideModule glideModule = (GlideModule) it.next();
                    if (setC.contains(glideModule.getClass())) {
                        if (Log.isLoggable("Glide", 3)) {
                            Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + glideModule);
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Log.d("Glide", "Discovered GlideModule from manifest: " + ((GlideModule) it2.next()).getClass());
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((GlideModule) it3.next()).b();
            }
            if (glideBuilder.f15662f == null) {
                GlideExecutor.Builder builder = new GlideExecutor.Builder(false);
                if (GlideExecutor.f16114c == 0) {
                    GlideExecutor.f16114c = Math.min(4, Runtime.getRuntime().availableProcessors());
                }
                int i2 = GlideExecutor.f16114c;
                builder.f16117b = i2;
                builder.f16118c = i2;
                builder.f16120e = "source";
                glideBuilder.f15662f = builder.a();
            }
            if (glideBuilder.f15663g == null) {
                int i3 = GlideExecutor.f16114c;
                GlideExecutor.Builder builder2 = new GlideExecutor.Builder(true);
                builder2.f16117b = 1;
                builder2.f16118c = 1;
                builder2.f16120e = "disk-cache";
                glideBuilder.f15663g = builder2.a();
            }
            if (glideBuilder.f15669m == null) {
                if (GlideExecutor.f16114c == 0) {
                    GlideExecutor.f16114c = Math.min(4, Runtime.getRuntime().availableProcessors());
                }
                int i4 = GlideExecutor.f16114c < 4 ? 1 : 2;
                GlideExecutor.Builder builder3 = new GlideExecutor.Builder(true);
                builder3.f16117b = i4;
                builder3.f16118c = i4;
                builder3.f16120e = "animation";
                glideBuilder.f15669m = builder3.a();
            }
            if (glideBuilder.f15665i == null) {
                glideBuilder.f15665i = new MemorySizeCalculator(new MemorySizeCalculator.Builder(applicationContext));
            }
            if (glideBuilder.f15666j == null) {
                glideBuilder.f15666j = new DefaultConnectivityMonitorFactory();
            }
            if (glideBuilder.f15659c == null) {
                int i5 = glideBuilder.f15665i.f16100a;
                if (i5 > 0) {
                    glideBuilder.f15659c = new LruBitmapPool(i5);
                } else {
                    glideBuilder.f15659c = new BitmapPoolAdapter();
                }
            }
            if (glideBuilder.f15660d == null) {
                glideBuilder.f15660d = new LruArrayPool(glideBuilder.f15665i.f16102c);
            }
            if (glideBuilder.f15661e == null) {
                glideBuilder.f15661e = new LruResourceCache(glideBuilder.f15665i.f16101b);
            }
            if (glideBuilder.f15664h == null) {
                glideBuilder.f15664h = new InternalCacheDiskCacheFactory(applicationContext);
            }
            if (glideBuilder.f15658b == null) {
                glideBuilder.f15658b = new Engine(glideBuilder.f15661e, glideBuilder.f15664h, glideBuilder.f15663g, glideBuilder.f15662f, GlideExecutor.a(), glideBuilder.f15669m);
            }
            List list2 = glideBuilder.n;
            if (list2 == null) {
                glideBuilder.n = Collections.EMPTY_LIST;
            } else {
                glideBuilder.n = Collections.unmodifiableList(list2);
            }
            Glide glide = new Glide(applicationContext, glideBuilder.f15658b, glideBuilder.f15661e, glideBuilder.f15659c, glideBuilder.f15660d, new RequestManagerRetriever(), glideBuilder.f15666j, glideBuilder.f15667k, glideBuilder.f15668l, glideBuilder.f15657a, glideBuilder.n);
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                GlideModule glideModule2 = (GlideModule) it4.next();
                try {
                    glideModule2.a();
                } catch (AbstractMethodError e2) {
                    throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(glideModule2.getClass().getName()), e2);
                }
            }
            applicationContext.registerComponentCallbacks(glide);
            f15646j = glide;
            f15647k = false;
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e3);
        }
    }

    public static Glide b(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f15646j == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e4);
            } catch (InvocationTargetException e5) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e5);
            }
            synchronized (Glide.class) {
                try {
                    if (f15646j == null) {
                        a(context, generatedAppGlideModule);
                    }
                } finally {
                }
            }
        }
        return f15646j;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        char[] cArr = Util.f16528a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        this.f15649b.a();
        this.f15648a.d();
        this.f15652e.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        long j2;
        char[] cArr = Util.f16528a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        Iterator it = this.f15655h.iterator();
        while (it.hasNext()) {
            ((RequestManager) it.next()).getClass();
        }
        LruResourceCache lruResourceCache = this.f15649b;
        lruResourceCache.getClass();
        if (i2 >= 40) {
            lruResourceCache.a();
        } else if (i2 >= 20 || i2 == 15) {
            synchronized (lruResourceCache) {
                j2 = lruResourceCache.f16522b;
            }
            lruResourceCache.f(j2 / 2);
        }
        this.f15648a.c(i2);
        LruArrayPool lruArrayPool = this.f15652e;
        synchronized (lruArrayPool) {
            try {
                if (i2 >= 40) {
                    lruArrayPool.a();
                } else if (i2 >= 20 || i2 == 15) {
                    lruArrayPool.c(lruArrayPool.f16059e / 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
