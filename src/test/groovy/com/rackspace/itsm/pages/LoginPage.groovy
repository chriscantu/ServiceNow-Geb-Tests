package com.rackspace.itsm.pages

import geb.Page

class LoginPage extends BasePage {
    static url = 'navpage.do'
    
    static at = { 
        withFrame('gsft_main') { loginText.text() == 'Login' }
    }
    
    static content = {
        loginForm { $('form', id: 'loginPage') }
        loginButton { $('button', id: 'sysverb_login') }
        
        loginText { $('div.caption') }
    }
    
    def login(username, password) {
        withFrame('gsft_main') {
            loginForm.user_name = username
            loginForm.user_password = password
            loginButton.click(HomePage)
        }
    }   
}
