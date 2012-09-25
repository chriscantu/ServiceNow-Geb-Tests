package com.rackspace.itsm.pages

import geb.Page

class HomePage extends BasePage {
    static url = 'navpage.do'
    static at = { waitFor { username?.text() } }

    static content = {
        
        username(wait:true) { $("a", id: "gsft_full_name") }
        
        logoutButton { $("span#gsft_logout > button.nav_header_button") }
        
        homePageGrid(wait:true) { $("table", id: "homepage_grid") }
        leftSideGrid { homePageGrid.find('td', id: 'dropzone1') }
        rightSideGrid { homePageGrid.find('td', id: 'dropzone2') }
        
        //Picks a record in a section ("My Groups Work") based on the place in which the link shows up in the list
        leftSectionNThLinkSelector { section, order -> leftSideGrid.find("div:nth-child($section)").find("tr:nth-child(2)").find('table', class:'list_table').find("tr:nth-child(${order + 1})") }
        
        //Picks the first record of a certain type (ex: Incident, Change Request)
        leftSectionLinkTypeSelector { section, type -> leftSideGrid.find("div:nth-child($section)").find("tr:nth-child(2)").find('table', class:'list_table').find('tr', record_class: type) }
        
        myGroupsWorkIncident { leftSectionLinkTypeSelector(2, 'incident').find('a') }
        myWorkIncident { leftSectionLinkTypeSelector(3, 'incident').find('a') }
        
        nav { module SideNavigationModule }
    }
    
    def clickGridLink() {
        withFrame("gsft_main") { myWorkIncident.click() }
    }
    
    def clickFirstIncidentInGrid(gridName) {
        withFrame("gsft_main") { this."${convertStringToCamelCase(gridName)}Incident".click() }
    }
    
}