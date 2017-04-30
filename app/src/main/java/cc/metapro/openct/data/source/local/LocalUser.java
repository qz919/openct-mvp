package cc.metapro.openct.data.source.local;

/*
 *  Copyright 2016 - 2017 OpenCT open source class table
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.text.TextUtils;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

import cc.metapro.openct.utils.Constants;

public class LocalUser {

    private String username;
    private String password;

    LocalUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() throws GeneralSecurityException {
        return AESCrypt.decrypt(Constants.seed, password);
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(username) || TextUtils.isEmpty(password);
    }
}