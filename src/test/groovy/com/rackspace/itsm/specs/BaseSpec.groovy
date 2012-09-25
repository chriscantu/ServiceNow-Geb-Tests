package com.rackspace.itsm.specs

import geb.spock.GebReportingSpec
import com.rackspace.itsm.pages.*

abstract class BaseSpec extends GebReportingSpec {
    
    static loginName, password, userName
    
    static defaultUser = [ loginName: 'itil', password: 'itil', username: 'ITIL User' ]
    
    def getUserCredentials(profile) {
        loginName = config.readValue( "${profile}LoginName", defaultUser.loginName )
        password = config.readValue( "${profile}Password", defaultUser.password )
        userName = config.readValue( "${profile}Username", defaultUser.username )
    }
    
    def setupSpec() {
        getUserCredentials(profile)
    }
    
    def "Login"() {
        given: "User Navigates to LoginPage"
            to LoginPage
        when: "User logs in with valid cloud credentials"
            login( loginName, password )
        then: "User sees homepage"
            at HomePage
        and: "Username is validated"
            username.text() == userName
    }
}