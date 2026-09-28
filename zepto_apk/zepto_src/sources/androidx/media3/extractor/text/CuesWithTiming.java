package androidx.media3.extractor.text;

import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class CuesWithTiming {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f9155a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9156b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9157c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9158d;

    public CuesWithTiming(List list, long j2, long j3) {
        this.f9155a = ImmutableList.o(list);
        this.f9156b = j2;
        this.f9157c = j3;
        long j4 = -9223372036854775807L;
        if (j2 != -9223372036854775807L && j3 != -9223372036854775807L) {
            j4 = j2 + j3;
        }
        this.f9158d = j4;
    }
}
