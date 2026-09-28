package kotlin.io;

import com.google.android.gms.common.api.Api;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: classes.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a, reason: collision with root package name */
    public final File f53724a;

    /* renamed from: b, reason: collision with root package name */
    public final FileWalkDirection f53725b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f53726c;

    /* renamed from: d, reason: collision with root package name */
    public final Function1 f53727d;

    /* renamed from: e, reason: collision with root package name */
    public final Function2 f53728e;

    /* renamed from: f, reason: collision with root package name */
    public final int f53729f;

    @Metadata
    @SourceDebugExtension
    public static abstract class DirectoryState extends WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        }
    }

    @Metadata
    public final class FileTreeWalkIterator extends AbstractIterator<File> {

        /* renamed from: c, reason: collision with root package name */
        public final ArrayDeque f53730c;

        @Metadata
        public final class BottomUpDirectoryState extends DirectoryState {

            /* renamed from: b, reason: collision with root package name */
            public boolean f53732b;

            /* renamed from: c, reason: collision with root package name */
            public File[] f53733c;

            /* renamed from: d, reason: collision with root package name */
            public int f53734d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f53735e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ FileTreeWalkIterator f53736f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.f53736f = fileTreeWalkIterator;
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.io.File a() {
                /*
                    r11 = this;
                    boolean r0 = r11.f53735e
                    r1 = 0
                    r2 = 1
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r3 = r11.f53736f
                    java.io.File r4 = r11.f53742a
                    if (r0 != 0) goto L40
                    java.io.File[] r0 = r11.f53733c
                    if (r0 != 0) goto L40
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = r0.f53726c
                    if (r0 == 0) goto L21
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L21
                    goto L65
                L21:
                    java.io.File[] r0 = r4.listFiles()
                    r11.f53733c = r0
                    if (r0 != 0) goto L40
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = r0.f53728e
                    if (r0 == 0) goto L3e
                    kotlin.io.AccessDeniedException r5 = new kotlin.io.AccessDeniedException
                    r7 = 0
                    java.lang.String r8 = "Cannot list files in a directory"
                    java.io.File r6 = r11.f53742a
                    r9 = 2
                    r10 = 0
                    r5.<init>(r6, r7, r8, r9, r10)
                    r0.invoke(r4, r5)
                L3e:
                    r11.f53735e = r2
                L40:
                    java.io.File[] r0 = r11.f53733c
                    if (r0 == 0) goto L55
                    int r5 = r11.f53734d
                    int r6 = r0.length
                    if (r5 >= r6) goto L55
                    kotlin.jvm.internal.Intrinsics.c(r0)
                    int r1 = r11.f53734d
                    int r2 = r1 + 1
                    r11.f53734d = r2
                    r0 = r0[r1]
                    return r0
                L55:
                    boolean r0 = r11.f53732b
                    if (r0 != 0) goto L5c
                    r11.f53732b = r2
                    return r4
                L5c:
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = r0.f53727d
                    if (r0 == 0) goto L65
                    r0.invoke(r4)
                L65:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState.a():java.io.File");
            }
        }

        @Metadata
        @SourceDebugExtension
        /* loaded from: classes3.dex */
        public final class SingleFileState extends WalkState {

            /* renamed from: b, reason: collision with root package name */
            public boolean f53737b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(File rootFile) {
                super(rootFile);
                Intrinsics.checkNotNullParameter(rootFile, "rootFile");
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File a() {
                if (this.f53737b) {
                    return null;
                }
                this.f53737b = true;
                return this.f53742a;
            }
        }

        @Metadata
        /* loaded from: classes3.dex */
        public final class TopDownDirectoryState extends DirectoryState {

            /* renamed from: b, reason: collision with root package name */
            public boolean f53738b;

            /* renamed from: c, reason: collision with root package name */
            public File[] f53739c;

            /* renamed from: d, reason: collision with root package name */
            public int f53740d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ FileTreeWalkIterator f53741e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.f53741e = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File a() {
                Function2 function2;
                boolean z = this.f53738b;
                FileTreeWalkIterator fileTreeWalkIterator = this.f53741e;
                File file = this.f53742a;
                if (z) {
                    File[] fileArr = this.f53739c;
                    if (fileArr == null || this.f53740d < fileArr.length) {
                        if (fileArr == null) {
                            File[] fileArrListFiles = file.listFiles();
                            this.f53739c = fileArrListFiles;
                            if (fileArrListFiles == null && (function2 = FileTreeWalk.this.f53728e) != null) {
                                function2.invoke(file, new AccessDeniedException(this.f53742a, null, "Cannot list files in a directory", 2, null));
                            }
                            File[] fileArr2 = this.f53739c;
                            if (fileArr2 == null || fileArr2.length == 0) {
                                Function1 function1 = FileTreeWalk.this.f53727d;
                                if (function1 != null) {
                                    function1.invoke(file);
                                }
                            }
                        }
                        File[] fileArr3 = this.f53739c;
                        Intrinsics.c(fileArr3);
                        int i2 = this.f53740d;
                        this.f53740d = i2 + 1;
                        return fileArr3[i2];
                    }
                    Function1 function12 = FileTreeWalk.this.f53727d;
                    if (function12 != null) {
                        function12.invoke(file);
                        return null;
                    }
                } else {
                    Function1 function13 = FileTreeWalk.this.f53726c;
                    if (function13 == null || ((Boolean) function13.invoke(file)).booleanValue()) {
                        this.f53738b = true;
                        return file;
                    }
                }
                return null;
            }
        }

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    FileWalkDirection fileWalkDirection = FileWalkDirection.f53743a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f53730c = arrayDeque;
            boolean zIsDirectory = FileTreeWalk.this.f53724a.isDirectory();
            File file = FileTreeWalk.this.f53724a;
            if (zIsDirectory) {
                arrayDeque.push(b(file));
            } else if (file.isFile()) {
                arrayDeque.push(new SingleFileState(file));
            } else {
                this.f53582a = 2;
            }
        }

        @Override // kotlin.collections.AbstractIterator
        public final void a() {
            File file;
            File fileA;
            while (true) {
                ArrayDeque arrayDeque = this.f53730c;
                WalkState walkState = (WalkState) arrayDeque.peek();
                if (walkState == null) {
                    file = null;
                    break;
                }
                fileA = walkState.a();
                if (fileA == null) {
                    arrayDeque.pop();
                } else if (fileA.equals(walkState.f53742a) || !fileA.isDirectory() || arrayDeque.size() >= FileTreeWalk.this.f53729f) {
                    break;
                } else {
                    arrayDeque.push(b(fileA));
                }
            }
            file = fileA;
            if (file == null) {
                this.f53582a = 2;
            } else {
                this.f53583b = file;
                this.f53582a = 1;
            }
        }

        public final DirectoryState b(File file) {
            int iOrdinal = FileTreeWalk.this.f53725b.ordinal();
            if (iOrdinal == 0) {
                return new TopDownDirectoryState(this, file);
            }
            if (iOrdinal == 1) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata
    public static abstract class WalkState {

        /* renamed from: a, reason: collision with root package name */
        public final File f53742a;

        public WalkState(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.f53742a = root;
        }

        public abstract File a();
    }

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        fileWalkDirection = (i3 & 2) != 0 ? FileWalkDirection.f53743a : fileWalkDirection;
        i2 = (i3 & 32) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i2;
        this.f53724a = file;
        this.f53725b = fileWalkDirection;
        this.f53726c = function1;
        this.f53727d = function12;
        this.f53728e = function2;
        this.f53729f = i2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new FileTreeWalkIterator();
    }
}
