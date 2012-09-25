package com.rackspace.itsm.pages

import org.apache.commons.lang.StringUtils as SU

class IncidentListPage extends BasePage {
    static url = 'navpage.do'
    static at = { withFrame('gsft_main') { SU.deleteWhitespace( listTitle?.text() ) == "Incidents" } }

    static content = {
        listTitle(wait:true) { $("div", id:"incident_list").find("table", id: "list_nav_incident").find("div", class:"list_title") }
                
        list { $("div", id: "incident_expanded") }
        
        listHeader { list.find("table", id: "list_nav_incident") }
        listTable { list.find("table", id: "incident_table") }
        listColumnSelector { column -> listTable.find("td:nth-child($column)") }
        listNumberColumn { listColumnSelector(2).find("a") }

        nav { module SideNavigationModule }
    }

    def numberColumn(){
        withFrame('gsft_main'){ listNumberColumn.click() } 
    }
}