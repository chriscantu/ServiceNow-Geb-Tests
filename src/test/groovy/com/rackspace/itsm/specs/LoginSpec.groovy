package com.rackspace.itsm.specs

import geb.spock.GebReportingSpec
import com.rackspace.itsm.pages.*
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {
    
    def getUser() {
        [
            loginName: config.readValue('supportLoginName', 'joe.cloud'), 
            password: config.readValue('supportPassword', 'snow123'),
            username: config.readValue('supportUserName', 'Joe Cloud')
        ]
    }
    
    def "Bad login credentials are rejected"() {
        given: "User navigates to LoginPage"
            to LoginPage
        when: "User enters invalid credentials"
            login('joe.admin', 'bad password')
        then: "Users sees loginPage"
            at LoginPage
    }
        
    def "Admin logs into SNOW"() {
        given: "User Navigates to LoginPage"
            to LoginPage
        when: "User logs in with valid cloud credentials"
            login( user.loginName, user.password )
        then: "User sees homepage"
            at HomePage
        and: "Username is validated"
            username.text() == user.username
    }   
}