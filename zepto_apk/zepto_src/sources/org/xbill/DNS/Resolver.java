package org.xbill.DNS;

import j$.time.Duration;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public interface Resolver {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$sendAsync$0(ResolverListener resolverListener, Object obj, Message message, Throwable th) {
        if (th != null) {
            resolverListener.handleException(obj, th instanceof Exception ? (Exception) th : new Exception(th));
            return null;
        }
        resolverListener.receiveMessage(obj, message);
        return null;
    }

    default Duration getTimeout() {
        return Duration.ofSeconds(10L);
    }

    default Message send(Message message) throws IOException {
        try {
            return sendAsync(message).toCompletableFuture().get(getTimeout().toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new IOException(e2);
        } catch (ExecutionException e3) {
            if (e3.getCause() instanceof IOException) {
                throw ((IOException) e3.getCause());
            }
            if (e3.getCause() != null) {
                throw new IOException(e3.getCause());
            }
            throw new IOException(e3);
        } catch (TimeoutException e4) {
            throw new IOException("Timed out while trying to resolve " + message.getQuestion().getName() + "/" + Type.string(message.getQuestion().type) + ", id=" + message.getHeader().getID(), e4);
        }
    }

    default CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    default void setEDNS(int i2) {
        setEDNS(i2, 0, 0, Collections.EMPTY_LIST);
    }

    void setEDNS(int i2, int i3, int i4, List<EDNSOption> list);

    void setIgnoreTruncation(boolean z);

    void setPort(int i2);

    void setTCP(boolean z);

    void setTSIGKey(TSIG tsig);

    @Deprecated
    default void setTimeout(int i2, int i3) {
        setTimeout(Duration.ofMillis((i2 * 1000) + i3));
    }

    void setTimeout(Duration duration);

    default CompletionStage<Message> sendAsync(Message message, Executor executor) {
        final CompletableFuture completableFuture = new CompletableFuture();
        sendAsync(message, new ResolverListener() { // from class: org.xbill.DNS.Resolver.1
            @Override // org.xbill.DNS.ResolverListener
            public void handleException(Object obj, Exception exc) {
                completableFuture.completeExceptionally(exc);
            }

            @Override // org.xbill.DNS.ResolverListener
            public void receiveMessage(Object obj, Message message2) {
                completableFuture.complete(message2);
            }
        });
        return completableFuture;
    }

    default void setEDNS(int i2, int i3, int i4, EDNSOption... eDNSOptionArr) {
        setEDNS(i2, i3, i4, eDNSOptionArr == null ? Collections.EMPTY_LIST : Arrays.asList(eDNSOptionArr));
    }

    @Deprecated
    default void setTimeout(int i2) {
        setTimeout(Duration.ofSeconds(i2));
    }

    @Deprecated
    default Object sendAsync(Message message, ResolverListener resolverListener) {
        Object obj = new Object();
        sendAsync(message).handleAsync(new f(1, resolverListener, obj));
        return obj;
    }
}
