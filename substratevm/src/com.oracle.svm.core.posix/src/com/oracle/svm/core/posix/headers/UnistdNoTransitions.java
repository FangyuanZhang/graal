/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.svm.core.posix.headers;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.function.CFunction.Transition;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CCharPointerPointer;
import org.graalvm.word.PointerBase;
import org.graalvm.word.SignedWord;
import org.graalvm.word.UnsignedWord;

import com.oracle.svm.core.annotate.Uninterruptible;

// Checkstyle: stop

/**
 * Variants of {@link Unistd} functions that can be used from {@link Uninterruptible} methods
 * because they have {@link Transition#NO_TRANSITION} set.
 */
@CContext(PosixDirectives.class)
public class UnistdNoTransitions {

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native void _exit(int status);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int chdir(CCharPointer path);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int close(int fd);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int dup2(int fd, int fd2);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int execve(CCharPointer path, CCharPointerPointer argv, CCharPointerPointer envp);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int fork();

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native int fsync(int fd);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native SignedWord write(int fd, PointerBase buf, UnsignedWord n);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native long sysconf(int name);

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native SignedWord lseek(int fd, SignedWord offset, int whence);

}
