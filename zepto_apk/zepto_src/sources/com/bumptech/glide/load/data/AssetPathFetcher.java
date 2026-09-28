package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f15821a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetManager f15822b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15823c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f15822b = assetManager;
        this.f15821a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void b() {
        Object obj = this.f15823c;
        if (obj == null) {
            return;
        }
        try {
            c(obj);
        } catch (IOException unused) {
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
            Object objF = f(this.f15822b, this.f15821a);
            this.f15823c = objF;
            dataCallback.f(objF);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            dataCallback.c(e2);
        }
    }

    public abstract Object f(AssetManager assetManager, String str);
}
