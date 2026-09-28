package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.v4.media.b;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public final String toString() {
        StringBuilder sbW = b.w("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sbW.append('{');
            sbW.append(entry.getKey());
            sbW.append(':');
            sbW.append(entry.getValue());
            sbW.append("}, ");
        }
        if (!isEmpty()) {
            sbW.replace(sbW.length() - 2, sbW.length(), "");
        }
        sbW.append(" )");
        return sbW.toString();
    }
}
