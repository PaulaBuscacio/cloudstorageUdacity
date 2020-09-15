package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;
    //Files
    @FindBy(id="nav-files-tab")
    private WebElement navFiles;

    @FindBy(id="fileUpload")
    private WebElement fileUpload;

    //How can I select a file?

    @FindBy(id="upload-file")
    private WebElement uploadFile;

    @FindBy(id="viewFile")
    private WebElement viewFile;

    @FindBy(id="deleteFile")
    private WebElement deleteFile;


    //Notes
    @FindBy(id = "nav-notes-tab")
    private WebElement navNote;

    @FindBy(id = "add-note")
    private WebElement addNote;

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "save-note")
    private WebElement saveNote;

    @FindBy(id = "edit-note")
    private WebElement editNote;

    @FindBy(id = "delete-note")
    private WebElement deleteNote;

    //Credentials
    @FindBy(id="nav-credentials")
    private WebElement navCredentials;

    @FindBy(id = "add-credential")
    private WebElement addCredential;

    @FindBy(id = "credential-url")
    private WebElement credentialUrl;

    @FindBy(id = "credential-username")
    private WebElement credentialUsername;

    @FindBy(id = "credential-password")
    private WebElement credentialPassword;

    @FindBy(id = "save-credential")
    private WebElement credentialSubmit;

    @FindBy(id = "edit-cred")
    private WebElement editCredential;

    @FindBy(id = "delete-credential")
    private WebElement deleteCredential;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Notes
    public void sendNote(String title, String description) {
        this.navNote.click();
        this.addNote.click();
        this.noteTitle.sendKeys(title);
        this.noteDescription.sendKeys(description);
        this.saveNote.click();
    }

    public void updateNote(String newTitle, String newDescription) {
        this.navNote.click();
        this.editNote.click();
        this.noteTitle.sendKeys(newTitle);
        this.noteDescription.sendKeys(newDescription);
        this.saveNote.click();
    }

    public void deleteNote() {
        this.navNote.click();
        this.deleteNote.click();
    }

    //Files
    public void uploadFile(String filePath, WebDriver driver) {
        this.navFiles.click();
        this.fileUpload.click();
        driver.get(filePath);
        this.uploadFile.click();
    }

    public void viewFile() {
        this.navFiles.click();
        this.viewFile.click();
    }

    public void deleteFile() {
        this.navFiles.click();
        this.deleteFile.click();
    }

    //Credential

    public void sendCredential(String credentialUrl, String credentialUsername, String credentialPassword) {
        this.navCredentials.click();
        this.editCredential.click();
        this.credentialUrl.sendKeys(credentialUrl);
        this.credentialUsername.sendKeys(credentialUsername);
        this.credentialPassword.sendKeys(credentialPassword);
        this.credentialSubmit.click();
    }

    public void updateCredential(String newCredentialUrl, String newCredentialUsername, String newCredentialPassword) {
        this.navCredentials.click();
        this.addCredential.click();
        this.credentialUrl.sendKeys(newCredentialUrl);
        this.credentialUsername.sendKeys(newCredentialUsername);
        this.credentialPassword.sendKeys(newCredentialPassword);
        this.credentialSubmit.click();
    }

    public void setDeleteCredential() {
        this.navCredentials.click();
        this.deleteCredential.click();
    }









}
