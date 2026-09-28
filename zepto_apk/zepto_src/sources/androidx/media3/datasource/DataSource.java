package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.DataReader;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public interface DataSource extends DataReader {

    public interface Factory {
        DataSource a();
    }

    void a(TransferListener transferListener);

    default Map c() {
        return Collections.EMPTY_MAP;
    }

    void close();

    long j(DataSpec dataSpec);

    Uri k();
}
