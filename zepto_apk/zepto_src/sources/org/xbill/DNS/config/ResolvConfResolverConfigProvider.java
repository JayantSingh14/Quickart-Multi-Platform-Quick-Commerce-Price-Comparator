package org.xbill.DNS.config;

import in.juspay.hyper.constants.LogSubCategory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/* loaded from: classes5.dex */
public class ResolvConfResolverConfigProvider extends BaseResolverConfigProvider {
    private int ndots = 1;

    private boolean tryParseResolveConf(String str) throws IOException {
        Path path = Paths.get(str, new String[0]);
        if (Files.exists(path, new LinkOption[0])) {
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    parseResolvConf(inputStreamNewInputStream);
                    if (inputStreamNewInputStream != null) {
                        inputStreamNewInputStream.close();
                    }
                    return true;
                } finally {
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws IOException {
        reset();
        if (tryParseResolveConf("/etc/resolv.conf")) {
            return;
        }
        tryParseResolveConf("sys:/etc/resolv.cfg");
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return (System.getProperty("os.name").contains("Windows") || System.getProperty("java.specification.vendor").toLowerCase().contains(LogSubCategory.LifeCycle.ANDROID)) ? false : true;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public int ndots() {
        return this.ndots;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseResolvConf(java.io.InputStream r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.config.ResolvConfResolverConfigProvider.parseResolvConf(java.io.InputStream):void");
    }
}
