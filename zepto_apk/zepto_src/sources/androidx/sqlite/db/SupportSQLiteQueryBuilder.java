package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SupportSQLiteQueryBuilder {

    @Metadata
    public static final class Companion {
    }

    static {
        Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }
}
