package androidx.privacysandbox.ads.adservices.topics;

import android.support.v4.media.b;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class Topic {

    /* renamed from: a, reason: collision with root package name */
    public final long f11279a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11280b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11281c;

    public Topic(long j2, long j3, int i2) {
        this.f11279a = j2;
        this.f11280b = j3;
        this.f11281c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.f11279a == topic.f11279a && this.f11280b == topic.f11280b && this.f11281c == topic.f11281c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11281c) + android.support.v4.media.a.d(Long.hashCode(this.f11279a) * 31, 31, this.f11280b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TaxonomyVersion=");
        sb.append(this.f11279a);
        sb.append(", ModelVersion=");
        sb.append(this.f11280b);
        sb.append(", TopicCode=");
        return b.C("Topic { ", b.o(sb, this.f11281c, " }"));
    }
}
