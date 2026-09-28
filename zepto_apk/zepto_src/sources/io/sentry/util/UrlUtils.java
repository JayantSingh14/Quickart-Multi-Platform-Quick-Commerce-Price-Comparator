package io.sentry.util;

import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class UrlUtils {

    public static final class UrlDetails {
    }

    static {
        Pattern.compile("(.+://)(.*@)(.*)");
    }
}
