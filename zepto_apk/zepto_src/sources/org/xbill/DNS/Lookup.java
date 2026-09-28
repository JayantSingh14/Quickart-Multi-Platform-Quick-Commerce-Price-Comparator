package org.xbill.DNS;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.hosts.HostsFileParser;

/* loaded from: classes5.dex */
public final class Lookup {
    public static final int HOST_NOT_FOUND = 3;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_AGAIN = 2;
    public static final int TYPE_NOT_FOUND = 4;
    public static final int UNRECOVERABLE = 1;
    private static Map<Integer, Cache> defaultCaches;
    private static HostsFileParser defaultHostsFileParser;
    private static int defaultNdots;
    private static Resolver defaultResolver;
    private static List<Name> defaultSearchPath;

    @Generated
    private static final Logger log = LoggerFactory.b(Lookup.class);
    private static final Name[] noAliases = new Name[0];
    private List<Name> aliases;
    private Record[] answers;
    private boolean badresponse;
    private String badresponseError;
    private Cache cache;
    private int credibility;
    private boolean cycleResults;
    private final int dclass;
    private boolean done;
    private boolean doneCurrent;
    private String error;
    private boolean foundAlias;
    private HostsFileParser hostsFileParser;
    private int iterations;
    private final int maxIterations;
    private final Name name;
    private boolean nametoolong;
    private int ndots;
    private boolean networkerror;
    private boolean nxdomain;
    private boolean referral;
    private Resolver resolver;
    private int result;
    private List<Name> searchPath;
    private boolean temporaryCache;
    private boolean timedout;
    private final int type;

    static {
        refreshDefault();
    }

    public Lookup(Name name, int i2, int i3) {
        this.cycleResults = true;
        Type.check(i2);
        DClass.check(i3);
        if (!Type.isRR(i2) && i2 != 255) {
            throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
        }
        this.name = name;
        this.type = i2;
        this.dclass = i3;
        synchronized (Lookup.class) {
            this.resolver = getDefaultResolver();
            this.searchPath = getDefaultSearchPath();
            this.cache = getDefaultCache(i3);
        }
        this.ndots = defaultNdots;
        this.credibility = 3;
        this.result = -1;
        this.maxIterations = Integer.parseInt(System.getProperty("dnsjava.lookup.max_iterations", "16"));
        if (Boolean.parseBoolean(System.getProperty("dnsjava.lookup.use_hosts_file", "true"))) {
            this.hostsFileParser = getDefaultHostsFileParser();
        }
    }

    private void checkDone() {
        if (!this.done || this.result == -1) {
            StringBuilder sb = new StringBuilder("Lookup of " + this.name + StringUtils.SPACE);
            int i2 = this.dclass;
            if (i2 != 1) {
                sb.append(DClass.string(i2));
                sb.append(StringUtils.SPACE);
            }
            sb.append(Type.string(this.type));
            sb.append(" isn't done");
            throw new IllegalStateException(sb.toString());
        }
    }

