import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver

driver = { 
    def driver = new FirefoxDriver()
    driver
}

environments {
    
    headless {
        driver = new HtmlUnitDriver()
    }
    
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }
    
    // run as “grails -Dgeb.env=firefox test-app”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
}

reportOnTestFailureOnly = true
reportsDir = "build/feedback/"
baseUrl = "https://demo08.service-now.com/"
autoClearCookies = true

itilLoginName = 'itil'
itilPassword = 'itil'
itilUserName ='ITIL User'

adminLoginName = 'admin'
adminPassword = 'admin'
adminUserName ='System Administrator'

employeeLoginName = 'employee'
employeePassword = 'employee'
employeeUserName ='Joe Employee'