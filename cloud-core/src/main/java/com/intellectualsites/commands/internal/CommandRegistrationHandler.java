//
// MIT License
//
// Copyright (c) 2020 Alexander Söderberg
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package com.intellectualsites.commands.internal;

import com.intellectualsites.commands.Command;
import com.intellectualsites.commands.meta.CommandMeta;

import javax.annotation.Nonnull;

/**
 * Utility that registers commands natively for whatever
 * platform the library is used in. This can do nothing, if
 * the target platform does not have its own concept of commands
 *
 * @param <M> Command meta type
 */
@FunctionalInterface
public interface CommandRegistrationHandler<M extends CommandMeta> {

    /**
     * Attempt to register the command
     *
     * @param command Command to register
     * @return {@code true} if the command was registered successfully,
     * else {@code false}
     */
    boolean registerCommand(@Nonnull Command<?, M> command);

    /**
     * Create a new {@link CommandRegistrationHandler} that does nothing
     *
     * @param <M> Command meta type
     * @return Constructed registration
     */
    static <M extends CommandMeta> CommandRegistrationHandler<M> nullCommandRegistrationHandler() {
        return new NullCommandRegistrationHandler<>();
    }


    final class NullCommandRegistrationHandler<M extends CommandMeta> implements CommandRegistrationHandler<M> {

        private NullCommandRegistrationHandler() {
        }

        @Override
        public boolean registerCommand(@Nonnull final Command<?, M> command) {
            return true;
        }

    }

}
