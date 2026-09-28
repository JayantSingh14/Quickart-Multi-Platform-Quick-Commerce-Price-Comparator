package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final ModelLoader f16192a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f16193b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f16194a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f16194a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16194a, multiModelLoaderFactory.b(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f16195a;

        public FileDescriptorFactory(Resources resources) {
            this.f16195a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16195a, multiModelLoaderFactory.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f16196a;

        public StreamFactory(Resources resources) {
            this.f16196a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16196a, multiModelLoaderFactory.b(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f16197a;

        public UriFactory(Resources resources) {
            this.f16197a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f16197a, UnitModelLoader.f16200a);
        }
    }

    public ResourceLoader(Resources resources, ModelLoader modelLoader) {
        this.f16193b = resources;
        this.f16192a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        Uri uri;
        Integer num = (Integer) obj;
        Resources resources = this.f16193b;
        try {
            uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.f16192a.b(uri, i2, i3, options);
    }
}
