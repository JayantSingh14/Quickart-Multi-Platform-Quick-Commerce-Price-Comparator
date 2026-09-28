package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FileMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56941a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f56942b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f56943c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f56944d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f56945e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f56946f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f56947g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f56948h;

    public FileMetadata() {
        this(false, false, (Path) null, (Long) null, (Long) null, (Long) null, (Long) null, 255);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f56941a) {
            arrayList.add("isRegularFile");
        }
        if (this.f56942b) {
            arrayList.add("isDirectory");
        }
        Long l2 = this.f56944d;
        if (l2 != null) {
            arrayList.add("byteCount=" + l2);
        }
        Long l3 = this.f56945e;
        if (l3 != null) {
            arrayList.add("createdAt=" + l3);
        }
        Long l4 = this.f56946f;
        if (l4 != null) {
            arrayList.add("lastModifiedAt=" + l4);
        }
        Long l5 = this.f56947g;
        if (l5 != null) {
            arrayList.add("lastAccessedAt=" + l5);
        }
        Map map = this.f56948h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return CollectionsKt.E(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public FileMetadata(boolean z, boolean z2, Path path, Long l2, Long l3, Long l4, Long l5, Map extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.f56941a = z;
        this.f56942b = z2;
        this.f56943c = path;
        this.f56944d = l2;
        this.f56945e = l3;
        this.f56946f = l4;
        this.f56947g = l5;
        this.f56948h = MapsKt.l(extras);
    }

    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l2, Long l3, Long l4, Long l5, int i2) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : path, (i2 & 8) != 0 ? null : l2, (i2 & 16) != 0 ? null : l3, (i2 & 32) != 0 ? null : l4, (i2 & 64) != 0 ? null : l5, MapsKt.c());
    }
}
