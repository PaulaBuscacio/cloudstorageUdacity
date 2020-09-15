package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	String firstName = "Leticia";
	String lastName = "Ramos";
	String username = "Le";
	String password = "1234";

	String filePath = "/cloudstorage/files/test_upload";

	String title = "Test";
	String description = "This is a test";

	String newTitle = "Test2";
	String newDescription = "This is a update test";

	String credentialUrl = "www.google.com";
	String credentialUsername = "testCredential";
	String credentialPassword = "1234";

	String newCredentialUrl = "www.google.com";
	String newCredentialUsername = "testCredential2";
	String newCredentialPassword = "12345";



	@LocalServerPort
	private int port;
	private static WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static  void afterAll() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}


	@Test
	public void getSignupPage() {
		driver.get("http://localhost:" + this.port + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup(firstName, lastName, username, password);

		Assertions.assertEquals("Sign Up", driver.getTitle());
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void fileUploadTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		HomePage homePage = new HomePage(driver);
		homePage.uploadFile(filePath, driver);
	}

	@Test
	public void fileViewTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		HomePage homePage = new HomePage(driver);
		homePage.viewFile();
	}

	@Test
	public void fileDeleteTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		HomePage homePage = new HomePage(driver);
		homePage.deleteFile();
	}

	@Test
	public void sendNote() throws InterruptedException {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		HomePage homePage = new HomePage(driver);
		homePage.sendNote(title,description);

	}

	@Test
	public void updateNote() throws InterruptedException {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		HomePage notePageUpdate = new HomePage(driver);
		Thread.sleep(5000);
		notePageUpdate.updateNote(newTitle, newDescription);

	}
	@Test
	public void deleteNote() {
		driver.get("http://localhost:" + this.port + "/home");

		HomePage homePage = new HomePage(driver);
		homePage.deleteNote();

	}
	@Test
	public void sendCredentialTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Login", driver.getTitle());

		HomePage homePage = new HomePage(driver);

		homePage.sendCredential(credentialUrl, credentialUsername, credentialPassword);

		Assertions.assertEquals("Save changes", driver.getTitle());

	}
	@Test
	public void updateCredentialTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Login", driver.getTitle());

		HomePage homePage = new HomePage(driver);

		homePage.updateCredential(newCredentialUrl, newCredentialUsername, newCredentialPassword);

		Assertions.assertEquals("Save changes", driver.getTitle());

	}
	@Test
	public void deleteCredentialTest() {
		driver.get("http://localhost:" + this.port + "/home");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Login", driver.getTitle());

		HomePage homePage = new HomePage(driver);

		homePage.setDeleteCredential();

		Assertions.assertEquals("Delete", driver.getTitle());


	}




}
