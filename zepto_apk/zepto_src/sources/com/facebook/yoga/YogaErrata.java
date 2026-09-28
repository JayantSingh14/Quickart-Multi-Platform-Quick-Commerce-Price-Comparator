package com.facebook.yoga;

import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class YogaErrata {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YogaErrata[] f20362a = {new YogaErrata("NONE", 0), new YogaErrata("STRETCH_FLEX_BASIS", 1), new YogaErrata("ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING", 2), new YogaErrata("ABSOLUTE_PERCENT_AGAINST_INNER_SIZE", 3), new YogaErrata(Rule.ALL, 4), new YogaErrata("CLASSIC", 5)};

    /* JADX INFO: Fake field, exist only in values array */
    YogaErrata EF5;

    public static YogaErrata valueOf(String str) {
        return (YogaErrata) Enum.valueOf(YogaErrata.class, str);
    }

    public static YogaErrata[] values() {
        return (YogaErrata[]) f20362a.clone();
    }
}
