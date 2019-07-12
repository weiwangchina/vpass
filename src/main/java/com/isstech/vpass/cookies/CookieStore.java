package com.isstech.vpass.cookies;

/**
 * @author wangwei<br />
 * @Description: <br/>
 * @date 2019/5/15 15:04<br/>
 * ${TAGS}
 */
/*
 * Copyright (C) 2016-2017 mzlion(mzllon@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import okhttp3.Cookie;
import okhttp3.HttpUrl;

import java.util.List;

/**
 * Defining Cookie Storage Mechanism
 *
 * @author mzlion on 2016/4/17.
 */
public interface CookieStore {

    /**
     * Add a cookie for the request address {@code url}
     *
     * @param uri     request address
     * @param cookies Cookie list
     * @see Cookie
     */
    void add(HttpUrl uri, List<Cookie> cookies);

    /**
     * Get a list of cookies for a requested address
     *
     * @param uri request address
     * @return Cookie list
     * @see Cookie
     */
    List<Cookie> get(HttpUrl uri);

    /**
     * Get all the list of cookies
     *
     * @return {@link Cookie}
     */
    List<Cookie> getCookies();

    /**
     * Deleting a cookie for the request
     *
     * @param uri    request address
     * @param cookie Cookie object
     * @return {@code true} if successful, otherwise {@code false}
     */
    boolean remove(HttpUrl uri, Cookie cookie);

    /**
     * Clear all cookies list
     *
     * @return {@code true} if empty, otherwise {@code false}
     */
    boolean removeAll();

}

