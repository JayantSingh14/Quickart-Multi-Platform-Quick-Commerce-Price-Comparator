package io.ktor.http.auth;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class HeaderValueEncoding {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeaderValueEncoding[] f50280a = {new HeaderValueEncoding("QUOTED_WHEN_REQUIRED", 0), new HeaderValueEncoding("QUOTED_ALWAYS", 1), new HeaderValueEncoding("URI_ENCODE", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    HeaderValueEncoding EF5;

    public static HeaderValueEncoding valueOf(String str) {
        return (HeaderValueEncoding) Enum.valueOf(HeaderValueEncoding.class, str);
    }

    public static HeaderValueEncoding[] values() {
        return (HeaderValueEncoding[]) f50280a.clone();
    }
}
