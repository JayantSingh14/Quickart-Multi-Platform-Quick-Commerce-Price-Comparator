package org.xbill.DNS.hosts;

import j$.time.Instant;
import j$.time.TimeConversions;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Address;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;

/* loaded from: classes5.dex */
public final class HostsFileParser {

    @Generated
    private static final Logger log = LoggerFactory.b(HostsFileParser.class);
    private final boolean clearCacheOnChange;
    private final Map<String, InetAddress> hostsCache;
    private boolean isEntireFileParsed;
    private Instant lastFileReadTime;
    private final int maxFullCacheFileSizeBytes;
    private final Path path;

    public static final class LineData {
        final byte[] address;
        final Iterable<? extends Name> names;
        final int type;

        @Generated
        public LineData(int i2, byte[] bArr, Iterable<? extends Name> iterable) {
            this.type = i2;
            this.address = bArr;
            this.names = iterable;
        }
    }

    public HostsFileParser() {
        this(System.getProperty("os.name").contains("Windows") ? Paths.get(System.getenv("SystemRoot"), "\\System32\\drivers\\etc\\hosts") : Paths.get("/etc/hosts", new String[0]), true);
    }

    private String[] getLineTokens(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        return str.substring(0, iIndexOf).trim().split("\\s+");
    }

    private String key(Name name, int i2) {
        return name.toString() + '\t' + i2;
    }

    private void parseEntireHostsFile() throws IOException {
        Path path = this.path;
        Charset charset = StandardCharsets.UTF_8;
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        int i2 = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    bufferedReaderNewBufferedReader.close();
                    this.isEntireFileParsed = true;
                    return;
                }
                i2++;
                LineData line2 = parseLine(i2, line);
                if (line2 != null) {
                    for (Name name : line2.names) {
                        this.hostsCache.putIfAbsent(key(name, line2.type), InetAddress.getByAddress(name.toString(true), line2.address));
                    }
                }
            } catch (Throwable th) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private LineData parseLine(final int i2, String str) {
        String[] lineTokens = getLineTokens(str);
        if (lineTokens.length < 2) {
            return null;
        }
        int i3 = 1;
        byte[] byteArray = Address.toByteArray(lineTokens[0], 1);
        if (byteArray == null) {
            byteArray = Address.toByteArray(lineTokens[0], 2);
            i3 = 28;
        }
        if (byteArray == null) {
            log.e("Could not decode address {}, {}#L{}", lineTokens[0], this.path, Integer.valueOf(i2));
            return null;
        }
        final Stream streamFilter = Arrays.stream(lineTokens).skip(1L).map(new Function() { // from class: org.xbill.DNS.hosts.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f58022a.lambda$parseLine$0(i2, (String) obj);
            }
        }).filter(new org.xbill.DNS.config.a(2));
        Objects.requireNonNull(streamFilter);
        return new LineData(i3, byteArray, new Iterable() { // from class: org.xbill.DNS.hosts.c
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return streamFilter.iterator();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: safeName, reason: merged with bridge method [inline-methods] */
    public Name lambda$parseLine$0(String str, int i2) {
        try {
            return Name.fromString(str, Name.root);
        } catch (TextParseException unused) {
            log.e("Could not decode name {}, {}#L{}, skipping", str, this.path, Integer.valueOf(i2));
            return null;
        }
    }

    private void searchHostsFileForEntry(Name name, int i2) throws IOException {
        Path path = this.path;
        Charset charset = StandardCharsets.UTF_8;
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        int i3 = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    bufferedReaderNewBufferedReader.close();
                    return;
                }
                i3++;
                LineData line2 = parseLine(i3, line);
                if (line2 != null) {
                    for (Name name2 : line2.names) {
                        if (name2.equals(name) && i2 == line2.type) {
                            this.hostsCache.putIfAbsent(key(name2, line2.type), InetAddress.getByAddress(name2.toString(true), line2.address));
                            bufferedReaderNewBufferedReader.close();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private void validateCache() throws IOException {
        if (this.clearCacheOnChange) {
            Instant instantConvert = Files.exists(this.path, new LinkOption[0]) ? TimeConversions.convert(Files.getLastModifiedTime(this.path, new LinkOption[0]).toInstant()) : Instant.MAX;
            if (instantConvert.isAfter(this.lastFileReadTime)) {
                if (!this.hostsCache.isEmpty()) {
                    log.l(instantConvert);
                    this.hostsCache.clear();
                }
                this.isEntireFileParsed = false;
                this.lastFileReadTime = instantConvert;
            }
        }
    }

    public int cacheSize() {
        return this.hostsCache.size();
    }

    public synchronized Optional<InetAddress> getAddressForHost(Name name, int i2) throws IOException {
        try {
            Objects.requireNonNull(name, "name is required");
            if (i2 != 1 && i2 != 28) {
                throw new IllegalArgumentException("type can only be A or AAAA");
            }
            validateCache();
            InetAddress inetAddress = this.hostsCache.get(key(name, i2));
            if (inetAddress != null) {
                return Optional.of(inetAddress);
            }
            if (!this.isEntireFileParsed && Files.exists(this.path, new LinkOption[0])) {
                if (Files.size(this.path) <= this.maxFullCacheFileSizeBytes) {
                    parseEntireHostsFile();
                } else {
                    searchHostsFileForEntry(name, i2);
                }
                return Optional.ofNullable(this.hostsCache.get(key(name, i2)));
            }
            return Optional.empty();
        } catch (Throwable th) {
            throw th;
        }
    }

    public HostsFileParser(Path path) {
        this(path, true);
    }

    public HostsFileParser(Path path, boolean z) {
        this.maxFullCacheFileSizeBytes = Integer.parseInt(System.getProperty("dnsjava.hostsfile.max_size_bytes", "16384"));
        this.hostsCache = new HashMap();
        this.lastFileReadTime = Instant.MIN;
        Objects.requireNonNull(path, "path is required");
        this.path = com.horcrux.svg.b.k(path);
        this.clearCacheOnChange = z;
        if (Files.isDirectory(path, new LinkOption[0])) {
            throw new IllegalArgumentException("path must be a file");
        }
    }
}
