package org.xbill.DNS;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.config.AndroidResolverConfigProvider;
import org.xbill.DNS.config.FallbackPropertyResolverConfigProvider;
import org.xbill.DNS.config.InitializationException;
import org.xbill.DNS.config.JndiContextResolverConfigProvider;
import org.xbill.DNS.config.PropertyResolverConfigProvider;
import org.xbill.DNS.config.ResolvConfResolverConfigProvider;
import org.xbill.DNS.config.ResolverConfigProvider;
import org.xbill.DNS.config.SunJvmResolverConfigProvider;
import org.xbill.DNS.config.WindowsResolverConfigProvider;

/* loaded from: classes5.dex */
public final class ResolverConfig {
    public static final String CONFIGPROVIDER_SKIP_INIT = "dnsjava.configprovider.skipinit";
    private static List<ResolverConfigProvider> configProviders;
    private static ResolverConfig currentConfig;

    @Generated
    private static final Logger log = LoggerFactory.b(ResolverConfig.class);
    private int ndots;
    private final List<InetSocketAddress> servers = new ArrayList(2);
    private final List<Name> searchlist = new ArrayList(0);

    public ResolverConfig() {
        this.ndots = 1;
        synchronized (ResolverConfig.class) {
            try {
                if (configProviders == null) {
                    configProviders = new ArrayList(8);
                    if (!Boolean.getBoolean(CONFIGPROVIDER_SKIP_INIT)) {
                        configProviders.add(new PropertyResolverConfigProvider());
                        configProviders.add(new ResolvConfResolverConfigProvider());
                        configProviders.add(new WindowsResolverConfigProvider());
                        configProviders.add(new AndroidResolverConfigProvider());
                        configProviders.add(new JndiContextResolverConfigProvider());
                        configProviders.add(new SunJvmResolverConfigProvider());
                        configProviders.add(new FallbackPropertyResolverConfigProvider());
                    }
                }
            } finally {
            }
        }
        for (ResolverConfigProvider resolverConfigProvider : configProviders) {
            if (resolverConfigProvider.isEnabled()) {
                try {
                    resolverConfigProvider.initialize();
                    if (this.servers.isEmpty()) {
                        this.servers.addAll(resolverConfigProvider.servers());
                    }
                    if (this.searchlist.isEmpty()) {
                        List<Name> listSearchPaths = resolverConfigProvider.searchPaths();
                        if (!listSearchPaths.isEmpty()) {
                            this.searchlist.addAll(listSearchPaths);
                            this.ndots = resolverConfigProvider.ndots();
                        }
                    }
                    if (!this.servers.isEmpty() && !this.searchlist.isEmpty()) {
                        return;
                    }
                } catch (InitializationException e2) {
                    log.t("Failed to initialize provider", e2);
                }
            }
        }
        if (this.servers.isEmpty()) {
            this.servers.add(new InetSocketAddress(InetAddress.getLoopbackAddress(), 53));
        }
    }

    private static void checkInitialized() {
        if (currentConfig == null || configProviders == null) {
            refresh();
        }
    }

    public static synchronized List<ResolverConfigProvider> getConfigProviders() {
        checkInitialized();
        return Collections.unmodifiableList(configProviders);
    }

    public static synchronized ResolverConfig getCurrentConfig() {
        checkInitialized();
        return currentConfig;
    }

    public static void refresh() {
        ResolverConfig resolverConfig = new ResolverConfig();
        synchronized (ResolverConfig.class) {
            currentConfig = resolverConfig;
        }
    }

    public static synchronized void setConfigProviders(List<ResolverConfigProvider> list) {
        configProviders = new ArrayList(list);
    }

    public int ndots() {
        return this.ndots;
    }

    public List<Name> searchPath() {
        return this.searchlist;
    }

    public InetSocketAddress server() {
        return this.servers.get(0);
    }

    public List<InetSocketAddress> servers() {
        return this.servers;
    }
}