    private static List<Name> convertSearchPathDomainList(List<Name> list) {
        try {
            return (List) list.stream().map(new i(6)).collect(Collectors.toList());
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof NameTooLongException) {
                throw new IllegalArgumentException(e2.getCause());
            }
            throw e2;
        }
    }

    private void follow(Name name, Name name2) {
        this.foundAlias = true;
        this.badresponse = false;
        this.networkerror = false;
        this.timedout = false;
        this.nxdomain = false;
        this.referral = false;
        int i2 = this.iterations + 1;
        this.iterations = i2;
        if (i2 >= this.maxIterations || name.equals(name2)) {
            this.result = 1;
            this.error = "CNAME loop";
            this.done = true;
        } else {
            if (this.aliases == null) {
                this.aliases = new ArrayList();
            }
            this.aliases.add(name2);
            lookup(name);
        }
    }

    public static synchronized Cache getDefaultCache(int i2) {
        Cache cache;
        DClass.check(i2);
        cache = defaultCaches.get(Integer.valueOf(i2));
        if (cache == null) {
            cache = new Cache(i2);
            defaultCaches.put(Integer.valueOf(i2), cache);
        }
        return cache;
    }

    public static synchronized HostsFileParser getDefaultHostsFileParser() {
        return defaultHostsFileParser;
    }

    public static synchronized Resolver getDefaultResolver() {
        return defaultResolver;
    }

    public static synchronized List<Name> getDefaultSearchPath() {
        return defaultSearchPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Name lambda$convertSearchPathDomainList$0(Name name) {
        try {
            return Name.concatenate(name, Name.root);
        } catch (NameTooLongException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void lookup(Name name) {
        if (lookupFromHostsFile(name)) {
            return;
        }
        SetResponse setResponseLookupRecords = this.cache.lookupRecords(name, this.type, this.credibility);
        Logger logger = log;
        logger.g("Lookup for {}/{}, cache answer: {}", name, Type.string(this.type), setResponseLookupRecords);
        processResponse(name, setResponseLookupRecords);
        if (this.done || this.doneCurrent) {
            return;
        }
        Message messageNewQuery = Message.newQuery(Record.newRecord(name, this.type, this.dclass));
        try {
            Message messageNormalize = this.resolver.send(messageNewQuery).normalize(messageNewQuery);
            int rcode = messageNormalize.getHeader().getRcode();
            if (rcode != 0 && rcode != 3) {
                this.badresponse = true;
                this.badresponseError = Rcode.string(rcode);
            } else {
                if (!messageNewQuery.getQuestion().equals(messageNormalize.getQuestion())) {
                    this.badresponse = true;
                    this.badresponseError = "response does not match query";
                    return;
                }
                SetResponse setResponseAddMessage = this.cache.addMessage(messageNormalize);
                if (setResponseAddMessage == null) {
                    setResponseAddMessage = this.cache.lookupRecords(name, this.type, this.credibility);
                }
                logger.g("Queried {}/{}, id={}: {}", name, Type.string(this.type), Integer.valueOf(messageNormalize.getHeader().getID()), setResponseAddMessage);
                processResponse(name, setResponseAddMessage);
            }
        } catch (IOException e2) {
            log.g("Lookup for {}/{}, id={} failed using resolver {}", name, Type.string(messageNewQuery.getQuestion().getType()), Integer.valueOf(messageNewQuery.getHeader().getID()), this.resolver, e2);
            if (e2 instanceof InterruptedIOException) {
                this.timedout = true;
            } else {
                this.networkerror = true;
            }
        }
    }

    private boolean lookupFromHostsFile(Name name) {
        int i2;
        HostsFileParser hostsFileParser = this.hostsFileParser;
        if (hostsFileParser != null && ((i2 = this.type) == 1 || i2 == 28)) {
            try {
                Optional<InetAddress> addressForHost = hostsFileParser.getAddressForHost(name, i2);
                if (addressForHost.isPresent()) {
                    this.result = 0;
                    this.done = true;
                    if (this.type == 1) {
                        this.answers = new ARecord[]{new ARecord(name, this.dclass, 0L, addressForHost.get())};
                        return true;
                    }
                    this.answers = new AAAARecord[]{new AAAARecord(name, this.dclass, 0L, addressForHost.get())};
                    return true;
                }
            } catch (IOException e2) {
                log.a("Local hosts database parsing failed, ignoring and using resolver", e2);
            }
        }
        return false;
    }

    private void processResponse(Name name, SetResponse setResponse) {
        if (setResponse.isSuccessful()) {
            List<RRset> listAnswers = setResponse.answers();
            ArrayList arrayList = new ArrayList();
            Iterator<RRset> it = listAnswers.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().rrs(this.cycleResults));
            }
            this.result = 0;
            this.answers = (Record[]) arrayList.toArray(new Record[0]);
            this.done = true;
            return;
        }
        if (setResponse.isNXDOMAIN()) {
            this.nxdomain = true;
            this.doneCurrent = true;
            if (this.iterations > 0) {
                this.result = 3;
                this.done = true;
                return;
            }
            return;
        }
        if (setResponse.isNXRRSET()) {
            this.result = 4;
            this.answers = null;
            this.done = true;
        } else {
            if (setResponse.isCNAME()) {
                follow(setResponse.getCNAME().getTarget(), name);
                return;
            }
            if (!setResponse.isDNAME()) {
                if (setResponse.isDelegation()) {
                    this.referral = true;
                }
            } else {
                try {
                    follow(name.fromDNAME(setResponse.getDNAME()), name);
                } catch (NameTooLongException unused) {
                    this.result = 1;
                    this.error = "Invalid DNAME target";
                    this.done = true;
                }
            }
        }
    }

    public static synchronized void refreshDefault() {
        defaultResolver = new ExtendedResolver();
        defaultSearchPath = ResolverConfig.getCurrentConfig().searchPath();
        defaultCaches = new HashMap();
        defaultNdots = ResolverConfig.getCurrentConfig().ndots();
        defaultHostsFileParser = new HostsFileParser();
    }

    private void reset() {
        this.iterations = 0;
        this.foundAlias = false;
        this.done = false;
        this.doneCurrent = false;
        this.aliases = null;
        this.answers = null;
        this.result = -1;
        this.error = null;
        this.nxdomain = false;
        this.badresponse = false;
        this.badresponseError = null;
        this.networkerror = false;
        this.timedout = false;
        this.nametoolong = false;
        this.referral = false;
        if (this.temporaryCache) {
            this.cache.clearCache();
        }
    }

    private void resolve(Name name, Name name2) {
        this.doneCurrent = false;
        if (name2 != null) {
            try {
                name = Name.concatenate(name, name2);
            } catch (NameTooLongException unused) {
                this.nametoolong = true;
                return;
            }
        }
        lookup(name);
    }

    public static synchronized void setDefaultCache(Cache cache, int i2) {
        DClass.check(i2);
        defaultCaches.put(Integer.valueOf(i2), cache);
    }

    public static synchronized void setDefaultHostsFileParser(HostsFileParser hostsFileParser) {
        defaultHostsFileParser = hostsFileParser;
    }

    public static void setDefaultNdots(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Illegal ndots value: "));
        }
        defaultNdots = i2;
    }

    public static synchronized void setDefaultResolver(Resolver resolver) {
        defaultResolver = resolver;
    }

    public static synchronized void setDefaultSearchPath(List<Name> list) {
        defaultSearchPath = convertSearchPathDomainList(list);
    }

    public static synchronized void setPacketLogger(PacketLogger packetLogger) {
        NioClient.setPacketLogger(packetLogger);
    }

    public Name[] getAliases() {
        checkDone();
        List<Name> list = this.aliases;
        return list == null ? noAliases : (Name[]) list.toArray(new Name[0]);
    }

    public Record[] getAnswers() {
        checkDone();
        return this.answers;
    }

    public String getErrorString() {
        checkDone();
        String str = this.error;
        if (str != null) {
            return str;
        }
        int i2 = this.result;
        if (i2 == 0) {
            return "successful";
        }
        if (i2 == 1) {
            return "unrecoverable error";
        }
        if (i2 == 2) {
            return "try again";
        }
        if (i2 == 3) {
            return "host not found";
        }
        if (i2 == 4) {
            return "type not found";
        }
        throw new IllegalStateException("unknown result");
    }

    @Generated
    public HostsFileParser getHostsFileParser() {
        return this.hostsFileParser;
    }

    public int getResult() {
        checkDone();
        return this.result;
    }

    public Record[] run() {
        if (this.done) {
            reset();
        }
        if (this.name.isAbsolute()) {
            resolve(this.name, null);
        } else if (this.searchPath == null) {
            resolve(this.name, Name.root);
        } else {
            if (this.name.labels() > this.ndots) {
                resolve(this.name, Name.root);
            }
            if (this.done) {
                return this.answers;
            }
            Iterator<Name> it = this.searchPath.iterator();
            while (it.hasNext()) {
                resolve(this.name, it.next());
                if (this.done) {
                    return this.answers;
                }
                if (this.foundAlias) {
                    break;
                }
            }
            resolve(this.name, Name.root);
        }
        if (!this.done) {
            if (this.badresponse) {
                this.result = 2;
                this.error = this.badresponseError;
                this.done = true;
            } else if (this.timedout) {
                this.result = 2;
                this.error = "timed out";
                this.done = true;
            } else if (this.networkerror) {
                this.result = 2;
                this.error = "network error";
                this.done = true;
            } else if (this.nxdomain) {
                this.result = 3;
                this.done = true;
            } else if (this.referral) {
                this.result = 1;
                this.error = "referral";
                this.done = true;
            } else if (this.nametoolong) {
                this.result = 1;
                this.error = "name too long";
                this.done = true;
            }
        }
        return this.answers;
    }

    public void setCache(Cache cache) {
        if (cache == null) {
            this.cache = new Cache(this.dclass);
            this.temporaryCache = true;
        } else {
            if (cache.getDClass() != this.dclass) {
                throw new IllegalArgumentException("DClass of cache doesn't match DClass of this Lookup instance");
            }
            this.cache = cache;
            this.temporaryCache = false;
        }
    }

    public void setCredibility(int i2) {
        this.credibility = i2;
    }

    public void setCycleResults(boolean z) {
        this.cycleResults = z;
    }

    @Generated
    public void setHostsFileParser(HostsFileParser hostsFileParser) {
        this.hostsFileParser = hostsFileParser;
    }

    public void setNdots(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Illegal ndots value: "));
        }
        this.ndots = i2;
    }

    public void setResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public void setSearchPath(List<Name> list) {
        this.searchPath = convertSearchPathDomainList(list);
    }

    public void setSearchPath(Name... nameArr) {
        setSearchPath(Arrays.asList(nameArr));
    }

    public static synchronized void setDefaultSearchPath(Name... nameArr) {
        setDefaultSearchPath((List<Name>) Arrays.asList(nameArr));
    }

    public void setSearchPath(String... strArr) throws TextParseException {
        if (strArr == null) {
            this.searchPath = null;
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Name.fromString(str, Name.root));
        }
        this.searchPath = arrayList;
    }

    public static synchronized void setDefaultSearchPath(String... strArr) throws TextParseException {
        if (strArr == null) {
            defaultSearchPath = null;
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Name.fromString(str, Name.root));
        }
        defaultSearchPath = arrayList;
    }

    public Lookup(Name name, int i2) {
        this(name, i2, 1);
    }

    public Lookup(Name name) {
        this(name, 1, 1);
    }

    public Lookup(String str, int i2, int i3) throws TextParseException {
        this(Name.fromString(str), i2, i3);
    }

    public Lookup(String str, int i2) throws TextParseException {
        this(Name.fromString(str), i2, 1);
    }

    public Lookup(String str) throws TextParseException {
        this(Name.fromString(str), 1, 1);
    }
}
