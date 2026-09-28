package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public enum zzgqq {
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VERSION("java.version"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VENDOR("java.vendor"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VENDOR_URL("java.vendor.url"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_HOME("java.home"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_VERSION("java.vm.version"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_VENDOR("java.vm.vendor"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_VM_NAME("java.vm.name"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_SPECIFICATION_VERSION("java.specification.version"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_SPECIFICATION_NAME("java.specification.name"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_CLASS_VERSION("java.class.version"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_CLASS_PATH("java.class.path"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_LIBRARY_PATH("java.library.path"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_IO_TMPDIR("java.io.tmpdir"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_COMPILER("java.compiler"),
    /* JADX INFO: Fake field, exist only in values array */
    JAVA_EXT_DIRS("java.ext.dirs"),
    /* JADX INFO: Fake field, exist only in values array */
    OS_NAME("os.name"),
    /* JADX INFO: Fake field, exist only in values array */
    OS_ARCH("os.arch"),
    /* JADX INFO: Fake field, exist only in values array */
    OS_VERSION("os.version"),
    /* JADX INFO: Fake field, exist only in values array */
    FILE_SEPARATOR("file.separator"),
    /* JADX INFO: Fake field, exist only in values array */
    PATH_SEPARATOR("path.separator"),
    /* JADX INFO: Fake field, exist only in values array */
    LINE_SEPARATOR("line.separator"),
    /* JADX INFO: Fake field, exist only in values array */
    USER_NAME("user.name"),
    /* JADX INFO: Fake field, exist only in values array */
    USER_HOME("user.home"),
    /* JADX INFO: Fake field, exist only in values array */
    USER_DIR("user.dir");


    /* renamed from: a, reason: collision with root package name */
    public final String f33083a;

    zzgqq(String str) {
        this.f33083a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        String str = this.f33083a;
        String property = System.getProperty(str);
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(property).length()), str, "=", property);
    }
}
