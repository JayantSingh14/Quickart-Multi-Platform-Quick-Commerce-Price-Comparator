package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.emsg.EventMessage;

@UnstableApi
/* loaded from: classes3.dex */
public final class EventStream {

    /* renamed from: a, reason: collision with root package name */
    public final EventMessage[] f6818a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f6819b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6820c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6821d;

    public EventStream(String str, String str2, long[] jArr, EventMessage[] eventMessageArr) {
        this.f6820c = str;
        this.f6821d = str2;
        this.f6819b = jArr;
        this.f6818a = eventMessageArr;
    }

    public final String a() {
        return this.f6820c + "/" + this.f6821d;
    }
}
