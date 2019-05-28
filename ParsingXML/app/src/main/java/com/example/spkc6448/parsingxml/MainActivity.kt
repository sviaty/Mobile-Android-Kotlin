package com.example.spkc6448.parsingxml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.novoda.sexp.SimpleEasyXmlParser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val XML = "<novoda>" +
                "<favouriteColour>Blue</favouriteColour>" +
                "</novoda>"

        val XML2 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<WTResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"wt.xsd\">" +
                "   <identifiers>" +
                "       <ident name=\"ID1\" value=\"8dcadeda-0723-1037-975c-005056a44b3b\"/>" +
                "       <ident name=\"status\" value=\"OK\"/>" +
                "   </identifiers>" +
                "</WTResponse>"

        val factory = SimpleEasyXmlParser.getElementFinderFactory()
        val elementFinder = factory.stringFinder
        val streamer = SimpleStreamer(elementFinder,"favouriteColour")
        val favouriteColour = SimpleEasyXmlParser.parse(XML2, streamer)
    }
}
