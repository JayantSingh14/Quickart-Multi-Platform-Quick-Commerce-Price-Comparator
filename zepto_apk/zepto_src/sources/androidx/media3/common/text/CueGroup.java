package androidx.media3.common.text;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes3.dex */
public final class CueGroup {

    /* renamed from: c, reason: collision with root package name */
    public static final CueGroup f5638c = new CueGroup(0, ImmutableList.r());

    /* renamed from: d, reason: collision with root package name */
    public static final String f5639d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5640e;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f5641a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5642b;

    static {
        int i2 = Util.f5744a;
        f5639d = Integer.toString(0, 36);
        f5640e = Integer.toString(1, 36);
    }

    public CueGroup(long j2, List list) {
        this.f5641a = ImmutableList.o(list);
        this.f5642b = j2;
    }
}
