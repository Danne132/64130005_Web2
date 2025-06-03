package project.an.bookmanagement.applitools;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class UITest {
	public static void main(String[] args) {
        // Thay đường dẫn đúng tới ChromeDriver nếu chưa cấu hình trong PATH
        System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Eyes eyes = new Eyes();

        // Dán API Key từ Applitools tại đây
        eyes.setApiKey("mtx39Z103LHiRDNy6X98pQt2ygEwVZgDcR1jo34ozrIA7A110");

        try {
            eyes.open(driver, "BookManagement Project", "Home UI Visual Test", new RectangleSize(1280, 720));

            driver.get("http://localhost:8080/");

            eyes.checkWindow("Home Page");
            
            driver.get("http://localhost:8080/admin/");

            eyes.checkWindow("Admin Page");

            // Đóng và gửi kết quả test lên Applitools
            eyes.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            eyes.abortIfNotClosed();
        }
    }
}
