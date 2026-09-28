package com.zeptoconsumerapp.gamification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class AnimationType {

    /* renamed from: b, reason: collision with root package name */
    public static final AnimationType f47596b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AnimationType[] f47597c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47598d;

    /* renamed from: a, reason: collision with root package name */
    public final String f47599a;

    static {
        AnimationType animationType = new AnimationType("FADE_OUT_REVEAL", 0, "FADE_OUT_REVEAL");
        f47596b = animationType;
        AnimationType[] animationTypeArr = {animationType, new AnimationType("OPACITY_REVEAL", 1, "OPACITY_REVEAL")};
        f47597c = animationTypeArr;
        f47598d = EnumEntriesKt.a(animationTypeArr);
    }

    public AnimationType(String str, int i2, String str2) {
        this.f47599a = str2;
    }

    public static AnimationType valueOf(String str) {
        return (AnimationType) Enum.valueOf(AnimationType.class, str);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) f47597c.clone();
    }

    public final String a() {
        return this.f47599a;
    }
}
