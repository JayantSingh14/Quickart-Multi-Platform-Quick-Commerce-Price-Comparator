package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class JsonContentTypeMatcher implements ContentTypeMatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonContentTypeMatcher f49879a = new JsonContentTypeMatcher();

    @Override // io.ktor.http.ContentTypeMatcher
    public final boolean a(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (contentType.b(ContentType.Application.f50129a)) {
            return true;
        }
        if (!contentType.f50198b.isEmpty()) {
            contentType = new ContentType(contentType.f50127c, contentType.f50128d, EmptyList.f53609a);
        }
        String string = contentType.toString();
        return StringsKt.O(string, "application/", false) && StringsKt.r(string, "+json", false);
    }
}
