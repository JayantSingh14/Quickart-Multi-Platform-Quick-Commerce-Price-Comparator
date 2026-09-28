package okio.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata
/* loaded from: classes3.dex */
public final class ZipEntry {

    /* renamed from: a, reason: collision with root package name */
    public final Path f57047a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f57048b;

    /* renamed from: c, reason: collision with root package name */
    public final String f57049c;

    /* renamed from: d, reason: collision with root package name */
    public final long f57050d;

    /* renamed from: e, reason: collision with root package name */
    public final long f57051e;

    /* renamed from: f, reason: collision with root package name */
    public final long f57052f;

    /* renamed from: g, reason: collision with root package name */
    public final int f57053g;

    /* renamed from: h, reason: collision with root package name */
    public final long f57054h;

    /* renamed from: i, reason: collision with root package name */
    public final int f57055i;

    /* renamed from: j, reason: collision with root package name */
    public final int f57056j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f57057k;

    /* renamed from: l, reason: collision with root package name */
    public final Long f57058l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f57059m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final ArrayList q;

    public ZipEntry(Path canonicalPath, boolean z, String comment, long j2, long j3, long j4, int i2, long j5, int i3, int i4, Long l2, Long l3, Long l4, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.f57047a = canonicalPath;
        this.f57048b = z;
        this.f57049c = comment;
        this.f57050d = j2;
        this.f57051e = j3;
        this.f57052f = j4;
        this.f57053g = i2;
        this.f57054h = j5;
        this.f57055i = i3;
        this.f57056j = i4;
        this.f57057k = l2;
        this.f57058l = l3;
        this.f57059m = l4;
        this.n = num;
        this.o = num2;
        this.p = num3;
        this.q = new ArrayList();
    }

    public /* synthetic */ ZipEntry(Path path, boolean z, String str, long j2, long j3, long j4, int i2, long j5, int i3, int i4, Long l2, Long l3, Long l4, int i5) {
        this(path, z, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? -1L : j2, (i5 & 16) != 0 ? -1L : j3, (i5 & 32) != 0 ? -1L : j4, (i5 & 64) != 0 ? -1 : i2, (i5 & 128) != 0 ? -1L : j5, (i5 & 256) != 0 ? -1 : i3, (i5 & 512) != 0 ? -1 : i4, (i5 & 1024) != 0 ? null : l2, (i5 & 2048) != 0 ? null : l3, (i5 & 4096) != 0 ? null : l4, null, null, null);
    }
}
