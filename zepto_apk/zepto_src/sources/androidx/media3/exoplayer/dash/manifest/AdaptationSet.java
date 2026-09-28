package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class AdaptationSet {

    /* renamed from: a, reason: collision with root package name */
    public final long f6779a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6780b;

    /* renamed from: c, reason: collision with root package name */
    public final List f6781c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6782d;

    /* renamed from: e, reason: collision with root package name */
    public final List f6783e;

    /* renamed from: f, reason: collision with root package name */
    public final List f6784f;

    public AdaptationSet(long j2, int i2, ArrayList arrayList, List list, List list2, List list3) {
        this.f6779a = j2;
        this.f6780b = i2;
        this.f6781c = Collections.unmodifiableList(arrayList);
        this.f6782d = Collections.unmodifiableList(list);
        this.f6783e = Collections.unmodifiableList(list2);
        this.f6784f = Collections.unmodifiableList(list3);
    }
}
