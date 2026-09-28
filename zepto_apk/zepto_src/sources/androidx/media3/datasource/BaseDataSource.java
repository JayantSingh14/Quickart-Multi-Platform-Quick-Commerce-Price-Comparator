package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5822a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5823b = new ArrayList(1);

    /* renamed from: c, reason: collision with root package name */
    public int f5824c;

    /* renamed from: d, reason: collision with root package name */
    public DataSpec f5825d;

    public BaseDataSource(boolean z) {
        this.f5822a = z;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        ArrayList arrayList = this.f5823b;
        if (arrayList.contains(transferListener)) {
            return;
        }
        arrayList.add(transferListener);
        this.f5824c++;
    }

    public final void l(int i2) {
        DataSpec dataSpec = this.f5825d;
        int i3 = Util.f5744a;
        for (int i4 = 0; i4 < this.f5824c; i4++) {
            ((TransferListener) this.f5823b.get(i4)).c(dataSpec, this.f5822a, i2);
        }
    }

    public final void m() {
        DataSpec dataSpec = this.f5825d;
        int i2 = Util.f5744a;
        for (int i3 = 0; i3 < this.f5824c; i3++) {
            ((TransferListener) this.f5823b.get(i3)).h(dataSpec, this.f5822a);
        }
        this.f5825d = null;
    }

    public final void n(DataSpec dataSpec) {
        for (int i2 = 0; i2 < this.f5824c; i2++) {
            ((TransferListener) this.f5823b.get(i2)).g(dataSpec, this.f5822a);
        }
    }

    public final void o(DataSpec dataSpec) {
        this.f5825d = dataSpec;
        for (int i2 = 0; i2 < this.f5824c; i2++) {
            ((TransferListener) this.f5823b.get(i2)).i(dataSpec, this.f5822a);
        }
    }
}
