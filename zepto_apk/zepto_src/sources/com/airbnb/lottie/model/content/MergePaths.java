package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* loaded from: classes3.dex */
public class MergePaths implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final MergePathsMode f14546a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14547b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MergePathsMode {

        /* renamed from: a, reason: collision with root package name */
        public static final MergePathsMode f14548a;

        /* renamed from: b, reason: collision with root package name */
        public static final MergePathsMode f14549b;

        /* renamed from: c, reason: collision with root package name */
        public static final MergePathsMode f14550c;

        /* renamed from: d, reason: collision with root package name */
        public static final MergePathsMode f14551d;

        /* renamed from: e, reason: collision with root package name */
        public static final MergePathsMode f14552e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ MergePathsMode[] f14553f;

        static {
            MergePathsMode mergePathsMode = new MergePathsMode("MERGE", 0);
            f14548a = mergePathsMode;
            MergePathsMode mergePathsMode2 = new MergePathsMode("ADD", 1);
            f14549b = mergePathsMode2;
            MergePathsMode mergePathsMode3 = new MergePathsMode("SUBTRACT", 2);
            f14550c = mergePathsMode3;
            MergePathsMode mergePathsMode4 = new MergePathsMode("INTERSECT", 3);
            f14551d = mergePathsMode4;
            MergePathsMode mergePathsMode5 = new MergePathsMode("EXCLUDE_INTERSECTIONS", 4);
            f14552e = mergePathsMode5;
            f14553f = new MergePathsMode[]{mergePathsMode, mergePathsMode2, mergePathsMode3, mergePathsMode4, mergePathsMode5};
        }

        public static MergePathsMode valueOf(String str) {
            return (MergePathsMode) Enum.valueOf(MergePathsMode.class, str);
        }

        public static MergePathsMode[] values() {
            return (MergePathsMode[]) f14553f.clone();
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f14546a = mergePathsMode;
        this.f14547b = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        if (lottieDrawable.E()) {
            return new MergePathsContent(this);
        }
        Logger.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f14546a + '}';
    }
}
