package com.google.common.html;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escapers;
import java.util.HashMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class HtmlEscapers {
    static {
        Escapers.Builder builder = new Escapers.Builder();
        HashMap map = builder.f43174a;
        map.put('\"', "&quot;");
        map.put('\'', "&#39;");
        map.put('&', "&amp;");
        map.put('<', "&lt;");
        map.put('>', "&gt;");
        builder.a();
    }
}
