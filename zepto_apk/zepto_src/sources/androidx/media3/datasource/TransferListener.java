package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public interface TransferListener {
    void c(DataSpec dataSpec, boolean z, int i2);

    void g(DataSpec dataSpec, boolean z);

    void h(DataSpec dataSpec, boolean z);

    void i(DataSpec dataSpec, boolean z);
}
