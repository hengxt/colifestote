/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.architecture.response;

public class ResponseStatus {

    private String code = "";
    private boolean success = true;
    private Enum source = ResultSource.NETWORK;

    public ResponseStatus() {
    }

    public ResponseStatus(String code, boolean success) {
        this.code = code;
        this.success = success;
    }

    public ResponseStatus(String code, boolean success, Enum source) {
        this(code, success);
        this.source = source;
    }

    public String getResponseCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public Enum getSource() {
        return source;
    }
}
