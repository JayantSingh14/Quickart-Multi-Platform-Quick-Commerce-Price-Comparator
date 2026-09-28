package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f15842a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f15843b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15844c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f15843b = contentResolver;
        this.f15842a = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void b() {
        Object obj = this.f15844c;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(Object obj);

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
            Object objF = f(this.f15843b, this.f15842a);
            this.f15844c = objF;
            dataCallback.f(objF);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            dataCallback.c(e2);
        }
    }

    public abstract Object f(ContentResolver contentResolver, Uri uri);
}
