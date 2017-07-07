import org.openqa.selenium.chrome.ChromeDriver

/**
 * Created by artyom on 07.07.17.
 */

driver = { new ChromeDriver() }

reportsDir = "build/geb-reports"
reportOnTestFailureOnly = true

baseNavigatorWaiting = true
atCheckWaiting = true