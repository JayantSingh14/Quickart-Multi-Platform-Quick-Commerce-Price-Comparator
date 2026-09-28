package org.xbill.DNS;

import j$.time.Duration;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.ExtendedResolver;

/* loaded from: classes5.dex */
public class ExtendedResolver implements Resolver {
    private final AtomicInteger lbStart;
    private boolean loadBalance;
    private final List<ResolverEntry> resolvers;
    private int retries;
    private Duration timeout;

    @Generated
    private static final Logger log = LoggerFactory.b(ExtendedResolver.class);
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration DEFAULT_RESOLVER_TIMEOUT = Duration.ofSeconds(5);

    public static class Resolution {
        private final int[] attempts;
        private int currentResolver;
        private final long endTime;
        private final Message query;
        private List<ResolverEntry> resolvers;
        private final int retriesPerResolver;

        public Resolution(ExtendedResolver extendedResolver, Message message) {
            this.resolvers = new ArrayList(extendedResolver.resolvers);
            this.endTime = extendedResolver.timeout.toNanos() + System.nanoTime();
            if (extendedResolver.loadBalance) {
                int iUpdateAndGet = extendedResolver.lbStart.updateAndGet(new IntUnaryOperator() { // from class: org.xbill.DNS.k
                    @Override // java.util.function.IntUnaryOperator
                    public final int applyAsInt(int i2) {
                        return this.f58031a.lambda$new$0(i2);
                    }
                });
                if (iUpdateAndGet > 0) {
                    ArrayList arrayList = new ArrayList(this.resolvers.size());
                    for (int i2 = 0; i2 < this.resolvers.size(); i2++) {
                        arrayList.add(this.resolvers.get((i2 + iUpdateAndGet) % this.resolvers.size()));
                    }
                    this.resolvers = arrayList;
                }
            } else {
                this.resolvers = (List) this.resolvers.stream().sorted(Comparator.comparingInt(new l())).collect(Collectors.toList());
            }
            this.attempts = new int[this.resolvers.size()];
            this.retriesPerResolver = extendedResolver.retries;
            this.query = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: handle, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public CompletionStage<Message> lambda$startAsync$2(Message message, Throwable th, Executor executor) {
            AtomicInteger atomicInteger = this.resolvers.get(this.currentResolver).failures;
            if (th == null) {
                atomicInteger.updateAndGet(new n());
                return CompletableFuture.completedFuture(message);
            }
            ExtendedResolver.log.g("Failed to resolve {}/{}, id={} with resolver {} ({}) on attempt {} of {}, reason={}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), this.resolvers.get(this.currentResolver).resolver, Integer.valueOf(this.attempts[this.currentResolver]), Integer.valueOf(this.retriesPerResolver), th.getMessage());
            atomicInteger.incrementAndGet();
            if (this.endTime - System.nanoTime() >= 0) {
                int size = (this.currentResolver + 1) % this.resolvers.size();
                this.currentResolver = size;
                if (this.attempts[size] < this.retriesPerResolver) {
                    return send(executor).handle(new m(this, executor, 1)).thenCompose(Function.identity());
                }
                CompletableFuture completableFuture = new CompletableFuture();
                completableFuture.completeExceptionally(th);
                return completableFuture;
            }
            CompletableFuture completableFuture2 = new CompletableFuture();
            completableFuture2.completeExceptionally(new IOException("Timed out while trying to resolve " + this.query.getQuestion().getName() + "/" + Type.string(this.query.getQuestion().type) + ", id=" + this.query.getHeader().getID()));
            return completableFuture2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$handle$4(int i2) {
            if (i2 > 0) {
                return (int) Math.log(i2);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$new$0(int i2) {
            return (i2 + 1) % this.resolvers.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$new$1(ResolverEntry resolverEntry) {
            return resolverEntry.failures.get();
        }

        private CompletionStage<Message> send(Executor executor) {
            ResolverEntry resolverEntry = this.resolvers.get(this.currentResolver);
            ExtendedResolver.log.g("Sending {}/{}, id={} to resolver {} ({}), attempt {} of {}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), resolverEntry.resolver, Integer.valueOf(this.attempts[this.currentResolver] + 1), Integer.valueOf(this.retriesPerResolver));
            int[] iArr = this.attempts;
            int i2 = this.currentResolver;
            iArr[i2] = iArr[i2] + 1;
            return resolverEntry.resolver.sendAsync(this.query, executor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletionStage<Message> startAsync(Executor executor) {
            return send(executor).handle(new m(this, executor, 0)).thenCompose(Function.identity());
        }
    }

    public static class ResolverEntry {
        private final AtomicInteger failures;
        private final Resolver resolver;

        @Generated
        public ResolverEntry(Resolver resolver, AtomicInteger atomicInteger) {
            this.resolver = resolver;
            this.failures = atomicInteger;
        }

        public static /* synthetic */ Resolver access$500(ResolverEntry resolverEntry) {
            return resolverEntry.resolver;
        }

        public String toString() {
            return this.resolver.toString();
        }

        public ResolverEntry(Resolver resolver) {
            this(resolver, new AtomicInteger(0));
        }
    }

    public ExtendedResolver() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.resolvers = copyOnWriteArrayList;
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        copyOnWriteArrayList.addAll((Collection) ResolverConfig.getCurrentConfig().servers().stream().map(new i(4)).collect(Collectors.toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteResolver$3(Resolver resolver, ResolverEntry resolverEntry) {
        return resolverEntry.resolver == resolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Resolver[] lambda$getResolvers$2(int i2) {
        return new Resolver[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResolverEntry lambda$new$0(InetSocketAddress inetSocketAddress) {
        SimpleResolver simpleResolver = new SimpleResolver(inetSocketAddress);
        simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
        return new ResolverEntry(simpleResolver);
    }

    public void addResolver(Resolver resolver) {
        this.resolvers.add(new ResolverEntry(resolver));
    }

    public void deleteResolver(final Resolver resolver) {
        this.resolvers.removeIf(new Predicate() { // from class: org.xbill.DNS.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ExtendedResolver.lambda$deleteResolver$3(resolver, (ExtendedResolver.ResolverEntry) obj);
            }
        });
    }

    public boolean getLoadBalance() {
        return this.loadBalance;
    }

    public Resolver getResolver(int i2) {
        if (i2 < this.resolvers.size()) {
            return this.resolvers.get(i2).resolver;
        }
        return null;
    }

    public Resolver[] getResolvers() {
        return (Resolver[]) this.resolvers.stream().map(new i(0)).toArray(new j());
    }

    public int getRetries() {
        return this.retries;
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i2, int i3, int i4, List<EDNSOption> list) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setEDNS(i2, i3, i4, list);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setIgnoreTruncation(z);
        }
    }

    public void setLoadBalance(boolean z) {
        this.loadBalance = z;
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i2) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setPort(i2);
        }
    }

    public void setRetries(int i2) {
        this.retries = i2;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTCP(z);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTSIGKey(tsig);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
    }

    public String toString() {
        return "ExtendedResolver of " + this.resolvers;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return new Resolution(this, message).startAsync(executor);
    }

    public ExtendedResolver(String[] strArr) throws UnknownHostException {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        for (String str : strArr) {
            SimpleResolver simpleResolver = new SimpleResolver(str);
            simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
            this.resolvers.add(new ResolverEntry(simpleResolver));
        }
    }

    public ExtendedResolver(Resolver[] resolverArr) {
        this(Arrays.asList(resolverArr));
    }

    public ExtendedResolver(Iterable<Resolver> iterable) {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        Iterator<Resolver> it = iterable.iterator();
        while (it.hasNext()) {
            this.resolvers.add(new ResolverEntry(it.next()));
        }
    }
}
