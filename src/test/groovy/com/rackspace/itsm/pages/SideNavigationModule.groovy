package com.rackspace.itsm.pages

import geb.Module

class SideNavigationModule extends Module {
	static content = {
		navLink { appName, linkText -> $("td", id: appName).closest('table').parent().next('span').find("a", text: linkText) }
	}
	
	def clickLink(linkText) {
	   withFrame('gsft_nav') { navLink(linkText).click() }
	}
}