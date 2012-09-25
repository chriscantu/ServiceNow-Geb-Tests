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
    
    // run as “grails -Dgeb.env=chrome test-app”
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

cloudUser = "joe.cloud"
cloudUserName = "Joe Cloud"
cloudPassword = "snow123"

supportLoginName = 'joe.cloud'
supportPassword = 'snow123'
supportUsername ='Joe Cloud'