package org.xbill.DNS;

import coil3.network.internal.UtilsKt;
import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AsyncSemaphore;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public final class DohResolver implements Resolver {
    private static final String APPLICATION_DNS_MESSAGE = "application/dns-message";
    private static final boolean USE_HTTP_CLIENT;
    private static Method byteArrayBodyPublisherMethod;
    private static Object defaultHttpRequestBuilder;
    private static Method httpClientBuilderBuildMethod;
    private static Method httpClientBuilderExecutorMethod;
    private static Method httpClientBuilderTimeoutMethod;
    private static Method httpClientNewBuilderMethod;
    private static Method httpClientSendAsyncMethod;
    private static Method httpResponseBodyMethod;
    private static Method httpResponseStatusCodeMethod;
    private static Method publisherOfByteArrayMethod;
    private static Method requestBuilderBuildMethod;
    private static Method requestBuilderCopyMethod;
    private static Method requestBuilderPostMethod;
    private static Method requestBuilderTimeoutMethod;
    private static Method requestBuilderUriMethod;
    private Executor defaultExecutor;
    private final Duration idleConnectionTimeout;
    private final AsyncSemaphore initialRequestLock;
    private final AtomicLong lastRequest;
    private final AsyncSemaphore maxConcurrentRequests;
    private OPTRecord queryOPT;
    private final SSLSocketFactory sslSocketFactory;
    private Duration timeout;
    private TSIG tsig;
    private String uriTemplate;
    private boolean usePost;

    @Generated
    private static final Logger log = LoggerFactory.b(DohResolver.class);
    private static final Map<Executor, Object> httpClients = Collections.synchronizedMap(new WeakHashMap());

    public static final class SendAndGetMessageBytesResponse {
        private final int rc;
        private final byte[] responseBytes;

        @Generated
        public SendAndGetMessageBytesResponse(int i2, byte[] bArr) {
            this.rc = i2;
            this.responseBytes = bArr;
        }

        @Generated
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SendAndGetMessageBytesResponse)) {
                return false;
            }
            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse = (SendAndGetMessageBytesResponse) obj;
            return getRc() == sendAndGetMessageBytesResponse.getRc() && Arrays.equals(getResponseBytes(), sendAndGetMessageBytesResponse.getResponseBytes());
        }

        @Generated
        public int getRc() {
            return this.rc;
        }

        @Generated
        public byte[] getResponseBytes() {
            return this.responseBytes;
        }

        @Generated
        public int hashCode() {
            return Arrays.hashCode(getResponseBytes()) + ((getRc() + 59) * 59);
        }

        @Generated
        public String toString() {
            return "DohResolver.SendAndGetMessageBytesResponse(rc=" + getRc() + ", responseBytes=" + Arrays.toString(getResponseBytes()) + ")";
        }
    }

    static {
        boolean z;
        if (System.getProperty("java.version").startsWith("1.")) {
            z = false;
        } else {
            try {
                Class<?> cls = Class.forName("java.net.http.HttpClient$Builder");
                Class<?> cls2 = Class.forName("java.net.http.HttpClient");
                Class<?> cls3 = Class.forName("java.net.http.HttpClient$Version");
                Class<?> cls4 = Class.forName("java.net.http.HttpRequest$Builder");
                Class<?> cls5 = Class.forName("java.net.http.HttpRequest");
                Class<?> cls6 = Class.forName("java.net.http.HttpRequest$BodyPublishers");
                Class<?> cls7 = Class.forName("java.net.http.HttpRequest$BodyPublisher");
                Class<?> cls8 = Class.forName("java.net.http.HttpResponse");
                Class<?> cls9 = Class.forName("java.net.http.HttpResponse$BodyHandlers");
                Class<?> cls10 = Class.forName("java.net.http.HttpResponse$BodyHandler");
                httpClientBuilderTimeoutMethod = cls.getDeclaredMethod("connectTimeout", Duration.class);
                httpClientBuilderExecutorMethod = cls.getDeclaredMethod("executor", Executor.class);
                httpClientBuilderBuildMethod = cls.getDeclaredMethod("build", null);
                httpClientNewBuilderMethod = cls2.getDeclaredMethod("newBuilder", null);
                httpClientSendAsyncMethod = cls2.getDeclaredMethod("sendAsync", cls5, cls10);
                Method declaredMethod = cls4.getDeclaredMethod("header", String.class, String.class);
                Method declaredMethod2 = cls4.getDeclaredMethod("version", cls3);
                requestBuilderTimeoutMethod = cls4.getDeclaredMethod("timeout", Duration.class);
                requestBuilderUriMethod = cls4.getDeclaredMethod("uri", URI.class);
                requestBuilderCopyMethod = cls4.getDeclaredMethod("copy", null);
                requestBuilderBuildMethod = cls4.getDeclaredMethod("build", null);
                requestBuilderPostMethod = cls4.getDeclaredMethod("POST", cls7);
                Method declaredMethod3 = cls5.getDeclaredMethod("newBuilder", null);
                publisherOfByteArrayMethod = cls6.getDeclaredMethod("ofByteArray", byte[].class);
                byteArrayBodyPublisherMethod = cls9.getDeclaredMethod("ofByteArray", null);
                httpResponseBodyMethod = cls8.getDeclaredMethod("body", null);
                httpResponseStatusCodeMethod = cls8.getDeclaredMethod("statusCode", null);
                defaultHttpRequestBuilder = declaredMethod3.invoke(null, null);
                declaredMethod2.invoke(defaultHttpRequestBuilder, Enum.valueOf(cls3, "HTTP_2"));
                declaredMethod.invoke(defaultHttpRequestBuilder, UtilsKt.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
                declaredMethod.invoke(defaultHttpRequestBuilder, "Accept", APPLICATION_DNS_MESSAGE);
                z = true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                log.q("Java >= 11 detected, but HttpRequest not available");
            }
        }
        USE_HTTP_CLIENT = z;
    }

    public DohResolver(String str) {
        this(str, 100, Duration.ofMinutes(2L));
    }

    private void discardStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                try {
                    do {
                    } while (inputStream.read(new byte[4096]) > 0);
                    inputStream.close();
                } finally {
                }
            } catch (IOException unused) {
            }
        }
    }

    private <T> CompletableFuture<T> failedFuture(Throwable th) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(th);
        return completableFuture;
    }

    private Object getHttpClient(Executor executor) {
        return httpClients.computeIfAbsent(executor, new Function() { // from class: org.xbill.DNS.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f57919a.lambda$getHttpClient$0((Executor) obj);
            }
        });
    }

    private String getUrl(byte[] bArr) {
        String str = this.uriTemplate;
        if (this.usePost) {
            return str;
        }
        StringBuilder sbX = android.support.v4.media.b.x(str, "?dns=");
        sbX.append(base64.toString(bArr, true));
        return sbX.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getHttpClient$0(Executor executor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = httpClientNewBuilderMethod.invoke(null, null);
            httpClientBuilderTimeoutMethod.invoke(objInvoke, this.timeout);
            httpClientBuilderExecutorMethod.invoke(objInvoke, executor);
            return httpClientBuilderBuildMethod.invoke(objInvoke, null);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            log.h("Could not create a HttpClient with for Executor {}", executor, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync11$2(Message message, Executor executor, long j2, Object obj, AsyncSemaphore.Permit permit, Throwable th) {
        return th != null ? timeoutFailedFuture(message, th) : sendAsync11WithInitialRequestPermit(message, executor, j2, obj, permit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAsync11WithConcurrentRequestPermit$4(long j2, AsyncSemaphore.Permit permit, boolean z, AsyncSemaphore.Permit permit2, Object obj, Throwable th) {
        if (th == null) {
            this.lastRequest.set(j2);
        }
        permit.release();
        if (z) {
            permit2.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$sendAsync11WithConcurrentRequestPermit$5(Message message, Object obj, Throwable th) {
        Message message2;
        if (th != null) {
            return th.getCause().getClass().getSimpleName().equals("HttpTimeoutException") ? timeoutFailedFuture(message, th.getCause()) : failedFuture(th);
        }
        try {
            int iIntValue = ((Integer) httpResponseStatusCodeMethod.invoke(obj, null)).intValue();
            if (iIntValue < 200 || iIntValue >= 300) {
                message2 = new Message();
                message2.getHeader().setRcode(2);
            } else {
                byte[] bArr = (byte[]) httpResponseBodyMethod.invoke(obj, null);
                message2 = new Message(bArr);
                verifyTSIG(message, message2, bArr, this.tsig);
            }
            message2.setResolver(this);
            return CompletableFuture.completedFuture(message2);
        } catch (IOException e2) {
            e = e2;
            return failedFuture(e);
        } catch (IllegalAccessException e3) {
            e = e3;
            return failedFuture(e);
        } catch (InvocationTargetException e4) {
            e = e4;
            return failedFuture(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync11WithInitialRequestPermit$3(boolean z, AsyncSemaphore.Permit permit, Message message, Executor executor, long j2, Object obj, AsyncSemaphore.Permit permit2, Throwable th) {
        if (th == null) {
            return sendAsync11WithConcurrentRequestPermit(message, executor, j2, obj, permit, z, permit2);
        }
        if (z) {
            permit.release();
        }
        return timeoutFailedFuture(message, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$sendAsync8$1(Message message, String str, byte[] bArr, long j2, AsyncSemaphore.Permit permit, Throwable th) {
        Message message2;
        try {
            if (th != null) {
                return timeoutFailedFuture(message, th);
            }
            try {
                SendAndGetMessageBytesResponse sendAndGetMessageBytesResponseSendAndGetMessageBytes = sendAndGetMessageBytes(str, bArr, j2);
                if (sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc == 0) {
                    message2 = new Message(sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes);
                    verifyTSIG(message, message2, sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes, this.tsig);
                } else {
                    message2 = new Message(0);
                    message2.getHeader().setRcode(sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc);
                }
                message2.setResolver(this);
                CompletableFuture completableFutureCompletedFuture = CompletableFuture.completedFuture(message2);
                permit.release();
                return completableFutureCompletedFuture;
            } catch (SocketTimeoutException e2) {
                CompletableFuture completableFutureTimeoutFailedFuture = timeoutFailedFuture(message, e2);
                permit.release();
                return completableFutureTimeoutFailedFuture;
            } catch (IOException e3) {
                e = e3;
                CompletableFuture completableFutureFailedFuture = failedFuture(e);
                permit.release();
                return completableFutureFailedFuture;
            } catch (URISyntaxException e4) {
                e = e4;
                CompletableFuture completableFutureFailedFuture2 = failedFuture(e);
                permit.release();
                return completableFutureFailedFuture2;
            }
        } catch (Throwable th2) {
            permit.release();
            throw th2;
        }
    }

    private Message prepareQuery(Message message) {
        Message messageClone = message.clone();
        messageClone.getHeader().setID(0);
        if (this.queryOPT != null && messageClone.getOPT() == null) {
            messageClone.addRecord(this.queryOPT, 3);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(messageClone, null);
        }
        return messageClone;
    }

    /* JADX WARN: Finally extract failed */
    private SendAndGetMessageBytesResponse sendAndGetMessageBytes(String str, byte[] bArr, long j2) throws URISyntaxException, IOException {
        SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URI(str).toURL().openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.sslSocketFactory);
        }
        Duration durationMinus = this.timeout.minus(getNanoTime() - j2, ChronoUnit.NANOS);
        httpURLConnection.setConnectTimeout((int) durationMinus.toMillis());
        httpURLConnection.setReadTimeout((int) durationMinus.toMillis());
        httpURLConnection.setRequestMethod(this.usePost ? "POST" : UtilsKt.HTTP_METHOD_GET);
        httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
        httpURLConnection.setRequestProperty("Accept", APPLICATION_DNS_MESSAGE);
        if (this.usePost) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bArr);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            discardStream(httpURLConnection.getInputStream());
            discardStream(httpURLConnection.getErrorStream());
            return new SendAndGetMessageBytesResponse(2, null);
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                if (httpURLConnection.getContentLength() > -1) {
                    int contentLength = httpURLConnection.getContentLength();
                    byte[] bArr2 = new byte[contentLength];
                    int i2 = 0;
                    do {
                        int i3 = inputStream.read(bArr2, i2, contentLength - i2);
                        if (i3 > 0) {
                            i2 += i3;
                        } else {
                            if (i2 < contentLength) {
                                throw new EOFException("Could not read expected content length");
                            }
                            sendAndGetMessageBytesResponse = new SendAndGetMessageBytesResponse(0, bArr2);
                        }
                    } while (!this.timeout.minus(getNanoTime() - j2, ChronoUnit.NANOS).isNegative());
                    throw new SocketTimeoutException();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr3 = new byte[4096];
                    while (true) {
                        int i4 = inputStream.read(bArr3, 0, 4096);
                        if (i4 <= 0) {
                            sendAndGetMessageBytesResponse = new SendAndGetMessageBytesResponse(0, byteArrayOutputStream.toByteArray());
                            byteArrayOutputStream.close();
                            break;
                        }
                        if (this.timeout.minus(getNanoTime() - j2, ChronoUnit.NANOS).isNegative()) {
                            throw new SocketTimeoutException();
                        }
                        byteArrayOutputStream.write(bArr3, 0, i4);
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                inputStream.close();
                return sendAndGetMessageBytesResponse;
            } finally {
            }
        } catch (IOException e2) {
            discardStream(httpURLConnection.getErrorStream());
            throw e2;
        }
    }

    private CompletionStage<Message> sendAsync11(Message message, Executor executor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Throwable th;
        long nanoTime = getNanoTime();
        byte[] wire = prepareQuery(message).toWire();
        String url = getUrl(wire);
        try {
            Object objInvoke = requestBuilderCopyMethod.invoke(defaultHttpRequestBuilder, null);
            requestBuilderUriMethod.invoke(objInvoke, URI.create(url));
            if (this.usePost) {
                try {
                    requestBuilderPostMethod.invoke(objInvoke, publisherOfByteArrayMethod.invoke(null, wire));
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    th = e2;
                    return failedFuture(th);
                }
            }
            return this.initialRequestLock.acquire(this.timeout.minus(getNanoTime() - nanoTime, ChronoUnit.NANOS)).handle(new d(this, message, executor, nanoTime, objInvoke)).thenCompose(Function.identity());
        } catch (IllegalAccessException | InvocationTargetException e3) {
            th = e3;
        }
    }

    private CompletionStage<Message> sendAsync11WithConcurrentRequestPermit(Message message, Executor executor, final long j2, Object obj, final AsyncSemaphore.Permit permit, final boolean z, final AsyncSemaphore.Permit permit2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Duration durationMinus = this.timeout.minus(getNanoTime() - j2, ChronoUnit.NANOS);
        if (durationMinus.isNegative()) {
            if (z) {
                permit.release();
            }
            permit2.release();
            return timeoutFailedFuture(message, null);
        }
        try {
            Object httpClient = getHttpClient(executor);
            requestBuilderTimeoutMethod.invoke(obj, durationMinus);
            return TimeoutCompletableFuture.compatTimeout(((CompletableFuture) httpClientSendAsyncMethod.invoke(httpClient, requestBuilderBuildMethod.invoke(obj, null), byteArrayBodyPublisherMethod.invoke(null, null))).whenComplete(new BiConsumer() { // from class: org.xbill.DNS.e
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    DohResolver dohResolver = this.f57993a;
                    AsyncSemaphore.Permit permit3 = permit2;
                    boolean z2 = z;
                    dohResolver.lambda$sendAsync11WithConcurrentRequestPermit$4(j2, permit3, z2, permit, obj2, (Throwable) obj3);
                }
            }).handleAsync((BiFunction) new f(0, this, message), executor).thenCompose(Function.identity()), durationMinus.toMillis(), TimeUnit.MILLISECONDS);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return failedFuture(e2);
        }
    }

    private CompletionStage<Message> sendAsync11WithInitialRequestPermit(final Message message, final Executor executor, final long j2, final Object obj, final AsyncSemaphore.Permit permit) {
        final boolean z = this.idleConnectionTimeout.toNanos() > getNanoTime() - this.lastRequest.get();
        if (!z) {
            permit.release();
        }
        Duration durationMinus = this.timeout.minus(getNanoTime() - j2, ChronoUnit.NANOS);
        if (!durationMinus.isNegative()) {
            return this.maxConcurrentRequests.acquire(durationMinus).handle(new BiFunction() { // from class: org.xbill.DNS.g
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    DohResolver dohResolver = this.f58007a;
                    long j3 = j2;
                    Object obj4 = obj;
                    return dohResolver.lambda$sendAsync11WithInitialRequestPermit$3(z, permit, message, executor, j3, obj4, (AsyncSemaphore.Permit) obj2, (Throwable) obj3);
                }
            }).thenCompose(Function.identity());
        }
        if (z) {
            permit.release();
        }
        return timeoutFailedFuture(message, null);
    }

    private CompletionStage<Message> sendAsync8(Message message, Executor executor) {
        byte[] wire = prepareQuery(message).toWire();
        return this.maxConcurrentRequests.acquire(this.timeout).handleAsync(new d(this, message, getUrl(wire), wire, getNanoTime()), executor).thenCompose(Function.identity());
    }

    private <T> CompletableFuture<T> timeoutFailedFuture(Message message, Throwable th) {
        return failedFuture(new IOException("Query " + message.getHeader().getID() + " for " + message.getQuestion().getName() + "/" + Type.string(message.getQuestion().getType()) + " timed out", th));
    }

    private void verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig) {
        if (tsig == null) {
            return;
        }
        log.g("TSIG verify for query {}, {}/{}: {}", Integer.valueOf(message.getHeader().getID()), message.getQuestion().getName(), Type.string(message.getQuestion().getType()), Rcode.TSIGstring(tsig.verify(message2, bArr, message.getGeneratedTSIG())));
    }

    @Deprecated
    public Executor getExecutor() {
        return this.defaultExecutor;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    public String getUriTemplate() {
        return this.uriTemplate;
    }

    public boolean isUsePost() {
        return this.usePost;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, this.defaultExecutor);
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i2, int i3, int i4, List<EDNSOption> list) {
        if (i2 == -1) {
            this.queryOPT = null;
        } else {
            if (i2 != 0) {
                throw new IllegalArgumentException("invalid EDNS version - must be 0 or -1 to disable");
            }
            this.queryOPT = new OPTRecord(0, 0, i2, i4, list);
        }
    }

    @Deprecated
    public void setExecutor(Executor executor) {
        if (executor == null) {
            executor = ForkJoinPool.commonPool();
        }
        this.defaultExecutor = executor;
        httpClients.clear();
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i2) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
        httpClients.clear();
    }

    public void setUriTemplate(String str) {
        this.uriTemplate = str;
    }

    public void setUsePost(boolean z) {
        this.usePost = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DohResolver {");
        sb.append(this.usePost ? "POST " : "GET ");
        return android.support.v4.media.b.r(sb, this.uriTemplate, "}");
    }

    public DohResolver(String str, int i2, Duration duration) throws NumberFormatException {
        this.usePost = false;
        this.timeout = Duration.ofSeconds(5L);
        this.queryOPT = new OPTRecord(0, 0, 0);
        this.defaultExecutor = ForkJoinPool.commonPool();
        this.lastRequest = new AtomicLong(0L);
        this.initialRequestLock = new AsyncSemaphore(1);
        this.uriTemplate = str;
        this.idleConnectionTimeout = duration;
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxConcurrentRequests must be > 0");
        }
        if (!USE_HTTP_CLIENT) {
            try {
                int i3 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                if (i2 > i3) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
            }
        }
        this.maxConcurrentRequests = new AsyncSemaphore(i2);
        try {
            this.sslSocketFactory = SSLContext.getDefault().getSocketFactory();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return USE_HTTP_CLIENT ? sendAsync11(message, executor) : sendAsync8(message, executor);
    }
}
