package io.sentry.android.core.internal.threaddump;

import io.sentry.SentryLockReason;
import io.sentry.SentryOptions;
import io.sentry.SentryStackTraceFactory;
import io.sentry.protocol.SentryThread;
import io.sentry.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ThreadDumpParser {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f52287d = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f52288e = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f52289f = Pattern.compile(" *(?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*?)\\s+\\((.*)\\+(\\d+)\\)(?: \\(.*\\))?");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f52290g = Pattern.compile(" *(?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*)\\s*\\(?(.*)\\)?(?: \\(.*\\))?");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f52291h = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f52292i = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f52293j = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f52294k = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f52295l = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f52296m = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    public static final Pattern n = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
    public static final Pattern o = Pattern.compile(" *- waiting to lock an unknown object");
    public static final Pattern p = Pattern.compile("\\s+");

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52297a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f52298b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryStackTraceFactory f52299c;

    public ThreadDumpParser(SentryOptions sentryOptions, boolean z) {
        this.f52297a = sentryOptions;
        this.f52298b = z;
        this.f52299c = new SentryStackTraceFactory(sentryOptions);
    }

    public static void a(SentryThread sentryThread, SentryLockReason sentryLockReason) {
        Map map = sentryThread.f52955j;
        if (map == null) {
            map = new HashMap();
        }
        SentryLockReason sentryLockReason2 = (SentryLockReason) map.get(sentryLockReason.f51840b);
        if (sentryLockReason2 != null) {
            sentryLockReason2.f51839a = Math.max(sentryLockReason2.f51839a, sentryLockReason.f51839a);
        } else {
            String str = sentryLockReason.f51840b;
            SentryLockReason sentryLockReason3 = new SentryLockReason();
            sentryLockReason3.f51839a = sentryLockReason.f51839a;
            sentryLockReason3.f51840b = str;
            sentryLockReason3.f51841c = sentryLockReason.f51841c;
            sentryLockReason3.f51842d = sentryLockReason.f51842d;
            sentryLockReason3.f51843e = sentryLockReason.f51843e;
            sentryLockReason3.f51844f = CollectionUtils.c(sentryLockReason.f51844f);
            map.put(str, sentryLockReason3);
        }
        sentryThread.f52955j = map;
    }

    public static Long b(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        return Long.valueOf(Long.parseLong(strGroup));
    }

    public static boolean c(Matcher matcher, String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03a3 A[EDGE_INSN: B:133:0x03a3->B:121:0x03a3 BREAK  A[LOOP:1: B:54:0x017e->B:120:0x0395], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList d(io.sentry.android.core.internal.threaddump.Lines r34) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.threaddump.ThreadDumpParser.d(io.sentry.android.core.internal.threaddump.Lines):java.util.ArrayList");
    }
}
