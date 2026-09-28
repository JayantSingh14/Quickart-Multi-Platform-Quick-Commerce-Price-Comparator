package okhttp3;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.TTL;

@Metadata
/* loaded from: classes.dex */
public final class CacheControl {
    public static final /* synthetic */ int n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56171a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f56172b;

    /* renamed from: c, reason: collision with root package name */
    public final int f56173c;

    /* renamed from: d, reason: collision with root package name */
    public final int f56174d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f56175e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f56176f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f56177g;

    /* renamed from: h, reason: collision with root package name */
    public final int f56178h;

    /* renamed from: i, reason: collision with root package name */
    public final int f56179i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f56180j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f56181k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f56182l;

    /* renamed from: m, reason: collision with root package name */
    public String f56183m;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f56184a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56185b;

        /* renamed from: c, reason: collision with root package name */
        public int f56186c = -1;

        /* renamed from: d, reason: collision with root package name */
        public boolean f56187d;

        public final CacheControl a() {
            return new CacheControl(this.f56184a, this.f56185b, -1, -1, false, false, false, this.f56186c, -1, this.f56187d, false, false, null);
        }

        public final void b() {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long seconds = timeUnit.toSeconds(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            if (seconds <= TTL.MAX_VALUE) {
                i2 = (int) seconds;
            }
            this.f56186c = i2;
        }
    }

    @Metadata
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static okhttp3.CacheControl a(okhttp3.Headers r26) {
            /*
                Method dump skipped, instructions count: 489
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.a(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    static {
        Builder builder = new Builder();
        builder.f56184a = true;
        builder.a();
        Builder builder2 = new Builder();
        builder2.f56187d = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder2.b();
        builder2.a();
    }

    public CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f56171a = z;
        this.f56172b = z2;
        this.f56173c = i2;
        this.f56174d = i3;
        this.f56175e = z3;
        this.f56176f = z4;
        this.f56177g = z5;
        this.f56178h = i4;
        this.f56179i = i5;
        this.f56180j = z6;
        this.f56181k = z7;
        this.f56182l = z8;
        this.f56183m = str;
    }

    public final String toString() {
        String str = this.f56183m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f56171a) {
            sb.append("no-cache, ");
        }
        if (this.f56172b) {
            sb.append("no-store, ");
        }
        int i2 = this.f56173c;
        if (i2 != -1) {
            sb.append("max-age=");
            sb.append(i2);
            sb.append(", ");
        }
        int i3 = this.f56174d;
        if (i3 != -1) {
            sb.append("s-maxage=");
            sb.append(i3);
            sb.append(", ");
        }
        if (this.f56175e) {
            sb.append("private, ");
        }
        if (this.f56176f) {
            sb.append("public, ");
        }
        if (this.f56177g) {
            sb.append("must-revalidate, ");
        }
        int i4 = this.f56178h;
        if (i4 != -1) {
            sb.append("max-stale=");
            sb.append(i4);
            sb.append(", ");
        }
        int i5 = this.f56179i;
        if (i5 != -1) {
            sb.append("min-fresh=");
            sb.append(i5);
            sb.append(", ");
        }
        if (this.f56180j) {
            sb.append("only-if-cached, ");
        }
        if (this.f56181k) {
            sb.append("no-transform, ");
        }
        if (this.f56182l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.f56183m = string;
        return string;
    }
}
