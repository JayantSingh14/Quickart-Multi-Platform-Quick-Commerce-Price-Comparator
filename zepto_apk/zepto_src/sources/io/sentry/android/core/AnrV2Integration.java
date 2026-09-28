package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ApplicationExitInfo;
import android.content.Context;
import coil3.network.internal.UtilsKt;
import io.sentry.Attachment;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.threaddump.Line;
import io.sentry.android.core.internal.threaddump.Lines;
import io.sentry.android.core.internal.threaddump.ThreadDumpParser;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.Backfillable;
import io.sentry.hints.BlockingFlushHint;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class AnrV2Integration implements Integration, Closeable, AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public static final long f52080d = TimeUnit.DAYS.toMillis(91);

    /* renamed from: a, reason: collision with root package name */
    public final Context f52081a;

    /* renamed from: b, reason: collision with root package name */
    public final CurrentDateProvider f52082b;

    /* renamed from: c, reason: collision with root package name */
    public SentryAndroidOptions f52083c;

    /* loaded from: classes3.dex */
    public static class AnrProcessor implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Context f52084a;

        /* renamed from: b, reason: collision with root package name */
        public final SentryAndroidOptions f52085b;

        /* renamed from: c, reason: collision with root package name */
        public final long f52086c;

        public AnrProcessor(Context context, SentryAndroidOptions sentryAndroidOptions, CurrentDateProvider currentDateProvider) {
            this.f52084a = context;
            this.f52085b = sentryAndroidOptions;
            currentDateProvider.getClass();
            this.f52086c = System.currentTimeMillis() - AnrV2Integration.f52080d;
        }

        public final void a(ApplicationExitInfo applicationExitInfo, boolean z) {
            ParseResult parseResult;
            byte[] bArr;
            InputStream traceInputStream;
            SentryAndroidOptions sentryAndroidOptions = this.f52085b;
            long timestamp = applicationExitInfo.getTimestamp();
            boolean z2 = applicationExitInfo.getImportance() != 100;
            try {
                traceInputStream = applicationExitInfo.getTraceInputStream();
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.WARNING, "Failed to read ANR thread dump", th);
                parseResult = new ParseResult(ParseResult.Type.NO_DUMP);
            }
            try {
                if (traceInputStream == null) {
                    parseResult = new ParseResult(ParseResult.Type.NO_DUMP);
                    if (traceInputStream != null) {
                        traceInputStream.close();
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int i2 = traceInputStream.read(bArr2, 0, 1024);
                            if (i2 == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr2, 0, i2);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        traceInputStream.close();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArray)));
                            try {
                                ArrayList arrayList = new ArrayList();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    Line line2 = new Line();
                                    line2.f52283a = line;
                                    arrayList.add(line2);
                                }
                                ArrayList arrayListD = new ThreadDumpParser(sentryAndroidOptions, z2).d(new Lines(arrayList));
                                if (arrayListD.isEmpty()) {
                                    parseResult = new ParseResult(ParseResult.Type.NO_DUMP);
                                    bufferedReader.close();
                                } else {
                                    ParseResult parseResult2 = new ParseResult(ParseResult.Type.DUMP, byteArray, arrayListD);
                                    bufferedReader.close();
                                    parseResult = parseResult2;
                                }
                            } finally {
                            }
                        } catch (Throwable th2) {
                            sentryAndroidOptions.getLogger().b(SentryLevel.WARNING, "Failed to parse ANR thread dump", th2);
                            parseResult = new ParseResult(ParseResult.Type.ERROR, byteArray);
                        }
                    } finally {
                    }
                }
                ParseResult.Type type = ParseResult.Type.NO_DUMP;
                ParseResult.Type type2 = parseResult.f52090a;
                if (type2 == type) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
                    return;
                }
                AnrV2Hint anrV2Hint = new AnrV2Hint(sentryAndroidOptions.getFlushTimeoutMillis(), sentryAndroidOptions.getLogger(), timestamp, z, z2);
                Hint hintA = HintUtils.a(anrV2Hint);
                SentryEvent sentryEvent = new SentryEvent();
                if (type2 == ParseResult.Type.ERROR) {
                    Message message = new Message();
                    message.f52856a = "Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.";
                    sentryEvent.q = message;
                } else if (type2 == ParseResult.Type.DUMP) {
                    sentryEvent.h(parseResult.f52092c);
                }
                sentryEvent.u = SentryLevel.FATAL;
                sentryEvent.p = DateUtils.b(timestamp);
                if (sentryAndroidOptions.isAttachAnrThreadDump() && (bArr = parseResult.f52091b) != null) {
                    hintA.f51640e = new Attachment("thread-dump.txt", UtilsKt.MIME_TYPE_TEXT_PLAIN, bArr);
                }
                if (HubAdapter.f51658a.A(sentryEvent, hintA).equals(SentryId.f52907b) || anrV2Hint.g()) {
                    return;
                }
                sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush ANR event to disk. Event: %s", sentryEvent.f51791a);
            } finally {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00cb A[EDGE_INSN: B:63:0x00cb->B:33:0x00cb BREAK  A[LOOP:0: B:28:0x00b2->B:65:?], SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 367
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AnrV2Integration.AnrProcessor.run():void");
        }
    }

    @ApiStatus.Internal
    public static final class AnrV2Hint extends BlockingFlushHint implements Backfillable, AbnormalExit {

        /* renamed from: d, reason: collision with root package name */
        public final long f52087d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52088e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f52089f;

        public AnrV2Hint(long j2, ILogger iLogger, long j3, boolean z, boolean z2) {
            super(j2, iLogger);
            this.f52087d = j3;
            this.f52088e = z;
            this.f52089f = z2;
        }

        @Override // io.sentry.hints.Backfillable
        public final boolean a() {
            return this.f52088e;
        }

        @Override // io.sentry.hints.DiskFlushNotification
        public final boolean b(SentryId sentryId) {
            return true;
        }

        @Override // io.sentry.hints.DiskFlushNotification
        public final void c(SentryId sentryId) {
        }

        @Override // io.sentry.hints.AbnormalExit
        public final Long e() {
            return Long.valueOf(this.f52087d);
        }

        @Override // io.sentry.hints.AbnormalExit
        public final boolean f() {
            return false;
        }

        @Override // io.sentry.hints.AbnormalExit
        public final String h() {
            return this.f52089f ? "anr_background" : "anr_foreground";
        }
    }

    public AnrV2Integration(Context context) {
        CurrentDateProvider currentDateProvider = CurrentDateProvider.f53091a;
        Context applicationContext = context.getApplicationContext();
        this.f52081a = applicationContext != null ? applicationContext : context;
        this.f52082b = currentDateProvider;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SentryAndroidOptions sentryAndroidOptions = this.f52083c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52083c = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(this.f52083c.isAnrEnabled()));
        if (this.f52083c.getCacheDirPath() == null) {
            this.f52083c.getLogger().c(SentryLevel.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (this.f52083c.isAnrEnabled()) {
            try {
                sentryOptions.getExecutorService().submit(new AnrProcessor(this.f52081a, this.f52083c, this.f52082b));
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to start AnrProcessor.", th);
            }
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "AnrV2Integration installed.", new Object[0]);
            IntegrationUtils.a("AnrV2");
        }
    }

    /* loaded from: classes3.dex */
    public static final class ParseResult {

        /* renamed from: a, reason: collision with root package name */
        public final Type f52090a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f52091b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f52092c;

        public enum Type {
            DUMP,
            NO_DUMP,
            ERROR
        }

        public ParseResult(Type type) {
            this.f52090a = type;
            this.f52091b = null;
            this.f52092c = null;
        }

        public ParseResult(Type type, byte[] bArr) {
            this.f52090a = type;
            this.f52091b = bArr;
            this.f52092c = null;
        }

        public ParseResult(Type type, byte[] bArr, ArrayList arrayList) {
            this.f52090a = type;
            this.f52091b = bArr;
            this.f52092c = arrayList;
        }
    }
}
