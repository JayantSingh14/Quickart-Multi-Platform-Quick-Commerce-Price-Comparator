package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class a() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public final void c(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public final Object f(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
