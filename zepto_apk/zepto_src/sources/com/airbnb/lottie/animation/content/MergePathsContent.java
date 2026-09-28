package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes3.dex */
public class MergePathsContent implements PathContent, GreedyContent {

    /* renamed from: a, reason: collision with root package name */
    public final Path f14272a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f14273b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f14274c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f14275d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final MergePaths f14276e;

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14277a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f14277a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14277a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14277a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14277a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14277a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        mergePaths.getClass();
        this.f14276e = mergePaths;
    }

    public final void a(Path.Op op) {
        Matrix matrixE;
        Matrix matrixE2;
        Path path = this.f14273b;
        path.reset();
        Path path2 = this.f14272a;
        path2.reset();
        ArrayList arrayList = this.f14275d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            PathContent pathContent = (PathContent) arrayList.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                ArrayList arrayList2 = (ArrayList) contentGroup.g();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path pathJ = ((PathContent) arrayList2.get(size2)).j();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.f14237k;
                    if (transformKeyframeAnimation != null) {
                        matrixE2 = transformKeyframeAnimation.e();
                    } else {
                        matrixE2 = contentGroup.f14229c;
                        matrixE2.reset();
                    }
                    pathJ.transform(matrixE2);
                    path.addPath(pathJ);
                }
            } else {
                path.addPath(pathContent.j());
            }
        }
        int i2 = 0;
        PathContent pathContent2 = (PathContent) arrayList.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List listG = contentGroup2.g();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listG;
                if (i2 >= arrayList3.size()) {
                    break;
                }
                Path pathJ2 = ((PathContent) arrayList3.get(i2)).j();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.f14237k;
                if (transformKeyframeAnimation2 != null) {
                    matrixE = transformKeyframeAnimation2.e();
                } else {
                    matrixE = contentGroup2.f14229c;
                    matrixE.reset();
                }
                pathJ2.transform(matrixE);
                path2.addPath(pathJ2);
                i2++;
            }
        } else {
            path2.set(pathContent2.j());
        }
        this.f14274c.op(path2, path, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14275d;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((PathContent) arrayList.get(i2)).b(list, list2);
            i2++;
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void g(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content content = (Content) listIterator.previous();
            if (content instanceof PathContent) {
                this.f14275d.add((PathContent) content);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        Path path = this.f14274c;
        path.reset();
        MergePaths mergePaths = this.f14276e;
        if (!mergePaths.f14547b) {
            int iOrdinal = mergePaths.f14546a.ordinal();
            if (iOrdinal == 0) {
                int i2 = 0;
                while (true) {
                    ArrayList arrayList = this.f14275d;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    path.addPath(((PathContent) arrayList.get(i2)).j());
                    i2++;
                }
            } else {
                if (iOrdinal == 1) {
                    a(Path.Op.UNION);
                    return path;
                }
                if (iOrdinal == 2) {
                    a(Path.Op.REVERSE_DIFFERENCE);
                    return path;
                }
                if (iOrdinal == 3) {
                    a(Path.Op.INTERSECT);
                    return path;
                }
                if (iOrdinal == 4) {
                    a(Path.Op.XOR);
                    return path;
                }
            }
        }
        return path;
    }
}
