package androidx.privacysandbox.ads.adservices.topics;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class GetTopicsResponse {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractCollection f11277a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11278b;

    /* JADX WARN: Multi-variable type inference failed */
    public GetTopicsResponse(List topics, List encryptedTopics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        Intrinsics.checkNotNullParameter(encryptedTopics, "encryptedTopics");
        this.f11277a = (AbstractCollection) topics;
        this.f11278b = encryptedTopics;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractCollection, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        ?? r0 = this.f11277a;
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (r0.size() != getTopicsResponse.f11277a.size()) {
            return false;
        }
        ?? r1 = this.f11278b;
        int size = r1.size();
        ?? r3 = getTopicsResponse.f11278b;
        return size == r3.size() && new HashSet((Collection) r0).equals(new HashSet(getTopicsResponse.f11277a)) && new HashSet((Collection) r1).equals(new HashSet((Collection) r3));
    }

    public final int hashCode() {
        return Objects.hash(this.f11277a, this.f11278b);
    }

    public final String toString() {
        return "GetTopicsResponse: Topics=" + this.f11277a + ", EncryptedTopics=" + this.f11278b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List topics) {
        this(topics, EmptyList.f53609a);
        Intrinsics.checkNotNullParameter(topics, "topics");
    }
}
