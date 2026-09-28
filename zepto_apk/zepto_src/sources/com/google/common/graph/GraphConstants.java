package com.google.common.graph;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class GraphConstants {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Presence {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Presence[] f43196a = {new Presence("EDGE_EXISTS", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        Presence EF5;

        public static Presence valueOf(String str) {
            return (Presence) Enum.valueOf(Presence.class, str);
        }

        public static Presence[] values() {
            return (Presence[]) f43196a.clone();
        }
    }
}
