package okhttp3;

import kotlin.Metadata;
import okio.BufferedSource;

@Metadata
/* loaded from: classes.dex */
public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaType f56381b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f56382c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BufferedSource f56383d;

    public ResponseBody$Companion$asResponseBody$1(MediaType mediaType, long j2, BufferedSource bufferedSource) {
        this.f56381b = mediaType;
        this.f56382c = j2;
        this.f56383d = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public final long e() {
        return this.f56382c;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType l() {
        return this.f56381b;
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.f56383d;
    }
}
