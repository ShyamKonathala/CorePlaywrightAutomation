package utils;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DatePickerUtils {
	
	private static final Logger logger = Logger.getLogger(DatePickerUtils.class.getName());
	
	 public static void selectDate(Page page, String calendarIconXpath, String calendarTitleXpath, String nextBtnXpath,String prevBtnXpath, String dayXpathTemplate, String desiredMonthYear, String day) {

	        // Step 1: Click the calendar icon to open the date picker
	        page.locator(calendarIconXpath).click();
	        logger.info("Date picker opened");

	        // Step 2: Loop until the correct month-year is found
	        while (true) {
	            Locator titleLocator = page.locator(calendarTitleXpath);
	            String currentMonthYear = titleLocator.textContent().trim();
	            logger.info("Current month-year: " + currentMonthYear);

	            if (currentMonthYear.equalsIgnoreCase(desiredMonthYear)) {
	                break;
	            } 
	            
	            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("MMMM yyyy");
	            java.time.YearMonth current = java.time.YearMonth.parse(currentMonthYear, formatter);
	            java.time.YearMonth desired = java.time.YearMonth.parse(desiredMonthYear, formatter);

	            if (desired.isAfter(current)) {
	                page.locator(nextBtnXpath).click();
	                logger.info("Next month clicked");
	            } else {
	                page.locator(prevBtnXpath).click();
	                logger.info("Previous month clicked");
	            }
	        }

	        // Step 3: Select the desired day
	        String dayXpath = dayXpathTemplate.replace("{day}", day);
	        page.locator(dayXpath).click();
	        logger.info("Day " + day + " selected");
	    }
	 
	 public static void currentselectDate(Page page, String calendarIconXpath, String calendarTitleXpath, String nextBtnXpath, String dayXpathTemplate, String desiredMonthYear, String day) {

	        // Step 1: Click the calendar icon to open the date picker
	        page.locator(calendarIconXpath).click();
	        logger.info("Date picker opened");

	        // Step 2: Loop until the correct month-year is found
	        while (true) {
	            Locator titleLocator = page.locator(calendarTitleXpath);
	            String currentMonthYear = titleLocator.textContent().trim();
	            logger.info("Current month-year: " + currentMonthYear);

	            if (currentMonthYear.equalsIgnoreCase(desiredMonthYear)) {
	                break;
	            } else {
	                page.locator(nextBtnXpath).click();
	                logger.info("Next month clicked");
	                break;
	            }
	        }

	        // Step 3: Select the desired day
	        String dayXpath = dayXpathTemplate.replace("{day}", day);
	        page.locator(dayXpath).click();
	        logger.info("Day " + day + " selected");
	    }
	 public static void previousselectDate(Page page, String calendarIconXpath, String calendarTitleXpath, String prevBtnXpath, String dayXpathTemplate, String desiredMonthYear, String day) {

	        // Step 1: Click the calendar icon to open the date picker
	        page.locator(calendarIconXpath).click();
	        logger.info("Date picker opened");

	        // Step 2: Loop until the correct month-year is found
	        while (true) {
	            Locator titleLocator = page.locator(calendarTitleXpath);
	            String currentMonthYear = titleLocator.textContent().trim();
	            logger.info("Current month-year: " + currentMonthYear);

	            if (currentMonthYear.equalsIgnoreCase(desiredMonthYear)) {
	                break;
	            } else {
	                page.locator(prevBtnXpath).click();
	                logger.info("Next month clicked");
	            }
	        }

	        // Step 3: Select the desired day
	        String dayXpath = dayXpathTemplate.replace("{day}", day);
	        page.locator(dayXpath).click();
	        logger.info("Day " + day + " selected");
	    }
}
