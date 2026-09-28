package androidx.media3.datasource;

import android.util.Base64;
import androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5946a;

    public /* synthetic */ a(int i2) {
        this.f5946a = i2;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f5946a) {
            case 0:
                Supplier supplier = DataSourceBitmapLoader.f5841c;
                return MoreExecutors.b(Executors.newSingleThreadExecutor());
            default:
                byte[] bArr = new byte[12];
                DefaultPlaybackSessionManager.f6397i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
        }
    }
}
