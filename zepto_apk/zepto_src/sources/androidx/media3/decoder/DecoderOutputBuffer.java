package androidx.media3.decoder;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class DecoderOutputBuffer extends Buffer {

    /* renamed from: b, reason: collision with root package name */
    public long f6076b;

    /* renamed from: c, reason: collision with root package name */
    public int f6077c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6078d;

    public interface Owner<S extends DecoderOutputBuffer> {
    }

    public void h() {
        this.f6056a = 0;
        this.f6076b = 0L;
        this.f6077c = 0;
        this.f6078d = false;
    }

    public abstract void i();
}
