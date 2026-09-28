package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

@Metadata
/* loaded from: classes3.dex */
public final class FormBody extends RequestBody {

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f56244c;

    /* renamed from: a, reason: collision with root package name */
    public final List f56245a;

    /* renamed from: b, reason: collision with root package name */
    public final List f56246b;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f56247a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f56248b = new ArrayList();

        @JvmOverloads
        public Builder() {
        }

        public final void a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f56247a.add(HttpUrl.Companion.a(0, 0, 91, name, " \"':;<=>@[]^`{}|/\\?#&!$(),~"));
            this.f56248b.add(HttpUrl.Companion.a(0, 0, 91, value, " \"':;<=>@[]^`{}|/\\?#&!$(),~"));
        }

        public final void b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f56247a.add(HttpUrl.Companion.a(0, 0, 83, name, " \"':;<=>@[]^`{}|/\\?#&!$(),~"));
            this.f56248b.add(HttpUrl.Companion.a(0, 0, 83, value, " \"':;<=>@[]^`{}|/\\?#&!$(),~"));
        }

        public final FormBody c() {
            return new FormBody(this.f56247a, this.f56248b);
        }
    }

    @Metadata
    public static final class Companion {
    }

    static {
        Pattern pattern = MediaType.f56278d;
        f56244c = MediaType.Companion.a("application/x-www-form-urlencoded");
    }

    public FormBody(ArrayList encodedNames, ArrayList encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.f56245a = Util.y(encodedNames);
        this.f56246b = Util.y(encodedValues);
    }

    public final long a(BufferedSink bufferedSink, boolean z) {
        Buffer bufferG;
        if (z) {
            bufferG = new Buffer();
        } else {
            Intrinsics.c(bufferedSink);
            bufferG = bufferedSink.g();
        }
        List list = this.f56245a;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                bufferG.O1(38);
            }
            bufferG.X1((String) list.get(i2));
            bufferG.O1(61);
            bufferG.X1((String) this.f56246b.get(i2));
        }
        if (!z) {
            return 0L;
        }
        long j2 = bufferG.f56914b;
        bufferG.a();
        return j2;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return f56244c;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
