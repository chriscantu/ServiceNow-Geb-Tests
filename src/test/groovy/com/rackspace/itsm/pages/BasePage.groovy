package com.rackspace.itsm.pages

import geb.Page
import org.apache.commons.lang.StringUtils as SU

abstract class BasePage extends Page {

    def clickNavLink(appName, linkText) {
        withFrame('gsft_nav') { nav.navLink(appName, linkText).click() }
    }
    
    
    /**
     * Converts the a string to a camel case variable name
     * IE:  "My Groups Work" becomes "myGroupsWork"
     */
    def convertStringToCamelCase(gridName) {
        def blackenedName = SU.deleteWhitespace( gridName )
        def firstLetter = lowerCaseFirstCharacter( blackenedName )
        
        blackenedName?.replaceFirst( blackenedName?.getAt(0), firstLetter )
    }
    
    /**
     * Converts first character of a word to lower case
     */
    def lowerCaseFirstCharacter( string ) {
        SU.lowerCase( string?.getAt(0) )
    }
    
}