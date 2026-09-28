package okio.internal;

import coil3.util.UtilsKt;
import io.sentry.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ResourceFileSystem extends FileSystem {

    /* renamed from: d, reason: collision with root package name */
    public static final Path f57041d;

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f57042a;

    /* renamed from: b, reason: collision with root package name */
    public final FileSystem f57043b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f57044c;

    @Metadata
    public static final class Companion {
        public static final boolean a(Path path) {
            Path path2 = ResourceFileSystem.f57041d;
            return !StringsKt.r(path.b(), ".class", true);
        }

        public static Path b(Path path, Path base) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            return ResourceFileSystem.f57041d.e(StringsKt.J(StringsKt.F(path.f56973a.z(), base.f56973a.z()), '\\', '/'));
        }
    }

    static {
        String str = Path.f56972b;
        f57041d = Path.Companion.a("/", false);
    }

    public ResourceFileSystem(ClassLoader classLoader) {
        FileSystem systemFileSystem = FileSystem.SYSTEM;
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(systemFileSystem, "systemFileSystem");
        this.f57042a = classLoader;
        this.f57043b = systemFileSystem;
        this.f57044c = LazyKt.b(new Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws IOException {
                FileSystem fileSystem;
                int iC;
                Pair pair;
                ResourceFileSystem resourceFileSystem = this.f57045c;
                ClassLoader classLoader2 = resourceFileSystem.f57042a;
                Enumeration<URL> resources = classLoader2.getResources("");
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                ArrayList list = Collections.list(resources);
                Intrinsics.checkNotNullExpressionValue(list, "list(...)");
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    fileSystem = resourceFileSystem.f57043b;
                    Pair pair2 = null;
                    if (!zHasNext) {
                        break;
                    }
                    URL url = (URL) it.next();
                    Intrinsics.c(url);
                    if (Intrinsics.b(url.getProtocol(), UtilsKt.SCHEME_FILE)) {
                        String str = Path.f56972b;
                        pair2 = new Pair(fileSystem, Path.Companion.b(new File(url.toURI())));
                    }
                    if (pair2 != null) {
                        arrayList.add(pair2);
                    }
                }
                Enumeration<URL> resources2 = classLoader2.getResources("META-INF/MANIFEST.MF");
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                ArrayList<URL> list2 = Collections.list(resources2);
                Intrinsics.checkNotNullExpressionValue(list2, "list(...)");
                ArrayList arrayList2 = new ArrayList();
                for (URL url2 : list2) {
                    Intrinsics.c(url2);
                    String string = url2.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    if (StringsKt.O(string, "jar:file:", false) && (iC = StringsKt.C(string, "!", 0, 6)) != -1) {
                        String str2 = Path.f56972b;
                        String strSubstring = string.substring(4, iC);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        pair = new Pair(ZipFilesKt.c(Path.Companion.b(new File(URI.create(strSubstring))), fileSystem, ResourceFileSystem$toJarRoot$zip$1.f57046c), ResourceFileSystem.f57041d);
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        arrayList2.add(pair);
                    }
                }
                return CollectionsKt.L(arrayList, arrayList2);
            }
        });
    }

    public static String a(Path child) {
        Path path = f57041d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        return Path.b(path, child, true).d(path).f56973a.z();
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final Path canonicalize(Path child) {
        Intrinsics.checkNotNullParameter(child, "path");
        Path path = f57041d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        return Path.b(path, child, true);
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path dir) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String strA = a(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : (List) this.f57044c.getValue()) {
            FileSystem fileSystem = (FileSystem) pair.f53533a;
            Path path = (Path) pair.f53534b;
            try {
                List list = fileSystem.list(path.e(strA));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.a((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.b((Path) it.next(), path));
                }
                CollectionsKt.i(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.e0(linkedHashSet);
        }
        throw new FileNotFoundException(a.a(dir, "file not found: "));
    }

    @Override // okio.FileSystem
    public final List listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String strA = a(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = ((List) this.f57044c.getValue()).iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            FileSystem fileSystem = (FileSystem) pair.f53533a;
            Path path = (Path) pair.f53534b;
            List listListOrNull = fileSystem.listOrNull(path.e(strA));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (Companion.a((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.b((Path) it2.next(), path));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                CollectionsKt.i(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return CollectionsKt.e0(linkedHashSet);
        }
        return null;
    }

    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.a(path)) {
            return null;
        }
        String strA = a(path);
        for (Pair pair : (List) this.f57044c.getValue()) {
            FileMetadata fileMetadataMetadataOrNull = ((FileSystem) pair.f53533a).metadataOrNull(((Path) pair.f53534b).e(strA));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public final FileHandle openReadOnly(Path file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.a(file)) {
            throw new FileNotFoundException(a.a(file, "file not found: "));
        }
        String strA = a(file);
        for (Pair pair : (List) this.f57044c.getValue()) {
            try {
                return ((FileSystem) pair.f53533a).openReadOnly(((Path) pair.f53534b).e(strA));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(a.a(file, "file not found: "));
    }

    @Override // okio.FileSystem
    public final FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public final Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path child) throws IOException {
        Intrinsics.checkNotNullParameter(child, "file");
        if (!Companion.a(child)) {
            throw new FileNotFoundException(a.a(child, "file not found: "));
        }
        Path path = f57041d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        URL resource = this.f57042a.getResource(Path.b(path, child, false).d(path).f56973a.z());
        if (resource == null) {
            throw new FileNotFoundException(a.a(child, "file not found: "));
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        return Okio.m(inputStream);
    }
}
