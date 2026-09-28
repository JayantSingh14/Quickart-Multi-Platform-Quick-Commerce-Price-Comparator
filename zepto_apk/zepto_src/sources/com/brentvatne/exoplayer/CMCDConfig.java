package com.brentvatne.exoplayer;

import com.brentvatne.common.api.CMCDProps;
import com.google.common.collect.ImmutableListMultimap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CMCDConfig {

    /* renamed from: a, reason: collision with root package name */
    public final CMCDProps f15519a;

    public CMCDConfig(CMCDProps props) {
        Intrinsics.checkNotNullParameter(props, "props");
        this.f15519a = props;
    }

    public static void a(ImmutableListMultimap.Builder builder, String str, List list) {
        String str2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str3 = (String) pair.f53533a;
            Object obj = pair.f53534b;
            if (obj instanceof String) {
                str2 = str3 + "=\"" + obj + "\"";
            } else {
                if (!(obj instanceof Number)) {
                    throw new IllegalArgumentException("Unsupported value type: " + obj.getClass());
                }
                str2 = str3 + "=" + obj;
            }
            builder.b(str, str2);
        }
    }

    public final a b() {
        return new a(this, 0);
    }
}
