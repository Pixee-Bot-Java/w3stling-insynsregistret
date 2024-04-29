/*
 * MIT License
 *
 * Copyright (c) 2022, Apptastic Software
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.apptasticsoftware.insynsregistret;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * Class that represents the free text query. It is used when searching for issuer names and person discharging managerial responsibilities (PDMR) names.
 * Object of this class is created via {@link FreeTextQueryBuilder} class.
 */
public class FreeTextQuery {
    private static final String ISSUER_URL = "https://marknadssok.fi.se/Publiceringsklient/sv-SE/AutoComplete/H%C3%A4mtaAutoCompleteListaFull?sokfunktion=Insyn&falt=Utgivare&sokterm=";
    private static final String PDMR_URL = "https://marknadssok.fi.se/Publiceringsklient/sv-SE/AutoComplete/H%C3%A4mtaAutoCompleteListaFull?sokfunktion=Insyn&falt=PersonILedandeSt%C3%A4llningNamn&sokterm=";
    private static final String URL_ENCODING = "UTF-8";
    private String url;

    /**
     * Constructor for free text query.
     * Query either issuer names or PDMR names.
     * @param issuer issuer name
     * @param pdmr person discharging managerial responsibilities (PDMR) name
     * @throws UnsupportedEncodingException exception
     */
    FreeTextQuery(String issuer, String pdmr) throws UnsupportedEncodingException {
        url = "";

        if (issuer != null)
            url = ISSUER_URL + URLEncoder.encode(issuer, URL_ENCODING);
        else if (pdmr != null)
            url = PDMR_URL + URLEncoder.encode(pdmr, URL_ENCODING);
    }

    /**
     * Get the URL for the issuer names and PDMR names query.
     * @return URL
     */
    public String getUrl() {
        return url;
    }
}
