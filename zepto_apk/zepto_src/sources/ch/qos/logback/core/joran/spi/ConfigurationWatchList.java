package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.spi.ContextAwareBase;
import coil3.util.UtilsKt;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ConfigurationWatchList extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public URL f13548d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f13549e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f13550f = new ArrayList();

    public final void T1(URL url) {
        File file;
        if (UtilsKt.SCHEME_FILE.equals(url.getProtocol())) {
            file = new File(URLDecoder.decode(url.getFile()));
        } else {
            s1("URL [" + url + "] is not of type file");
            file = null;
        }
        if (file != null) {
            this.f13549e.add(file);
            this.f13550f.add(Long.valueOf(file.lastModified()));
        }
    }

    public final boolean U1() {
        int size = this.f13549e.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((Long) this.f13550f.get(i2)).longValue() != ((File) this.f13549e.get(i2)).lastModified()) {
                return true;
            }
        }
        return false;
    }
}
