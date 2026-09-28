package com.google.maps.android;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class Source {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Source[] f45501a = {new Source("DEFAULT", 0), new Source("OUTDOOR", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    Source EF5;

    public static Source valueOf(String str) {
        return (Source) Enum.valueOf(Source.class, str);
    }

    public static Source[] values() {
        return (Source[]) f45501a.clone();
    }
}
