
// the syntax for Jasmine is
// describe("Description for a suite of tests", function{ contains your tests called specs
// it("What the test tests for", function(){
// expect(somevalue).toBe(expectedvalue)
//})
//    })

// Will ignore if the page is not an angular application
browser.ignoreSynchronization = true;

// describe the suite of tests
describe("Google Express suite", function(){

    it("Should go to GoogleExpress display the title", function(){
        browser.get("https://express.google.com/u/0/")
        expect(browser.getTitle()).toBe("Google Express - Shopping done fast")
    });

    it("Sould go to amiibo results", function(){
        element(by.name("q")).sendKeys("amiibo")
        magnifiyingglass = element(by.className("searchSubmitButton mat-button mat-icon-button ng-star-inserted"))
        magnifiyingglass.click()
        browser.sleep(2000)
        expect(browser.getTitle()).toBe("Google Express - amiibo")
    });

});

// The adavtage to using protractor is that it is designed specifically to 
// test Angular applications
// You have selectors for angular specific features like getting elements
// by their ngmodel



