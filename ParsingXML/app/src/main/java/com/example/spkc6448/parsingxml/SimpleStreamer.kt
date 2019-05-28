package com.example.spkc6448.parsingxml

import com.novoda.sax.RootElement
import com.novoda.sexp.RootTag
import com.novoda.sexp.Streamer
import com.novoda.sexp.finder.ElementFinder

class SimpleStreamer(val elementFinder: ElementFinder<String>, val elementTag: String) : Streamer<String> {

    override fun getStreamResult(): String {
        return elementFinder.resultOrThrow
    }

    override fun getRootTag(): RootTag {
        return RootTag.create("novoda")
    }

    override fun stream(rootElement: RootElement) {
        elementFinder.find(rootElement, elementTag)
    }
}
