package com.phoenix;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
