package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    public final Converter f16132a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory$1, reason: invalid class name */
        class AnonymousClass1 implements Converter<ByteBuffer> {
            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public final Class a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public final Object b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new AnonymousClass1());
        }
    }

    public interface Converter<Data> {
        Class a();

        Object b(byte[] bArr);
    }

    public static class Fetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f16133a;

        /* renamed from: b, reason: collision with root package name */
        public final Converter f16134b;

        public Fetcher(byte[] bArr, Converter converter) {
            this.f16133a = bArr;
            this.f16134b = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return this.f16134b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() {
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
            dataCallback.f(this.f16134b.b(this.f16133a));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory$1, reason: invalid class name */
        class AnonymousClass1 implements Converter<InputStream> {
            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public final Class a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public final Object b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new AnonymousClass1());
        }
    }

    public ByteArrayLoader(Converter converter) {
        this.f16132a = converter;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        byte[] bArr = (byte[]) obj;
        return new ModelLoader.LoadData(new ObjectKey(bArr), new Fetcher(bArr, this.f16132a));
    }
}
