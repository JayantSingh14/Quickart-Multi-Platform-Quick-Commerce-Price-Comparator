package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final FileOpener f16141a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        public final FileOpener f16142a;

        public Factory(FileOpener fileOpener) {
            this.f16142a = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f16142a);
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements FileOpener<ParcelFileDescriptor> {
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final Class a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final Object b(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final void c(Object obj) throws IOException {
                ((ParcelFileDescriptor) obj).close();
            }
        }

        public FileDescriptorFactory() {
            super(new AnonymousClass1());
        }
    }

    public static final class FileFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final File f16143a;

        /* renamed from: b, reason: collision with root package name */
        public final FileOpener f16144b;

        /* renamed from: c, reason: collision with root package name */
        public Object f16145c;

        public FileFetcher(File file, FileOpener fileOpener) {
            this.f16143a = file;
            this.f16144b = fileOpener;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return this.f16144b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() {
            Object obj = this.f16145c;
            if (obj != null) {
                try {
                    this.f16144b.c(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource d() {
            return DataSource.f15788a;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object objB = this.f16144b.b(this.f16143a);
                this.f16145c = objB;
                dataCallback.f(objB);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                dataCallback.c(e2);
            }
        }
    }

    public interface FileOpener<Data> {
        Class a();

        Object b(File file);

        void c(Object obj);
    }

    public static class StreamFactory extends Factory<InputStream> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$StreamFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements FileOpener<InputStream> {
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final Class a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final Object b(File file) {
                return new FileInputStream(file);
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public final void c(Object obj) throws IOException {
                ((InputStream) obj).close();
            }
        }

        public StreamFactory() {
            super(new AnonymousClass1());
        }
    }

    public FileLoader(FileOpener fileOpener) {
        this.f16141a = fileOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        File file = (File) obj;
        return new ModelLoader.LoadData(new ObjectKey(file), new FileFetcher(file, this.f16141a));
    }
}
