package com.huongntg.KiemTra2;

import com.huongntg.common.BaseTest;
import com.huongntg.helpers.CaptureHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewProduct extends BaseTest {
    private String PRODUCT_NAME = "product kiem tra";
    @Test
    public void testCreateNewProduct() throws InterruptedException {
        CaptureHelper.startRecord("testCreateNewProduct");
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();
        Thread.sleep(2000);

        // add new product
        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(PRODUCT_NAME);
        // Category
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Sport shoes')]")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-1-2']")).click();
        // Brand
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@title='Select Brand']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Cosy");
        driver.findElement(By.xpath("//a[@id='bs-select-2-18']")).click();
        // Unit
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']")).sendKeys("Kg");
        // Weight
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("2.1");
        // Minimum Purchase Qty *
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='min_qty']")).clear();
        driver.findElement(By.xpath("//input[@name='min_qty']")).sendKeys("1");
        // Tags
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@role='textbox']")).sendKeys("product Giang Huong");

        // captureScreenshot

        CaptureHelper.captureScreenshot("captureScreenshot Giang Huong test");

        //Product Images >> Gallery Images (600x600)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[normalize-space()='Gallery Images (600x600)']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("img");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h6[@class='d-flex']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        // Product price + stock
        //Unit price *
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).sendKeys("2000000");
        //Discount
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Discount']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Discount']")).sendKeys("100000");
        //Quantity
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("12");
        //Save & Publish
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save & Publish']")).click();

       // check alert message
       Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Product has been inserted successfully']")).isDisplayed(),"the alert message success not display");

        //Search and re-check
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(PRODUCT_NAME);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(2 * 1000);
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).isDisplayed(), "The Category not display.");
        Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(), PRODUCT_NAME, "The Category Name not match.");
        CaptureHelper.stopRecord();

  }
}
