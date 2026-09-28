package ch.qos.logback.classic;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import ch.qos.logback.classic.pattern.ContextNameConverter;
import ch.qos.logback.classic.pattern.DateConverter;
import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.pattern.FileOfCallerConverter;
import ch.qos.logback.classic.pattern.LevelConverter;
import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import ch.qos.logback.classic.pattern.LocalSequenceNumberConverter;
import ch.qos.logback.classic.pattern.LoggerConverter;
import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.pattern.MarkerConverter;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.pattern.MethodOfCallerConverter;
import ch.qos.logback.classic.pattern.NopThrowableInformationConverter;
import ch.qos.logback.classic.pattern.PrefixCompositeConverter;
import ch.qos.logback.classic.pattern.PropertyConverter;
import ch.qos.logback.classic.pattern.RelativeTimeConverter;
import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import ch.qos.logback.classic.pattern.ThreadConverter;
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.PatternLayoutBase;
import ch.qos.logback.core.pattern.color.BlackCompositeConverter;
import ch.qos.logback.core.pattern.color.BlueCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldMagentaCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldRedCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import ch.qos.logback.core.pattern.color.CyanCompositeConverter;
import ch.qos.logback.core.pattern.color.GrayCompositeConverter;
import ch.qos.logback.core.pattern.color.GreenCompositeConverter;
import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import ch.qos.logback.core.pattern.color.RedCompositeConverter;
import ch.qos.logback.core.pattern.color.WhiteCompositeConverter;
import ch.qos.logback.core.pattern.color.YellowCompositeConverter;
import ch.qos.logback.core.pattern.parser.Parser;
import coil3.util.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.hyperutil.constants.LogLevel;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f13253i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f13254j;

    static {
        HashMap map = new HashMap();
        f13253i = map;
        HashMap map2 = new HashMap();
        f13254j = map2;
        map.putAll(Parser.f13680f);
        map.put("d", DateConverter.class.getName());
        map.put(CLConstants.SHARED_PREFERENCE_ITEM_DATE, DateConverter.class.getName());
        map2.put(DateConverter.class.getName(), CLConstants.SHARED_PREFERENCE_ITEM_DATE);
        map.put("r", RelativeTimeConverter.class.getName());
        map.put("relative", RelativeTimeConverter.class.getName());
        map2.put(RelativeTimeConverter.class.getName(), "relative");
        map.put("level", LevelConverter.class.getName());
        map.put("le", LevelConverter.class.getName());
        map.put("p", LevelConverter.class.getName());
        map2.put(LevelConverter.class.getName(), "level");
        map.put("t", ThreadConverter.class.getName());
        map.put("thread", ThreadConverter.class.getName());
        map2.put(ThreadConverter.class.getName(), "thread");
        map.put("lo", LoggerConverter.class.getName());
        map.put("logger", LoggerConverter.class.getName());
        map.put("c", LoggerConverter.class.getName());
        map2.put(LoggerConverter.class.getName(), "logger");
        map.put("m", MessageConverter.class.getName());
        map.put("msg", MessageConverter.class.getName());
        map.put(APayConstants.Error.MESSAGE, MessageConverter.class.getName());
        map2.put(MessageConverter.class.getName(), APayConstants.Error.MESSAGE);
        map.put("C", ClassOfCallerConverter.class.getName());
        map.put("class", ClassOfCallerConverter.class.getName());
        map2.put(ClassOfCallerConverter.class.getName(), "class");
        map.put("M", MethodOfCallerConverter.class.getName());
        map.put("method", MethodOfCallerConverter.class.getName());
        map2.put(MethodOfCallerConverter.class.getName(), "method");
        map.put("L", LineOfCallerConverter.class.getName());
        map.put("line", LineOfCallerConverter.class.getName());
        map2.put(LineOfCallerConverter.class.getName(), "line");
        map.put("F", FileOfCallerConverter.class.getName());
        map.put(UtilsKt.SCHEME_FILE, FileOfCallerConverter.class.getName());
        map2.put(FileOfCallerConverter.class.getName(), UtilsKt.SCHEME_FILE);
        map.put("X", MDCConverter.class.getName());
        map.put("mdc", MDCConverter.class.getName());
        map.put("ex", ThrowableProxyConverter.class.getName());
        map.put(LogLevel.EXCEPTION, ThrowableProxyConverter.class.getName());
        map.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
        map.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
        map.put("throwable", ThrowableProxyConverter.class.getName());
        map.put("xEx", ExtendedThrowableProxyConverter.class.getName());
        map.put("xException", ExtendedThrowableProxyConverter.class.getName());
        map.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());
        map.put("nopex", NopThrowableInformationConverter.class.getName());
        map.put("nopexception", NopThrowableInformationConverter.class.getName());
        map.put("cn", ContextNameConverter.class.getName());
        map.put("contextName", ContextNameConverter.class.getName());
        map2.put(ContextNameConverter.class.getName(), "contextName");
        map.put("caller", CallerDataConverter.class.getName());
        map2.put(CallerDataConverter.class.getName(), "caller");
        map.put("marker", MarkerConverter.class.getName());
        map2.put(MarkerConverter.class.getName(), "marker");
        map.put("property", PropertyConverter.class.getName());
        map.put("n", LineSeparatorConverter.class.getName());
        map.put("black", BlackCompositeConverter.class.getName());
        map.put("red", RedCompositeConverter.class.getName());
        map.put("green", GreenCompositeConverter.class.getName());
        map.put("yellow", YellowCompositeConverter.class.getName());
        map.put("blue", BlueCompositeConverter.class.getName());
        map.put("magenta", MagentaCompositeConverter.class.getName());
        map.put("cyan", CyanCompositeConverter.class.getName());
        map.put("white", WhiteCompositeConverter.class.getName());
        map.put("gray", GrayCompositeConverter.class.getName());
        map.put("boldRed", BoldRedCompositeConverter.class.getName());
        map.put("boldGreen", BoldGreenCompositeConverter.class.getName());
        map.put("boldYellow", BoldYellowCompositeConverter.class.getName());
        map.put("boldBlue", BoldBlueCompositeConverter.class.getName());
        map.put("boldMagenta", BoldMagentaCompositeConverter.class.getName());
        map.put("boldCyan", BoldCyanCompositeConverter.class.getName());
        map.put("boldWhite", BoldWhiteCompositeConverter.class.getName());
        map.put("highlight", HighlightingCompositeConverter.class.getName());
        map.put("lsn", LocalSequenceNumberConverter.class.getName());
        map2.put(LocalSequenceNumberConverter.class.getName(), "lsn");
        map.put("prefix", PrefixCompositeConverter.class.getName());
    }

    public PatternLayout() {
        this.f13660g = new EnsureExceptionHandling();
    }

    @Override // ch.qos.logback.core.pattern.PatternLayoutBase
    public final HashMap T1() {
        return f13253i;
    }

    @Override // ch.qos.logback.core.Layout
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public final String c1(ILoggingEvent iLoggingEvent) {
        if (!this.f13445d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(256);
        for (Converter converter = this.f13658e; converter != null; converter = converter.f13648a) {
            converter.c(sb, iLoggingEvent);
        }
        return sb.toString();
    }
}
