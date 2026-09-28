package ch.qos.logback.core.rolling;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import ch.qos.logback.core.util.DefaultInvocationGate;

@NoAutoStart
/* loaded from: classes3.dex */
public class SizeAndTimeBasedFNATP<E> extends TimeBasedFileNamingAndTriggeringPolicyBase<E> {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Usage {

        /* renamed from: a, reason: collision with root package name */
        public static final Usage f13717a;

        /* renamed from: b, reason: collision with root package name */
        public static final Usage f13718b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Usage[] f13719c;

        static {
            Usage usage = new Usage("EMBEDDED", 0);
            f13717a = usage;
            Usage usage2 = new Usage("DIRECT", 1);
            f13718b = usage2;
            f13719c = new Usage[]{usage, usage2};
        }

        public static Usage valueOf(String str) {
            return (Usage) Enum.valueOf(Usage.class, str);
        }

        public static Usage[] values() {
            return (Usage[]) f13719c.clone();
        }
    }

    public SizeAndTimeBasedFNATP() {
        this(Usage.f13718b);
    }

    @Override // ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        throw null;
    }

    public SizeAndTimeBasedFNATP(Usage usage) {
        new DefaultInvocationGate();
    }
}
