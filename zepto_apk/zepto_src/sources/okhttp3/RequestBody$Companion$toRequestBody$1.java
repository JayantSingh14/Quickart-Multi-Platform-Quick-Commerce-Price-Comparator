package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

@Metadata
/* loaded from: classes.dex */
public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaType f56344a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteString f56345b;

    public RequestBody$Companion$toRequestBody$1(MediaType mediaType, ByteString byteString) {
        this.f56344a = mediaType;
        this.f56345b = byteString;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.f56345b.d();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f56344a;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sink.D1(this.f56345b);
    }
}
