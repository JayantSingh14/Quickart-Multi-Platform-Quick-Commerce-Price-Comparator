package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes3.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16159a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f16160a;

        public Factory(Context context) {
            this.f16160a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f16160a);
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f16161c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final Context f16162a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f16163b;

        public FilePathFetcher(Context context, Uri uri) {
            this.f16162a = context;
            this.f16163b = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return File.class;
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
            Cursor cursorQuery = this.f16162a.getContentResolver().query(this.f16163b, f16161c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                dataCallback.f(new File(string));
                return;
            }
            dataCallback.c(new FileNotFoundException("Failed to find file path for: " + this.f16163b));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f16159a = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        return MediaStoreUtil.a((Uri) obj);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        Uri uri = (Uri) obj;
        return new ModelLoader.LoadData(new ObjectKey(uri), new FilePathFetcher(this.f16159a, uri));
    }
}
