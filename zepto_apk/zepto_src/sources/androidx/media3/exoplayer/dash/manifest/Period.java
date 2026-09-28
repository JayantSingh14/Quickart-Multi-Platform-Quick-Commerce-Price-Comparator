package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class Period {

    /* renamed from: a, reason: collision with root package name */
    public final String f6822a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6823b;

    /* renamed from: c, reason: collision with root package name */
    public final List f6824c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6825d;

    public Period(String str, long j2, ArrayList arrayList, List list) {
        this.f6822a = str;
        this.f6823b = j2;
        this.f6824c = Collections.unmodifiableList(arrayList);
        this.f6825d = Collections.unmodifiableList(list);
    }
}
