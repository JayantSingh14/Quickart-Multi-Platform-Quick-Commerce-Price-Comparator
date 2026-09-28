package io.ktor.http.content;

import io.ktor.http.HttpStatusCode;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class VersionCheckResult {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VersionCheckResult[] f50303a;

    /* JADX INFO: Fake field, exist only in values array */
    VersionCheckResult EF7;

    static {
        HttpStatusCode httpStatusCode = HttpStatusCode.f50219c;
        f50303a = new VersionCheckResult[]{new VersionCheckResult("OK", 0), new VersionCheckResult("NOT_MODIFIED", 1), new VersionCheckResult("PRECONDITION_FAILED", 2)};
    }

    public static VersionCheckResult valueOf(String str) {
        return (VersionCheckResult) Enum.valueOf(VersionCheckResult.class, str);
    }

    public static VersionCheckResult[] values() {
        return (VersionCheckResult[]) f50303a.clone();
    }
}
