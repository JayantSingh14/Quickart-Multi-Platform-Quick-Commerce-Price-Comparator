package okhttp3.internal.http;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.RealBufferedSource;

@Metadata
/* loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: b, reason: collision with root package name */
    public final String f56587b;

    /* renamed from: c, reason: collision with root package name */
    public final long f56588c;

    /* renamed from: d, reason: collision with root package name */
    public final RealBufferedSource f56589d;

    public RealResponseBody(String str, long j2, RealBufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56587b = str;
        this.f56588c = j2;
        this.f56589d = source;
    }

    @Override // okhttp3.ResponseBody
    public final long e() {
        return this.f56588c;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType l() {
        String str = this.f56587b;
        if (str == null) {
            return null;
        }
        Pattern pattern = MediaType.f56278d;
        return MediaType.Companion.b(str);
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.f56589d;
    }
}
