package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class LongSerializationPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final LongSerializationPolicy f45258a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LongSerializationPolicy[] f45259b;

    static {
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.1
        };
        f45258a = longSerializationPolicy;
        f45259b = new LongSerializationPolicy[]{longSerializationPolicy, new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.2
        }};
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f45259b.clone();
    }
}
