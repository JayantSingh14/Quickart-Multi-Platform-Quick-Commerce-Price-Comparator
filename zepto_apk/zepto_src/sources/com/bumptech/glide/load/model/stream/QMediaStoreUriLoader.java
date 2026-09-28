package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi
/* loaded from: classes3.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16219a;

    /* renamed from: b, reason: collision with root package name */
    public final ModelLoader f16220b;

    /* renamed from: c, reason: collision with root package name */
    public final ModelLoader f16221c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f16222d;

    public static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f16223a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f16224b;

        public Factory(Context context, Class cls) {
            this.f16223a = context;
            this.f16224b = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            Class cls = this.f16224b;
            return new QMediaStoreUriLoader(this.f16223a, multiModelLoaderFactory.b(File.class, cls), multiModelLoaderFactory.b(Uri.class, cls), cls);
        }
    }

    @RequiresApi
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {

        /* renamed from: k, reason: collision with root package name */
        public static final String[] f16225k = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final Context f16226a;

        /* renamed from: b, reason: collision with root package name */
        public final ModelLoader f16227b;

        /* renamed from: c, reason: collision with root package name */
        public final ModelLoader f16228c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f16229d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16230e;

        /* renamed from: f, reason: collision with root package name */
        public final int f16231f;

        /* renamed from: g, reason: collision with root package name */
        public final Options f16232g;

        /* renamed from: h, reason: collision with root package name */
        public final Class f16233h;

        /* renamed from: i, reason: collision with root package name */
        public volatile boolean f16234i;

        /* renamed from: j, reason: collision with root package name */
        public volatile DataFetcher f16235j;

        public QMediaStoreUriFetcher(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Uri uri, int i2, int i3, Options options, Class cls) {
            this.f16226a = context.getApplicationContext();
            this.f16227b = modelLoader;
            this.f16228c = modelLoader2;
            this.f16229d = uri;
            this.f16230e = i2;
            this.f16231f = i3;
            this.f16232g = options;
            this.f16233h = cls;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return this.f16233h;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() {
            DataFetcher dataFetcher = this.f16235j;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        public final DataFetcher c() throws Throwable {
            ModelLoader.LoadData loadDataB;
            boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
            Cursor cursor = null;
            Options options = this.f16232g;
            int i2 = this.f16231f;
            int i3 = this.f16230e;
            Context context = this.f16226a;
            if (zIsExternalStorageLegacy) {
                Uri uri = this.f16229d;
                try {
                    Cursor cursorQuery = context.getContentResolver().query(uri, f16225k, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                                if (TextUtils.isEmpty(string)) {
                                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                                }
                                File file = new File(string);
                                cursorQuery.close();
                                loadDataB = this.f16227b.b(file, i3, i2, options);
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                int iCheckSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
                Uri requireOriginal = this.f16229d;
                if (iCheckSelfPermission == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                loadDataB = this.f16228c.b(requireOriginal, i3, i2, options);
            }
            if (loadDataB != null) {
                return loadDataB.f16169c;
            }
            return null;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void cancel() {
            this.f16234i = true;
            DataFetcher dataFetcher = this.f16235j;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource d() {
            return DataSource.f15788a;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void e(Priority priority, DataFetcher.DataCallback dataCallback) throws Throwable {
            try {
                DataFetcher dataFetcherC = c();
                if (dataFetcherC == null) {
                    dataCallback.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f16229d));
                } else {
                    this.f16235j = dataFetcherC;
                    if (this.f16234i) {
                        cancel();
                    } else {
                        dataFetcherC.e(priority, dataCallback);
                    }
                }
            } catch (FileNotFoundException e2) {
                dataCallback.c(e2);
            }
        }
    }

    public QMediaStoreUriLoader(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Class cls) {
        this.f16219a = context.getApplicationContext();
        this.f16220b = modelLoader;
        this.f16221c = modelLoader2;
        this.f16222d = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.a((Uri) obj);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        Uri uri = (Uri) obj;
        return new ModelLoader.LoadData(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f16219a, this.f16220b, this.f16221c, uri, i2, i3, options, this.f16222d));
    }
}
