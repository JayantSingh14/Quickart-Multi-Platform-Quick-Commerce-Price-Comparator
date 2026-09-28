package io.ktor.client.engine;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ProxyType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProxyType[] f49358a = {new ProxyType("SOCKS", 0), new ProxyType("HTTP", 1), new ProxyType("UNKNOWN", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    ProxyType EF5;

    public static ProxyType valueOf(String str) {
        return (ProxyType) Enum.valueOf(ProxyType.class, str);
    }

    public static ProxyType[] values() {
        return (ProxyType[]) f49358a.clone();
    }
}
