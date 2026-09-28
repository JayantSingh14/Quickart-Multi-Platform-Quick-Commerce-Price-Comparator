package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final DataDecoder f16136a;

    public interface DataDecoder<Data> {
    }

    public static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final String f16137a;

        /* renamed from: b, reason: collision with root package name */
        public final DataDecoder f16138b;

        /* renamed from: c, reason: collision with root package name */
        public Object f16139c;

        public DataUriFetcher(String str, DataDecoder dataDecoder) {
            this.f16137a = str;
            this.f16138b = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() throws IOException {
            try {
                ((InputStream) this.f16139c).close();
            } catch (IOException unused) {
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
                ByteArrayInputStream byteArrayInputStreamA = ((StreamFactory.AnonymousClass1) this.f16138b).a(this.f16137a);
                this.f16139c = byteArrayInputStreamA;
                dataCallback.f(byteArrayInputStreamA);
            } catch (IllegalArgumentException e2) {
                dataCallback.c(e2);
            }
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final DataDecoder f16140a = new AnonymousClass1();

        /* renamed from: com.bumptech.glide.load.model.DataUrlLoader$StreamFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements DataDecoder<InputStream> {
            public final ByteArrayInputStream a(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f16140a);
        }
    }

    public DataUrlLoader(DataDecoder dataDecoder) {
        this.f16136a = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new DataUriFetcher(obj.toString(), this.f16136a));
    }
}
