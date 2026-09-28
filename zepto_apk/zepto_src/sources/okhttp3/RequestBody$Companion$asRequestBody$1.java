package okhttp3;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaType f56342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f56343b;

    public RequestBody$Companion$asRequestBody$1(MediaType mediaType, File file) {
        this.f56342a = mediaType;
        this.f56343b = file;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.f56343b.length();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f56342a;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Source sourceL = Okio.l(this.f56343b);
        try {
            sink.g0(sourceL);
            sourceL.close();
        } finally {
        }
    }
}
