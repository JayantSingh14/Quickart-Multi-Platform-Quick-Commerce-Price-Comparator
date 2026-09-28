package in.juspay.airborne.ota;

import in.juspay.airborne.ota.UpdateTask;
import io.sentry.Attachment;
import io.sentry.ILogger;
import io.sentry.ISerializer;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryEnvelopeItem;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.vendor.Base64;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f48455b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48456c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f48457d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f48458e;

    public /* synthetic */ b(UpdateTask.Update.Package r2, UpdateTask updateTask, ReleaseConfig releaseConfig, long j2) {
        this.f48454a = 0;
        this.f48456c = r2;
        this.f48457d = updateTask;
        this.f48458e = releaseConfig;
        this.f48455b = j2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws SentryEnvelopeException {
        Object obj = this.f48458e;
        Object obj2 = this.f48457d;
        long j2 = this.f48455b;
        Object obj3 = this.f48456c;
        switch (this.f48454a) {
            case 0:
                return UpdateTask.runInternal$lambda$4((UpdateTask.Update.Package) obj3, (UpdateTask) obj2, (ReleaseConfig) obj, j2);
            case 1:
                ISerializer iSerializer = (ISerializer) obj;
                Charset charset = SentryEnvelopeItem.f51819d;
                File file = (File) obj3;
                if (!file.exists()) {
                    throw new SentryEnvelopeException(android.support.v4.media.b.D("Dropping profiling trace data, because the file '", file.getName(), "' doesn't exists"));
                }
                String strC = Base64.c(FileUtils.b(j2, file.getPath()));
                if (strC.isEmpty()) {
                    throw new SentryEnvelopeException("Profiling trace file is empty");
                }
                ProfilingTraceData profilingTraceData = (ProfilingTraceData) obj2;
                profilingTraceData.B = strC;
                try {
                    profilingTraceData.f51738l = (List) profilingTraceData.f51728b.call();
                } catch (Throwable unused) {
                }
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, SentryEnvelopeItem.f51819d));
                            try {
                                iSerializer.e(profilingTraceData, bufferedWriter);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                bufferedWriter.close();
                                byteArrayOutputStream.close();
                                return byteArray;
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        throw new SentryEnvelopeException("Failed to serialize profiling trace data\n" + e2.getMessage());
                    }
                } finally {
                    file.delete();
                }
            default:
                Charset charset2 = SentryEnvelopeItem.f51819d;
                Attachment attachment = (Attachment) obj3;
                byte[] bArrB = attachment.f51546a;
                String str = attachment.f51548c;
                if (bArrB != null) {
                    long length = bArrB.length;
                    if (length > j2) {
                        throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(length), Long.valueOf(j2)));
                    }
                } else {
                    ViewHierarchy viewHierarchy = attachment.f51547b;
                    if (viewHierarchy == null || (bArrB = JsonSerializationUtils.b((ISerializer) obj2, (ILogger) obj, viewHierarchy)) == null) {
                        throw new SentryEnvelopeException(android.support.v4.media.b.D("Couldn't attach the attachment ", str, ".\nPlease check that either bytes, serializable or a path is set."));
                    }
                    long length2 = bArrB.length;
                    if (length2 > j2) {
                        throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(length2), Long.valueOf(j2)));
                    }
                }
                return bArrB;
        }
    }

    public /* synthetic */ b(Object obj, long j2, Object obj2, Object obj3, int i2) {
        this.f48454a = i2;
        this.f48456c = obj;
        this.f48455b = j2;
        this.f48457d = obj2;
        this.f48458e = obj3;
    }
}
