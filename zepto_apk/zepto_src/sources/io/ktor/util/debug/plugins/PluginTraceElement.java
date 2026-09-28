package io.ktor.util.debug.plugins;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class PluginTraceElement {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class PluginEvent {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PluginEvent[] f50558a = {new PluginEvent("STARTED", 0), new PluginEvent("FINISHED", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        PluginEvent EF5;

        public static PluginEvent valueOf(String str) {
            return (PluginEvent) Enum.valueOf(PluginEvent.class, str);
        }

        public static PluginEvent[] values() {
            return (PluginEvent[]) f50558a.clone();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginTraceElement)) {
            return false;
        }
        ((PluginTraceElement) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "PluginTraceElement(pluginName=null, handler=null, event=null)";
    }
}
