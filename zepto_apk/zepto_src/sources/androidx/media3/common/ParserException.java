package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public class ParserException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5411a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5412b;

    public ParserException(String str, Exception exc, boolean z, int i2) {
        super(str, exc);
        this.f5411a = z;
        this.f5412b = i2;
    }

    public static ParserException a(RuntimeException runtimeException, String str) {
        return new ParserException(str, runtimeException, true, 1);
    }

    public static ParserException b(String str, Exception exc) {
        return new ParserException(str, exc, true, 4);
    }

    public static ParserException c(String str) {
        return new ParserException(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        sb.append("{contentIsMalformed=");
        sb.append(this.f5411a);
        sb.append(", dataType=");
        return android.support.v4.media.b.o(sb, this.f5412b, "}");
    }
}
